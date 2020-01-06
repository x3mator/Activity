package ru.s.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityVibor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vibor);
    }

    public void onRadioClick(View view) {
        Intent answerIntent = new Intent();

        switch (view.getId()) {
            case R.id.rBtnVibor1:
                answerIntent.putExtra(MainActivity.VIBOR, getString(R.string.vibor1));
                break;
            case R.id.rBtnVibor2:
                answerIntent.putExtra(MainActivity.VIBOR, getString(R.string.vibor2));
                break;
            case R.id.rBtnVibor3:
                answerIntent.putExtra(MainActivity.VIBOR, getString(R.string.vibor3));
                break;
            default:
                break;
        }
        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
