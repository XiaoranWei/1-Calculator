package com.example.onecalculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GongNeng extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "GongNeng";
  private Button bankir;
  private Button unitc;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gong_neng);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initClick();
  }

  private void initView() {
    bankir = this.findViewById(R.id.btn_bankir);
    unitc = this.findViewById(R.id.btn_unitc);
  }

  private void initClick() {
    bankir.setOnClickListener(this);
    unitc.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    int id = v.getId();
    switch(id){
      case R.id.btn_bankir:{
        Intent intent=new Intent();
        intent.setClass(GongNeng.this,BankIR.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_unitc:{
        Intent intent=new Intent();
        intent.setClass(GongNeng.this,UnitC.class);
        startActivity(intent);
      }
      break;
    }
  }
}
