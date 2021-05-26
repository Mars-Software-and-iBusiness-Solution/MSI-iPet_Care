package com.mars.itech.msi_ipetcare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mars.itech.msi_ipetcare.Java_Class.User_Register_Details;

public class Register_User extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    EditText username;
    EditText email;
    EditText Nic;
    EditText phone;
    EditText Occupation;
    EditText VehicleNo;
    EditText password;
    EditText reppassword;
    TextView viewdate;
    Button selectdate;
    Button Register;

    TextView lognback;
    TextView shopreg;

    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;



    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;


    private static final String USERS = "users";
    private String TAG = "RegisterUser";
    ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__user);



        username = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        Nic = (EditText) findViewById(R.id.editText3);
        phone = (EditText) findViewById(R.id.editText7);
        Occupation = (EditText) findViewById(R.id.editText9);
        VehicleNo = (EditText) findViewById(R.id.editText10);
        password = (EditText) findViewById(R.id.editText4);
        reppassword =(EditText) findViewById(R.id.editText5);
        selectdate  =(Button) findViewById(R.id.button3);
        viewdate = (TextView) findViewById(R.id.editTextDate);
        Register =(Button)  findViewById(R.id.button2);
        progressBar1 = findViewById(R.id.progressBar);
        spinner = findViewById(R.id.editText8);




        mAuth = FirebaseAuth.getInstance();

        shopreg = (TextView) findViewById(R.id.testView4);


        selectdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(Register_User.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                viewdate.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();

            }

        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);




    }


    private boolean validateUsername()
    {
        String usernameInput = username.getEditableText().toString().trim();

        if (usernameInput.isEmpty())
        { username.setError("UserName(Vehicle) Can't Be Empty");
            return false; }

        else
        { username.setError(null);
            return true; }
    }
    private boolean validateEmail()
    {
        String emailInput = email.getEditableText().toString().trim();

        if(emailInput.isEmpty())
        {email.setError("Email Can't Be Empty");
            return false; }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {email.setError("Please Enter a valid Email Address");
            return false; }

        else
        {email.setError(null);
            return true; }

    }
    private boolean validateNic()
    {
        String NicInput = Nic.getEditableText().toString().trim();

        if (NicInput.isEmpty())
        {Nic.setError("Nic / PassPort Can't Be Empty");
            return false; }

        else
        {Nic.setError(null);
            return true; }

    }
    private boolean validatePhone()
    {
        String phoneInput = phone.getEditableText().toString().trim();
        if (phoneInput.isEmpty())
        { phone.setError("Field can't be Empty");
            return false; }
        else if (!Patterns.PHONE.matcher(phoneInput).matches())
        {phone.setError("Please Enter a valid Phone Number");
            return false; }

        else
        {phone.setError(null);
            return true; }
    }
    private boolean validateGender()
    {
        String Gender = spinner.getSelectedItem().toString().trim();

        if ("Select Gender".equals(Gender))
        {
            Toast.makeText(Register_User.this, "Please Select a Gender", Toast.LENGTH_LONG).show();

            return false; }

        else
        {
            return true; }

    }
    private boolean validateOccupation()
    {
        String VehicleMInput = Occupation.getEditableText().toString().trim();

        if (VehicleMInput.isEmpty())
        {Occupation.setError("Occupation Can't Be Empty");
            return false; }

        else
        {Occupation.setError(null);
            return true; }

    }
    private boolean validatePromo()
    {
        String VehicleRegInput = VehicleNo.getEditableText().toString().trim();

        if (VehicleRegInput.isEmpty())
        {VehicleNo.setError("Promo Code Can't Be Empty");
            return false; }

        else
        {VehicleNo.setError(null);
            return true; }

    }
    private boolean validatePassword()
    {
        String passwordInput = password.getEditableText().toString().trim();

        if (passwordInput.isEmpty())
        {password.setError("Password Can't Be Empty");
            return false; }

        else
        {password.setError(null);
            return true; }

    }
    private boolean validaterepPassword()
    {
        String reppasswordInput = reppassword.getText().toString();
        String passwordInput = password.getText().toString();

        if (reppasswordInput.isEmpty())
        {reppassword.setError("Field can't be Empty");
            return false; }

        else if (!reppasswordInput.equals (passwordInput))
        {reppassword.setError("Password Does not Match");
            return false; }

        else { reppassword.setError(null);
            return true; }
    }
    private boolean validatedate()
    {
        String VehicleInput = viewdate.getText().toString();

        if (VehicleInput.isEmpty())
        {viewdate.setError("Date Can't Be Empty");
            return false; }

        else
        {viewdate.setError(null);
            return true; }

    }



    public void register(View view)
    {
        progressBar1.setVisibility(View.VISIBLE);
        if (!validateEmail() | !validateUsername() | !validateNic() | !validaterepPassword() | !validatePassword() | !validatePhone() | !validateGender() | !validateOccupation() |!validatePromo() | validatedate() )
        { progressBar1.setVisibility(View.INVISIBLE);
            return;
        }
        else
        { progressBar1.setVisibility(view.VISIBLE);
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Registering...");progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);progressDialog.show();

            String Email = email.getText().toString().trim();
            String Password = password.getText().toString().trim();
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Log.d(TAG, "Create a User With Email:Success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    String Uid = user.getUid();
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference("User_Register_Details");

                    String Name = username.getText().toString();
                    String Email = email.getText().toString();
                    String NIC = Nic.getText().toString();
                    String Phone = phone.getText().toString();
                    String VehicleB = spinner.getSelectedItem().toString();
                    String VehicleM = Occupation.getText().toString();
                    String VehicleN = VehicleNo.getText().toString();
                    String Date = viewdate.getText().toString();

                    User_Register_Details Details = new User_Register_Details( Name, Email, NIC, Phone, VehicleB, VehicleM, VehicleN,Date);
                    databaseReference.child(Uid).setValue(Details).addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            progressDialog.dismiss();
                            Toast.makeText(Register_User.this, "User registered Successfully! Please Login", Toast.LENGTH_SHORT).show();
                            Intent longbackIntent = new Intent(Register_User.this,MainActivity.class );
                            startActivity(longbackIntent);
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    if (e instanceof FirebaseAuthUserCollisionException){
                        createAlert("Error", "This Email Address is Already Registered With Us!", "OK");
                    }else{
                        Toast.makeText(Register_User.this, "Failed to Register! Please try Again Later.", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });




        }



    }
    private void createAlert(String alertTitle, String alertMessage, String positiveText){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle)
                .setMessage(alertMessage)
                .setPositiveButton(positiveText, null)
                .create().show();
    }

    @Override
    public void onBackPressed() {
        // do your back button logic here
        // you can have conditions or whatever you want to do.
        // change to different fragment, go to different activity, etc.

        Intent registerIntent = new Intent(Register_User.this, MainActivity.class);
        startActivity(registerIntent);
        finish();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}