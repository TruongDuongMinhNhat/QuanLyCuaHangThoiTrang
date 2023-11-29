package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHangPhienBanSP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietPhieuNhapHangPhienBanSPDAO implements IDAO<ChiTietPhieuNhapHangPhienBanSP>{
    private ConnectDB connectDB;
    public ChiTietPhieuNhapHangPhienBanSPDAO() throws Exception {
        connectDB = new ConnectDB();
    }

    @Override
    public boolean them(ChiTietPhieuNhapHangPhienBanSP chiTietPhieuNhapHangPhienBanSP) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietPhieuNhapHangPhienBanSP values(?, ?, ?)");
        preparedStatement.setString(1, chiTietPhieuNhapHangPhienBanSP.getChiTietPhieuNhapHang().getMaChiTietPhieuNhap());
        preparedStatement.setString(2, chiTietPhieuNhapHangPhienBanSP.getChiTietPhienBanSanPham().getMaPhienBanSP());
        preparedStatement.setInt(3, chiTietPhieuNhapHangPhienBanSP.getSoLuongNhap());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietPhieuNhapHangPhienBanSP target) throws Exception {
        return false;
    }

    @Override
    public boolean xoa(String id) throws Exception {
        return false;
    }

    @Override
    public int xoa(String... ids) throws Exception {
        return 0;
    }

    @Override
    public List<ChiTietPhieuNhapHangPhienBanSP> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietPhieuNhapHangPhienBanSP");
        List<ChiTietPhieuNhapHangPhienBanSP> chiTietPhieuNhapHangPhienBanSPs = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietPhieuNhapHangPhienBanSP chiTietPhieuNhapHangPhienBanSP = new ChiTietPhieuNhapHangPhienBanSP(
                    new ChiTietPhieuNhapHangDAO().timKiem(resultSet.getString("MaChiTietPhieuNhap")).get(),
                    new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                    resultSet.getInt("SoLuongNhap")
            );
            chiTietPhieuNhapHangPhienBanSPs.add(chiTietPhieuNhapHangPhienBanSP);
        }
        return chiTietPhieuNhapHangPhienBanSPs;
    }

    @Override
    public List<Map<String, Object>> timKiem(Map<String, Object> conditions, boolean isDuplicateResult, String... colNames) throws Exception {
        return null;
    }

    @Override
    public List<ChiTietPhieuNhapHangPhienBanSP> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<ChiTietPhieuNhapHangPhienBanSP> timKiem(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<ChiTietPhieuNhapHangPhienBanSP> timKiem(String... ids) throws Exception {
        return null;
    }
}
