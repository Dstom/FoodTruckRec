package com.example.practica1.foodtruckrec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txt_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_pedido = (TextView)findViewById(R.id.txt_pedido);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                manipularTexto(intent);
            }
        }
    }

    public void manipularTexto(Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT) + "\n" + intent.getStringExtra("gaseosa");
        if(sharedText != null){
            txt_pedido.setText(txt_pedido.getText().toString() + "\n" + sharedText);

        }
    }
}
