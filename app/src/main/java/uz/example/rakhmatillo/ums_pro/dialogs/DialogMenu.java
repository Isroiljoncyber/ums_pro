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

public class DialogMenu extends AnotherDialog {
    TextView one;
    TextView two;
    TextView three;
    TextView four;

    public DialogMenu(Context context) {
        super(context, R.layout.menu_dialog_fragment);
        one = findViewById(R.id.sozlamalar);
        two = findViewById(R.id.internet_yoqish);
        three = findViewById(R.id.internet_ochirish);
        four = findViewById(R.id.OnNet);
        one.setOnClickListener(view -> call("*111*021", view));
        two.setOnClickListener(view -> call("*111*0011", view));
        three.setOnClickListener(view -> call("*111*0010", view));
        four.setOnClickListener(view -> call("*202*0", view));

    }


    public void setOne(String text) {
        one.setText(text);
    }

    public void setTwo(String text) {
        two.setText(text);
    }

    public void setThree(String text) {
        three.setText(text);
    }

    public void setFour(String text) {
        four.setText(text);
    }

    public static void call(String num, View view) {
        String a = Uri.encode((String) "#");
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:" + num + a));
        if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        view.getContext().startActivity(call);
    }


}
