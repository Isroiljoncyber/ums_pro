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
import android.widget.TextView;

import uz.example.rakhmatillo.ums_pro.dialogs.Dialog;
import uz.example.rakhmatillo.ums_pro.dialogs.Packets_Dialog;
import uz.example.rakhmatillo.ums_pro.models.ServiceData;

import java.util.ArrayList;


public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.ViewHolder> {
    private ArrayList<ServiceData> data;

    public ServiceListAdapter(ArrayList<ServiceData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_service,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView description;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.service_name);
            description=itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.service_description);
            cardView=itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.item_service_card);
        }

        void bindView(ServiceData data){
            name.setText(data.getName());
            description.setText(data.getDescription());
            cardView.setOnClickListener(view -> {
                Packets_Dialog dialog= new Packets_Dialog(view.getContext());
                dialog.setTitle(view.getContext().getResources().getString(uz.example.rakhmatillo.ums_pro.R.string.dialog_title));
                dialog.setOnClickListener(new Dialog.OnClickListener() {
                    @Override
                    public void onApply() {
                        call(data.getMyTag(),view);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                dialog.show();
            });
        }
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
