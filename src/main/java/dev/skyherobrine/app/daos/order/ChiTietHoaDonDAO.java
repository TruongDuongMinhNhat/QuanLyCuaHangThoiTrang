package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietHoaDon;
import dev.skyherobrine.app.entities.person.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ChiTietHoaDonDAO implements IDAO<ChiTietHoaDon> {
    private ConnectDB connectDB;
    public ChiTietHoaDonDAO() throws Exception {
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietHoaDon chiTietHoaDon) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietHoaDon values(?, ?, ?)");
        preparedStatement.setString(1, chiTietHoaDon.getHoaDon().getMaHD());
        preparedStatement.setString(2, chiTietHoaDon.getChiTietPhienBanSanPham().getMaPhienBanSP());
        preparedStatement.setInt(3, chiTietHoaDon.getSoLuongMua());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietHoaDon target) throws Exception {
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
    public List<ChiTietHoaDon> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from ChiTietHoaDon");
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        while(resultSet.next()) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon
                    (new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                     new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                     resultSet.getInt("SoLuongMua"));

            chiTietHoaDons.add(chiTietHoaDon);
        }
        return chiTietHoaDons;
    }

    @Override
    public List<ChiTietHoaDon> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from ChiTietHoaDon cthd where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("cthd." + column + " like '%" + value + "%'"));
            isNeedAnd.set(true);
        });

        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon
                    (new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                            new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                            resultSet.getInt("SoLuongMua"));

            chiTietHoaDons.add(chiTietHoaDon);
        }
        return chiTietHoaDons;
    }

    @Override
    public Optional<ChiTietHoaDon> timKiem(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<ChiTietHoaDon> timKiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietHoaDon> timKiem(String maHD, String maPhienBanSP) throws Exception{
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from ChiTietHoaDon where MaPhienBanSP = ? and MaHD = ?");
        preparedStatement.setString(1, maPhienBanSP);
        preparedStatement.setString(2, maHD);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietHoaDon(new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                    new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                    resultSet.getInt("SoLuongMua")));
        } else {
            return Optional.empty();
        }
    }
    @Override
    public List<Map<String, Object>> timKiem(Map<String, Object> conditions, boolean isDuplicateResult, String... colNames) throws Exception {
        AtomicReference<String> query = new AtomicReference<>("select " + (isDuplicateResult ? "distinct " : ""));
        AtomicBoolean canPhay = new AtomicBoolean(false);
        AtomicBoolean canAnd = new AtomicBoolean(false);

        Arrays.stream(colNames).forEach(column -> {
            query.set(query.get() + (canPhay.get() ? "," : "") + column);
            canPhay.set(true);
        });

        query.set(query.get() + " from ChiTietHoaDon where ");

        conditions.forEach((column, value) -> {
            query.set(query.get() + (canAnd.get() ? " AND " : "") + column + " like '%" + value + "%'");
            canAnd.set(true);
        });

        System.out.println(query);
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery(query.get());

        List<Map<String, Object>> listResult = new ArrayList<>();
        while(resultSet.next()){
            Map<String, Object> rowDatas = new HashMap<>();
            for(String column : Arrays.stream(colNames).toList()) {
                rowDatas.put(column, resultSet.getString(column));
            }
            listResult.add(rowDatas);
        }
        return listResult;
    }
}
