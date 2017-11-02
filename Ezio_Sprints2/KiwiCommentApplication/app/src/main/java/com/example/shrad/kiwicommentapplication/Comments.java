package com.example.shrad.kiwicommentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comments extends AppCompatActivity {

    private String shopID;
    private String reviewTxt;

    TextView review;

    public Comments(String shopID){
        setShopID(shopID);
        this.reviewTxt = null;
    }

    public void setShopID(String shopID){
        this.shopID = shopID;
    }

    public void setReviewTxt(String reviewTxt){
        this.reviewTxt = reviewTxt;
    }

    public String getShopID(){
        return this.shopID;
    }

    public String getReviewTxt(){
        return this.reviewTxt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }

    public View setContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View rootView = inflater.inflate(R.layout.activity_comments, container, false);

        String fileName = getShopID()+ ".txt";
        String txt = "";

        boolean valid = true;

        do
        {
            try{
                FileReader data = new FileReader(fileName);
                BufferedReader txtInput = new BufferedReader(data);
                String line;

                while((line = txtInput.readLine()) != null){
                    txt = txt + line;
                }

                data.close();
            }
            catch(FileNotFoundException e)
            {
                Toast.makeText(this,"File not found, create file.", Toast.LENGTH_SHORT).show();
            }
            catch(IOException e)
            {
                Toast.makeText(this,"Error reading from file", Toast.LENGTH_SHORT).show();
            }
        }while(!valid);

        setReviewTxt(txt);
        review.getRootView().findViewById(R.id.CommentsText);
        review.setText(getReviewTxt());

        return rootView;
    }


}
