/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;


import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.pnDanhSachSanPhamLapHoaDon;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.EventItemSelected;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 *
 * @author Virtue Nguyen
 */
public class LapHoaDon extends JPanel {

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

    private void initComponents() {

        jPanel1 = new JPanel();
        pnBodyLapHoaDon = new JPanel();
        pnTabTraiLapHoaDon = new JPanel();
        splLapHoaDon = new JSplitPane();
        pnTopSplTopGioHang = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        pnBottomSplDsSp = new JPanel();
        jScrollPaneSplDsSp = new JScrollPane();
        multipleButton1 = new dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.MultipleButton();
        txtTimKiemDsSp = new JTextField();
        cbLoai = new JComboBox<>();
        cbDanhMuc = new JComboBox<>();
        pnTabPhaiLapHoaDon = new JPanel();
        gradientPanel1 = new dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.GradientPanel();
        btnLapHoaDon = new JButton();
        btnLuuTamHoaDon = new JButton();
        pnKhachHang = new JPanel();
        lbTenKhachHang = new JLabel();
        lbSoDienThoaiKhachHang = new JLabel();
        lbNgaySinh = new JLabel();
        txtTenKh = new JTextField();
        txtSĐTKhachHang = new JTextField();
        txtNgaySinhKh = new JTextField();
        pnHoaDon = new JPanel();
        lbMaHoaDon = new JLabel();
        lbNgayLap = new JLabel();
        lbGhiChu = new JLabel();
        txtNgayLap = new JTextField();
        txtMaHoaDon = new JTextField();
        jScrollPane1 = new JScrollPane();
        txtAGhiChu = new JTextArea();
        pnThanhToan = new JPanel();
        lbThongSoTienThanToan = new JLabel();
        lbSoTienkhachTra = new JLabel();
        txtSoTienKhachPhaiTra = new JTextField();
        txtTongSoTienThanhToan = new JTextField();
        lbChietKhau = new JLabel();
        lbThue = new JLabel();
        txtThue = new JTextField();
        txtChietKhau = new JTextField();
        pnNhanVien = new JPanel();
        lbMaNhanVien = new JLabel();
        lbTenNhanVien = new JLabel();
        lbSoDienThoaiNhanVien = new JLabel();
        txtMaNhanVien = new JTextField();
        txtTenNhanVien = new JTextField();
        txtSoDienThoaiNhanVien = new JTextField();

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBodyLapHoaDon.setLayout(null);

        splLapHoaDon.setDividerLocation(500);
        splLapHoaDon.setDividerSize(10);
        splLapHoaDon.setOrientation(JSplitPane.VERTICAL_SPLIT);

        pnTopSplTopGioHang.setBackground(new Color(255, 255, 255));

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

        GroupLayout pnTopSplTopGioHangLayout = new GroupLayout(pnTopSplTopGioHang);
        pnTopSplTopGioHang.setLayout(pnTopSplTopGioHangLayout);
        pnTopSplTopGioHangLayout.setHorizontalGroup(
            pnTopSplTopGioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        pnTopSplTopGioHangLayout.setVerticalGroup(
            pnTopSplTopGioHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        splLapHoaDon.setTopComponent(pnTopSplTopGioHang);

        pnBottomSplDsSp.setBackground(new Color(37, 36, 36));

        jScrollPaneSplDsSp.setViewportView(multipleButton1);

        txtTimKiemDsSp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiemDsSp.setText("tìm kiếm");
        txtTimKiemDsSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemDsSpActionPerformed(evt);
            }
        });

        cbLoai.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbDanhMuc.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        GroupLayout pnBottomSplDsSpLayout = new GroupLayout(pnBottomSplDsSp);
        pnBottomSplDsSp.setLayout(pnBottomSplDsSpLayout);
        pnBottomSplDsSpLayout.setHorizontalGroup(
            pnBottomSplDsSpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPaneSplDsSp)
            .addGroup(pnBottomSplDsSpLayout.createSequentialGroup()
                .addComponent(txtTimKiemDsSp, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDanhMuc, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLoai, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        );
        pnBottomSplDsSpLayout.setVerticalGroup(
            pnBottomSplDsSpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomSplDsSpLayout.createSequentialGroup()
                .addGroup(pnBottomSplDsSpLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbLoai)
                    .addComponent(cbDanhMuc)
                    .addComponent(txtTimKiemDsSp))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneSplDsSp, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        splLapHoaDon.setRightComponent(pnBottomSplDsSp);

        GroupLayout pnTabTraiLapHoaDonLayout = new GroupLayout(pnTabTraiLapHoaDon);
        pnTabTraiLapHoaDon.setLayout(pnTabTraiLapHoaDonLayout);
        pnTabTraiLapHoaDonLayout.setHorizontalGroup(
            pnTabTraiLapHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnTabTraiLapHoaDonLayout.createSequentialGroup()
                .addComponent(splLapHoaDon)
                .addContainerGap())
        );
        pnTabTraiLapHoaDonLayout.setVerticalGroup(
            pnTabTraiLapHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(splLapHoaDon, GroupLayout.Alignment.TRAILING)
        );

        pnBodyLapHoaDon.add(pnTabTraiLapHoaDon);
        pnTabTraiLapHoaDon.setBounds(0, 0, 1260, 1000);

        pnTabPhaiLapHoaDon.setBackground(new Color(255, 255, 255));

        gradientPanel1.setPreferredSize(new java.awt.Dimension(401, 889));

        btnLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLapHoaDon.setText("Lập hoá đơn");

        btnLuuTamHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuTamHoaDon.setText("Lưu tạm hoá đơn");

        pnKhachHang.setBorder(BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        GroupLayout pnKhachHangLayout = new GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addComponent(lbTenKhachHang)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKh))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lbSoDienThoaiKhachHang)
                            .addComponent(lbNgaySinh))
                        .addGap(30, 30, 30)
                        .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtSĐTKhachHang)
                            .addComponent(txtNgaySinhKh))))
                .addContainerGap())
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenKhachHang)
                    .addComponent(txtTenKh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDienThoaiKhachHang)
                    .addComponent(txtSĐTKhachHang))
                .addGroup(pnKhachHangLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbNgaySinh))
                    .addGroup(pnKhachHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNgaySinhKh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnHoaDon.setBorder(BorderFactory.createTitledBorder(null, "Hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        GroupLayout pnHoaDonLayout = new GroupLayout(pnHoaDon);
        pnHoaDon.setLayout(pnHoaDonLayout);
        pnHoaDonLayout.setHorizontalGroup(
            pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaHoaDon)
                            .addComponent(lbNgayLap))
                        .addGap(56, 56, 56)
                        .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHoaDon, GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayLap, GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnHoaDonLayout.createSequentialGroup()
                        .addComponent(lbGhiChu)
                        .addGap(93, 93, 93)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnHoaDonLayout.setVerticalGroup(
            pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaHoaDon)
                    .addComponent(txtMaHoaDon, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayLap, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNgayLap))
                .addGap(18, 18, 18)
                .addGroup(pnHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbGhiChu)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                .addGap(153, 153, 153))
        );

        pnThanhToan.setBorder(BorderFactory.createTitledBorder(null, "Thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        GroupLayout pnThanhToanLayout = new GroupLayout(pnThanhToan);
        pnThanhToan.setLayout(pnThanhToanLayout);
        pnThanhToanLayout.setHorizontalGroup(
            pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbSoTienkhachTra)
                        .addGap(67, 67, 67)
                        .addComponent(txtSoTienKhachPhaiTra))
                    .addGroup(pnThanhToanLayout.createSequentialGroup()
                        .addComponent(lbThongSoTienThanToan)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
            pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThue)
                    .addComponent(txtThue, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbChietKhau)
                    .addComponent(txtChietKhau, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoTienkhachTra)
                    .addComponent(txtSoTienKhachPhaiTra, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThanhToanLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThongSoTienThanToan)
                    .addComponent(txtTongSoTienThanhToan, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnNhanVien.setBorder(BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        GroupLayout pnNhanVienLayout = new GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
            pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaNhanVien)
                    .addComponent(txtMaNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenNhanVien)
                    .addComponent(txtTenNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnNhanVienLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoDienThoaiNhanVien)
                    .addComponent(txtSoDienThoaiNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout gradientPanel1Layout = new GroupLayout(gradientPanel1);
        gradientPanel1.setLayout(gradientPanel1Layout);
        gradientPanel1Layout.setHorizontalGroup(
            gradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnNhanVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addGroup(gradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, gradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLapHoaDon)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnLuuTamHoaDon))
                    .addComponent(pnThanhToan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gradientPanel1Layout.setVerticalGroup(
            gradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gradientPanel1Layout.createSequentialGroup()
                .addComponent(pnNhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnHoaDon, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnThanhToan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuTamHoaDon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        GroupLayout pnTabPhaiLapHoaDonLayout = new GroupLayout(pnTabPhaiLapHoaDon);
        pnTabPhaiLapHoaDon.setLayout(pnTabPhaiLapHoaDonLayout);
        pnTabPhaiLapHoaDonLayout.setHorizontalGroup(
            pnTabPhaiLapHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnTabPhaiLapHoaDonLayout.createSequentialGroup()
                .addComponent(gradientPanel1, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnTabPhaiLapHoaDonLayout.setVerticalGroup(
            pnTabPhaiLapHoaDonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(gradientPanel1, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );

        pnBodyLapHoaDon.add(pnTabPhaiLapHoaDon);
        pnTabPhaiLapHoaDon.setBounds(1260, 0, 390, 1000);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnBodyLapHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(pnBodyLapHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }



    private JButton btnLapHoaDon;
    private JButton btnLuuTamHoaDon;
    private JComboBox<String> cbDanhMuc;
    private JComboBox<String> cbLoai;
    private dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.GradientPanel gradientPanel1;

    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPaneSplDsSp;
    private JTable jTable1;
    private JLabel lbChietKhau;
    private JLabel lbGhiChu;
    private JLabel lbMaHoaDon;
    private JLabel lbMaNhanVien;
    private JLabel lbNgayLap;
    private JLabel lbNgaySinh;
    private JLabel lbSoDienThoaiKhachHang;
    private JLabel lbSoDienThoaiNhanVien;
    private JLabel lbSoTienkhachTra;
    private JLabel lbTenKhachHang;
    private JLabel lbTenNhanVien;
    private JLabel lbThongSoTienThanToan;
    private JLabel lbThue;
    private dev.skyherobrine.app.views.dashboard.component.lapHoaDon.setting.danhSachSanPham.MultipleButton multipleButton1;
    private JPanel pnBodyLapHoaDon;
    private JPanel pnBottomSplDsSp;
    private JPanel pnHoaDon;
    private JPanel pnKhachHang;
    private JPanel pnNhanVien;
    private JPanel pnTabPhaiLapHoaDon;
    private JPanel pnTabTraiLapHoaDon;
    private JPanel pnThanhToan;
    private JPanel pnTopSplTopGioHang;
    private JSplitPane splLapHoaDon;
    private JTextArea txtAGhiChu;
    private JTextField txtChietKhau;
    private JTextField txtMaHoaDon;
    private JTextField txtMaNhanVien;
    private JTextField txtNgayLap;
    private JTextField txtNgaySinhKh;
    private JTextField txtSoDienThoaiNhanVien;
    private JTextField txtSoTienKhachPhaiTra;
    private JTextField txtSĐTKhachHang;
    private JTextField txtTenKh;
    private JTextField txtTenNhanVien;
    private JTextField txtThue;
    private JTextField txtTimKiemDsSp;
    private JTextField txtTongSoTienThanhToan;
    // End of variables declaration//GEN-END:variables
}