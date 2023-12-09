package dev.skyherobrine.app.daos.order;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.product.ChiTietPhienBanSanPhamDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHang;
import dev.skyherobrine.app.entities.order.ChiTietPhieuNhapHangPhienBanSP;
import dev.skyherobrine.app.entities.product.ChiTietPhienBanSanPham;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ChiTietPhieuNhapHangPhienBanSPDAO implements IDAO<ChiTietPhieuNhapHangPhienBanSP> {
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
        List<ChiTietPhieuNhapHangPhienBanSP> result = new ArrayList<>();
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietPhieuNhapHangPhienBanSP");
        while(resultSet.next()) {
            ChiTietPhieuNhapHangPhienBanSP chiTietPhieuNhapHangPhienBanSP = new ChiTietPhieuNhapHangPhienBanSP
                    (new ChiTietPhieuNhapHangDAO().timKiem(resultSet.getString("MaChiTietPhieuNhap")).get(),
                     new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                     resultSet.getInt("SoLuongNhap"));
            result.add(chiTietPhieuNhapHangPhienBanSP);
        }
        return result;
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

        query.set(query.get() + " from ChiTietPhieuNhapHangPhienBanSP where ");

        conditions.forEach((column, value) -> {
            query.set(query.get() + (canAnd.get() ? " AND " : "") + column + " like '%" + value + "%'");
            canAnd.set(true);
        });

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

    @Override
    public List<ChiTietPhieuNhapHangPhienBanSP> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from ChiTietPhieuNhapHangPhienBanSP ctpn where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);
        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("ctpn." + column + "= '" + value +"'"));
            isNeedAnd.set(true);
        });
        List<ChiTietPhieuNhapHangPhienBanSP> result = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            ChiTietPhieuNhapHangPhienBanSP chiTietPhieuNhapHangPhienBanSP = new ChiTietPhieuNhapHangPhienBanSP
                    (new ChiTietPhieuNhapHangDAO().timKiem(resultSet.getString("MaChiTietPhieuNhap")).get(),
                            new ChiTietPhienBanSanPhamDAO().timKiem(resultSet.getString("MaPhienBanSP")).get(),
                            resultSet.getInt("SoLuongNhap"));
            result.add(chiTietPhieuNhapHangPhienBanSP);
        }
        return result;
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
