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

        Bundle extras = getIntent().getExtras();
        int idBitacora = 0;
        if(extras != null){
            idBitacora = extras.getInt("idBitacora", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: "+idBitacora);
        }

        Bitacora unaBitacora;
        ArrayList<Materia> materias = null;
        for (int i=0; i<App.listadoBitacoras.size(); i++){
            unaBitacora = App.getListadoBitacoras().get(i);

            if (idBitacora == unaBitacora.getId()){

                materias = unaBitacora.getMaterias();
                Log.i(LogUtils.tag, "Bitacora encontrada - id: "+idBitacora);
                Log.i(LogUtils.tag, "Cantidad de materias: "+materias.size());
//                Intent i = new Intent(this, MenuPrincipalActivity.class);
//                i.putExtra("idBitacora", Integer.parseInt(""+idBitacora));
            }
        }

        setListAdapter(new MateriaAdaptador(this, materias));



        // Modo1

    }



    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MenuPrincipalActivity.class);
        i.putExtra("idMaterias", Integer.parseInt(""+id));

        startActivity(i);
    }


    public void lanzarVistaAddMateria(View view) {


    }
}