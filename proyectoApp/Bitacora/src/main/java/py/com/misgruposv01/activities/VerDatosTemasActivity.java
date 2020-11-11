package py.com.misgruposv01.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.App;
import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.datos.Item;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;


public class VerDatosTemasActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idItem = 1;
    private Bitacora unaBitacora = null;
    private Materia unaMateria = null;
    private Tema unTema = null;
    private Item unItem = null;
    private TextView Concepto;
    private TextView Descripcion;
    private TextView Dudas;
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosTemasActivity.onCreate");
        setContentView(R.layout.activity_ver_datos_temas);

        BottomNavigationView navView = findViewById(R.id.nav_view);

//        Bundle extras = getIntent().getExtras();
//
//        if (extras != null) {
//            idMateria = extras.getInt("idMateria", -1);
//            idBitacora = extras.getInt("idBitacora", -1);
//            //idItem = extras.getInt("idItem", -1);
//            idTema = extras.getInt("idTema", -1);
//            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
//            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
//            Log.i(LogUtils.tag, "Id recibido del Tema: " + idTema);
//            Log.i(LogUtils.tag, "Id recibido del item: " + idItem);
//        }

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
       // actualizarVista();
    }

//    public void actualizarVista(){
//        if ( idItem < 0 || idItem > (unTema.getItems().size()-1) ) {
//            desplegarMensajeNoExisteGrupo();
//            finish();
//            return;
//        }
//        unaBitacora = App.buscarBitacora(idBitacora);
//        unaMateria = App.buscarMateria(unaBitacora, idMateria);
//        unTema = App.buscarTema(unaMateria, idTema);
//        unItem = unTema.getItems().get(idItem);
//
//        Concepto = (TextView) findViewById(R.id.id_nombre_concepto_valor);
//        Concepto.setText( unItem.getConcepto());
//
//        Descripcion = (TextView) findViewById(R.id.id_nombre_descrip_valor);
//        Descripcion.setText(unItem.getDescripcion());
//    }

//    public void desplegarMensajeNoExisteGrupo() {
//        Toast toast = Toast.makeText( this, "El grupo no existe", Toast.LENGTH_SHORT);
//        toast.show();
//    }

}





