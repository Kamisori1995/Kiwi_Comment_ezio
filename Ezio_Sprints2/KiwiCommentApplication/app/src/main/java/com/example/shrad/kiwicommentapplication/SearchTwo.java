package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchTwo extends AppCompatActivity {

    private TextView nametv;
    private TextView addresstv;
    private TextView phonetv;
    private TextView netlinktv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_two);

        Button btnMapActivity=(Button) findViewById(R.id.getDirectionbtn);
        btnMapActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMapAcitivity();
            }
        });

        Button btnReviewActivity=(Button) findViewById(R.id.writeReview);
        btnReviewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReviewAcitivity();
            }
        });

    }

    public void openMapAcitivity(){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void openReviewAcitivity(){
        Intent intent = new Intent(this,Review.class);
        startActivity(intent);
    }
}
