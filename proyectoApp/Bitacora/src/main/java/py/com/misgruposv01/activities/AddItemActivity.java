package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddItemActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText campoConcepto;
    EditText campoDescripcion;
    EditText campoDudas;
    EditText campoAprendido;

    int idBitacora = 0;
    int idMateria = 0;
    int idTema = 0;

    int idItem = 0;
    Item unItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD MATERIA ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            idMateria = extras.getInt("idMateria", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la Bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la Materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: " + idTema);
        }


        //  unItem = App.buscarItem(idItem);

        campoConcepto = (EditText) findViewById(R.id.crear_concepto_item);
        campoDescripcion = (EditText) findViewById(R.id.crear_descripcion_item);
        campoDudas = (EditText) findViewById(R.id.crear_dudas_item);
        campoAprendido = (EditText) findViewById(R.id.crear_aprendido_item);


    }
    public void crearItem () {
        Log.i(LogUtils.tag, "METODO CREAR ITEM ");
        String concepto = campoConcepto.getText().toString();
        String descripcion = campoDescripcion.getText().toString();
        String dudas = campoDudas.getText().toString();
        if (concepto.equals("")|| descripcion.equals("")||dudas.equals("")){
            desplegarMensajeCamposRequeridos();
        }else{
            Bitacora unaBitacora = App.buscarBitacora(idBitacora);
            Materia unaMateria = App.buscarMateria(unaBitacora, idMateria);
            Tema unTema = App.buscarTema(unaMateria, idTema);
            Item item = new Item (concepto, descripcion, dudas, false);
            App.agregarItem(unTema, item);
            desplegarMensajeResgistroExitoso();
            Log.i(LogUtils.tag, "Item creado: "+item.getConcepto());
            finish();
        }
    }

    public void crearItem (View view) {
        Log.i(LogUtils.tag, "METODO CREAR ITEM ");
        String concepto = campoConcepto.getText().toString();
        String descripcion = campoDescripcion.getText().toString();
        String dudas = campoDudas.getText().toString();
        if (concepto.equals("")|| descripcion.equals("")||dudas.equals("")){
            desplegarMensajeCamposRequeridos();
        }else{
            Bitacora unaBitacora = App.buscarBitacora(idBitacora);
            Materia unaMateria = App.buscarMateria(unaBitacora, idMateria);
            Tema unTema = App.buscarTema(unaMateria, idTema);
            Item item = new Item (concepto, descripcion, dudas, false);
            App.agregarItem(unTema, item);
            desplegarMensajeResgistroExitoso();
            Log.i(LogUtils.tag, "Item creado: "+item.getConcepto());
            finish();
        }
    }

    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.crear_menu_limpiar, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
               crearItem();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }
    public void limpiarCampos(){
        campoConcepto.setText("");
        campoDescripcion.setText("");
        campoDudas.setText("");
  //      campoAprendido.setText("");
    }


}
