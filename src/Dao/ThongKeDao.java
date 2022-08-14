/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TienIch.jdbcHelper;

/**
 *
 * @author User
 */
public class ThongKeDao {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getLuongPetsKham() {
        String sql = "{CALL sp_LuongpetsKham}";
        String[] cols = {"Nam", "SoLuong", "DauTien", "CuoiCung"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getTK_NhanVien() {
        String sql = "{CALL SP_TKNhanVien}";
        String[] cols = {"MaNV", "TenNV", "tuoi", "Gioitinh", "Email", "Luong"};
        return this.getListOfArray(sql, cols);
    }

      public List<Object[]> getDoanhThu(int nam){
        String sql="{CALL sp_ThongKeDoanhThu(?)}";
        String[] col ={"Toathuoc","soNV","SolUOngPhieuKham","DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListOfArray(sql, col, nam);
    }
}
