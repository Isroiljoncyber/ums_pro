package uz.example.rakhmatillo.ums_pro.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uz.example.rakhmatillo.ums_pro.R;

import uz.example.rakhmatillo.ums_pro.adapters.RecyclerViewAdapter;
import uz.example.rakhmatillo.ums_pro.models.BaseData;

import java.io.Serializable;
import java.util.ArrayList;


public class ListFragment extends Fragment implements Serializable {
    RecyclerViewAdapter adapter;
    ArrayList<BaseData> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView list = view.findViewById(R.id.list);
        assert getArguments() != null;
        data = (ArrayList<BaseData>) getArguments().getSerializable("DATA");
        adapter = new RecyclerViewAdapter(data);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;

    }


    public static ListFragment getInstance(ArrayList<BaseData> data) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", data);
        fragment.setArguments(bundle);
        return fragment;
    }


}
