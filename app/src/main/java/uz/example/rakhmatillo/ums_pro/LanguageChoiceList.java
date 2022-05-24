/*coded by Mukhammadyunus and Rakhmatillo
 *rakhmatillo.topiboldiev@gmail.com
 *
 *
 * project ready date 30.07.2018*/
package uz.example.rakhmatillo.ums_pro;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import uz.example.rakhmatillo.ums_pro.helpers.LocaleHelper;
import uz.example.rakhmatillo.ums_pro.activities.MainActivity;

import io.paperdb.Paper;

public class LanguageChoiceList extends DialogFragment {
    final CharSequence[] items = {"O'zbek", "Русский"};
    int selected;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        @SuppressLint("InflateParams") View view = LayoutInflater.from(getContext()).inflate(R.layout.content_main, null, false);
        TextView textView = view.findViewById(R.id.main_tarrif_txt);
        if (textView.getText().equals("Tariflar")) {
            selected = 0;
        }
        if (textView.getText().equals("Тарифы")) {
            selected = 1;
        }

            builder.setSingleChoiceItems(items, selected, (dialog, which) -> {
                switch (which) {
                    case 0:
                        Paper.book().write("language", "en");
                        updateView((String) Paper.book().read("language"));
                        break;
                    case 1:
                        Paper.book().write("language", "ru");
                        updateView((String) Paper.book().read("language"));
                        break;
                }
            });

        builder.setPositiveButton("OK", (dialog, which) -> {
            Intent refresh = new Intent(getContext(), MainActivity.class);
            refresh.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(refresh);

        });
        return builder.create();
    }

    private void updateView(String language) {
        LocaleHelper.setLocale(getActivity(), language);
        Configuration config = new Configuration();
        Objects.requireNonNull(getActivity()).getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        Paper.book().write("language", language);

    }
}