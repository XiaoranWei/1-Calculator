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

public class AirType extends AppCompatActivity {
  String[] name1 = {"波音(美国)", "空客(欧洲)"};
  String[] name2 = {"737", "747", "777", "787"};
  String[] name3 =
      {"737-200(B732)", "737-300(B733)", "737-400(B734)", "737-500(B735)", "737-700(B737)",
          "737-800(B738)", "737-900(B739)", "737MAX8(B73M)"};
  String[] name4 = {"747-100(B741)", "747-200(B742)", "747-300(B743)", "747-8(B748)"};
  String[] name5 = {"777-200(B772)", "777-300(B773)"};
  String[] name6 = {"787-8'9'10 dreamliner"};
  String[] name7 = {"A320", "A330", "A350", "A380"};
  String[] name8 = {"A319", "A320", "A321", "A320NEO"};
  String[] name9 = {"A330-200", "A330-300"};
  String[] name10 = {"A350-900"};
  String[] name11 = {"A380-800"};
  private Spinner aircom;
  private Spinner airtype;
  private Spinner airtypeex;
  private Button check;
  private TextView answerone;
  private TextView answertwo;
  private ArrayAdapter<String> adapter;
  private ArrayAdapter<String> adap;
  private Context context;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_air_type);
    context = this;
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    initView();
    initListener();

    aircom = findViewById(R.id.sp_aircom);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name1);
    aircom.setAdapter(adapter);
    aircom.setOnItemSelectedListener(new SpinnerListener());

    airtype = findViewById(R.id.sp_airtype);
    adap = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name2);
    airtype.setAdapter(adap);
    airtype.setOnItemClickListener(new SpinnerListener());
  }

  private class SpinnerListener implements AdapterView.OnItemSelectedListener,
      AdapterView.OnItemClickListener {
    @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String s1 = name1[position];
      airtype = findViewById(R.id.sp_airtype);
      if (s1 == "波音(美国)") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name2);
        airtype.setAdapter(adapter);
      } else if (s1 == "空客(欧洲)") {
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name7);
        airtype.setAdapter(adapter);
      }
    }

    @Override public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      String s2 = name2[position];
      airtypeex = findViewById(R.id.sp_airtypeex);
      if (s2 == "737") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name3);
        airtypeex.setAdapter(adap);
      } else if (s2 == "747") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name4);
        airtypeex.setAdapter(adap);
      } else if (s2 == "777") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name5);
        airtypeex.setAdapter(adap);
      } else if (s2 == "787") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name6);
        airtypeex.setAdapter(adap);
      } else if (s2 == "A320") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name8);
        airtypeex.setAdapter(adap);
      } else if (s2 == "A330") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name9);
        airtypeex.setAdapter(adap);
      } else if (s2 == "A350") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name10);
        airtypeex.setAdapter(adap);
      } else if (s2 == "A380") {
        adap = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, name11);
        airtypeex.setAdapter(adap);
      }
    }
  }

  private void initListener() {
    check.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        String saircom = aircom.getSelectedItem().toString();
        String sairtype = airtype.getSelectedItem().toString();
        String sairtypees = airtypeex.getSelectedItem().toString();
        if (TextUtils.isEmpty(saircom)) {
          return;
        }
        if (TextUtils.isEmpty(sairtype)) {
          return;
        }
        if (TextUtils.isEmpty(sairtypees)) {
          return;
        }
      }
    });
  }

  private void initView() {
    check = this.findViewById(R.id.btn_check);
    answerone = this.findViewById(R.id.tv_answerone);
    answertwo = this.findViewById(R.id.tv_answertwo);
  }
}
