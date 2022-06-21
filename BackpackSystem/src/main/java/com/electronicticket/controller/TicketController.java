package com.electronicticket.controller;

import com.electronicticket.domain.ResultData;
import com.electronicticket.domain.Ticket;
import com.electronicticket.services.TicketService;
import lombok.val;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc
 * @date 2022年02月19日 2022/2/19
 */
@RestController
public class TicketController {
    private  //指定上传的位置为 C:/upload/
    String path = "C:\\Program Files\\Java\\up_load\\";
    @Autowired
    private TicketService ticketService;

    @RequestMapping("upLoad")
    public ResultData Upload(@RequestParam("file") MultipartFile file) {
        int code = -1;
        String msg = "";
        //判断文件是否为空
        if (file.isEmpty()) {
            code = 400;
            msg = "上传文件为空";
        } else {
            //创建输入输出流
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                //获取文件的输入流
                inputStream = file.getInputStream();
                //命名文件
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                dateFormat.applyPattern("yyyy-MM-dd-HH-mm-ss");// 格式化时间
                Date date = new Date();// 获取当前时间
                //修改文件名
                String fileName = dateFormat.format(date) + ".jpg";
                //注意是路径+文件名
                File targetFile = new File(path + fileName);
                //判断文件父目录是否存在
                if (!targetFile.getParentFile().exists()) {
                    //不存在就创建一个
                    targetFile.getParentFile().mkdir();
                }
                outputStream = new FileOutputStream(targetFile);
                FileCopyUtils.copy(inputStream, outputStream);
                code = 200;
                msg = fileName;
            } catch (IOException e) {
                e.printStackTrace();
                code = 400;
                msg = e.getMessage();
            } finally {
                //关闭输入输出流
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        code = 400;
                        msg = e.getMessage();
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        code = 400;
                        msg = e.getMessage();
                    }
                }
            }

        }
        ResultData response = new ResultData();
        response.setCode(code);
        System.out.println("返回文件名"+msg);
        response.setMsg(msg);
        return response;
    }


    @RequestMapping("creatTicket")
    public ResultData creatTicket(@RequestBody JSONObject request) {
        //准备数据
        int code = -1;
        String msg = "";
        Object data = null;
        String imgName = request.getString("imgPath");
        System.out.println(imgName);
        String carId="";
        if (imgName==null||imgName.equals("")){
            carId = "图片为空";
        }
        else{
           // carId = CarId.identifyCarId(path+imgName);
        }
        if (carId == null || carId.equals("")) {
            carId = "车牌识别失败";
        }
        Ticket ticket = new Ticket();
        ticket.setCarId(carId);
        ticket.setCarColor(request.getString("carColor"));
        ticket.setCarType(request.getString("carType"));
        Date date = new Date();
        Timestamp currentTime = new Timestamp(date.getTime());
        ticket.setParkingDate(currentTime);
        ticket.setParkingLocation(request.getString("location"));
        ticket.setColor(request.getString("color"));
        ticket.setDress(request.getString("dress"));
        ticket.setRecordPerson(request.getString("recordPerson"));
        ticket.setTelphone(request.getString("phone"));
        ticket.setImgPath(imgName);
        Ticket result = ticketService.insertTicket(ticket);
        if (result != null) {
            code = 200;
            msg = "登陆成功";
            data = result;
        } else {
            code = 400;
            msg = "数据获取失败";
        }

        ResultData response = new ResultData();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @RequestMapping("findTicketByDate")
    public ResultData findTicketByDate(@RequestBody JSONObject request) {
        //准备数据
        int code = -1;
        String msg = "";
        Object data = null;
        Timestamp startTime = Timestamp.valueOf(request.getString("startDate") + " 00:00:00");
        Timestamp endTime = Timestamp.valueOf(request.getString("endDate") + " 00:00:00");
        List<Ticket> tickets = ticketService.findTickets();
        List<Ticket> list = new ArrayList<>();
        if (tickets != null) {
            for (Ticket item : tickets
            ) {
                if (item.getParkingDate().after(startTime) && item.getParkingDate().before(endTime)) {
                    list.add(item);
                }
            }
        }
        if (list.size() > 0 && list != null) {
            code = 200;
            msg = "查询成功";
            data = list;
        } else {
            code = 200;
            msg = "该时间段没有告知单数据";
        }
        ResultData response = new ResultData();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
}
