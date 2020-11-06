package py.com.misgruposv01.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import py.com.misgruposv01.datos.Bitacora;
import py.com.misgruposv01.R;


public class BitacoraAdaptador extends BaseAdapter {

	private final Activity actividad;
	private final ArrayList<Bitacora> lista;

	public BitacoraAdaptador(Activity actividad, ArrayList<Bitacora> lista){
		super();
		this.actividad = actividad;
		this.lista = lista;
	}

	@Override
	public View getView(int posicion, View vista, ViewGroup padre) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_bitacoras, null, true);

		TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_elemento);
		nombreElemento.setText(lista.get(posicion).getAnho());

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
		Bitacora unaBitacora = lista.get(arg0);
		return unaBitacora.getId();
				
	}

	

}
