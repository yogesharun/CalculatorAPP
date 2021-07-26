package com.example.mycalculator;


import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button One,two,three,four,five,six,seven,eight,nine,zero,plus,sub,mul,div,mod,expo,dec,sign,clear,equal;
    ImageButton back;
    TextView value;
    char lastop=' ';
    String input,prev="";
    boolean decimal=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value=(TextView) findViewById(R.id.input);
        One=(Button)findViewById(R.id.oneBTN);
        two=(Button)findViewById(R.id.twoBTN);
        three=(Button)findViewById(R.id.threeBTN);
        four=(Button)findViewById(R.id.fourBTN);
        five=(Button)findViewById(R.id.fiveBTN);
        six=(Button)findViewById(R.id.sixBTN);
        seven=(Button)findViewById(R.id.sevenBTN);
        eight=(Button)findViewById(R.id.eightBTN);
        nine=(Button)findViewById(R.id.nineBTN);
        zero=(Button)findViewById(R.id.zeroBTN);
        plus=(Button)findViewById(R.id.addBTN);
        sub=(Button)findViewById(R.id.subtractBTN);
        mul=(Button)findViewById(R.id.multiplyBTN);
        div=(Button)findViewById(R.id.divideBTN);
        mod=(Button)findViewById(R.id.parenthesesBTN);
        expo=(Button)findViewById(R.id.exponentBTN);
        dec=(Button)findViewById(R.id.pointBTN);
        sign=(Button) findViewById(R.id.plusminusBTN);
        equal=(Button)findViewById(R.id.equalsBTN);
        clear=(Button)findViewById(R.id.clearBTN);
        back=(ImageButton) findViewById(R.id.backspaceBTN);
        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"1";
                value.setText(input);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"2";
                value.setText(input);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"3";
                value.setText(input);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"4";
                value.setText(input);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"5";
                value.setText(input);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"6";
                value.setText(input);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"7";
                value.setText(input);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"8";
                value.setText(input);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"9";
                value.setText(input);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString()+"0";
                value.setText(input);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('+');
                lastop='+';
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('-');
                lastop='-';
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('*');
                lastop='*';
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('/');
                lastop='/';
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('%');
                lastop='%';
            }
        });
        expo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opration('^');
                lastop='^';
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimal=true;
                input=value.getText().toString()+".";
                value.setText(input);
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString();
                if(input.charAt(0)=='-')
                    input=input.substring(1,input.length());
                else
                    input='-'+input;
                value.setText(input);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastop!=' ')
                    opration(lastop);
                if(decimal)
                {
                    input=value.getText().toString();
                    if(input.charAt(input.length()-1)=='.') {
                        input = input + '0';
                        value.setText(input);
                    }
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input=value.getText().toString();
                if(input.length()>1)
                    input=input.substring(0,input.length()-1);
                else
                    input="";
                value.setText(input);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev="";
                input="";
                lastop=' ';
                value.setText("");
            }
        });

    }
    public void opration(char opr)
    {

        if(prev.equals(""))
        {
            prev=value.getText().toString();
            value.setText("");
        }
        else
        {
            if(!decimal)
            {
                int value1=0,value2=0,result=0;
                value1=Integer.parseInt(prev);
                value2=Integer.parseInt(value.getText().toString());
                switch (opr)
                {
                    case '+':result=value1+value2;
                        prev="";
                        break;
                    case '-':result=value1-value2;
                        prev="";
                        break;
                    case '*':result=value1*value2;
                        prev="";
                        break;
                    case '/':result=value1/value2;
                        prev="";
                        break;
                    case '%':result=value1%value2;
                        prev="";
                        break;
                    case '^':result=(int)Math.pow(value1,value2);
                        prev="";
                        break;
                }
                value.setText(Integer.toString(result));
            }
            else
            {
                double value1=0,value2=0,result=0;
                input=value.getText().toString();
                if(prev.charAt(prev.length()-1)=='.')
                    prev=prev+'0';
                if(input.charAt(input.length()-1)=='.')
                    input=input+'0';
                value1=Double.parseDouble(prev);
                value2=Double.parseDouble(input);
                switch (opr)
                {
                    case '+':result=value1+value2;
                        prev="";
                        break;
                    case '-':result=value1-value2;
                        prev="";
                        break;
                    case '*':result=value1*value2;
                        prev="";
                        break;
                    case '/':result=value1/value2;
                        prev="";
                        break;
                    case '%':result=value1%value2;
                        prev="";
                        break;
                    case '^':result=(int)Math.pow(value1,value2);
                        prev="";
                        break;
                }
                value.setText(Double.toString(result));
            }




        }
    }
}