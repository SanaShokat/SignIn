package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EMAIL_KEY="email_key";
    private String FILE_NAME="my_pref";

    public EditText UserEmail;
   public EditText UserPassward;
    public Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserEmail=findViewById(R.id.editText);
        UserPassward=findViewById(R.id.edPassward);

        SharedPreferences preferences=getSharedPreferences(LoggedIn.FILE_NAME,MODE_PRIVATE);
        String Email= preferences.getString(LoggedIn.EMAIL_KEY,"default");
        UserEmail.setText(Email);



        signin=(Button) findViewById(R.id.button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
            }
        });



    }//super ends
    private void Validate(){
         UserEmail=(EditText)findViewById(R.id.editText);
        String email=UserEmail.getText().toString();

         UserPassward=(EditText)findViewById(R.id.edPassward);
        String passward=UserPassward.getText().toString();

         //String email=EditText.getText().toString();
       if( (email.isEmpty()) ||  (passward.isEmpty())){
           Toast.makeText(this,"Invalid user",Toast.LENGTH_SHORT).show();

       }
else{
           Intent intent=new Intent(MainActivity.this,LoggedIn.class);
           intent.putExtra(EMAIL_KEY,email);
           startActivity(intent);
           finish();
       }

    }//validatte end


}//class end
