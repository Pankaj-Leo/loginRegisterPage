package com.example.loginregister_50073457;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds
    private Handler splashHandler = new Handler(); // Handler for managing the splash delay
    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            // After the delay, switch to the main content view
            setContentView(R.layout.activity_main);
            // Initialize your main activity components here

            btnLogin = findViewById(R.id.btnLogin);
            btnRegister = findViewById(R.id.btnRegister);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            });

            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initially set the splash screen layout
        setContentView(R.layout.activity_splash_screen);
        // Post the runnable to switch to the main content view after the delay
        splashHandler.postDelayed(splashRunnable, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the runnable to prevent it from executing if the activity is destroyed
        splashHandler.removeCallbacks(splashRunnable);
    }



}


