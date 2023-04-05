/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.htu.detai07;

import com.htu.entity.KhachHang;
import com.htu.entity.TaiKhoan;
import com.htu.entity.TaiKhoanHeThong;
import com.htu.entity.TaiKhoanKhongKyHan;
import com.htu.manage.QuanLiTaiKhoan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class DeTai07 {

    private static QuanLiTaiKhoan quanLiTK = new QuanLiTaiKhoan();
    private static int selectionIndex = -1;
    
    public static void main(String[] args) throws ParseException {
        init();
        
        while (true) {
            printMenu();

            System.out.print("Lua chon: ");
            Scanner scan = new Scanner(System.in);

            selectionIndex = scan.nextInt();

            switch (selectionIndex) {
                case 1:
                    moTaiKhoanKhongKyHan();
                    break;
                case 2:
                    dangNhap();
                    break;
                default:
                    break;
            }

            if (selectionIndex == 3)
                break;
        }
    }
    
    public static void init() {
        quanLiTK = new QuanLiTaiKhoan();
    }
    
    public static void printMenu() {
        System.out.print("--------------- Chon chuc nang ---------------\n");
        System.out.print("1. Mo tai khoan khong ky han\n");
        System.out.print("2. Dang nhap\n");
        System.out.print("3. Thoat\n");
    }
    
    public static void moTaiKhoanKhongKyHan() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ho ten: ");
        String hoTen = scan.nextLine();
        
        System.out.print("Gioi tinh: ");
        String gioiTinh = scan.nextLine();
        
        System.out.print("Ngay sinh: ");
        String ngaySinh = scan.nextLine();
        
        System.out.print("Que quan: ");
        String queQuan = scan.nextLine();
        
        System.out.print("CCCD: ");
        String cccd = scan.nextLine();
        
        System.out.print("So tien gui: ");
        double soTienGui = scan.nextDouble();
        
        KhachHang kh = new KhachHang();
        kh.setHoTen(hoTen);
        kh.setGioiTinh(gioiTinh);
        
        Calendar mydate = new GregorianCalendar();
        String mystring = ngaySinh;
        Date convertedDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(mystring);
        
        kh.setNgaySinh(convertedDate);
        kh.setQueQuan(queQuan);
        kh.setSoCanCuoc(cccd);
        kh.setSoTienGui(soTienGui);
        
        TaiKhoan tkKhongKH = new TaiKhoanKhongKyHan(0.2, convertedDate);
        List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        dsTaiKhoan.add(tkKhongKH);
        kh.setDsTaiKhoan(dsTaiKhoan);
        
        TaiKhoanHeThong tk = quanLiTK.moTaiKhoanKhongKyHan(kh);
        
        printKhachHang(tk);
    }
    
    public static void printKhachHang(TaiKhoanHeThong tk) {
        System.out.printf("-------Thong tin tai khoan----------\n");
        System.out.printf("Khach hang: %s\n", tk.getKhachHang().getHoTen());
        System.out.printf("Username: %s\n", tk.getUserName());
        System.out.printf("Mat khau: %s\n", tk.getPassword());
    }
    
    public static void dangNhap() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ten dang nhap: ");
        String username = scan.nextLine();
        
        System.out.print("Mat khau: ");
        String password = scan.nextLine();
        
        // Kiểm tra thông tin đăng nhập
        TaiKhoanHeThong tk = null;
        for (int i = 0; i < quanLiTK.getDsTaiKhoang().size(); i++) {
            TaiKhoanHeThong tkHeThong = quanLiTK.getDsTaiKhoang().get(i);
            if (tkHeThong.getUserName().equals(username) && tkHeThong.getPassword().equals(password)) {
                tk = tkHeThong;
                break;
            }
        }
        
        if (tk == null) {
            System.out.print("\nThong tin dang nhap khong chinh xac. Vui long kiem tra lai!");
        }
        else {
            KhachHang kh = tk.getKhachHang();
            System.out.printf("Xin chao: %s\n", kh.getHoTen());
        }
    }
}
