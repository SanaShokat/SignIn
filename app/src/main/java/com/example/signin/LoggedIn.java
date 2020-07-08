package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import static com.example.signin.MainActivity.EMAIL_KEY;

public class LoggedIn extends AppCompatActivity {

    public static final String FILE_NAME="my_prefrences";
    public static final String EMAIL_KEY="email_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        //Toolbar toolbar=(Toolbar)findViewById(R.id.);
        TextView outputText=findViewById(R.id.textView2);

       String Email=getIntent().getStringExtra(MainActivity.EMAIL_KEY);
        Toast.makeText(this,"Successfully Logged In ",Toast.LENGTH_SHORT).show();
        outputText.setText("welcome " +Email);

        SharedPreferences.Editor editor=getSharedPreferences(FILE_NAME,MODE_PRIVATE).edit();
        editor.putString(EMAIL_KEY,Email);
        editor.apply();Toast.makeText(this,"Mail written in File Successfully  ",Toast.LENGTH_SHORT).show();

    }//s end
}//c end