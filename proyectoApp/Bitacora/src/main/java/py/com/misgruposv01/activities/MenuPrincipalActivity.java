package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import py.com.misgruposv01.R;
import py.com.misgruposv01.activities.AcercaDeActivity;
import py.com.misgruposv01.activities.AddMateriaActivity;
import py.com.misgruposv01.activities.Materia1Activity;

public class MenuPrincipalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void lanzarVistaAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }
    public void lanzarVistaMateria1 (View view){
        Intent i = new Intent(this, Materia1Activity.class);
        //i.putExtra("id", (long)0);
        startActivity(i);
    }

    public void lanzarVistaAddMateria (View view){
        Intent i = new Intent(this, AddMateriaActivity.class);
        startActivity(i);
    }
}
