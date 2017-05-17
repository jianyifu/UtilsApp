package com.fjy.utilsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView showConstraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        showConstraintLayout.setOnClickListener(this);
    }

    private void initViews() {
        showConstraintLayout = (TextView) findViewById(R.id.show_constraintLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_constraintLayout:
                startActivity(new Intent(this,ConstraintLayoutExample.class));
                break;
        }
    }
}
