/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Class_entity.Thuoc;
import TienIch.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ThuocDao extends EduSysDAO<Thuoc, Object>{
     String INSERT_SQL = "INSERT INTO Thuoc (Mathuoc,Tenthuoc,Dongia,Soluong,Cachdung,Congdung,Maloai) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE Thuoc SET Tenthuoc=?, Dongia=?, Soluong=?, Cachdung=?, Congdung=?, Maloai=? WHERE Mathuoc=?";
    String DELETE_SQL = "DELETE FROM Thuoc WHERE Mathuoc=?";
    String SELECT_ALL_SQL = "SELECT * FROM Thuoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM Thuoc WHERE Mathuoc=?";
    @Override
    public void insert(Thuoc entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaThuoc(),  entity.getTenThuoc(), entity.getDonGia(),entity.getSoLuong(),
                entity.getCachDung(),entity.getCongDung(),entity.getMaLoai());
    }

    @Override
    public void update(Thuoc entity) {
         jdbcHelper.update(UPDATE_SQL, entity.getTenThuoc(), entity.getDonGia(),entity.getSoLuong(),
                entity.getCachDung(),entity.getCongDung(),entity.getMaLoai(),entity.getMaThuoc());
    }

    @Override
    public void delete(Object id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public Thuoc selectById(Object id) {
         List<Thuoc>list=this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);    }

    @Override
    public List<Thuoc> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<Thuoc> selectBySql(String sql, Object... args) {
      List<Thuoc> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Thuoc entity = new Thuoc();
                entity.setMaThuoc(rs.getString("Mathuoc"));
               entity.setTenThuoc(rs.getString("Tenthuoc"));
               entity.setDonGia(rs.getDouble("Dongia"));
               entity.setSoLuong(rs.getInt("Soluong"));
               entity.setCachDung(rs.getString("Cachdung"));
               entity.setCongDung(rs.getString("Congdung"));
               entity.setMaLoai(rs.getString("Maloai"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }   }

    

    
}
