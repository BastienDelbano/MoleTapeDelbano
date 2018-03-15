package org.diiage.delbano.moletapdelbano;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bastien on 15/03/2018.
 */

public class Session implements Parcelable {

    private String name;
    private Date date;
    private ArrayList<Score> scores;

    public Session(String name){
        this.name = name;
        this.date = new Date();
        this.scores = new ArrayList<>();

        Score score1 = new Score(5, 3, 0.15, 1.45, 0.94);
        Score score2 = new Score(7, 2, 0.56, 1.45, 0.43);
        Score score3 = new Score(3, 4, 0.34, 2.23, 0.23);
        this.scores.add(score1);
        this.scores.add(score2);
        this.scores.add(score3);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeSerializable(this.date);
        parcel.writeTypedList(this.scores);
    }

    public static final Parcelable.Creator<Session> CREATOR = new Parcelable.Creator<Session>()
    {
        @Override
        public Session createFromParcel(Parcel source)
        {
            return new Session(source);
        }

        @Override
        public Session[] newArray(int size)
        {
            return new Session[size];
        }
    };


    private Session(Parcel in) {
        this.name = in.readString();
        this.date = (Date)in.readSerializable();
        this.scores = in.createTypedArrayList(Score.CREATOR);
    }
}
