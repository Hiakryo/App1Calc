package com.awesome.app1_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText num1;
    private EditText num2;
    private TextView hasil;
    boolean add,min,multi,divide;
    private Button calculate;
    double x1,x2;
    public String opr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x1=0;
        x2=0;
        num1 = (EditText) findViewById (R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        hasil= (TextView) findViewById(R.id.textView6);
        calculate= (Button) findViewById(R.id.button);
        Spinner spin1= findViewById(R.id.operator1);
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this, R.array.operator, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);
        spin1.setOnItemSelectedListener(this);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().toString().isEmpty())
                {
                    num1.setText("0");
                    x1=0;
                }
                if(num2.getText().toString().isEmpty())
                {
                    num2.setText("0");
                    x2=0;
                }
                x1=0;
                x2=0;
                x1= Double.parseDouble(num1.getText().toString());
                x2= Double.parseDouble(num2.getText().toString());
                if(opr.equals("+"))
                {
                    hasil.setText(x1+x2+"");
                }
                else if(opr.equals("-"))
                {
                    hasil.setText(x1-x2+"");
                }
                else if(opr.equals("*"))
                {
                    hasil.setText(x1*x2+"");
                }
                else if(opr.equals("/"))
                {
                    hasil.setText(x1/x2+"");
                }
                //hasil.setText(x1/x2+"");
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        opr = adapterView.getItemAtPosition(i).toString();
     //   Toast.makeText(adapterView.getContext(),opr,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
