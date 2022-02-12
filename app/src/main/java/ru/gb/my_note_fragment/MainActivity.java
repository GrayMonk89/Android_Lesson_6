package ru.gb.my_note_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            NoteListFragment noteListFragment = NoteListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, noteListFragment).commit();
        }
    }
}