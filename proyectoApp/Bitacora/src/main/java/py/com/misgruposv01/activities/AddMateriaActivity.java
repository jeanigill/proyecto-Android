package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;

public class AddMateriaActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoNombreMateria;
    EditText campoFecha;
    EditText campoCodigo;
    int idBitacora = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
        }

        campoNombreMateria = (EditText) findViewById(R.id.crear_nombre_Materia);
        campoCodigo = (EditText) findViewById(R.id.crear_id_Materia);
        campoFecha = (EditText) findViewById(R.id.editTextDate);
    }


    public void crearMateria (View view) {
        String nombreMateria = campoNombreMateria.getText().toString();
        String codigoMateria = campoCodigo.getText().toString();
        int codMateriaI = (int) (Double.parseDouble(codigoMateria));
        // MateriasListView metodoBuscar = new MateriasListView();
        Materia materia = new Materia(codMateriaI, nombreMateria);
        Bitacora unaBitacora = App.buscarBitacora(idBitacora);
        unaBitacora.agregarMateria(materia);
        Log.i(LogUtils.tag, "Metodo Crear Materia: "+materia.getNombre());
        Intent intentLanzarMaterias = new Intent( this, MateriasListView.class );
        startActivity( intentLanzarMaterias );
    }


    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddMateriaActivity.class);
        startActivity(i);
    }

}
