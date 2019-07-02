package com.example.customalertdialog_passargumentsparcelable_callbackinterface.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserDetails implements Parcelable {

    private String fName,lName;
    private int age;

    public UserDetails(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fName);
        dest.writeString(this.lName);
        dest.writeInt(this.age);
    }

    protected UserDetails(Parcel in) {
        this.fName = in.readString();
        this.lName = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<UserDetails> CREATOR = new Parcelable.Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel source) {
            return new UserDetails(source);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };
}
