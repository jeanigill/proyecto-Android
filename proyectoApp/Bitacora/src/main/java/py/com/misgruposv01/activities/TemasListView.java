package py.com.misgruposv01.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.adaptadores.MateriaAdaptador;
import py.com.misgruposv01.adaptadores.TemaAdaptador;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

 public class TemasListView extends ListActivity {
     int idMateria = 0;
     int idBitacora = 0;
     Bitacora unaBitacora = null;
     Materia unaMateria = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_temas);

        Log.i(LogUtils.tag, "METODO DE TEMAS LIST VIEW" );
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);

        }
        unaBitacora = App.buscarBitacora(idBitacora);
        unaMateria = App.buscarMateria(unaBitacora, idMateria);
            if (unaMateria.getTemas() == null ||unaMateria.getTemas().size()==0){
                Toast.makeText(this, "Todavía no hay temas cargados", Toast.LENGTH_SHORT).show();
            }else {
                Log.i(LogUtils.tag, "Materias Size: " + unaMateria.getTemas().size());
                setListAdapter(new TemaAdaptador(this, unaMateria.getTemas()));
            }
            Log.i(LogUtils.tag, "Log es NULL" );
        }



    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,MenuPrincipalActivity.class);
        i.putExtra("idBitacora", Integer.parseInt(""+idBitacora));
        i.putExtra("idMateria", Integer.parseInt(""+idMateria));
        i.putExtra("idTema", Integer.parseInt(""+id));

        startActivity(i);
    }

     public void lanzarVistaAddTema(View view){
         Intent i = new Intent(this, AddMateriaActivity.class);
         //i.putExtra("id", (long)0);
         i.putExtra("idBitacora", Integer.parseInt(""+idBitacora));
         i.putExtra("idMateria", Integer.parseInt(""+idMateria));
         startActivity(i);
     }

 }