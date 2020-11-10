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
import py.com.misgruposv01.adaptadores.BitacoraAdaptador;
import py.com.misgruposv01.adaptadores.MateriaAdaptador;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;

public class MateriasListView extends ListActivity {
public int idBitacora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_materias);

        Bundle extras = getIntent().getExtras();
        idBitacora = 0;
        if (extras != null) {
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
        }

        Bitacora unaBitacora = App.buscarBitacora(idBitacora);

        setListAdapter(new MateriaAdaptador(this, unaBitacora.getMaterias()));




    }








    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, TemasListView.class);
        i.putExtra("idMateria", Integer.parseInt(""+id));
        i.putExtra("idBitacora", Integer.parseInt(""+idBitacora));

        startActivity(i);
    }



    public void lanzarVistaAddMateria(View view){
        Intent i = new Intent(this, AddMateriaActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
}