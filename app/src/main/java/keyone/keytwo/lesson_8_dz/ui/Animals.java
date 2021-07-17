package keyone.keytwo.lesson_8_dz.ui;

import android.os.Parcel;
import android.os.Parcelable;




    public class Animals  {

        private int imageIndex;
        private String animalName;

        public Animals(int imageIndex, String animalName) {
            this.imageIndex = imageIndex;
            this.animalName = animalName;
        }
        private void getanimalName() {
        }
        public int getImageIndex() {
            return imageIndex;
        }

        public String getAnimalName() {
            return animalName;
        }
//
//
//
//    @Override
//        public int describeContents() {
//            return 0;
//        }
//
//        public static final Creator<Animals> CREATOR = new Creator<Animals>() {
//            @Override
//            public Animals createFromParcel(Parcelable in) {
//                return new Animals(in);
//            }
//
//            @Override
//            public Animals createFromParcel(Parcel source) {
//                return null;
//            }
//
//            @Override
//            public Animals[] newArray(int size) {
//                return new Animals[size];
//            }
//        };
//
//        public int getImageIndex() {
//            return imageIndex;
//        }
//
//        public String getAnimalName() {
//            return animalName;
//        }

}