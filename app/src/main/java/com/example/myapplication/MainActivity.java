package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_navigation=findViewById(R.id.bottom_navigation);
        Todo todo=new Todo();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, todo).commit();
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch(item.getItemId()){
                    case R.id.todo:
                        selectedFragment=new Todo();
                        break;
                    case R.id.reminder:
                        selectedFragment=new Reminder();
                        break;
                    case R.id.search:
                        selectedFragment=new Search();
                        break;
                    case R.id.settings:
                        selectedFragment=new Settings();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }
}