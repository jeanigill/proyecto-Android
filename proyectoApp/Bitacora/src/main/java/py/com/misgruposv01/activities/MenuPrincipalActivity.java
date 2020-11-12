package py.com.misgruposv01.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import py.com.misgruposv01.R;
import py.com.misgruposv01.activities.AcercaDeActivity;
import py.com.misgruposv01.activities.AddMateriaActivity;
import py.com.misgruposv01.activities.Materia1Activity;
import py.com.misgruposv01.utils.LogUtils;

public class MenuPrincipalActivity extends Activity {
    int idMateria = 0;
    int idBitacora = 0;
    int idTema = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idMateria", -1);
            idBitacora = extras.getInt("idBitacora", -1);
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido de la bitacora: " + idBitacora);
            Log.i(LogUtils.tag, "Id recibido de la materia: " + idMateria);
            Log.i(LogUtils.tag, "Id recibido del Tema: "+ idTema);

        }
    }

    public void lanzarVistaAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaMaterias (View view){
        Intent i = new Intent(this, MateriasListView.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddMateriaActivity.class);
        startActivity(i);
    }
    public void lanzarVistaVerItem (View view){
            final EditText entrada = new EditText(this);
            entrada.setText("0");
            new AlertDialog.Builder(this)
                    .setTitle("Selección de item")
                    .setMessage("Indica su id:")
                    .setView(entrada)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            int id = Integer.parseInt( entrada.getText().toString());
                            Intent i = new Intent( MenuPrincipalActivity.this, VerDatosTemasItemActivity.class);
                            i.putExtra("idItem", id);
                            i.putExtra("idBitacora", idBitacora);
                            i.putExtra("idMateria", idMateria);
                            i.putExtra("idTema", idTema);
                            startActivity( i );
                        }})
                    .setNegativeButton("Cancelar", null)
                    .show();
    }
    public void lanzarVistaNew (View view){
        Intent i = new Intent(this, NewActivity.class);
        i.putExtra("idBitacora", idBitacora);
        i.putExtra("idMateria", idMateria);
        i.putExtra("idTema", idTema);
        startActivity(i);
    }
}
