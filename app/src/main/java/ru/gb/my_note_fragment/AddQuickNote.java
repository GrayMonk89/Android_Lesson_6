package ru.gb.my_note_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddQuickNote extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.quick_note, null);
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setTitle("Введите имя")
                .setView(view)
                .show();
        view.findViewById(R.id.addQuickNote).setOnClickListener(v -> {

            ( (MainActivity) getActivity()).onDialogResult(((EditText)view.findViewById(R.id.editTextTittleNote)).getText().toString(),
                                                           ((EditText)view.findViewById(R.id.editTextBodyNote)).getText().toString());
            dismiss();
        });

        return alertDialog;
    }
}
