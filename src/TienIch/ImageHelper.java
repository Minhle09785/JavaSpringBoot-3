/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author hp
 */
public class ImageHelper {

    public static Image getAppIcon(){      
     URL url =   ImageHelper.class.getResource("/Image/icon/logo.jpg");
    return new ImageIcon(url).getImage();
    
//     ImageIcon image1 = new ImageIcon("D:\\HK4\\DUAM(DA1)\\PS16989_TruongThanhThang_DuAnMau\\ThanhThang_Ps16989\\src\\Image_icon\\fpt.png");
//        return image1.getImage();
    }
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ImageIcon read(String fileName){
        File path = new File("logos",fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
public static ImageIcon reSizeImg(ImageIcon icon, int scaleWidth, int scaleHeight) {
        Image image = icon.getImage();
        double height = icon.getIconHeight();
        double width = icon.getIconWidth();
        if (icon.getIconWidth() > scaleWidth ) {
            width = scaleWidth;
            height = (scaleWidth * icon.getIconHeight()) / icon.getIconWidth();
        }
        else if (icon.getIconHeight() > scaleHeight) {
            height = scaleHeight;
            width = (scaleWidth * icon.getIconHeight()) / icon.getIconHeight();
        }
        Image newimg = image.getScaledInstance((int) width, (int) height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
//    //Hàm đọc ảnh từ thư mục logos
//    public static ImageIcon read(String fileName) {
//        File path = new File("logos", fileName);
//        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
//    }

}
