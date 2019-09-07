package app.techsol.firebasedemoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText EmailET, PasswordET;
    Button mSignupBtn;
    FirebaseAuth auth;
    @Override
    protected void onStart() {
        super.onStart();
         auth=FirebaseAuth.getInstance();
        Toast.makeText(this, ""+auth.getUid(), Toast.LENGTH_SHORT).show();
        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(getBaseContext(), DashboardActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        EmailET=findViewById(R.id.EmailET);
        PasswordET=findViewById(R.id.PasswordET);
        mSignupBtn=findViewById(R.id.mSignupBtn);
        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signInWithEmailAndPassword(EmailET.getText().toString(), PasswordET.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String Uid=auth.getCurrentUser().getUid();
                            Toast.makeText(MainActivity.this, Uid, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getBaseContext(), DashboardActivity.class));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
