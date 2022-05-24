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
import android.view.MenuItem;

import uz.example.rakhmatillo.ums_pro.R;
import uz.example.rakhmatillo.ums_pro.adapters.TarrifAdapter;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.models.TarrifsData;

import java.util.ArrayList;
import java.util.Objects;


public class TarrifActivity extends AppCompatActivity {
    private ArrayList<TarrifsData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uz.example.rakhmatillo.ums_pro.R.layout.activity_tarrif);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadData();
        RecyclerView list = findViewById(uz.example.rakhmatillo.ums_pro.R.id.tarrif_list_id);
        TarrifAdapter adapter = new TarrifAdapter(data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle(uz.example.rakhmatillo.ums_pro.R.string.tariffs);
    }

    private void loadData() {
        data = new ArrayList<>();
        data.add(new TarrifsData(R.drawable.ic_mobi_16, getString(R.string.mobi_16_title), getString(R.string.mobi_16_info), "*171*116*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_20, getString(R.string.mobi_20_title), getString(R.string.mobi_20_info), "*171*120*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_25, getString(R.string.mobi_25_title), getString(R.string.mobi_25_info), "*171*105*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_30, getString(R.string.mobi_30_title), getString(R.string.mobi_30_info), "*171*128*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_40, getString(R.string.mobi_40_title), getString(R.string.mobi_40_info), "*171*122*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_50, getString(R.string.mobi_50_title), getString(R.string.mobi_50_info), "*171*129*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_60, getString(R.string.mobi_60_title), getString(R.string.mobi_60_info), "*171*129*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_70, getString(R.string.mobi_70_title), getString(R.string.mobi_70_info), "*171*131*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_90, getString(R.string.mobi_90_title), getString(R.string.mobi_90_info), "*171*132*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_110, getString(R.string.mobi_110_title), getString(R.string.mobi_110_info), "*171*133*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_mobi_150, getString(R.string.mobi_150_title), getString(R.string.mobi_150_info), "*171*134*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_gap, getString(R.string.gap_yoq_title), getString(R.string.gap_yoq_info), "*171*100*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_gap_pro, getString(R.string.gap_yoq_pro_title), getString(R.string.gap_yoq_pro_info), "*171*101*010100180*1"));
        data.add(new TarrifsData(R.drawable.ic_chilla, getString(R.string.chilla_lite_title), getString(R.string.chilla_lite_info), "*171*042*010100180*1"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }
}
