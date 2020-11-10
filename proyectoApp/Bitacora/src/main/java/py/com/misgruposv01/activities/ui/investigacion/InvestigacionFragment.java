package py.com.misgruposv01.activities.ui.investigacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import py.com.misgruposv01.R;


public class InvestigacionFragment extends Fragment {

    private InvestigacionViewModel investigacionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        investigacionViewModel =
                new ViewModelProvider(this).get(InvestigacionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_investigacion, container, false);
        final TextView textView = root.findViewById(R.id.text_inicio);
        investigacionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}