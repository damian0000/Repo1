package com.example.damian.systemy_mobilne_haslo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.damian.systemy_mobilne_haslo.CryptoService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EnterPasswordActivity extends AppCompatActivity {
    EditText editText;
    Button button_;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings=getSharedPreferences("PREPS",0);
        password=settings.getString("password","");

        editText=(EditText)findViewById(R.id.editText);
        button_=(Button)findViewById(R.id.button2);

        button_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=CryptoService.md5(editText.getText().toString());

                if(text.equals(password))
                {
                    Intent newIntent=new Intent(getApplicationContext(), MainActivity.class);
                    Bundle bundle=getIntent().getExtras();
                    if(bundle!=null)
                        newIntent.putExtras(bundle);
                    startActivity(newIntent);
                    finish();
                }
                else
                {
                    Toast.makeText(EnterPasswordActivity.this, "Złe hasło", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
