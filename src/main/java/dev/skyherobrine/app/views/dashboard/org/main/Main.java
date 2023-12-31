/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dev.skyherobrine.app.views.dashboard.org.main;


import dev.skyherobrine.app.views.dashboard.component.*;
import dev.skyherobrine.app.views.dashboard.libDashBoard.scroll.win11.ScrollPaneWin11;
import dev.skyherobrine.app.views.dashboard.org.menu.Menu;
import dev.skyherobrine.app.views.dashboard.org.menu.MenuEvent;


import javax.swing.*;

/**
 * @author Virtue Nguyen
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();







        TrangChu t = new TrangChu();
        pnBody.add(t);
        menuDashBoard.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {


                long startTime = System.currentTimeMillis();



                if (index == 0) {//trang chủ
                    showForm(t);
                    System.out.println("Form : " + index + " " + subIndex);
                } else if(index ==1){// thông tin cá nhân
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.out.println("Form : " + index + " " + subIndex);
                } else if (index==2 && subIndex==1) {//Lập hoá đơn
                    showForm(new LapHoaDon());
                    System.out.println("Form : " + index + " " + subIndex);
                } else if (index==2 && subIndex==2) {//Quản lý hoá đơn
                    showForm(new QuanLyHoaDon());
                    System.out.println("Form : " + index + " " + subIndex);
                } else if (index==3 && subIndex==1) {// quản lý sản phẩm
                    showForm(new QuanLySanPham());
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==3 && subIndex==2) {//Quản lý Nhập hàng
                    showForm(new QuanLyNhapHang());
                    System.out.println("Form : " + index + " " + subIndex);
                }
                else if (index==3 && subIndex==3) {//Quản lý trả hành nhà cung cấp
                    showForm(new QuanLyPhieuTraHangChoNhaCungCap());
                    System.out.println("Form : " + index + " " + subIndex);
                }
                else if (index==3 && subIndex==4) {//quản lý trả hàng của khách hàng
                    showForm(new QuanLyPhieuTraHangChoKhachHang());
                    System.out.println("Form : " + index + " " + subIndex);
                }
                else if (index==3 && subIndex==5) {// xoá
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.out.println("Form : " + index + " " + subIndex);
                }
                else if (index==3 && subIndex==6) {// xoá
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.out.println("Form : " + index + " " + subIndex);
                } else if (index==4 ) {//khuyến mãi
                    showForm(new KhuyenMai());
                    System.out.println("Form : " + index + " " + subIndex);
                }
                else if (index==5 ) {//nhà cung cấp
                    showForm(new FrmNhaCungCap());
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==6 ) {//khách hàng
                    showForm(new FrmKhachHang());
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==7) {//nhân viên
                    showForm(new FrmNhanVien());
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==8 ) {// báo cáo cửa hàng
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==9 ) {// trợ giúp
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.out.println("Form : " + index + " " + subIndex);
                }else if (index==10 ) {// đăng xuất
                    showForm(new DefaultForm("Form : " + index + " " + subIndex));
                    System.exit(0);
                    System.out.println("Form : " + index + " " + subIndex);
                }

                // tính toán thời gian load
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;
                System.out.println("Thời gian load cho Form " + index + " " + subIndex + ": " + executionTime + "ms");


            }
        });
    }

    private void showForm(JComponent component) {
        pnBody.removeAll();
        pnBody.add(component);
        pnBody.repaint();
        pnBody.revalidate();
    }



    /**
     * This method is called from within t6he constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBackGroungDashBoard = new javax.swing.JPanel();
        pnLogoNMenu = new javax.swing.JPanel();
        header1 = new Header();
        scrollPaneWin112 = new ScrollPaneWin11();
        menuDashBoard = new Menu();
        pnBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("dashboard"); // NOI18N
        setUndecorated(true);

        pnBackGroungDashBoard.setBackground(new java.awt.Color(255, 255, 255));
        pnBackGroungDashBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnBackGroungDashBoard.setAlignmentX(0.0F);
        pnBackGroungDashBoard.setAlignmentY(0.0F);
        pnBackGroungDashBoard.setPreferredSize(new java.awt.Dimension(1920, 1000));

        pnLogoNMenu.setPreferredSize(new java.awt.Dimension(1920, 1022));

        scrollPaneWin112.setBorder(null);
        scrollPaneWin112.setViewportView(menuDashBoard);

        javax.swing.GroupLayout pnLogoNMenuLayout = new javax.swing.GroupLayout(pnLogoNMenu);
        pnLogoNMenu.setLayout(pnLogoNMenuLayout);
        pnLogoNMenuLayout.setHorizontalGroup(
            pnLogoNMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPaneWin112, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnLogoNMenuLayout.setVerticalGroup(
            pnLogoNMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogoNMenuLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pnBody.setPreferredSize(new java.awt.Dimension(1651, 1000));
        pnBody.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnBackGroungDashBoardLayout = new javax.swing.GroupLayout(pnBackGroungDashBoard);
        pnBackGroungDashBoard.setLayout(pnBackGroungDashBoardLayout);
        pnBackGroungDashBoardLayout.setHorizontalGroup(
            pnBackGroungDashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBackGroungDashBoardLayout.createSequentialGroup()
                .addComponent(pnLogoNMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnBody, javax.swing.GroupLayout.PREFERRED_SIZE, 1686, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnBackGroungDashBoardLayout.setVerticalGroup(
            pnBackGroungDashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLogoNMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
            .addGroup(pnBackGroungDashBoardLayout.createSequentialGroup()
                .addComponent(pnBody, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBackGroungDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBackGroungDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Header header1;
    private Menu menuDashBoard;
    private javax.swing.JPanel pnBackGroungDashBoard;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnLogoNMenu;
    private ScrollPaneWin11 scrollPaneWin112;
    // End of variables declaration//GEN-END:variables
}
