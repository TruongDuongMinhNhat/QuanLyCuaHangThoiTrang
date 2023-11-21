package dev.skyherobrine.app.controllers.dashboardui.mainDashboard;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;
import dev.skyherobrine.app.views.dashboard.component.LapHoaDon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LapHoaDonController implements KeyListener, Runnable, ThreadFactory {
    private LapHoaDon lapHoaDon;
    private DefaultListModel<String> listModel;
    private ChiTietPhienBanSanPhamDAO chiTietPhienBanSanPhamDAO;
    private WebcamPanel pnCam = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private static int count = 0;
    public LapHoaDonController(LapHoaDon lapHoaDon) {
        this.lapHoaDon = lapHoaDon;
        listModel = new DefaultListModel<>();
        lapHoaDon.getListProduct().setModel(listModel);
        try {
            this.chiTietPhienBanSanPhamDAO = new ChiTietPhienBanSanPhamDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(count == 0){
            setCamera();
            count++;
        }
    }
    public void setCamera(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        pnCam = new WebcamPanel(webcam);
        pnCam.setPreferredSize(size);
        pnCam.setFPSDisplayed(true);
//        pnCam.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5) );
        pnCam.setSize(new Dimension(463,350));
        pnCam.setLocation(30, 60);

//        lapHoaDon.getPnCamera().add(avb);
        lapHoaDon.getPnCamera().add(pnCam);
        executor.execute(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        String text = lapHoaDon.getTxtTimKiemSanPham().getText().trim();
       if(e.getSource().equals(lapHoaDon.getTxtTimKiemSanPham())){
           listModel.removeAllElements();
           Map<String, Object> conditions = new HashMap<>();
           conditions.put("MaPhienBanSP", text);
           try {
               List<Map<String, Object>> listCTPBSP = chiTietPhienBanSanPhamDAO.timKiem(conditions, false, "MaPhienBanSP");
               System.out.println(listCTPBSP.size());
               if(listCTPBSP.size() == 0){
                   lapHoaDon.getMenuProduct().setVisible(false);
               }else{
                   for (int i = 0; i < listCTPBSP.size(); i++){
                       listModel.addElement(listCTPBSP.get(i).get("MaPhienBanSP").toString());
                   }
                   lapHoaDon.getMenuProduct().show(lapHoaDon.getTxtTimKiemSanPham(), 0, lapHoaDon.getTxtTimKiemSanPham().getHeight());
               }
           } catch (Exception ex) {
               throw new RuntimeException(ex);
           }
       }
    }

    @Override
    public void run() {
        do{
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Result result = null;
            BufferedImage image = null;

            if(webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }

            }
            LuminanceSource source = null;
            source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try{
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //e.printStackTrace();
            }

            if(result!=null){
                System.out.println(result);
            }
        }while(true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
