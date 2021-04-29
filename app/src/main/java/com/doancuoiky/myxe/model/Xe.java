package com.doancuoiky.myxe.model;


import java.util.ArrayList;
import java.util.Date;

public class Xe {
    public int id;
    public String tenXe;
    public String bienSoXe;
    public String loaiXe;
    public String hangXe;
    public Date ngayMua;
    public int kmHienTai;
    public String ghiChu;

    public String ngayBaoTri;
    public int kilometBaoTri;

    public ArrayList<LichSuDoXang> listLichSuDoXang;
    public ArrayList<LichSuThayNhot> listLichSuThayNhot;
    public ArrayList<LichSuThayLinhKien> listLichSuThayLinhKien;

    public Xe(int id, String tenXe, String bienSoXe, String loaiXe, String hangXe, Date ngayMua, int kmHienTai, String ghiChu) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
        this.kmHienTai = kmHienTai;
        this.ghiChu = ghiChu;
    }

    public Xe(int id, String tenXe, String bienSoXe, String loaiXe, String hangXe, Date ngayMua, int kmHienTai) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
        this.kmHienTai = kmHienTai;
    }

    public Xe(int id, String tenXe, String bienSoXe, String loaiXe, String hangXe, Date ngayMua) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getKmHienTai() {
        return kmHienTai;
    }

    public void setKmHienTai(int kmHienTai) {
        this.kmHienTai = kmHienTai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayBaoTri() {
        return ngayBaoTri;
    }

    public void setNgayBaoTri(String ngayBaoTri) {
        this.ngayBaoTri = ngayBaoTri;
    }

    public int getKilometBaoTri() {
        return kilometBaoTri;
    }

    public void setKilometBaoTri(int kilometBaoTri) {
        this.kilometBaoTri = kilometBaoTri;
    }

    public ArrayList<LichSuDoXang> getListLichSuDoXang() {
        return listLichSuDoXang;
    }

    public void setListLichSuDoXang(ArrayList<LichSuDoXang> listLichSuDoXang) {
        this.listLichSuDoXang = listLichSuDoXang;
    }

    public ArrayList<LichSuThayNhot> getListLichSuThayNhot() {
        return listLichSuThayNhot;
    }

    public void setListLichSuThayNhot(ArrayList<LichSuThayNhot> listLichSuThayNhot) {
        this.listLichSuThayNhot = listLichSuThayNhot;
    }

    public ArrayList<LichSuThayLinhKien> getListLichSuThayLinhKien() {
        return listLichSuThayLinhKien;
    }

    public void setListLichSuThayLinhKien(ArrayList<LichSuThayLinhKien> listLichSuThayLinhKien) {
        this.listLichSuThayLinhKien = listLichSuThayLinhKien;
    }
}
