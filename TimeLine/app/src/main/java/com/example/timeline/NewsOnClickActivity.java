package com.example.timeline;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsOnClickActivity extends AppCompatActivity {

    TextView otvName;
    TextView otvDate;
    TextView otvText;
    TextView otvCommentsCount;
    TextView otvLikesCount;
    TextView otvRepostCount;
    TextView otvViewsCount;
    TextView likedByPeople;
    ImageView otvImage;

    News news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_on_click);

      //  ActionBar actionBar = getSupportActionBar();

        otvName = findViewById(R.id.autor);
        otvDate = findViewById(R.id.date);
        otvText = findViewById(R.id.vText);
        otvCommentsCount = findViewById(R.id.comment_text);
        otvLikesCount = findViewById(R.id.like_text);
        otvRepostCount = findViewById(R.id.shre_text);
        otvViewsCount = findViewById(R.id.view_text);
        likedByPeople = findViewById(R.id.likedbypeople);
        otvImage = findViewById(R.id.imageView3);

        news = getIntent().getParcelableExtra("news");


        otvName.setText(news.getName());
        otvDate.setText(news.getDate());
        otvText.setText(news.getText());
        otvViewsCount.setText(String.valueOf(news.getCommentsCount()));
        otvRepostCount.setText(String.valueOf(news.getRepostsCount()));
        otvLikesCount.setText(String.valueOf(news.getLikesCount()));
        otvCommentsCount.setText(String.valueOf(news.getCommentsCount()));
        likedByPeople.setText("Понравилось " + news.getLikesCount() + " людям");

        otvImage.setImageResource(news.getImg());

    }


}
