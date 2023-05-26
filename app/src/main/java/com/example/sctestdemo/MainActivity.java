package com.example.sctestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

   private EditText intoAccount;
    private EditText intoTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView accountText = (TextView)findViewById(R.id.accountText);
         intoAccount = (EditText)findViewById(R.id.intoAccount);
        final TextView timeText = (TextView)findViewById(R.id.timeText);
         intoTime = (EditText)findViewById(R.id.intoTime);
        Button submit = (Button)findViewById(R.id.submit);

        intoAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s!=null){
                accountText.setText(Utils.num2thousand00(s.toString()));}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        intoTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if (count!=0){
                   Integer decode = Integer.decode(s.toString());
                   int min=decode/60;
                   int sen=decode%60;

                   timeText.setText(min+"m"+sen+"s");
               }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Double account = Double.parseDouble(intoAccount.getText().toString().trim());

                Integer time = Integer.decode(intoTime.getText().toString().trim());

                 Double data= account*time;

                Intent intent =new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("data",data.toString());
                startActivity(intent);

            }
        });
    }


}
