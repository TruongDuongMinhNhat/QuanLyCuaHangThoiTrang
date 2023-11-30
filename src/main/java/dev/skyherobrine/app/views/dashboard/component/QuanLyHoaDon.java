/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

import com.toedter.calendar.JDateChooser;
//import dev.skyherobrine.app.controllers.dashboardui.QuanLyHoaDon.HoaDonController;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class QuanLyHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public QuanLyHoaDon() {
        initComponents();
//        new HoaDonController(this).loadDsHoaDon();
//        HoaDonController.loadCbMucTien();
//        tbDanhSachHoaDon.addMouseListener(new HoaDonController(this));
//        btnInHoaDon.addActionListener(new HoaDonController(this));
//        btnXuatHoaDon.addActionListener(new HoaDonController(this));
//        txtTuKhoaTimKiem.addKeyListener(new HoaDonController(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
//     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBGThongTinCaNhan = new javax.swing.JPanel();
        pnDanhSachHoaDon = new javax.swing.JPanel();
        spDanhSachHoaDon = new javax.swing.JScrollPane();
        tbDanhSachHoaDon = new javax.swing.JTable();
        pnTimKiemHoaDon = new javax.swing.JPanel();
        cbTkCaLamViec = new javax.swing.JComboBox<>();
        txtTuKhoaTimKiem = new javax.swing.JTextField();
        btnXuatHoaDon = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        jDateChooserNgayLapHoaDon = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        lbTuKhoaTimKiem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnHoaDon = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnDanhSachHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách hoá đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Nhân viên", "Khách hàng", "Tổng tiền"
            }
        ));
        spDanhSachHoaDon.setViewportView(tbDanhSachHoaDon);

        javax.swing.GroupLayout pnDanhSachHoaDonLayout = new javax.swing.GroupLayout(pnDanhSachHoaDon);
        pnDanhSachHoaDon.setLayout(pnDanhSachHoaDonLayout);
        pnDanhSachHoaDonLayout.setHorizontalGroup(
            pnDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        pnDanhSachHoaDonLayout.setVerticalGroup(
            pnDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
        );

        pnTimKiemHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm hoá đơn ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        cbTkCaLamViec.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkCaLamViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca làm việc", " " }));

        txtTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTuKhoaTimKiem.setToolTipText("");

        btnXuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatHoaDon.setText("xuất hoá đơn");

        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInHoaDon.setText("In hoá đơn");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ngày lập hoá đơn:");

        lbTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTuKhoaTimKiem.setText("Từ khoá tìm kiếm:");

        javax.swing.GroupLayout pnTimKiemHoaDonLayout = new javax.swing.GroupLayout(pnTimKiemHoaDon);
        pnTimKiemHoaDon.setLayout(pnTimKiemHoaDonLayout);
        pnTimKiemHoaDonLayout.setHorizontalGroup(
            pnTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(cbTkCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186)
                .addComponent(lbTuKhoaTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXuatHoaDon)
                .addGap(18, 18, 18)
                .addComponent(btnInHoaDon)
                .addContainerGap())
        );
        pnTimKiemHoaDonLayout.setVerticalGroup(
            pnTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTuKhoaTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTkCaLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserNgayLapHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        pnHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTimKiemHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnInHoaDon() {
        return btnInHoaDon;
    }
    public JButton getBtnXuatHoaDon() {
        return btnXuatHoaDon;
    }

    public JComboBox<String> getCbTkCaLamViec() {
        return cbTkCaLamViec;
    }
    public JTable getTbDanhSachHoaDon() {
        return tbDanhSachHoaDon;
    }
    public JTextField getTxtTuKhoaTimKiem() {
        return txtTuKhoaTimKiem;
    }
    public JDateChooser getjDateChooserNgayLapHoaDon() {
        return jDateChooserNgayLapHoaDon;
    }
    public JPanel getjPanel1() {
        return jPanel1;
    }
    public JPanel getPnHoaDon(){
        return pnHoaDon;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JComboBox<String> cbTkCaLamViec;
    private com.toedter.calendar.JDateChooser jDateChooserNgayLapHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTuKhoaTimKiem;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachHoaDon;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JPanel pnTimKiemHoaDon;
    private javax.swing.JScrollPane spDanhSachHoaDon;
    private javax.swing.JTable tbDanhSachHoaDon;
    private javax.swing.JTextField txtTuKhoaTimKiem;
    // End of variables declaration//GEN-END:variables
}
