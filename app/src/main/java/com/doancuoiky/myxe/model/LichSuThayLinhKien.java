package com.doancuoiky.myxe.model;

import java.time.format.DateTimeFormatter;

public class LichSuThayLinhKien {
    public String idXe;
    public String bienSoXe;
    public String tenLinhKien;
    public int soLuong;
    public int giaLinhKien;
    public String thoiGian;
    public String diaDiem;

    public LichSuThayLinhKien(String idXe, String bienSoXe, String tenLinhKien, int soLuong, int giaLinhKien, String thoiGian, String diaDiem) {
        this.idXe = idXe;
        this.bienSoXe = bienSoXe;
        this.tenLinhKien = tenLinhKien;
        this.soLuong = soLuong;
        this.giaLinhKien = giaLinhKien;
        this.thoiGian = thoiGian;
        this.diaDiem = diaDiem;
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
