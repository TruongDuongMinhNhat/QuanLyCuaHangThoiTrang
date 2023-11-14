package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuTraNhaCungCap;
import dev.skyherobrine.app.entities.order.PhieuTraNhaCungCap;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ChiTietPhieuTraNhaCungCapDAO implements IDAO<ChiTietPhieuTraNhaCungCap> {
    private ConnectDB connectDB;
    public ChiTietPhieuTraNhaCungCapDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietPhieuTraNhaCungCap chiTietPhieuTraNhaCungCap) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("insert ChiTietPhieuTraNhaCungCap values(?, ?, ?, ?)");
        preparedStatement.setString(1, chiTietPhieuTraNhaCungCap.getPhieuTra().getMaPhieuTra());
        preparedStatement.setString(2, chiTietPhieuTraNhaCungCap.getSanPham().getMaSP());
        preparedStatement.setInt(3, chiTietPhieuTraNhaCungCap.getSoLuongTra());
        preparedStatement.setString(4, chiTietPhieuTraNhaCungCap.getLiDoTra());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietPhieuTraNhaCungCap target) throws Exception {
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
    public List<ChiTietPhieuTraNhaCungCap> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from ChiTietPhieuTraNhaCungCap");
        List<ChiTietPhieuTraNhaCungCap> chiTietPhieuTraNhaCungCaps = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietPhieuTraNhaCungCap chiTietPhieuTraNhaCungCap = new ChiTietPhieuTraNhaCungCap
                    (new PhieuTraNhaCungCapDAO().timKiem(resultSet.getString("MaPhieuTra")).get(),
                            new SanPhamDAO().timKiem("MaSP").get(),
                            resultSet.getInt("SoLuongTra"),
                            resultSet.getString("LiDoTra"));

            chiTietPhieuTraNhaCungCaps.add(chiTietPhieuTraNhaCungCap);
        }
        return chiTietPhieuTraNhaCungCaps;
    }

    @Override
    public List<ChiTietPhieuTraNhaCungCap> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    @Deprecated
    public Optional<ChiTietPhieuTraNhaCungCap> timKiem(String id) throws Exception {
        throw new Exception("Phương thức này không được sử dụng");
    }

    @Override
    public List<ChiTietPhieuTraNhaCungCap> timkiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietPhieuTraNhaCungCap> timKiem(String maPhieuTra, String maSP) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietPhieuTraNhaCungCap where MaPhieuTra = ? and MaSP = ?");
        preparedStatement.setString(1, maPhieuTra);
        preparedStatement.setString(2, maSP);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietPhieuTraNhaCungCap(new PhieuTraNhaCungCapDAO().timKiem(resultSet.getString("MaPhieuTra")).get(),
                    new SanPhamDAO().timKiem(resultSet.getString("MaSP")).get(),
                    resultSet.getInt("SoLuongTra"),
                    resultSet.getString("LiDoTra")));
        } else {
            return Optional.empty();
        }
    }
}
