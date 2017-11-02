package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Review extends AppCompatActivity {

    private String shopID;
    private String name;
    private int rating;
    private String comments;

    public Review(){
        this.shopID = null;
        this.name = null;
        this.rating = 0;
        this.comments = null;
    }

    public void setShopID(String shopID){
        this.shopID = shopID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public String getShopID(){
        return shopID;
    }

    public String getName(){
        return name;
    }

    public int getRating(){
        return rating;
    }

    public String getComments(){
        return comments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    //public void readShop_ID(String ShopID){
      //  aComment.setShop_ID(ShopID);
    //}



    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.postbtn)
        {
            EditText a = (EditText)findViewById(R.id.nameTxt);
            setName(a.getText().toString());

            a = (EditText)findViewById(R.id.ratingsTxt);
            setRating(Integer.parseInt(a.getText().toString()));

            a = (EditText)findViewById(R.id.reviewTxt);
            setComments(a.getText().toString());

            boolean valid = true;

            String fileName = getShopID()+ ".txt";
            String txt;
            String dataTxt = null;
            PrintWriter output = null;

            txt = "Name: " + getName() +
                    "\r\nRating: " + getRating() +
                    "\r\nComment: " + getComments() + "\r\n\n";

            do
            {
                try
                {
                    FileReader file = new FileReader(fileName);
                    BufferedReader txtInput = new BufferedReader(file);
                    String line = "";

                    while((line = txtInput.readLine())!= null){
                        dataTxt = dataTxt+line+ "\r\n\n";
                    }
                }
                catch(FileNotFoundException e)
                {
                    Toast.makeText(this,"File not found, create file.", Toast.LENGTH_SHORT).show();
                }
                catch(IOException e)
                {
                    Toast.makeText(this,"Error reading from file", Toast.LENGTH_SHORT).show();
                }

                try
                {
                    output = new PrintWriter(new FileOutputStream(fileName));
                    output.println(dataTxt + "\r\n" + txt);

                    output.close();
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

            Comments comment = new Comments(getShopID());

            Intent i = new Intent(Review.this, comment.getClass());
            startActivity(i);
        }
    }
}
