package com.example.bottom_navi_try1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fn;
    private FragmentTransaction ft;
    private Frag_home frag_home;
    private Frag_cate frag_cate;
    private Frag_garden frag_garden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_cate:
                        setFrag(1);
                        break;
                    case R.id.action_garden:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        frag_home = new Frag_home();
        frag_cate = new Frag_cate();
        frag_garden = new Frag_garden();
        setFrag(0); //첫 프래그먼트 화면 지정

    }

    private void setFrag(int n){
        fn = getSupportFragmentManager();
        ft = fn.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, frag_home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag_cate);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag_garden);
                ft.commit();
                break;
        }
    }

}