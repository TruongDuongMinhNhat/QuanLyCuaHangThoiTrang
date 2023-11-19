/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import dev.skyherobrine.app.controllers.dashboardui.person.KhachHangController;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class FrmKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public FrmKhachHang() {
        initComponents();
        new KhachHangController(this).loaddsKhachHang();
        new KhachHangController(this).loadComboBoxPhanThongTinNV();
        new KhachHangController(this).loadComboBoxPhanTimKiem();
        tbDanhSachKhachHang.addMouseListener(new KhachHangController(this));
        btnThemKhachHang.addActionListener(new KhachHangController(this));
        btnSuaKhachHang.addActionListener(new KhachHangController(this));
        btnXuatFile.addActionListener(new KhachHangController(this));

        cbTkGioiTinhKhachHang.addActionListener(new KhachHangController(this));
        jDateChooserTkNgaySinh.addPropertyChangeListener(new KhachHangController(this));
        jDateChooserTuNgayLocDanhSach.addPropertyChangeListener(new KhachHangController(this));
        jDateChooserDenNgayLocDanhSachFile.addPropertyChangeListener(new KhachHangController(this));
        cbThangLoc.addPropertyChangeListener(new KhachHangController(this));
        jYearChooserNam.addPropertyChangeListener(new KhachHangController(this));
        btnLocDanhSach.addActionListener(new KhachHangController(this));
        btnLamMoiLoc.addActionListener(new KhachHangController(this));
        txtTuKhoaTimKiem.addKeyListener(new KhachHangController(this));
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
        btnXuatFile = new javax.swing.JButton();
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
        pnLocDanhSachXuatFile = new javax.swing.JPanel();
        jYearChooserNam = new com.toedter.calendar.JYearChooser();
        jDateChooserDenNgayLocDanhSachFile = new com.toedter.calendar.JDateChooser();
        jDateChooserTuNgayLocDanhSach = new com.toedter.calendar.JDateChooser();
        lblTuNgay = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        lblThangLoc = new javax.swing.JLabel();
        lblNamLoc = new javax.swing.JLabel();
        btnLocDanhSach = new javax.swing.JButton();
        btnLamMoiLoc = new javax.swing.JButton();
        lblLocTheoNamThang = new javax.swing.JLabel();
        lblTieuDeLocTheoNgay = new javax.swing.JLabel();
        cbThangLoc = new javax.swing.JComboBox<>();

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

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnXuatFile.setText("Xuất danh sách");

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGioiTinh.setEnabled(false);

        jDateChooserNgaySinh.setEnabled(false);

        javax.swing.GroupLayout pnThongTinKhachHangLayout = new javax.swing.GroupLayout(pnThongTinKhachHang);
        pnThongTinKhachHang.setLayout(pnThongTinKhachHangLayout);
        pnThongTinKhachHangLayout.setHorizontalGroup(
            pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSoDienThoaiNhanVien)
                                    .addComponent(lbNgaySinhNhanVien))
                                .addGap(25, 25, 25)
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbMaNhanVien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnThemKhachHang)))
                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbGIoiTinhNhanVien)
                                    .addComponent(lbHoTenNhanVien))
                                .addGap(45, 45, 45)
                                .addGroup(pnThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                                .addComponent(lbEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(96, Short.MAX_VALUE))
                    .addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnSuaKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXuatFile)
                        .addGap(137, 137, 137))))
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
                    .addComponent(btnXuatFile))
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
                .addComponent(txtTuKhoaTimKiem)
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

        pnLocDanhSachXuatFile.setBackground(new java.awt.Color(255, 255, 255));
        pnLocDanhSachXuatFile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc danh sách xuất file", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jYearChooserNam.setEnabled(false);

        jDateChooserDenNgayLocDanhSachFile.setEnabled(false);

        jDateChooserTuNgayLocDanhSach.setEnabled(false);

        lblTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTuNgay.setText("Từ ngày:");

        lblDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDenNgay.setText("Đến ngày:");

        lblThangLoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThangLoc.setText("Tháng:");

        lblNamLoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamLoc.setText("Năm:");

        btnLocDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLocDanhSach.setText("Lọc danh sách");
        btnLocDanhSach.setEnabled(false);

        btnLamMoiLoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoiLoc.setText("Làm mới");
        btnLamMoiLoc.setEnabled(false);
        btnLamMoiLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiLocActionPerformed(evt);
            }
        });

        lblLocTheoNamThang.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblLocTheoNamThang.setText("Hoặc lọc theo Năm và Tháng");

        lblTieuDeLocTheoNgay.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblTieuDeLocTheoNgay.setText("Lọc theo ngày(từ ngày .. đến ngày ..)");

        cbThangLoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbThangLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        cbThangLoc.setEnabled(false);

        javax.swing.GroupLayout pnLocDanhSachXuatFileLayout = new javax.swing.GroupLayout(pnLocDanhSachXuatFile);
        pnLocDanhSachXuatFile.setLayout(pnLocDanhSachXuatFileLayout);
        pnLocDanhSachXuatFileLayout.setHorizontalGroup(
            pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocDanhSachXuatFileLayout.createSequentialGroup()
                .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLocDanhSachXuatFileLayout.createSequentialGroup()
                        .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTuNgay)
                            .addComponent(lblDenNgay))
                        .addGap(18, 18, 18)
                        .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserDenNgayLocDanhSachFile, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserTuNgayLocDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTieuDeLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocTheoNamThang, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocDanhSachXuatFileLayout.createSequentialGroup()
                .addComponent(lblNamLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jYearChooserNam, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblThangLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbThangLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocDanhSachXuatFileLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnLocDanhSach)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnLocDanhSachXuatFileLayout.setVerticalGroup(
            pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocDanhSachXuatFileLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTieuDeLocTheoNgay)
                .addGap(18, 18, 18)
                .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserTuNgayLocDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserDenNgayLocDanhSachFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLocTheoNamThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThangLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbThangLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jYearChooserNam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnLocDanhSachXuatFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLocDanhSach)
                    .addComponent(btnLamMoiLoc))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTimKiemKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnLocDanhSachXuatFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnLocDanhSachXuatFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btnLamMoiLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiLoc;
    private javax.swing.JButton btnLocDanhSach;
    private javax.swing.JButton btnSuaKhachHang;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbThangLoc;
    private javax.swing.JComboBox<String> cbTkGioiTinhKhachHang;
    private com.toedter.calendar.JDateChooser jDateChooserDenNgayLocDanhSachFile;
    private com.toedter.calendar.JDateChooser jDateChooserNgaySinh;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgaySinh;
    private com.toedter.calendar.JDateChooser jDateChooserTuNgayLocDanhSach;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JYearChooser jYearChooserNam;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGIoiTinhNhanVien;
    private javax.swing.JLabel lbHoTenNhanVien;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbNgaySinhNhanVien;
    private javax.swing.JLabel lbSoDienThoaiNhanVien;
    private javax.swing.JLabel lbTkTenKhachHang;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblLocTheoNamThang;
    private javax.swing.JLabel lblNamLoc;
    private javax.swing.JLabel lblThangLoc;
    private javax.swing.JLabel lblTieuDeLocTheoNgay;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnDanhSachKhachHang;
    private javax.swing.JPanel pnLocDanhSachXuatFile;
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

    public JTable getTbDanhSachKhachHang() {
        return tbDanhSachKhachHang;
    }
    public JButton getButtonThemKhachHang(){return btnThemKhachHang;}
    public JButton getButtonSuaKhachHang(){return btnSuaKhachHang;}
    public JButton getButtonXoaKhachHang(){return btnXuatFile;}
    public JTextField getTxtMaKhachHang(){return txtMaKhachHang;}
    public JTextField getTxtSoDienThoaiKhachHang(){return txtSoDienThoaiKhachHang;}
    public JDateChooser getjDateChooserNgaySinhKhachHang(){return jDateChooserNgaySinh;}
    public JTextField getTxtHoTenKhachHang(){return txtHoTenKhachHang;}
    public JComboBox getCbGioiTinh(){return  cbGioiTinh;}
    public JTextField getTxtDiemTichLuy(){return txtDiemTichLuy;}
    public JComboBox getCbTkGioiTinh(){return cbTkGioiTinhKhachHang;}
    public JTextField getTxtTuKhoaTimKiem(){return txtTuKhoaTimKiem;}
    public JDateChooser getjDateChooserTkNgaySinh(){return jDateChooserTkNgaySinh;}
    public JDateChooser getjDateChooserTuNgayLocDanhSach(){return jDateChooserTuNgayLocDanhSach;}
    public JDateChooser getjDateChooserDenNgayLocDanhSachFile(){return jDateChooserDenNgayLocDanhSachFile;}
    public JComboBox<String> getCbThangLoc(){return cbThangLoc;}
    public JYearChooser getjYearChooserNam(){return jYearChooserNam;}
    public JButton getBtnLocDanhSach(){return btnLocDanhSach;}
    public JButton getBtnLamMoiLoc(){return btnLamMoiLoc;}
}
