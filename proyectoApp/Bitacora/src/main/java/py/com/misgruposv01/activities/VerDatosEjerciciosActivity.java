package py.com.misgruposv01.activities;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;
import py.com.misgruposv01.utils.NotificationsUtils;

// import py.com.misgruposv01.utils.NotificationsUtils;
// import py.com.misgruposv01.utils.RequestCode;

public class VerDatosEjerciciosActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosEjercicioActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idEjercicio = 1;
    private Bitacora unaBitacora = null;
    private Materia unaMateria = null;
    private Tema unTema = null;
    private Ejercicio unEjercicio = null;
    private TextView tiempoD;
    private TextView experiencia;
    private TextView logrado;
    private TextView dudas;
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosTemasItemActivity.onCreate");
        setContentView(R.layout.fragment_ejercicio);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            idEjercicio = extras.getInt("idEjercicio", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: "+ idTema);
            Log.i(LogUtils.tag, "Id recibido del ejercicio: "+ idEjercicio);

        }else{
            Log.i(LogUtils.tag, "Extras es null en ver Datos Ejercicio: ");
        }

      actualizarVista();
    }

    public void actualizarVista(){
        unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);
        unTema = App.buscarTema(unaMateria, idTema);
        unEjercicio = unTema.getEjercicios().get(idEjercicio);

        if ( idEjercicio < 0 || idEjercicio > (unTema.getEjercicios().size()-1) ) {
            desplegarMensajeNoExisteEjercicio();
            finish();
            return;
        }

        experiencia = (TextView) findViewById(R.id.id_nombre_experiencia_valor);
        experiencia.setText( unEjercicio.getExperiencia());

        tiempoD = (TextView) findViewById(R.id.nombre_tiempo_dedic_valor);
        String tiempoS = String.valueOf(unEjercicio.getTiempoDedicadoIni());
        tiempoD.setText(tiempoS+" minutos");

        logrado = (TextView) findViewById(R.id.id_nombre_logrado_valor);
        String logradoS = String.valueOf(unEjercicio.getLogrado());
        logrado.setText(logradoS+" %");
        Log.i(LogUtils.tag, "Logrado del ejercicio: "+unEjercicio.getLogrado());

        dudas = (TextView) findViewById(R.id.id_nombre_dudas_valor);
        dudas.setText( unEjercicio.getDudas());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.ver_item_menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId() ) {
            case R.id.editar_grupo:{
                //lanzarActividadEdicionGrupo();
                break;
            }
            case R.id.eliminar_grupo:{
                unTema.getEjercicios().remove(unEjercicio);
                desplegarMensajeEliminacionEjercicio();
                 finish();
              break;
          }case R.id.accion_sigte_tar:{
            Log.d(LogUtils.tag, "Ejercicio seleccionado: Siguiente");
                opcionSiguiente();
          }

          }
      return true;
     }

    public void opcionSiguiente(){
        idEjercicio++;
        if(idEjercicio < unTema.getEjercicios().size()){
            unEjercicio = unTema.getEjercicios().get(idEjercicio);
            actualizarVista();
        }else{
            Context contexto = getApplicationContext();
            NotificationsUtils.desplegarMensaje("Ya no existen ejercicios en la lista", contexto);
        }

    }

    //  private void lanzarActividadEdicionGrupo() {
    //    Intent i = new Intent( this, CrearGrupoActivity.class );
    //    i.putExtra("idGrupo", idGrupo );
    //    startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    //    }


    public void desplegarMensajeEliminacionEjercicio() {
        Toast toast = Toast.makeText( this, "El ejercicio fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteEjercicio() {
        Toast toast = Toast.makeText( this, "El ejercicio no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
}
