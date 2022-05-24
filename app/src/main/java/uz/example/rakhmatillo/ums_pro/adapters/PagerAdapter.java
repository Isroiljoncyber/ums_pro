package uz.example.rakhmatillo.ums_pro.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import uz.example.rakhmatillo.ums_pro.R;
import uz.example.rakhmatillo.ums_pro.fragments.ListFragment;
import uz.example.rakhmatillo.ums_pro.models.ListData;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter{
    private ArrayList<ListData> data;
    private int currentPage;
    private String[] titles = {"","","","",""};

    public PagerAdapter(FragmentManager fm, ArrayList<ListData> data, Context context) {
        super(fm);
        this.data=data;
        String[] titles = {context.getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.monthly_column),
                context.getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_column),
                context.getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.night_drive_column),
                context.getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.mini_column),
                context.getResources().getString(R.string.onNet_column),
        };
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return ListFragment.getInstance(data.get(position).getData());
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return 5;
    }

}