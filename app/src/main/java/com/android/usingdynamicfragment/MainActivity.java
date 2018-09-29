package com.android.usingdynamicfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.usingdynamicfragment.myFragments.FragmentOne;
import com.android.usingdynamicfragment.myFragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goFrg1Btn=findViewById(R.id.go_frg1_btn);
        Button goFrg2Btn=findViewById(R.id.go_frg2_btn);
        Button removeBtn=findViewById(R.id.remove_btn);
        goFrg1Btn.setOnClickListener(this);
        goFrg2Btn.setOnClickListener(this);
        removeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_frg1_btn:
                goToFragment(new FragmentOne());
                break;
            case R.id.go_frg2_btn:
                goToFragment(new FragmentTwo());
                break;
            case R.id.remove_btn:
                removeFragments();
                break;
        }
    }

    void goToFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frg_container,fragment)
                .commit();
    }

    void removeFragments(){
        for(Fragment frg:getSupportFragmentManager().getFragments()){
            getSupportFragmentManager().beginTransaction()
                    .remove(frg)
                    .commit();
        }
    }
}
