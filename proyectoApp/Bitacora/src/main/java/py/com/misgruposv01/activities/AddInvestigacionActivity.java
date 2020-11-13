package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Investigacion;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class AddInvestigacionActivity extends AppCompatActivity {
    private String tag = "AppConoceme";
    EditText campoTiempoDedicado;
    EditText campoTema;
    EditText campoComentarios;
    EditText campoDudas;
        EditText campoComprension;
    int idBitacora = 0;
    int idMateria = 0;
    int idTema = 0;
    int tiempoDedicadoI;
    Investigacion unaInvestigacion= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LogUtils.tag, "ACTIVIDAD ADD INVESTIGACION ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_investigacion);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            idMateria = extras.getInt("idMateria", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la Bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la Materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: " + idTema);
        }


        campoTiempoDedicado = (EditText) findViewById(R.id.crear_tiempodedi_inves);
       // campoTiempoDedicado.setInputType(InputType.TYPE_NULL);
        campoTema = (EditText) findViewById(R.id.crear_tema_inves);
        campoComentarios = (EditText) findViewById(R.id.crear_comentarios_inves);
        campoDudas = (EditText) findViewById(R.id.crear_dudas_inves);
        campoComprension = (EditText) findViewById(R.id.crear_comprension_inves);


        campoTiempoDedicado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarFechaHora(campoTiempoDedicado);
            }
        });

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
                crearInvestigacion();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }


    public void crearInvestigacion () {
        Log.i(LogUtils.tag, "METODO CREAR INVESTIGACION ");

       // String tiempoDedicadoS = campoTiempoDedicado.getText().toString();
        String tema = campoTema.getText().toString();
        String comentarios = campoComentarios.getText().toString();
        String dudas = campoDudas.getText().toString();
        String comprensionS = campoComprension.getText().toString();

        if (tema.equals("")|| comentarios.equals("")||dudas.equals("")|| comprensionS.equals("")) {
            desplegarMensajeCamposRequeridos();
        }else{
         //   int tiempoDedicado = (int) (Double.parseDouble(tiempoDedicadoS));
            int comprension = (int) (Double.parseDouble(comprensionS));
            Bitacora unaBitacora = App.buscarBitacora(idBitacora);
            Materia unaMateria = App.buscarMateria(unaBitacora, idMateria);
            Tema unTema = App.buscarTema(unaMateria, idTema);
            Investigacion investigacion = new Investigacion ( tema, comentarios, comprension, dudas);
            App.agregarInvestigacion(unTema, investigacion);
            desplegarMensajeResgistroExitoso();
            Log.i(LogUtils.tag, "Investigacion creada creado: "+ investigacion.getTema());
            finish();
        }


    }

    public void crearInvestigacion (View view) {
        Log.i(LogUtils.tag, "METODO CREAR INVESTIGACION ");

        // String tiempoDedicadoS = campoTiempoDedicado.getText().toString();
        String tema = campoTema.getText().toString();
        String comentarios = campoComentarios.getText().toString();
        String dudas = campoDudas.getText().toString();
        String comprensionS = campoDudas.getText().toString();

        if (tema.equals("")|| comentarios.equals("")||dudas.equals("")|| comprensionS.equals("")) {
            desplegarMensajeCamposRequeridos();
        }else{
            //   int tiempoDedicado = (int) (Double.parseDouble(tiempoDedicadoS));
            int comprension = (int) (Double.parseDouble(comprensionS));
            Bitacora unaBitacora = App.buscarBitacora(idBitacora);
            Materia unaMateria = App.buscarMateria(unaBitacora, idMateria);
            Tema unTema = App.buscarTema(unaMateria, idTema);
            Investigacion investigacion = new Investigacion ( tema, comentarios, comprension, dudas);
            App.agregarInvestigacion(unTema, investigacion);
            desplegarMensajeResgistroExitoso();
            Log.i(LogUtils.tag, "Investigacion creada creado: "+ investigacion.getTema());
        }

        finish();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }


    private void mostrarFechaHora(final EditText date_time_in) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(AddInvestigacionActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(AddInvestigacionActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void limpiarCampos(){
        campoComentarios.setText("");
        campoComprension.setText("");
        campoDudas.setText("");
        campoTema.setText("");
    }

}
