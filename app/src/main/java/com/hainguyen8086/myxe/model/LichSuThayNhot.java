package com.hainguyen8086.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuThayNhot {
    public String idXe;
    public String bienSoXe;
    public int kmLucThayNhot;
    public String loaiNhot;
    public int giaNhot;
    public DateTimeFormatter dateTimeFormatter;


    public LichSuThayNhot(String idXe, String bienSoXe, int kmLucThayNhot, String loaiNhot, int giaNhot, DateTimeFormatter dateTimeFormatter) {
        this.idXe = idXe;
        this.bienSoXe = bienSoXe;
        this.kmLucThayNhot = kmLucThayNhot;
        this.loaiNhot = loaiNhot;
        this.giaNhot = giaNhot;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public String getIdXe() {
        return idXe;
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

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }


}
