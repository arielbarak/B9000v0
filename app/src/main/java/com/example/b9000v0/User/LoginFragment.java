package com.example.b9000v0.User;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.example.b9000v0.R;

import java.net.URL;
import java.util.concurrent.Executor;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;

    private FirebaseAuth mAuth;

    private EditText etEmail, etPassword;
    private Button btLogin;
    private TextView tvRegister, tvForgotPassword;
    private Context context;
    private CheckBox show_hide_password;

    private FirebaseUser current_user;
    private DatabaseReference mDatabase;

    public LoginFragment(Context context) {
        this.context = context;
    }

//    public LoginFragment() {
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:

                // Call checkValidation method
                checkValidation();
                break;

            case R.id.tvRegister:

                // Replace login fragment
                new RegisterFragment(context);//TODO - Handle redirect
                break;
        }

    }

    private void checkValidation() {
        final String email = etEmail.getText().toString();
        final String password = etPassword.getText().toString();

        if (email.equals("") || email.length() == 0
                || password.equals("") || password.length() < 6){
            Toast.makeText(context, "please make sure to fill in email, and 6 characters password!", Toast.LENGTH_LONG).show();
        }

        else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("LOGIN", "signInWithEmail:success");
                                Toast.makeText(context, "User is connected",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();//TODO HANDLE REDIRECT
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("LOGIN", "signInWithEmail:failure", task.getException());
                                Toast.makeText(context, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show(); //TODO- HANDLE REDIRECT
                            }
                        }

                    });
        }
//            Toast.makeText(getActivity(), "Do Login.", Toast.LENGTH_SHORT)
//                    .show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(com.example.b9000v0.R.layout.fragment_login, container, false);
        initViews();
        setListeners();
        return view;
    }

    //setting listeners
    private void setListeners() {
        btLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);

        // Set check listener over checkbox for showing and hiding password
        show_hide_password
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton button,
                                                 boolean isChecked) {

                        // If it is checked then show password else hide
                        // password
                        if (isChecked) {

                            show_hide_password.setText(R.string.hide_pwd);// change
                            // checkbox
                            // text

                            etPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                            etPassword.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());// show password
                        } else {
                            show_hide_password.setText(R.string.show_pwd);// change
                            // checkbox
                            // text

                            etPassword.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            etPassword.setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());// hide password

                        }

                    }
                });
    }

    // Initialize all views
    private void initViews() {
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPassword = (EditText) view.findViewById(R.id.etPassword);
        btLogin = (Button) view.findViewById(R.id.btLogin);
        tvForgotPassword = (TextView) view.findViewById(R.id.tvForgotPassword);
        tvRegister = (TextView) view.findViewById(R.id.tvRegister);
        show_hide_password = (CheckBox) view
                .findViewById(R.id.cbShowHidePassword);
    }
}
