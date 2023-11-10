package dev.skyherobrine.app.daos.person;

import dev.skyherobrine.app.daos.ConnectDB;
import dev.skyherobrine.app.daos.IDAO;
import dev.skyherobrine.app.entities.person.NhanVien;
import dev.skyherobrine.app.enums.CaLamViec;
import dev.skyherobrine.app.enums.ChucVu;
import dev.skyherobrine.app.enums.TinhTrangNhanVien;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class NhanVienDAO implements IDAO<NhanVien> {
    private ConnectDB connectDB;
    public NhanVienDAO() throws Exception{
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(NhanVien nhanVien) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Insert NhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, nhanVien.getMaNV());
        preparedStatement.setString(2, nhanVien.getHoTen());
        preparedStatement.setString(3, nhanVien.getSoDienThoai());
        preparedStatement.setBoolean(4, nhanVien.isGioiTinh());
        preparedStatement.setDate(5, Date.valueOf(nhanVien.getNgaySinh()));
        preparedStatement.setString(6, nhanVien.getEmail());
        preparedStatement.setString(7, nhanVien.getDiaChi());
        preparedStatement.setString(8, nhanVien.getChucVu().toString());
        preparedStatement.setString(9, nhanVien.getCaLamViec().toString());
        preparedStatement.setString(10, nhanVien.getTenTaiKhoan());
        preparedStatement.setString(11, nhanVien.getMatKhau());
        preparedStatement.setString(12, nhanVien.getTinhTrang().toString());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean capNhat(NhanVien target) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("Update NhanVien set HoTen = ?, SoDienThoai = ?, GioiTinh = ?, NgaySinh = ?, Email = ?," +
                        "DiaChi = ?, ChucVu = ?, CaLamViec = ?, TenTaiKhoan = ?, MatKhau = ?, TinhTrang = ? where MaNV = ?");
        preparedStatement.setString(1, target.getHoTen());
        preparedStatement.setString(2, target.getSoDienThoai());
        preparedStatement.setBoolean(3, target.isGioiTinh());
        preparedStatement.setDate(4, Date.valueOf(target.getNgaySinh()));
        preparedStatement.setString(5, target.getEmail());
        preparedStatement.setString(6, target.getDiaChi());
        preparedStatement.setString(7, target.getChucVu().toString());
        preparedStatement.setString(8, target.getCaLamViec().toString());
        preparedStatement.setString(9, target.getTenTaiKhoan());
        preparedStatement.setString(10, target.getMatKhau());
        preparedStatement.setString(11, target.getTinhTrang().toString());
        preparedStatement.setString(12, target.getMaNV());

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
    public List<NhanVien> timKiem() throws Exception {
        ResultSet resultSet = connectDB.getConnection().createStatement().executeQuery
                ("select * from NhanVien");
        List<NhanVien> nhanViens = new ArrayList<>();
        while(resultSet.next()) {
            NhanVien nhanVien = new NhanVien(resultSet.getString("MaNV"),
                    resultSet.getString("HoTen"),
                    resultSet.getString("SoDienThoai"),
                    resultSet.getBoolean("GioiTinh"),
                    resultSet.getDate("NgaySinh").toLocalDate(),
                    resultSet.getString("Email"),
                    resultSet.getString("DiaChi"),
                    ChucVu.layGiaTri(resultSet.getString("ChucVu")),
                    CaLamViec.layGiaTri(resultSet.getString("CaLamViec")),
                    resultSet.getString("TenTaiKhoan"),
                    resultSet.getString("MatKhau"),
                    TinhTrangNhanVien.layGiaTri(resultSet.getString("TinhTrang")));
            nhanViens.add(nhanVien);
        }
        return nhanViens;
    }

    @Override
    public List<NhanVien> timKiem(Map<String, Object> conditions) throws Exception {
        AtomicReference<String> query = new AtomicReference<>
                ("select * from NhanVien nv where ");
        AtomicBoolean isNeedAnd = new AtomicBoolean(false);

        conditions.forEach((column, value) -> {
            query.set(query.get() + (isNeedAnd.get() ? " and " : "") + ("nv." + column + " = '" + value + "'"));
            isNeedAnd.set(true);
        });

        List<NhanVien> nhanViens = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query.get());
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            NhanVien nhanVien = new NhanVien(
                    result.getString("MaNV"),
                    result.getString("HoTen"),
                    result.getString("SoDienThoai"),
                    result.getBoolean("GioiTinh"),
                    result.getDate("NgaySinh").toLocalDate(),
                    result.getString("Email"),
                    result.getString("DiaChi"),
                    ChucVu.layGiaTri(result.getString("ChucVu")),
                    CaLamViec.layGiaTri(result.getString("CaLamViec")),
                    result.getString("TenTaiKhoan"),
                    result.getString("MatKhau"),
                    TinhTrangNhanVien.layGiaTri(result.getString("TinhTrang")));
            nhanViens.add(nhanVien);
        }
        return nhanViens;
    }

    @Override
    public Optional<NhanVien> timKiem(String id) throws Exception {
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement
                ("select * from NhanVien nv where nv.MaNV = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new NhanVien(resultSet.getString("MaNV"),
                    resultSet.getString("HoTen"),
                    resultSet.getString("SoDienThoai"),
                    resultSet.getBoolean("GioiTinh"),
                    resultSet.getDate("NgaySinh").toLocalDate(),
                    resultSet.getString("Email"),
                    resultSet.getString("DiaChi"),
                    ChucVu.layGiaTri(resultSet.getString("ChucVu")),
                    CaLamViec.layGiaTri(resultSet.getString("CaLamViec")),
                    resultSet.getString("TenTaiKhoan"),
                    resultSet.getString("MatKhau"),
                    TinhTrangNhanVien.layGiaTri(resultSet.getString("TinhTrang"))));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<NhanVien> timkiem(String... ids) throws Exception {
        String query = "select * from NhanVien nv where ";
        String[] listID = (String[]) Arrays.stream(ids).toArray();
        for(int i = 0; i < listID.length; ++i) {
            query += ("nv.MaNV = '" + listID[i] + "'");
            if((i + 1) >= listID.length) break;
            else query += ", ";
        }

        List<NhanVien> nhanViens = new ArrayList<>();
        PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            NhanVien nhanVien = new NhanVien(resultSet.getString("MaNV"),
                    resultSet.getString("HoTen"),
                    resultSet.getString("SoDienThoai"),
                    resultSet.getBoolean("GioiTinh"),
                    resultSet.getDate("NgaySinh").toLocalDate(),
                    resultSet.getString("Email"),
                    resultSet.getString("DiaChi"),
                    ChucVu.layGiaTri(resultSet.getString("ChucVu")),
                    CaLamViec.layGiaTri(resultSet.getInt("CaLamViec")),
                    resultSet.getString("TenTaiKhoan"),
                    resultSet.getString("MatKhau"),
                    TinhTrangNhanVien.layGiaTri(resultSet.getString("TinhTrang")));
            nhanViens.add(nhanVien);
        }
        return nhanViens;
    }
}
