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
  private Button house;
  private Button scalec;
  private Button run;
  private Button caroil;
  //private Button airtype;

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
    house = this.findViewById(R.id.btn_house);
    scalec = this.findViewById(R.id.btn_scalec);
    run = this.findViewById(R.id.btn_run);
    caroil = this.findViewById(R.id.btn_caroil);
    //airtype = this.findViewById(R.id.btn_airtype);
  }

  private void initClick() {
    bankir.setOnClickListener(this);
    unitc.setOnClickListener(this);
    house.setOnClickListener(this);
    scalec.setOnClickListener(this);
    run.setOnClickListener(this);
    caroil.setOnClickListener(this);
    //airtype.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    int id = v.getId();
    switch (id) {
      //case R.id.btn_airtype: {
      //  Intent intent = new Intent();
      //  intent.setClass(GongNeng.this, AirType.class);
      //  startActivity(intent);
      //}
      //break;
      case R.id.btn_scalec: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, ScaleC.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_bankir: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, BankIR.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_unitc: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, UnitC.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_house: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, House.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_run: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, Run.class);
        startActivity(intent);
      }
      break;
      case R.id.btn_caroil: {
        Intent intent = new Intent();
        intent.setClass(GongNeng.this, CarOil.class);
        startActivity(intent);
      }
      break;
    }
  }
}