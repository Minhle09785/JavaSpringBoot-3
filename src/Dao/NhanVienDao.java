/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Class_entity.NhanVien;
import Class_entity.ThuCung;
import TienIch.jdbcHelper;

/**
 *
 * @author User
 */
public class NhanVienDao extends EduSysDAO<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO NhanVien (MaNV,TenNV,Dienthoai,Diachi,Email,Gioitinh,Ngaysinh, MatKhau, VaiTro, Luong, Hinh, Ghichu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NhanVien SET TenNV=?, Dienthoai=?, Diachi=?, Email=?, Gioitinh=?,Ngaysinh=?, Matkhau=?, VaiTro=?, Luong=?, Hinh=?, GhiChu=? WHERE MaNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNV(), entity.getHoTen(), entity.getSDT(),entity.getDiaChi(),
                entity.getEmail(),entity.getGioiTinh(),entity.getNgaySinh(),entity.getMatKhau(), entity.getVaiTro(),entity.getLuong(),entity.getHinh(),entity.getGhiChu());
    }

    @Override
    public void update(NhanVien entity) {
        jdbcHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getSDT(), entity.getDiaChi(), entity.getEmail(), entity.getGioiTinh(),
                entity.getNgaySinh(), entity.getMatKhau(), entity.getVaiTro(),entity.getLuong(),entity.getHinh(),entity.getGhiChu(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien>list=this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
       

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("TenNV"));
                entity.setSDT(rs.getString("Dienthoai"));
                entity.setDiaChi(rs.getString("Diachi"));
                entity.setEmail(rs.getString("Email"));
                entity.setGioiTinh(rs.getBoolean("Gioitinh"));
                entity.setNgaySinh(rs.getDate("Ngaysinh"));
                entity.setMatKhau(rs.getString("Matkhau"));
                entity.setVaiTro(rs.getBoolean("Vaitro"));
                entity.setLuong(rs.getDouble("Luong"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setGhiChu(rs.getString("Ghichu"));
             
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public List<NhanVien> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
        public void update1(NhanVien model){
        String sql="UPDATE NhanVien SET Matkhau=? WHERE MaNV=?";
        jdbcHelper.update(sql, 
                model.getMatKhau(), 
                
                model.getMaNV());
    }

}
