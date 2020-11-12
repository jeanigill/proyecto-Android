package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddTemaActivity extends Activity {
    private String tag = "AppConoceme";
    EditText campoId;
    EditText campoNombre;
    EditText campoFecha;
    int idBitacora = 0;
    int idMateria = 0;
    Bitacora unaBitacora= null;
    Materia unaMateria= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD TEMA ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tema);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            idMateria = extras.getInt("idMateria", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
        }

         unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);

        campoNombre = (EditText) findViewById(R.id.crear_nombre_tema);
        campoId = (EditText) findViewById(R.id.crear_id_tema);
        campoFecha = (EditText) findViewById(R.id.editText);

        campoFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFecha(campoFecha);
            }
        });

    }


//    public void crearTema (View view) {
//        Log.i(LogUtils.tag, "METODO CREAR MATERIA ");
//        String nombreTema = campoNombre.getText().toString();
//        String idTexmaS = campoId.getText().toString();
//        String fecha = campoFecha.getText().toString();
//        //Date fechaNac = (Date.valueOf(fechaS);
//        //fechaS.split("-");
//        if (nombreTema.equals("") || idTema.equals("") || fecha.equals("")) {
//            desplegarMensajeCamposRequeridos();
//        } else {
////            if ( modoEdicion ) {
////                Grupo grupo = Grupo.grupos.get( idGrupo );
////                grupo.setNombre( nombre );
////                grupo.setDescripcion( objetivo );
////
////                Intent intent = new Intent();
////                intent.putExtra("resultado", 1);
////                setResult(RESULT_OK, intent);
////                finish();
////            } else {
//            int idTemaI = (int) (Double.parseDouble(idTemaS));
//          //  ArrayList<Tema> temas = new ArrayList<>();
//            Tema tema = new Tema(idTemaI, nombreTema, temas);
//            if (tema == null){
//                Log.i(LogUtils.tag, "Materia null ");
//            }else{
//                App.agregarMateria(unaBitacora, materia);
//                mensajeMateriaCreada(materia);
//                finish();
//            }
//
//            Intent intent = new Intent();
//            intent.putExtra("resultado", 10);
//            setResult(RESULT_OK, intent);
//            finish();
//        }
//    }

    public void mensajeMateriaCreada(Materia materia){
        Toast toast = Toast.makeText( this, "Materia creada", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Materia creada: "+materia.getNombre());
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

        new DatePickerDialog(AddTemaActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

}


