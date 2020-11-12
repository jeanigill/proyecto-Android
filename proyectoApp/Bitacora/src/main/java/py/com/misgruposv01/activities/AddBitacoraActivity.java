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

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;
import androidx.appcompat.app.AppCompatActivity;

public class AddBitacoraActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText campoId;
     EditText campoAnho;
    int id = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bitacora);

        campoId = (EditText) findViewById(R.id.id_bitacora);
        campoAnho = (EditText) findViewById(R.id.anho_bitacora);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.crear_menu_compartir, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                crearBitacora ();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void crearBitacora (View view) {
        String idString = campoId.getText().toString();
        id = (int) (Double.parseDouble(idString));
        String anho = campoAnho.getText().toString();
        if (idString.equals("") || anho.equals("")) {
            desplegarMensajeCamposRequeridos();
        }else{
//                if (modoEdicion) {
//                    Grupo grupo = Grupo.grupos.get(idGrupo);
//                    grupo.setNombre(nombre);
//                    grupo.setDescripcion(objetivo);
//
//                    Intent intent = new Intent();
//                    intent.putExtra("resultado", 1);
//                    setResult(RESULT_OK, intent);
//                    finish();
//                }
                    Bitacora unaBitacora = new Bitacora(id, anho);
                    App.agregarBitacora(unaBitacora);
                    desplegarMensajeResgistroExitoso();

                    Log.i(LogUtils.tag, "Metodo Crear Bitacora: " + unaBitacora.getAnho());

                    Log.i(LogUtils.tag, "Cantidad de bitacoras: " + App.listadoBitacoras.size());
                    finish();
                }
            }
    public void crearBitacora () {
        String idString = campoId.getText().toString();
        id = (int) (Double.parseDouble(idString));
        String anho = campoAnho.getText().toString();
        if (idString.equals("") || anho.equals("")) {
            desplegarMensajeCamposRequeridos();
        }else{
//                if (modoEdicion) {
//                    Grupo grupo = Grupo.grupos.get(idGrupo);
//                    grupo.setNombre(nombre);
//                    grupo.setDescripcion(objetivo);
//
//                    Intent intent = new Intent();
//                    intent.putExtra("resultado", 1);
//                    setResult(RESULT_OK, intent);
//                    finish();
//                }
            Bitacora unaBitacora = new Bitacora(id, anho);
            App.agregarBitacora(unaBitacora);
            desplegarMensajeResgistroExitoso();

            Log.i(LogUtils.tag, "Metodo Crear Bitacora: " + unaBitacora.getAnho());

            Log.i(LogUtils.tag, "Cantidad de bitacoras: " + App.listadoBitacoras.size());
            finish();
        }
    }
    public void limpiarCampos(){
        campoAnho.setText("");
        campoId.setText("");
    }

    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText( this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeCancelado() {
        Toast toast = Toast.makeText( this, "La carga fue cancelada", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void lanzarVistaVolver (View view){
        Intent i = new Intent(this, BitacorasListView.class);
        desplegarMensajeCancelado();
        startActivity(i);
    }
    public void lanzarVistaAddMateriaB (View view) {
        crearBitacora();
        Intent i = new Intent(this, AddMateriaActivity.class);
        i.putExtra("idBitacora", Integer.parseInt(""+id));
        startActivity(i);
    }
}
