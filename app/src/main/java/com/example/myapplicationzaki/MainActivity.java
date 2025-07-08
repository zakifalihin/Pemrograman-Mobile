package com.example.myapplicationzaki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplicationzaki.model.Mahasiswa;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtNama, txtStb;
    private TextView txtNa, txtNh;
    public final static String KEY_STB = "STAMBUK";
    public final static String KEY_NAMA = "NAMA";

    public final static int REQ_CODE_INPUT_NILAI = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtStb = findViewById(R.id.txt_stb);
        txtNama = findViewById(R.id.txt_nama);
        txtNa = findViewById(R.id.txt_na);
        txtNh = findViewById(R.id.txt_nh);

    }

    /** @noinspection deprecation*/
    public void prosesClick(View view){
        String url = "https://umi.ac.id";
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(KEY_STB, txtStb.getText().toString());
        intent.putExtra(KEY_NAMA, txtNama.getText().toString());

        startActivityForResult(intent, REQ_CODE_INPUT_NILAI);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null && requestCode == REQ_CODE_INPUT_NILAI){
            Float nilaiUts = data.getFloatExtra(MainActivity2.KEY_UTS, 0f);
            Float nilaiUas = data.getFloatExtra(MainActivity2.KEY_UAS, 0f);
            Float nilaiAkhir = (nilaiUas+nilaiUts)/2;
            txtNa.setText("nilai Akhir \t\t:" + String.valueOf(nilaiAkhir));

            if (nilaiAkhir > 85)txtNh.setText("Nilai Akhir \t: A");
            else if (nilaiAkhir > 85) txtNh.setText("Nilai Huruf \t: A-");
            else if (nilaiAkhir > 75) txtNh.setText("Nilai Huruf \t: B+");
            else if (nilaiAkhir > 70) txtNh.setText("Nilai Huruf \t: B");
            else if (nilaiAkhir > 65) txtNh.setText("Nilai Huruf \t: B-");
            else if (nilaiAkhir > 60) txtNh.setText("Nilai Huruf \t: C+");
            else if (nilaiAkhir > 55) txtNh.setText("Nilai Huruf \t: C");
            else if (nilaiAkhir > 40) txtNh.setText("Nilai Huruf \t: D");
            else if (nilaiAkhir > 35) txtNh.setText("Nilai Huruf \t: E-");
        }
    }
}