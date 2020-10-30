package py.com.misgruposv01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class AddMateriaActivity extends Activity {
    private String tag = "AppConoceme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(tag, "Inicia metodo en AddMateriaActivity.onCreate");
        //	int entero = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }
}
