package com.example.coffeeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv  , tvcom , tvch , tvcr , tvqu , tvpr , tvpc;
    Button bt ;
    ImageButton ib1 , ib2 ;
    CheckBox cb1 , cb2 ;
    public float px;
    public int count ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView3);
        ib1  = findViewById(R.id.imageButton1);
        ib2  = findViewById(R.id.imageButton2);

        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);

        tvcom = findViewById(R.id.textView4);
        tvch = findViewById(R.id.textView5);
        tvcr = findViewById(R.id.textView6);
        tvqu = findViewById(R.id.textView7);
        tvpr = findViewById(R.id.textView8);
        tvpc = findViewById(R.id.textView9);


        bt = findViewById(R.id.button);




        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                updateTextView();
            }
        });

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 0) {
                    count--;
                    updateTextView();
                }
            }
        });



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    px = (float) (60.0 * count);
                    tvcom.setText("ORDER :");
                    if (cb1.isChecked()) {
                        tvch.setText("Chocolate : Oui");
                        px = px + (float) (20.0);


                    } else {
                        tvch.setText("Chocolate : Non");
                    }

                    if (cb2.isChecked()) {
                        tvcr.setText("Cream : Oui");
                        px = (float) (px + 40.0);


                    } else {
                        tvcr.setText("Cream : Non");
                    }

                    tvqu.setText("Quantity : " + count);

                    tvpr.setText("PRICE :");
                    tvpc.setText(px + " Da");
                } else {
                    Toast.makeText(MainActivity.this, "Please select the quantity you want", Toast.LENGTH_SHORT).show();
                }







            }
        });







    }

    private void updateTextView() {
        tv.setText(String.valueOf(count));
    }
}
