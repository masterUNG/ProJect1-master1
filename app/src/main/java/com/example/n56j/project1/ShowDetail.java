package com.example.n56j.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowDetail extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String nameRoomString, imageString,typeString,
            pathImageString, latString, lngString, numberString;
    private ImageView imageView;
    private TextView  nameRoomTextView , typeTextView  , numberTextView,
            pathImageTextView, latTextView, lngTextView;
    private Button edtiButton, deleteButton, backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        bindWidget();

        nameRoomString = getIntent().getStringExtra("NameRoom");

        try {

            SynRoom synRoom = new SynRoom(ShowDetail.this);
            synRoom.execute();
            String strJSON = synRoom.get();

            JSONArray jsonArray = new JSONArray(strJSON);

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (nameRoomString.equals(jsonObject.getString("room_name"))) {
                    //nameRoom OK
                    imageString = jsonObject.getString("PathImage");
                    typeString = jsonObject.getString("Type");
                    nameRoomString = jsonObject.getString("room_name");
                    numberString = jsonObject.getString("classroom");
                    latString = jsonObject.getString("room_lat");
                    lngString = jsonObject.getString("room_long");

                }   // if

            }   //for

            Picasso.with(ShowDetail.this).load(imageString).into(imageView);
            typeTextView.setText(typeString);
            nameRoomTextView.setText(nameRoomString);
            numberTextView.setText(numberString);
            latTextView.setText(latString);
            lngTextView.setText(lngString);


        } catch (Exception e) {
            e.printStackTrace();
        }


        edtiButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

    }   // Main Method

    private void bindWidget() {

        imageView = (ImageView) findViewById(R.id.imageView7);
        typeTextView = (TextView) findViewById(R.id.textView4);
        nameRoomTextView = (TextView) findViewById(R.id.textView5);
        numberTextView = (TextView) findViewById(R.id.textView6);
        latTextView = (TextView) findViewById(R.id.textView10);
        lngTextView = (TextView) findViewById(R.id.textView11);
        edtiButton = (Button) findViewById(R.id.button4);
        deleteButton = (Button) findViewById(R.id.button18);
        backButton = (Button) findViewById(R.id.button19);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button4:
                break;
            case R.id.button18:
                break;
            case R.id.button19:
                finish();
                break;
        }

    }
}   // Main Class