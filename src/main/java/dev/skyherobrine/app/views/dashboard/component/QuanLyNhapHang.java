/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

/**
 *
 * @author Virtue Nguyen
 */
public class QuanLyNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public QuanLyNhapHang() {
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
        pnThongTinPhieuNhap = new javax.swing.JPanel();
        lbMaSpQuanLySanPham = new javax.swing.JLabel();
        txtMaPhieuNhap = new javax.swing.JTextField();
        lbMaLoaiSpQuanLySanPham = new javax.swing.JLabel();
        lbHhQuanLySanPham = new javax.swing.JLabel();
        lbTenSpQuanLySanPham = new javax.swing.JLabel();
        txtNhaCungCap = new javax.swing.JTextField();
        lbMauSacQuanLySanPham = new javax.swing.JLabel();
        lbKichThuocQuanLySanPham = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        lbNgaySanXuatQuanLySanPham = new javax.swing.JLabel();
        lbXuatXuQuanLySanPham = new javax.swing.JLabel();
        lbPhanTramLoiQuanLySanPham = new javax.swing.JLabel();
        btnSuaPhieuNhap = new javax.swing.JButton();
        btnThemPhieuNhap = new javax.swing.JButton();
        btnInPhieuNHap = new javax.swing.JButton();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAGhiChu = new javax.swing.JTextArea();
        SpinnerGiaNhap = new javax.swing.JSpinner();
        SpinnerSoLuong = new javax.swing.JSpinner();
        jDateChooserNgayLapPhieu = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        pnDanhSachPhieuNhap = new javax.swing.JPanel();
        spDanhSachPhieuNhap = new javax.swing.JScrollPane();
        tbDanhSachPheiNhap = new javax.swing.JTable();
        pnTimKiemPhieuNhap = new javax.swing.JPanel();
        cbTkNhaCungCap = new javax.swing.JComboBox<>();
        cbTkTinhTrang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserTkNgayLapPhieu = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserTkNgayHenGiao = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnThongTinPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinPhieuNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhập hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnThongTinPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbMaSpQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaSpQuanLySanPham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaSpQuanLySanPham.setText("Mã phiếu nhập:");

        txtMaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaPhieuNhap.setEnabled(false);
        txtMaPhieuNhap.setPreferredSize(new java.awt.Dimension(64, 25));

        lbMaLoaiSpQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaLoaiSpQuanLySanPham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaLoaiSpQuanLySanPham.setText("Tên sản phẩm nhập:");

        lbHhQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHhQuanLySanPham.setText("Ngày lập phiếu:");

        lbTenSpQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSpQuanLySanPham.setText("Nhà cung cấp:");

        txtNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNhaCungCap.setEnabled(false);
        txtNhaCungCap.setPreferredSize(new java.awt.Dimension(79, 33));

        lbMauSacQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMauSacQuanLySanPham.setText("Ngày hẹn giao:");

        lbKichThuocQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbKichThuocQuanLySanPham.setText("Số lượng:");

        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSanPham.setEnabled(false);

        lbNgaySanXuatQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgaySanXuatQuanLySanPham.setText("Tình trạng:");

        lbXuatXuQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbXuatXuQuanLySanPham.setText("Ghi chú:");

        lbPhanTramLoiQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPhanTramLoiQuanLySanPham.setText("Giá nhập:");

        btnSuaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnSuaPhieuNhap.setText("Sửa phiếu nhập");

        btnThemPhieuNhap.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnThemPhieuNhap.setText("Thêm phiếu nhập");

        btnInPhieuNHap.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnInPhieuNHap.setText("In phiếu nhập");

        cbTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtAGhiChu.setColumns(20);
        txtAGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtAGhiChu);

        javax.swing.GroupLayout pnThongTinPhieuNhapLayout = new javax.swing.GroupLayout(pnThongTinPhieuNhap);
        pnThongTinPhieuNhap.setLayout(pnThongTinPhieuNhapLayout);
        pnThongTinPhieuNhapLayout.setHorizontalGroup(
            pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinPhieuNhapLayout.createSequentialGroup()
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnThongTinPhieuNhapLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgaySanXuatQuanLySanPham)
                            .addComponent(lbTenSpQuanLySanPham)
                            .addComponent(lbXuatXuQuanLySanPham))
                        .addGap(18, 18, 18)
                        .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(cbTinhTrang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(pnThongTinPhieuNhapLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbMaSpQuanLySanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(361, 361, 361)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaLoaiSpQuanLySanPham)
                    .addComponent(lbHhQuanLySanPham)
                    .addComponent(lbMauSacQuanLySanPham)
                    .addComponent(lbKichThuocQuanLySanPham)
                    .addComponent(lbPhanTramLoiQuanLySanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(SpinnerGiaNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(SpinnerSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserNgayLapPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(271, 271, 271))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinPhieuNhapLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(btnThemPhieuNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaPhieuNhap)
                .addGap(251, 251, 251)
                .addComponent(btnInPhieuNHap)
                .addGap(279, 279, 279))
        );
        pnThongTinPhieuNhapLayout.setVerticalGroup(
            pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinPhieuNhapLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaSpQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaLoaiSpQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTenSpQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbHhQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserNgayLapPhieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNgaySanXuatQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMauSacQuanLySanPham)
                        .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnThongTinPhieuNhapLayout.createSequentialGroup()
                        .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbXuatXuQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbKichThuocQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SpinnerSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPhanTramLoiQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SpinnerGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(98, 98, 98)
                .addGroup(pnThongTinPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemPhieuNhap)
                    .addComponent(btnInPhieuNHap))
                .addGap(32, 32, 32))
        );

        pnDanhSachPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachPhieuNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách phiếu nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachPheiNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        spDanhSachPhieuNhap.setViewportView(tbDanhSachPheiNhap);

        javax.swing.GroupLayout pnDanhSachPhieuNhapLayout = new javax.swing.GroupLayout(pnDanhSachPhieuNhap);
        pnDanhSachPhieuNhap.setLayout(pnDanhSachPhieuNhapLayout);
        pnDanhSachPhieuNhapLayout.setHorizontalGroup(
            pnDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1641, Short.MAX_VALUE)
        );
        pnDanhSachPhieuNhapLayout.setVerticalGroup(
            pnDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pnTimKiemPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemPhieuNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cbTkNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà cung cấp", " " }));

        cbTkTinhTrang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tình trạng", " " }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ngày lập phiếu:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ngày hẹn giao:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Từ khoá tìm kiếm:");

        javax.swing.GroupLayout pnTimKiemPhieuNhapLayout = new javax.swing.GroupLayout(pnTimKiemPhieuNhap);
        pnTimKiemPhieuNhap.setLayout(pnTimKiemPhieuNhapLayout);
        pnTimKiemPhieuNhapLayout.setHorizontalGroup(
            pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTkNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayHenGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTimKiemPhieuNhapLayout.setVerticalGroup(
            pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemPhieuNhapLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jDateChooserTkNgayHenGiao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnTimKiemPhieuNhapLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTkNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThongTinPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDanhSachPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnTimKiemPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTinPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(pnBGThongTinCaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerGiaNhap;
    private javax.swing.JSpinner SpinnerSoLuong;
    private javax.swing.JButton btnInPhieuNHap;
    private javax.swing.JButton btnSuaPhieuNhap;
    private javax.swing.JButton btnThemPhieuNhap;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JComboBox<String> cbTkNhaCungCap;
    private javax.swing.JComboBox<String> cbTkTinhTrang;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserNgayLapPhieu;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayHenGiao;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayLapPhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbHhQuanLySanPham;
    private javax.swing.JLabel lbKichThuocQuanLySanPham;
    private javax.swing.JLabel lbMaLoaiSpQuanLySanPham;
    private javax.swing.JLabel lbMaSpQuanLySanPham;
    private javax.swing.JLabel lbMauSacQuanLySanPham;
    private javax.swing.JLabel lbNgaySanXuatQuanLySanPham;
    private javax.swing.JLabel lbPhanTramLoiQuanLySanPham;
    private javax.swing.JLabel lbTenSpQuanLySanPham;
    private javax.swing.JLabel lbXuatXuQuanLySanPham;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachPhieuNhap;
    private javax.swing.JPanel pnThongTinPhieuNhap;
    private javax.swing.JPanel pnTimKiemPhieuNhap;
    private javax.swing.JScrollPane spDanhSachPhieuNhap;
    private javax.swing.JTable tbDanhSachPheiNhap;
    private javax.swing.JTextArea txtAGhiChu;
    private javax.swing.JTextField txtMaPhieuNhap;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}