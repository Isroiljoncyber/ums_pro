package uz.example.rakhmatillo.ums_pro.dialogs;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import uz.example.rakhmatillo.ums_pro.R;

public class DialogBalance extends AnotherDialog {
//    TextView balance;
    TextView poslednaya_oplata;
    TextView moy_rasxod;
    TextView RemainTrafBtn;
    TextView moy_nomer;
    TextView vse_moi_nomer;
    TextView CheckActServ;

    public DialogBalance(Context context) {
        super(context, R.layout.fragment_balance);
//        balance  =findViewById(R.id.balance_in_fragment);
        poslednaya_oplata=findViewById(R.id.last_payment);
        moy_rasxod = findViewById(R.id.my_spendings);
        RemainTrafBtn = findViewById(R.id.RemainTrafBtn);
        moy_nomer=findViewById(R.id.my_number);
        vse_moi_nomer = findViewById(R.id.all_numbers);
        CheckActServ=findViewById(R.id.CheckActServ);

//        balance.setOnClickListener(v -> call("*100",v));
        poslednaya_oplata.setOnClickListener(view -> call("*171*1*2",view));
        moy_rasxod.setOnClickListener(view -> call("*171*1*3",view));
        RemainTrafBtn.setOnClickListener(view -> call("*102",view));
        moy_nomer.setOnClickListener(view -> call("*150",view));
        vse_moi_nomer.setOnClickListener(view -> call("*151",view));
        CheckActServ.setOnClickListener(view -> call("*140",view));

    }


//    public void setBalance(String balance) {
//        this.balance.setText(balance);
//    }

    public void setPoslednaya_oplata(String poslednaya_oplata) {
        this.poslednaya_oplata.setText(poslednaya_oplata);
    }

    public void setMoy_rasxod(String moy_rasxod) {
        this.moy_rasxod.setText(moy_rasxod);
    }

    public void RemainTrafBtn(String RemainTrafBtn) {
        this.RemainTrafBtn.setText(RemainTrafBtn);
    }




    public void setMoy_nomer(String moy_nomer) {
        this.moy_nomer.setText(moy_nomer);
    }

    public void setVse_moi_nomer(String vse_moi_nomer) {
        this.vse_moi_nomer.setText(vse_moi_nomer);
    }
    public void CheckActServ(String CheckActServ) {
        this.CheckActServ.setText(CheckActServ);
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
