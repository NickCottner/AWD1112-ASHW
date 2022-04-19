package org.insideranken.npcottner.androidtodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText loginEmail, loginPassword;
    Button btnLogin;
    TextView tvPageQuestion;
    Toolbar loginToolbar;

    FirebaseAuth auth;
    ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvPageQuestion = findViewById(R.id.loginPageQuestion);

        loginToolbar = findViewById(R.id.loginToolbar);
        setSupportActionBar(loginToolbar);
        getSupportActionBar().setTitle("Login Page");

        auth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        tvPageQuestion.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailLogin = loginEmail.getText().toString().trim();
                String passwordLogin = loginPassword.getText().toString().trim();

                if(TextUtils.isEmpty(emailLogin))
                {
                    loginEmail.setError("Email Required!");
                    loginEmail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(passwordLogin))
                {
                    loginPassword.setError("Password Required!");
                    loginPassword.requestFocus();
                    return;
                }
                loader.setMessage("Login In Progress");
                loader.setCanceledOnTouchOutside(false);
                loader.show();

                auth.signInWithEmailAndPassword(emailLogin, passwordLogin).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Intent intent = new Intent(LoginActivity.this,
                                            SuccessActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    String error = task.getException().toString();
                                    Toast.makeText(LoginActivity.this,
                                            "Login Failed\n" + error,
                                            Toast.LENGTH_LONG).show();
                                }
                                loader.dismiss();
                            }
                        });
            }
        });
    }
}