package com.example.onecalculator;

import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "MainActivity";
  private TextView result;
  private TextView clear;
  private TextView positiveornegative;
  private TextView divide;
  private TextView percent;
  private TextView seven;
  private TextView eight;
  private TextView nine;
  private TextView time;
  private TextView four;
  private TextView five;
  private TextView six;
  private TextView minus;
  private TextView one;
  private TextView two;
  private TextView three;
  private TextView plus;
  private TextView zero;
  private TextView point;
  private TextView equal;
  private TextView onedividex;
  private TextView xsquare;
  private TextView xcube;
  private TextView xpowern;
  private TextView xex;
  private TextView squarerootx;
  private TextView cuberootx;
  private TextView nrootx;
  private TextView pi;
  private TextView sin;
  private TextView cos;
  private TextView tan;
  private TextView ee;
  private TextView arcsin;
  private TextView arccos;
  private TextView arctan;
  private TextView epowerx;
  private TextView tenpowerx;
  private TextView logten;
  private TextView ln;

  boolean empty;
  double num1, num2, num5, num8, num10, num13, num16, num19, num21, num24, num28, num32, num36,
      num41, num44, num47, num50, num54, num57, num60;
  int num20;
  String symbol;
  private GestureDetector Detector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    initClick();
    result.setText("0");
    Detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
      @Override
      public boolean onDown(MotionEvent e) {
        return false;
      }

      @Override
      public void onShowPress(MotionEvent e) {

      }

      @Override
      public boolean onSingleTapUp(MotionEvent e) {
        return false;
      }

      @Override
      public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
      }

      @Override
      public void onLongPress(MotionEvent e) {

      }

      @Override
      public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        String s = result.getText().toString();
        if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if ((e1.getX() - e2.getX()) > 50 || (e2.getX() - e1.getX()) > 50) {
          if (result.getText() == "0") {
            result.setText("Touch Error Please Restart");
          } else {
            result.setText(s.substring(0, s.length() - 1));
          }
          if (s.length() == 1) {
            result.setText("0");
          }
        }
        return false;
      }
    });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return Detector.onTouchEvent(event);
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    setContentView(R.layout.activity_main);
    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
      initView();
      initClick();
      inView();
      inClick();
    } else if (getResources().getConfiguration().orientation
        == Configuration.ORIENTATION_PORTRAIT) {
      initView();
      initClick();
    }
    result.setText("0");
  }

  private void initView() {
    result = this.findViewById(R.id.tv_result);
    clear = this.findViewById(R.id.tv_clear);
    positiveornegative = this.findViewById(R.id.tv_positiveornegative);
    percent = this.findViewById(R.id.tv_percent);
    divide = this.findViewById(R.id.tv_divide);
    seven = this.findViewById(R.id.tv_seven);
    eight = this.findViewById(R.id.tv_eight);
    nine = this.findViewById(R.id.tv_nine);
    time = this.findViewById(R.id.tv_time);
    four = this.findViewById(R.id.tv_four);
    five = this.findViewById(R.id.tv_five);
    six = this.findViewById(R.id.tv_six);
    minus = this.findViewById(R.id.tv_minus);
    one = this.findViewById(R.id.tv_one);
    two = this.findViewById(R.id.tv_two);
    three = this.findViewById(R.id.tv_three);
    plus = this.findViewById(R.id.tv_plus);
    zero = this.findViewById(R.id.tv_zero);
    point = this.findViewById(R.id.tv_point);
    equal = this.findViewById(R.id.tv_equal);
  }

  private void initClick() {
    clear.setOnClickListener(this);
    positiveornegative.setOnClickListener(this);
    divide.setOnClickListener(this);
    percent.setOnClickListener(this);
    seven.setOnClickListener(this);
    eight.setOnClickListener(this);
    nine.setOnClickListener(this);
    time.setOnClickListener(this);
    four.setOnClickListener(this);
    five.setOnClickListener(this);
    six.setOnClickListener(this);
    minus.setOnClickListener(this);
    one.setOnClickListener(this);
    two.setOnClickListener(this);
    three.setOnClickListener(this);
    plus.setOnClickListener(this);
    zero.setOnClickListener(this);
    point.setOnClickListener(this);
    equal.setOnClickListener(this);
  }

  private void inView() {
    onedividex = this.findViewById(R.id.tv_onedividex);
    xsquare = this.findViewById(R.id.tv_xsquare);
    xcube = this.findViewById(R.id.tv_xcube);
    xpowern = this.findViewById(R.id.tv_xpowern);
    xex = this.findViewById(R.id.tv_xex);
    squarerootx = this.findViewById(R.id.tv_squarerootx);
    cuberootx = this.findViewById(R.id.tv_cuberootx);
    nrootx = this.findViewById(R.id.tv_nrootx);
    pi = this.findViewById(R.id.tv_pi);
    sin = this.findViewById(R.id.tv_sin);
    cos = this.findViewById(R.id.tv_cos);
    tan = this.findViewById(R.id.tv_tan);
    ee = this.findViewById(R.id.tv_ee);
    arcsin = this.findViewById(R.id.tv_arcsin);
    arccos = this.findViewById(R.id.tv_arccos);
    arctan = this.findViewById(R.id.tv_arctan);
    epowerx = this.findViewById(R.id.tv_epowerx);
    tenpowerx = this.findViewById(R.id.tv_tenpowerx);
    logten = this.findViewById(R.id.tv_logten);
    ln = this.findViewById(R.id.tv_ln);
  }

  private void inClick() {
    onedividex.setOnClickListener(this);
    xsquare.setOnClickListener(this);
    xcube.setOnClickListener(this);
    xpowern.setOnClickListener(this);
    xex.setOnClickListener(this);
    squarerootx.setOnClickListener(this);
    cuberootx.setOnClickListener(this);
    nrootx.setOnClickListener(this);
    pi.setOnClickListener(this);
    sin.setOnClickListener(this);
    cos.setOnClickListener(this);
    tan.setOnClickListener(this);
    ee.setOnClickListener(this);
    arcsin.setOnClickListener(this);
    arccos.setOnClickListener(this);
    arctan.setOnClickListener(this);
    epowerx.setOnClickListener(this);
    tenpowerx.setOnClickListener(this);
    logten.setOnClickListener(this);
    ln.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    String str = result.getText().toString();
    switch (id) {
      case R.id.tv_ln: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num60 = Double.parseDouble(str);
          getLn();
        }
      }
      break;
      case R.id.tv_logten: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num57 = Double.parseDouble(str);
          getLogten();
        }
      }
      break;
      case R.id.tv_tenpowerx: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num54 = Double.parseDouble(str);
          getTenpowerx();
        }
      }
      break;
      case R.id.tv_epowerx: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num50 = Double.parseDouble(str);
          getEpowerx();
        }
      }
      break;
      case R.id.tv_arctan: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num47 = Double.parseDouble(str);
          getArcTanx();
        }
      }
      break;
      case R.id.tv_arccos: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num44 = Double.parseDouble(str);
          getArcCosx();
        }
      }
      break;
      case R.id.tv_arcsin: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num41 = Double.parseDouble(str);
          getArcSinx();
        }
      }
      break;
      case R.id.tv_ee: {
        double num40 = 2.71828183;
        result.setText("" + num40);
      }
      break;
      case R.id.tv_tan: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num36 = Double.parseDouble(str);
          getTanx();
        }
      }
      break;
      case R.id.tv_cos: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num32 = Double.parseDouble(str);
          getCosx();
        }
      }
      break;
      case R.id.tv_sin: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num28 = Double.parseDouble(str);
          getSinx();
        }
      }
      break;
      case R.id.tv_pi: {
        double num27 = Math.PI;
        result.setText("" + num27);
      }
      break;
      case R.id.tv_nrootx: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "ⁿ√x";
          result.setText("");
        }
      }
      break;
      case R.id.tv_cuberootx: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num24 = Double.parseDouble(str);
          getCuberootx();
        }
      }
      break;
      case R.id.tv_squarerootx: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num21 = Double.parseDouble(str);
          getSquarerootx();
        }
      }
      break;
      case R.id.tv_xex: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num19 = Double.parseDouble(str);
          num20 = (int) num19;
          getXex();
        }
      }
      break;
      case R.id.tv_xpowern: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "xⁿ";
          result.setText("");
        }
      }
      break;
      case R.id.tv_xcube: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num16 = Double.parseDouble(str);
          getXcube();
        }
      }
      break;
      case R.id.tv_xsquare: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num13 = Double.parseDouble(str);
          getXsquare();
        }
      }
      break;
      case R.id.tv_onedividex: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num10 = Double.parseDouble(str);
          getOnedividex();
        }
      }
      break;
      case R.id.tv_clear: {
        if (empty) {
          empty = false;
        }
        str = "";
        result.setText("0");
      }
      break;
      case R.id.tv_positiveornegative: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num5 = Double.parseDouble(str);
          getPositiveornegative();
        }
      }
      break;
      case R.id.tv_percent: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num8 = Double.parseDouble(str);
          getPercent();
        }
      }
      break;
      case R.id.tv_divide: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "÷";
          result.setText("");
        }
      }
      break;
      case R.id.tv_seven:
      case R.id.tv_eight:
      case R.id.tv_nine:
      case R.id.tv_four:
      case R.id.tv_five:
      case R.id.tv_six:
      case R.id.tv_one:
      case R.id.tv_two:
      case R.id.tv_three: {
        if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          if (result.getText() == "0") {
            result.setText(((TextView) v).getText());
          } else {
            result.setText(str + ((TextView) v).getText());
          }
        }
      }
      break;
      case R.id.tv_time: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "x";
          result.setText("");
        }
      }
      break;
      case R.id.tv_minus: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "—";
          result.setText("");
        }
      }
      break;
      case R.id.tv_plus: {
        if (result.getText() == "") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else if (result.getText() != "") {
          num1 = Double.parseDouble(str);
          symbol = "+";
          result.setText("");
        }
      }
      break;
      case R.id.tv_zero: {
        if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          if (result.getText() == "0") {
            result.setText(((TextView) v).getText());
          } else {
            result.setText(str + ((TextView) v).getText());
          }
        }
      }
      break;
      case R.id.tv_point: {
        if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          if (empty) {
            empty = false;
            str = "";
            result.setText("");
          }
          result.setText(str + ((TextView) v).getText());
        }
      }
      break;
      case R.id.tv_equal: {
        if (result.getText() == "Touch Error Please Restart") {
          result.setText("Touch Error Please Restart");
        } else {
          num2 = Double.parseDouble(str);
          getResult();
        }
      }
      break;
    }
  }

  public void getLn() {
    double num61 = Math.log(num60);
    int num62;
    if (num61 % 1 == 0) {
      num62 = (int) num61;
      result.setText("" + num62);
    } else {
      result.setText("" + num61);
    }
  }

  public void getLogten() {
    double num58 = Math.log10(num57);
    int num59;
    if (num58 % 1 == 0) {
      num59 = (int) num58;
      result.setText("" + num59);
    } else {
      result.setText("" + num58);
    }
  }

  public void getTenpowerx() {
    double num55 = Math.pow(10, num54);
    int num56;
    if (num55 % 1 == 0) {
      num56 = (int) num55;
      result.setText("" + num56);
    } else {
      result.setText("" + num55);
    }
  }

  public void getEpowerx() {
    double num51 = 2.71828183;
    double num52 = Math.pow(num51, num50);
    int num53;
    if (num52 % 1 == 0) {
      num53 = (int) num52;
      result.setText("" + num53);
    } else {
      result.setText("" + num52);
    }
  }

  public void getArcTanx() {
    double num48 = Math.toDegrees(Math.atan(num47));
    int num49;
    if (num48 % 1 == 0) {
      num49 = (int) num48;
      result.setText("" + num49);
    } else {
      result.setText("" + num48);
    }
  }

  public void getArcCosx() {
    double num45 = Math.toDegrees(Math.acos(num44));
    int num46;
    if (num45 % 1 == 0) {
      num46 = (int) num45;
      result.setText("" + num46);
    } else {
      result.setText("" + num45);
    }
  }

  public void getArcSinx() {
    double num42 = Math.toDegrees(Math.asin(num41));
    int num43;
    if (num42 % 1 == 0) {
      num43 = (int) num42;
      result.setText("" + num43);
    } else {
      result.setText("" + num42);
    }
  }

  public void getTanx() {
    double num37 = Math.toRadians(num36);
    double num38 = Math.tan(num37);
    int num39;
    if (num38 % 1 == 0) {
      num39 = (int) num38;
      result.setText("" + num39);
    } else {
      result.setText("" + num38);
    }
  }

  public void getCosx() {
    double num33 = Math.toRadians(num32);
    double num34 = Math.cos(num33);
    int num35;
    if (num34 % 1 == 0) {
      num35 = (int) num34;
      result.setText("" + num35);
    } else {
      result.setText("" + num34);
    }
  }

  public void getSinx() {
    double num29 = Math.toRadians(num28);
    double num30 = Math.sin(num29);
    int num31;
    if (num30 % 1 == 0) {
      num31 = (int) num30;
      result.setText("" + num31);
    } else {
      result.setText("" + num30);
    }
  }

  public void getCuberootx() {
    double xw = 3;
    double num25 = Math.pow(num24, 1 / xw);
    int num26;
    if (num25 % 1 == 0) {
      num26 = (int) num25;
      result.setText("" + num26);
    } else {
      result.setText("" + num25);
    }
  }

  public void getSquarerootx() {
    double num22 = Math.sqrt(num21);
    int num23;
    if (num22 % 1 == 0) {
      num23 = (int) num22;
      result.setText("" + num23);
    } else {
      result.setText("" + num22);
    }
  }

  public void getXex() {
    int num21 = 1;
    for (int i = num20; i > 0; i--) {
      num21 *= i;
    }
    result.setText("" + num21);
  }

  public void getXcube() {
    double num17 = num16 * num16 * num16;
    int num18;
    if (num17 % 1 == 0) {
      num18 = (int) num17;
      result.setText("" + num18);
    } else {
      result.setText("" + num17);
    }
  }

  public void getXsquare() {
    double num14 = num13 * num13;
    int num15;
    if (num14 % 1 == 0) {
      num15 = (int) num14;
      result.setText("" + num15);
    } else {
      result.setText("" + num14);
    }
  }

  public void getOnedividex() {
    double num11 = 1 / num10;
    int num12;
    if (num11 % 1 == 0) {
      num12 = (int) num11;
      result.setText("" + num12);
    } else {
      result.setText("" + num11);
    }
  }

  public void getPositiveornegative() {
    double num6 = 0 - num5;
    int num7;
    if (num6 % 1 == 0) {
      num7 = (int) num6;
      result.setText("" + num7);
    } else {
      result.setText("" + num6);
    }
  }

  public void getPercent() {
    double num9;
    num9 = num8 / 100;
    result.setText("" + num9);
  }

  public void getResult() {
    double num3 = 0;
    int num4;
    if (symbol == "÷") {
      num3 = num1 / num2;
    } else if (symbol == "x") {
      num3 = num1 * num2;
    } else if (symbol == "—") {
      num3 = num1 - num2;
    } else if (symbol == "+") {
      num3 = num1 + num2;
    } else if (symbol == "xⁿ") {
      num3 = Math.pow(num1, num2);
    } else if (symbol == "ⁿ√x") {
      num3 = Math.pow(num1, 1 / num2);
    } else {
      num3 = 0;
    }
    if (num3 % 1 == 0) {
      num4 = (int) num3;
      result.setText("" + num4);
    } else {
      result.setText("" + num3);
    }
  }
}