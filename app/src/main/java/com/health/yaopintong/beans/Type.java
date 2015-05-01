package com.health.yaopintong.beans;

/**
 * 品牌专区的实体类
 */
public class Type {
    private String namecn;
    private String titleimg;

    public String getNamecn() {
        return namecn;
    }

    public void setNamecn(String namecn) {
        this.namecn = namecn;
    }

    public String getTitleimg() {
        return titleimg;
    }

    public void setTitleimg(String titleimg) {
        this.titleimg = titleimg;
    }

    @Override
    public String toString() {
        return "Type{" +
                "namecn='" + namecn + '\'' +
                ", titleimg='" + titleimg + '\'' +
                '}';
    }
}
