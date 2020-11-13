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
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;
import py.com.misgruposv01.utils.NotificationsUtils;

// import py.com.misgruposv01.utils.NotificationsUtils;
// import py.com.misgruposv01.utils.RequestCode;

public class VerDatosInvestigacionActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosInvestigacionActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idInvestigacion = 1;
    private Bitacora unaBitacora = null;
    private Materia unaMateria = null;
    private Tema unTema = null;
    private Investigacion unaInvestigacion = null;
    private TextView tiempoD;
    private TextView temaInvestigado;
    private TextView comentarios;
    private TextView nivelComp;
    private TextView dudas;
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosInvestigacionActivity.onCreate");
        setContentView(R.layout.fragment_investigacion);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            idInvestigacion = extras.getInt("idInvestigacion", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: "+ idTema);
            Log.i(LogUtils.tag, "Id recibido de la investigacion: "+ idInvestigacion);

        }else{
            Log.i(LogUtils.tag, "Extras es null en ver Datos Investigacion: ");
        }

      actualizarVista();
    }

    public void actualizarVista(){
        unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);
        unTema = App.buscarTema(unaMateria, idTema);
        unaInvestigacion = unTema.getInvestigaciones().get(idInvestigacion);

        if ( idInvestigacion < 0 || idInvestigacion > (unTema.getInvestigaciones().size()-1) ) {
            desplegarMensajeNoExisteInvestigacion();
            finish();
            return;
        }

        tiempoD = (TextView) findViewById(R.id.tiempo_dedicado_valor);
        String tiempoDS = String.valueOf(unaInvestigacion.getTiempoDedicado());
        tiempoD.setText( tiempoDS);

        temaInvestigado = (TextView) findViewById(R.id.tema_investigado_valor);
        temaInvestigado.setText(unaInvestigacion.getTema());

        comentarios = (TextView) findViewById(R.id.id_nombre_comentarios_valor);
        comentarios.setText(unaInvestigacion.getComentarios());

        nivelComp = (TextView) findViewById(R.id.id_nombre_comprension_valor);
        String nivelCS = String.valueOf(unaInvestigacion.getComprension());
        nivelComp.setText(nivelCS);

        dudas = (TextView) findViewById(R.id.id_nombre_dudas_inves_valor);
        dudas.setText( unaInvestigacion.getDudas());

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
                unTema.getEjercicios().remove(unaInvestigacion);
                desplegarMensajeEliminacionInvestigacion();
                 finish();
              break;
          }case R.id.accion_sigte_tar:{
            Log.d(LogUtils.tag, "Investigacion seleccionada: Siguiente");
                opcionSiguiente();
          }

          }
      return true;
     }

    public void opcionSiguiente(){
        idInvestigacion++;
        if(idInvestigacion < unTema.getInvestigaciones().size()){
            unaInvestigacion = unTema.getInvestigaciones().get(idInvestigacion);
            actualizarVista();
        }else{
            Context contexto = getApplicationContext();
            NotificationsUtils.desplegarMensaje("Ya no existen investigaciones en la lista", contexto);
        }

    }

    //  private void lanzarActividadEdicionGrupo() {
    //    Intent i = new Intent( this, CrearGrupoActivity.class );
    //    i.putExtra("idGrupo", idGrupo );
    //    startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    //    }


    public void desplegarMensajeEliminacionInvestigacion() {
        Toast toast = Toast.makeText( this, "La investigacion fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteInvestigacion() {
        Toast toast = Toast.makeText( this, "La investigación no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
}
