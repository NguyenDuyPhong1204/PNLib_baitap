package com.example.pnlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pnlib.DAO.ThuThuDAO;
import com.example.pnlib.R;
import com.example.pnlib.fragment_add_user;
import com.example.pnlib.model.ThuThu;

import java.util.ArrayList;

public class ThuThuAdapter extends ArrayAdapter<ThuThu> {

    private Context context;
    fragment_add_user fragment;
    private ArrayList<ThuThu> list;
    TextView tvMaTT,tvTenTT,tvMatKhau;
    ImageView imgDel;
    ThuThuDAO dao;

    public ThuThuAdapter(@NonNull Context context, fragment_add_user fragment, ArrayList<ThuThu> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        dao = new ThuThuDAO(getContext());
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_add_user,null);

        }

        final ThuThu item = list.get(position);
        if (item != null){
            tvMaTT = v.findViewById(R.id.tvMaTT);
            tvMaTT.setText("Mã TT: "+item.getMaTT());
            tvTenTT = v.findViewById(R.id.tvTenTT);
            tvTenTT.setText("Họ tên: "+item.getHoTen());
            tvMatKhau = v.findViewById(R.id.tvMatKhau);
            tvMatKhau.setText("Mật khẩu: "+item.getMatKhau());


            imgDel = v.findViewById(R.id.imgDeleteLS);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pt xoa
                fragment.xoa(item.getMaTT());
            }
        });
        return v;
    }
}
