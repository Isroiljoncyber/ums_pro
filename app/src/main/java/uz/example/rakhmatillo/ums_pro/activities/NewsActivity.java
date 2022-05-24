package uz.example.rakhmatillo.ums_pro.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import uz.example.rakhmatillo.ums_pro.R;
import uz.example.rakhmatillo.ums_pro.adapters.News_ListAdapter;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.models.NewsData;

public class NewsActivity extends AppCompatActivity  implements News_ListAdapter.OnItemClickListener{
    RecyclerView list;
    News_ListAdapter adapter;
    ArrayList<NewsData> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    setTitle(getResources().getString(R.string.news));

    load();

    list = findViewById(R.id.news_recyclerView);
    adapter = new News_ListAdapter(this, data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        News_ListAdapter.setOnItemClickListener(this);
}
    private void load() {
            data = new ArrayList<>();
            data.add(new NewsData(
                    getString(R.string.tiklash_text_news),
                    getString(R.string.tiklash_title_news),
                    "https://mobi.uz/uz/news/2020/20865/"
            ));
            data.add(new NewsData(
                    getString(R.string.tarif_text_news),
                    getString(R.string.tarif_title_news),
                    "https://mobi.uz/uz/news/2020/20863/"
            ));
        data.add(new NewsData(
                getString(R.string.TV_text_news),
                getString(R.string.TV_title_news),
                "https://mobi.uz/uz/news/2020/20655/"
        ));
        }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    protected void attachBaseContext (Context newBase){
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }

    @Override
    public void onItemClick(NewsData data) {

    }
}
