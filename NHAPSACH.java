/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadon;
import java.time.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author DELL
 */
public class NHAPSACH extends HoaDon{
//    constructor and getter setter
    public NHAPSACH(){
        super();
    }
    public NHAPSACH(String tenNV,long tongTien,String idHoaDon,List<String> list,int year, Month month, int dayOfMonth, int hour, int minute, int second){
        super();
    }
    public NHAPSACH(NHAPSACH ns){
        this.idHoaDon = ns.idHoaDon;
        this.tenNV = ns.tenNV;
        this.listIDSach = ns.listIDSach;
        this.thoiGianXuat = ns.thoiGianXuat;
        this.tongTien = ns.tongTien;
    }
    
    
    //các hàm kiểm tra ràng buộc
    @Override
    public boolean ktIDHoaDon(String idHoaDon){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
             File f = new File("D:/IDNhapSach.txt");
             BufferedReader br;
            //Bước 2: Đọc dữ liệu
            try (FileReader fr = new FileReader(f)) {
                //Bước 2: Đọc dữ liệu
                br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    return line.equals(idHoaDon);
                }
                //Bước 3: Đóng luồng
            }
              br.close();
        } catch (IOException ex) {
            System.out.println("Loi doc file: "+ex);
          }
        return false;
    }
    
//    main test các phương thức
    public static void main(String[] args) {
        NHAPSACH ns = new NHAPSACH();
        ns.getIDHoaDon();
    }
}
