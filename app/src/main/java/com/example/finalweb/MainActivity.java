package com.example.finalweb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,generator;
    EditText start,end,series,account;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.intenter);
        generator = findViewById(R.id.button2);
        start = findViewById(R.id.starting);
        end = findViewById(R.id.ending);
        series = findViewById(R.id.Series);
        account = findViewById(R.id.accountno);
        img = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Good luck Bro");
                intent.putExtra(AlarmClock.EXTRA_HOUR, 0);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, 1);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }
    public void generators(View view) {
        Toast.makeText(MainActivity.this,"Generating",Toast.LENGTH_SHORT).show();
        int s,e,a;
        s = Integer.parseInt(start.getText().toString());
        e = Integer.parseInt(end.getText().toString());
        a = Integer.parseInt(account.getText().toString());
        String st = "";
        for(int i= s;i < e+1;i++){
            if(i<10){
                st = st + "0" +i + "000000" + a + "\n";
            }else {
                st = st + i + "000000" + a + "\n";
            }
        }
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Series",st.toString());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(MainActivity.this,"done",Toast.LENGTH_SHORT).show();
    }
}