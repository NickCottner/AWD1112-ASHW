package org.insideranken.npcottner.androidtodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText registrationEmail, registrationPassword;
    Button btnRegistration;
    TextView registrationQuestion;
    Toolbar registrationToolbar;

    FirebaseAuth auth;
    ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registrationEmail = findViewById(R.id.registrationEmail);
        registrationPassword = findViewById(R.id.registrationPassword);
        btnRegistration = findViewById(R.id.btnRegistration);
        registrationQuestion = findViewById(R.id.registrationQuestion);

        registrationToolbar = findViewById(R.id.registrationToolbar);
        setSupportActionBar(registrationToolbar);
        getSupportActionBar().setTitle("Registration Page");

        auth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        registrationQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerEmail = registrationEmail.getText().toString().trim();
                String registerPassword = registrationPassword.getText().toString().trim();

                if(TextUtils.isEmpty(registerEmail))
                {
                    registrationEmail.setError("Email Required!");
                    registrationEmail.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(registerPassword))
                {
                    registrationPassword.setError("Password Required!");
                    registrationPassword.requestFocus();
                    return;
                }
                auth.createUserWithEmailAndPassword(registerEmail,registerPassword).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    Intent intent = new Intent(RegistrationActivity.this,
                                            LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    String error = task.getException().toString();
                                    Toast.makeText(RegistrationActivity.this,
                                            "Registration Failed\n" + error,
                                            Toast.LENGTH_LONG).show();
                                }
                                loader.dismiss();
                            }
                        });
            }
        });
    }
}