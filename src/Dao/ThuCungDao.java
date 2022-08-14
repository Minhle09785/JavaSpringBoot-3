/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Class_entity.ThuCung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TienIch.jdbcHelper;

/**
 *
 * @author User
 */
public class ThuCungDao extends EduSysDAO<ThuCung, String> {

    String INSERT_SQL = "INSERT INTO Thucung (MaTC,TenTC,Gioitinh,Dienthoai,NgaySinh,Hinh, Ghichu ,Benh) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
    String UPDATE_SQL = "UPDATE Thucung SET TenTC=?, Gioitinh=?, Dienthoai=?, NgaySinh=?, Hinh=?,Ghichu=?, Benh=?   WHERE MaTC=?";
    String DELETE_SQL = "DELETE FROM Thucung WHERE MaTC=?";
    String SELECT_ALL_SQL = "SELECT * FROM Thucung";
    String SELECT_BY_ID_SQL = "SELECT * FROM Thucung WHERE MaTC=?";

    @Override
    public void insert(ThuCung entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaTC(), entity.getTenTC(), entity.getGioiTinh(), entity.getSDT(),
                entity.getNgaySinh(), entity.getHinh(), entity.getGhiChu(), entity.getBenh());
    }

    @Override
    public void update(ThuCung entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getTenTC(), entity.getGioiTinh(), entity.getSDT(), entity.getNgaySinh(),
                entity.getHinh(), entity.getGhiChu(), entity.getBenh(), entity.getMaTC());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ThuCung> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ThuCung selectById(String id) {
        List<ThuCung> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThuCung> selectBySql(String sql, Object... args) {
        List<ThuCung> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                ThuCung entity = new ThuCung();
                entity.setMaTC(rs.getString("MaTC"));
                entity.setTenTC(rs.getString("TenTC"));
                entity.setGioiTinh(rs.getBoolean("Gioitinh"));
                entity.setSDT(rs.getString("Dienthoai"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setGhiChu(rs.getString("Ghichu"));
                entity.setBenh(rs.getString("Benh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ThuCung> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM ThuCung WHERE TenTC LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

//    public List<ThuCung> selectNotInCourse(int makh, String keyword) {
//        String sql = "SELECT * FROM ThuCung WHERE HoTen LIKE ? AND "
//                + "MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH = ?)";
//        return selectBySql(sql, "%" + keyword + "%", makh);
//    }

}
