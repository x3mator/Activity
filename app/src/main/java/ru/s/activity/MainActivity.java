package ru.s.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnMenuItemClickListener {

    static private final int CHOOSE_VIBOR = 0;
    public final static String VIBOR = "VIBOR";
    public static String popstr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_popup)
                //Следим за нажатиями по кнопке:
                .setOnClickListener(new OnClickListener() {

                    //Обрабатываем нажатие кнопки Button:
                    @Override
                    public void onClick(View view) {
                        //Вызываем popup меню, заполняем его с файла popup.xml и настраиваем
                        //слушатель нажатий по пунктам OnMenuItemClickListener:
                        PopupMenu popup_menu = new PopupMenu(MainActivity.this, view);
                        popup_menu.setOnMenuItemClickListener(MainActivity.this);
                        popup_menu.inflate(R.menu.popup);
                        popup_menu.show();                    }
                });
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



    public boolean onMenuItemClick(MenuItem item) {
        TextView infoTextView = findViewById(R.id.textView_popup);

        switch (item.getItemId()) {
            case R.id.item1:
                popstr = getString(R.string.popup1);
                break;
            case R.id.item2:
                popstr = getString(R.string.popup2);
                break;
            case R.id.item3:
                popstr = getString(R.string.popup3);
                break;
        }
        Toast.makeText(this, popstr, Toast.LENGTH_SHORT).show();
        infoTextView.setText(popstr);
        return true;
    }


}

