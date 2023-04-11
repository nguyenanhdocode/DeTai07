/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.htu.detai07;

import com.htu.entity.KhachHang;
import com.htu.entity.TaiKhoan;
import com.htu.entity.TaiKhoanHeThong;
import com.htu.entity.TaiKhoanKhongKyHan;
import com.htu.manage.QuanLiKhachHang;
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
    private static QuanLiKhachHang quanLiKH = new QuanLiKhachHang();
    private static int selectionIndex = -1;
    private static TaiKhoanHeThong tkHienTai;
    
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
                case 3:
                    moTaiKhoanKyHan();
                    break;
                default:
                    break;
            }

            if (selectionIndex == 4)
                break;
        }
    }
    
    public static void init() {
        quanLiTK = new QuanLiTaiKhoan();
    }
    
	// Xử lí in menu
    public static void printMenu() {
        System.out.print("--------------- Chon chuc nang ---------------\n");
        System.out.print("1. Mo tai khoan khong ky han\n");
        System.out.print("2. Dang nhap\n");
        System.out.print("3. Mo tai khoan ky han\n");
        System.out.print("4. Thoat\n");
    }
    
	// Xử lý chức năng tạo tài khoản không kỳ hạn
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
        
		// Tạo thông tin khách hàng
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
        
	       // Tạo tài khoản không kỳ hạn
        TaiKhoan tkKhongKH = new TaiKhoanKhongKyHan(0.2, convertedDate);

        // Add tài khoản không kỳ hạn mặc định vào danh sách tài khoản của khách hàng
        List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        dsTaiKhoan.add(tkKhongKH);
        kh.setDsTaiKhoan(dsTaiKhoan);

        // Add vào tài khoản hệ thống
        TaiKhoanHeThong tk = quanLiTK.moTaiKhoanKhongKyHan(kh);
        quanLiKH.themKhachHang(tk.getKhachHang());
        
        printKhachHang(tk);
    }
    
	// Xử lí in thông tin tài khoản hệ thống
    public static void printKhachHang(TaiKhoanHeThong tk) {
        System.out.printf("-------Thong tin tai khoan----------\n");
        System.out.printf("Khach hang: %s\n", tk.getKhachHang().getHoTen());
        System.out.printf("Username: %s\n", tk.getUserName());
        System.out.printf("Mat khau: %s\n", tk.getPassword());
    }
    
	// Xử lí đăng nhập
    public static void dangNhap() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ten dang nhap: ");
        String username = scan.nextLine();
        
        System.out.print("Mat khau: ");
        String password = scan.nextLine();
        
        // Kiểm tra thông tin đăng nhập
        TaiKhoanHeThong tk = null;
        for (int i = 0; i < quanLiTK.getDsTaiKhoan().size(); i++) {
            TaiKhoanHeThong tkHeThong = quanLiTK.getDsTaiKhoan().get(i);
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
            tkHienTai = tk;
            System.out.printf("Xin chao: %s\n", kh.getHoTen());
        }
    }
    
    public static void moTaiKhoanKyHan() {
        if (tkHienTai != null) {
            
            System.out.print("1. MOT TUAN:\n");
            System.out.print("2. MOT THANG:\n");
            System.out.print("3. SAU THANG:\n");
            System.out.print("4. MOT NAM:\n");
            System.out.print("Lua chon ky han: ");
            
            double soDu = tkHienTai.getKhachHang().getSoTienGui();
            
            if (soDu < 50000) {
                System.out.print("So du phai toi thieu 50.000\n");
                return;
            }
            
            int kyHan = 0;
            Scanner scan = new Scanner(System.in);
            kyHan = scan.nextInt();
            
            double soTienGui = 0;
            
            while (soTienGui < 100000) {
                System.out.print("So tien gui: ");
                soTienGui = scan.nextDouble();
                if (soTienGui < 100000) {
                    System.out.print("So tien gui phai toi thieu 100.000: \n");
                }
            }

            Date ngayDaoHan = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ngayDaoHan);

            double laiSuat = 0;

            if (kyHan == 1) {
                // Mot tuan
                calendar.add(Calendar.DATE, 7);
                laiSuat = 2;
            } else if (kyHan == 2) {
                // Mot thang
                calendar.add(Calendar.MONTH, 1);
                laiSuat = 5.5;
            } else if (kyHan == 3) {
                // Sau thang
                calendar.add(Calendar.MONTH, 6);
                laiSuat = 7.5;
            } else if (kyHan == 4) {
                // Mot thang
                calendar.add(Calendar.YEAR, 1);
                laiSuat = 7.9;
            }

            ngayDaoHan = calendar.getTime();
            String maKH = tkHienTai.getKhachHang().getMaKH();
            Date ngayGui = Calendar.getInstance().getTime();
            quanLiTK.moTaiKhoanKyHan(maKH, soTienGui, ngayGui, laiSuat, ngayDaoHan);
            
            System.out.print("---------------------------------------\n");
            System.out.print("Da mo tai khoan ky han thanh cong!\n");
            System.out.printf("So tien gui: %f\n", soTienGui);
            System.out.printf("Lai suat: %f\n", laiSuat);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.printf("Ngay dao han: %s\n", dateFormat.format(ngayDaoHan));
        }
        else{
            System.out.print("Dang nhap di loz\n");
        }
    }
}
