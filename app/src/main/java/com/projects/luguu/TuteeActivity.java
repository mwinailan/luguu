package com.projects.luguu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.projects.luguu.modules.Account;
import com.projects.luguu.modules.Activity;
import com.projects.luguu.modules.MainApp;

import java.util.Date;

public class TuteeActivity extends AppCompatActivity {

    private MainApp mainApp = MainApp.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set application to full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tutee);

        FirebaseApp.initializeApp(this);
        //Testing
//        Account testAccount = new Account("testFromJava", 9808, "testemail@gmail.com");
//        testAccount.addMenteeingActivity(
//                new Activity(testAccount,testAccount, "MATH 200", "UBC", new Date(), testAccount.getUUID())
//        );
//        mainApp.addAccount(testAccount);
//        mainApp.getAccount(testAccount.getId());

        ImageButton mentorButton =  findViewById(R.id.mentorButton);
        mentorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mentorMove = new Intent(TuteeActivity.this, TutorActivity.class);
                startActivity(mentorMove);
            }
        });

        // Checks if user is logged in to firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        ImageButton accountButton = findViewById(R.id.accountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user!=null) {
                    Intent accountMove = new Intent(TuteeActivity.this, AccountActivity.class);
                    startActivity(accountMove);
                }
                else {
                    Intent signupMove = new Intent(TuteeActivity.this, SignUpActivity.class);
                    startActivity(signupMove);
                }
            }
        });

        ImageButton addButton =  findViewById(R.id.addMentorButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addMentor = new Intent(TuteeActivity.this, AddMentorActivity.class);
                startActivity(addMentor);
            }
        });
    }


}
