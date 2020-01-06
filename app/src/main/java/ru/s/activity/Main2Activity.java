package ru.s.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Object button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String text_1 = "Животное";
        String text_2 = "дырку от бублика";

        text_1 = getIntent().getExtras().getString("text_1");
        text_2 = getIntent().getExtras().getString("text_2");

        TextView infoTextView = findViewById(R.id.text_result);
        infoTextView.setText(text_1 + " , вам передали " + text_2);
    }

    public void onClickBack(View view) {
        onBackPressed(); /* или finish() */
    }
}
