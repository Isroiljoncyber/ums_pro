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

import uz.example.rakhmatillo.ums_pro.R;
import uz.example.rakhmatillo.ums_pro.dialogs.Dialog;
import uz.example.rakhmatillo.ums_pro.dialogs.Packets_Dialog;
import uz.example.rakhmatillo.ums_pro.models.BaseData;
import uz.example.rakhmatillo.ums_pro.models.ButtonData;
import uz.example.rakhmatillo.ums_pro.models.MyData;
import uz.example.rakhmatillo.ums_pro.models.MyDataBonus;
import uz.example.rakhmatillo.ums_pro.models.StringData;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BaseData> data;

    public RecyclerViewAdapter(ArrayList<BaseData> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == BaseData.TYPE_BONUS) {
            holder = new BonusViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_packets_recycler_bonus, parent, false));
        } else if (viewType == BaseData.TYPE_BUTTON) {
            holder = new ButtonViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_packets_button, parent, false));
        } else if (viewType == BaseData.TYPE_DATA) {
            holder = new MainViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_packets_recycler, parent, false));
        } else if (viewType == BaseData.TYPE_STRING) {
            holder = new StringViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(uz.example.rakhmatillo.ums_pro.R.layout.item_string_packets, parent, false));
        }
        assert holder != null;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BaseData.TYPE_BONUS) {
            MyDataBonus dataBonus = (MyDataBonus) data.get(position);
            BonusViewHolder holder1 = (BonusViewHolder) holder;
            holder1.bindData(dataBonus);
        } else if (getItemViewType(position) == BaseData.TYPE_BUTTON) {
            ButtonData dataButton = (ButtonData) data.get(position);
            ButtonViewHolder holder1 = (ButtonViewHolder) holder;
            holder1.bindData(dataButton);
        } else if (getItemViewType(position) == BaseData.TYPE_DATA) {
            MyData dataMain = (MyData) data.get(position);
            MainViewHolder holder1 = (MainViewHolder) holder;
            holder1.bindData(dataMain);
        } else if (getItemViewType(position) == BaseData.TYPE_STRING) {
            StringData dataString = (StringData) data.get(position);
            StringViewHolder holder1 = (StringViewHolder) holder;
            holder1.bindData(dataString);
        }
    }


    static class BonusViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView bonus;
        private CardView cardView;


        public BonusViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_name);
            price = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_cost);
            bonus = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_bonus);
            cardView = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.item_packets_bonus_card);

        }

        void bindData(MyDataBonus data) {
            name.setText(data.getName());
            price.setText(data.getCost());
            bonus.setText(data.getBonus());
            cardView.setOnClickListener(view -> {
                Packets_Dialog dialog = new Packets_Dialog(view.getContext());
                dialog.setTitle(view.getContext().getResources().getString(R.string.dialog_title));
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


    static class StringViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public StringViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_string);
        }

        void bindData(StringData data) {
            text.setText(data.getText());
        }

    }

    static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private CardView cardView;


        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_name);
            price = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_cost);
            cardView = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.item_packets_card);
        }

        void bindData(MyData data) {
            name.setText(data.getName());
            price.setText(data.getCost());
            cardView.setOnClickListener(view -> {
                Packets_Dialog dialog = new Packets_Dialog(view.getContext());
                dialog.setTitle(view.getContext().getResources().getString(R.string.dialog_title));
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


    static class ButtonViewHolder extends RecyclerView.ViewHolder {
        private TextView name;


        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(uz.example.rakhmatillo.ums_pro.R.id.packet_button);
        }

        void bindData(ButtonData data) {
            name.setText(data.getText());
            name.setOnClickListener(view -> {
                Packets_Dialog dialog = new Packets_Dialog(view.getContext());
                dialog.setTitle(view.getContext().getResources().getString(R.string.dialog_title));
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
