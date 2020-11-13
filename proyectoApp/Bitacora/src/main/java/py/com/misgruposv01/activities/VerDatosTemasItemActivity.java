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
import py.com.misgruposv01.utils.NotificationsUtils;

// import py.com.misgruposv01.utils.NotificationsUtils;
// import py.com.misgruposv01.utils.RequestCode;

public class VerDatosTemasItemActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idItem = 1;
    private Bitacora unaBitacora = null;
    private Materia unaMateria = null;
    private Tema unTema = null;
    private Item unItem = null;
    private TextView campoConcepto;
    private TextView campoDescripcion;
    private TextView campoDudas;
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosTemasItemActivity.onCreate");
        setContentView(R.layout.fragment_item);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            idItem = extras.getInt("idItem", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: "+ idTema);
            Log.i(LogUtils.tag, "Id recibido del item: "+ idItem);

        }

      actualizarVista();
    }

    public void actualizarVista(){
        unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);
        unTema = App.buscarTema(unaMateria, idTema);
        unItem = unTema.getItems().get(idItem);


        if ( idItem < 0 || idItem > (unTema.getItems().size()-1) ) {
            desplegarMensajeNoExisteItem();
            finish();
            return;
        }

        campoConcepto = (TextView) findViewById(R.id.id_nombre_concepto_valor);
        campoConcepto.setText( unItem.getConcepto());

        campoDescripcion = (TextView) findViewById(R.id.id_nombre_descrip_valor);
        campoDescripcion.setText(unItem.getDescripcion());

        campoDudas = (TextView) findViewById(R.id.id_nombre_dudas_valor);
        Log.i(LogUtils.tag, "Dudas: " + unItem.getDudas());
        campoDudas.setText(unItem.getDudas());
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
                unTema.getItems().remove(unItem);
                desplegarMensajeEliminacionItem();
                 finish();
              break;
          }case R.id.accion_sigte_tar:{
            Log.d(LogUtils.tag, "Item seleccionado: Siguiente");
                opcionSiguiente();
          }

          }
      return true;
     }

    public void opcionSiguiente(){
        idItem++;
        if(idItem < unTema.getItems().size()){
            unItem = unTema.getItems().get(idItem);
            actualizarVista();
        }else{
            Context contexto = getApplicationContext();
            NotificationsUtils.desplegarMensaje("Ya no existen items en la lista", contexto);
        }

    }

    //  private void lanzarActividadEdicionGrupo() {
    //    Intent i = new Intent( this, CrearGrupoActivity.class );
    //    i.putExtra("idGrupo", idGrupo );
    //    startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    //    }


    public void desplegarMensajeEliminacionItem() {
        Toast toast = Toast.makeText( this, "El item fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteItem() {
        Toast toast = Toast.makeText( this, "El item no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
}
