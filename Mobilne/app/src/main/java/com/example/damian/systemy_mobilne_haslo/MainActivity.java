package com.example.damian.systemy_mobilne_haslo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView  textView, textShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textViewActMain);
        //Bundle bundle=getIntent().getExtras();
        String text=getIntent().getStringExtra("message");
        textView.setText(CryptoService.decryptIt(text));


    }

}
