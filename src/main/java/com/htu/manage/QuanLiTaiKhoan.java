/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.manage;

import com.htu.entity.KhachHang;
import com.htu.entity.TaiKhoanHeThong;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class QuanLiTaiKhoan {

    /**
     * @return the sttKhachHang
     */
    public int getSttKhachHang() {
        return sttKhachHang;
    }

    /**
     * @param sttKhachHang the sttKhachHang to set
     */
    public void setSttKhachHang(int sttKhachHang) {
        this.sttKhachHang = sttKhachHang;
    }

    public List<TaiKhoanHeThong> getDsTaiKhoang() {
        return dsTaiKhoan;
    }
    
    public void setDsTaiKhoan(List<TaiKhoanHeThong> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
    
    // Mở tài khoản không kỳ hạn
    public TaiKhoanHeThong moTaiKhoanKhongKyHan(KhachHang kh) {
        if (kh == null)
            return null;
        
        TaiKhoanHeThong tkHeThong = new TaiKhoanHeThong();
        
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        
        String newUserName =  String.format("%02d", day) + String.format("%02d", month) + year + String.format("%04d", sttKhachHang);
        
        // Random mật khẩu
        Random rnd = new Random();
        int randomNum = 100000 + rnd.nextInt(900000);
        String newPassword = Integer.toString(randomNum);
        
        tkHeThong.setUserName(newUserName);
        tkHeThong.setPassword(newPassword);
        tkHeThong.setKhachHang(kh);
        
        sttKhachHang += 1;
        
        dsTaiKhoan.add(tkHeThong);
        
        return tkHeThong;
    }
    
    public QuanLiTaiKhoan() {
        this.dsTaiKhoan = new ArrayList<>();
    }
    
    private List<TaiKhoanHeThong> dsTaiKhoan;
    private int sttKhachHang = 0;
}
