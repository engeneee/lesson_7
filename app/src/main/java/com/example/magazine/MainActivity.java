package com.example.magazine;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView android_phone, ios_phone;
    RadioButton radio_karta, radio_nalichka, radio_qr;
    CheckBox check_podarok, check_dostavka;
    Button btnReady;

    String tolemTuri, jetkizuText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android_phone = findViewById(R.id.android);
        ios_phone = findViewById(R.id.ios);

        radio_karta = findViewById(R.id.radio_karta);
        radio_nalichka = findViewById(R.id.radio_nalichka);
        radio_qr = findViewById(R.id.radio_qr);

        check_podarok = findViewById(R.id.check_podarok);
        check_dostavka = findViewById(R.id.check_dostavka);

        btnReady = findViewById(R.id.btnJiberu);


        registerForContextMenu(android_phone);
        registerForContextMenu(ios_phone);

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_karta.isChecked()) {
                    tolemTuri = "Банк карточкасы арқылы";
                } else if (radio_nalichka.isChecked()) {
                    tolemTuri = "Қолма қол арқылы";
                } else {
                    tolemTuri = "QR код арқылы";
                }

                if (check_podarok.isChecked()) {
                    jetkizuText = "Сыйлық қорабшасына орау";
                }

                if (check_dostavka.isChecked()) {
                    jetkizuText = "Доставкамен жеткізу";
                }

                String res = "Android: " + android_phone.getText() + "\n" +
                        "IOS: " + ios_phone.getText() + "\n" +
                        "Төлем түрі: " + tolemTuri + "\n" +
                        "Жеткізу түрі: " + jetkizuText;

                Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if (v == android_phone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if (v == ios_phone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sam_phone:
                android_phone.setText("Samsung");
                break;

            case R.id.mi_phone:
                android_phone.setText("Mi9");
                break;

            case R.id.xiaomi_phone:
                android_phone.setText("Xiaomi");
                break;

            case R.id.huawei_phone:
                android_phone.setText("Huawei");
                break;


            case R.id.iPhone11:
                ios_phone.setText("Iphone 11");
                break;

            case R.id.iPhone11Pro:
                ios_phone.setText("Iphone 11 Pro");
                break;

            case R.id.iPhone6sPlus:
                ios_phone.setText("Iphone 6s Plus");
                break;

            case R.id.iPhone13ProMax:
                ios_phone.setText("Iphone 13 Pro Max");
                break;

            case R.id.iPhoneX:
                ios_phone.setText("Iphone X");
                break;
        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_set:
                Toast.makeText(this, "Setting menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}