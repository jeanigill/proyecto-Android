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
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddInvestigacionActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoTiempoDedicado;
    EditText campoTema;
    EditText campoComentarios;
    EditText campoDudas;
        EditText campoComprension;
    int idBitacora = 0;
    int idMateria = 0;
    int idTema = 0;
    int tiempoDedicadoI;
    Investigacion unaInvestigacion= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD INVESTIGACION ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_investigacion);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            idMateria = extras.getInt("idMateria", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la Bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la Materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: " + idTema);
        }

//      unaBitacora = App.buscarBitacora(idInvestigacion);

        campoTiempoDedicado = (EditText) findViewById(R.id.crear_tiempodedi_inves);
        campoTema = (EditText) findViewById(R.id.crear_id_Materia);
        campoComentarios = (EditText) findViewById(R.id.crear_tiempodedi_inves);
        campoDudas = (EditText) findViewById(R.id.crear_dudas_inves);
        campoComprension = (EditText) findViewById(R.id.crear_comprension_inves);


    }


    public void crearInvestigacion (View view) {
        Log.i(LogUtils.tag, "METODO CREAR INVESTIGACION ");

        String tiempoDedicadoS = campoTiempoDedicado.getText().toString();
        int tiempoDedicado = (int) (Double.parseDouble(tiempoDedicadoS));
        String tema = campoTema.getText().toString();
        String comentarios = campoComentarios.getText().toString();
        String dudas = campoDudas.getText().toString();
        String comprensionS = campoDudas.getText().toString();
        int comprension = (int) (Double.parseDouble(comprensionS));

        Bitacora unaBitacora = App.buscarBitacora(idBitacora);
        Materia unaMateria = App.buscarMateria(unaBitacora, idMateria);
        Tema unTema = App.buscarTema(unaMateria, idTema);
        Investigacion investigacion = new Investigacion (tiempoDedicado, tema, comentarios, comprension, dudas);
        unTema.agregarInvestigacion(investigacion);

        Toast toast = Toast.makeText( this, "Investigacion agregada", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Investigacion creada: "+investigacion.getTema());

        finish();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }


}
