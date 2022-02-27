package ru.gb.my_note_fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
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


        return inflater.inflate(R.layout.fragment_new_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initView(view);

    }
    void initView(View view){
        view.findViewById(R.id.add_new_note).setOnClickListener(v -> {addNote();});
        view.findViewById(R.id.go_back).setOnClickListener(v ->{showDialogFragment();});
    }

    private void addNote() {

        NotificationManager notificationManager =(NotificationManager) requireActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("1", "VERY_VERY_IMPORTANT_CHANNEL", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Канал для важных сообщений!");
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Notification notification = new NotificationCompat.Builder(requireContext(),"1")
                .setContentTitle("Внимание! Очень важное сообщение!")
                .setContentText("Была добаленна новая заметка")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();

        notificationManager.notify(1, notification);


            Toast.makeText(requireContext(), "Типо добавил заметку", Toast.LENGTH_SHORT).show();
            requireActivity().onBackPressed();
    }

    void showDialogFragment() {
        new ChoiceDialogFragment().show(getActivity().getSupportFragmentManager(), "Dialog");
    }
}