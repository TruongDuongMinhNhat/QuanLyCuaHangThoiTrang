/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.component;



import com.toedter.calendar.JDateChooser;
import dev.skyherobrine.app.controllers.dashboardui.order.NhapHangController;
import dev.skyherobrine.app.views.dashboard.component.nutXoaDongTb.TableActionEvent;
import dev.skyherobrine.app.views.dashboard.component.nutDuyetVaNutXoaDongTb.TableActionCellEditor1;
import dev.skyherobrine.app.views.dashboard.component.nutDuyetVaNutXoaDongTb.TableActionCellRender1;
import dev.skyherobrine.app.views.dashboard.component.nutDuyetVaNutXoaDongTb.TableActionEvent1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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

        NhapHangController controller = new NhapHangController(this);

        controller.loadPhieuNhap();
        controller.loadComboBoxPhanTimKiem();
        tbDanhSachPheiNhap.addMouseListener(controller);

        menuSPNhap.add(pnTimSPNhap);
        menuNCCNhap.add(pnNCCNhap);

        listSPNhap.addKeyListener(controller);
        listNCCNhap.addKeyListener(controller);

        btnThemPhieuNhap.addActionListener(controller);
        btnSuaPhieuNhap.addActionListener(controller);
        btnXuatFile.addActionListener(controller);

        txtTimKiemSanPhamNhap.addKeyListener(controller);
        txtNhaCungCap.addKeyListener(controller);

        tbDanhSachSpTrongGioHang.getModel().addTableModelListener(controller);

        cbTkNhaCungCap.addActionListener(controller);
        cbTkTinhTrang.addActionListener(controller);
        jDateChooserTkNgayLapPhieu.addPropertyChangeListener(controller);
        jDateChooserTkNgayHenGiao.addPropertyChangeListener(controller);





        TableActionEvent1 event = new TableActionEvent1() {
            @Override
            public void onDuyet(int row) {
                    System.out.println(".onDuyet");
                }

            @Override
            public void onHuy(int row) {
                if (tbDanhSachPheiNhap.isEditing()) {
                    tbDanhSachPheiNhap.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tbDanhSachPheiNhap.getModel();
                model.removeRow(row);
            }
        };
        tbDanhSachPheiNhap.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender1());
        tbDanhSachPheiNhap.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor1(event));
        
        dev.skyherobrine.app.views.dashboard.component.nutXoaDongTb.TableActionEvent event1 = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (tbDanhSachSpTrongGioHang.isEditing()) {
                    tbDanhSachSpTrongGioHang.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tbDanhSachSpTrongGioHang.getModel();
                model.removeRow(row);
            }
        };
        tbDanhSachSpTrongGioHang.getColumnModel().getColumn(7).setCellRenderer(new dev.skyherobrine.app.views.dashboard.component.nutXoaDongTb.TableActionCellRender());
        tbDanhSachSpTrongGioHang.getColumnModel().getColumn(7).setCellEditor(new dev.skyherobrine.app.views.dashboard.component.nutXoaDongTb.TableActionCellEditor(event1));
        
        
        dev.skyherobrine.app.views.dashboard.component.nutChon.TableActionEvent event2 = new dev.skyherobrine.app.views.dashboard.component.nutChon.TableActionEvent() {
            @Override
            public void onChon(int row) {
                System.out.println(".onChon()");
                }
        };
        tbDanhSachSpTrongGioHang.getColumnModel().getColumn(3).setCellRenderer(new dev.skyherobrine.app.views.dashboard.component.nutChon.TableActionCellRender());
        tbDanhSachSpTrongGioHang.getColumnModel().getColumn(3).setCellEditor(new dev.skyherobrine.app.views.dashboard.component.nutChon.TableActionCellEditor(event2));

        dev.skyherobrine.app.views.dashboard.component.nutHuy.TableActionEvent event3 = new dev.skyherobrine.app.views.dashboard.component.nutHuy.TableActionEvent() {
            @Override
            public void onHuy(int row) {
                System.out.println(".onHuy()");
            }
        };
        tbChonPBSP.getColumnModel().getColumn(3).setCellRenderer(new dev.skyherobrine.app.views.dashboard.component.nutHuy.TableActionCellRender());
        tbChonPBSP.getColumnModel().getColumn(3).setCellEditor(new dev.skyherobrine.app.views.dashboard.component.nutHuy.TableActionCellEditor(event3));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTimSPNhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSPNhap = new javax.swing.JList<>();
        menuSPNhap = new javax.swing.JPopupMenu();
        pnNCCNhap = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNCCNhap = new javax.swing.JList<>();
        menuNCCNhap = new javax.swing.JPopupMenu();
        fmPBSP = new javax.swing.JFrame();
        pnChonPBSP = new javax.swing.JPanel();
        lblSanPhamFrmChonPBSP = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbChonPBSP = new javax.swing.JTable();
        btnChonXongPBSP = new javax.swing.JButton();
        pnBGThongTinCaNhan = new javax.swing.JPanel();
        pnThongTinNhapHang = new javax.swing.JPanel();
        pnButton = new javax.swing.JPanel();
        btnThemPhieuNhap = new javax.swing.JButton();
        btnSuaPhieuNhap = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        txtTimKiemSanPhamNhap = new javax.swing.JTextField();
        pnDanhSach = new javax.swing.JPanel();
        spDanhSachSpTrongGioHang = new javax.swing.JScrollPane();
        tbDanhSachSpTrongGioHang = new javax.swing.JTable();
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
        txtTkPhieuNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnThongTinCuaHang = new javax.swing.JPanel();
        lbDiaChiCuaHang = new javax.swing.JLabel();
        lbDienThoaiCuaHang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDienThoaiCuaHang = new javax.swing.JTextField();
        txtEmailCUaHang = new javax.swing.JTextField();
        txtDiaChiCuaHang = new javax.swing.JTextField();
        pnTHongTinNhaCungCap = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNhaCungCap = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtEmailNhaCungCap = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooserNgayHenGiao = new com.toedter.calendar.JDateChooser();
        txtTongTienSanPham = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTinhTrangPhieuNhap = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();

        pnTimSPNhap.setFocusable(false);

        listSPNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listSPNhap);

        javax.swing.GroupLayout pnTimSPNhapLayout = new javax.swing.GroupLayout(pnTimSPNhap);
        pnTimSPNhap.setLayout(pnTimSPNhapLayout);
        pnTimSPNhapLayout.setHorizontalGroup(
            pnTimSPNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        pnTimSPNhapLayout.setVerticalGroup(
            pnTimSPNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        menuSPNhap.setFocusable(false);

        listNCCNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(listNCCNhap);

        javax.swing.GroupLayout pnNCCNhapLayout = new javax.swing.GroupLayout(pnNCCNhap);
        pnNCCNhap.setLayout(pnNCCNhapLayout);
        pnNCCNhapLayout.setHorizontalGroup(
            pnNCCNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
        );
        pnNCCNhapLayout.setVerticalGroup(
            pnNCCNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        fmPBSP.setAutoRequestFocus(false);
        fmPBSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fmPBSP.setSize(new java.awt.Dimension(600, 400));

        pnChonPBSP.setFocusable(false);
        pnChonPBSP.setRequestFocusEnabled(false);

        lblSanPhamFrmChonPBSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSanPhamFrmChonPBSP.setText("Sản phẩm:");

        jTextField1.setText("jTextField1");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Các phiên bản sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbChonPBSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Màu sắc", "Kích thước", "Số lượng", ""
            }
        ));
        tbChonPBSP.setRowHeight(40);
        jScrollPane3.setViewportView(tbChonPBSP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChonXongPBSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChonXongPBSP.setText("Xong");
        btnChonXongPBSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonXongPBSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChonPBSPLayout = new javax.swing.GroupLayout(pnChonPBSP);
        pnChonPBSP.setLayout(pnChonPBSPLayout);
        pnChonPBSPLayout.setHorizontalGroup(
            pnChonPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChonPBSPLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnChonPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnChonPBSPLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblSanPhamFrmChonPBSP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChonPBSPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChonXongPBSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnChonPBSPLayout.setVerticalGroup(
            pnChonPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChonPBSPLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnChonPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSanPhamFrmChonPBSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonXongPBSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fmPBSPLayout = new javax.swing.GroupLayout(fmPBSP.getContentPane());
        fmPBSP.getContentPane().setLayout(fmPBSPLayout);
        fmPBSPLayout.setHorizontalGroup(
            fmPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
            .addGroup(fmPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fmPBSPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnChonPBSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        fmPBSPLayout.setVerticalGroup(
            fmPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
            .addGroup(fmPBSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fmPBSPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnChonPBSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnBGThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));
        pnBGThongTinCaNhan.setPreferredSize(new java.awt.Dimension(1651, 1000));

        pnThongTinNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinNhapHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhập hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        pnThongTinNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        pnButton.setBackground(new java.awt.Color(255, 255, 255));

        btnThemPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThemPhieuNhap.setText("Thêm phiếu nhập");

        btnSuaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaPhieuNhap.setText("Sửa phiếu nhập");

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatFile.setText("Nhập file");

        javax.swing.GroupLayout pnButtonLayout = new javax.swing.GroupLayout(pnButton);
        pnButton.setLayout(pnButtonLayout);
        pnButtonLayout.setHorizontalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnThemPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(btnSuaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        pnButtonLayout.setVerticalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnSuaPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtTimKiemSanPhamNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbDanhSachSpTrongGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "PBSP", "Số lượng", "Đơn giá", "Thành tiền", ""
            }
        ));
        tbDanhSachSpTrongGioHang.setRowHeight(40);
        spDanhSachSpTrongGioHang.setViewportView(tbDanhSachSpTrongGioHang);

        javax.swing.GroupLayout pnDanhSachLayout = new javax.swing.GroupLayout(pnDanhSach);
        pnDanhSach.setLayout(pnDanhSachLayout);
        pnDanhSachLayout.setHorizontalGroup(
            pnDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachSpTrongGioHang)
        );
        pnDanhSachLayout.setVerticalGroup(
            pnDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachSpTrongGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnThongTinNhapHangLayout = new javax.swing.GroupLayout(pnThongTinNhapHang);
        pnThongTinNhapHang.setLayout(pnThongTinNhapHangLayout);
        pnThongTinNhapHangLayout.setHorizontalGroup(
            pnThongTinNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnThongTinNhapHangLayout.createSequentialGroup()
                .addComponent(txtTimKiemSanPhamNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnThongTinNhapHangLayout.setVerticalGroup(
            pnThongTinNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinNhapHangLayout.createSequentialGroup()
                .addComponent(txtTimKiemSanPhamNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnDanhSachPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnDanhSachPhieuNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách phiếu nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbDanhSachPheiNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "Nhà cung cấp", "Ngày lập", "Ngày gia hạn", "Tình trạng", ""
            }
        ));
        tbDanhSachPheiNhap.setRowHeight(40);
        spDanhSachPhieuNhap.setViewportView(tbDanhSachPheiNhap);

        javax.swing.GroupLayout pnDanhSachPhieuNhapLayout = new javax.swing.GroupLayout(pnDanhSachPhieuNhap);
        pnDanhSachPhieuNhap.setLayout(pnDanhSachPhieuNhapLayout);
        pnDanhSachPhieuNhapLayout.setHorizontalGroup(
            pnDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE)
        );
        pnDanhSachPhieuNhapLayout.setVerticalGroup(
            pnDanhSachPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooserTkNgayHenGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTkPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTimKiemPhieuNhapLayout.setVerticalGroup(
            pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimKiemPhieuNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTkPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jDateChooserTkNgayLapPhieu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnTimKiemPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTkNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTkTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jDateChooserTkNgayHenGiao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnThongTinCuaHang.setBackground(new java.awt.Color(255, 255, 255));
        pnThongTinCuaHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cửa hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbDiaChiCuaHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDiaChiCuaHang.setText("Địa chỉ:");

        lbDienThoaiCuaHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbDienThoaiCuaHang.setText("Điện thoại:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Email:");

        javax.swing.GroupLayout pnThongTinCuaHangLayout = new javax.swing.GroupLayout(pnThongTinCuaHang);
        pnThongTinCuaHang.setLayout(pnThongTinCuaHangLayout);
        pnThongTinCuaHangLayout.setHorizontalGroup(
            pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinCuaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDienThoaiCuaHang)
                    .addComponent(lbDiaChiCuaHang)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDienThoaiCuaHang)
                    .addComponent(txtEmailCUaHang)
                    .addComponent(txtDiaChiCuaHang))
                .addContainerGap())
        );
        pnThongTinCuaHangLayout.setVerticalGroup(
            pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinCuaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDiaChiCuaHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChiCuaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDienThoaiCuaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lbDienThoaiCuaHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmailCUaHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnTHongTinNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        pnTHongTinNhaCungCap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Nhà cung cấp:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Email:");

        javax.swing.GroupLayout pnTHongTinNhaCungCapLayout = new javax.swing.GroupLayout(pnTHongTinNhaCungCap);
        pnTHongTinNhaCungCap.setLayout(pnTHongTinNhaCungCapLayout);
        pnTHongTinNhaCungCapLayout.setHorizontalGroup(
            pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTHongTinNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDiaChi)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnTHongTinNhaCungCapLayout.setVerticalGroup(
            pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTHongTinNhaCungCapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnTHongTinNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(290, 290, 290))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Ngày lập:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Ngày hẹn giao");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Tổng tiền sản phẩm:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tình trạng:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Mã phiếu:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Ghi chú:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGhiChu)
                    .addComponent(txtMaPhieu)
                    .addComponent(txtTinhTrangPhieuNhap)
                    .addComponent(txtTongTienSanPham)
                    .addComponent(jDateChooserNgayHenGiao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayLap))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtMaPhieu))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserNgayHenGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinhTrangPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtGhiChu))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnThongTinCuaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTHongTinNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnThongTinCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTHongTinNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBGThongTinCaNhanLayout = new javax.swing.GroupLayout(pnBGThongTinCaNhan);
        pnBGThongTinCaNhan.setLayout(pnBGThongTinCaNhanLayout);
        pnBGThongTinCaNhanLayout.setHorizontalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnThongTinNhapHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnTimKiemPhieuNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnDanhSachPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnBGThongTinCaNhanLayout.setVerticalGroup(
            pnBGThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBGThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(pnDanhSachPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiemPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTinNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnChonXongPBSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonXongPBSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonXongPBSPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonXongPBSP;
    private javax.swing.JButton btnSuaPhieuNhap;
    private javax.swing.JButton btnThemPhieuNhap;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbTkNhaCungCap;
    private javax.swing.JComboBox<String> cbTkTinhTrang;
    private javax.swing.JFrame fmPBSP;
    private com.toedter.calendar.JDateChooser jDateChooserNgayHenGiao;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayHenGiao;
    private com.toedter.calendar.JDateChooser jDateChooserTkNgayLapPhieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbDiaChiCuaHang;
    private javax.swing.JLabel lbDienThoaiCuaHang;
    private javax.swing.JLabel lblSanPhamFrmChonPBSP;
    private javax.swing.JList<String> listNCCNhap;
    private javax.swing.JList<String> listSPNhap;
    private javax.swing.JPopupMenu menuNCCNhap;
    private javax.swing.JPopupMenu menuSPNhap;
    private javax.swing.JPanel pnBGThongTinCaNhan;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnChonPBSP;
    private javax.swing.JPanel pnDanhSach;
    private javax.swing.JPanel pnDanhSachPhieuNhap;
    private javax.swing.JPanel pnNCCNhap;
    private javax.swing.JPanel pnTHongTinNhaCungCap;
    private javax.swing.JPanel pnThongTinCuaHang;
    private javax.swing.JPanel pnThongTinNhapHang;
    private javax.swing.JPanel pnTimKiemPhieuNhap;
    private javax.swing.JPanel pnTimSPNhap;
    private javax.swing.JScrollPane spDanhSachPhieuNhap;
    private javax.swing.JScrollPane spDanhSachSpTrongGioHang;
    private javax.swing.JTable tbChonPBSP;
    private javax.swing.JTable tbDanhSachPheiNhap;
    private javax.swing.JTable tbDanhSachSpTrongGioHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChiCuaHang;
    private javax.swing.JTextField txtDienThoaiCuaHang;
    private javax.swing.JTextField txtEmailCUaHang;
    private javax.swing.JTextField txtEmailNhaCungCap;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtTimKiemSanPhamNhap;
    private javax.swing.JTextField txtTinhTrangPhieuNhap;
    private javax.swing.JTextField txtTkPhieuNhap;
    private javax.swing.JTextField txtTongTienSanPham;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtMaPhieuNhap(){return txtMaPhieu;}
    public JTable getTbDanhSachPheiNhap() {return tbDanhSachPheiNhap;}
    public JTable getTbDanhSachSpTrongGioHang(){return  tbDanhSachSpTrongGioHang;}
    public JTextField getTxtNhaCungCap(){return txtNhaCungCap;}
    public JTextField getTxtDiaChi(){return txtDiaChi;}
    public JTextField getTxtEmailNhaCungCap(){return txtEmailNhaCungCap;}
    public JTextField getTxtNgayLapPhieu(){return txtNgayLap;}
    public JDateChooser getjDateChooserNgayHenGiao(){return jDateChooserNgayHenGiao;}
    public JTextField getTxtTongTienSanPham(){return txtTongTienSanPham;}
    public JTextField getTxtTimKiemSanPhamNhap(){return txtTimKiemSanPhamNhap;}
    public JList getListSPNhap(){return listSPNhap;}
    public JList getListNCCNhap(){return listNCCNhap;}
    public JPopupMenu getMenuSPNhap(){return menuSPNhap;}
    public JPopupMenu getMenuNCCNhap(){return menuNCCNhap;}
    public JButton getBtnThemPhieuNhap(){return btnThemPhieuNhap;}
    public JButton getBtnSuaPhieuNhap(){return btnSuaPhieuNhap;}
    public JButton getBtnXuatFile(){return btnXuatFile;}
    public JComboBox getCbTkNhaCungCap(){return cbTkNhaCungCap;}
    public JComboBox getCbTkTinhTrang(){return cbTkTinhTrang;}
    public JDateChooser getjDateChooserTkNgayLapPhieu(){return jDateChooserTkNgayLapPhieu;}
    public JDateChooser getjDateChooserTkNgayHenGiao(){return jDateChooserTkNgayHenGiao;}
    public JTextField getTxtTkPhieuNhap(){return txtTkPhieuNhap;}
    public JTextField getTxtDiaChiCuaHang(){return txtDiaChiCuaHang;}
    public JTextField getTxtDienThoaiCuaHang(){return txtDienThoaiCuaHang;}
    public JTextField getTxtEmailCUaHang(){return txtEmailCUaHang;}
    public JTextField getTxtTinhTrangPhieuNhap(){return txtTinhTrangPhieuNhap;}
    public JTextField getTxtGhiChu(){return txtGhiChu;}
    public JFrame getFmPBSP(){return fmPBSP;}

}
