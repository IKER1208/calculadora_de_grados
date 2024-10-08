package com.example.calculadoradegrados;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculadoradegrados.conversiones.Celsius;
import com.example.calculadoradegrados.conversiones.Fahrenheit;
import com.example.calculadoradegrados.conversiones.Kelvin;
import com.example.calculadoradegrados.conversiones.Grados;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCantidad;
    private Spinner spinnerUnidad;
    private Button buttonCalcular;
    private TextView textViewResultado;

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

        // inicialización
        editTextCantidad = findViewById(R.id.editTextCantidad);
        spinnerUnidad = findViewById(R.id.spinnerUnidad);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularConversion();
            }
        });
    }

    private void calcularConversion() {
        // Obtener la cantidad q se ingresó
        String cantidadString = editTextCantidad.getText().toString();
        if (cantidadString.isEmpty()) {
            textViewResultado.setText("Por favor, ingresa una cantidad.");
            return;
        }
        double cantidad = Double.parseDouble(cantidadString);

        String unidadSeleccionada = spinnerUnidad.getSelectedItem().toString().toLowerCase();

        Grados grados;
        Grados convertido1;
        Grados convertido2;
        switch (unidadSeleccionada) {

            case "celsius":
                grados = new Celsius(cantidad);
                convertido1 = grados.parse("fahrenheit");
                convertido2 = grados.parse("kelvin");
                break;

            case "fahrenheit":
                grados = new Fahrenheit(cantidad);
                convertido1 = grados.parse("celsius");
                convertido2 = grados.parse("kelvin");
                break;

            case "kelvin":
                grados = new Kelvin(cantidad);
                convertido1 = grados.parse("celsius");
                convertido2 = grados.parse("fahrenheit");
                break;

            default:
                textViewResultado.setText("Unidad no reconocida.");
                return;
        }

        //  resu
        textViewResultado.setText(String.format("%.2f %s = %.2f %s\n%.2f %s = %.2f %s",
                cantidad, unidadSeleccionada, convertido1.getCantidad(), convertido1.getClass().getSimpleName(),
                cantidad, unidadSeleccionada, convertido2.getCantidad(), convertido2.getClass().getSimpleName()));
    }
}
