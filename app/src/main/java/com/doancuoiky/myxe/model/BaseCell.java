package com.doancuoiky.myxe.model;

public class BaseCell {
    int iconName;
    String title;
    String placeHolder;
    public BaseCell() {

    }

    public int getIconName() {
        return iconName;
    }

    public void setIconName(int iconName) {
        this.iconName = iconName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public BaseCell(int iconName, String title, String placeHolder) {
        this.iconName = iconName;
        this.title = title;
        this.placeHolder = placeHolder;
    }
}
