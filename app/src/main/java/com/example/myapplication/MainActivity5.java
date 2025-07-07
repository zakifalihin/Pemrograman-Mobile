package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    private RadioGroup rgAritmatika;
    private EditText txtAn1, txtAn2;
    private TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtAn1 = findViewById(R.id.txt_an1);
        txtAn2 = findViewById(R.id.txt_an2);
        txtFinal = findViewById(R.id.txt_final);
        rgAritmatika = findViewById(R.id.rg_aritmatika);

        rgAritmatika.setOnCheckedChangeListener((group, checkedId) -> hitung());
        txtAn1.addTextChangedListener(textWatcher);
        txtAn2.addTextChangedListener(textWatcher);
    }

    private void hitung() {
        String input1 = txtAn1.getText().toString();
        String input2 = txtAn2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            txtFinal.setText("Isi angka dulu");
            return;
        }

        try {
            double angka1 = Double.parseDouble(input1);
            double angka2 = Double.parseDouble(input2);
            double hasil;

            int selectedId = rgAritmatika.getCheckedRadioButtonId();

            if (selectedId == R.id.rb_tambah) {
                hasil = angka1 + angka2;
            } else if (selectedId == R.id.rb_kurang) {
                hasil = angka1 - angka2;
            } else if (selectedId == R.id.rb_kali) {
                hasil = angka1 * angka2;
            } else if (selectedId == R.id.rb_bagi) {
                if (angka2 == 0) {
                    txtFinal.setText("Tidak bisa bagi 0");
                    return;
                }
                hasil = angka1 / angka2;
            } else {
                txtFinal.setText("Pilih operasi");
                return;
            }

            txtFinal.setText(String.valueOf(hasil));

        } catch (NumberFormatException e) {
            txtFinal.setText("Input tidak valid");
        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            hitung();
        }

        @Override public void afterTextChanged(Editable s) { }
    };
}
