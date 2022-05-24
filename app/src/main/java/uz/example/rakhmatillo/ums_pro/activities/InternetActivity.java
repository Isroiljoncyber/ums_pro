/*coded by Mukhammadyunus and Rakhmatillo
 *rakhmatillo.topiboldiev@gmail.com
 *
 *
 * project ready date 30.07.2018*/
package uz.example.rakhmatillo.ums_pro.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import uz.example.rakhmatillo.ums_pro.R;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import uz.example.rakhmatillo.ums_pro.adapters.PagerAdapter;
import uz.example.rakhmatillo.ums_pro.dialogs.DialogMenu;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.models.BaseData;
import uz.example.rakhmatillo.ums_pro.models.ButtonData;
import uz.example.rakhmatillo.ums_pro.models.ListData;
import uz.example.rakhmatillo.ums_pro.models.MyData;


public class InternetActivity extends AppCompatActivity implements Serializable {
    private ArrayList<BaseData> oylik;
    private ArrayList<BaseData> tungi;
    private ArrayList<BaseData> tungiDrive;
    private ArrayList<BaseData> mini;
    private ArrayList<BaseData> onNet;
    private ArrayList<ListData> data;
    private ViewPager pager;
    ScrollView scrollView;
    TextView text1;
    TextView text2;

    @Override
    public void onBackPressed() {
        if (scrollView.getVisibility()==View.VISIBLE){
            scrollView.setVisibility(View.GONE);
        }
        else if(scrollView.getVisibility()==View.GONE){
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uz.example.rakhmatillo.ums_pro.R.layout.activity_internet);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadData();
        pager = findViewById(uz.example.rakhmatillo.ums_pro.R.id.pager_internet);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), data, this);
        pager.setAdapter(adapter);
        scrollView = findViewById(uz.example.rakhmatillo.ums_pro.R.id.scroll_internet);
        text1 = findViewById(uz.example.rakhmatillo.ums_pro.R.id.text_internet_name);
        text2 = findViewById(uz.example.rakhmatillo.ums_pro.R.id.text_internet_des);
        getSupportActionBar().setTitle(getString(uz.example.rakhmatillo.ums_pro.R.string.internet_packets));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }

    private void loadData() {
        loadLists();
        data = new ArrayList<>();
        data.add(new ListData(oylik));
        data.add(new ListData(tungi));
        data.add(new ListData(tungiDrive));
        data.add(new ListData(mini));
        data.add(new ListData(onNet));
    }

    private void loadLists() {
        oylik = new ArrayList<>();
        oylik.add(new ButtonData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.checking_button), "*171*019"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_300_packet), "8 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*1*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_500_packet), "9 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*7*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_1000_packet), "11 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*2*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_2000_packet), "17 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*5*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_3000_packet), "25 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*3*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_5000_packet), "33 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word),  "*171*019*4*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_10000_packet), "50 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word),  "*171*019*6*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_20000_packet), "55 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word),  "*171*019*8*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_30000_packet), "65 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word),  "*171*019*9*010100180*1"));
        oylik.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.internet_50000_packet), "75 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*019*10*010100180*1"));

        tungi = new ArrayList<>();
        tungi.add(new ButtonData(getString(uz.example.rakhmatillo.ums_pro.R.string.checking_button), "*203"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_1000), "5 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*1000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_2000), "9 500 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*2000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_3000), "12 500 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*3000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_5000), "17 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*5000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_10000), "22 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*10000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_20000), "33 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*20000*010100180*1"));
        tungi.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_50000), "44 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*203*50000*010100180*1"));


        tungiDrive = new ArrayList<>();
        tungiDrive.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_1_sutka), "5 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*200*1*010100180*1"));
        tungiDrive.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_7_sutka), "20 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*200*7*010100180*1"));
        tungiDrive.add(new MyData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_30_sutka), "60 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*200*30*010100180*1"));

        mini = new ArrayList<>();
        mini.add(new ButtonData(getString(uz.example.rakhmatillo.ums_pro.R.string.checking_button), "*102"));
        mini.add(new MyData(getResources().getString(R.string.day_200), "2 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*200*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_300), "3 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*300*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_500), "4 500 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*500*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_1000), "5 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*1000*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_2000), "9 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*2000*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_3000), "12 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*3000*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_5000), "16 500 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*5000*010100180*1"));
        mini.add(new MyData(getResources().getString(R.string.day_10000), "25 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*204*1*10000*010100180*1"));

        onNet = new ArrayList<>();
        onNet.add(new MyData(getResources().getString(R.string.onNet_300), "8 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*300*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_500), "9 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*500*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_1000), "11 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*1000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_2000), "17 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*2000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_3000), "25 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*3000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_5000), "33 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*5000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_10000), "50 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*10000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_20000), "55 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*20000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_30000), "65 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*30000*010100180*1"));
        onNet.add(new MyData(getResources().getString(R.string.onNet_50000), "75 000 "+getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sum_word), "*171*202*50000*010100180*1"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(uz.example.rakhmatillo.ums_pro.R.menu.menu_internet_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case uz.example.rakhmatillo.ums_pro.R.id.menu_setting:
                DialogMenu dialog = new DialogMenu(this);
                dialog.setOne(getString(uz.example.rakhmatillo.ums_pro.R.string.internet_settings_dialog_1_raw));
                dialog.setTwo(getString(uz.example.rakhmatillo.ums_pro.R.string.internet_settings_dialog_2_raw));
                dialog.setThree(getString(uz.example.rakhmatillo.ums_pro.R.string.internet_settings_dialog_3_raw));
                dialog.setFour(getString(uz.example.rakhmatillo.ums_pro.R.string.internet_settings_dialog_4_raw));
                dialog.show();
                return true;
            case uz.example.rakhmatillo.ums_pro.R.id.menu_info_internet:
                switch (pager.getCurrentItem()) {
                    case 0:
                        if (scrollView.getVisibility() == View.GONE) {
                            String formattedText = getString(uz.example.rakhmatillo.ums_pro.R.string.monthly_internet_name);
                            Spanned result = Html.fromHtml(formattedText);
                            text1.setText(result);
                            String formatedText = getString(uz.example.rakhmatillo.ums_pro.R.string.monthly_internet_des);
                            Spanned resul = Html.fromHtml(formatedText);
                            text2.setText(resul);
                            scrollView.setVisibility(View.VISIBLE);
                            break;
                        }
                        if (scrollView.getVisibility() == View.VISIBLE) {
                            scrollView.setVisibility(View.GONE);
                            break;
                        }
                    case 1:
                        if (scrollView.getVisibility() == View.GONE) {
                            String formattedText = getString(uz.example.rakhmatillo.ums_pro.R.string.night_internet_name);
                            Spanned result = Html.fromHtml(formattedText);
                            text1.setText(result);
                            String formatedText = getString(uz.example.rakhmatillo.ums_pro.R.string.night_internet_des);
                            Spanned resul = Html.fromHtml(formatedText);
                            text2.setText(resul);
                            scrollView.setVisibility(View.VISIBLE);
                            break;
                        }
                        if (scrollView.getVisibility() == View.VISIBLE) {
                            scrollView.setVisibility(View.GONE);
                            break;
                        }
                    case 2:
                        if (scrollView.getVisibility() == View.GONE) {
                            String formattedText = getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_internet_name);
                            Spanned result = Html.fromHtml(formattedText);
                            text1.setText(result);
                            String formatedText = getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_internet_des);
                            Spanned resul = Html.fromHtml(formatedText);
                            text2.setText(resul);
                            scrollView.setVisibility(View.VISIBLE);
                            break;
                        }
                        if (scrollView.getVisibility() == View.VISIBLE) {
                            scrollView.setVisibility(View.GONE);
                            break;
                        }
                }

        }
        return super.onOptionsItemSelected(item);
    }

}