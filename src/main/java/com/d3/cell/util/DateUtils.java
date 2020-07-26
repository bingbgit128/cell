package com.d3.cell.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtils {
    public static void main(String[] args) {
        System.out.println("="+  formattedDate("20190716", "yyyyMMdd", "yyyy-MM-dd"));

    }
    /**
     * 不带时分秒的日期字符串转化
     *
     * @param input 输入的日期
     * @param inputFormat 输入日期的格式
     * @param outputFormat 输出日期的格式
     * @return 输出的日期，不带时分秒
     */
    public static String formattedDate(String input, String inputFormat, String outputFormat) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat);
        LocalDate localDate = LocalDate.parse(input, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);
        return localDate.format(outputFormatter);
    }

}
