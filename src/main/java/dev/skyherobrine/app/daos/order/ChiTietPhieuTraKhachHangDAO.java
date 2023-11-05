package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuTraKhachHang;
import dev.skyherobrine.app.entities.order.PhieuTraKhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietPhieuTraKhachHangDAO implements IDAO<ChiTietPhieuTraKhachHang> {
    private ConnectDB connectDB;
    public ChiTietPhieuTraKhachHangDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietPhieuTraKhachHang chiTietPhieuTraKhachHang) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietPhieuTraKhachHang values(?, ?, ?, ?)");
        preparedStatement.setString(1, chiTietPhieuTraKhachHang.getPhieuTra().getMaPhieuTraKhachHang());
        preparedStatement.setString(2, chiTietPhieuTraKhachHang.getSanPham().getMaSP());
        preparedStatement.setInt(3, chiTietPhieuTraKhachHang.getSoLuongTra());
        preparedStatement.setString(4, chiTietPhieuTraKhachHang.getNoiDungTra());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietPhieuTraKhachHang target) throws Exception {
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
    public List<ChiTietPhieuTraKhachHang> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietPhieuTraKhachHang");
        List<ChiTietPhieuTraKhachHang> chiTietPhieuTraKhachHangs = new ArrayList<>();
        while(resultSet.next()) {
            ChiTietPhieuTraKhachHang chiTietPhieuTraKhachHang = new ChiTietPhieuTraKhachHang(
                    new PhieuTraKhachHangDAO().timKiem(resultSet.getString("MaPhieuTraKH")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuongTra"),
                    resultSet.getString("NoiDungTra")
            );

            chiTietPhieuTraKhachHangs.add(chiTietPhieuTraKhachHang);
        }
        return chiTietPhieuTraKhachHangs;
    }

    @Override
    public List<ChiTietPhieuTraKhachHang> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<ChiTietPhieuTraKhachHang> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietPhieuTraKhachHang where MaPhieuTraKH = ?");
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietPhieuTraKhachHang(
                    new PhieuTraKhachHangDAO().timKiem(resultSet.getString("MaPhieuTraKH")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuongTra"),
                    resultSet.getString("NoiDungTra")
            ));
        }
        return Optional.empty();
    }

    @Override
    public List<ChiTietPhieuTraKhachHang> timkiem(String... ids) throws Exception {
        return null;
    }
}
