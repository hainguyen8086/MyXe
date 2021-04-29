package com.doancuoiky.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuDoXang {
    public String idXe;
    public int tienDoXang;
    public int dungTich;
    public int kmLucDoXang;
    public String thoiGian;
    public String diaChi;

    public LichSuDoXang(String idXe, int tienDoXang, int dungTich, int kmLucDoXang, String thoiGian, String diaChi) {
        this.idXe = idXe;
        this.tienDoXang = tienDoXang;
        this.dungTich = dungTich;
        this.kmLucDoXang = kmLucDoXang;
        this.thoiGian = thoiGian;
        this.diaChi = diaChi;
    }

    public String getIdXe() {
        return idXe;
    }

    public void setIdXe(String idXe) {
        this.idXe = idXe;
    }

    public int getTienDoXang() {
        return tienDoXang;
    }

    public void setTienDoXang(int tienDoXang) {
        this.tienDoXang = tienDoXang;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public int getKmLucDoXang() {
        return kmLucDoXang;
    }

    public void setKmLucDoXang(int kmLucDoXang) {
        this.kmLucDoXang = kmLucDoXang;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
