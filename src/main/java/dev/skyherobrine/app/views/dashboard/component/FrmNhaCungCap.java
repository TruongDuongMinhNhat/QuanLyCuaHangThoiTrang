/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

import dev.skyherobrine.app.controllers.dashboardui.person.NhaCungCapController;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class FrmNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public FrmNhaCungCap() {
        initComponents();
        new NhaCungCapController(this).loaddsNhaCungCap();
        new NhaCungCapController(this).loadComboBoxPhanThongTinNCC();
        new NhaCungCapController(this).loadComboBoxPhanTimKiem();
        tbDanhSachCacNhaCungCap.addMouseListener(new NhaCungCapController(this));
        btnThemNhaCungCap.addActionListener(new NhaCungCapController(this));
        btnSuaNhaCungCap.addActionListener(new NhaCungCapController(this));
        btnXoaNhaCungCap.addActionListener(new NhaCungCapController(this));

        cbTkTinhTrangNhaCungCap.addActionListener(new NhaCungCapController(this));
        txtTuKhoaTimKiem.addKeyListener(new NhaCungCapController(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBGThongTinCaNhan = new javax.swing.JPanel();
        pnDanhSachCacNhaCungCap = new javax.swing.JPanel();
        spDanhCacNhaCungCap = new javax.swing.JScrollPane();
        tbDanhSachCacNhaCungCap = new javax.swing.JTable();
        pnTimKiemNhaCungCap = new javax.swing.JPanel();
        cbTkTinhTrangNhaCungCap = new javax.swing.JComboBox<>();
        txtTuKhoaTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnThongTInNhaCungCap = new javax.swing.JPanel();
        lbMaNhaCungCap = new javax.swing.JLabel();
        lbTenNhaCungCap = new javax.swing.JLabel();
        lbDiaChiNhaCungCap = new javax.swing.JLabel();
        lbEmailNhaCungCap = new javax.swing.JLabel();
        lbTinhTrangNhaCungCap = new javax.swing.JLabel();
        txtMaNhaCungCap = new javax.swing.JTextField();
        txtTenNhaCungCap = new javax.swing.JTextField();
        txtTenNhaCungCap.setEnabled(false);
        txtDiaChiNhaCungCap = new javax.swing.JTextField();
        txtDiaChiNhaCungCap.setEnabled(false);
        cbTinhTrangNhaCungCap = new javax.swing.JComboBox<>();
        cbTinhTrangNhaCungCap.setEnabled(false);
        txtEmailNhaCungCap = new javax.swing.JTextField();
        txtEmailNhaCungCap.setEnabled(false);
        btnThemNhaCungCap = new javax.swing.JButton();
        btnSuaNhaCungCap = new javax.swing.JButton();
        btnXoaNhaCungCap = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnDanhSachCacNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachCacNhaCungCap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách các nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachCacNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Email", "Tình trạng"
            }
        ));
        spDanhCacNhaCungCap.setViewportView(tbDanhSachCacNhaCungCap);

        javax.swing.GroupLayout pnDanhSachCacNhaCungCapLayout = new javax.swing.GroupLayout(pnDanhSachCacNhaCungCap);
        pnDanhSachCacNhaCungCap.setLayout(pnDanhSachCacNhaCungCapLayout);
        pnDanhSachCacNhaCungCapLayout.setHorizontalGroup(
            pnDanhSachCacNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDanhSachCacNhaCungCapLayout.createSequentialGroup()
                .addComponent(spDanhCacNhaCungCap)
                .addContainerGap())
        );
        pnDanhSachCacNhaCungCapLayout.setVerticalGroup(
            pnDanhSachCacNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDanhSachCacNhaCungCapLayout.createSequentialGroup()
                .addComponent(spDanhCacNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTimKiemNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemNhaCungCap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cbTkTinhTrangNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkTinhTrangNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tình trạng", " ", " ", " " }));

        txtTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Từ khoá tìm kiếm:");

        javax.swing.GroupLayout pnTimKiemNhaCungCapLayout = new javax.swing.GroupLayout(pnTimKiemNhaCungCap);
        pnTimKiemNhaCungCap.setLayout(pnTimKiemNhaCungCapLayout);
        pnTimKiemNhaCungCapLayout.setHorizontalGroup(
            pnTimKiemNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemNhaCungCapLayout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(cbTkTinhTrangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        pnTimKiemNhaCungCapLayout.setVerticalGroup(
            pnTimKiemNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemNhaCungCapLayout.createSequentialGroup()
                .addGroup(pnTimKiemNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(cbTkTinhTrangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnThongTInNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTInNhaCungCap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbMaNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaNhaCungCap.setText("Mã nhà cung cấp:");

        lbTenNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenNhaCungCap.setText("Tên nhà cung cấp:");

        lbDiaChiNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDiaChiNhaCungCap.setText("Địa chỉ:");

        lbEmailNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbEmailNhaCungCap.setText("Email:");

        lbTinhTrangNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTinhTrangNhaCungCap.setText("Tình trạng:");

        txtMaNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaNhaCungCap.setEnabled(false);

        txtTenNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtDiaChiNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        cbTinhTrangNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtEmailNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnThemNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemNhaCungCap.setText("Thêm nhà cung cấp");

        btnSuaNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaNhaCungCap.setText("Sửa nhà cung cấp");

        btnXoaNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaNhaCungCap.setText("Xoá nhà cung cấp");

        javax.swing.GroupLayout pnThongTInNhaCungCapLayout = new javax.swing.GroupLayout(pnThongTInNhaCungCap);
        pnThongTInNhaCungCap.setLayout(pnThongTInNhaCungCapLayout);
        pnThongTInNhaCungCapLayout.setHorizontalGroup(
            pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInNhaCungCapLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(btnThemNhaCungCap)
                .addGap(274, 274, 274)
                .addComponent(btnSuaNhaCungCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(btnXoaNhaCungCap)
                .addGap(265, 265, 265))
            .addGroup(pnThongTInNhaCungCapLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTInNhaCungCapLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbMaNhaCungCap))
                    .addComponent(lbTinhTrangNhaCungCap)
                    .addComponent(lbEmailNhaCungCap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTinhTrangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnThongTInNhaCungCapLayout.createSequentialGroup()
                        .addComponent(lbDiaChiNhaCungCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChiNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTInNhaCungCapLayout.createSequentialGroup()
                        .addComponent(lbTenNhaCungCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(183, 183, 183))
        );
        pnThongTInNhaCungCapLayout.setVerticalGroup(
            pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInNhaCungCapLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChiNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiaChiNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmailNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTinhTrangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTinhTrangNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(pnThongTInNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnDanhSachCacNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnThongTInNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTimKiemNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachCacNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTInNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaNhaCungCap;
    private javax.swing.JButton btnThemNhaCungCap;
    private javax.swing.JButton btnXoaNhaCungCap;
    private javax.swing.JComboBox<String> cbTkTinhTrangNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDiaChiNhaCungCap;
    private javax.swing.JLabel lbEmailNhaCungCap;
    private javax.swing.JLabel lbMaNhaCungCap;
    private javax.swing.JLabel lbTenNhaCungCap;
    private javax.swing.JLabel lbTinhTrangNhaCungCap;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachCacNhaCungCap;
    private javax.swing.JPanel pnThongTInNhaCungCap;
    private javax.swing.JPanel pnTimKiemNhaCungCap;
    private javax.swing.JScrollPane spDanhCacNhaCungCap;
    private javax.swing.JTable tbDanhSachCacNhaCungCap;
    private javax.swing.JTextField txtDiaChiNhaCungCap;
    private javax.swing.JTextField txtEmailNhaCungCap;
    private javax.swing.JTextField txtMaNhaCungCap;
    private javax.swing.JTextField txtTenNhaCungCap;
    private javax.swing.JComboBox cbTinhTrangNhaCungCap;
    private javax.swing.JTextField txtTuKhoaTimKiem;
    // End of variables declaration//GEN-END:variables

    public JTable getTbDanhSachNhaCungCap() {
        return tbDanhSachCacNhaCungCap;
    }
    public JButton getButtonThemNhaCungCap(){return btnThemNhaCungCap;}
    public JButton getButtonSuaNhaCungCap(){return btnSuaNhaCungCap;}
    public JButton getButtonXoaNhaCungCap(){return btnXoaNhaCungCap;}
    public JTextField getTxtMaNhaCungCap(){return txtMaNhaCungCap;}
    public JTextField getTxtDiaChiNhaCungCap(){return txtDiaChiNhaCungCap;}
    public JTextField getTxtTenNhaCungCap(){return txtTenNhaCungCap;}
    public JTextField getTxtEmailNhaCungCap(){return txtEmailNhaCungCap;}
    public JComboBox getCbTinhTrangNhaCungCap(){return cbTinhTrangNhaCungCap;}
    public JComboBox getCbTkTinhTrangNhaCungCap(){return cbTkTinhTrangNhaCungCap;}
    public JTextField getTxtTuKhoaTimKiem(){return txtTuKhoaTimKiem;}

}
