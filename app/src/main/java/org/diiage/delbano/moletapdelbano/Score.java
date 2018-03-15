package org.diiage.delbano.moletapdelbano;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Bastien on 15/03/2018.
 */

public class Score implements Parcelable {

    private int pointCount;
    private int moleMissed;
    private double reactionTimeMax;
    private double reactionTimeMin;
    private double reactionTimeAvg;

    public Score(int pointCount, int moleMissed, double reactionTimeMax, double reactionTimeMin, double reactionTimeAvg){
        this.pointCount = pointCount;
        this.moleMissed = moleMissed;
        this.reactionTimeMax = reactionTimeMax;
        this.reactionTimeMin = reactionTimeMin;
        this.reactionTimeAvg = reactionTimeAvg;
    }

    public int getPointCount() {
        return pointCount;
    }

    public int getMoleMissed() {
        return moleMissed;
    }

    public double getReactionTimeMax() {
        return reactionTimeMax;
    }

    public double getReactionTimeMin() {
        return reactionTimeMin;
    }

    public double getReactionTimeAvg() {
        return reactionTimeAvg;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public void setMoleMissed(int moleMissed) {
        this.moleMissed = moleMissed;
    }

    public void setReactionTimeMax(double reactionTimeMax) {
        this.reactionTimeMax = reactionTimeMax;
    }

    public void setReactionTimeMin(double reactionTimeMin) {
        this.reactionTimeMin = reactionTimeMin;
    }

    public void setReactionTimeAvg(double reactionTimeAvg) {
        this.reactionTimeAvg = reactionTimeAvg;
    }


    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pointCount);
        parcel.writeInt(this.moleMissed);
        parcel.writeDouble(this.reactionTimeMax);
        parcel.writeDouble(this.reactionTimeMin);
        parcel.writeDouble(this.reactionTimeAvg);
    }

    public Score(Parcel in) {
        this.pointCount = in.readInt();
        this.moleMissed = in.readInt();
        this.reactionTimeMax = in.readDouble();
        this.reactionTimeMin = in.readDouble();
        this.reactionTimeAvg = in.readDouble();
    }
}
