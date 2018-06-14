package com.example.damian.systemy_mobilne_haslo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMessaeActivity extends AppCompatActivity {

    EditText editTextMessage;
    Button buttonMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_messae);

        editTextMessage=(EditText)findViewById(R.id.editTextMessage);
        buttonMessage=(Button)findViewById(R.id.buttonMessage);

        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=CryptoService.encryptIt(editTextMessage.getText().toString());
                //String value=CryptoService.md5(editTextMessage.getText().toString());
                if(!value.equals(""))
                {
                    Intent intent=new Intent(getApplicationContext(), EnterPasswordActivity.class);
                    intent.putExtra("message",value);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(CreateMessaeActivity.this, "Nie możesz zapisac pustej wiadomości", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
