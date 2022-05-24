package uz.example.rakhmatillo.ums_pro.adapters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import uz.example.rakhmatillo.ums_pro.dialogs.Dialog;
import uz.example.rakhmatillo.ums_pro.dialogs.Packets_Dialog;
import uz.example.rakhmatillo.ums_pro.models.TarrifsData;

import java.util.ArrayList;


public class TarrifAdapter extends RecyclerView.Adapter<TarrifAdapter.TarrifViewHolder> {
    private ArrayList<TarrifsData> data;

    @NonNull
    @Override
    public TarrifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TarrifViewHolder(LayoutInflater.from(parent.getContext()).inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_tarrif, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TarrifViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    public TarrifAdapter(ArrayList<TarrifsData> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class TarrifViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        TextView a;
        TextView description;
        CardView cardView;


        public TarrifViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.tarrif_name);
            icon = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.tarrif_icon);
            description = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.tarrif_description);
            a = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.aaa);
            cardView = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.item_tarrif_card);

        }

        void bindData(TarrifsData data) {
            name.setText(data.getTarrifName());
            description.setText(data.getTarrifDescription());
            icon.setImageResource(data.getIconRes());
            cardView.setOnClickListener(view -> {
                Packets_Dialog dialog = new Packets_Dialog(view.getContext());
                dialog.setTitle(view.getContext().getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.dialog_title));
                dialog.setOnClickListener(new Dialog.OnClickListener() {
                    @Override
                    public void onApply() {
                        call(data.getMyTag(), view);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                dialog.show();
            });
        }
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
