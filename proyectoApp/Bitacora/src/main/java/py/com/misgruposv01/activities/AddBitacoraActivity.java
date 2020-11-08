package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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

        Bitacora unaBitacora = new Bitacora( id, anho);
        App.agregarBitacora(unaBitacora);
        Log.i(LogUtils.tag, "Metodo Crear Bitacora: "+unaBitacora.getAnho());
     Intent intentLanzarMaterias = new Intent( this, MateriasListView.class );
     startActivity( intentLanzarMaterias );
    }

}
