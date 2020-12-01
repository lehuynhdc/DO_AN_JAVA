/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadon;

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
//import java.util.Vector;

/**
 *
 * @author DELL
 */
public class HOADONFORM extends javax.swing.JFrame {

    /**
     * Creates new form HOADONFORM
     */
    private List<String> dsMua =  new Vector<>();
    private List<Integer> arraySL = new Vector<>();
    public HOADONFORM() {
        initComponents();
    }
    public HOADONFORM(String tenNV, String maHD, List<String> list, LocalDateTime thoiGianXuat,long tongTien) {
        initComponents();
        String temp,s1[];
        this.inTenNV.setText(tenNV);
        this.inMaHD.setText(maHD);
        temp = thoiGianXuat.format(DateTimeFormatter.ofPattern("d/MMM/uuuu HH:mm:ss"));
        this.inTG.setText(temp);
        temp = String.valueOf(tongTien);
        this.inTongTien.setText(temp + " vnđ");
        
        DefaultTableModel model = new DefaultTableModel();
        String a[] = {"       STT", "   Mã Sách", "  Tên Sách", "  Số Lượng", "   Giá Tiền"};
        model.setColumnIdentifiers(a);
        
        ArrayList arrRows = new ArrayList();
        int j = 0;
        List<Integer> arrSL = this.soLuongSach(list);
        arrSL = this.editArrSL(list, arrSL);
        this.arraySL = arrSL;
        list = this.editListDS(list);
        this.dsMua = list;
        for(String i : list) {            
            s1 = i.split("-");
            arrRows.add(String.valueOf(j+1));
            arrRows.add(String.valueOf(s1[0]));
            arrRows.add(String.valueOf(s1[1]));
            arrRows.add(String.valueOf(arrSL.get(j)));
            arrRows.add(String.valueOf(s1[2]));
            model.addRow(arrRows.toArray());
            arrRows.clear();
            j++;
        }
        
        this.DSMuaHang.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TenNV = new javax.swing.JLabel();
        TC = new javax.swing.JLabel();
        TGXuat = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DSMuaHang = new javax.swing.JTable();
        MHD = new javax.swing.JLabel();
        inTG = new javax.swing.JLabel();
        inTenNV = new javax.swing.JLabel();
        inMaHD = new javax.swing.JLabel();
        inTongTien = new javax.swing.JLabel();
        btn_Finish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TenNV.setText("   Tên Nhân Viên");

        TC.setText("Tổng cộng:");

        TGXuat.setText("   Thời gian xuất");

        DSMuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "s1", null, null, null},
                {"2", null, null, null, null},
                {"3", null, null, null, null},
                {"4", null, null, null, null},
                {"5", null, null, null, null},
                {"6", null, null, null, null},
                {"7", null, null, null, null},
                {"8", null, null, null, null},
                {"9", null, null, null, null},
                {"10", null, null, null, null},
                {"11", null, null, null, null},
                {"12", null, null, null, null},
                {"13", null, null, null, null},
                {"14", null, null, null, null},
                {"15", null, null, null, null},
                {"16", null, null, null, null},
                {"17", null, null, null, null},
                {"18", null, null, null, null},
                {"19", null, null, null, null},
                {"20", null, null, null, null},
                {"21", null, null, null, null},
                {"22", null, null, null, null},
                {"23", "", null, null, null},
                {"24", null, null, null, null},
                {"25", null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sách", "               Tên Sách", "Số Lượng", "   Giá Tiền"
            }
        ));
        jScrollPane2.setViewportView(DSMuaHang);
        if (DSMuaHang.getColumnModel().getColumnCount() > 0) {
            DSMuaHang.getColumnModel().getColumn(0).setPreferredWidth(5);
            DSMuaHang.getColumnModel().getColumn(1).setPreferredWidth(30);
            DSMuaHang.getColumnModel().getColumn(2).setPreferredWidth(150);
            DSMuaHang.getColumnModel().getColumn(3).setPreferredWidth(30);
            DSMuaHang.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        MHD.setText("      Mã Hóa Đơn");

        btn_Finish.setText("Finish");
        btn_Finish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FinishMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TGXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MHD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inTG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(inMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(190, 190, 190))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Finish))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TGXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inTG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Finish))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_FinishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FinishMouseClicked
        // TODO add your handling code here:
        HoaDon hd = new HoaDon();
        try {
            hd.ghiFile(this.getMAHD());
        } catch (IOException ex) {
            Logger.getLogger(HOADONFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        try {
            this.ghiFile();
        } catch (IOException ex) {
            Logger.getLogger(HOADONFORM.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_btn_FinishMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOADONFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOADONFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DSMuaHang;
    private javax.swing.JLabel MHD;
    private javax.swing.JLabel TC;
    private javax.swing.JLabel TGXuat;
    private javax.swing.JLabel TenNV;
    private javax.swing.JButton btn_Finish;
    private javax.swing.JLabel inMaHD;
    private javax.swing.JLabel inTG;
    private javax.swing.JLabel inTenNV;
    private javax.swing.JLabel inTongTien;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    //setter and getter
    public void setTenNV(String ten){
        this.inTenNV.setText(ten);
    }
    public void setMAHD(String id){
        this.inMaHD.setText(id);
    }
    public void setTGX(LocalDateTime thoiGianXuat){
        String temp = thoiGianXuat.format(DateTimeFormatter.ofPattern("d/MMM/uuuu HH:mm:ss"));
    }
    public void setTongTien(long tien){
        String temp = String.valueOf(tien);
        this.inTongTien.setText(temp + " vnđ");
    }
    public void setlist(List<String> list){
        this.DSMuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"         1", null, null, null, null},
                {"         2", null, null, null, null},
                {"         3", null, null, null, null},
                {"         4", null, null, null, null},
                {"         5", null, null, null, null},
                {"         6", null, null, null, null},
                {"         7", null, null, null, null},
                {"         8", null, null, null, null},
                {"         9", null, null, null, null},
                {"         10", null, null, null, null},
                {"         11", null, null, null, null},
                {"         12", null, null, null, null},
                {"         13", null, null, null, null},
                {"         14", null, null, null, null},
                {"         15", null, null, null, null},
                {"         16", null, null, null, null},
                {"         17", null, null, null, null},
                {"         18", null, null, null, null},
                {"         19", null, null, null, null},
                {"         20", null, null, null, null},
                {"         21", null, null, null, null},
                {"         22", null, null, null, null},
                {"         23", null, null, null, null},
                {"         24", null, null, null, null},
                {"         25", null, null, null, null}
            },
            new String [] {
                "       STT", "   Mã Sách", "  Tên Sách", "  Số Lượng", "   Giá Tiền"
            }
        ));
    }
    public void setDSMua(List<String> list){
        this.dsMua = list;
    }
    public void setArraySL(List<Integer> list){
        this.arraySL = list;
    }
    public String getTenNV(){
        return this.inTenNV.getText();
    }
    public String getMAHD(){
        return this.inMaHD.getText();
    }
    public String getTongTien(){
        return this.inTongTien.getText();
    }
    public String getTG(){
        return this.inTG.getText();
    }
    public List<String> getDSMua(){
        return dsMua;
    }
    public List<Integer> getArraySL(){
        return arraySL;
    }
    
    //cac ham xu ly
    public List<Integer> soLuongSach(List<String> list){
        int soLuong = 0;
        ArrayList<Integer> arrSL = new ArrayList<>();
        for(String i : list){
            for(String j : list){
                if(i == j){
                    soLuong++;
                }
            } 
            arrSL.add(soLuong);
            soLuong = 0;
        }
        return arrSL;
    }
    public List<String> editListDS(List<String> list){
        for(int i = 0;i < list.size();i++){
            for(int j = i+1;j < list.size();j++){
                if(list.get(i) == list.get(j)){
                    list.remove(j);
                }
            }
        }
        return list;
    }
    public List<Integer> editArrSL(List<String> list,List<Integer> arrRows){
        for(int i = 0;i < list.size();i++){
            for(int j = i+1;j < list.size();j++){
                if(list.get(i) == list.get(j)){
                    arrRows.remove(j);
                    list.remove(j);
                }
            }
        }
        return arrRows;
    }
    public  void ghiFile()throws IOException{
        File file = new File("D:/HoaDon.txt"); 
        OutputStream outputStream = new FileOutputStream(file,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        List<String> dsMua = this.getDSMua(),temp = new Vector<>();
        List<Integer> arrSL = this.getArraySL();
        for(int i =0 ; i < dsMua.size();i++){
            temp.add(dsMua.get(i).concat("-" + arrSL.get(i).toString()));   
        }
        // Dùng để xuống hàng        
        outputStreamWriter.write(this.getMAHD());
        outputStreamWriter.write("\n");
        outputStreamWriter.write(this.getTenNV());
        outputStreamWriter.write("\n");
        outputStreamWriter.write(this.getTG());
        outputStreamWriter.write("\n");
        for(String i : temp){
            outputStreamWriter.write(i);
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.write(this.getTongTien());
        outputStreamWriter.write("\n");
        outputStreamWriter.write("-------------------------------------------------------------------------------------");
        outputStreamWriter.write("\n");
        
        // Đây là phương thức quan trọng!
        // Nó sẽ bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
    }
}
