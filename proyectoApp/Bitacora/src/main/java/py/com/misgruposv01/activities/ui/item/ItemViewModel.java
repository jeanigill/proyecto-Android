package py.com.misgruposv01.activities.ui.item;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ItemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Item");
    }

    public LiveData<String> getText() {
        return mText;
    }
}