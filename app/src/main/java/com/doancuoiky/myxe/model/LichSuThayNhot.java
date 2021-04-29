package com.doancuoiky.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuThayNhot {
    public String idXe;
    public int kmLucThayNhot;
    public String loaiNhot;
    public int giaNhot;
    public String thoiGian;
    public String diaDiem;

    public LichSuThayNhot(String idXe, int kmLucThayNhot, String loaiNhot, int giaNhot, String thoiGian, String diaDiem) {
        this.idXe = idXe;
        this.kmLucThayNhot = kmLucThayNhot;
        this.loaiNhot = loaiNhot;
        this.giaNhot = giaNhot;
        this.thoiGian = thoiGian;
        this.diaDiem = diaDiem;
    }

    public String getIdXe() {
        return idXe;
    }

    public void setIdXe(String idXe) {
        this.idXe = idXe;
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
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
}
