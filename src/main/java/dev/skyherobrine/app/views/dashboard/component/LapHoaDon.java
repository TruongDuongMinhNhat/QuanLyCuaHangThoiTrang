/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;

import dev.skyherobrine.app.controllers.dashboardui.mainDashboard.LapHoaDonController;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.TableActionCellEditor;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.TableActionCellRender;
import dev.skyherobrine.app.views.dashboard.component.lapHoaDon.TableActionEvent;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Virtue Nguyen
 */
public class LapHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinCaNhan
     */
    public LapHoaDon() {
        initComponents();
        TableActionEvent event1 = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if(tbDanhSachCacSanPhamTrongGioHang.isEditing()){
                    tbDanhSachCacSanPhamTrongGioHang.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel)tbDanhSachCacSanPhamTrongGioHang.getModel();
                model.removeRow(row);
                System.out.println("Bảng danh sách sản phẩm giỏ hàng. Xoá hàng ngang theo mảng: "+row);
            }
        };
        tbDanhSachCacSanPhamTrongGioHang.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        tbDanhSachCacSanPhamTrongGioHang.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event1));

        TableActionEvent event2 = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if(tbHoaDonLuuTam.isEditing()){
                    tbHoaDonLuuTam.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel)tbHoaDonLuuTam.getModel();
                model.removeRow(row);
                System.out.println("Bảng lưu hoá đơn tạm. Xoá hàng ngang theo mảng: "+row);
            }
        };
        tbHoaDonLuuTam.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        tbHoaDonLuuTam.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event2));
        new LapHoaDonController(this);
        txtTimKiemSanPham.addKeyListener(new LapHoaDonController(this));
        menuProduct.add(panel2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        listProduct = new javax.swing.JList<>();
        menuProduct = new javax.swing.JPopupMenu();
        pnBGLapHoaDon = new javax.swing.JPanel();
        pnTraiLapHoaDon = new javax.swing.JPanel();
        pnPhaiTrenLapHoaDon = new javax.swing.JPanel();
        txtTimKiemSanPham = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        spDanhSachCacSanPhamTrongGioHang = new javax.swing.JScrollPane();
        tbDanhSachCacSanPhamTrongGioHang = new javax.swing.JTable();
        pnPhaiDuoiLapHoaDon = new javax.swing.JPanel();
        pnCamera = new javax.swing.JPanel();
        pnHoaDonLuuTam = new javax.swing.JPanel();
        spHoaDonLuuTam = new javax.swing.JScrollPane();
        tbHoaDonLuuTam = new javax.swing.JTable();
        txtTimKiemHoaDonLuuTam = new javax.swing.JTextField();
        pnPhaiLapHoaDon = new javax.swing.JPanel();
        pnThongTinHoaDon = new javax.swing.JPanel();
        pnThongTInKhachHang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserNgayLapHoaDonKh = new com.toedter.calendar.JDateChooser();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoaiKh = new javax.swing.JTextField();
        pnThonhTinNhanVien = new javax.swing.JPanel();
        lbMaNhanVien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtSoDienTHoaiNv = new javax.swing.JTextField();
        pnTHongTinHoaDon = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtThue = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        txtTongTIen = new javax.swing.JTextField();
        btnLapHoaDon = new javax.swing.JButton();
        btnLuuTam = new javax.swing.JButton();

        panel2.setPreferredSize(new java.awt.Dimension(390, 100));

        listProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        menuProduct.setFocusable(false);

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnBGLapHoaDon.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnTraiLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        pnPhaiTrenLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiemSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiemSanPham.setText("Tìm kiếm sản phẩm");
        txtTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemSanPhamActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách các sản phẩm trong giỏ hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        spDanhSachCacSanPhamTrongGioHang.setBackground(new java.awt.Color(255, 255, 255));

        tbDanhSachCacSanPhamTrongGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Số thứ tự", "Mã sản phẩm", "Tên sản phẩm", "Kích thước", "Số lượng", "Đơn giá", "Thành tiền", ""
            }
        ));
        tbDanhSachCacSanPhamTrongGioHang.setRowHeight(40);
        tbDanhSachCacSanPhamTrongGioHang.setSelectionBackground(new java.awt.Color(0, 255, 58));
        tbDanhSachCacSanPhamTrongGioHang.setSelectionForeground(new java.awt.Color(243, 7, 7));
        spDanhSachCacSanPhamTrongGioHang.setViewportView(tbDanhSachCacSanPhamTrongGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachCacSanPhamTrongGioHang)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachCacSanPhamTrongGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnPhaiTrenLapHoaDonLayout = new javax.swing.GroupLayout(pnPhaiTrenLapHoaDon);
        pnPhaiTrenLapHoaDon.setLayout(pnPhaiTrenLapHoaDonLayout);
        pnPhaiTrenLapHoaDonLayout.setHorizontalGroup(
            pnPhaiTrenLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhaiTrenLapHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPhaiTrenLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPhaiTrenLapHoaDonLayout.createSequentialGroup()
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnPhaiTrenLapHoaDonLayout.setVerticalGroup(
            pnPhaiTrenLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhaiTrenLapHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnPhaiDuoiLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        pnCamera.setBackground(new java.awt.Color(255, 255, 255));
        pnCamera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Camera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        javax.swing.GroupLayout pnCameraLayout = new javax.swing.GroupLayout(pnCamera);
        pnCamera.setLayout(pnCameraLayout);
        pnCameraLayout.setHorizontalGroup(
            pnCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        pnCameraLayout.setVerticalGroup(
            pnCameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnHoaDonLuuTam.setBackground(new java.awt.Color(255, 255, 255));
        pnHoaDonLuuTam.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá đơn lưu tạm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tbHoaDonLuuTam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số thứ tự", "Tên khách hàng", "Số điện thoại", ""
            }
        ));
        tbHoaDonLuuTam.setRowHeight(40);
        tbHoaDonLuuTam.setSelectionBackground(new java.awt.Color(0, 255, 91));
        tbHoaDonLuuTam.setSelectionForeground(new java.awt.Color(255, 0, 0));
        spHoaDonLuuTam.setViewportView(tbHoaDonLuuTam);

        javax.swing.GroupLayout pnHoaDonLuuTamLayout = new javax.swing.GroupLayout(pnHoaDonLuuTam);
        pnHoaDonLuuTam.setLayout(pnHoaDonLuuTamLayout);
        pnHoaDonLuuTamLayout.setHorizontalGroup(
            pnHoaDonLuuTamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spHoaDonLuuTam, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );
        pnHoaDonLuuTamLayout.setVerticalGroup(
            pnHoaDonLuuTamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spHoaDonLuuTam, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        txtTimKiemHoaDonLuuTam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiemHoaDonLuuTam.setText("Tìm kiếm hoá đơn lưu tạm");
        txtTimKiemHoaDonLuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHoaDonLuuTamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPhaiDuoiLapHoaDonLayout = new javax.swing.GroupLayout(pnPhaiDuoiLapHoaDon);
        pnPhaiDuoiLapHoaDon.setLayout(pnPhaiDuoiLapHoaDonLayout);
        pnPhaiDuoiLapHoaDonLayout.setHorizontalGroup(
            pnPhaiDuoiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhaiDuoiLapHoaDonLayout.createSequentialGroup()
                .addComponent(pnCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPhaiDuoiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemHoaDonLuuTam)
                    .addComponent(pnHoaDonLuuTam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnPhaiDuoiLapHoaDonLayout.setVerticalGroup(
            pnPhaiDuoiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhaiDuoiLapHoaDonLayout.createSequentialGroup()
                .addComponent(pnHoaDonLuuTam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemHoaDonLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pnCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnTraiLapHoaDonLayout = new javax.swing.GroupLayout(pnTraiLapHoaDon);
        pnTraiLapHoaDon.setLayout(pnTraiLapHoaDonLayout);
        pnTraiLapHoaDonLayout.setHorizontalGroup(
            pnTraiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPhaiTrenLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnPhaiDuoiLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnTraiLapHoaDonLayout.setVerticalGroup(
            pnTraiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTraiLapHoaDonLayout.createSequentialGroup()
                .addComponent(pnPhaiTrenLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPhaiDuoiLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnPhaiLapHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        pnThongTinHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hoá đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        pnThongTInKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ngày lập hoá đơn:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jDateChooserNgayLapHoaDonKh.setEnabled(false);

        txtTenKhachHang.setEnabled(false);

        javax.swing.GroupLayout pnThongTInKhachHangLayout = new javax.swing.GroupLayout(pnThongTInKhachHang);
        pnThongTInKhachHang.setLayout(pnThongTInKhachHangLayout);
        pnThongTInKhachHangLayout.setHorizontalGroup(
            pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserNgayLapHoaDonKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenKhachHang)
                    .addComponent(txtSoDienThoaiKh))
                .addContainerGap())
        );
        pnThongTInKhachHangLayout.setVerticalGroup(
            pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTInKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtTenKhachHang))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooserNgayLapHoaDonKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTInKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoaiKh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnThonhTinNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        lbMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMaNhanVien.setText("Mã nhân viên:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tên nhân viên:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        txtTenNhanVien.setEnabled(false);

        txtMaNhanVien.setEnabled(false);

        txtSoDienTHoaiNv.setEnabled(false);

        javax.swing.GroupLayout pnThonhTinNhanVienLayout = new javax.swing.GroupLayout(pnThonhTinNhanVien);
        pnThonhTinNhanVien.setLayout(pnThonhTinNhanVienLayout);
        pnThonhTinNhanVienLayout.setHorizontalGroup(
            pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThonhTinNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThonhTinNhanVienLayout.createSequentialGroup()
                        .addComponent(lbMaNhanVien)
                        .addGap(11, 11, 11)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                    .addGroup(pnThonhTinNhanVienLayout.createSequentialGroup()
                        .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(pnThonhTinNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoDienTHoaiNv)
                            .addComponent(txtTenNhanVien))))
                .addContainerGap())
        );
        pnThonhTinNhanVienLayout.setVerticalGroup(
            pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThonhTinNhanVienLayout.createSequentialGroup()
                .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtMaNhanVien))
                .addGap(18, 18, 18)
                .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNhanVien)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThonhTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtSoDienTHoaiNv)))
        );

        pnTHongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tiền khách đưa:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thuế:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Chiết khấu:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tổng tiền:");

        txtTienKhachDua.setEnabled(false);

        txtThue.setEnabled(false);

        txtChietKhau.setEnabled(false);

        txtTongTIen.setEnabled(false);

        javax.swing.GroupLayout pnTHongTinHoaDonLayout = new javax.swing.GroupLayout(pnTHongTinHoaDon);
        pnTHongTinHoaDon.setLayout(pnTHongTinHoaDonLayout);
        pnTHongTinHoaDonLayout.setHorizontalGroup(
            pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTHongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua)
                    .addComponent(txtThue)
                    .addComponent(txtChietKhau)
                    .addComponent(txtTongTIen))
                .addContainerGap())
        );
        pnTHongTinHoaDonLayout.setVerticalGroup(
            pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTHongTinHoaDonLayout.createSequentialGroup()
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtTienKhachDua))
                .addGap(18, 18, 18)
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtThue)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtChietKhau)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnTHongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtTongTIen)))
        );

        btnLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLapHoaDon.setText("Lập hoá đơn");
        btnLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHoaDonActionPerformed(evt);
            }
        });

        btnLuuTam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLuuTam.setText("Lưu tạm bill");
        btnLuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinHoaDonLayout = new javax.swing.GroupLayout(pnThongTinHoaDon);
        pnThongTinHoaDon.setLayout(pnThongTinHoaDonLayout);
        pnThongTinHoaDonLayout.setHorizontalGroup(
            pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThongTInKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTHongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnThongTinHoaDonLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnLapHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnThonhTinNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnThongTinHoaDonLayout.setVerticalGroup(
            pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinHoaDonLayout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(pnThongTInKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pnTHongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
            .addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnThongTinHoaDonLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(pnThonhTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(763, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnPhaiLapHoaDonLayout = new javax.swing.GroupLayout(pnPhaiLapHoaDon);
        pnPhaiLapHoaDon.setLayout(pnPhaiLapHoaDonLayout);
        pnPhaiLapHoaDonLayout.setHorizontalGroup(
            pnPhaiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhaiLapHoaDonLayout.createSequentialGroup()
                .addComponent(pnThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        pnPhaiLapHoaDonLayout.setVerticalGroup(
            pnPhaiLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnBGLapHoaDonLayout = new javax.swing.GroupLayout(pnBGLapHoaDon);
        pnBGLapHoaDon.setLayout(pnBGLapHoaDonLayout);
        pnBGLapHoaDonLayout.setHorizontalGroup(
            pnBGLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGLapHoaDonLayout.createSequentialGroup()
                .addComponent(pnTraiLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPhaiLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        pnBGLapHoaDonLayout.setVerticalGroup(
            pnBGLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTraiLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnPhaiLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBGLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBGLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemHoaDonLuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonLuuTamActionPerformed
        if (txtTimKiemHoaDonLuuTam.getText().equalsIgnoreCase("Tìm kiếm hoá đơn lưu tạm")) {
        txtTimKiemHoaDonLuuTam.setText("");
        txtTimKiemHoaDonLuuTam.setForeground(Color.BLACK); // Đổi màu văn bản khi bắt đầu nhập
    }
    }//GEN-LAST:event_txtTimKiemHoaDonLuuTamActionPerformed

    private void txtTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamActionPerformed
        if(txtTimKiemSanPham.getText().equalsIgnoreCase("Tìm kiếm sản phẩm")){
            txtTimKiemSanPham.setText("");
            txtTimKiemSanPham.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtTimKiemSanPhamActionPerformed

    private void btnLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHoaDonActionPerformed
        System.out.println("Đã Lập hoá đơn");
    }//GEN-LAST:event_btnLapHoaDonActionPerformed

    private void btnLuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTamActionPerformed
        // TODO add your handling code here:
        System.out.println("Đã lưu bản nháp hoá đơm");
    }//GEN-LAST:event_btnLuuTamActionPerformed

   public JTextField getTxtTimKiemSanPham(){
        return txtTimKiemSanPham;
    }

    public JTextField getTxtTimKiemHoaDonLuuTam(){
        return txtTimKiemHoaDonLuuTam;
    }

    public JPopupMenu getMenuProduct(){
        return menuProduct;
    }
    public JList getListProduct(){
        return listProduct;
    }
    public JPanel getPnCamera(){
        return pnCamera;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLapHoaDon;
    private javax.swing.JButton btnLuuTam;
    private com.toedter.calendar.JDateChooser jDateChooserNgayLapHoaDonKh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JList<String> listProduct;
    private javax.swing.JPopupMenu menuProduct;
    private java.awt.Panel panel2;
    private javax.swing.JPanel pnBGLapHoaDon;
    private javax.swing.JPanel pnCamera;
    private javax.swing.JPanel pnHoaDonLuuTam;
    private javax.swing.JPanel pnPhaiDuoiLapHoaDon;
    private javax.swing.JPanel pnPhaiLapHoaDon;
    private javax.swing.JPanel pnPhaiTrenLapHoaDon;
    private javax.swing.JPanel pnTHongTinHoaDon;
    private javax.swing.JPanel pnThongTInKhachHang;
    private javax.swing.JPanel pnThongTinHoaDon;
    private javax.swing.JPanel pnThonhTinNhanVien;
    private javax.swing.JPanel pnTraiLapHoaDon;
    private javax.swing.JScrollPane spDanhSachCacSanPhamTrongGioHang;
    private javax.swing.JScrollPane spHoaDonLuuTam;
    private javax.swing.JTable tbDanhSachCacSanPhamTrongGioHang;
    private javax.swing.JTable tbHoaDonLuuTam;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienTHoaiNv;
    private javax.swing.JTextField txtSoDienThoaiKh;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtThue;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiemHoaDonLuuTam;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTongTIen;
    // End of variables declaration//GEN-END:variables
}
