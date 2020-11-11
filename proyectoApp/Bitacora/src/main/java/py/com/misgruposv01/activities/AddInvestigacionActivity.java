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
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;

public class AddInvestigacionActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoTiempoDedicado;
    EditText campoTema;
    EditText campoComentarios;
    EditText campoDudas;
    EditText campoLogrado;
    int idInvestigacion = 0;
    int tiempoDedicadoI;
    Investigacion unaInvestigacion= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD INVESTIGACION ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_investigacion);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idInvestigacion = extras.getInt("idInvestigacion", -1);
            Log.i(LogUtils.tag, "Id recibido de la investigación: " + idInvestigacion);
        }

//      unaBitacora = App.buscarBitacora(idInvestigacion);

        campoTiempoDedicado = (EditText) findViewById(R.id.crear_tiempodedi_inves);
        campoTema = (EditText) findViewById(R.id.crear_id_Materia);
        campoComentarios = (EditText) findViewById(R.id.crear_tiempodedi_inves);
        campoDudas = (EditText) findViewById(R.id.crear_dudas_inves);
        campoLogrado = (EditText) findViewById(R.id.crear_logrado_inves);

    }


    public void crearInvestigacion (View view) {
        Log.i(LogUtils.tag, "METODO CREAR INVESTIGACION ");

        String tiempoDedicado = campoTiempoDedicado.getText().toString();
        int tiempoDedicadoI = (int) (Double.parseDouble(tiempoDedicado));
        String tema = campoTema.getText().toString();
        String comentarios = campoComentarios.getText().toString();
        String dudas = campoDudas.getText().toString();

        String ti = campoId.getText().toString();
        int IdMateriaI = (int) (Double.parseDouble(IdMateria));
        // MateriasListView metodoBuscar = new MateriasListView();
        Materia materia = new Materia(IdMateriaI, nombreMateria);
        unaBitacora.agregarMateria(materia);
        Toast toast = Toast.makeText( this, "Materia agregada", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Materia creada: "+materia.getNombre());

        finish();
    }


    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddInvestigacionActivity.class);
        startActivity(i);
    }

}
