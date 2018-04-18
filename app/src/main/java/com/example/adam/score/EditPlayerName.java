package com.example.adam.score;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

public class EditPlayerName extends DialogFragment {

    public interface EditPlayerNameNoticeListener {
        void onDialogPositiveClick(DialogFragment dialog, int playerId);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    EditPlayerNameNoticeListener editPlayerNameNoticeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            editPlayerNameNoticeListener = (EditPlayerNameNoticeListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement EditPlayerNameNoticeListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        final int playerId = bundle.getInt("playerId");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.edit_name, null))
            .setTitle(R.string.edit_player_title)
                .setPositiveButton(R.string.player_name_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editPlayerNameNoticeListener.onDialogPositiveClick(EditPlayerName.this, playerId);
                    }
                })
                .setNegativeButton(R.string.player_name_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editPlayerNameNoticeListener.onDialogNegativeClick(EditPlayerName.this);
                    }
                });
        return builder.create();
    }
}
