package dev.skyherobrine.app.daos.person;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.person.KhachHang;
import dev.skyherobrine.app.entities.person.NhaCungCap;
import dev.skyherobrine.app.enums.TinhTrangNhaCungCap;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class KhachHangDAO implements IDAO<KhachHang> {
    private ConnectDB connectDB;

    public KhachHangDAO() throws Exception {
        connectDB = new ConnectDB();
    }

    @Override
    public boolean them(KhachHang khachHang) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("insert KhachHang values(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, khachHang.getMaKH());
        preparedStatement.setString(2, khachHang.getHoTen());
        preparedStatement.setString(3, khachHang.getSoDienThoai());
        preparedStatement.setDate(4, Date.valueOf(khachHang.getNgaySinh()));
        preparedStatement.setFloat(5, khachHang.getDiemTichLuy());

        int result = preparedStatement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean capNhat(KhachHang target) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update KhachHang KH set KH.HoTen = ?," +
                        "KH.SoDienThoai = ?, KH.GioiTinh = ?, KH.NgaySinh = ?," +
                        "KH.DiemTichLuy = ? where KH.MaKH = ?");
        preparedStatement.setString(1, target.getHoTen());
        preparedStatement.setString(2, target.getSoDienThoai());
        preparedStatement.setBoolean(3, target.isGioiTinh());
        preparedStatement.setDate(4, Date.valueOf(target.getNgaySinh()));
        preparedStatement.setFloat(5, target.getDiemTichLuy());
        preparedStatement.setString(6, target.getMaKH());

        return preparedStatement.executeUpdate() > 0;
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
    public List<KhachHang> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from KhachHang");
        List<KhachHang> khachHangs = new ArrayList<>();
        while (resultSet.next()) {
            KhachHang khachHang = new KhachHang
                    (resultSet.getString("MaKH"), resultSet.getString("HoTen"), resultSet.getString("SoDienThoai"),
                            resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh").toLocalDate(),
                            resultSet.getFloat("DiemTichLuy"));
            khachHangs.add(khachHang);
        }
        return khachHangs;
    }

    @Override
    public List<KhachHang> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from KhachHang t where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("t." + column + " like '%" + value + "%'"));
            isNeedAnd.set(true);
        });

        List<KhachHang> khachHangs = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            KhachHang khachHang = new KhachHang(
                    result.getString("MaKH"),
                    result.getString("HoTen"),
                    result.getString("SoDienThoai"),
                    result.getBoolean("GioiTinh"),
                    result.getDate("NgaySinh").toLocalDate(),
                    result.getFloat("DiemTichLuy"));
            khachHangs.add(khachHang);
        }
        return khachHangs;
    }

    @Override
    public Optional<KhachHang> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from KhachHang KH where KH.MaKH = ?");
        preparedStatement.setString(1, id);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            return Optional.of(new KhachHang(result.getString("MaKH"),
                    result.getString("HoTen"), result.getString("SoDienThoai"),
                    result.getBoolean("GioiTinh"), result.getDate("NgaySinh").toLocalDate(), result.getFloat("DiemTichLuy")));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<KhachHang> timKiem(String... ids) throws Exception {
        String query = "select * from KhachHang KH where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for (int i = 0; i < listID.length; ++i) {
            query += ("KH.MaKH like '%" + listID[i] + "%'");
            if ((i + 1) >= listID.length) {
                break;
            } else {
                query += ", ";
            }
        }
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        List<KhachHang> khachHangs = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            KhachHang khachHang = new KhachHang(resultSet.getString("MaKH"), resultSet.getString("HoTen"),
                    resultSet.getString("SoDienThoai"), resultSet.getBoolean("GioiTinh"), resultSet.getDate("NgaySinh").toLocalDate(),
                    resultSet.getFloat("DiemTichLuy"));
            khachHangs.add(khachHang);
        }
        return khachHangs;
    }
}
