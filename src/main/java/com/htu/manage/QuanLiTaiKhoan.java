/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.manage;

import com.htu.entity.KhachHang;
import com.htu.entity.TaiKhoan;
import com.htu.entity.TaiKhoanHeThong;
import com.htu.entity.TaiKhoanKyHan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


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

    public List<TaiKhoanHeThong> getDsTaiKhoan() {
        return dsTaiKhoan;
    }
    
    public void setDsTaiKhoan(List<TaiKhoanHeThong> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
    
    // Xử lí mở tài khoản không kỳ hạn
    public TaiKhoanHeThong moTaiKhoanKhongKyHan(KhachHang kh) {
        if (kh == null)
            return null;
        
        TaiKhoanHeThong tkHeThong = new TaiKhoanHeThong();
        
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        
        String newUserName =  String.format("%02d", day) + String.format("%02d", month) + year + String.format("%04d", sttKhachHang);
        kh.setMaKH(newUserName);
        
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
    
    // Mở tài khoản có kỳ hạn
    public TaiKhoan moTaiKhoanKyHan(String maKH, double soTienGui, Date ngayGui, double laiSuat, Date ngayDaoHan) {
        TaiKhoan taiKhoan = new TaiKhoanKyHan(laiSuat, ngayGui, ngayDaoHan);
        KhachHang kh = timKiem(maKH);
        if (kh != null) {
            kh.themTaiKhoan(taiKhoan);
            return taiKhoan;
        }
        return null;
    }
    
    public KhachHang timKiem(String maKH) {
        for (int i = 0; i < dsTaiKhoan.size(); i++) {
            KhachHang kh = dsTaiKhoan.get(i).getKhachHang();
            if (kh.getMaKH().equals(maKH))
                return kh;
        }
        return null;
    }
    
    // Xử lí gửi tiền
    public double guiTien(String maKH, double soTien) {
        KhachHang kh = timKiem(maKH);
        double soDu = kh.getSoTienGui() + soTien;
        kh.setSoTienGui(soDu);
        return soDu;
    }
    
    // Xử lí rút tiền
    public double rutTien(String maKH, double soTien) {
        KhachHang kh = timKiem(maKH);
        double tienConLai = kh.getSoTienGui() - soTien;
        kh.setSoTienGui(tienConLai);
        return tienConLai;
    }
    
    public List<KhachHang> timKiemTheoTen(String tenKH) {
        List<KhachHang> kq = new ArrayList<>();
        for (int i = 0; i < dsTaiKhoan.size(); i++) {
            if (dsTaiKhoan.get(i).getKhachHang().getHoTen().equalsIgnoreCase(tenKH)) {
                kq.add(dsTaiKhoan.get(i).getKhachHang());
            }
        }
        return kq;
    }
    
    public List<KhachHang> timKiemTheoMaKH(String maKH) {
        List<KhachHang> kq = new ArrayList<>();
        for (int i = 0; i < dsTaiKhoan.size(); i++) {
            if (dsTaiKhoan.get(i).getKhachHang().getMaKH().equalsIgnoreCase(maKH)) {
                kq.add(dsTaiKhoan.get(i).getKhachHang());
            }
        }
        return kq;
    }
    
    public List<TaiKhoan> traCuuDsTaiKhoan(String maKH) {
        KhachHang kh = timKiem(maKH);
        return kh.getDsTaiKhoan();
    }
    
    public QuanLiTaiKhoan() {
        this.dsTaiKhoan = new ArrayList<>();
    }
    
    private List<TaiKhoanHeThong> dsTaiKhoan;
    private int sttKhachHang = 0;
}
