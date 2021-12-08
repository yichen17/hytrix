package client.demo.controller;

import client.demo.constants.CommonConstants;
import client.demo.constants.ImageConstants;
import client.demo.utils.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author yichen
 * @version 1.0.0
 * @ClassName CookController.java
 * @Description 食品 controller
 * @createTime 2021年12月08日 21:45:00
 */
@Controller
@RequestMapping("/cook")
@Slf4j
public class CookController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ReturnT save(@RequestParam("foodName")String foodName, @RequestParam("image")MultipartFile file){
        log.info("入参 食物名称 {},原始图片名称 {},图片大小 {}",foodName,file.getOriginalFilename(),file.getSize());
        // 前置  判断文件是否是 jpg,jpeg,png 等格式
        String originalFileName=file.getOriginalFilename();
        int lastDot=originalFileName.lastIndexOf(".");
        // 避免 -1 导致 substring 出错
        if(lastDot<0){
            return new ReturnT("1","图片名称中没有. 无法区分类型");
        }
        String fileType=originalFileName.substring(lastDot+1);
        if(!ImageConstants.IMAGE_TYPE.toUpperCase().contains(fileType.toUpperCase())){
            return new ReturnT("1","图片类型不符合要求，请选择 jpg,jpeg,png,gif图片");
        }
        // 判断文件大小  是不是大于 16M
        if(file.getSize()>ImageConstants.MEDIUM_SIZE){
            return new ReturnT("1","图片过大，请选择16M以下的图片");
        }
        //生成文件名，可代替自增主键
        String newFileName= UUID.randomUUID().toString().replaceAll("-","")+"."+fileType;
        // 保存图片或者写入 db

        PreparedStatementSetter preparedStatementSetter=new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                try{
                    preparedStatement.setBinaryStream(1,file.getInputStream(),file.getSize());
                    preparedStatement.setString(2,foodName);
                }
                catch (IOException e){
                    log.error("无法读取文件流");
                }
            }
        };
        int affectRows=jdbcTemplate.update("insert into imagetest(image,name) values (?,?)",preparedStatementSetter);
        log.info("将记录插入到数据库，成功行数{}",affectRows);
        try{
            file.transferTo(new File(ImageConstants.FILE_ROOT+newFileName));
        }
        catch (IOException e){
            log.error("保存图片到本地出错，错误信息为{}",e.getMessage());
            return new ReturnT("1","保存图片到本地出错，请重试");
        }
        return new ReturnT("0","成功");
    }

}
