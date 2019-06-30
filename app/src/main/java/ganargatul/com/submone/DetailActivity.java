package ganargatul.com.submone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIES="EXTRA_MOVIES";
    TextView title,desc;
    ImageView photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        MovieItems movieItems= getIntent().getParcelableExtra(EXTRA_MOVIES);
        title = findViewById(R.id.detail_title);
        desc = findViewById(R.id.detail_desc);
        photo = findViewById(R.id.detail_poster);

        title.setText(movieItems.getTitle());
        desc.setText(movieItems.getDesc());
        photo.setImageResource(movieItems.getPhoto());
    }
}
