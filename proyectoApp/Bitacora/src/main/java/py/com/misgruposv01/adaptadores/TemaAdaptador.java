package py.com.misgruposv01.adaptadores;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv01.R;
import py.com.misgruposv01.datos.Materia;
import py.com.misgruposv01.datos.Tema;
import py.com.misgruposv01.utils.LogUtils;


public class TemaAdaptador extends BaseAdapter {

	private final Activity actividad;
	private final ArrayList<Tema> lista;

	public TemaAdaptador(Activity actividad, ArrayList<Tema> lista){
		super();
		this.actividad = actividad;
		this.lista = lista;
	}

	@Override
	public View getView(int posicion, View vista, ViewGroup padre) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_temas, null, true);

		TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_elemento);
		Log.i(LogUtils.tag, "Nombre elemento: "+lista.get(posicion).getNombre());
		Log.i(LogUtils.tag, "Nombre elemento: "+nombreElemento);
		nombreElemento.setText(lista.get(posicion).getNombre());

		return view;
	}
	
	@Override
	public int getCount() {		
		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {
		if(lista != null){
			return lista.get(arg0);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		Tema unTema = lista.get(arg0);
		return unTema.getId();
				
	}


}
