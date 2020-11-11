package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.utils.LogUtils;

public class AddMateriaActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoNombreMateria;
    EditText campoId;
    EditText campoFechaMateria;
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
        campoFechaMateria = (EditText) findViewById(R.id.editText);

        campoFechaMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFecha(campoFechaMateria);
            }
        });

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

    private void mostrarFecha(final EditText campoFechaMateria) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                campoFechaMateria.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(AddMateriaActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

}


