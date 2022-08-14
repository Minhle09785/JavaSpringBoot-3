/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class XDate {
//    static SimpleDateFormat formater = new SimpleDateFormat();
//    /**
//     * Chuyển đổi String sang Date
//     * @param date là String cần chuyển
//     * @param pattern là định dạng thời gian
//     * @return Date kết quả
//     */
//    public static Date toDate(String date, String pattern) {
//        try {
//            formater.applyPattern(pattern);
//             java.util.Date date1 = formater.parse(date);
//            java.sql.Date myDate = new java.sql.Date(date1.getTime());
//            return myDate;
//        } 
//        catch (ParseException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//    /**
//     * Chuyển đổi từ Date sang String
//     * @param date là Date cần chuyển đổi
//     * @param pattern là định dạng thời gian
//     * @return String kết quả
//     */
//    public static String toString(Date date, String pattern) {
//        formater.applyPattern(pattern);
//        return formater.format(date);
//    }
//
//    /**
//     * Bổ sung số ngày vào thời gian
//     * @param date thời gian hiện có
//     * @param days số ngày cần bổ sung váo date
//     * @return Date kết quả
//     */
//    public static Date addDays(Date date, long days) {
//        date.setTime(date.getTime() + days*24*60*60*1000);
//        return date;
//    }
    


    static SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    Date maxDate;  // This is the limit



    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {

                formater.applyPattern(pattern[0]);

            }
            if (date == null) {
                return XDate.now();
            }
            System.out.println(date);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            formater.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = XDate.now();
        }
        return formater.format(date);
    }

    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date add(int days) {
        Date now = XDate.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    public static Date now() {
        return new Date();
    }

   
}
        