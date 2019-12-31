package com.drawingtest.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.drawingtest.R;
import com.drawingtest.ui.dialog.GridDialog;
import com.drawingtest.ui.component.GridView;

import java.util.Random;


public class GridActivity extends AppCompatActivity implements GridDialog.GridDialogListener {
    private Button set_size;
    private GridView gridView;
    private SeekBar grid_seek_bar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        gridView = (GridView) findViewById(R.id.grid_view);
        set_size = (Button) findViewById(R.id.set_size);
        grid_seek_bar= (SeekBar) findViewById(R.id.grid_seek_bar);

        grid_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int seekBarValue= grid_seek_bar.getProgress();
                gridView.setNumColumns(seekBarValue);
                gridView.setNumRows(seekBarValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        set_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridDialog views = new GridDialog();
                views.show(getSupportFragmentManager(),"Make Your Own Grid");
            }
        });

    }

    @Override
    public void makeChange(int column, int row) {
        gridView.setNumColumns(column);
        gridView.setNumRows(row);
    }

}


