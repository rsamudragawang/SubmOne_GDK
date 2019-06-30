package ganargatul.com.submone;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieItems implements Parcelable {
    String title,desc;
    int photo;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhoto() {
        return photo;
    }

    public MovieItems(String title, String desc, int photo) {
        this.title = title;
        this.desc = desc;
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeInt(this.photo);
    }


    protected MovieItems(Parcel in) {
        this.title = in.readString();
        this.desc = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<MovieItems> CREATOR = new Parcelable.Creator<MovieItems>() {
        @Override
        public MovieItems createFromParcel(Parcel source) {
            return new MovieItems(source);
        }

        @Override
        public MovieItems[] newArray(int size) {
            return new MovieItems[size];
        }
    };
}
