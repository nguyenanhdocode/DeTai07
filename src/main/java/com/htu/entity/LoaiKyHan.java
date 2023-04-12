/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.entity;

public enum LoaiKyHan {
    MOT_TUAN(0.02),
    MOT_THANG(0.055),
    SAU_THANG(0.075),
    MOT_NAM(0.079);

    private double laiSuat;

    LoaiKyHan(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public double getLaiSuat() {
        return this.laiSuat;
    }
}
