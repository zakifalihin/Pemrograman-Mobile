package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText txtNama, txtHasil;
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

        txtNama = findViewById(R.id.txt_nama);
        txtHasil = findViewById(R.id.txt_hasil);

        txtNama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                onChange();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onChange();
            }

            @Override
            public void afterTextChanged(Editable s) {
                onChange();
            }

            public void onChange(){
                txtNama.setText("");
                String nama, hasil;
                nama = txtNama.getText().toString();
                hasil = nama;
                txtHasil.setText(hasil);
            }
        });
    }

    public void btnOKCick(View view){
        String nama, hasil;
        nama = txtNama.getText().toString();
        hasil = nama;
        txtHasil.setText(hasil);
    }
}