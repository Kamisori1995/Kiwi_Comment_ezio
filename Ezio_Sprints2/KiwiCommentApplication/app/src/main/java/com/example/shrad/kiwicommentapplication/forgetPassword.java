package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class forgetPassword extends AppCompatActivity {

    DatabaseHelper helper = WelcomePage.myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void onButtonClick(View v)
    {
        EditText a = (EditText)findViewById(R.id.address);
        String str = a.getText().toString();

        EditText b = (EditText)findViewById(R.id.edit_new_password);
        String newPassword = b.getText().toString();

        EditText c = (EditText)findViewById(R.id.new_password_again);
        String passwordAgain = c.getText().toString();

        EditText d = (EditText)findViewById(R.id.editVerifyCode);
        String editVerify = d.getText().toString();

        if(v.getId() == R.id.verify_code){

            boolean verify = helper.verifyCode(str);

            if(!verify)
                Toast.makeText(forgetPassword.this,"Account doesn't exist!", Toast.LENGTH_SHORT).show();
        }

        if(v.getId() == R.id.Done){

            boolean found = false;

            if(newPassword != passwordAgain)
                Toast.makeText(forgetPassword.this, "password not match, please check!", Toast.LENGTH_SHORT).show();
            else{

                String VerifyCode = helper.compareVerifyCode(str);

                if(editVerify.equals(VerifyCode))
                {
                    found = helper.changePassword(str,passwordAgain);
                }
                else
                {
                    Toast.makeText(forgetPassword.this,"Account doesn't exist!", Toast.LENGTH_SHORT).show();
                }
                if(!found)
                    Toast.makeText(forgetPassword.this,"Error!!!",Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(forgetPassword.this, LogIn.class);
                    startActivity(i);
                }
            }
        }
    }

}
