package com.emilygelb.fbuinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private EditText newUsernameInput;
    private EditText newPasswordInput;
    private EditText emailInput;
    private EditText fullNameInput;
    private Button newSignUp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        newUsernameInput = findViewById(R.id.newUsername_et);
        newPasswordInput = findViewById(R.id.newPassword_et);
        emailInput = findViewById(R.id.email_et);
        fullNameInput = findViewById(R.id.fullName_et);

        newSignUp_btn = findViewById(R.id.newSignUp_btn);
        newSignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = newUsernameInput.getText().toString();
                final String password = newPasswordInput.getText().toString();
                final String email = emailInput.getText().toString();
                final String fullName = fullNameInput.getText().toString();

                signUp(username, password, email, fullName);
            }
        });
    }

    private void signUp(String username, String password, String email, String fullName) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.put("Name", fullName);

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("SignupActivity", "Signup successful!");
                    final Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.e("SignupActivity", "Signup failure");
                    e.printStackTrace();
                }
            }
        });
    }


}
