package com.example.b9000v0.User;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.b9000v0.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.b9000v0.R;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Toast;
import io.opencensus.internal.Utils;


public class RegisterFragment extends Fragment implements View.OnClickListener {

    private View view;

    private FirebaseAuth mAuth;
    private EditText etEmail, etFullName, etUsername, etPassword, etBio;
    private Button btRegister;
    private TextView tvLogin;
    private URL url_profile_pic; //TODO - FIX PIC UPLOADING!
    private Context context;
    private FirebaseUser current_user;

    public RegisterFragment(Context context) {
        this.context = context;
    }

//    @Override
//    public void onClick(View view) {
//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        Toast.makeText(context, "Got user", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        initViews();
        setListeners();
        return view;
    }

    //setting listeners
    private void setListeners() {
        btRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    // Initialize all views
    private void initViews() {
        etFullName = (EditText) view.findViewById(R.id.etFullName);
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        etBio = (EditText) view.findViewById(R.id.etBio);
        btRegister = (Button) view.findViewById(R.id.btRegister);
    }

    //        login = (TextView) view.findViewById(R.id.already_user);
//        terms_conditions = (CheckBox) view.findViewById(R.id.terms_conditions);

        // Setting text selector over textviews
//        XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
//        try {
//            ColorStateList csl = ColorStateList.createFromXml(getResources(),
//                    xrp);
//
//            login.setTextColor(csl);
//            terms_conditions.setTextColor(csl);
//        } catch (Exception e) {
//        }
//    }

    // Check Validation Method


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btRegister:

                // Call checkValidation method
                checkValidation();
                break;

            case R.id.tvLogin:

                // Replace login fragment
                new LoginFragment();//TODO - FIX
                break;
        }
    }


    private void checkValidation() {
        //Get all edittext texts
        String fullName = etFullName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String bio = etBio.getText().toString();
        String username = etUsername.getText().toString();

        // Check if all strings are null or not
        if (fullName.equals("") || fullName.length() == 0
                || email.equals("") || email.length() == 0
                || password.equals("") || password.length() < 6
                || bio.equals("") || bio.length() == 0
                || username.equals("") || username.length() == 0

            Toast.makeText(context,"All fields are required.", Toast.LENGTH_SHORT).show();


        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] encoded_password_bytes = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));

        final String password_hash = new String(encoded_password_bytes);;

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email,password_hash).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(context, "Succesfully Registerd to B9000", Toast.LENGTH_LONG).show();
                    mAuth.signInWithEmailAndPassword(email, password_hash);
                    current_user = mAuth.getCurrentUser();
                    if(current_user != null){

                    }
                }
            }
        })


    }
}