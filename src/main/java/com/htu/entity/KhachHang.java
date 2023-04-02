/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htu.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nguye
 */
public class KhachHang {

    /**
     * @return the maKH
     */
    public String getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the soCanCuoc
     */
    public String getSoCanCuoc() {
        return soCanCuoc;
    }

    /**
     * @param soCanCuoc the soCanCuoc to set
     */
    public void setSoCanCuoc(String soCanCuoc) {
        this.soCanCuoc = soCanCuoc;
    }

    /**
     * @return the soTienGui
     */
    public double getSoTienGui() {
        return soTienGui;
    }

    /**
     * @param soTienGui the soTienGui to set
     */
    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    /**
     * @return the dsTaiKhoan
     */
    public List<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    /**
     * @param dsTaiKhoan the dsTaiKhoan to set
     */
    public void setDsTaiKhoan(List<TaiKhoan> dsTaiKhoan) {
        this.dsTaiKhoan = dsTaiKhoan;
    }
    
    public void guiTien() {}
    
    public void rutTien() {}
    
    private String maKH;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String soCanCuoc;
    private double soTienGui;
    private List<TaiKhoan> dsTaiKhoan;
}
