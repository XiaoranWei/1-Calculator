package com.example.onecalculator;

import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class BankIR extends AppCompatActivity {

  private static final String TAG = "BankIR";
  private TextView money;
  private TextView year;
  private TextView interestrate;
  private Button huansuan;
  private TextView answer;
  private Button restart;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bankir);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        String smoney = money.getText().toString();
        String syear = year.getText().toString();
        String sinterestrate = interestrate.getText().toString();
        if (TextUtils.isEmpty(smoney)) {
          money.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(syear)) {
          year.setError("不能为空 ");
          return;
        }
        if (TextUtils.isEmpty(sinterestrate)) {
          interestrate.setError("不能为空 ");
          return;
        }
        restart.setOnClickListener(this);
        int id = v.getId();
        String str1 = money.getText().toString();
        String str2 = year.getText().toString();
        String str3 = interestrate.getText().toString();
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double num3 = Double.parseDouble(str3);
        double num4 = num3 / 100;
        int num6, num7, num8;
        double num5 = num2 * (num1 * num4) + num1;
        num6 = (int) num5;
        num7 = (int) num1;
        num8 = (int) num2;
        switch (id) {
          case R.id.btn_huansuan: {
            if (num5 % 1 == 0 && num1 % 1 == 0 && num2 % 1 == 0) {//1
              answer.setText("在" + num8 + "年之后，你的存款将会从" + num7 + "变为" + num6);
            } else if (num5 % 1 == 0 && num1 % 1 == 0 && num2 % 1 != 0) {//2
              answer.setText("在" + num2 + "年之后，你的存款将会从" + num7 + "变为" + num6);
            } else if (num5 % 1 == 0 && num1 % 1 != 0 && num2 % 1 == 0) {//3
              answer.setText("在" + num8 + "年之后，你的存款将会从" + num1 + "变为" + num6);
            } else if (num5 % 1 == 0 && num1 % 1 != 0 && num2 % 1 != 0) {//4
              answer.setText("在" + num2 + "年之后，你的存款将会从" + num1 + "变为" + num6);
            } else if (num5 % 1 != 0 && num1 % 1 == 0 && num2 % 1 != 0) {//5
              answer.setText("在" + num2 + "年之后，你的存款将会从" + num7 + "变为" + num5);
            } else if (num5 % 1 != 0 && num1 % 1 != 0 && num2 % 1 == 0) {//6
              answer.setText("在" + num8 + "年之后，你的存款将会从" + num1 + "变为" + num5);
            } else if (num5 % 1 != 0 && num1 % 1 != 0 && num2 % 1 != 0) {//7
              answer.setText("在" + num2 + "年之后，你的存款将会从" + num1 + "变为" + num5);
            } else {//8
              answer.setText("在" + num2 + "年之后，你的存款将会从" + num1 + "变为" + num5);
            }
          }
          break;
          case R.id.btn_restart:{
            money.setText("");
            year.setText("");
            interestrate.setText("");
            answer.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    money = this.findViewById(R.id.et_money);
    year = this.findViewById(R.id.et_year);
    interestrate = this.findViewById(R.id.et_interestrate);
    huansuan = this.findViewById(R.id.btn_huansuan);
    answer = this.findViewById(R.id.tv_answer);
    restart = this.findViewById(R.id.btn_restart);
  }
}
