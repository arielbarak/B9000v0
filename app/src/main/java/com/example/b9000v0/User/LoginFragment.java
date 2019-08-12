package com.example.b9000v0.User;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View v;
    private Button btnLogin;
//    TextView btnLostPw,btnRegister;
    private EditText etEmail,etPassword;


    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View view) {

    }
}
