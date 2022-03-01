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
    int fNum;
    int sNum;
    int sum;
    Random rnd = new Random();
    int count = 0;
    TextView fNumView;
    TextView sNumView;
    TextView sNumView2;
    TextView fNumView2;
    TextView sNumView3;
    TextView fNumView3;
    int counter;

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
        if(count != 3) {
            count++;
        }
        else
        {
            count = 1;
        }
        TextView sNumView;
        TextView fNumView;

        fNumView = findViewById(R.id.fNum);
        sNumView = findViewById(R.id.sNum);
        int input;
        fNum = rnd.nextInt((99 - 10) + 1) + 1;
        sNum = rnd.nextInt((99 - 10) + 1) + 1;
        if(count == 1) {
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

        ImageView X_Or_Min;
        X_Or_Min = findViewById(R.id.XorMin);
        ImageView X_Or_Min2;
        X_Or_Min2 = findViewById(R.id.XorMin2);
        ImageView X_Or_Min3;
        X_Or_Min3 = findViewById(R.id.XorMin3);

        fNumView2 = findViewById(R.id.fNum2);
        sNumView2 = findViewById(R.id.sNum2);
        fNumView3 = findViewById(R.id.fNum3);
        sNumView3 = findViewById(R.id.sNum3);
        Button check1;
        Button check2;
        Button check3;
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        int input;
        EditText input1;
        String help;

        input1 = findViewById((R.id.Sum));
        //input
        help = input1.getText().toString();
        input = Integer.parseInt(help);

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
            sNumView3.setText(Integer.toString(sNum));
        }
        if(count == 3)
        {
            //Toast
            if(counter == 0) {
                Toast.makeText(this, "You got 0 out of 3 0%" , Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "You got " + counter + " out of 3 " + counter * (1/3.0) + "%", Toast.LENGTH_SHORT).show();
            }
        }
        game();
    }

    public void callGame(View view) {
        counter = 0;
        count = 0;
        //RESET ALL
        game();
    }
}