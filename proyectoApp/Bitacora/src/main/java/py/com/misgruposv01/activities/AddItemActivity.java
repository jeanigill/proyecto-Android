package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;

public class AddItemActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoNombreMateria;
    EditText campoId;
    int idBitacora = 0;
    Bitacora unaBitacora= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD MATERIA ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
        }

         unaBitacora = App.buscarBitacora(idBitacora);

        campoNombreMateria = (EditText) findViewById(R.id.crear_nombre_Materia);
        campoId = (EditText) findViewById(R.id.crear_id_Materia);
        //  campoFecha = (EditText) findViewById(R.id.editTextDate);
    }


//    public void crearMateria (View view) {
//        Log.i(LogUtils.tag, "METODO CREAR MATERIA ");
//        String nombreMateria = campoNombreMateria.getText().toString();
//        String IdMateria = campoId.getText().toString();
//        int IdMateriaI = (int) (Double.parseDouble(IdMateria));
//        // MateriasListView metodoBuscar = new MateriasListView();
//        Materia materia = new Materia(IdMateriaI, nombreMateria);
//        unaBitacora.agregarMateria(materia);
//        Toast toast = Toast.makeText( this, "Materia agregada", Toast.LENGTH_SHORT);
//        toast.show();
//        Log.i(LogUtils.tag, "Materia creada: "+materia.getNombre());
//
//        finish();
//    }


    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddItemActivity.class);
        startActivity(i);
    }

}
