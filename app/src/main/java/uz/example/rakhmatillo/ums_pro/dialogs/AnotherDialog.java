package uz.example.rakhmatillo.ums_pro.dialogs;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

public abstract class AnotherDialog {
    private AlertDialog.Builder builder;
    private View view;
    int a;

    public AnotherDialog(Context context, int resId) {
        builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(resId,null,false);
        builder.setView(view);
    }

    public void show(){
        AlertDialog dialog = builder.show();
    }

    <T extends View> T findViewById(int resId){
        return view.findViewById(resId);
    }

    protected void setTitle(String title){
        builder.setTitle(title);
    }

}
