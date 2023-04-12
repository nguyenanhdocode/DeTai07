/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.htu.detai07;

import com.htu.entity.KhachHang;
import com.htu.entity.LoaiKyHan;
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
                case 4:
                    guiTien();
                    break;
                case 5:
                    rutTien();
                    break;
                case 6:
                    timKiem();
                    break;
                case 7:
                    traCuuDsTaiKhoan();
                    break;
                default:
                    break;
            }

            if (selectionIndex == 8)
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
        System.out.print("4. Gui tien\n");
        System.out.print("5. Rut tien\n");
        System.out.print("6. Tim kiem\n");
        System.out.print("7. Tra cuu danh sach tai khoan cua khach hang\n");
        System.out.print("8. Thoat\n");
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
                laiSuat = LoaiKyHan.MOT_TUAN.getLaiSuat();
            } else if (kyHan == 2) {
                // Mot thang
                calendar.add(Calendar.MONTH, 1);
                laiSuat = LoaiKyHan.MOT_THANG.getLaiSuat();
            } else if (kyHan == 3) {
                // Sau thang
                calendar.add(Calendar.MONTH, 6);
                laiSuat = LoaiKyHan.SAU_THANG.getLaiSuat();
            } else if (kyHan == 4) {
                // Mot thang
                calendar.add(Calendar.YEAR, 1);
                laiSuat = LoaiKyHan.MOT_NAM.getLaiSuat();
            }

            ngayDaoHan = calendar.getTime();
            String maKH = tkHienTai.getKhachHang().getMaKH();
            Date ngayGui = Calendar.getInstance().getTime();
            quanLiTK.moTaiKhoanKyHan(maKH, soTienGui, ngayGui, laiSuat, ngayDaoHan);
            
            System.out.print("---------------------------------------\n");
            System.out.print("Da mo tai khoan ky han thanh cong!\n");
            System.out.printf("So tien gui: %.2f %s\n", soTienGui, "VND");
            System.out.printf("Lai suat: %.2f %s\n", laiSuat * 100, "%");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.printf("Ngay dao han: %s\n", dateFormat.format(ngayDaoHan));
        }
        else{
            System.out.print("Vui long dang nhap!\n");
        }
    }
    
    public static void rutTien() {
        System.out.print("Nhap so tien can rut: ");
        Scanner scan = new Scanner(System.in);
        double soTien = scan.nextDouble();
        
        double soDu = quanLiTK.rutTien(tkHienTai.getKhachHang().getMaKH(), soTien);
        
        System.out.print("Rut tien thanh cong!\n");
        System.out.printf("So du: %.2f VND\n", soDu);
    }
    
    public static void guiTien() {
        System.out.print("Nhap so tien can gui: ");
        Scanner scan = new Scanner(System.in);
        double soTien = scan.nextDouble();
        
        double soDu = quanLiTK.guiTien(tkHienTai.getKhachHang().getMaKH(), soTien);
        
        System.out.print("Gui tien thanh cong!\n");
        System.out.printf("So du: %.2f VND\n", soDu);
    }
    
    // Xử lí tìm kiếm khách hàng theo họ tên hoặc mã số khách hàng
    public static void timKiem() {
        System.out.print("Nhap ho ten hoac ma so khach hang: ");
        Scanner scan = new Scanner(System.in);
        String thongTinTimKiem = scan.nextLine();
        
        List<KhachHang> dsKH = quanLiTK.timKiemTheoMaKH(thongTinTimKiem);
        
        List<KhachHang> dsKHTheoTen = quanLiTK.timKiemTheoTen(thongTinTimKiem);
        
        dsKH.addAll(dsKHTheoTen);
        
        System.out.printf("-------------Ket qua tim kiem-------------\n");
        
        if (dsKH.isEmpty()) {
            System.out.printf("Khong tim thay '%s'\n", thongTinTimKiem);
        }
        
        for (int i = 0; i < dsKH.size(); i++) {
            KhachHang kh = dsKH.get(i);
            System.out.printf("Ma so khach hang: %s\n", kh.getMaKH());
            System.out.printf("Ho ten: %s\n", kh.getHoTen());
            System.out.printf("CCCD: %s\n", kh.getSoCanCuoc());
            System.out.printf("Gioi tinh: %s\n", kh.getGioiTinh());
            System.out.printf("Que quan: %s\n\n", kh.getQueQuan());
        }
        
    }
    
    public static void traCuuDsTaiKhoan() {
        System.out.print("Nhap ma so khach hang: ");
        Scanner scan = new Scanner(System.in);
        String maKH = scan.nextLine();
        
        List<TaiKhoan> dsTK = quanLiTK.traCuuDsTaiKhoan(maKH);
        for (int i = 0; i < dsTK.size(); i++) {
            
        }
    }
}
