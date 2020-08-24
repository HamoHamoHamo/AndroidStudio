package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class TestClass implements Parcelable {

    int data10;
    String data20;

    public static final Creator<TestClass> CREATOR = new Creator<TestClass>() {
        //객체 복원
        @Override
        public TestClass createFromParcel(Parcel parcel) {
            TestClass t1 = new TestClass();
            t1.data10 = parcel.readInt();
            t1.data20 = parcel.readString();

            return t1;
        }

        @Override
        public TestClass[] newArray(int i) {
            return new TestClass[i];
        }
    };

    //객체를 Intent에 담을때 자동으로 호출되는 메서드
    // 첫 번째 매개 변수로 들어오는 Pacel 객체에 객체 복원을 위해 필요한 정보를 담는댜.
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(data10);
        parcel.writeString(data20);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
