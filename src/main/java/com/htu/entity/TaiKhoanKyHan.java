/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.entity;

import java.util.Date;

/**
 *
 * @author nguye
 */
public class TaiKhoanKyHan extends TaiKhoan{

    public TaiKhoanKyHan(double laiSuat, Date ngayGui, Date ngayDaoHan) {
        super(laiSuat, ngayGui);
        this.ngayDaoHan = ngayDaoHan;
    }
    /**
     * @return the ngayDaoHan
     */
    public Date getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Date ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }
    
    private Date ngayDaoHan;
}
