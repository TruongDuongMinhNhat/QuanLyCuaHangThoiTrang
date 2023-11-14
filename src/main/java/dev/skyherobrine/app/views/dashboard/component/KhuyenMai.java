/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

/**
 *
 * @author Virtue Nguyen
 */
public class KhuyenMai extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public KhuyenMai() {
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
        pnDanhSachCacKhuyenMai = new javax.swing.JPanel();
        spDanhSachCacKhuyenMaiCuaSanPham = new javax.swing.JScrollPane();
        tbDanhSachCacKhuyenMaiCuaSanPham = new javax.swing.JTable();
        pnTimKiemKhuyenMai = new javax.swing.JPanel();
        cbTkNgayApDung = new javax.swing.JComboBox<>();
        txtTuKhoaTimKiem = new javax.swing.JTextField();
        cbTimKiemNgayHetHan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pnThongTInKhuyenMai = new javax.swing.JPanel();
        lbMaKhuyenMai = new javax.swing.JLabel();
        lbTile = new javax.swing.JLabel();
        lbNgayApDung = new javax.swing.JLabel();
        lbNgayHetHan = new javax.swing.JLabel();
        lbTenSanPhamApDung = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtTile = new javax.swing.JTextField();
        txtNgayApDung = new javax.swing.JTextField();
        txtTenSanPhamApDung = new javax.swing.JTextField();
        txtNgayHetHan = new javax.swing.JTextField();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnSuaKhuyenMai = new javax.swing.JButton();
        btnXoaKhuyenMai = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnDanhSachCacKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachCacKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh các khuyến mãi của sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachCacKhuyenMaiCuaSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        spDanhSachCacKhuyenMaiCuaSanPham.setViewportView(tbDanhSachCacKhuyenMaiCuaSanPham);

        javax.swing.GroupLayout pnDanhSachCacKhuyenMaiLayout = new javax.swing.GroupLayout(pnDanhSachCacKhuyenMai);
        pnDanhSachCacKhuyenMai.setLayout(pnDanhSachCacKhuyenMaiLayout);
        pnDanhSachCacKhuyenMaiLayout.setHorizontalGroup(
            pnDanhSachCacKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachCacKhuyenMaiCuaSanPham)
        );
        pnDanhSachCacKhuyenMaiLayout.setVerticalGroup(
            pnDanhSachCacKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachCacKhuyenMaiCuaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pnTimKiemKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cbTkNgayApDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkNgayApDung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày áp dụng", " ", " ", " ", " " }));

        txtTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTuKhoaTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuKhoaTimKiemActionPerformed(evt);
            }
        });

        cbTimKiemNgayHetHan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTimKiemNgayHetHan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày hết hạn", " ", " ", " ", " ", " " }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Từ khoá tìm kiếm:");

        javax.swing.GroupLayout pnTimKiemKhuyenMaiLayout = new javax.swing.GroupLayout(pnTimKiemKhuyenMai);
        pnTimKiemKhuyenMai.setLayout(pnTimKiemKhuyenMaiLayout);
        pnTimKiemKhuyenMaiLayout.setHorizontalGroup(
            pnTimKiemKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTkNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbTimKiemNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTimKiemKhuyenMaiLayout.setVerticalGroup(
            pnTimKiemKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimKiemKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTkNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimKiemNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTuKhoaTimKiem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
        );

        pnThongTInKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTInKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khuyến mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaKhuyenMai.setText("Mã khuyến mãi:");

        lbTile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTile.setText("Tile:");

        lbNgayApDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayApDung.setText("Ngày áp dụng:");

        lbNgayHetHan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayHetHan.setText("Ngày hết hạn:");

        lbTenSanPhamApDung.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSanPhamApDung.setText("Tên sản phẩm áp dụng:");

        txtMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNgayApDung.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTenSanPhamApDung.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNgayHetHan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnThemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemKhuyenMai.setText("Thêm khuyến mãi");

        btnSuaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaKhuyenMai.setText("Sửa khuyến mãi");

        btnXoaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaKhuyenMai.setText("Xoá khuyến mãi");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("%");

        javax.swing.GroupLayout pnThongTInKhuyenMaiLayout = new javax.swing.GroupLayout(pnThongTInKhuyenMai);
        pnThongTInKhuyenMai.setLayout(pnThongTInKhuyenMaiLayout);
        pnThongTInKhuyenMaiLayout.setHorizontalGroup(
            pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInKhuyenMaiLayout.createSequentialGroup()
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTInKhuyenMaiLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaKhuyenMai)
                            .addComponent(lbTile))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnThongTInKhuyenMaiLayout.createSequentialGroup()
                                .addComponent(txtTile, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(317, 317, 317)
                        .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayHetHan)
                            .addComponent(lbNgayApDung))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInKhuyenMaiLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTenSanPhamApDung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSanPhamApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInKhuyenMaiLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(btnThemKhuyenMai)
                .addGap(274, 274, 274)
                .addComponent(btnSuaKhuyenMai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaKhuyenMai)
                .addGap(265, 265, 265))
        );
        pnThongTInKhuyenMaiLayout.setVerticalGroup(
            pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInKhuyenMaiLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSanPhamApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSanPhamApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(pnThongTInKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(pnTimKiemKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnThongTInKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDanhSachCacKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachCacKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTInKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtTuKhoaTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuKhoaTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuKhoaTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaKhuyenMai;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnXoaKhuyenMai;
    private javax.swing.JComboBox<String> cbTimKiemNgayHetHan;
    private javax.swing.JComboBox<String> cbTkNgayApDung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbMaKhuyenMai;
    private javax.swing.JLabel lbNgayApDung;
    private javax.swing.JLabel lbNgayHetHan;
    private javax.swing.JLabel lbTenSanPhamApDung;
    private javax.swing.JLabel lbTile;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachCacKhuyenMai;
    private javax.swing.JPanel pnThongTInKhuyenMai;
    private javax.swing.JPanel pnTimKiemKhuyenMai;
    private javax.swing.JScrollPane spDanhSachCacKhuyenMaiCuaSanPham;
    private javax.swing.JTable tbDanhSachCacKhuyenMaiCuaSanPham;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtNgayApDung;
    private javax.swing.JTextField txtNgayHetHan;
    private javax.swing.JTextField txtTenSanPhamApDung;
    private javax.swing.JTextField txtTile;
    private javax.swing.JTextField txtTuKhoaTimKiem;
    // End of variables declaration//GEN-END:variables
}