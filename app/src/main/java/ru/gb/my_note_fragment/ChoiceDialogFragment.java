package ru.gb.my_note_fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ChoiceDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(requireContext())
                .setTitle("Go back")
                .setMessage("Want to go back?")
                .setPositiveButton("Да", (dialog, which) -> {
                    requireActivity().onBackPressed();
                })
                .setNegativeButton("Нет", (dialog, which) -> {
                    showToast("Нет");
                })
                .show();
    }

    void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}
