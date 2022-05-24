package uz.example.rakhmatillo.ums_pro.dialogs;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import uz.example.rakhmatillo.ums_pro.R;

public abstract class Dialog {
    private AlertDialog.Builder builder;
    private View view;


    public Dialog(Context context, int resId)
    {
        builder = new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(resId, null, false);
        builder.setView(view);
    }

    public void show()
    {
        AlertDialog dialog = builder.show();
    }

    protected void setTitle(String title)
    {
        builder.setTitle(title);
    }

    public void setOnClickListener(OnClickListener onClickListener)
    {
        builder.setPositiveButton(view.getContext().getResources().getString(R.string.dialog_apply_button),(dialogInterface, i) ->{
            if(onClickListener!=null){
                onClickListener.onApply();
            }
        });
        builder.setNegativeButton(view.getContext().getResources().getString(R.string.dialog_cancel_button), (dialogInterface, i)->{
            if(onClickListener!=null)
            {
                onClickListener.onCancel();
            }
        });
    }

    public interface OnClickListener
    {
        void onApply();
        void onCancel();
    }
}
