package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietPhieuNhapHangDAO implements IDAO<ChiTietPhieuNhapHang> {
    private ConnectDB connectDB;
    public ChiTietPhieuNhapHangDAO() throws Exception {
        connectDB = new ConnectDB();
    }

    @Override
    public boolean them(ChiTietPhieuNhapHang chiTietPhieuNhapHang) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietPhieuNhap values(?, ?, ?, ?)");
        preparedStatement.setString(1, chiTietPhieuNhapHang.getPhieuNhapHang().getMaPhieuNhap());
        preparedStatement.setString(2, chiTietPhieuNhapHang.getSanPham().getMaSP());
        preparedStatement.setInt(3, chiTietPhieuNhapHang.getSoLuong());
        preparedStatement.setDouble(4, chiTietPhieuNhapHang.getGiaNhap());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietPhieuNhapHang target) throws Exception {
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
    public List<ChiTietPhieuNhapHang> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietPhieuNhap");
        List<ChiTietPhieuNhapHang> chiTietPhieuNhapHangs = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietPhieuNhapHang chiTietPhieuNhapHang = new ChiTietPhieuNhapHang(
                    new PhieuNhapHangDAO().timKiem(resultSet.getString("MaPhieuNhap")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuong"),
                    resultSet.getDouble("GiaNhap"));

            chiTietPhieuNhapHangs.add(chiTietPhieuNhapHang);
        }
        return chiTietPhieuNhapHangs;
    }

    @Override
    public List<ChiTietPhieuNhapHang> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    @Deprecated
    public Optional<ChiTietPhieuNhapHang> timKiem(String id) throws Exception {
        throw new Exception("Phương thức này không đươợc sử dụng");
    }

    @Override
    public List<ChiTietPhieuNhapHang> timkiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietPhieuNhapHang> timKiem(String maPhieuNhap, String maSP) throws Exception{
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietPhieuNhap where MaPhieuNhap = ? and MaSP = ?");
        preparedStatement.setString(1, maPhieuNhap);
        preparedStatement.setString(2, maSP);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietPhieuNhapHang(new PhieuNhapHangDAO().timKiem(resultSet.getString("MaPhieuNhap")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuong"), resultSet.getDouble("GiaNhap")));
        } else {
            return Optional.empty();
        }
    }
}
