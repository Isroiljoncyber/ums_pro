/*coded by Mukhammadyunus and Rakhmatillo
 *rakhmatillo.topiboldiev@gmail.com
 *
 *
 * project ready date 30.07.2018*/

package uz.example.rakhmatillo.ums_pro.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import uz.example.rakhmatillo.ums_pro.R;

import io.paperdb.Paper;
import uz.example.rakhmatillo.ums_pro.LanguageChoiceList;
import uz.example.rakhmatillo.ums_pro.dialogs.DialogBalance;
import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(uz.example.rakhmatillo.ums_pro.R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(uz.example.rakhmatillo.ums_pro.R.id.toolbar);
        setSupportActionBar(toolbar);

        Paper.init(this);
        if (Build.VERSION.SDK_INT >= 23 && !check()) {
            this.requestPermissions(new String[]{"android.permission.CALL_PHONE"}, 1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(uz.example.rakhmatillo.ums_pro.R.id.activity_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, uz.example.rakhmatillo.ums_pro.R.string.open, uz.example.rakhmatillo.ums_pro.R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(uz.example.rakhmatillo.ums_pro.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, "uz"));
    }

    private boolean check() {
        return checkCallingOrSelfPermission("android.permission.CALL_PHONE") == PackageManager.PERMISSION_GRANTED;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == uz.example.rakhmatillo.ums_pro.R.id.call) {
            Intent calling = new Intent(Intent.ACTION_CALL);
            calling.setData(Uri.parse("tel:" + "+998971300909"));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            }
            startActivity(calling);
        } else if (id == uz.example.rakhmatillo.ums_pro.R.id.language) {

            LanguageChoiceList dialog = new LanguageChoiceList();
            dialog.show(getSupportFragmentManager(), "dialog");

        } else if (id == uz.example.rakhmatillo.ums_pro.R.id.nav_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "UMS Pro Dealer");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Go through the link and download it here https://play.google.com/store/apps/details?id=uz.example.rakhmatillo.ums_pro ");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        } else if (id == uz.example.rakhmatillo.ums_pro.R.id.tg_kanal) {

            Intent telegram_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/umsuzb2"));
            startActivity(telegram_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(uz.example.rakhmatillo.ums_pro.R.id.activity_main);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void clickBalance(View view) {

        call("*100",view);
//        DialogBalance dialog = new DialogBalance(this);
//        dialog.setBalance(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.balancee));
//        dialog.setMoy_nomer(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_numbers));
//        dialog.setPoslednaya_oplata(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.last_payment));
//        dialog.RemainTrafBtn(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.RemainTrafBtn));
//        dialog.CheckActServ(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.CheckActServ));
//
//        dialog.setMoy_rasxod(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_expenditure));
//        dialog.setVse_moi_nomer(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_all_numbers));
//        dialog.show();
    }

    public void clickTarrif(View view) {
        startActivity(new Intent(this, TarrifActivity.class));
    }

    public void clickService(View view) {
        startActivity(new Intent(this, ServiceActivity.class));
    }

    public void clickMinute(View view) {
        startActivity(new Intent(this, MinuteActivity.class));
    }

    public void clickInternet(View view) {
        startActivity(new Intent(this, InternetActivity.class));
    }

    public void clickUseful(View view) {
        DialogBalance dialog = new DialogBalance(this);
        dialog.setMoy_nomer(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_numbers));
        dialog.setPoslednaya_oplata(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.last_payment));
        dialog.RemainTrafBtn(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.RemainTrafBtn));
        dialog.CheckActServ(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.CheckActServ));

        dialog.setMoy_rasxod(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_expenditure));
        dialog.setVse_moi_nomer(getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.my_all_numbers));
        dialog.show();
    }

    public void rate_click(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) "market://details?id=uz.example.rakhmatillo.ums_pro")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        if (item.getItemId() == R.id.news_menu) {
            Intent news_intent = new Intent(this, NewsActivity.class);
            startActivity(news_intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static void call(String num, View view){
        String a = Uri.encode((String) "#");
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:" + num + a));
        if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        view.getContext().startActivity(call);
    }
}