package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.person.NhaCungCapDAO;
import dev.skyherobrine.app.entities.order.PhieuNhapHang;
import dev.skyherobrine.app.entities.order.PhieuTraKhachHang;
import dev.skyherobrine.app.enums.TinhTrangNhapHang;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

public class PhieuTraKhachHangDAO implements IDAO<PhieuTraKhachHang> {
    private ConnectDB connectDB;
    public PhieuTraKhachHangDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(PhieuTraKhachHang phieuTraKhachHang) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert PhieuTraKhachHang values(?, ?, ?)");
        preparedStatement.setString(1, phieuTraKhachHang.getMaPhieuTraKhachHang());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(phieuTraKhachHang.getNgayLap()));
        preparedStatement.setString(3, phieuTraKhachHang.getHoaDon().getMaHD());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(PhieuTraKhachHang target) throws Exception {
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
    public List<PhieuTraKhachHang> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from PhieuTraKhachHang");
        List<PhieuTraKhachHang> phieuTraKhachHangs = new ArrayList<>();
        while(resultSet.next()) {
            PhieuTraKhachHang phieuTraKhachHang = new PhieuTraKhachHang(
                    resultSet.getString("MaPhieuTraKH"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get()
            );

            phieuTraKhachHangs.add(phieuTraKhachHang);
        }
        return phieuTraKhachHangs;
    }

    @Override
    public List<PhieuTraKhachHang> timKiem(Map<String, Object> conditions) throws Exception {
        return null;
    }

    @Override
    public Optional<PhieuTraKhachHang> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from PhieuTraKhachHang where MaPhieuTraKH = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            return Optional.of(new PhieuTraKhachHang(
                    resultSet.getString("MaPhieuTraKH"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get()
            ));
        }
        return Optional.empty();
    }

    @Override
    public List<PhieuTraKhachHang> timKiem(String... ids) throws Exception {
        String query = "select * from PhieuTraKhachHang where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("MaPhieuTraKH = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<PhieuTraKhachHang> phieuTraKhachHangs = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            PhieuTraKhachHang phieuTraKhachHang = new PhieuTraKhachHang(
                    resultSet.getString("MaPhieuTraKH"),
                    resultSet.getTimestamp("NgayLap").toLocalDateTime(),
                    new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get()
            );

            phieuTraKhachHangs.add(phieuTraKhachHang);
        }
        return phieuTraKhachHangs;
    }
}
