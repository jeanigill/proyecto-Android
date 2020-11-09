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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_temas);

         Bundle extras = getIntent().getExtras();

        Materia unaMateria = buscarMateria();
        setListAdapter(new TemaAdaptador(this, unaMateria.getTemas()));

    }

    //    METODO PARA BUSCAR MATERIA
     public Materia buscarMateria (){
         Log.i(LogUtils.tag, "TEMASlISTvIEW BUSCAR MATERIA" );
         Bundle extras = getIntent().getExtras();
         int idMateria = 0;
         if (extras != null) {
             idMateria = extras.getInt("idMateria", -1);
             Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
         }
        MateriasListView metodo = null;
         Bitacora unaBitacora = metodo.buscarBitacora();
         Materia unaMateria = null;
         for (int i = 0; i < unaBitacora.getMaterias().size(); i++) {
             unaMateria = unaBitacora.getMaterias().get(i);
             if (idMateria == unaMateria.getId()) {
                 i = unaBitacora.getMaterias().size();
                 return unaMateria;
             }
         }
         return null;
     }



    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MenuPrincipalActivity.class);
        i.putExtra("idMaterias", Integer.parseInt(""+id));
        startActivity(i);
    }

 }