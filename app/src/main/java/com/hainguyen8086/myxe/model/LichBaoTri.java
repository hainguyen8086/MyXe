package com.hainguyen8086.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichBaoTri {
    public String bienSoXe;
    public DateTimeFormatter ngayBaotri;
    public int kmBaotri;

    public LichBaoTri(String bienSoXe, DateTimeFormatter ngayBaotri, int kmBaotri) {
        this.bienSoXe = bienSoXe;
        this.ngayBaotri = ngayBaotri;
        this.kmBaotri = kmBaotri;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public DateTimeFormatter getNgayBaotri() {
        return ngayBaotri;
    }

    public void setNgayBaotri(DateTimeFormatter ngayBaotri) {
        this.ngayBaotri = ngayBaotri;
    }

    public int getKmBaotri() {
        return kmBaotri;
    }

    public void setKmBaotri(int kmBaotri) {
        this.kmBaotri = kmBaotri;
    }

    @Override
    public String toString() {
        return "LichBaoTri{" +
                "bienSoXe='" + bienSoXe + '\'' +
                ", ngayBaotri=" + ngayBaotri +
                ", kmBaotri=" + kmBaotri +
                '}';
    }
}
