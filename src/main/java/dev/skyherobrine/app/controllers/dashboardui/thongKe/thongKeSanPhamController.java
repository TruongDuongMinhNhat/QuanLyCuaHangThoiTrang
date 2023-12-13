package dev.skyherobrine.app.controllers.dashboardui.thongKe;

import dev.skyherobrine.app.daos.order.ChiTietHoaDonDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;
import dev.skyherobrine.app.views.dashboard.component.FormBaoCaoSanPhamCuaHang;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class thongKeSanPhamController {
    private FormBaoCaoSanPhamCuaHang formBaoCaoSanPhamCuaHang;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    public thongKeSanPhamController(FormBaoCaoSanPhamCuaHang formBaoCaoSanPhamCuaHang){
        this.formBaoCaoSanPhamCuaHang = formBaoCaoSanPhamCuaHang;
        try {
            this.chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            loadData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void loadData(){
        PieDataset dataSet = createDataSet();
        JFreeChart chart = createChart(dataSet);
        ChartPanel chartPanel = new ChartPanel(chart);
        formBaoCaoSanPhamCuaHang.getPnBieuDoTHongKeSanPham().removeAll();
        formBaoCaoSanPhamCuaHang.getPnBieuDoTHongKeSanPham().setLayout(new java.awt.BorderLayout());
        formBaoCaoSanPhamCuaHang.getPnBieuDoTHongKeSanPham().add(chartPanel);
    }
    private PieDataset createDataSet() {

        String cols = "TOP 10 MaPhienBanSP, sum(soLuongMua) as soLuongBan";
        String join = "cthd inner join HoaDon hd on cthd.MaHD = hd.MaHD";
        String query = " NgayLap >= DATEADD(DAY, -1, GETDATE()) GROUP BY MaPhienBanSP ORDER BY soLuongBan DESC";
        DefaultPieDataset dataset = new DefaultPieDataset();

        try {
            List<Map<String, Integer>> result = chiTietHoaDonDAO.timKiem(cols, join, query);
            for (Map<String, Integer> map : result) {
                for(Map.Entry<String, Integer> entry : map.entrySet()){
                    dataset.setValue(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dataset;
    }
    private JFreeChart createChart(PieDataset dataset) {
        return ChartFactory.createPieChart("Biểu đồ biểu hiện top 10 sản phẩm bán chạy", dataset, true, true, false);
    }
}