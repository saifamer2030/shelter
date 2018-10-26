package com.life.shelter.people.homeless;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.app.AppCompatActivity;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import custom_font.MyTextView;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import custom_font.MyEditText;
import custom_font.MyTextView;

import static android.view.View.VISIBLE;

public class Register extends AppCompatActivity {

    private TextView shelter;
    private MyTextView singIn, signUp;
    private MyEditText editTextEmail, editTextPassword, editTextCPassword, CodeText,NumperPhone;
    private ProgressBar progressBar;
    private Spinner spinnerCountry, spinnerType;
    DatabaseReference databaseReg;
    FirebaseAuth mAuth;
    LinearLayout linearLayoutCode,linearLayoutNumperPhone;
    long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        shelter = (TextView) findViewById(R.id.title_reister);
        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");
        shelter.setTypeface(custom_fonts);

        mAuth = FirebaseAuth.getInstance();
        databaseReg = FirebaseDatabase.getInstance().getReference("reg_data");
        linearLayoutNumperPhone = (LinearLayout)findViewById(R.id.phone);
        NumperPhone = (MyEditText)findViewById(R.id.MyEditTixtphon);
        linearLayoutCode = (LinearLayout) findViewById(R.id.cod);
        CodeText = (MyEditText) findViewById(R.id.postCode);
        editTextEmail = findViewById(R.id.edit_email);
        editTextPassword = findViewById(R.id.edit_password);
        editTextCPassword = findViewById(R.id.edit_c_password);
        signUp = findViewById(R.id.getstarted);
        singIn = (MyTextView) findViewById(R.id.login);

        spinnerCountry = findViewById(R.id.spinner_country);
        spinnerType = findViewById(R.id.spinner_type);

        progressBar = findViewById(R.id.progressbar);

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Register.this, Login.class);
                finish();
                startActivity(it);

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

// spinner for countries
        ArrayAdapter<CharSequence> adapterc = ArrayAdapter.createFromResource(
                Register.this, R.array.countries_array, android.R.layout.simple_spinner_item);
        adapterc.setDropDownViewResource(R.layout.array_list_item);
        spinnerCountry.setAdapter(adapterc);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorText));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // spinner for type
        ArrayAdapter<CharSequence> adaptert = ArrayAdapter.createFromResource(
                Register.this, R.array.type_array, android.R.layout.simple_spinner_item);
        adaptert.setDropDownViewResource(R.layout.array_list_item);
        spinnerType.setAdapter(adaptert);


        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorText));
                if (position == 1) {
                    linearLayoutCode.setVisibility(VISIBLE);
                    linearLayoutNumperPhone.setVisibility(VISIBLE);
                } else {
                    linearLayoutCode.setVisibility(View.GONE);
                    linearLayoutNumperPhone.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void registerUser() {
        final String mEmail = editTextEmail.getText().toString().trim();
        String mPassword = editTextPassword.getText().toString().trim();
        String mCPassword = editTextCPassword.getText().toString().trim();
        final String WEBSITE = CodeText.getText().toString().trim();
        final String NumberPhone = NumperPhone.getText().toString().trim();
        final String mCountry = spinnerCountry.getSelectedItem().toString().trim();
        final String mtype = spinnerType.getSelectedItem().toString().trim();


        if (spinnerType.getSelectedItem().equals("Organization")) {
            if (WEBSITE.isEmpty()) {
                CodeText.setError("Web site is required");
                CodeText.requestFocus();
                return;
            }
            if (!Patterns.WEB_URL.matcher(WEBSITE).matches()) {
                CodeText.setError("Please enter valid Web site");
                CodeText.requestFocus();
                return;
            }
            if (NumberPhone.isEmpty()) {
                NumperPhone.setError("Number phone is required");
                NumperPhone.requestFocus();
                return;
            }
            if (!Patterns.PHONE.matcher(NumberPhone).matches()) {
                NumperPhone.setError("Please enter valid Phone Number");
                NumperPhone.requestFocus();
                return;
            }
        
        }
        if (mEmail.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (mPassword.length() < 6) {
            editTextPassword.setError("Minimum length of password should be 6");
            editTextPassword.requestFocus();
            return;
        }

        if (mPassword.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (mCPassword.isEmpty()) {
            editTextCPassword.setError("you should confirm your password");
            editTextCPassword.requestFocus();
            return;
        }

        if (!mCPassword.equals(mPassword)) {
            editTextCPassword.setError("it must be the same as password");
            editTextCPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(VISIBLE);
        if (isNetworkConnected()) {
            mAuth.createUserWithEmailAndPassword(mEmail, mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(Register.this, "USER CREATED", Toast.LENGTH_SHORT).show();
                        RegisterClass regdata = new RegisterClass(mEmail, mCountry, mtype,WEBSITE, NumberPhone);
                        databaseReg.child(mAuth.getCurrentUser().getUid()).setValue(regdata);

                        Intent intend = new Intent(Register.this, home.class);
                        intend.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(intend);

                    } else {
                        //Log.e(TAG, task.getException().getMessage());
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(Register.this, "you are already registered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register.this, "REGISTER ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        } else {
            Toast.makeText(this, "please check the network connection", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }
    }

    //  check if network is connected
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void onBackPressed() {


        if (time + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();
        } else {
            Toast.makeText(Register.this, "Press Again To Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();

    }
}
