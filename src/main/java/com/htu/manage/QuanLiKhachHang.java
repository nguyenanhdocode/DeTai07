/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.manage;

import com.htu.entity.KhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class QuanLiKhachHang {

    /**
     * @return the dsKhachHang
     */
    public List<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    /**
     * @param dsKhachHang the dsKhachHang to set
     */
    public void setDsKhachHang(List<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }
    
    public void themKhachHang(KhachHang kh) {
        dsKhachHang.add(kh);
    }
    
    private List<KhachHang> dsKhachHang;
    
    public QuanLiKhachHang() {
        this.dsKhachHang = new ArrayList<>();
    }
}
