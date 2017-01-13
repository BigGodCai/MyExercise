package com.cfy.administrator.exercisecfy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.cfy.administrator.exercisecfy.R;

public class MySpinnerActivity extends AppCompatActivity {
    private Spinner spi1;
    private Spinner spi2;
    private Spinner spi3;

    private int[] mess={R.array.books,R.array.country};
    private int[] mess3={R.array.literature,R.array.computer};
    private int[] mess4={R.array.asia,R.array.europe};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spinner);
        spi1=(Spinner) findViewById(R.id.fLianDong);
        spi2=(Spinner) findViewById(R.id.sLianDong);
        spi3=(Spinner) findViewById(R.id.tLianDong);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MySpinnerActivity.this, R.array.first, android.R.layout.simple_spinner_item);
        spi1.setAdapter(adapter);

        spi1.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MySpinnerActivity.this,mess[position], android.R.layout.simple_spinner_item);
                spi2.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        spi2.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (spi1.getSelectedItemPosition()) {
                    case 0:
                        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MySpinnerActivity.this,mess3[position], android.R.layout.simple_spinner_item);
                        spi3.setAdapter(adapter);
                        break;

                    case 1:
                        ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(MySpinnerActivity.this,mess4[position], android.R.layout.simple_spinner_item);
                        spi3.setAdapter(adapter4);
                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

    }
}
