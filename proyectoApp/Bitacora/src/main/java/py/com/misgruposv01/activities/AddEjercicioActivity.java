package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Ejercicio;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddEjercicioActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText campotiempoDedicadoIni;
    EditText campotiempoDedicadoFin;
    int tiempoDedicadoI;
    int tiempoDedidcadoII;
    EditText campoexperiencia;
    EditText campodudas;
    EditText campologrado;
    int idTema = 0;
    int idBitacora = 0;
    int idMateria = 0;
    Tema unTema= null;
    Ejercicio unEjercicio = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD EJERCICIO ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ejercicio);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            idMateria = extras.getInt("idMateria", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la Bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la Materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: " + idTema);
        }

      //  unTema = App.buscarTema();

        campotiempoDedicadoIni = (EditText) findViewById(R.id.crear_tiempodediIni_ejerci);
        campotiempoDedicadoFin = (EditText) findViewById(R.id.crear_tiempodediFin_ejerci);
        campoexperiencia = (EditText) findViewById(R.id.crear_experiencias_ejer);
        campodudas = (EditText) findViewById(R.id.crear_dudas_ejer);
        campologrado = (EditText) findViewById (R.id.crear_logrado_ejer);

        campotiempoDedicadoIni.setInputType(InputType.TYPE_NULL);
        campotiempoDedicadoFin.setInputType(InputType.TYPE_NULL);


        campotiempoDedicadoIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHora(campotiempoDedicadoIni);
            }
        });

        campotiempoDedicadoFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHora(campotiempoDedicadoFin);
            }
        });

    }

    public void crearEjercicio (View view) {
        Log.i(LogUtils.tag, "METODO CREAR EJERCICIO");
        String tiempoDedicadoIni = campotiempoDedicadoIni.getText().toString();
        int tiempoDedicadoI = (int) (Double.parseDouble(tiempoDedicadoIni));
        String tiempoDedicadoFin = campotiempoDedicadoFin.getText().toString();
        int tiempoDedicadoII = (int) (Double.parseDouble(tiempoDedicadoFin));
        String experiencia = campoexperiencia.getText().toString();
        String duda = campodudas.getText().toString();
        String logrado = campologrado.getText().toString();
        int logradoI = (int) (Double.parseDouble(logrado));


        // MateriasListView metodoBuscar = new MateriasListView();
        // Ejercicio unEjercicio = new Ejercicio(tiempoDedicadoI, experiencia , duda , logradoI);
        // unEjercicio.agregarEjercicio(ejercicio);

        Toast toast = Toast.makeText( this, "Ejercicio agregado", Toast.LENGTH_SHORT);
        toast.show();
        Log.i(LogUtils.tag, "Ejercicio creado: "+ unEjercicio.getTiempoDedicadoIni());
        finish();
    }

    //
//    public void crearEjercicio (View view) {
//        Log.i(LogUtils.tag, "METODO CREAR EJERCICIO");
//        String tiempoDedicadoIni = campotiempoDedicadoIni.getText().toString();
//        int tiempoDedicadoI = (int) (Double.parseDouble(tiempoDedicadoIni));
//        String tiempoDedicadoFin = campotiempoDedicadoFin.getText().toString();
//        int tiempoDedicadoII = (int) (Double.parseDouble(tiempoDedicadoFin));
//        String experiencia = campoexperiencia.getText().toString();
//        String duda = campodudas.getText().toString();
//        String logrado = campologrado.getText().toString();
//        int logradoI = (int) (Double.parseDouble(logrado));
//
//
//        // MateriasListView metodoBuscar = new MateriasListView();
//        // Ejercicio unEjercicio = new Ejercicio(tiempoDedicadoI, experiencia , duda , logradoI);
//        // unEjercicio.agregarEjercicio(ejercicio);
//
//        Toast toast = Toast.makeText( this, "Ejercicio agregado", Toast.LENGTH_SHORT);
//        toast.show();
//        Log.i(LogUtils.tag, "Ejercicio creado: "+ unEjercicio.getTiempoDedicado());
//        finish();
//    }


    //Cargar el menu donde se tiene que llevar de vuelta
    public void lanzarVistaVolver (View view){
        Intent i = new Intent(this, MenuPrincipalActivity.class);
        desplegarMensajeVolver();
        startActivity(i);
    }

    public void desplegarMensajeVolver() {
        Toast toast = Toast.makeText( this, "Carga cancelada", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void mostrarHora(final EditText time_in) {
        final Calendar calendar=Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
                time_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new TimePickerDialog(AddEjercicioActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }


    @Override
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
        //        crearEjercicio();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void limpiarCampos(){
        campotiempoDedicadoIni.setText("");
        campotiempoDedicadoFin.setText("");
        campodudas.setText("");
        campoexperiencia.setText("");
    }
}


