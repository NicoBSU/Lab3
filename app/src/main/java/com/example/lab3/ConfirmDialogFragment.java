package com.example.lab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment {


    private IConfirmCheck confirmCheck;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            confirmCheck = (IConfirmCheck) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("activity must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.areYouSure)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        confirmCheck.confirmButtonClicked();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        confirmCheck.cancelButtonClicked();
                    }
                });

        return builder.create();
    }
}
