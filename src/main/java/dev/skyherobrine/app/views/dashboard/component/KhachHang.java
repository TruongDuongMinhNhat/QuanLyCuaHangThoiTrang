/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

/**
 *
 * @author Virtue Nguyen
 */
public class KhachHang extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public KhachHang() {
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
        pnThongTinKhachHang = new javax.swing.JPanel();
        lbMaNhanVien = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        lbHoTenNhanVien = new javax.swing.JLabel();
        txtHoTenKhachHang = new javax.swing.JTextField();
        lbGIoiTinhNhanVien = new javax.swing.JLabel();
        lbSoDienThoaiNhanVien = new javax.swing.JLabel();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtDiemTichLuy = new javax.swing.JTextField();
        lbNgaySinhNhanVien = new javax.swing.JLabel();
        btnSuaKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        btnXoaKhachHang = new javax.swing.JButton();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jDateChooserNgaySinh = new com.toedter.calendar.JDateChooser();
        pnDanhSachKhachHang = new javax.swing.JPanel();
        spDanhSachKhachHang = new javax.swing.JScrollPane();
        tbDanhSachKhachHang = new javax.swing.JTable();
        pnTimKiemKhachHang = new javax.swing.JPanel();
        cbTkGioiTinhKhachHang = new javax.swing.JComboBox<>();
        lbTkTenKhachHang = new javax.swing.JLabel();
        txtTuKhoaTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserTkNgaySinh = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnThongTinKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaNhanVien.setText("Mã khách hàng:");

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKhachHang.setEnabled(false);
        txtMaKhachHang.setPreferredSize(new java.awt.Dimension(64, 25));

        lbHoTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHoTenNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHoTenNhanVien.setText("Họ tên:");

        txtHoTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTenKhachHang.setEnabled(false);
        txtHoTenKhachHang.setPreferredSize(new java.awt.Dimension(64, 25));

        lbGIoiTinhNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbGIoiTinhNhanVien.setText("Giới tính:");

        lbSoDienThoaiNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSoDienThoaiNhanVien.setText("Số điện thoại:");

        txtSoDienThoaiKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoDienThoaiKhachHang.setEnabled(false);
        txtSoDienThoaiKhachHang.setPreferredSize(new java.awt.Dimension(79, 33));

        lbEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbEmail.setText("Điểm tích luỹ:");

        txtDiemTichLuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiemTichLuy.setEnabled(false);

        lbNgaySinhNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgaySinhNhanVien.setText("Ngày Sinh:");

        btnSuaKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnSuaKhachHang.setText("Sửa khách hàng");

        btnThemKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnThemKhachHang.setText("Thêm khách hàng");

        btnXoaKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnXoaKhachHang.setText("Xoá khách hàng");

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnThongTinKhachHangLayout = new javax.swing.GroupLayout(pnThongTinKhachHang);
        pnThongTinKhachHang.setLayout(pnThongTinKhachHangLayout);
        pnThongTinKhachHangLayout.setHorizontalGroup(
            pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSoDienThoaiNhanVien)
                                    .addComponent(lbNgaySinhNhanVien))
                                .addGap(25, 25, 25)
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbMaNhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnThemKhachHang)))
                .addGap(156, 156, 156)
                .addComponent(btnSuaKhachHang)
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbHoTenNhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHoTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbGIoiTinhNhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(btnXoaKhachHang)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        pnThongTinKhachHangLayout.setVerticalGroup(
            pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGIoiTinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEmail))
                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92)
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKhachHang)
                    .addComponent(btnSuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhachHang))
                .addGap(36, 36, 36))
        );

        pnDanhSachKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnDanhSachKhachHang.setLayout(new java.awt.BorderLayout());

        tbDanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        spDanhSachKhachHang.setViewportView(tbDanhSachKhachHang);

        pnDanhSachKhachHang.add(spDanhSachKhachHang, java.awt.BorderLayout.CENTER);

        pnTimKiemKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        cbTkGioiTinhKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkGioiTinhKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới tính", "Nam", "Nữ", "Gay", "Les", " " }));

        lbTkTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTkTenKhachHang.setText("Từ khoá tìm kiếm:");

        txtTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ngày sinh:");

        javax.swing.GroupLayout pnTimKiemKhachHangLayout = new javax.swing.GroupLayout(pnTimKiemKhachHang);
        pnTimKiemKhachHang.setLayout(pnTimKiemKhachHangLayout);
        pnTimKiemKhachHangLayout.setHorizontalGroup(
            pnTimKiemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemKhachHangLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(cbTkGioiTinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(lbTkTenKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );
        pnTimKiemKhachHangLayout.setVerticalGroup(
            pnTimKiemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTimKiemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTkGioiTinhKhachHang)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserTkNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTuKhoaTimKiem)
                .addComponent(lbTkTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTimKiemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaKhachHang;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnXoaKhachHang;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbTkGioiTinhKhachHang;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGIoiTinhNhanVien;
    private javax.swing.JLabel lbHoTenNhanVien;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbNgaySinhNhanVien;
    private javax.swing.JLabel lbSoDienThoaiNhanVien;
    private javax.swing.JLabel lbTkTenKhachHang;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachKhachHang;
    private javax.swing.JPanel pnThongTinKhachHang;
    private javax.swing.JPanel pnTimKiemKhachHang;
    private javax.swing.JScrollPane spDanhSachKhachHang;
    private javax.swing.JTable tbDanhSachKhachHang;
    private javax.swing.JTextField txtDiemTichLuy;
    private javax.swing.JTextField txtHoTenKhachHang;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtTuKhoaTimKiem;
    // End of variables declaration//GEN-END:variables
}