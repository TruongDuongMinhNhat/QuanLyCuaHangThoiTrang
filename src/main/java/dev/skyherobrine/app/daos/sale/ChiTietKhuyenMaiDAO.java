package dev.skyherobrine.app.daos.sale;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.daos.order.HoaDonDAO;
import dev.skyherobrine.app.daos.product.SanPhamDAO;
import dev.skyherobrine.app.entities.product.DanhMucSanPham;
import dev.skyherobrine.app.entities.sale.ChiTietKhuyenMai;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ChiTietKhuyenMaiDAO implements IDAO<ChiTietKhuyenMai> {
    private ConnectDB connectDB;
    public ChiTietKhuyenMaiDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(ChiTietKhuyenMai chiTietKhuyenMai) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert ChiTietKhuyenMai values(?, ?, ?)");
        preparedStatement.setString(1, chiTietKhuyenMai.gethoaDon().getMaHD());
        preparedStatement.setString(2, chiTietKhuyenMai.getKhuyenMai().getMaKM());
        preparedStatement.setFloat(3, chiTietKhuyenMai.getTiLe());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(ChiTietKhuyenMai target) throws Exception {
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
    public List<ChiTietKhuyenMai> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery("select * from ChiTietKhuyenMai");
        List<ChiTietKhuyenMai> chiTietKhuyenMais = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(
                    new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                    new KhuyenMaiDAO().timKiem(resultSet.getString("MaKM")).get(),
                    resultSet.getFloat("TiLe"));

            chiTietKhuyenMais.add(chiTietKhuyenMai);
        }
        return chiTietKhuyenMais;
    }

    @Override
    public List<ChiTietKhuyenMai> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from ChiTietKhuyenMai t where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("t." + column + " like '%" + value + "%'"));
            isNeedAnd.set(true);
        });

        List<ChiTietKhuyenMai> chiTietKhuyenMais = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(
                    new HoaDonDAO().timKiem(result.getString("MaHD")).get(),
                    new KhuyenMaiDAO().timKiem(result.getString("MaKM")).get(),
                    result.getFloat("TiLe")
            );
            chiTietKhuyenMais.add(chiTietKhuyenMai);
        }
        return chiTietKhuyenMais;
    }

    @Override
    @Deprecated
    public Optional<ChiTietKhuyenMai> timKiem(String id) throws Exception {
        throw new Exception("Phương thức này không thể áp dụng cho class này");
    }

    @Override
    public List<ChiTietKhuyenMai> timKiem(String... ids) throws Exception {
        return null;
    }

    public Optional<ChiTietKhuyenMai> timKiem(String maKM, String maSP) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement("select * from ChiTietKhuyenMai where MaKM = ? and MaSP = ?");
        preparedStatement.setString(1, maKM);
        preparedStatement.setString(2, maSP);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new ChiTietKhuyenMai(new HoaDonDAO().timKiem(resultSet.getString("MaHD")).get(),
                    new KhuyenMaiDAO().timKiem(resultSet.getString("MaKM")).get(), resultSet.getFloat("TiLe")));
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

        query.set(query.get() + " from ChiTietKhuyenMai where ");

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
