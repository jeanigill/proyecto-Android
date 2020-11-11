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
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddEjercicioActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campotiempoDedicado;
    int tiempoDedicadoI;
    EditText campoexperiencia;
    EditText campodudas;
    EditText campologrado;
    int idTema = 0;
    Tema unTema= null;
    Ejercicio unEjercicio = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD MATERIA ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ejercicio);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido del tema: " + idTema);
        }

    //    unTema = App.buscarTema(idTema);

        campotiempoDedicado = (EditText) findViewById(R.id.crear_tiempodedi_ejerci);
        campoexperiencia = (EditText) findViewById(R.id.crear_experiencias_ejer);
        campodudas = (EditText) findViewById(R.id.crear_dudas_ejer);
        campologrado = (EditText) findViewById (R.id.crear_logrado_ejer);

    }


    public void crearEjercicio (View view) {
        Log.i(LogUtils.tag, "METODO CREAR EJERCICIO");
        String tiempoDedicado = campotiempoDedicado.getText().toString();
        int tiempoDedicadoI = (int) (Double.parseDouble(tiempoDedicado));
        String experiencia = campoexperiencia.getText().toString();
        String duda = campodudas.getText().toString();
        String logrado = campologrado.getText().toString();
        int logradoI = (int) (Double.parseDouble(logrado));


        // MateriasListView metodoBuscar = new MateriasListView();
        // Ejercicio unEjercicio = new Ejercicio(tiempoDedicadoI, experiencia , duda , logradoI);
        // unEjercicio.agregarEjercicio(ejercicio);

        Toast toast = Toast.makeText( this, "Ejercicio agregado", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Ejercicio creado: "+ unEjercicio.getTiempoDedicado());
        finish();
    }


    public void lanzarVistaAddEjercicio (View view){
        Intent i = new Intent(this, AddEjercicioActivity.class);
        desplegarMensajeVolver();
        startActivity(i);
    }

    //Cargar el menu donde se tiene que llevar de vuelta
    public void lanzarVistaVolver (View view){
        Intent i = new Intent(this, TemasListView.class);
        startActivity(i);
    }

    public void desplegarMensajeVolver() {
        Toast toast = Toast.makeText( this, "Carga cancelada", Toast.LENGTH_SHORT);
        toast.show();
    }
}

