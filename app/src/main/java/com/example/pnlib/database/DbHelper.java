package com.example.pnlib.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "PNLIB";
    public static final int DB_VERSION = 3;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableThuThu = "create table ThuThu(" +
                "maTT TEXT PRIMARY KEY, " +
                "hoTen TEXT NOT NULL, " +
                "matKhau TEXT NOT NULL)";
        db.execSQL(createTableThuThu);
        // tạo bảng thành viên
        String createTableThanhVien = "create table ThanhVien(" +
                "maTV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "hoTen TEXT NOT NULL, " +
                "namSinh TEXT NOT NULL," +
                "cccd TEXT NOT NULL)";
        db.execSQL(createTableThanhVien);
        // tạo bảng Loại Sách
        String createTableLoaiSach = "create table LoaiSach(" +
                "maLoai INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenLoai TEXT NOT NULL)";
        db.execSQL(createTableLoaiSach);
        // tạo bảng Sách
        String createTableSach = "create table Sach(" +
                "maSach INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenSach TEXT NOT NULL, " +
                "giaThue INTEGER NOT NULL, " +
                "maLoai INTEGER REFERENCES LoaiSach(maLoai)," +
                "namXB INTEGER NOT NULL)";
        db.execSQL(createTableSach);

        // tạo bảng Phiếu Mượn
        String createTablePhieuMuon = "create table PhieuMuon(" +
                "maPM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "maTT TEXT REFERENCES ThuThu(maTT), " +
                "maTV INTEGER REFERENCES ThanhVien(maTV), " +
                "maSach INTEGER REFERENCES Sach(maSach), " +
                "tienThue INTEGER NOT NULL, " +
                "ngay DATE NOT NULL, " +
                "traSach INTEGER NOT NULL)";
        db.execSQL(createTablePhieuMuon);
        // data mẫu
        db.execSQL("INSERT INTO ThuThu VALUES('admin','Admin','admin')," +
                "('trinhpk','Phạm Kiều Trinh','123')");
        db.execSQL("INSERT INTO ThanhVien VALUES(1,'Đoàn Ngọc Mai','2000','123')," +
                "(2,'Phạm Thị Hân','2001','456')");
        db.execSQL("INSERT INTO LoaiSach VALUES(1,'Thiếu nhi'),(2,'Tình cảm'),(3,'CNTT')");
        db.execSQL("INSERT INTO Sach VALUES(1,'Hãy đợi đấy',2500,'2',2003),(2,'Doraemon',2000,'1',2014),(3,'Lập trình Android',2000,'3',2020)");
        db.execSQL("INSERT INTO PhieuMuon VALUES(1,'admin','1','1','2000','2023/09/21','1')," +
                "(2,'trinhpk','2','2','2000','2023/09/23','1')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("drop table if exists ThuThu");
            db.execSQL("drop table if exists ThanhVien");
            db.execSQL("drop table if exists LoaiSach");
            db.execSQL("drop table if exists Sach");
            db.execSQL("drop table if exists PhieuMuon");
            onCreate(db);
        }
    }
}
