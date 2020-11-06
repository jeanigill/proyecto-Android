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
import py.com.misgruposv01.utils.LogUtils;

public class MateriasListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_materias);

        ArrayList<Materia> materias = App.listadoMaterias1;
        Log.d(LogUtils.tag, "Materias: " + materias.size());

        // Modo1
        setListAdapter(new MateriaAdaptador(this, materias));
    }

    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MateriasListView.class);
        i.putExtra("idGrupo", Integer.parseInt(""+id));
        startActivity(i);
    }

}