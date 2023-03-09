package com.example.conexiondbremoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private EditText usuario;
    private EditText contraseña;
    private EditText DNI;
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;
    private EditText calle;
    private EditText provincia;
    private EditText ciudad;
    private EditText codigoPostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = findViewById(R.id.etUsuarioRegistro);
        contraseña = findViewById(R.id.etContraseñaRegistro);
        DNI = findViewById(R.id.etDNIRegistro);
        nombre = findViewById(R.id.etNombreRegistro);
        apellido1 = findViewById(R.id.etApellido1Registro);
        apellido2 = findViewById(R.id.etApellido2Registro);
        calle = findViewById(R.id.etCalleRegistro);
        provincia = findViewById(R.id.etProvinciaRegistro);
        ciudad = findViewById(R.id.etCiudadRegistro);
        codigoPostal = findViewById(R.id.etCodigoPostalRegistro);

    }

}