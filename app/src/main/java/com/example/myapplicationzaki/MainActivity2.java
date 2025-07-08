package com.example.myapplicationzaki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplicationzaki.model.Mahasiswa;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText txtNama, txtStb, txtUts, txtUas;
    protected final static String KEY_UAS = "NILAI UAS";
    protected final static String KEY_UTS = "NILAI UTS";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtStb = findViewById(R.id.txt_stb);
        txtNama = findViewById(R.id.txt_nama);
        txtUts = findViewById(R.id.txt_uts);
        txtUas = findViewById(R.id.txt_uas);

        getData();
        txtUts.requestFocus();
    }

    private void getData() {
        Intent intent = getIntent();
        Mahasiswa mhs = new Mahasiswa();

        mhs.setStb(intent.getStringExtra(MainActivity.KEY_STB));
        mhs.setNama((intent.getStringExtra(MainActivity.KEY_NAMA)));

        String message = "Stambuk :" + mhs.getStb() + "\n" + "Nama :" + mhs.getNama();

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        txtStb.setText(mhs.getStb());
        txtNama.setText(mhs.getNama());
    }

    public void finishClick(View view){
        Intent intent = new Intent();
        Float nilaiUts = null;
        try {
            nilaiUts = Float.parseFloat(txtUts.getText().toString());
        }catch (NumberFormatException e){
            nilaiUts = 0f;
        }

        Float nilaiUas = null;
        try {
            nilaiUas = Float.parseFloat(txtUas.getText().toString());
        }catch (NumberFormatException e){
            nilaiUas = 0f;
        }

        intent.putExtra(KEY_UTS, nilaiUts);
        intent.putExtra(KEY_UAS, nilaiUas);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void getDataClick(View view){
        finish();
    }
}