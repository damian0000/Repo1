package com.example.damian.systemy_mobilne_haslo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.security.NoSuchAlgorithmException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if ((text1.length()<5 && text2.length()<5) ) {
                    Toast.makeText(CreatePasswordActivity.this, "Nie podano haseł. Hasła muszą zawierać conajmniej 6 znaków", Toast.LENGTH_SHORT).show();
                } else {
                    if (text1.equals(text2)) {
                        String passwordHash1=CryptoService.md5(text1);
                        String passwordHash2=CryptoService.md5(text2);
//                        Log.d("","zahashhowane haslo1 "+passwordHash1);
//                        Log.d("","zahashhowane haslo2 "+CryptoService.md5(passwordHash2));
                        SharedPreferences settings = getSharedPreferences("PREPS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", passwordHash1);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), CreateMessaeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(CreatePasswordActivity.this, "Złe hasła", Toast.LENGTH_SHORT).show();
                    }
                }
            }}
            );

    }

}
