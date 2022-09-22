package com.example.lect2_simplemath_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtOp1;
    private EditText edtOp2;
    private Button Button_One,Button_Two,Button_Three,Button_Four,Button_Five,Button_Six;
    private Button Button_Seven,Button_Eight,Button_Nine,Button_Null,Button_Dot,Button_Plus;
    private Button Button_Minus,Button_Times,Button_Divid,Button_Sqrt,Button_Equal,Button_Clear;
    private List<Float> num = new ArrayList<>();
    private List<String> op = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtOp1 = (EditText) findViewById(R.id.edtOp1);
        edtOp2 = (EditText) findViewById(R.id.edtOp2);

        Button_One = findViewById(R.id.Button_One);
        Button_One.setOnClickListener(this);
        Button_Two = findViewById(R.id.Button_Two);
        Button_Two.setOnClickListener(this);
        Button_Three = findViewById(R.id.Button_Three);
        Button_Three.setOnClickListener(this);
        Button_Four = findViewById(R.id.Button_Four);
        Button_Four.setOnClickListener(this);
        Button_Five = findViewById(R.id.Button_Five);
        Button_Five.setOnClickListener(this);
        Button_Six = findViewById(R.id.Button_Six);
        Button_Six.setOnClickListener(this);
        Button_Seven = findViewById(R.id.Button_Seven);
        Button_Seven.setOnClickListener(this);
        Button_Eight = findViewById(R.id.Button_Eight);
        Button_Eight.setOnClickListener(this);
        Button_Nine = findViewById(R.id.Button_Nine);
        Button_Nine.setOnClickListener(this);
        Button_Null = findViewById(R.id.Button_Null);
        Button_Null.setOnClickListener(this);
        Button_Dot = findViewById(R.id.Button_Dot);
        Button_Dot.setOnClickListener(this);
        Button_Plus = findViewById(R.id.Button_Plus);
        Button_Plus.setOnClickListener(this);
        Button_Minus = findViewById(R.id.Button_Minus);
        Button_Minus.setOnClickListener(this);
        Button_Times = findViewById(R.id.Button_Times);
        Button_Times.setOnClickListener(this);
        Button_Divid = findViewById(R.id.Button_Divid);
        Button_Divid.setOnClickListener(this);
        Button_Sqrt = findViewById(R.id.Button_Sqrt);
        Button_Sqrt.setOnClickListener(this);
        Button_Equal = findViewById(R.id.Button_Equal);
        Button_Equal.setOnClickListener(this);
        Button_Clear = findViewById(R.id.Button_Clear);
        Button_Clear.setOnClickListener(this);









    }

    public void onClick(View view){
        String result = "0";
        Button button = (Button) view;
        String button_txt = button.getText().toString();
        String record_txt = edtOp1.getText().toString();
        if (button_txt.equals("C")){
            record_txt = "";
            edtOp1.setText("");
            edtOp2.setText("0");
            return;
        }
        if(button_txt.equals("=")){
            result = calculate(record_txt);
            edtOp2.setText(result);
        }




        record_txt = record_txt + button_txt;


        edtOp1.setText(record_txt);
        edtOp2.setText(result);


    }

    String calculate (String record_txt){
        try{
            Context con = Context.enter();
            con.setOptimizationLevel(-1);
            Scriptable scrip = con.initStandardObjects();
            String result = con.evaluateString(scrip,record_txt,"Javascript", 1,null).toString();
            return result;
        }catch (Exception e){
            return "Error";
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}