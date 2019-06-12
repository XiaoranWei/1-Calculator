package com.example.onecalculator;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UnitC extends AppCompatActivity {
  String[] name1 = {"长度", "面积", "体积", "温度", "质量"};
  String[] name2 = {"千米", "米", "分米", "厘米", "毫米"};
  String[] name3 = {"平方千米", "平方米", "公顷", "英亩"};
  String[] name4 = {"立方米", "立方厘米", "升"};
  String[] name5 = {"摄氏度", "华氏度"};
  String[] name6 = {"克", "千克", "吨", "磅"};
  private Spinner type;
  private Spinner unit1;
  private Spinner unit2;
  private EditText number;
  private Button huansuan;
  private TextView answer;
  private Button restart;
  private ArrayAdapter<String> adapter;
  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_unit_c);
    context = this;
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();

    type = findViewById(R.id.sp_type);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name1);
    type.setAdapter(adapter);
    type.setOnItemSelectedListener(new SpinnerListener());
  }

  private void initListener() {
    huansuan.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        String sunit1 = unit1.getSelectedItem().toString();
        String sunit2 = unit2.getSelectedItem().toString();
        String stype = type.getSelectedItem().toString();
        String snumber = number.getText().toString();
        if (TextUtils.isEmpty(sunit1)) {
          return;
        }
        if (TextUtils.isEmpty(sunit2)) {
          return;
        }
        if (TextUtils.isEmpty(stype)) {
          return;
        }
        if (TextUtils.isEmpty(snumber)) {
          return;
        }
        restart.setOnClickListener(this);
        int id = v.getId();
        String str3 = type.getSelectedItem().toString();
        String str1 = unit1.getSelectedItem().toString();
        String str2 = unit2.getSelectedItem().toString();
        String str4 = number.getText().toString();
        int num0;
        switch (id) {
          case R.id.btn_huansuan: {
            if (str3 == "长度") {
              double num1 = Double.parseDouble(str4);
              double num2 = 0, num3 = 0;
              if (str1 == "千米") {
                num2 = num1 * 1000;
              } else if (str1 == "米") {
                num2 = num1;
              } else if (str1 == "分米") {
                num2 = num1 / 10;
              } else if (str1 == "厘米") {
                num2 = num1 / 100;
              } else if (str1 == "毫米") {
                num2 = num1 / 1000;
              }
              if (str2 == "千米") {
                num3 = num2 / 1000;
              } else if (str2 == "米") {
                num3 = num2;
              } else if (str2 == "分米") {
                num3 = num2 * 10;
              } else if (str2 == "厘米") {
                num3 = num2 * 100;
              } else if (str2 == "毫米") {
                num3 = num2 * 1000;
              }
              num0 = (int) num3;
              if (num3 % 1 == 0) {
                answer.setText("" + num0);
              } else {
                answer.setText("" + num3);
              }
            } else if (str3 == "面积") {
              double num4 = Double.parseDouble(str4);
              double num5 = 0, num6 = 0;
              if (str1 == "平方千米") {
                num5 = num4 * 1000000;
              } else if (str1 == "平方米") {
                num5 = num4;
              } else if (str1 == "公顷") {
                num5 = num4 * 10000;
              } else if (str1 == "英亩") {
                num5 = num4 / 0.0002471;
              }
              if (str2 == "平方千米") {
                num6 = num5 / 1000000;
              } else if (str2 == "平方米") {
                num6 = num5;
              } else if (str2 == "公顷") {
                num6 = num5 / 10000;
              } else if (str2 == "英亩") {
                num6 = num5 * 0.0002471;
              }
              num0 = (int) num6;
              if (num6 % 1 == 0) {
                answer.setText("" + num0);
              } else {
                answer.setText("" + num6);
              }
            } else if (str3 == "体积") {
              double num7 = Double.parseDouble(str4);
              double num8 = 0, num9 = 0;
              if (str1 == "立方米") {
                num8 = num7;
              } else if (str1 == "立方厘米") {
                num8 = num7 * 1000000;
              } else if (str1 == "升") {
                num8 = num7 * 1000;
              }
              if (str2 == "立方米") {
                num9 = num8;
              } else if (str2 == "立方厘米") {
                num9 = num8 / 1000000;
              } else if (str1 == "升") {
                num9 = num8 / 1000;
              }
              num0 = (int) num9;
              if (num9 % 1 == 0) {
                answer.setText("" + num0);
              } else {
                answer.setText("" + num9);
              }
            } else if (str3 == "温度") {
              double num10 = Double.parseDouble(str4);
              double num11 = 0, num12 = 0;
              if (str1 == "摄氏度") {
                num11 = num10;
              } else if (str1 == "华氏度") {
                num11 = (num10 - 32) / 1.8;
              }
              if (str2 == "摄氏度") {
                num12 = num11;
              } else if (str2 == "华氏度") {
                num12 = num11 * 1.8 + 32;
              }
              num0 = (int) num12;
              if (num12 % 1 == 0) {
                answer.setText("" + num0);
              } else {
                answer.setText("" + num12);
              }
            } else if (str3 == "质量") {
              double num13 = Double.parseDouble(str4);
              double num14 = 0, num15 = 0;
              if (str1 == "克") {
                num14 = num13;
              } else if (str1 == "千克") {
                num14 = num13 / 1000;
              } else if (str1 == "吨") {
                num14 = num13 / 1000000;
              } else if (str1 == "磅") {
                num14 = (num13 * 2.2046) / 1000;
              }
              if (str2 == "克") {
                num15 = num14;
              } else if (str2 == "千克") {
                num15 = num14 * 1000;
              } else if (str2 == "吨") {
                num15 = num14 * 1000000;
              } else if (str2 == "磅") {
                num15 = (num14 / 2.2046) * 1000;
              }
              num0 = (int) num15;
              if (num15 % 1 == 0) {
                answer.setText("" + num0);
              } else {
                answer.setText("" + num15);
              }
            }
          }
          break;
          case R.id.btn_restart: {
            number.setText("");
          }
          break;
        }
      }
    });
  }

  private void initView() {
    number = this.findViewById(R.id.et_number);
    huansuan = this.findViewById(R.id.btn_huansuan);
    answer = this.findViewById(R.id.tv_answer);
    restart = this.findViewById(R.id.btn_restart);
    number.setInputType(EditorInfo.TYPE_CLASS_PHONE);
  }

  private class SpinnerListener implements android.widget.AdapterView.OnItemSelectedListener {

    @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String str = name1[position];
      unit1 = findViewById(R.id.sp_unit1);
      unit2 = findViewById(R.id.sp_unit2);
      if (str == "长度") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name2);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);
      } else if (str == "面积") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name3);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);
      } else if (str == "体积") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name4);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);
      } else if (str == "温度") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name5);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);
      } else if (str == "质量") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name6);
        unit1.setAdapter(adapter);
        unit2.setAdapter(adapter);
      }
    }

    @Override public void onNothingSelected(AdapterView<?> parent) {
    }
  }
}
