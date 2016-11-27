package com.example.jay.tablayoutapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
/**
 * Created by jay on 11/5/16.
 */
public class FragmentOne extends Fragment {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        private RadioButton  sedanRadio, suvRadio, minivanRadio;
        private RadioGroup  radiogroup;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentone, container, false);

        radiogroup=(RadioGroup)v.findViewById(R.id.RadioGroup);
        sedanRadio=(RadioButton)v.findViewById(R.id.radio1);
        suvRadio=(RadioButton)v.findViewById(R.id.radio2);
        minivanRadio=(RadioButton)v.findViewById(R.id.radio3);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                SharedPreferences shared= PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit=shared.edit();

                if(sedanRadio.isChecked())
                {
                    edit.putInt("prefer_int",30);
                    edit.commit();
                }
                if(suvRadio.isChecked())
                {
                    edit.putInt("prefer_int",40);
                    edit.commit();
                }
                if(minivanRadio.isChecked())
                {
                    edit.putInt("prefer_int",50);
                    edit.commit();
                }
            }
        });

        return v;
    }
}