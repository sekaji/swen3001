package com.drawingtest.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.drawingtest.ui.component.GridView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.drawingtest.R;

import java.util.Random;

public class GridDialog extends AppCompatDialogFragment {
    private EditText grid_column_num, grid_row_num;
    private CheckBox ran_generate;
    private GridDialogListener gridDialogListener;

    public int row, column;

    public interface GridDialogListener {
        void makeChange(int column, int row);
    }
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        try{
            gridDialogListener = (GridDialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Must Implement GridDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.activity_dialoggrid, null);

        grid_column_num = (EditText) v.findViewById(R.id.grid_column_num);
        grid_row_num = (EditText) v.findViewById(R.id.grid_row_num);
        ran_generate= (CheckBox) v.findViewById(R.id.ran_generate);

        builder.setView(v)
                .setTitle("Make Your Own Grid")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .setPositiveButton("Create Grid", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (ran_generate.isChecked()){
                            Random rand = new Random();
                            int row = rand.nextInt(50);
                            int column = rand.nextInt(50);
                            setColumn(column);
                            setRow(row);
                            gridDialogListener.makeChange(getColumn(),getRow());
                        }
                        else
                            {
                            setColumn(Integer.parseInt(grid_column_num.getText().toString()));
                            setRow(Integer.parseInt(grid_row_num.getText().toString()));
                            gridDialogListener.makeChange(getColumn(),getRow());
                        }
                    }
                });

        return builder.create();
    }

    public void setRow(int row){this.row = row;}

    public void setColumn(int column){this.column = column;}

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }
}

