package ru.gb.my_note_fragment;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private int noteIndex;

    public Note(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    public int getNoteIndex() {
        return noteIndex;
    }


    //region Автозаполнение от имплементации Parcelable
    protected Note(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
    //endregion
}
