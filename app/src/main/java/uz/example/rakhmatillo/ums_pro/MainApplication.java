package uz.example.rakhmatillo.ums_pro;

import android.app.Application;
import android.content.Context;


import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;

public class MainApplication  extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"uz"));
    }
}
