package com.example.formatnumberexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppCompatEditText etUserId = findViewById(R.id.etUserId);
        etUserId.addTextChangedListener(new UserIdTextWatcher(etUserId));
        findViewById(R.id.btnGetUserId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = etUserId.getText().toString();
                Toast.makeText(MainActivity.this, userId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
