package com.example.pnlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pnlib.R;
import com.example.pnlib.fragment_loai_sach;
import com.example.pnlib.fragment_thanh_vien;
import com.example.pnlib.model.LoaiSach;
import com.example.pnlib.model.ThanhVien;

import java.util.ArrayList;

public class LoaiSachAdapter extends ArrayAdapter<LoaiSach> {
    private Context context;
    fragment_loai_sach fragment;
    private ArrayList<LoaiSach> list;
    TextView tvMaLoai, tvTenLoai;
    ImageView imgDel;

    public LoaiSachAdapter(@NonNull Context context, fragment_loai_sach fragment, ArrayList<LoaiSach> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_loai_sach, null);
        }
        final LoaiSach item = list.get(position);
        if (item != null) {
            tvMaLoai = v.findViewById(R.id.tvMaLoaiSach);
            tvMaLoai.setText("Mã Loại: " + item.getMaLoai());
            tvTenLoai = v.findViewById(R.id.tvTenLoaiSach);
            tvTenLoai.setText("Tên Loại: " + item.getTenLoai());

            imgDel = v.findViewById(R.id.imgDeleteLS);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi phương thức xóa
                fragment.xoa(String.valueOf(item.getMaLoai()));
            }
        });
        return v;
    }
}
