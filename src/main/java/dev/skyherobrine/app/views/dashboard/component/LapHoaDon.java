/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;


import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.pnDanhSachSanPhamLapHoaDon;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.EventItemSelected;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.GradientPanel;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.MultipleButton;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class LapHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form LapHoaDon
     */
    public LapHoaDon() {
        initComponents();
        pnBottomSplDsSp.add(new pnDanhSachSanPhamLapHoaDon());
        jScrollPaneSplDsSp.getViewport().setOpaque(false);
        jScrollPaneSplDsSp.setViewportBorder(null);
        jScrollPaneSplDsSp.setBorder(null);

        //khu vục đổi chũ thành label
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            items.add("");
        }
        multipleButton1.setItems(items);

        // xử lý khi chọn vào vào items của danh sách các sản phẩm 
        multipleButton1.setEvent(new EventItemSelected() {
            @Override
            public void selected(int index) {
                System.out.println("đã chọn sản phẩm số: "+index);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnBodyLapHoaDon = new javax.swing.JPanel();
        pnTabTraiLapHoaDon = new javax.swing.JPanel();
        splLapHoaDon = new javax.swing.JSplitPane();
        pnTopSplTopGioHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnBottomSplDsSp = new javax.swing.JPanel();
        jScrollPaneSplDsSp = new javax.swing.JScrollPane();
        multipleButton1 = new MultipleButton();
        txtTimKiemDsSp = new javax.swing.JTextField();
        cbLoai = new javax.swing.JComboBox<>();
        cbDanhMuc = new javax.swing.JComboBox<>();
        pnTabPhaiLapHoaDon = new javax.swing.JPanel();
        gradientPanel1 = new GradientPanel();
        btnLapHoaDon = new javax.swing.JButton();
        btnLuuTamHoaDon = new javax.swing.JButton();
        pnKhachHang = new javax.swing.JPanel();
        lbTenKhachHang = new javax.swing.JLabel();
        lbSoDienThoaiKhachHang = new javax.swing.JLabel();
        lbNgaySinh = new javax.swing.JLabel();
        txtTenKh = new javax.swing.JTextField();
        txtSĐTKhachHang = new javax.swing.JTextField();
        txtNgaySinhKh = new javax.swing.JTextField();
        pnHoaDon = new javax.swing.JPanel();
        lbMaHoaDon = new javax.swing.JLabel();
        lbNgayLap = new javax.swing.JLabel();
        lbGhiChu = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAGhiChu = new javax.swing.JTextArea();
        pnThanhToan = new javax.swing.JPanel();
        lbThongSoTienThanToan = new javax.swing.JLabel();
        lbSoTienkhachTra = new javax.swing.JLabel();
        txtSoTienKhachPhaiTra = new javax.swing.JTextField();
        txtTongSoTienThanhToan = new javax.swing.JTextField();
        lbChietKhau = new javax.swing.JLabel();
        lbThue = new javax.swing.JLabel();
        txtThue = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        pnNhanVien = new javax.swing.JPanel();
        lbMaNhanVien = new javax.swing.JLabel();
        lbTenNhanVien = new javax.swing.JLabel();
        lbSoDienThoaiNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBodyLapHoaDon.setLayout(null);

        splLapHoaDon.setDividerLocation(500);
        splLapHoaDon.setDividerSize(10);
        splLapHoaDon.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        pnTopSplTopGioHang.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout pnTopSplTopGioHangLayout = new javax.swing.GroupLayout(pnTopSplTopGioHang);
        pnTopSplTopGioHang.setLayout(pnTopSplTopGioHangLayout);
        pnTopSplTopGioHangLayout.setHorizontalGroup(
            pnTopSplTopGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        pnTopSplTopGioHangLayout.setVerticalGroup(
            pnTopSplTopGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        splLapHoaDon.setTopComponent(pnTopSplTopGioHang);

        pnBottomSplDsSp.setBackground(new java.awt.Color(37, 36, 36));

        jScrollPaneSplDsSp.setViewportView(multipleButton1);

        txtTimKiemDsSp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiemDsSp.setText("tìm kiếm");
        txtTimKiemDsSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemDsSpActionPerformed(evt);
            }
        });

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnBottomSplDsSpLayout = new javax.swing.GroupLayout(pnBottomSplDsSp);
        pnBottomSplDsSp.setLayout(pnBottomSplDsSpLayout);
        pnBottomSplDsSpLayout.setHorizontalGroup(
            pnBottomSplDsSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPaneSplDsSp)
            .addGroup(pnBottomSplDsSpLayout.createSequentialGroup()
                .addComponent(txtTimKiemDsSp, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnBottomSplDsSpLayout.setVerticalGroup(
            pnBottomSplDsSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomSplDsSpLayout.createSequentialGroup()
                .addGroup(pnBottomSplDsSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbLoai)
                    .addComponent(cbDanhMuc)
                    .addComponent(txtTimKiemDsSp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSplDsSp, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        splLapHoaDon.setRightComponent(pnBottomSplDsSp);

        javax.swing.GroupLayout pnTabTraiLapHoaDonLayout = new javax.swing.GroupLayout(pnTabTraiLapHoaDon);
        pnTabTraiLapHoaDon.setLayout(pnTabTraiLapHoaDonLayout);
        pnTabTraiLapHoaDonLayout.setHorizontalGroup(
            pnTabTraiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabTraiLapHoaDonLayout.createSequentialGroup()
                .addComponent(splLapHoaDon)
                .addContainerGap())
        );
        pnTabTraiLapHoaDonLayout.setVerticalGroup(
            pnTabTraiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splLapHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pnBodyLapHoaDon.add(pnTabTraiLapHoaDon);
        pnTabTraiLapHoaDon.setBounds(0, 0, 1260, 1000);

        pnTabPhaiLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        gradientPanel1.setPreferredSize(new java.awt.Dimension(401, 889));

        btnLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLapHoaDon.setText("Lập hoá đơn");

        btnLuuTamHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuTamHoaDon.setText("Lưu tạm hoá đơn");

        pnKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenKhachHang.setText("Tên khách hàng:");

        lbSoDienThoaiKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSoDienThoaiKhachHang.setText("Số điện thoại:");

        lbNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgaySinh.setText("Ngày sinh:");

        txtTenKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenKh.setEnabled(false);

        txtSĐTKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSĐTKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSĐTKhachHangActionPerformed(evt);
            }
        });

        txtNgaySinhKh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgaySinhKh.setEnabled(false);
        txtNgaySinhKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhKhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(lbTenKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKh))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSoDienThoaiKhachHang)
                            .addComponent(lbNgaySinh))
                        .addGap(30, 30, 30)
                        .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSĐTKhachHang)
                            .addComponent(txtNgaySinhKh))))
                .addContainerGap())
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenKhachHang)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDienThoaiKhachHang)
                    .addComponent(txtSĐTKhachHang))
                .addGroup(pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbNgaySinh))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNgaySinhKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaHoaDon.setText("Mã hoá đơn:");

        lbNgayLap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbNgayLap.setText("Ngày lập:");

        lbGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbGhiChu.setText("Ghi chú:");

        txtNgayLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayLap.setEnabled(false);

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaHoaDon.setEnabled(false);

        txtAGhiChu.setColumns(20);
        txtAGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtAGhiChu);

        javax.swing.GroupLayout pnHoaDonLayout = new javax.swing.GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaHoaDon)
                            .addComponent(lbNgayLap))
                        .addGap(56, 56, 56)
                        .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addComponent(lbGhiChu)
                        .addGap(93, 93, 93)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaHoaDon)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayLap))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGhiChu)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );

        pnThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbThongSoTienThanToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbThongSoTienThanToan.setText("Tổng số tiền thanh toán:");

        lbSoTienkhachTra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSoTienkhachTra.setText("Số tiền khách trả:");

        lbChietKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbChietKhau.setText("Chiết khấu:");

        lbThue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbThue.setText("Thuế:");

        txtThue.setEnabled(false);

        txtChietKhau.setEnabled(false);

        javax.swing.GroupLayout pnThanhToanLayout = new javax.swing.GroupLayout(pnThanhToan);
        pnThanhToan.setLayout(pnThanhToanLayout);
        pnThanhToanLayout.setHorizontalGroup(
            pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbSoTienkhachTra)
                        .addGap(67, 67, 67)
                        .addComponent(txtSoTienKhachPhaiTra))
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbThongSoTienThanToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongSoTienThanhToan))
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbChietKhau)
                        .addGap(120, 120, 120)
                        .addComponent(txtChietKhau))
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbThue)
                        .addGap(168, 168, 168)
                        .addComponent(txtThue)))
                .addContainerGap())
        );
        pnThanhToanLayout.setVerticalGroup(
            pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThue)
                    .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChietKhau)
                    .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoTienkhachTra)
                    .addComponent(txtSoTienKhachPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThongSoTienThanToan)
                    .addComponent(txtTongSoTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaNhanVien.setText("Mã nhân viên:");

        lbTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenNhanVien.setText("Tên nhân viên:");

        lbSoDienThoaiNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSoDienThoaiNhanVien.setText("Số điện thoai:");

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNhanVien.setEnabled(false);

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNhanVien.setEnabled(false);

        txtSoDienThoaiNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoDienThoaiNhanVien.setEnabled(false);

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addComponent(lbMaNhanVien)
                        .addGap(26, 26, 26)
                        .addComponent(txtMaNhanVien))
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addComponent(lbTenNhanVien)
                        .addGap(21, 21, 21)
                        .addComponent(txtTenNhanVien))
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addComponent(lbSoDienThoaiNhanVien)
                        .addGap(30, 30, 30)
                        .addComponent(txtSoDienThoaiNhanVien)))
                .addContainerGap())
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNhanVien)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenNhanVien)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDienThoaiNhanVien)
                    .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gradientPanel1Layout = new javax.swing.GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLapHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnLuuTamHoaDon))
                    .addComponent(pnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addComponent(pnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuTamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTabPhaiLapHoaDonLayout = new javax.swing.GroupLayout(pnTabPhaiLapHoaDon);
        pnTabPhaiLapHoaDon.setLayout(pnTabPhaiLapHoaDonLayout);
        pnTabPhaiLapHoaDonLayout.setHorizontalGroup(
            pnTabPhaiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabPhaiLapHoaDonLayout.createSequentialGroup()
                .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnTabPhaiLapHoaDonLayout.setVerticalGroup(
            pnTabPhaiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pnBodyLapHoaDon.add(pnTabPhaiLapHoaDon);
        pnTabPhaiLapHoaDon.setBounds(1260, 0, 390, 1000);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBodyLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBodyLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemDsSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemDsSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemDsSpActionPerformed

    private void txtSĐTKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSĐTKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSĐTKhachHangActionPerformed

    private void txtNgaySinhKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhKhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLapHoaDon;
    private javax.swing.JButton btnLuuTamHoaDon;
    private javax.swing.JComboBox<String> cbDanhMuc;
    private javax.swing.JComboBox<String> cbLoai;
    private GradientPanel gradientPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneSplDsSp;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbChietKhau;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbNgayLap;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSoDienThoaiKhachHang;
    private javax.swing.JLabel lbSoDienThoaiNhanVien;
    private javax.swing.JLabel lbSoTienkhachTra;
    private javax.swing.JLabel lbTenKhachHang;
    private javax.swing.JLabel lbTenNhanVien;
    private javax.swing.JLabel lbThongSoTienThanToan;
    private javax.swing.JLabel lbThue;
    private MultipleButton multipleButton1;
    private javax.swing.JPanel pnBodyLapHoaDon;
    private javax.swing.JPanel pnBottomSplDsSp;
    private javax.swing.JPanel pnHoaDon;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnTabPhaiLapHoaDon;
    private javax.swing.JPanel pnTabTraiLapHoaDon;
    private javax.swing.JPanel pnThanhToan;
    private javax.swing.JPanel pnTopSplTopGioHang;
    private javax.swing.JSplitPane splLapHoaDon;
    private javax.swing.JTextArea txtAGhiChu;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNgaySinhKh;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    private javax.swing.JTextField txtSoTienKhachPhaiTra;
    private javax.swing.JTextField txtSĐTKhachHang;
    private javax.swing.JTextField txtTenKh;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtThue;
    private javax.swing.JTextField txtTimKiemDsSp;
    private javax.swing.JTextField txtTongSoTienThanhToan;
    // End of variables declaration//GEN-END:variables
}
