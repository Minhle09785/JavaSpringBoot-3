/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;

/**
 *
 * @author hp
 */
public class ColorHelper {

    private static Point point = new Point();
    public static Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(102, 102, 102));
    public static Border white_border = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.white);
    public static Border black_border = BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLUE);
//      public static Border null_border = BorderFactory.createMatteBorder(0, 1, 1, 0, Color.black);

    /**
     * Đổi màu tiêu đề của bảng
     *
     * @param opaque dùng để chỉnh trạng thái cho Opaque
     * @param backround là 1 màu nền
     * @param fore là 1 màu sắc cho chữ
     * @param font là 1 Font ch
     * @param tblBang là 1 JTable
     */
    public static void designTable(boolean opaque, Color backround, Color fore, Font font, JTable tblBang) {
        //Xét màu
        tblBang.getTableHeader().setOpaque(opaque);
        //Xét backround cho TableHeader
        tblBang.getTableHeader().setBackground(backround);
        //Xét màu chữ
        tblBang.getTableHeader().setForeground(fore);
        //Xét font chữ
        tblBang.getTableHeader().setFont(font);
    }

    /**
     * Đổi màu chữ hoặc nền cho 1 combobox
     *
     * @param backround là 1 màu nền
     * @param fore là 1 màu sắc cho chữ
     * @param font là 1 Font ch
     * @param cbo là 1 JComboBox
     */
    public static void designComboBox(Color backround, Color fore, Font font, JComboBox cbo) {
        //Xét màu backround của combobox
        cbo.setBackground(backround);
        //Xét màu chữ của combobox
        cbo.setForeground(fore);
        //Xét kiểu chữ cho combobox
        cbo.setFont(font);
    }

    //Lưu tọa độ
    public static void moveFrom(java.awt.event.MouseEvent evt) {
        point.x = evt.getX();
        point.y = evt.getY();
    }

    //Giúp di chuyển 1 Frame
    public static void MouseDragged(java.awt.event.MouseEvent evt, JFrame frame) {
        frame.setLocation(evt.getXOnScreen() - point.x, evt.getYOnScreen() - point.y);
    }

    /**
     * Đổi màu chữ và nền cho 1 JLabel
     *
     * @param fore là 1 màu sắc cho chữ
     * @param font là 1 Font ch
     * @param lblBackgroup là 1 JLabel
     */
    public static void setBackround(Color color, Color fore, JLabel lblBackground) {
        lblBackground.setBackground(color);
        lblBackground.setForeground(fore);
    }

    /**
     * Đổi màu chữ hoặc nền cho 1 combobox
     *
     * @param fore là 1 màu sắc cho chữ
     * @param font là 1 Font ch
     * @param btnBackground là 1 JButton
     */
    public static void setBackround(Color color, Color fore, JButton btnBackground) {
        btnBackground.setBackground(color);
        btnBackground.setForeground(fore);
    }

    public static void chooserList(Color color, Object... object) {
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JLabel) {
                JLabel lbl = (JLabel) object[i];
                lbl.setOpaque(true);
                lbl.setBackground(color);
            }
        }
    }

    public static void chooserDefault(Color color, Object... object) {
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JLabel) {
                JLabel lbl = (JLabel) object[i];
                lbl.setOpaque(false);
                lbl.setBackground(color);
            }
        }
    }

    //Xét màu chữ cho JButton hoặc JLabel
    public static void ColorForeground(Color color, Object... object) {
        //Cho JLabel
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JLabel) {
                JLabel lbl = (JLabel) object[i];
                lbl.setForeground(color);
            }
        }
        //Cho JButton
        for (int i = 0; i < object.length; i++) {
            if (object[i] instanceof JButton) {
                JButton btn = (JButton) object[i];
                btn.setForeground(color);
            }
        }
    }
}
