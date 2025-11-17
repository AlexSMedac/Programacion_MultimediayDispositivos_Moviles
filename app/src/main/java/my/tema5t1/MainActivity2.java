package my.tema5t1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2); // usa tu layout de la pantalla 2

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnCancelar = findViewById(R.id.button4);

        btnCancelar.setOnClickListener(v -> finish());
    }
}
