package com.android.calculator;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tv1, tv2;
    ImageButton backSpace;
    private final char ADDITION = '+';
    private final char SUB = '-';
    private final char MULTIPLY = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double value1 = Double.NaN;
    private double value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton btn0 = findViewById(R.id.btn0);
        AppCompatButton btn1 = findViewById(R.id.btn1);
        AppCompatButton btn2 = findViewById(R.id.btn2);
        AppCompatButton btn3 = findViewById(R.id.btn3);
        AppCompatButton btn4 = findViewById(R.id.btn4);
        AppCompatButton btn5 = findViewById(R.id.btn5);
        AppCompatButton btn6 = findViewById(R.id.btn6);
        AppCompatButton btn7 = findViewById(R.id.btn7);
        AppCompatButton btn8 = findViewById(R.id.btn8);
        AppCompatButton btn9 = findViewById(R.id.btn9);
        AppCompatButton btnAdd = findViewById(R.id.btn_add);
        AppCompatButton btnClear = findViewById(R.id.btn_clear);
        AppCompatButton btnDivide = findViewById(R.id.btn_divide);
        AppCompatButton btnDot = findViewById(R.id.btn_dot);
        AppCompatButton btnEqual = findViewById(R.id.btn_eql);
        AppCompatButton btnMultiply = findViewById(R.id.btn_multi);
        AppCompatButton btnPercent = findViewById(R.id.btn_percent);
        AppCompatButton btnPlusMinus = findViewById(R.id.btn_plus_minus);
        AppCompatButton btnSub = findViewById(R.id.btn_sub);
        backSpace = findViewById(R.id.btn_back_space);
        tv1 = findViewById(R.id.input_tv);
        tv2 = findViewById(R.id.output_tv);

        btn1.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}1", tv1.getText().toString()));
        });

        btn2.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}2", tv1.getText().toString()));
        });

        btn3.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}3", tv1.getText().toString()));
        });

        btn4.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}4", tv1.getText().toString()));
        });

        btn5.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}5", tv1.getText().toString()));
        });

        btn6.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}6", tv1.getText().toString()));
        });

        btn7.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}7", tv1.getText().toString()));
        });

        btn8.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}8", tv1.getText().toString()));
        });

        btn9.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}9", tv1.getText().toString()));
        });

        btn0.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}0", tv1.getText().toString()));
        });

        btnDot.setOnClickListener(v -> {
            error();
            tvLength();
            tv1.setText(MessageFormat.format("{0}.",tv1.getText().toString()));
        });

        btnPercent.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                ACTION = MODULUS;
                calculation();
                if (!isDecimal()) {
                    tv2.setText(MessageFormat.format("{0}%", value1));
                } else {
                    tv2.setText(MessageFormat.format("{0}%", (int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });

        btnAdd.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                ACTION = ADDITION;
                calculation();
                if (!isDecimal()) {
                    tv2.setText(MessageFormat.format("{0}+", value1));
                } else {
                    tv2.setText(MessageFormat.format("{0}+", (int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });

        btnSub.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                ACTION = SUB;
                calculation();
                if (!isDecimal()) {
                    tv2.setText(MessageFormat.format("{0}-", value1));
                } else {
                    tv2.setText(MessageFormat.format("{0}-", (int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });


        btnMultiply.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                ACTION = MULTIPLY;
                calculation();
                if (!isDecimal()) {
                    tv2.setText(MessageFormat.format("{0}*", value1));
                } else {
                    tv2.setText(MessageFormat.format("{0}*", (int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });

        btnDivide.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                ACTION = DIVISION;
                calculation();
                if (!isDecimal()) {
                    tv2.setText(MessageFormat.format("{0}/", value1));
                } else {
                    tv2.setText(MessageFormat.format("{0}/", (int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });

        btnPlusMinus.setOnClickListener(v -> {
            if (!tv2.getText().toString().isEmpty() || tv1.getText().toString().isEmpty()) {
                value1 = Double.parseDouble(tv1.getText().toString());
                ACTION = EXTRA;
                tv2.setText(MessageFormat.format("-{0}", tv1.getText().toString()));
                tv1.setText("");
            } else {
                tv2.setText("Error");
            }
        });

        btnEqual.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                calculation();
                ACTION = EQUAL;
                if (!isDecimal()) {
                    tv2.setText(String.valueOf(value1));
                } else {
                    tv2.setText(String.valueOf((int) value1));
                }
                tv1.setText(null);
            } else {
                tv2.setText("Error");
            }
        });

        btnClear.setOnClickListener(v -> {
            value1 = Double.NaN;
            value2 = Double.NaN;
            tv2.setText("");
            tv1.setText("");
        });

        backSpace.setOnClickListener(v -> {
            if (tv1.getText().length() > 0) {
                CharSequence charSequence = tv1.getText().toString();
                tv1.setText(charSequence.subSequence(0, charSequence.length() - 1));
            }
        });

    }

    private void error(){
        if (tv2.getText().toString().equals("Error")){
            tv2.setText("");
        }
    }

    private boolean isDecimal(){
        return value1 == (int) value1;
    }

    private void tvLength(){
        if (tv1.getText().toString().length() > 10){
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }

    private void calculation(){
        if (!Double.isNaN(value1)){
            if (tv2.getText().toString().charAt(0) == '-') {
                value1 = (-1) * value1;
            }
            value2 = Double.parseDouble(tv1.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUB:
                    value1 = value1 - value2;
                    break;
                case MULTIPLY:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case EXTRA:
                    value1 = (-1) * value1;
                    break;
                case MODULUS:
                    value1 = value1 % value2;
                    break;
                case EQUAL:
                    break;
            }
        } else {
            value1 = Double.parseDouble(tv1.getText().toString());
        }
    }
}