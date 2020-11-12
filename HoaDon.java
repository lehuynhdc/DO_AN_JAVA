/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadon;
import java.time.*;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
//import java.io.BufferedReader;
//import java.io.FileWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Iterator;
//import javax.swing.*;
/**
 *
 * @author DELL
 */
public class HoaDon {
    String idHoaDon;
    String tenNV;
    long tongTien; 
    LocalDateTime thoiGianXuat;
    List<String> listIDSach;
    TAOHHD taoHoaDon;
    HOADONFORM hoaDon;
    
    //constructor 
    public HoaDon(){
        this.tenNV = null;
        this.tongTien = 0;
        this.idHoaDon = null;
        this.thoiGianXuat = LocalDateTime.now();
        this.listIDSach= null;
    }
    public HoaDon(String tenNV,String idHoaDon,List<String> list,LocalDateTime thoiGian,long tien){
        this.tenNV = tenNV;
        this.idHoaDon = idHoaDon;
        this.listIDSach = list;
        this.thoiGianXuat = thoiGian;
        this.tongTien = tien;
    }
    public HoaDon(String tenNV,long tongTien,String idHoaDon,List<String> list,int year, Month month, int dayOfMonth, int hour, int minute, int second){
        this.tenNV = tenNV;
        this.tongTien = tongTien;
        this.idHoaDon = idHoaDon;
        this.thoiGianXuat.of(year,month,dayOfMonth,hour,minute,second);
        this.listIDSach = list;
    }
    public HoaDon(HoaDon hoaDon){
        this.idHoaDon = hoaDon.idHoaDon;
        this.tenNV = hoaDon.tenNV;
        this.tongTien = hoaDon.tongTien;
        this.thoiGianXuat = hoaDon.thoiGianXuat;
        this.listIDSach = hoaDon.listIDSach;
    }
    
    //các getter và setter
    public String getIDHoaDon(){
        return this.idHoaDon;
    }
    public String getTenNV(){
        return this.tenNV;
    }
    public long getTongTien(){
        return this.tongTien;
    }
    public LocalDateTime getTGXuat(){
        return this.thoiGianXuat;
    }
    public List<String> getListIDSach(){
        return this.listIDSach;
    }
    public void setIDHoaDon(String id){
        this.idHoaDon = id;
        if(ktIDHoaDon(id)){
         throw new ArithmeticException("invalinID");    
        }
    }
    public void setTenNV(String ten){
        this.tenNV = ten;
    }
    public void setTongTien(long tien){
        this.tongTien = tien;
    }
    public void setTGXuat(LocalDateTime tGXuat){
        this.thoiGianXuat = tGXuat;
    }
    public void setListIDSach(List<String> list){
        this.listIDSach = list;
    }
    //các hàm kiểm tra ràng buộc
    public boolean ktIDHoaDon(String idHoaDon){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
             File f = new File("D:/IDHoaDon.txt");
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
    
    
    //các hàm sử lý 
    public  void ghiFile(String str)throws IOException{
        File file = new File("D:/IDHoaDon.txt");
        OutputStream outputStream = new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        // Dùng để xuống hàng
        outputStreamWriter.write("\n");
        outputStreamWriter.write(str);
            
        // Đây là phương thức quan trọng!
        // Nó sẽ bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
    }
    public String autoSetIDHD(){
        String line,idEnd="";
        int check=0;
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
             File f = new File("D:/IDHoaDon.txt");
             BufferedReader br;
            //Bước 2: Đọc dữ liệu
            try (FileReader fr = new FileReader(f)) {
                //Bước 2: Đọc dữ liệu
                br = new BufferedReader(fr);                
                while ((line = br.readLine()) != null) {
                    idEnd = br.readLine();
                    if(idEnd == null){
                        check++;
                       idEnd = line.split("D")[1];
                       int temp = Integer.parseInt(idEnd);
                       temp++;
                       idEnd = String.valueOf(temp);
                    }
                }
                if(line == null && check ==0){
                       idEnd = idEnd.split("D")[1];
                       int temp = Integer.parseInt(idEnd);
                       temp++;
                       idEnd = String.valueOf(temp);
                    }
                //Bước 3: Đóng luồng
            }            
            br.close();
        } catch (IOException ex) {
            System.out.println("Loi doc file: "+ex);
          }
        return "HD"+idEnd;
    }
    public HoaDon taoHoaDonMoi(String ten){
        HoaDon hoaDon = new HoaDon();
        hoaDon.setIDHoaDon(hoaDon.autoSetIDHD());
        hoaDon.setTGXuat(LocalDateTime.now());
        hoaDon.setTenNV(ten);
        hoaDon.setTongTien(0);
        hoaDon.setListIDSach(null);
        return hoaDon;
    }
    public void huyHoaDon(HoaDon hoaDon){
        hoaDon.setIDHoaDon(null);
        hoaDon.setTGXuat(null);
        hoaDon.setTenNV(null);
        hoaDon.setTongTien(0);
        hoaDon.setListIDSach(null);
    }
    public void updateTongTien(HoaDon hoaDon){ 
        List<String> list = hoaDon.listIDSach;
        int listSize = list.size();
        long tien;
        for(String item: list){
            try {
                    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                    File f = new File("D:/sach.txt");
                    FileReader fr = new FileReader(f);
                    //Bước 2: Đọc dữ liệu
                    BufferedReader br = new BufferedReader(fr);
                    for(int i = 0; i < listSize; i++){
                        String line = br.readLine();
                        String s1 = line.split("-")[0]; 
                        if(item.equals(s1)){
                            tien = Long.parseLong(line.split("-")[2]);
                            hoaDon.setTongTien(tien + hoaDon.getTongTien());
                            break;
                        }
                    }                   
                    
                    //Bước 3: Đóng luồng
                    fr.close();
                    br.close();
            } catch (Exception ex) {
                System.out.println("Loi doc file: "+ex);
              }
        }
    }
    
    public void taoFormGhiHD(HoaDon hd){
        taoHoaDon = new TAOHHD(hd.getTenNV(),hd.getIDHoaDon(),hd.getListIDSach());
        taoHoaDon.setVisible(true);
    }
    
    public void taoFormHD(HoaDon hd){
        hoaDon = new HOADONFORM(hd.getTenNV(),hd.getIDHoaDon(),hd.getListIDSach(),hd.getTGXuat(), hd.getTongTien());
        hoaDon.setVisible(true);
    }
    
    //các hàm input
    public List<String> leakDS(){
        List<String> list = new Vector<>();
            try {
                    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
                    File f = new File("D:/sach.txt");
                    FileReader fr = new FileReader(f);
                    //Bước 2: Đọc dữ liệu
                    BufferedReader br = new BufferedReader(fr);
                    String line; 
                    while((line = br.readLine()) != null){
                        list.add(line);
                    }                    
                    //Bước 3: Đóng luồng
                    fr.close();
                    br.close();
            } catch (Exception ex) {
                System.out.println("Loi doc file: "+ex);
              }
        return list;
    }
    
    
    //các hàm output
    public void inHoaDon(HoaDon hoaDon){
        if(hoaDon.getIDHoaDon() == null){
            System.out.println("hóa đơn không tồn tại");
            return;
        }
        System.out.println("tên NV: " + hoaDon.tenNV);
        System.out.println("mã hóa đơn " + hoaDon.idHoaDon);
        System.out.println("các sách khách hàng đã mua:");
        hoaDon.listIDSach.forEach(s -> {
            System.out.println(s);
        });
        hoaDon.updateTongTien(hoaDon);
        System.out.println("tổng tiền: " + hoaDon.tongTien);
        System.out.println("thời gian xuất hóa đơn: " + hoaDon.thoiGianXuat);
    }
    
    //main để test tính năng
    public static void main(String[] args) {
       HoaDon hoaDon = new HoaDon();
       hoaDon = hoaDon.taoHoaDonMoi("Lê Huỳnh Đức");
       List<String> listIDSach = new Vector<>();
       listIDSach = hoaDon.leakDS();
       hoaDon.setListIDSach(listIDSach);
       hoaDon.taoFormGhiHD(hoaDon);
       
    }    
}
