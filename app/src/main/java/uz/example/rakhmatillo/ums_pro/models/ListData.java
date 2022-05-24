package uz.example.rakhmatillo.ums_pro.models;

import java.util.ArrayList;

public class ListData {
    private ArrayList<BaseData> data;

    public ListData(ArrayList<BaseData> data) {
        this.data = data;
    }

    public ArrayList<BaseData> getData() {
        return data;
    }
}