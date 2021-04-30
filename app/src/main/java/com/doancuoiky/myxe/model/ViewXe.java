package com.doancuoiky.myxe.model;

public class ViewXe {
    public String tenXe;
    public String bienSo;

    public ViewXe(String tenXe, String bienSo) {
        this.tenXe = tenXe;
        this.bienSo = bienSo;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
}
