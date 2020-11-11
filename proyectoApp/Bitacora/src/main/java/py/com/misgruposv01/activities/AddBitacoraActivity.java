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

public class AddBitacoraActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoId;
     EditText campoAnho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bitacora);

        campoId = (EditText) findViewById(R.id.id_bitacora);
        campoAnho = (EditText) findViewById(R.id.anho_bitacora);

    }


    public void crearBitacora (View view) {
        String idString = campoId.getText().toString();
        int id = (int) (Double.parseDouble(idString));
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
}
