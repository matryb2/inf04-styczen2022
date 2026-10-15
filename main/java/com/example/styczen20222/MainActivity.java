package com.example.styczen20222;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText haslo;
    EditText powtorzHaslo;
    Button przycisk;
    TextView poleTekstowe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextText);
        haslo = findViewById(R.id.editTextText2);
        powtorzHaslo = findViewById(R.id.editTextText3);
        przycisk = findViewById(R.id.button);
        poleTekstowe = findViewById(R.id.textView5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        poleTekstowe.setText("Autor: xxxxxx");


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tekstEmail = email.getText().toString().trim();
                String tekstHaslo = haslo.getText().toString();
                String tekstPowtorzHaslo = powtorzHaslo.getText().toString();

                if (!tekstEmail.contains("@")) {
                    poleTekstowe.setText("Nieprawidłowy adres e-mail");
                }
                else if (tekstHaslo.isEmpty() || !tekstHaslo.equals(tekstPowtorzHaslo)) {
                    poleTekstowe.setText("Hasła różnią się");
                }
                else {
                    poleTekstowe.setText("Witaj " + tekstEmail);
                }
            }
        });
    }
}