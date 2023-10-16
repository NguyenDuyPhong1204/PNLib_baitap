package com.example.pnlib;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pnlib.DAO.PhieuMuonDAO;
import com.example.pnlib.DAO.ThongKeDAO;
import com.example.pnlib.adapter.TopAdapter;
import com.example.pnlib.model.Top;

import java.util.ArrayList;


public class fragment_top extends Fragment {
    ListView lvTop;
    ArrayList<Top> list;
    TopAdapter adapter;
    ThongKeDAO dao;


    public fragment_top() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_top, container, false);
        lvTop = v.findViewById(R.id.lvTop);
        PhieuMuonDAO phieuMuonDAO = new PhieuMuonDAO(getActivity());
        list = (ArrayList<Top>) phieuMuonDAO.getTop();
        adapter = new TopAdapter(getActivity(),this,list);
        lvTop.setAdapter(adapter);
        return v;
    }
}