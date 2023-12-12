package com.example.haloo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment cl = new ContactList();
        Fragment d = new Display();
        getSupportFragmentManager().beginTransaction().replace(R.id.leftFrame, cl).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.rightFrame, d).commit();

    }
}