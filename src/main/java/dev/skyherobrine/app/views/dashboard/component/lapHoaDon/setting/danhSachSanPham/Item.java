/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Virtue Nguyen
 */
public class Item extends javax.swing.JPanel {

    /**
     * Creates new form Item
     */
    public Item() {
        initComponents();
        
        //khu vực chỉnh sửa nhé tên và các thành phàn của item

            Imformation(3);

    }
    
    private void Imformation(int i){
        URL url = getClass().getResource("/img/imgTest/"+i+".png");
        if (url != null) {
            ImageIcon iconGoc = new ImageIcon(url);
            Image anh = iconGoc.getImage();
            Image tinhChinhAnh = anh.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(tinhChinhAnh);
            lbAnhItem.setIcon(icon);
            lbTenSanPham.setText("Giày số hiệu"+i);
            lbGiaTienSo.setText(i+" tỷ");
            lbSoLuongSanPhamChinhSo.setText(""+i);
        }
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAnhItem = new javax.swing.JLabel();
        lbTenSanPham = new javax.swing.JLabel();
        pnSoLuongSpChu = new javax.swing.JLabel();
        lbSoLuongSanPhamChinhSo = new javax.swing.JLabel();
        pnGia = new javax.swing.JLabel();
        lbGiaTienSo = new javax.swing.JLabel();
        pnDonViTienTe = new javax.swing.JLabel();

        lbAnhItem.setBackground(new java.awt.Color(255, 255, 102));

        lbTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSanPham.setText("Tên sản phẩm");

        pnSoLuongSpChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnSoLuongSpChu.setText("Số lượng:");

        lbSoLuongSanPhamChinhSo.setText("null");

        pnGia.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pnGia.setText("Giá");

        lbGiaTienSo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbGiaTienSo.setText("00.0");

        pnDonViTienTe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnDonViTienTe.setText("đ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenSanPham)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnSoLuongSpChu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSoLuongSanPhamChinhSo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(pnGia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(lbGiaTienSo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnDonViTienTe)))
                .addContainerGap())
            .addComponent(lbAnhItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTenSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnSoLuongSpChu)
                    .addComponent(lbSoLuongSanPhamChinhSo))
                .addGap(10, 10, 10)
                .addComponent(lbAnhItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnGia)
                    .addComponent(lbGiaTienSo)
                    .addComponent(pnDonViTienTe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbAnhItem;
    private javax.swing.JLabel lbGiaTienSo;
    private javax.swing.JLabel lbSoLuongSanPhamChinhSo;
    private javax.swing.JLabel lbTenSanPham;
    private javax.swing.JLabel pnDonViTienTe;
    private javax.swing.JLabel pnGia;
    private javax.swing.JLabel pnSoLuongSpChu;
    // End of variables declaration//GEN-END:variables
}