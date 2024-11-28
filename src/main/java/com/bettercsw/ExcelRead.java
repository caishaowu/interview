package com.bettercsw;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author csw
 * @date 2022/8/3 16:26
 */@Slf4j
public class ExcelRead {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = new FileInputStream("D:\\File\\ProjectCode\\server\\study\\interview\\src\\main\\resources\\test2.xlsx");//创建文件输入流
        XSSFWorkbook wb = new XSSFWorkbook(fileInput);//由输入流文件得到工作簿对象
        XSSFSheet sheet = wb.getSheetAt(1);//获取第一个sheet
        int lastRowNum = sheet.getLastRowNum(); //获取表格内容的最后一行的行数
        List<Order> orderList = new ArrayList<>();
        //rowBegin代表要开始读取的行号，下面这个循环的作用是读取每一行内容
        for (int i = 1; i <= lastRowNum; ++i) {
            Order order = null;
            int j = 0;
            XSSFRow row = sheet.getRow(i);//获取每一行
            try {
                order = new Order();
                if(row.getCell(j) == null) {
                    order.setTime("");
                    j++;
                }else {
                    order.setTime(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setId("");
                    j++;
                }else {
                    order.setId(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setTitle("");
                    j++;
                }else {
                    order.setTitle(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setContent("");
                    j++;
                }else {
                    order.setContent(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setLevelOne("");
                    j++;
                }else {
                    order.setLevelOne(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setLevelTwo("");
                    j++;
                }else {
                    order.setLevelTwo(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setLevelThree("");
                    j++;
                }else {
                    order.setLevelThree(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setTeam("");
                    j++;
                }else {
                    order.setTeam(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setAccount("");
                    j++;
                }else {
                    order.setAccount(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setName("");
                    j++;
                }else {
                    order.setName(row.getCell(j++).getStringCellValue());
                }
                if(row.getCell(j) == null) {
                    order.setCreateTime("");
                }else {
                    String createTime = row.getCell(j).getStringCellValue();
                    System.out.println(createTime.substring(0,createTime.indexOf('-')+3));


                    order.setCreateTime(createTime.substring(0,createTime.indexOf('-')+3));
                }
                j++;
                if(row.getCell(j) == null) {
                    order.setCity("");
                }else {
                    order.setCity(row.getCell(j).getStringCellValue());
                }
                j++;
                if(row.getCell(j) == null) {
                    order.setProvince("");
                }else {
                    order.setProvince(row.getCell(j).getStringCellValue());
                }
                j++;
                if(row.getCell(j) == null) {
                    order.setOrg("");
                }else {
                    order.setOrg(row.getCell(j).getStringCellValue());
                }
                j++;
                if(row.getCell(j) == null) {
                    order.setStatus("");
                }else {
                    order.setStatus(row.getCell(j).getStringCellValue());
                }
                j++;
                if(row.getCell(j) == null) {
                    order.setType("");
                }else {
                    order.setType(row.getCell(j).getStringCellValue());
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("行数：" + i + ",列数：" + j);
                break;
            }

            orderList.add(order);
        }
        Map<String,List<Order>> map = new HashMap<>();
        //根据城市分组
        // map = orderList.stream().collect(Collectors.groupingBy(Order::getCity));
        // for(String key : map.keySet()) {
        //     List<Order> cityOrders = map.get(key);
        //     System.out.print("城市: " + key + ",总数量：" + cityOrders.size());
        //     Map<String, List<Order>> level2Map = cityOrders.stream().collect(Collectors.groupingBy(Order::getLevelTwo));
        //     Map<String, List<Order>> level1Map = cityOrders.stream().collect(Collectors.groupingBy(Order::getLevelOne));
        //     for(String level : level2Map.keySet()) {
        //         List<Order> level2s = level2Map.get(level);
        //         int num = 0;
        //         if(level2s != null) {
        //             num = level2s.size();
        //         }
        //         log.info("二级专业：{}，工单量：{}",level,num);
        //     }
        // }

        groupByTime(orderList);

        wb.close();
        fileInput.close();
    }

    public static void groupByTime(List<Order> orderList) {
        Map<String,List<Order>> map = orderList.stream().collect(Collectors.groupingBy(Order::getCreateTime));
        for(String key : map.keySet()) {
            List<Order> timeOrders = map.get(key);

            Map<String, List<Order>> level1Map = timeOrders.stream().collect(Collectors.groupingBy(Order::getLevelOne));
            for(String level : level1Map.keySet()) {
                List<Order> levels = level1Map.get(level);
                log.info("建单年月：{},一级专业：{}，数量：{}",key,level,levels.size());
            }

        }
    }


}
