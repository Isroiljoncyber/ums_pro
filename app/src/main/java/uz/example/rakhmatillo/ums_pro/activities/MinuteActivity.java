/*coded by Mukhammadyunus and Rakhmatillo
 *rakhmatillo.topiboldiev@gmail.com
 *
 *
 * project ready date 30.07.2018*/
package uz.example.rakhmatillo.ums_pro.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import uz.example.rakhmatillo.ums_pro.R;


import java.util.ArrayList;
import java.util.Objects;

import uz.example.rakhmatillo.ums_pro.adapters.RecyclerViewAdapter;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.models.BaseData;
import uz.example.rakhmatillo.ums_pro.models.ButtonData;
import uz.example.rakhmatillo.ums_pro.models.MyData;

public class MinuteActivity extends AppCompatActivity {
    RecyclerView list;
    ArrayList<BaseData> data;
    RecyclerViewAdapter adapter;
    ScrollView scrollView;
    TextView text1;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uz.example.rakhmatillo.ums_pro.R.layout.activity_minute);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadData();
        list = findViewById(uz.example.rakhmatillo.ums_pro.R.id.list_minute);
        adapter = new RecyclerViewAdapter(data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        scrollView = findViewById(uz.example.rakhmatillo.ums_pro.R.id.scroll_minute);
        text1 = findViewById(uz.example.rakhmatillo.ums_pro.R.id.text_minute_name);
        text2 = findViewById(uz.example.rakhmatillo.ums_pro.R.id.text_minute_des);
        String formattedText = getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_package_info_name);
        Spanned result = Html.fromHtml(formattedText);
        text1.setText(result);
        String formatedText = getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_package_info_des);
        Spanned resul = Html.fromHtml(formatedText);
        text2.setText(resul);
        scrollView=findViewById(R.id.scroll_minute);
        getSupportActionBar().setTitle(getString(R.string.minutes_packages));
          }

    private void loadData() {
        data = new ArrayList<>();
        data.add(new ButtonData(getString(uz.example.rakhmatillo.ums_pro.R.string.checking_button), "*103"));
        data.add(new MyData("60 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word) , "4 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*60*010100180*1"));
        data.add(new MyData("120 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "7 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*120*010100180*1"));
        data.add(new MyData("180 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "10 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*180*010100180*1"));
        data.add(new MyData("300 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "16 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*300*010100180*1"));
        data.add(new MyData("900 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "37 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*900*010100180*1"));
        data.add(new MyData("1200 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "45 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*1200*010100180*1"));
        data.add(new MyData("1800 " + getString(uz.example.rakhmatillo.ums_pro.R.string.minutes_word), "62 000 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*103*1800*010100180*1"));
        data.add(new ButtonData(getString(uz.example.rakhmatillo.ums_pro.R.string.checking_button), "*104"));
        data.add(new MyData("SMS 100", "4 500 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*018*1*010100180*1"));
        data.add(new MyData("SMS 300", "10 500 " + getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*018*2*010100180*1"));
}
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
                case uz.example.rakhmatillo.ums_pro.R.id.menu_info:
                    if (scrollView.getVisibility() == View.GONE)
                        scrollView.setVisibility(View.VISIBLE);
                    else if (scrollView.getVisibility() == View.VISIBLE)
                        scrollView.setVisibility(View.GONE);
            }
            return super.onOptionsItemSelected(item);
        }


        @Override
        public void onBackPressed() {
            if (scrollView.getVisibility() == View.VISIBLE) {
                scrollView.setVisibility(View.GONE);
            } else if (scrollView.getVisibility() == View.GONE) {
                super.onBackPressed();
            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(uz.example.rakhmatillo.ums_pro.R.menu.menu_sms_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

        @Override
        protected void attachBaseContext (Context newBase){
            super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
        }
    }

