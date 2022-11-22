package com.sven.riceapp.ui.home.disease_identifier;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorSpace;


import com.google.firebase.database.collection.LLRBNode;

import org.jetbrains.annotations.NotNull;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ColorSpaceType;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.ImageProperties;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp;
import org.tensorflow.lite.support.image.ops.Rot90Op;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ImageClassifier {


    private static final float PROBABILITY_MEAN = 0.0f;
    private static final float PROBABILITY_STD = 255.0f;
    private static final float IMAGE_STD = 1.0f;
    private static final float IMAGE_MEAN = 0.0f;
    private static final int MAX_SIZE = 1;
    private final int imageResize_X;
    private final int imageResize_Y;
    private final List<String> labels;
    private final Interpreter tensorClassifier;
    private TensorImage inputImageBuffer, test;
    private final TensorBuffer probabilityImageBuffer;
    private final TensorProcessor probabilityProcessor;


    public ImageClassifier(Activity activity) throws IOException {
        /*
         * The loaded TensorFlow Lite model.
         */
        MappedByteBuffer classifierModel = FileUtil.loadMappedFile(activity,
                "model.tflite");
        // Loads labels out from the label file.
        labels = FileUtil.loadLabels(activity, "labels.txt");

        tensorClassifier = new Interpreter(classifierModel, null);

        // Reads type and shape of input and output tensors, respectively. [START]
        int imageTensorIndex = 0; // input
        int probabilityTensorIndex = 0;// output

        int[] inputImageShape = tensorClassifier.getInputTensor(imageTensorIndex).shape();
        DataType inputDataType = tensorClassifier.getInputTensor(imageTensorIndex).dataType();
        System.out.print(inputImageShape[1]+" "+inputImageShape[2]);

        int[] outputImageShape = tensorClassifier.getOutputTensor(probabilityTensorIndex).shape();
        DataType outputDataType = tensorClassifier.getOutputTensor(probabilityTensorIndex).dataType();

        imageResize_X = inputImageShape[1];
        imageResize_Y = inputImageShape[2];
        // Reads type and shape of input and output tensors, respectively. [END]

        // Creates the input tensor.
        inputImageBuffer = new TensorImage(inputDataType);

        // Creates the output tensor and its processor.
        probabilityImageBuffer = TensorBuffer.createFixedSize(outputImageShape, outputDataType);

        // Creates the post processor for the output probability.
        probabilityProcessor = new TensorProcessor.Builder().add(new NormalizeOp(PROBABILITY_MEAN, PROBABILITY_STD))
                .build();
    }

    @SuppressWarnings("unchecked")
    public List<Recognition> recognizeImage(final Bitmap bitmap, final int sensorOrientation) {

        List<Recognition> recognitions = new ArrayList<>();

        //pre-processing image
        inputImageBuffer = loadImage(bitmap, sensorOrientation);
        //load to interpreter
        tensorClassifier.run(inputImageBuffer.getBuffer(), probabilityImageBuffer.getBuffer().rewind());
        // Gets the map of label and probability.
        Map<String, Float> labelledProbability = new TensorLabel(labels,
                probabilityProcessor.process(probabilityImageBuffer)).getMapWithFloatValue();

        for (Map.Entry<String, Float> entry : labelledProbability.entrySet()) {
            recognitions.add(new Recognition(entry.getKey(), entry.getValue()));
        }
        // Find the best classifications by sorting predicitons based on confidence
        Collections.sort(recognitions);
        // returning predicitons
        return recognitions.subList(0, MAX_SIZE);
    }

    private TensorImage loadImage(Bitmap bitmap, int sensorOrientation) {
        // Loads bitmap into a TensorImage.
        inputImageBuffer.load(bitmap);

        int noOfRotations = sensorOrientation / 90;
//        int cropSize = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int cropSize = 256;
        // Creates processor for the TensorImage.
        // pre processing steps are applied here
        ImageProcessor imageProcessor = new ImageProcessor.Builder()
                //Center crop the image to 256 width and 256 height
                .add(new ResizeWithCropOrPadOp(cropSize, cropSize))
                //resize using nearest neighbour
                .add(new ResizeOp(imageResize_X, imageResize_Y, ResizeOp.ResizeMethod.NEAREST_NEIGHBOR))
                // rotation counter-clockwise / 90
                .add(new Rot90Op(noOfRotations))
                .add(new NormalizeOp(IMAGE_MEAN, IMAGE_STD)).build(); //standard normal distribution -  mean=0.0 and std.deviation=1.0, formula(x-mean/std)
        return imageProcessor.process(inputImageBuffer);
    }

    public static class Recognition implements Comparable {

        private String name;
        private float confidence;

        public Recognition() {
        }

        public Recognition(String name, float confidence) {
            this.name = name;
            this.confidence = confidence;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getConfidence() {
            return confidence;
        }

        public void setConfidence(float confidence) {
            this.confidence = confidence;
        }

        @NotNull
        @Override
        public String toString() {
            return "Recognition{" +
                    "name='" + name + '\'' + ", confidence=" + confidence + '}';
        }

        @Override
        public int compareTo(Object o) {
            return Float.compare(((Recognition) o).confidence, this.confidence);
        }
    }

}
