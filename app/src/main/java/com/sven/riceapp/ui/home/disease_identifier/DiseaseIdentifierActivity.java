package com.sven.riceapp.ui.home.disease_identifier;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

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
    private Button takePicture, close, learn;
    private TextView diseaseName;
    private TextView diseaseDetails;
    private RelativeLayout relativeLayout, layout, designLayout;
    private static final int CAMERA_REQEUST_CODE = 123456;
    private static final int[] designImages = {R.drawable.blast1, R.drawable.blight1 ,
            R.drawable.sheath_blight1, R.drawable.brownspot1, R.drawable.tungro1};
    private ImageSwitcher imageSwitcher;
    private int position = 0;

    @SuppressLint("SetTextI18n")
    @Override
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
        if(position>4){
            position = 0;
        }
        imageSwitcher.setImageResource(designImages[position]);
        position++;
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
        takePicture = findViewById(R.id.bt_take_picture);
        close = findViewById(R.id.close);
        learn = findViewById(R.id.learnmore);
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
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQEUST_CODE);
        });
        // click listview
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
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
            }
        });
        //Close disease definition
        close.setOnClickListener(v -> {
            setLayoutInvisible();
            layout.setBackgroundResource(0);
        });

        learn.setOnClickListener(v -> {
            Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browser);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // if this is the result of our camera image request
        if (requestCode == CAMERA_REQEUST_CODE && resultCode == Activity.RESULT_OK) {
            // getting bitmap of the image
            Bitmap photo = (Bitmap) Objects.requireNonNull(data).getExtras().get("data");
//            int green = 0;
//            int width = photo.getWidth();
//            int height = photo.getHeight();
//            for (int x=0; x<width; x++){
//                for (int y=0; y<height; y++){
//                    int pixel = photo.getPixel(x, y);
//                    int r = Color.red(pixel);
//                    int g = Color.green(pixel);
//                    int b = Color.blue(pixel);
//
//                    if (g > r && g > b){
//                        green+=1;
//                    }
//                }
//            }
//            int totalg = width*height;
//            if (green > totalg/2) {
                // displaying this bitmap in imageview
            imageView.setImageBitmap(photo);

                // pass this bitmap to classifier to make prediction
            List<ImageClassifier.Recognition> predictions = imageClassifier.recognizeImage(
                        photo, 0);

                // creating a list of string to display in list view
            final List<String> predictionsList = new ArrayList<>();
            for (ImageClassifier.Recognition recog : predictions) {
                predictionsList.add(recog.getName() + " disease: " + recog.getConfidence() +"%");
            }

                // creating an array adapter to display the classification result in list view
            ArrayAdapter<String> predictionsAdapter = new ArrayAdapter<>(
                    this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, predictionsList);
            listView.setAdapter(predictionsAdapter);
//            }else{
//            imageView.setImageBitmap(photo);
//            String [] predictionsList = {"No Disease Detected:"};
//            ArrayAdapter<String> predictionsAdapter = new ArrayAdapter<>(
//                    this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, predictionsList);
//            listView.setAdapter(predictionsAdapter);
//            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}