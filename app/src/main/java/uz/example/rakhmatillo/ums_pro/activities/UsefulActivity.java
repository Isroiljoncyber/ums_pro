package uz.example.rakhmatillo.ums_pro.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Objects;

import uz.example.rakhmatillo.ums_pro.R;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;

public class UsefulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle(getResources().getString(R.string.useful));

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    public void ums_pro(View view) {
        Intent telegram_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/umsuzb2"));
        startActivity(telegram_intent);
    }

    @Override
    protected void attachBaseContext (Context newBase){
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }

    public void USSD_click(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=uz.nisd.ussduzbekistan2020ucellbeelineuzmobilemobiuzums")));
    }
}


