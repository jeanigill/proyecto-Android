package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;

public class AddMateriaActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoNombreMateria;
    // EditText campoFecha;
    // EditText campoCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);

        campoNombreMateria = (EditText) findViewById(R.id.crear_nombre_Materia);
        // campoCodigo = (EditText) findViewById(R.id.crear_id_Materia);
        //   campoFecha = (EditText) findViewById(R.id.editTextDate);
    }

    public void crearMateria(View view) {
     String nombreMateria = campoNombreMateria.getText().toString();
     //String fechaMateria = campoFecha.getText().toString();
    // int codigoMateria = campoCodigo.getText().toString();

     Materia materia = new Materia(nombreMateria);
     Bitacora.agregarMateria(materia);

     Intent intentLanzarCrearMateria = new Intent( this, Bitacora.class );
     startActivity( intentLanzarCrearMateria );
    }
}
