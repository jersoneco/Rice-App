package com.sven.riceapp.ui.home.disease_identifier;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sven.riceapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiseaseIdentifierActivity extends AppCompatActivity {


    private ImageView imageView;
    private ListView listView;
    private ImageClassifier imageClassifier;
    private TextView diseaseName;
    private TextView diseaseDetails;
    private RelativeLayout relativeLayout, layout, designLayout;
    private static final int CAMERA_REQEUST_CODE = 123456;
    private static final int[] designImages = {R.drawable.blast1, R.drawable.blight1 ,
            R.drawable.sheath_blight1, R.drawable.brownspot1, R.drawable.tungro1};
    private ImageSwitcher imageSwitcher;
    private int position1 = 0;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_identifier);
        setLayoutInvisible();
        initializeUIElements();
        layout.setBackgroundColor(getResources().getColor(R.color.transparent));

        imageSwitcher.setFactory(() -> {
            ImageView designImage = new ImageView(getApplicationContext());
            designImage.setScaleType(ImageView.ScaleType.FIT_XY);
            return designImage;
        });
        imageSwitcher.setImageResource(designImages[0]);
    }

    public void changeImage(View view){
        if(position1>4){
            position1 = 0;
        }
        imageSwitcher.setImageResource(designImages[position1]);
        position1++;
    }

    public void closeTips(View view){
        layout.setBackgroundResource(0);
        designLayout.setVisibility(View.GONE);
    }

    private void setLayoutInvisible(){
        relativeLayout = findViewById(R.id.hideSheet);
        if (relativeLayout.getVisibility() == View.VISIBLE) {
            relativeLayout.setVisibility(View.GONE);
        }
    }
    public void setLayoutVisible() {
        relativeLayout = findViewById(R.id.hideSheet);
        if (relativeLayout.getVisibility() == View.GONE) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void initializeUIElements() {
        imageView = findViewById(R.id.iv_capture);
        listView = findViewById(R.id.lv_probabilities);
        diseaseName = findViewById(R.id.diseaseName);
        diseaseDetails = findViewById(R.id.diseaseDetails);
        Button takePicture = findViewById(R.id.bt_take_picture);
        Button close = findViewById(R.id.close);
        Button learn = findViewById(R.id.learnmore);
        layout = findViewById(R.id.layout2);
        designLayout = findViewById(R.id.tips);
        TextView definition = findViewById(R.id.definition);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        definition.setText("         Make sure that the photo is clear and focused on the rice disease. Example above.");


        try {
            imageClassifier = new ImageClassifier(this);
        } catch (IOException e) {
            Log.e("Image Classifier Error", "ERROR: " + e);
        }

        // adding on click listener to button
        takePicture.setOnClickListener(v -> {
//            imageClassifier.clearImageClassifier();
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQEUST_CODE);
        });

        // click listview
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String text3 = " ";
            String text2 = (String) (listView.getItemAtPosition(position));
            String text = text2.substring(0, text2.indexOf(":"));
            String vv = text2.substring(0, text2.indexOf(" "));
            layout.setBackgroundColor(getResources().getColor(R.color.transparent));
            setLayoutVisible();
            diseaseName.setText(text.toUpperCase());

            try {
                InputStream is = getAssets().open(vv+".txt");
                int size = is.available();
                byte [] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text3 = new String(buffer);

            }catch (IOException ex){
                ex.printStackTrace();
            }
            diseaseDetails.setText(text3);
        });
        //Close disease definition
        close.setOnClickListener(v -> {
            setLayoutInvisible();
            layout.setBackgroundResource(0);
        });

        learn.setOnClickListener(v -> {
            Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.philrice.gov.ph/"));
            startActivity(browser);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if this is the result of our camera image request
        if (requestCode == CAMERA_REQEUST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Bitmap bitmap = (Bitmap) Objects.requireNonNull(data).getExtras().get("data");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                }
                loadClassifier(bitmap);
            }
        }
    }

    private void loadClassifier(final Bitmap bitmap){
        // getting bitmap of the image
        int green = 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
//            System.out.println(width+"x"+height);
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                int pixel = bitmap.getPixel(x, y);
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);

                if (g > r && g > b){
                    green+=1;
                }
            }
        }
        int totalg = width*height;
        if (green > totalg/4) {
            // pass this bitmap to classifier to make prediction
            List<ImageClassifier.Recognition> predictions = imageClassifier.recognizeImage(
                    bitmap, 0);

            // creating a list of string to display in list view
            final List<String> predictionsList = new ArrayList<>();
            float[] confidence = new float[5];
            int i = 0;

            for (ImageClassifier.Recognition recog : predictions) {
                float con = recog.getConfidence()*100;
                int toInt = (int) con;
                confidence[i] = recog.getConfidence();
                i+=1;
                predictionsList.add(recog.getName() + " disease: " + toInt +"% Accuracy");
            }

            for (float v : confidence) {
                if (v > 1.0 || v < 0.7) {
                    noDiseases(bitmap);
                }else {
                    hasDiseases(bitmap, predictionsList);
                }
                break;
            }
        }else{
            noDiseases(bitmap);
        }
    }

    public void noDiseases(final Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
        String [] predictionsList = {"No Disease Detected:"};
        ArrayAdapter<String> predictionsAdapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, predictionsList);
        listView.setAdapter(predictionsAdapter);
    }

    public void hasDiseases(final Bitmap bitmap, List<String> predictionsList){
        // displaying this bitmap in imageview
        imageView.setImageBitmap(bitmap);
        // creating an array adapter to display the classification result in list view
        ArrayAdapter<String> predictionsAdapter = new ArrayAdapter<>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, predictionsList);
        listView.setAdapter(predictionsAdapter);
    }

}