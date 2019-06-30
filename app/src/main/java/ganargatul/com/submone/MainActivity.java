package ganargatul.com.submone;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ganargatul.com.submone.Adapter.MovieAdapter;



public class MainActivity extends AppCompatActivity {

    String[] title,desc;
    TypedArray photo;
    MovieAdapter mMovieAdapter;
    ArrayList<MovieItems> mMovieItems;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView =findViewById(R.id.list_item);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieItems movieItems = new MovieItems(mMovieItems.get(position).title,mMovieItems.get(position).desc,mMovieItems.get(position).photo);

                Intent detail = new Intent(MainActivity.this,DetailActivity.class);
                detail.putExtra(DetailActivity.EXTRA_MOVIES,movieItems);
                startActivity(detail);
            }
        });
        Prepare();
        Show();
    }


    private void Prepare() {
        title=getResources().getStringArray(R.array.title_movie);
        desc = getResources().getStringArray(R.array.desc_movie);
        photo=getResources().obtainTypedArray(R.array.photo_movie);
    }


    private void Show() {
        mMovieItems = new ArrayList<>();

        for(int i=0;i<title.length;i++){
            MovieItems movieItems = new MovieItems(title[i],desc[i],photo.getResourceId(i,-1));
            mMovieItems.add(movieItems);
        }
        mMovieAdapter = new MovieAdapter(MainActivity.this,mMovieItems);
        mListView.setAdapter(mMovieAdapter);
    }

}
