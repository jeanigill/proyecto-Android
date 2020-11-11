package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;

public class AddMateriaActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoNombreMateria;
    EditText campoId;
    int idBitacora = 0;
    Bitacora unaBitacora= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD MATERIA ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
        }

         unaBitacora = App.buscarBitacora(idBitacora);

        campoNombreMateria = (EditText) findViewById(R.id.crear_nombre_Materia);
        campoId = (EditText) findViewById(R.id.crear_id_Materia);
    }


    public void crearMateria (View view) {
        Log.i(LogUtils.tag, "METODO CREAR MATERIA ");
        String nombreMateria = campoNombreMateria.getText().toString();
        String idMateria = campoId.getText().toString();
        int idMateriaI = (int) (Double.parseDouble(idMateria));

        if (nombreMateria.equals("") || idMateria.equals("")) {
            desplegarMensajeCamposRequeridos();
        } else {
//            if ( modoEdicion ) {
//                Grupo grupo = Grupo.grupos.get( idGrupo );
//                grupo.setNombre( nombre );
//                grupo.setDescripcion( objetivo );
//
//                Intent intent = new Intent();
//                intent.putExtra("resultado", 1);
//                setResult(RESULT_OK, intent);
//                finish();
//            } else {
            Materia materia = new Materia(idMateriaI, nombreMateria);
            if (materia == null){
                Log.i(LogUtils.tag, "Materia null ");
            }else{
                App.agregarMateria(unaBitacora, materia);
                mensajeMateriaCreada(materia);
                finish();
            }

            Intent intent = new Intent();
            intent.putExtra("resultado", 10);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void mensajeMateriaCreada(Materia materia){
        Toast toast = Toast.makeText( this, "Materia creada", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Materia creada: "+materia.getNombre());
    }
    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddMateriaActivity.class);
        startActivity(i);
    }
    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText( this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

}
