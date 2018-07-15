package azdev.cgpacalculator.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

import azdev.cgpacalculator.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

import static butterknife.OnItemSelected.Callback.NOTHING_SELECTED;

/**
 * A simple {@link Fragment} subclass.
 */
public class CGPA extends Fragment {

    private final static String TAG = "CGPA";

    private View view;
    private String[] size_values;


    private double g1,g2,g3,g4,g5,g6,g7,g8,g9,g10 = 0;
    private double ch1,sum1,ch2,sum2,ch3,sum3,ch4,sum4,ch5,sum5,ch6,sum6,ch7,sum7,ch8,sum8,ch9,sum9,ch10,sum10 = 0;
    private double chsum,gpsum,gpa,cgpa,pgpa,pch,spcgpa,spcgpa2,spch = 0;

    @BindView(R.id.tv_gpa) TextView tv_gpa;
    @BindView(R.id.tv_cgpa) TextView tv_cgpa;
    @BindView(R.id.b_calculate) Button b_calculate;
    @BindView(R.id.b_reset) Button b_reset;
    @BindView(R.id.et_gpa) EditText et_gpa;
    @BindView(R.id.et_ch) EditText et_ch;

    @BindView(R.id.s_grade1) Spinner s_grade1;
    @BindView(R.id.tv_gp1)  TextView tv_gp1;
    @BindView(R.id.tv_g1)   TextView tv_g1;
    @BindView(R.id.s_ch1)   Spinner s_ch1;

    @BindView(R.id.s_grade2) Spinner s_grade2;
    @BindView(R.id.tv_gp2)  TextView tv_gp2;
    @BindView(R.id.tv_g2)   TextView tv_g2;
    @BindView(R.id.s_ch2)   Spinner s_ch2;

    @BindView(R.id.s_grade3) Spinner s_grade3;
    @BindView(R.id.tv_gp3)  TextView tv_gp3;
    @BindView(R.id.tv_g3)   TextView tv_g3;
    @BindView(R.id.s_ch3)   Spinner s_ch3;

    @BindView(R.id.s_grade4) Spinner s_grade4;
    @BindView(R.id.tv_gp4)  TextView tv_gp4;
    @BindView(R.id.tv_g4)   TextView tv_g4;
    @BindView(R.id.s_ch4)   Spinner s_ch4;

    @BindView(R.id.s_grade5) Spinner s_grade5;
    @BindView(R.id.tv_gp5)  TextView tv_gp5;
    @BindView(R.id.tv_g5)   TextView tv_g5;
    @BindView(R.id.s_ch5)   Spinner s_ch5;

    @BindView(R.id.s_grade6) Spinner s_grade6;
    @BindView(R.id.tv_gp6)  TextView tv_gp6;
    @BindView(R.id.tv_g6)   TextView tv_g6;
    @BindView(R.id.s_ch6)   Spinner s_ch6;

    @BindView(R.id.s_grade7) Spinner s_grade7;
    @BindView(R.id.tv_gp7)  TextView tv_gp7;
    @BindView(R.id.tv_g7)   TextView tv_g7;
    @BindView(R.id.s_ch7)   Spinner s_ch7;

    @BindView(R.id.s_grade8) Spinner s_grade8;
    @BindView(R.id.tv_gp8)  TextView tv_gp8;
    @BindView(R.id.tv_g8)   TextView tv_g8;
    @BindView(R.id.s_ch8)   Spinner s_ch8;

    @BindView(R.id.s_grade9) Spinner s_grade9;
    @BindView(R.id.tv_gp9)  TextView tv_gp9;
    @BindView(R.id.tv_g9)   TextView tv_g9;
    @BindView(R.id.s_ch9)   Spinner s_ch9;

    @BindView(R.id.s_grade10) Spinner s_grade10;
    @BindView(R.id.tv_gp10)  TextView tv_gp10;
    @BindView(R.id.tv_g10)   TextView tv_g10;
    @BindView(R.id.s_ch10)   Spinner s_ch10;

    public CGPA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_cg, container, false);
        ButterKnife.bind(this,view);

        setupSpinner();

        return view;
    }

    private void setupSpinner(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.gred_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ch_array, android.R.layout.simple_spinner_item);
        size_values = getResources().getStringArray(R.array.ch_array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_grade1.setAdapter(adapter);
        s_ch1.setAdapter(adapter2);

        s_grade2.setAdapter(adapter);
        s_ch2.setAdapter(adapter2);

        s_grade3.setAdapter(adapter);
        s_ch3.setAdapter(adapter2);

        s_grade4.setAdapter(adapter);
        s_ch4.setAdapter(adapter2);

        s_grade5.setAdapter(adapter);
        s_ch5.setAdapter(adapter2);

        s_grade6.setAdapter(adapter);
        s_ch6.setAdapter(adapter2);

        s_grade7.setAdapter(adapter);
        s_ch7.setAdapter(adapter2);

        s_grade8.setAdapter(adapter);
        s_ch8.setAdapter(adapter2);

        s_grade9.setAdapter(adapter);
        s_ch9.setAdapter(adapter2);

        s_grade10.setAdapter(adapter);
        s_ch10.setAdapter(adapter2);
    }

    @OnClick(R.id.b_calculate)
    public void calcSum(){

        sumTotal();
    }

    @OnClick(R.id.b_reset)
    public void resetHolder(){

        resetData();
    }

    @OnItemSelected(R.id.s_grade1)
    void onItemSelected1(int position){

        switch (position){

            case 0:
                g1 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g1 = 4;
                break;
            case 2:
                g1 = 3.67;
                break;
            case 3:
                g1 = 3.33;
                break;
            case 4:
                g1 = 3;
                break;
            case 5:
                g1 = 2.67;
                break;
            case 6:
                g1 = 2.33;
                break;
            case 7:
                g1 = 2;
                break;
            case 8:
                g1 = 1.7;
                break;
            case 9:
                g1 = 1.33;
                break;
            case 10:
                g1 = 1;
                break;
            case 11:
                g1 = 0.7;
                break;

        }

        tv_g1.setText(String.valueOf(g1));
        sum1 = ch1 * g1 ;
        tv_gp1.setText(String.valueOf(sum1));

    }

    @OnItemSelected(R.id.s_ch1)
    void onItemSelected1_1(int postion){


        ch1 = Double.valueOf(size_values[postion]);
        sum1 = ch1 * g1 ;
        tv_gp1.setText(String.valueOf(sum1));
    }

    @OnItemSelected(value = R.id.s_grade1, callback = NOTHING_SELECTED)
    void onNothingSelected1_2() {

        g1 = 0;
        ch1 = 0;
    }

    @OnItemSelected(R.id.s_grade2)
    void onItemSelected2(int position){

        switch (position){

            case 0:
                g2 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g2 = 4;
                break;
            case 2:
                g2 = 3.67;
                break;
            case 3:
                g2 = 3.33;
                break;
            case 4:
                g2 = 3;
                break;
            case 5:
                g2 = 2.67;
                break;
            case 6:
                g2 = 2.33;
                break;
            case 7:
                g2 = 2;
                break;
            case 8:
                g2 = 1.7;
                break;
            case 9:
                g2 = 1.33;
                break;
            case 10:
                g2 = 1;
                break;
            case 11:
                g2 = 0.7;
                break;

        }

        tv_g2.setText(String.valueOf(g2));
        sum2 = ch2 * g2 ;
        tv_gp2.setText(String.valueOf(sum2));

    }

    @OnItemSelected(R.id.s_ch2)
    void onItemSelected2_1(int postion){


        ch2 = Double.valueOf(size_values[postion]);
        sum2 = ch2 * g2 ;
        tv_gp2.setText(String.valueOf(sum2));
    }

    @OnItemSelected(R.id.s_grade3)
    void onItemSelected3(int position){

        switch (position){

            case 0:
                g3 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g3 = 4;
                break;
            case 2:
                g3 = 3.67;
                break;
            case 3:
                g3 = 3.33;
                break;
            case 4:
                g3 = 3;
                break;
            case 5:
                g3 = 2.67;
                break;
            case 6:
                g3 = 2.33;
                break;
            case 7:
                g3 = 2;
                break;
            case 8:
                g3 = 1.7;
                break;
            case 9:
                g3 = 1.33;
                break;
            case 10:
                g3 = 1;
                break;
            case 11:
                g3 = 0.7;
                break;

        }

        tv_g3.setText(String.valueOf(g3));
        sum3 = ch3 * g3 ;
        tv_gp3.setText(String.valueOf(sum3));

    }

    @OnItemSelected(R.id.s_ch3)
    void onItemSelected3_1(int postion){


        ch3 = Double.valueOf(size_values[postion]);
        sum3 = ch3 * g3 ;
        tv_gp3.setText(String.valueOf(sum3));
    }

    @OnItemSelected(R.id.s_grade4)
    void onItemSelected4(int position){

        switch (position){

            case 0:
                g4 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g4 = 4;
                break;
            case 2:
                g4 = 3.67;
                break;
            case 3:
                g4 = 3.33;
                break;
            case 4:
                g4 = 3;
                break;
            case 5:
                g4 = 2.67;
                break;
            case 6:
                g4 = 2.33;
                break;
            case 7:
                g4 = 2;
                break;
            case 8:
                g4 = 1.7;
                break;
            case 9:
                g4 = 1.33;
                break;
            case 10:
                g4 = 1;
                break;
            case 11:
                g4 = 0.7;
                break;

        }

        tv_g4.setText(String.valueOf(g4));
        sum4 = ch4 * g4 ;
        tv_gp4.setText(String.valueOf(sum4));

    }

    @OnItemSelected(R.id.s_ch4)
    void onItemSelected4_1(int postion){


        ch4 = Double.valueOf(size_values[postion]);
        sum4 = ch4 * g4 ;
        tv_gp4.setText(String.valueOf(sum4));
    }

    @OnItemSelected(R.id.s_grade5)
    void onItemSelected5(int position){

        switch (position){

            case 0:
                g5 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g5 = 4;
                break;
            case 2:
                g5 = 3.67;
                break;
            case 3:
                g5 = 3.33;
                break;
            case 4:
                g5 = 3;
                break;
            case 5:
                g5 = 2.67;
                break;
            case 6:
                g5 = 2.33;
                break;
            case 7:
                g5 = 2;
                break;
            case 8:
                g5 = 1.7;
                break;
            case 9:
                g5 = 1.33;
                break;
            case 10:
                g5 = 1;
                break;
            case 11:
                g5 = 0.7;
                break;

        }

        tv_g5.setText(String.valueOf(g5));
        sum5 = ch5 * g5 ;
        tv_gp5.setText(String.valueOf(sum5));

    }

    @OnItemSelected(R.id.s_ch5)
    void onItemSelected5_1(int postion){


        ch5 = Double.valueOf(size_values[postion]);
        sum5 = ch5 * g5 ;
        tv_gp5.setText(String.valueOf(sum5));
    }

    @OnItemSelected(R.id.s_grade6)
    void onItemSelected6(int position){

        switch (position){

            case 0:
                g6 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g6 = 4;
                break;
            case 2:
                g6 = 3.67;
                break;
            case 3:
                g6 = 3.33;
                break;
            case 4:
                g6 = 3;
                break;
            case 5:
                g6 = 2.67;
                break;
            case 6:
                g6 = 2.33;
                break;
            case 7:
                g6 = 2;
                break;
            case 8:
                g6 = 1.7;
                break;
            case 9:
                g6 = 1.33;
                break;
            case 10:
                g6 = 1;
                break;
            case 11:
                g6 = 0.7;
                break;

        }

        tv_g6.setText(String.valueOf(g6));
        sum6 = ch6 * g6 ;
        tv_gp6.setText(String.valueOf(sum6));

    }

    @OnItemSelected(R.id.s_ch6)
    void onItemSelected6_1(int postion){


        ch6 = Double.valueOf(size_values[postion]);
        sum6 = ch6 * g6 ;
        tv_gp6.setText(String.valueOf(sum6));
    }

    @OnItemSelected(R.id.s_grade7)
    void onItemSelected7(int position){

        switch (position){

            case 0:
                g7 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g7 = 4;
                break;
            case 2:
                g7 = 3.67;
                break;
            case 3:
                g7 = 3.33;
                break;
            case 4:
                g7 = 3;
                break;
            case 5:
                g7 = 2.67;
                break;
            case 6:
                g7 = 2.33;
                break;
            case 7:
                g7 = 2;
                break;
            case 8:
                g7 = 1.7;
                break;
            case 9:
                g7 = 1.33;
                break;
            case 10:
                g7 = 1;
                break;
            case 11:
                g7 = 0.7;
                break;

        }

        tv_g7.setText(String.valueOf(g7));
        sum7 = ch7 * g7 ;
        tv_gp7.setText(String.valueOf(sum7));

    }

    @OnItemSelected(R.id.s_ch7)
    void onItemSelected7_1(int postion){


        ch7 = Double.valueOf(size_values[postion]);
        sum7 = ch7 * g7 ;
        tv_gp7.setText(String.valueOf(sum7));
    }

    @OnItemSelected(R.id.s_grade8)
    void onItemSelected8(int position){

        switch (position){

            case 0:
                g8 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g8 = 4;
                break;
            case 2:
                g8 = 3.67;
                break;
            case 3:
                g8 = 3.33;
                break;
            case 4:
                g8 = 3;
                break;
            case 5:
                g8 = 2.67;
                break;
            case 6:
                g8 = 2.33;
                break;
            case 7:
                g8 = 2;
                break;
            case 8:
                g8 = 1.7;
                break;
            case 9:
                g8 = 1.33;
                break;
            case 10:
                g8 = 1;
                break;
            case 11:
                g8 = 0.7;
                break;

        }

        tv_g8.setText(String.valueOf(g8));
        sum8 = ch8 * g8 ;
        tv_gp8.setText(String.valueOf(sum8));

    }

    @OnItemSelected(R.id.s_ch8)
    void onItemSelected8_1(int postion){


        ch8 = Double.valueOf(size_values[postion]);
        sum8 = ch8 * g8 ;
        tv_gp8.setText(String.valueOf(sum8));
    }

    @OnItemSelected(R.id.s_grade9)
    void onItemSelected9(int position){

        switch (position){

            case 0:
                g9 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g9 = 4;
                break;
            case 2:
                g9 = 3.67;
                break;
            case 3:
                g9 = 3.33;
                break;
            case 4:
                g9 = 3;
                break;
            case 5:
                g9 = 2.67;
                break;
            case 6:
                g9 = 2.33;
                break;
            case 7:
                g9 = 2;
                break;
            case 8:
                g9 = 1.7;
                break;
            case 9:
                g9 = 1.33;
                break;
            case 10:
                g9 = 1;
                break;
            case 11:
                g9 = 0.7;
                break;

        }

        tv_g9.setText(String.valueOf(g9));
        sum9 = ch9 * g9 ;
        tv_gp9.setText(String.valueOf(sum9));

    }

    @OnItemSelected(R.id.s_ch9)
    void onItemSelected9_1(int postion){


        ch9 = Double.valueOf(size_values[postion]);
        sum9 = ch9 * g9 ;
        tv_gp9.setText(String.valueOf(sum9));
    }

    @OnItemSelected(R.id.s_grade10)
    void onItemSelected10(int position){

        switch (position){

            case 0:
                g10 = 0;
                Log.d(TAG,"Nothing selected");
                break;
            case 1:
                g10 = 4;
                break;
            case 2:
                g10 = 3.67;
                break;
            case 3:
                g10 = 3.33;
                break;
            case 4:
                g10 = 3;
                break;
            case 5:
                g10 = 2.67;
                break;
            case 6:
                g10 = 2.33;
                break;
            case 7:
                g10 = 2;
                break;
            case 8:
                g10 = 1.7;
                break;
            case 9:
                g10 = 1.33;
                break;
            case 10:
                g10 = 1;
                break;
            case 11:
                g10 = 0.7;
                break;

        }

        tv_g10.setText(String.valueOf(g10));
        sum10 = ch10 * g10 ;
        tv_gp10.setText(String.valueOf(sum10));

    }

    @OnItemSelected(R.id.s_ch10)
    void onItemSelected10_1(int postion){


        ch10 = Double.valueOf(size_values[postion]);
        sum10 = ch10 * g10 ;
        tv_gp10.setText(String.valueOf(sum10));
    }

    private void sumTotal(){
        String etgpa,etch;

        etgpa = et_gpa.getText().toString();
        etch = et_ch.getText().toString();


        if((etgpa.equals("") && etch.equals("")) || (etgpa.equals("") && !etch.equals("")) || (!etgpa.equals("") && etch.equals("")) ){
            pgpa = 0;
            pch = 0;
        }else{
            pgpa = Double.parseDouble(etgpa);
            pch = Double.parseDouble(etch);
        }


        chsum = ch1 + ch2 + ch3 + ch4 + ch5 + ch6 + ch7 + ch8 + ch9 + ch10;
        gpsum = sum1 + sum2 + sum3 + sum4 + sum5 + sum6 + sum7 + sum8 + sum9 + sum10;

        spcgpa = pgpa * pch ;
        spch = pch + chsum;
        spcgpa2 = spcgpa + gpsum;

        DecimalFormat point = new DecimalFormat("0.000");

        gpa = gpsum / chsum;
        cgpa = spcgpa2 / spch;


        tv_gpa.setText(String.valueOf(point.format(gpa)));
        tv_cgpa.setText(String.valueOf(point.format(cgpa)));

    }

    private void resetData() {

        tv_gpa.setText(null);
        tv_cgpa.setText(null);
        et_gpa.setText(null);
        et_ch.setText(null);

        g1 = 0;
        tv_g1.setText(String.valueOf(g1));
        sum1 = 0;
        tv_gp1.setText(String.valueOf(sum1));
        s_grade1.setSelection(0);
        s_ch1.setSelection(0);

        g2 = 0;
        tv_g2.setText(String.valueOf(g2));
        sum2 = 0;
        tv_gp2.setText(String.valueOf(sum2));
        s_grade2.setSelection(0);
        s_ch2.setSelection(0);

        g3 = 0;
        tv_g3.setText(String.valueOf(g3));
        sum3 = 0;
        tv_gp3.setText(String.valueOf(sum3));
        s_grade3.setSelection(0);
        s_ch3.setSelection(0);

        g4 = 0;
        tv_g4.setText(String.valueOf(g4));
        sum4 = 0;
        tv_gp4.setText(String.valueOf(sum4));
        s_grade4.setSelection(0);
        s_ch4.setSelection(0);

        g5 = 0;
        tv_g5.setText(String.valueOf(g5));
        sum5 = 0;
        tv_gp5.setText(String.valueOf(sum5));
        s_grade5.setSelection(0);
        s_ch5.setSelection(0);

        g6 = 0;
        tv_g6.setText(String.valueOf(g6));
        sum6 = 0;
        tv_gp6.setText(String.valueOf(sum6));
        s_grade6.setSelection(0);
        s_ch6.setSelection(0);

        g7 = 0;
        tv_g7.setText(String.valueOf(g7));
        sum7 = 0;
        tv_gp7.setText(String.valueOf(sum7));
        s_grade7.setSelection(0);
        s_ch7.setSelection(0);

        g8 = 0;
        tv_g8.setText(String.valueOf(g8));
        sum8 = 0;
        tv_gp8.setText(String.valueOf(sum8));
        s_grade8.setSelection(0);
        s_ch8.setSelection(0);

        g9 = 0;
        tv_g9.setText(String.valueOf(g9));
        sum9 = 0;
        tv_gp9.setText(String.valueOf(sum9));
        s_grade9.setSelection(0);
        s_ch9.setSelection(0);

        g10 = 0;
        tv_g10.setText(String.valueOf(g10));
        sum10 = 0;
        tv_gp10.setText(String.valueOf(sum10));
        s_grade10.setSelection(0);
        s_ch10.setSelection(0);
    }
}
