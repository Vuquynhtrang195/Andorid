package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TextView login;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // layout của màn hình đăng ký

        login = findViewById(R.id.login); // ID của TextView/quay về login
        email  = findViewById(R.id.email);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString().trim();

                if (emailInput.isEmpty()) {
                    email.setError("Email không được để trống");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Email không hợp lệ");
                } else {
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    // Tiếp tục xử lý đăng ký...
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về LoginActivity
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Đóng RegisterActivity để tránh quay lại bằng nút Back
            }
        });
    }

}