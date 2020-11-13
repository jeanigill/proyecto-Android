package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    Bitacora unaBitacora = null;

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


//    public void crearMateria(View view) {
//        Log.i(LogUtils.tag, "METODO CREAR MATERIA ");
//        String nombreMateria = campoNombreMateria.getText().toString();
//        String idMateria = campoId.getText().toString();
//
//
//        if (nombreMateria.equals("") || idMateria.equals("")) {
//            desplegarMensajeCamposRequeridos();
//        } else {
//            unaBitacora = App.buscarBitacora(idBitacora);
//            int idMateriaI = (int) (Double.parseDouble(idMateria));
//           // ArrayList<Materia> materias = new ArrayList<>();
//            Materia materia = new Materia(idMateriaI, nombreMateria);
//            if (materia == null) {
//                Log.i(LogUtils.tag, "Materia null ");
//            } else {
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

    public void crearMateria(View view) {
        Log.i(LogUtils.tag, "METODO CREAR MATERIA ");
        String nombreMateria = campoNombreMateria.getText().toString();
        String idMateria = campoId.getText().toString();


        if (nombreMateria.equals("") || idMateria.equals("")) {
            desplegarMensajeCamposRequeridos();
        } else {
            int idMateriaI = (int) (Double.parseDouble(idMateria));
            ArrayList<Materia> materias = new ArrayList<>();
            Materia materia = new Materia(idMateriaI, nombreMateria, materias);
            if (materia == null) {
                Log.i(LogUtils.tag, "Materia null ");
            } else {
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
  //              crearMateria ();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    ///// TOAST //////
    public void mensajeMateriaCreada(Materia materia) {
        Toast toast = Toast.makeText(this, "Materia creada", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Materia creada: " + materia.getNombre());
    }

    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeCancelado() {
        Toast toast = Toast.makeText( this, "La carga fue cancelada", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void limpiarCampos(){
        campoNombreMateria.setText("");
        campoId.setText("");
    }


    public void lanzarVistaVolver (View view){
        Intent i = new Intent(this, MateriasListView.class);
        desplegarMensajeCancelado();
        startActivity(i);
    }


        //// MOSTRAR FECHA ////

    private void mostrarFecha(final EditText campoFechaMateria) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
                campoFechaMateria.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new DatePickerDialog(AddMateriaActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}





