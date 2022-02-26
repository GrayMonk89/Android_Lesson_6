package ru.gb.my_note_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class NewNoteFragment extends Fragment {
    Button button;

    public static NewNoteFragment newInstance() {
        NewNoteFragment fragment = new NewNoteFragment();
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_note_menu, menu);
        menu.findItem(R.id.action_new_note).setVisible(false);
        menu.findItem(R.id.action_exit).setVisible(false);

        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_note, container, false);
        button = view.findViewById(R.id.add_new_note);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.add_new_note){
                    Toast.makeText(requireContext(), "Типо добавил заметку", Toast.LENGTH_SHORT).show();
                    requireActivity().onBackPressed();
                }
            }
        });
    }
}