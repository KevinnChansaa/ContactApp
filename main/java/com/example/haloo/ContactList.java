package com.example.haloo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ContactList extends Fragment {

    private static ArrayList<String> data = new ArrayList<>();
    private Button btnAddContact;
    private ListView listView;
    private View clView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        clView = inflater.inflate(R.layout.list_contact, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView = clView.findViewById(R.id.daftarKontak);
        Bundle bundle = getArguments();

        if(bundle != null){
            String fname = bundle.getString("fname");
            String pnumber = bundle.getString("pnumber");
            String result = fname + "\n" + pnumber;
//            System.out.println(result);
            data.add(result);
//            ArrayAdapter<String> ad = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
//            listView.setAdapter(ad);

            adapter.notifyDataSetChanged();
        }

        listView.setAdapter(adapter);

        btnAddContact = clView.findViewById(R.id.addContactBtn);

        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment d = new Display();
//                Bundle b = new Bundle();
//                bundle.putString("show", );
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rightFrame, new AddContact()).commit();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = data.get(i);

                Fragment d = new Display();
                Bundle b = new Bundle();
                b.putString("show", s );
                d.setArguments(b);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rightFrame, d).commit();
            }
        });

        return clView;
    }


}
