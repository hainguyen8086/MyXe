package com.hainguyen8086.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuDoXang {
    public String idXe;
    public String bienSoXe;
    public int tienDoXang;
    public int dungTich;
    public int kmLucDoXang;
    public DateTimeFormatter dateTimeFormatter;
    public String diaChi;

    public LichSuDoXang(String idXe, String bienSoXe, int tienDoXang, int dungTich, int kmLucDoXang, DateTimeFormatter dateTimeFormatter, String diaChi) {
        this.idXe = idXe;
        this.bienSoXe = bienSoXe;
        this.tienDoXang = tienDoXang;
        this.dungTich = dungTich;
        this.kmLucDoXang = kmLucDoXang;
        this.dateTimeFormatter = dateTimeFormatter;
        this.diaChi = diaChi;
    }



    public void setIdXe(String idXe) {
        this.idXe = idXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
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

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
