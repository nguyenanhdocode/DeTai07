/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.manage;

import com.htu.entity.KhachHang;
import com.htu.entity.TaiKhoanHeThong;
import java.util.List;

/**
 *
 * @author nguye
 */
public class QuanLiTaiKhoan {

    public List<TaiKhoanHeThong> getDsKhachHang() {
        return dsTaiKhoan;
    }
    
    public void setDsKhachHang(List<TaiKhoanHeThong> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
    
    // Mở tài khoản không kỳ hạn
    public boolean moTaiKhoanKhongKyHan(KhachHang kh) {
        if (kh == null)
            return false;
        
        TaiKhoanHeThong tkHeThong = new TaiKhoanHeThong();
        String newUserName = "";
        String newPassword = "";
        
        tkHeThong.setUserName(newUserName);
        tkHeThong.setPassword(newPassword);
        tkHeThong.setKhachHang(kh);
        
        dsTaiKhoan.add(tkHeThong);
        
        return true;
    }
    
    private List<TaiKhoanHeThong> dsTaiKhoan;
    
}
