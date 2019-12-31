package com.example.bottomnav;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.bottomnav.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;


public class SwitchFragment extends Fragment {

    private EditText name;
    private Switch mode_switch;

    public static final String MyPreferences="nightModePrefs";
    public static final String KEY_ISNIGHTMODE="isNightMode";
    SharedPreferences sharedPreferences;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_switch, container, false);

        sharedPreferences = this.getActivity().getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        name= (EditText) view.findViewById(R.id.name);
        mode_switch= (Switch) view.findViewById(R.id.mode_switch);

        mode_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveNightModeState(true);
                    getFragmentManager().beginTransaction().detach(SwitchFragment.this).attach(SwitchFragment.this).addToBackStack(null).commit();
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveNightModeState(true);
                    getFragmentManager().beginTransaction().detach(SwitchFragment.this).attach(SwitchFragment.this).addToBackStack(null).commit();
                }
            }

        });
        return view;
    }

    private void saveNightModeState(boolean b) {
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putBoolean(KEY_ISNIGHTMODE, b);

        editor.apply();
    }

}
