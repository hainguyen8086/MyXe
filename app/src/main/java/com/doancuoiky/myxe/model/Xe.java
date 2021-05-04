package com.doancuoiky.myxe.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Xe {
    public String id;
    public String tenXe;
    public String bienSoXe;
    public String loaiXe;
    public String hangXe;
    public String ngayMua;
    public int kmHienTai;
    public String ghiChu;
    public String chuXe;
    public String ngayBaoTri;
    public int kilometBaoTri;

    public List<LichSuDoXang> listLichSuDoXang;
    public List<LichSuThayNhot> listLichSuThayNhot;
    public List<LichSuThayLinhKien> listLichSuThayLinhKien;

    public Xe(String id, String tenXe, String bienSoXe, String loaiXe, String hangXe, String ngayMua, int kmHienTai, String ghiChu, String chuXe) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
        this.kmHienTai = kmHienTai;
        this.ghiChu = ghiChu;
        this.chuXe = chuXe;
    }

    public Xe(String id, String tenXe, String bienSoXe, String loaiXe, String hangXe, String ngayMua, int kmHienTai) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
        this.kmHienTai = kmHienTai;
    }

    public Xe(String id, String tenXe, String bienSoXe, String loaiXe, String hangXe, String ngayMua) {
        this.id = id;
        this.tenXe = tenXe;
        this.bienSoXe = bienSoXe;
        this.loaiXe = loaiXe;
        this.hangXe = hangXe;
        this.ngayMua = ngayMua;
    }

    public List<LichSuDoXang> getListLichSuDoXang() {
        return listLichSuDoXang;
    }

    public void setListLichSuDoXang(List<LichSuDoXang> listLichSuDoXang) {
        this.listLichSuDoXang = listLichSuDoXang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
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

    public String getChuXe() {
        return chuXe;
    }

    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
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

    public List<LichSuThayNhot> getListLichSuThayNhot() {
        return listLichSuThayNhot;
    }

    public void setListLichSuThayNhot(List<LichSuThayNhot> listLichSuThayNhot) {
        this.listLichSuThayNhot = listLichSuThayNhot;
    }

    public List<LichSuThayLinhKien> getListLichSuThayLinhKien() {
        return listLichSuThayLinhKien;
    }

    public void setListLichSuThayLinhKien(List<LichSuThayLinhKien> listLichSuThayLinhKien) {
        this.listLichSuThayLinhKien = listLichSuThayLinhKien;
    }

    @Override
    public boolean equals(Object object) {
        Xe xe = (Xe)object;
        return xe.getId().equals(id);
    }

}
