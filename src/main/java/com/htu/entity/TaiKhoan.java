/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.entity;

import java.util.Date;

public abstract class TaiKhoan {
    protected double laiSuat;
    protected Date ngayGui;
    
    protected TaiKhoan(double laiSuat, Date ngayGui) {
        this.laiSuat = laiSuat;
        this.ngayGui = ngayGui;
    }
}
