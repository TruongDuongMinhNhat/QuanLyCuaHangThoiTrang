/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

/**
 *
 * @author Virtue Nguyen
 */
public class FormThue extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public FormThue() {
        initComponents();
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
        pnDanhSachCacThue = new javax.swing.JPanel();
        spDanhSachThueCuaSanPham = new javax.swing.JScrollPane();
        tbDanhSachThueCuaSanPham = new javax.swing.JTable();
        pnTimKiemThue = new javax.swing.JPanel();
        txtTuKhoaTimKiemThue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserNgayApDungThue = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserNgayHetHanThue = new com.toedter.calendar.JDateChooser();
        pnThongTInThue = new javax.swing.JPanel();
        lbMaKhuyenMai = new javax.swing.JLabel();
        lbTile = new javax.swing.JLabel();
        lbNgayApDung = new javax.swing.JLabel();
        lbNgayHetHan = new javax.swing.JLabel();
        lbTenSanPhamApDung = new javax.swing.JLabel();
        txtMaThue = new javax.swing.JTextField();
        txtThue = new javax.swing.JTextField();
        txtTenThue = new javax.swing.JTextField();
        btnThemThue = new javax.swing.JButton();
        btnSuaThue = new javax.swing.JButton();
        btnXoaThue = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserNgayApDungThongTinThue = new com.toedter.calendar.JDateChooser();
        jDateChooserNgayHetHanjThongTinThue = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnDanhSachCacThue.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachCacThue.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh thuế của sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachThueCuaSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spDanhSachThueCuaSanPham.setViewportView(tbDanhSachThueCuaSanPham);

        javax.swing.GroupLayout pnDanhSachCacThueLayout = new javax.swing.GroupLayout(pnDanhSachCacThue);
        pnDanhSachCacThue.setLayout(pnDanhSachCacThueLayout);
        pnDanhSachCacThueLayout.setHorizontalGroup(
            pnDanhSachCacThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachThueCuaSanPham)
        );
        pnDanhSachCacThueLayout.setVerticalGroup(
            pnDanhSachCacThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachThueCuaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pnTimKiemThue.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemThue.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtTuKhoaTimKiemThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTuKhoaTimKiemThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuKhoaTimKiemThueActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Từ khoá tìm kiếm:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày áp dụng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ngày hết hạn:");

        javax.swing.GroupLayout pnTimKiemThueLayout = new javax.swing.GroupLayout(pnTimKiemThue);
        pnTimKiemThue.setLayout(pnTimKiemThueLayout);
        pnTimKiemThueLayout.setHorizontalGroup(
            pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemThueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserNgayApDungThue, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserNgayHetHanThue, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTuKhoaTimKiemThue, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTimKiemThueLayout.setVerticalGroup(
            pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemThueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTimKiemThueLayout.createSequentialGroup()
                        .addGroup(pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserNgayApDungThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addContainerGap())
                    .addGroup(pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTuKhoaTimKiemThue)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemThueLayout.createSequentialGroup()
                        .addGroup(pnTimKiemThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserNgayHetHanThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))))
        );

        pnThongTInThue.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTInThue.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin thuế", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaKhuyenMai.setText("Mã khuyến mãi:");

        lbTile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTile.setText("Tỉ lệ:");

        lbNgayApDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayApDung.setText("Ngày áp dụng:");

        lbNgayHetHan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayHetHan.setText("Ngày hết hạn:");

        lbTenSanPhamApDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSanPhamApDung.setText("Tên khuyến mãi:");

        txtMaThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTenThue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnThemThue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemThue.setText("Thêm khuyến mãi");

        btnSuaThue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaThue.setText("Sửa khuyến mãi");

        btnXoaThue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaThue.setText("Xoá khuyến mãi");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("%");

        javax.swing.GroupLayout pnThongTInThueLayout = new javax.swing.GroupLayout(pnThongTInThue);
        pnThongTInThue.setLayout(pnThongTInThueLayout);
        pnThongTInThueLayout.setHorizontalGroup(
            pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInThueLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTInThueLayout.createSequentialGroup()
                        .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTile)
                            .addGroup(pnThongTInThueLayout.createSequentialGroup()
                                .addComponent(lbMaKhuyenMai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(317, 317, 317)
                        .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayHetHan)
                            .addComponent(lbNgayApDung)))
                    .addGroup(pnThongTInThueLayout.createSequentialGroup()
                        .addComponent(lbTenSanPhamApDung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTInThueLayout.createSequentialGroup()
                                .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(txtTenThue, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserNgayApDungThongTinThue, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jDateChooserNgayHetHanjThongTinThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInThueLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(btnThemThue)
                .addGap(274, 274, 274)
                .addComponent(btnSuaThue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaThue)
                .addGap(265, 265, 265))
        );
        pnThongTInThueLayout.setVerticalGroup(
            pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInThueLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserNgayApDungThongTinThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jDateChooserNgayHetHanjThongTinThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTenSanPhamApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(pnThongTInThueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnBGThongTinCaNhanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnTimKiemThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnThongTInThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDanhSachCacThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachCacThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTInThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTuKhoaTimKiemThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuKhoaTimKiemThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuKhoaTimKiemThueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaThue;
    private javax.swing.JButton btnThemThue;
    private javax.swing.JButton btnXoaThue;
    private com.toedter.calendar.JDateChooser jDateChooserNgayApDungThongTinThue;
    private com.toedter.calendar.JDateChooser jDateChooserNgayApDungThue;
    private com.toedter.calendar.JDateChooser jDateChooserNgayHetHanThue;
    private com.toedter.calendar.JDateChooser jDateChooserNgayHetHanjThongTinThue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbMaKhuyenMai;
    private javax.swing.JLabel lbNgayApDung;
    private javax.swing.JLabel lbNgayHetHan;
    private javax.swing.JLabel lbTenSanPhamApDung;
    private javax.swing.JLabel lbTile;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachCacThue;
    private javax.swing.JPanel pnThongTInThue;
    private javax.swing.JPanel pnTimKiemThue;
    private javax.swing.JScrollPane spDanhSachThueCuaSanPham;
    private javax.swing.JTable tbDanhSachThueCuaSanPham;
    private javax.swing.JTextField txtMaThue;
    private javax.swing.JTextField txtTenThue;
    private javax.swing.JTextField txtThue;
    private javax.swing.JTextField txtTuKhoaTimKiemThue;
    // End of variables declaration//GEN-END:variables
}
