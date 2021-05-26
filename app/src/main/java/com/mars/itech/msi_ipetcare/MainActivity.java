package com.mars.itech.msi_ipetcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.mars.itech.msi_ipetcare.Home_Directory.Home_iFit;

public class MainActivity extends AppCompatActivity {


    private static final int TIME_DELAY = 1000;
    private static long back_pressed;

    private EditText email;
    private   EditText password;
    private Button Login;
    private TextView register;
    private   TextView Forgotpass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        Login = (Button) findViewById(R.id.button1);
        register = (TextView) findViewById(R.id.editText3);
        Forgotpass = (TextView) findViewById(R.id.editText4);
        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this,Register_User.class );
                startActivity(registerIntent);
                finish();
            }
        });

        Forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this, Home_iFit.class );
                startActivity(registerIntent);
            }
        });







    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("     EXIT FROM APP");
            alertDialogBuilder.setIcon(R.drawable.back_image);
            alertDialogBuilder.setMessage("Are you sure !, Do you really wants to exit from the Alpha Fitness X ?");
            alertDialogBuilder.setPositiveButton("yes",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",new
                    DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    private boolean validateEmail() {
        String emailInput = email.getEditableText().toString().trim();

        if(emailInput.isEmpty())
        {
            email.setError("Email Can't Be Empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            email.setError("Please Enter a valid Email Address");
            return false;
        }

        else
        {
            email.setError(null);
            return true;
        }

    }

    private boolean validatePassword() {
        String passwordInput = password.getEditableText().toString().trim();
        if (passwordInput.isEmpty()) {
            password.setError("Password can't be empty");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    private void createAlert(String alertTitle, String alertMessage, String positiveText)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle)
                .setMessage(alertMessage)
                .setPositiveButton(positiveText, null)
                .create().show();
    }


    public void confirmInput(View view)
    {
        if(!validateEmail() | !validatePassword())
        {
            Toast.makeText(MainActivity.this, "Login Failed Make Sure Fields are not Empty .",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            String emailx = email.getText().toString().trim();
            String passwordx = password.getText().toString().trim();
            if (emailx.isEmpty()){
                createAlert("Error", "Please enter your Email!", "OK");
            }else if(passwordx.isEmpty()){
                createAlert("Error", "Please enter your Password!", "OK");
            }else{
                mAuth.signInWithEmailAndPassword(emailx, passwordx).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.dismiss();

                        Intent loginIntent = new Intent(MainActivity.this,User_Home.class );
                        startActivity(loginIntent);
                        finish();

                        Toast.makeText(MainActivity.this, "Login Success.",
                                Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        if (e instanceof FirebaseAuthInvalidUserException){
                            createAlert("Error", "This Email is not registered with us!", "OK");
                        }else if(e instanceof FirebaseAuthInvalidCredentialsException){
                            createAlert("Error", "Invalid Password! Please try again.", "OK");
                        }else{
                            Toast.makeText(MainActivity.this, "Unable to login! Please try after some time.", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                });
            }


        }

    }




}