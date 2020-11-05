package py.com.misgruposv01.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;

public class BitacorasListView extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_bitacoras);

        ArrayList<Bitacora> listadoBitacoras = Bitacora.listadoBitacoras;
        Log.d(LogUtils.tag, "CantidadGrupos: " + listadoBitacoras.size());

        // Modo1
        setListAdapter(new GrupoAdaptador(this, grupos));
    }

}
