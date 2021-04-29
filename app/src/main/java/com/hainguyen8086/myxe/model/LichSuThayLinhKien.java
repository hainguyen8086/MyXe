package com.hainguyen8086.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuThayLinhKien {
    public String idXe;
    public String bienSoXe;
    public String tenLinhKien;
    public int soLuong;
    public int giaLinhKien;
    public DateTimeFormatter dateTimeFormatter;

    public LichSuThayLinhKien(String idXe, String bienSoXe, String tenLinhKien, int soLuong, int giaLinhKien, DateTimeFormatter dateTimeFormatter) {
        this.idXe = idXe;
        this.bienSoXe = bienSoXe;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.giaLinhKien = giaLinhKien;
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

    public String getTenLinhKien() {
        return tenLinhKien;
    }

    public void setTenLinhKien(String tenLinhKien) {
        this.tenLinhKien = tenLinhKien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaLinhKien() {
        return giaLinhKien;
    }

    public void setGiaLinhKien(int giaLinhKien) {
        this.giaLinhKien = giaLinhKien;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }


}
