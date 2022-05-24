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
import uz.example.rakhmatillo.ums_pro.adapters.ServiceListAdapter;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.models.ServiceData;

import java.util.ArrayList;
import java.util.Objects;

public class ServiceActivity extends AppCompatActivity {
    private ArrayList<ServiceData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uz.example.rakhmatillo.ums_pro.R.layout.activity_service);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        loadData();
        RecyclerView list = findViewById(uz.example.rakhmatillo.ums_pro.R.id.service_list);
        ServiceListAdapter adapter = new ServiceListAdapter(data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle(uz.example.rakhmatillo.ums_pro.R.string.services);
    }

    private void loadData() {
        data = new ArrayList<>();
        data.add(new ServiceData(getResources().getString(R.string.mutlaqo_cheksiz_title),getString(R.string.mutlaqo_cheksiz_info),"*165*1"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.vada_qilingan_tolov_title), getString(uz.example.rakhmatillo.ums_pro.R.string.vada_qilingan_tolov_info), "*111*32"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.chaqiriqni_kutish_title), getString(uz.example.rakhmatillo.ums_pro.R.string.chaqiriqni_kutish_info), "*43"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.sizga_qongiroq_qilishdi_title), getString(uz.example.rakhmatillo.ums_pro.R.string.sizga_qongiroq_qilishdi_info), "*111*0131"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.anitiaon_title), getString(uz.example.rakhmatillo.ums_pro.R.string.antiaon_info), "*111*0101"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.LTE_title), getString(uz.example.rakhmatillo.ums_pro.R.string.LTE_info), "*222*1"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.faollashtirilgan_xizmatlar_title), getString(uz.example.rakhmatillo.ums_pro.R.string.faollashtirilgan_xizmatlat_info), "*140"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.xalqaro_qongiroqlar_title), getString(uz.example.rakhmatillo.ums_pro.R.string.xalqaro_qongiroqlar_info), "*111*0021"));
        data.add(new ServiceData(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.super_nul_title), getString(uz.example.rakhmatillo.ums_pro.R.string.super_nul_info), "*166"));
    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
