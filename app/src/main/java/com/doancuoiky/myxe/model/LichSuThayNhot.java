package com.doancuoiky.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuThayNhot {
    public String id;
    public int kmLucThayNhot;
    public String loaiNhot;
    public int giaNhot;
    public String thoiGian;
    public String diaChi;

    public LichSuThayNhot(String id, int kmLucThayNhot, String loaiNhot, int giaNhot, String thoiGian, String diaChi) {
        this.id = id;
        this.kmLucThayNhot = kmLucThayNhot;
        this.loaiNhot = loaiNhot;
        this.giaNhot = giaNhot;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
    }

    public String getIdXe() {
        return id;
    }

    public void setIdXe(String idXe) {
        this.id = idXe;
    }

    public int getKmLucThayNhot() {
        return kmLucThayNhot;
    }

    public void setKmLucThayNhot(int kmLucThayNhot) {
        this.kmLucThayNhot = kmLucThayNhot;
    }

    public String getLoaiNhot() {
        return loaiNhot;
    }

    public void setLoaiNhot(String loaiNhot) {
        this.loaiNhot = loaiNhot;
    }

    public int getGiaNhot() {
        return giaNhot;
    }

    public void setGiaNhot(int giaNhot) {
        this.giaNhot = giaNhot;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaDiem() {
        return diaChi;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaChi = diaDiem;
    }
}
