package py.com.misgruposv01.activities.ui.ejercicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EjercicioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EjercicioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ejercicios");
    }

    public LiveData<String> getText()
    { return mText;}
}