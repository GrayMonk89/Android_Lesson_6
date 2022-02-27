package ru.gb.my_note_fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements OnDialogListener {


    @Override
    public void onDialogResult(String string) {

    }

    public void onDialogResult(String messageTittle, String messageBody){
        Toast.makeText(this, "Заголовок" + messageTittle + " \n" + "Тело заметки" + messageBody, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            NoteListFragment noteListFragment = NoteListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, noteListFragment).commit();
        }
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.list_of_note);
        if (backStackFragment != null && backStackFragment instanceof NoteFragment) {
            onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_about): {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.the_note, AboutFragment.newInstance()).addToBackStack("").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, AboutFragment.newInstance()).addToBackStack("").commit();
                }
                return true;
            }
            case (R.id.action_new_note):{
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.the_note, NewNoteFragment.newInstance()).addToBackStack("").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.list_of_note, NewNoteFragment.newInstance()).addToBackStack("").commit();
                };
                return true;
            }
            case (R.id.action_exit): {
                finish();
                return true;
            }
            case (R.id.action_quick_new_note): {
                new AddQuickNote().show(getSupportFragmentManager(), "Quick Note");
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}