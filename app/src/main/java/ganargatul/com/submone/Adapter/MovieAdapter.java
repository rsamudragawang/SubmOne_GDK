package ganargatul.com.submone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ganargatul.com.submone.MovieItems;
import ganargatul.com.submone.R;

public class MovieAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<MovieItems> mMovieItems;

    public MovieAdapter(Context mContext, ArrayList<MovieItems> mMovieItems) {
        this.mContext = mContext;
        this.mMovieItems = mMovieItems;
    }

    @Override
    public int getCount() {
        return mMovieItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_items,parent,false);

        MovieViewHolder movieViewHolder = new MovieViewHolder(convertView);
        MovieItems movieItems =(MovieItems) getItem(position);
        movieViewHolder.bind(movieItems);
        return convertView;
    }

    public class MovieViewHolder{
        TextView mTittle;
        ImageView mPhoto;
        MovieViewHolder(View view){
            mTittle = view.findViewById(R.id.txt_title);
            mPhoto = view.findViewById(R.id.img_movie_items);

        }

        void bind(MovieItems movieItems){
                mTittle.setText(movieItems.getTitle());
                mPhoto.setImageResource(movieItems.getPhoto());
        }
    }
}
