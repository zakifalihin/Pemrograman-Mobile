package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    private RadioGroup rgProdi;
    private TextView txtHasil3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgProdi = findViewById(R.id.rg_prodi);
        txtHasil3 = findViewById(R.id.txt_hasil3);
    }

    public void tampil(){
        String hasil = "Hasil : \n";
        int rbID = rgProdi.getCheckedRadioButtonId();
        if(rbID == R.id.rb_ti)
            hasil += "Teknik Informatika";
        else if (rbID == R.id.rb_si)
            hasil += "Sistem Informasi";

        txtHasil3.setText(hasil);
    }

    public void okClick(View view){
        tampil();
    }
}