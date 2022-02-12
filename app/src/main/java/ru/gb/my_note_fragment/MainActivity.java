package ru.gb.my_note_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment)getSupportFragmentManager()
                .findFragmentById(R.id.list_of_note);
        if(backStackFragment!=null&&backStackFragment instanceof NoteFragment){
            onBackPressed();
        }
    }
}