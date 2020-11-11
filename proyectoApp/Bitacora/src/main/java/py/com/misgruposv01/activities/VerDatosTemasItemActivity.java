package py.com.misgruposv01.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.utils.LogUtils;

// import py.com.misgruposv01.utils.NotificationsUtils;
// import py.com.misgruposv01.utils.RequestCode;

public class VerDatosTemasItemActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idItem = 0;
    private Bitacora unaBitacora = null;
    private Materia unaMateria = null;
    private Tema unTema = null;
    private Item unItem = null;
    private TextView Concepto;
    private TextView Descripcion;
    private TextView Dudas;
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosTemasItemActivity.onCreate");
        setContentView(R.layout.activity_ver_datos_temas);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            //idItem = extras.getInt("idItem", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: "+ idTema);
            Log.i(LogUtils.tag, "Id recibido del item: "+ idItem);
        }

     //   actualizarVista();
    }

    public void actualizarVista(){
        if ( idItem < 0 || idItem > (unTema.getItems().size()-1) ) {
            desplegarMensajeNoExisteGrupo();
            finish();
            return;
        }
        unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);
        unTema = App.buscarTema(unaMateria, idTema);
        unItem = unTema.getItems().get(idItem);

        Concepto = (TextView) findViewById(R.id.id_nombre_concepto_valor);
        Concepto.setText( unItem.getConcepto());

        Descripcion = (TextView) findViewById(R.id.id_nombre_descrip_valor);
        Descripcion.setText(unItem.getDescripcion());
    }

  //  @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
  //      getMenuInflater().inflate( R.menu.ver_grupo_menu , menu );
  //      return true;
  //  }

  //  @Override
  //  public boolean onOptionsItemSelected(MenuItem item) {
  //      switch( item.getItemId() ) {
  //          case R.id.editar_grupo:{
  //              lanzarActividadEdicionGrupo();
  //              break;
  //          }
  //          case R.id.eliminar_grupo:{
  //              Grupo.grupos.remove( idGrupo );
  //              desplegarMensajeEliminacionGrupo();
    //             finish();
    //          break;
    //      }case R.id.accion_sigte_tar:{
  //          Log.d(LogUtils.tag, "Item seleccionado: Siguiente");
    //            opcionSiguiente();
    //      }
//
    //      }
    //  return true;
    // }

    //  private void lanzarActividadEdicionGrupo() {
    //    Intent i = new Intent( this, CrearGrupoActivity.class );
    //    i.putExtra("idGrupo", idGrupo );
    //    startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    //    }


    public void desplegarMensajeEliminacionGrupo() {
        Toast toast = Toast.makeText( this, "El grupo fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteGrupo() {
        Toast toast = Toast.makeText( this, "El grupo no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
}
