package com.example.et1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int fNum = 0;
    int sNum = 0;
    int sum = 0;
    Random rnd = new Random();
    int count = 0;
    TextView fNumView;
    TextView sNumView;
    TextView sNumView2;
    TextView fNumView2;
    TextView sNumView3;
    TextView fNumView3;
    int counter = 0;
    EditText input1;
    EditText input2;
    EditText input3;
    String help;
    ImageView X_Or_Min;
    ImageView X_Or_Min2;
    ImageView X_Or_Min3;
    Button check1;
    Button check2;
    Button check3;
    int Dan = 1; // disabling buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game();
    }

    public void game()
    {

        fNumView = findViewById(R.id.fNum);
        sNumView = findViewById(R.id.sNum);
        fNumView2 = findViewById(R.id.fNum2);
        sNumView2 = findViewById(R.id.sNum2);
        fNumView3 = findViewById(R.id.fNum3);
        sNumView3 = findViewById(R.id.sNum3);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);

        if(count != 3)
        {
            count++;
        }
        else
        {
            count = 1;
        }

        if(Dan == 1)
        {
            check2.setEnabled(false);
            check3.setEnabled(false);
        }
        else if(Dan == 2)
        {
            check2.setEnabled(true);
            check1.setEnabled(false);
            check3.setEnabled(false);
        }
        else if(Dan == 3)
        {
            check3.setEnabled(true);
            check2.setEnabled(false);
            check1.setEnabled(false);
        }




        fNumView = findViewById(R.id.fNum);
        sNumView = findViewById(R.id.sNum);
        int input;
        fNum = rnd.nextInt((99 - 10) + 1) + 10;
        sNum = rnd.nextInt((99 - 10) + 1) + 10;
        if(count == 1)
        {
            sum = fNum + sNum;
        }
        else
        {
            sum += sNum;
        }

        if(count == 1) {
            fNumView.setText(Integer.toString(fNum));
            sNumView.setText(Integer.toString(sNum));
        }

        if(count == 2)
        {
            sNumView2.setText(Integer.toString((sNum)));
        }

    }

    public void inputJava(View view) {
        Dan++;
        X_Or_Min = findViewById(R.id.XorMin);
        X_Or_Min2 = findViewById(R.id.XorMin2);
        X_Or_Min3 = findViewById(R.id.XorMin3);

        fNumView2 = findViewById(R.id.fNum2);
        sNumView2 = findViewById(R.id.sNum2);
        fNumView3 = findViewById(R.id.fNum3);
        sNumView3 = findViewById(R.id.sNum3);

        int input = 0;

        input1 = findViewById(R.id.Sum);
        input2 = findViewById(R.id.Sum2);
        input3 = findViewById(R.id.Sum3);
        //input
        if(count == 1)
        {
            help = input1.getText().toString();
            input = Integer.parseInt(help);
        }
        else if(count == 2)
        {
            help = input2.getText().toString();
            input = Integer.parseInt(help);
        }
        else if(count == 3)
        {
            help = input2.getText().toString();
            input = Integer.parseInt(help);
        }


        if(input == sum)
        {
            if(count == 1)
            {
                X_Or_Min.setImageResource(R.drawable.v);
                counter++;
            }
            else if(count == 2)
            {
                X_Or_Min2.setImageResource(R.drawable.v);
                counter++;
            }
            else if(count == 3)
            {
                X_Or_Min3.setImageResource(R.drawable.v);
                counter++;
            }
        }

        else
        {
            if(count == 1)
            {
                X_Or_Min.setImageResource(R.drawable.x);
            }
            else if(count == 2)
            {
                X_Or_Min2.setImageResource(R.drawable.x);
            }
            else if(count == 3)
            {
                X_Or_Min3.setImageResource(R.drawable.x);
            }
        }

        if(count == 1) {
            fNumView2.setText(Integer.toString(sum));
            sNumView2.setText(Integer.toString(sNum));
        }
        if(count == 2)
        {
            fNumView3.setText(Integer.toString(sum));
            sNum = rnd.nextInt((99 - 10) + 1) + 10;
            sNumView3.setText(Integer.toString(sNum));
        }

        if(count == 3)
        {
            //Toast
            if(counter == 0) {
                Toast.makeText(this, "You got 0/3 0%" , Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "You got " + counter + "/3 " + counter * (1/3.0) + "%", Toast.LENGTH_SHORT).show();
            }
        }


        game();
    }

    public void callGame(View view) {
        counter = 0;
        count = 0;
        fNumView.setText("");
        fNumView2.setText("");
        fNumView3.setText("");
        sNumView.setText("");
        sNumView2.setText("");
        sNumView3.setText("");
        X_Or_Min.setImageResource(0);
        X_Or_Min2.setImageResource(0);
        X_Or_Min3.setImageResource(0);
        Dan = 1;
        check1.setEnabled(true);
        check3.setEnabled(false);
        game();
    }
}