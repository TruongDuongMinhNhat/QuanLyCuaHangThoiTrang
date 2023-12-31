/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class QuanLyPhieuTraHangChoNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public QuanLyPhieuTraHangChoNhaCungCap() {
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
        pnThongTInPhieuTraHang = new javax.swing.JPanel();
        lbMaPhieuTra = new javax.swing.JLabel();
        txtMaPhieuTra = new javax.swing.JTextField();
        lbTenNhaCungCapSanPham = new javax.swing.JLabel();
        lbMaPhieuNhap = new javax.swing.JLabel();
        lbTenSpQuanLySanPham = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        lbNgayLapPhieu = new javax.swing.JLabel();
        lbNgayHenLay = new javax.swing.JLabel();
        lbNgaySanXuatQuanLySanPham = new javax.swing.JLabel();
        txtSoLuongTra = new javax.swing.JTextField();
        lbXuatXuQuanLySanPham = new javax.swing.JLabel();
        txtLyDoTraHang = new javax.swing.JTextField();
        lbDoTuoiQuanLySanPham = new javax.swing.JLabel();
        btnThemPhieu = new javax.swing.JButton();
        btnInPhieu = new javax.swing.JButton();
        txtTinhTrang = new javax.swing.JTextField();
        txtTenNhaCungCapSanPham = new javax.swing.JTextField();
        txtMaPhieuNhap = new javax.swing.JTextField();
        jDateChooserNgayLapPhieu = new com.toedter.calendar.JDateChooser();
        jDateChooserNgayHenLay = new com.toedter.calendar.JDateChooser();
        pnDanhSachPhieuTraHangChoNhaCungCap = new javax.swing.JPanel();
        spPhieuTraHangChoNhaCungCap = new javax.swing.JScrollPane();
        tbPhieuTraHangChoNhaCungCap = new javax.swing.JTable();
        pnTimKiemPhieuTraHang = new javax.swing.JPanel();
        cbTkNhaCungCap = new javax.swing.JComboBox<>();
        cbTkTinhTrang = new javax.swing.JComboBox<>();
        txtTuKhoaTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserTkNgayLapPhieu = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserTkNgayHenLay = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnThongTInPhieuTraHang.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTInPhieuTraHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu trả hàng nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnThongTInPhieuTraHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lbMaPhieuTra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaPhieuTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaPhieuTra.setText("Mã phiếu trả:");

        txtMaPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaPhieuTra.setEnabled(false);
        txtMaPhieuTra.setPreferredSize(new java.awt.Dimension(64, 25));

        lbTenNhaCungCapSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenNhaCungCapSanPham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTenNhaCungCapSanPham.setText("Tên nhà cung cấp sản phẩm:");

        lbMaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaPhieuNhap.setText("Mã phiếu nhập:");

        lbTenSpQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSpQuanLySanPham.setText("Tên sản phẩm:");

        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSanPham.setEnabled(false);
        txtTenSanPham.setPreferredSize(new java.awt.Dimension(79, 33));

        lbNgayLapPhieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayLapPhieu.setText("Ngày lập phiếu:");

        lbNgayHenLay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayHenLay.setText("Ngày hẹn lấy:");

        lbNgaySanXuatQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgaySanXuatQuanLySanPham.setText("Số lượng trả:");

        txtSoLuongTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongTra.setText("   ");
        txtSoLuongTra.setEnabled(false);

        lbXuatXuQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbXuatXuQuanLySanPham.setText("Lý do trả hàng:");

        txtLyDoTraHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLyDoTraHang.setEnabled(false);

        lbDoTuoiQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDoTuoiQuanLySanPham.setText("Tình trạng:");

        btnThemPhieu.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnThemPhieu.setText("Thêm phiếu");

        btnInPhieu.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnInPhieu.setText("In phiếu");

        txtTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTinhTrang.setEnabled(false);

        txtTenNhaCungCapSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNhaCungCapSanPham.setEnabled(false);

        txtMaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaPhieuNhap.setEnabled(false);

        javax.swing.GroupLayout pnThongTInPhieuTraHangLayout = new javax.swing.GroupLayout(pnThongTInPhieuTraHang);
        pnThongTInPhieuTraHang.setLayout(pnThongTInPhieuTraHangLayout);
        pnThongTInPhieuTraHangLayout.setHorizontalGroup(
            pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInPhieuTraHangLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnThongTInPhieuTraHangLayout.createSequentialGroup()
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDoTuoiQuanLySanPham)
                            .addComponent(lbXuatXuQuanLySanPham)
                            .addComponent(lbNgaySanXuatQuanLySanPham)
                            .addComponent(lbTenSpQuanLySanPham)
                            .addComponent(lbMaPhieuTra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLyDoTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnThemPhieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnThongTInPhieuTraHangLayout.createSequentialGroup()
                        .addComponent(lbTenNhaCungCapSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNhaCungCapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInPhieuTraHangLayout.createSequentialGroup()
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaPhieuNhap)
                            .addComponent(lbNgayLapPhieu)
                            .addComponent(lbNgayHenLay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInPhieu)
                            .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaPhieuNhap)
                                .addComponent(jDateChooserNgayLapPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addComponent(jDateChooserNgayHenLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        pnThongTInPhieuTraHangLayout.setVerticalGroup(
            pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTInPhieuTraHangLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenNhaCungCapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhaCungCapSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenSpQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNgaySanXuatQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayLapPhieu)
                    .addComponent(jDateChooserNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTInPhieuTraHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbXuatXuQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLyDoTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnThongTInPhieuTraHangLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayHenLay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserNgayHenLay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDoTuoiQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(pnThongTInPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemPhieu)
                    .addComponent(btnInPhieu))
                .addGap(18, 18, 18))
        );

        pnDanhSachPhieuTraHangChoNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachPhieuTraHangChoNhaCungCap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách phiếu trả hàng nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbPhieuTraHangChoNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
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
        spPhieuTraHangChoNhaCungCap.setViewportView(tbPhieuTraHangChoNhaCungCap);

        javax.swing.GroupLayout pnDanhSachPhieuTraHangChoNhaCungCapLayout = new javax.swing.GroupLayout(pnDanhSachPhieuTraHangChoNhaCungCap);
        pnDanhSachPhieuTraHangChoNhaCungCap.setLayout(pnDanhSachPhieuTraHangChoNhaCungCapLayout);
        pnDanhSachPhieuTraHangChoNhaCungCapLayout.setHorizontalGroup(
            pnDanhSachPhieuTraHangChoNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spPhieuTraHangChoNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 1626, Short.MAX_VALUE)
        );
        pnDanhSachPhieuTraHangChoNhaCungCapLayout.setVerticalGroup(
            pnDanhSachPhieuTraHangChoNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spPhieuTraHangChoNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        pnTimKiemPhieuTraHang.setBackground(new java.awt.Color(255, 255, 255));
        pnTimKiemPhieuTraHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm phiếu trả hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cbTkNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà cung cấp", " " }));

        cbTkTinhTrang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTkTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tình trạng", " " }));

        txtTuKhoaTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Từ khoá tìm kiếm:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ngày lập phiếu:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Ngày hẹn lấy:");

        javax.swing.GroupLayout pnTimKiemPhieuTraHangLayout = new javax.swing.GroupLayout(pnTimKiemPhieuTraHang);
        pnTimKiemPhieuTraHang.setLayout(pnTimKiemPhieuTraHangLayout);
        pnTimKiemPhieuTraHangLayout.setHorizontalGroup(
            pnTimKiemPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemPhieuTraHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTkNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayHenLay, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTuKhoaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnTimKiemPhieuTraHangLayout.setVerticalGroup(
            pnTimKiemPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemPhieuTraHangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnTimKiemPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserTkNgayHenLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnTimKiemPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTkNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimKiemPhieuTraHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTuKhoaTimKiem)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnThongTInPhieuTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnTimKiemPhieuTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnDanhSachPhieuTraHangChoNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachPhieuTraHangChoNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemPhieuTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTInPhieuTraHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public JDateChooser getjDateChooserTkNgayHenLay() {
        return jDateChooserTkNgayHenLay;
    }

    public JButton getBtnInPhieu() {
        return btnInPhieu;
    }
    public JButton getBtnThemPhieu() {
        return btnThemPhieu;
    }

    public JTextField getTxtLyDoTraHang() {
        return txtLyDoTraHang;
    }
    public JTextField getTxtMaPhieuTra() {
        return txtMaPhieuTra;
    }
    public JTextField getTxtMaPhieuNhap() {
        return txtMaPhieuNhap;
    }
    public JTextField getTxtSoLuongTra() {
        return txtSoLuongTra;
    }
    public JTextField getTxtTenNhaCungCapSanPham() {
        return txtTenNhaCungCapSanPham;
    }
    public JTextField getTxtTenSanPham(){
        return txtTenSanPham;
    }
    public JTextField getTxtTinhTrang(){
        return txtTinhTrang;
    }
    public JDateChooser getjDateChooserNgayHenLay() {
        return jDateChooserNgayHenLay;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieu;
    private javax.swing.JButton btnThemPhieu;
    private javax.swing.JComboBox<String> cbTkNhaCungCap;
    private javax.swing.JComboBox<String> cbTkTinhTrang;
    private com.toedter.calendar.JDateChooser jDateChooserNgayHenLay;
    private com.toedter.calendar.JDateChooser jDateChooserNgayLapPhieu;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayHenLay;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayLapPhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbDoTuoiQuanLySanPham;
    private javax.swing.JLabel lbMaPhieuNhap;
    private javax.swing.JLabel lbMaPhieuTra;
    private javax.swing.JLabel lbNgayHenLay;
    private javax.swing.JLabel lbNgayLapPhieu;
    private javax.swing.JLabel lbNgaySanXuatQuanLySanPham;
    private javax.swing.JLabel lbTenNhaCungCapSanPham;
    private javax.swing.JLabel lbTenSpQuanLySanPham;
    private javax.swing.JLabel lbXuatXuQuanLySanPham;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachPhieuTraHangChoNhaCungCap;
    private javax.swing.JPanel pnThongTInPhieuTraHang;
    private javax.swing.JPanel pnTimKiemPhieuTraHang;
    private javax.swing.JScrollPane spPhieuTraHangChoNhaCungCap;
    private javax.swing.JTable tbPhieuTraHangChoNhaCungCap;
    private javax.swing.JTextField txtLyDoTraHang;
    private javax.swing.JTextField txtMaPhieuNhap;
    private javax.swing.JTextField txtMaPhieuTra;
    private javax.swing.JTextField txtSoLuongTra;
    private javax.swing.JTextField txtTenNhaCungCapSanPham;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTinhTrang;
    private javax.swing.JTextField txtTuKhoaTimKiem;
    // End of variables declaration//GEN-END:variables
}
