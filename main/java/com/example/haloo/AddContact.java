package com.example.haloo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddContact extends Fragment {
    private EditText fNameText, phoneNumText;
    private Button btnAddContact;
    private View acView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        acView = inflater.inflate(R.layout.contact_add, container, false);

        fNameText = acView.findViewById(R.id.fullName);
        phoneNumText = acView.findViewById(R.id.phoneNumber);

        btnAddContact = acView.findViewById(R.id.saveContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = fNameText.getText().toString();
                String pn = phoneNumText.getText().toString();
                if (fn.isEmpty() || pn.isEmpty()) {
                    // Show an alert if either fname or pnumber is empty
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Please enter both full name and phone number.");
                    builder.setPositiveButton("OK", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    Bundle b = new Bundle();
                    b.putString("fname", fn);
                    b.putString("pnumber", pn);
                    Fragment cl = new ContactList();
                    cl.setArguments(b);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.leftFrame, cl).commit();

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rightFrame, new Display()).commit();
                }
            }
        });

        return acView;
    }
}
