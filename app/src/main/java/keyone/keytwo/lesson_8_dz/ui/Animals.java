package keyone.keytwo.lesson_8_dz.ui;

public class Animals Parcelable {

        private int imageIndex;
        private String animalName;

        public Animals(int imageIndex, String animalName){
            this.imageIndex = imageIndex;
            this.animalName = animalName;
        }

        protected Animals(Parcel in) {
            imageIndex = in.readInt();
            animalName = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(getImageIndex());
            dest.writeString(getanimalName());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Animals> CREATOR = new Creator<Animals>() {
            @Override
            public Animals createFromParcel(Parcel in) {
                return new Animals(in);
            }

            @Override
            public Animals[] newArray(int size) {
                return new Animals[size];
            }
        };

        public int getImageIndex() {
            return imageIndex;
        }

        public String getAnimalName() {
            return animalName;
        }
    }
}
