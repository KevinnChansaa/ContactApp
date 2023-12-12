package com.example.haloo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.haloo.R;

public class Display extends Fragment {
    private View dView;
    private TextView tampilanText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dView = inflater.inflate(R.layout.display, container, false);
        tampilanText = dView.findViewById(R.id.tampilan);
        Bundle b = getArguments();
        if(b!=null){
            String teks = b.getString("show");
            tampilanText.setText(teks);

        }else{
            tampilanText.setText("pilih kontak untuk menampilkan sesuatu");
        }

        return dView;
    }
}
