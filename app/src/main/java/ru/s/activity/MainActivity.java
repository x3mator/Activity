package ru.s.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static private final int CHOOSE_VIBOR = 0;
    public final static String VIBOR = "VIBOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText input_t1EditText = findViewById(R.id.input_text_1);
        EditText input_t2EditText = findViewById(R.id.input_text_2);

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        intent.putExtra("text_1", input_t1EditText.getText().toString());
        intent.putExtra("text_2", input_t2EditText.getText().toString());
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent viborIntent = new Intent(MainActivity.this, MainActivityVibor.class);
        startActivityForResult(viborIntent, CHOOSE_VIBOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView infoTextView = findViewById(R.id.textView_vibor);
        if (requestCode == CHOOSE_VIBOR) {
            if (resultCode == RESULT_OK) {
                String vibor_text = data.getStringExtra(VIBOR);
                infoTextView.setText(vibor_text);
            } else {
                infoTextView.setText("");
            }
        }
    }
}

