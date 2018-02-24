package com.example.vladimirbabenko.android_base_homeworks.lesson4;

import android.os.Parcel;
import android.os.Parcelable;

public class ColorObject implements Parcelable {
    private int red;
    private int green;
    private int blue;

    protected ColorObject(Parcel in) {
        red = in.readInt();
        green = in.readInt();
        blue = in.readInt();
    }

    public static final Creator<ColorObject> CREATOR = new Creator<ColorObject>() {
        @Override public ColorObject createFromParcel(Parcel in) {
            return new ColorObject(in);
        }

        @Override public ColorObject[] newArray(int size) {
            return new ColorObject[size];
        }
    };

    public ColorObject(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(red);
        dest.writeInt(green);
        dest.writeInt(blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
