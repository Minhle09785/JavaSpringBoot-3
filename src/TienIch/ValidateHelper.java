/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class ValidateHelper {

    public static Font Plain = new Font("Tahoma", Font.PLAIN, 12);
    public static Font Italic = new Font("Tahoma", Font.ITALIC, 12);
    public static Color Black = new Color(0, 0, 0);
    public static Color Gray = new Color(153, 153, 153);

    /**
    *Kiểm tra tính hợp lệ của mã sản phẩm
    * @param txt là 1 JTextFiled được truyền vào
    * @return true khi mã sản phẩm đúng định đạng và ngược lại
    */
    public static boolean ValidateMaSp(JTextField txt) {
        String id = txt.getText();
        String rgx = "[A-Z]{2,3}\\d+";
        if (!id.matches(rgx)) {
            //Dặt lại con trỏ cho người dùng nhập lại
            txt.requestFocus();
            return false;
        }
        return true;
    }
    //
    /**
    *Kiểm tra tính hợp lệ của mã nhà cung cấp
    * @param txt là 1 JTextFiled được truyền vào
    * @return true khi mã nhà cung cấp đúng định đạng và ngược lại
    */
    public static boolean ValidateNhaCc(JTextField txt) {
        String id = txt.getText();
        String rgx = "[A-Z]{2,3}\\d+";
        if (!id.matches(rgx)) {
            //Dặt lại con trỏ cho người dùng nhập lại
            txt.requestFocus();
            return false;
        }
        return true;
    }

 
    /**
    *Kiểm tra tính hợp lệ của giá sản phẩm
    * @param txt là 1 JTextFiled được truyền vào
    * @return true khi giá sản phẩm đúng định đạng và ngược lại
    */
    public static boolean ValidateGiaSp(JTextField txt) {
        String replace = "";
        try {
            if (txt.getText().trim().contains(",")) {
                replace = txt.getText().replace(",", ".");
            } else {
                replace = txt.getText();
            }
            float giaNhap = (Float.parseFloat(replace));
            if (giaNhap < 0) {
                txt.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            txt.requestFocus();
            return false;
        }
        return true;
    }
    
    /**
    *Kiểm tra tính hợp lệ của lương 
    * @param txt là 1 JTextFiled được truyền vào
    * @return true khi lương đúng định đạng và ngược lại
    */
    public static boolean ValidateLuong(JTextField txt) {
        String replace = "";
        try {
            if (txt.getText().trim().contains(",")) {
                replace = txt.getText().replace(",", ".");
            } else {
                replace = txt.getText();
            }
            float luong = (Float.parseFloat(replace));
            if (luong < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    
    /**
    *Kiểm tra tính hợp lệ của mật khẩu phải (từ 3-25 kí tự)
    * @param txt là 1 JPasswordFiled được truyền vào
    * @return true khi mật khẩu đúng điều kiện và ngược lại
    */
    public static boolean ValidatePass(JPasswordField txt) {
        if (txt.getPassword().length > 2 && txt.getPassword().length < 26 && txt.getForeground().equals(Black)) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
    *Kiểm tra JDateChooser có bị trống hay ko
    * @param date là 1 JDateChooser được truyền vào
    * @return true khi date không trống và ngược lại
    */
    public static boolean ValidateJDateChooser(JDateChooser date) {
        if (date.getDate() != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
    *Kiểm tra JTextField có bị trống hay ko
    * @param txtX là 1 JTextField được truyền vào
    * @return true khi txtX không trống và ngược lại
    */
    public static boolean ValidateNull(JTextField txtX) {
        if (txtX.getForeground().equals(Gray)) {
            return false;
        }
        return true;
    }


    /**
    *Kiểm tra JTextArea có bị trống hay ko
    * @param txtX là 1 JTextArea được truyền vào
    * @return true khi txtX không trống và ngược lại
    */
    public static boolean ValidateNull(JTextArea txtX) {
        if (txtX.getForeground().equals(Gray)) {
            return false;
        }
        return true;
    }
    
    /**
     * Đổi màu chữ trong JTextField
     * @param txtX là 1 JTextField được truyền vào
     * @param a là chuỗi cần được hiển thị
     * @param f là 1 phông chữ
     * @param c là màu chữa
     */
    public static void Color(JTextField txtX, String a, Font f, Color c) {
        txtX.setText(a);
        txtX.setFont(f);
        txtX.setForeground(c);
    }

    /**
     * Đổi màu chữ trong JTextArea
     * @param txtX là 1 JTextArea được truyền vào
     * @param a là chuỗi cần được hiển thị
     * @param f là 1 phông chữ
     * @param c là màu chữa
     */
    public static void Color(JTextArea txtX, String a, Font f, Color c) {
        txtX.setText(a);
        txtX.setFont(f);
        txtX.setForeground(c);
    }

    /**
     * Kiểm tra tính hợp của tên
     * @param txt là 1 JTextField được truyền vào
     * @return true nếu tên đúng định dạng và ngược lại
     */
    public static boolean ValidateName(JTextField txt) {
        String id = txt.getText().trim();
        String rgx = "([A-ZĐ][a-záàạãảắặằẵẳăâấậẩẫầêèéệếểễôốồộổơớởờợỡúùứửừựữưịìíỉĩýỳỵỹỷòóọỏõđ]+[ ]{0,1})+";
        if (!id.matches(rgx) && txt.getForeground().equals(Black)) {
            return false;
        }
        return true;
    }


    /**
     * Kiểm tra tính hợp của số điện thoại
     * @param txt là 1 JTextField được truyền vào
     * @return true nếu số điện thoại đúng định dạng và ngược lại
     */
    public static boolean ValidateSDT(JTextField txt) {
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7,8}";
        if (id.matches(rgx) && !txt.getForeground().equals(Gray)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Kiểm tra tính hợp của email
     * @param txt là 1 JTextField được truyền vào
     * @return true nếu email đúng định dạng và ngược lại
     */
    public static boolean ValidateEmail(JTextField txt) {
        String id = txt.getText().trim();
        String rgx = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        if (!id.matches(rgx) && !txt.getForeground().equals(Gray)) {
            return false;
        }
        return true;
    }

    /**
     * Kiểm tra có trống hình hay không
     * @param lblAnh là 1 JLabel được truyền vào
     * @return true nếu có hình và ngược lại
     */
    public static boolean checkNullHinh(JLabel lblAnh) {
        if (lblAnh.getToolTipText() == null) {
            return false;
        }
        return true;
    }

    /**
     * Kiểm tra tính hợp của số lượng
     * @param txt là 1 JTextField được truyền vào
     * @return true nếu số lượng đúng định dạng và ngược lại
     */
    public static boolean checkSoLuong(JTextField txt) {
        try {
            int soLuong = (Integer.parseInt(txt.getText()));
            if (soLuong < 0) {
                txt.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            txt.requestFocus();
            return false;
        }
        return true;
    }

}
