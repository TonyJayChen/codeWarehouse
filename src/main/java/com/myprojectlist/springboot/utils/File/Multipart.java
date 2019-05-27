package com.myprojectlist.springboot.utils.File;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Multipart {

    private String savePath;

    /**
     * 接收表单上传，返回JSON格式。
     * @param file
     * @return
     */
    public String SetUpReturnJson(MultipartFile file) {
        String jsonString = "";
        Map<String, Object> json = new HashMap<String, Object>();
        try {
            Calendar date = Calendar.getInstance();
            // 修改文件名
            String filename = null;
            //临时文件名
            String tempFileName = null;
            //合并后的新文件名
            String newFileName = null;
            //文件保存路径
            savePath = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/"
                    + date.get(Calendar.DAY_OF_MONTH);

            //在磁盘上创建文件上传目录
            String uploadPath = savePath;
            // 获取上传文件对象
            tempFileName = file.getOriginalFilename();
            if (StringUtils.isNotEmpty(filename)) {
                newFileName = filename.concat(".").concat(FilenameUtils.getExtension(tempFileName));
            } else {
                newFileName = tempFileName;
            }
            File uploadFile = new File(uploadPath, newFileName);
            FileCopyUtils.copy(file.getBytes(), uploadFile);
            json.put("success", "true");
            json.put("cpdnRecordPath", savePath + newFileName);
            jsonString = JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    /**
     * 接收表单上传，返回Map格式。
     * @param file
     * @return
     */
    public Map<String, Object> SetUpReturnMap(MultipartFile file) {
        String jsonString = "";
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Calendar date = Calendar.getInstance();
            // 修改文件名
            String filename = null;
            //临时文件名
            String tempFileName = null;
            //合并后的新文件名
            String newFileName = null;
            //文件保存路径
            savePath = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/"
                    + date.get(Calendar.DAY_OF_MONTH);

            //在磁盘上创建文件上传目录
            String uploadPath = savePath;
            // 获取上传文件对象
            tempFileName = file.getOriginalFilename();
            if (StringUtils.isNotEmpty(filename)) {
                newFileName = filename.concat(".").concat(FilenameUtils.getExtension(tempFileName));
            } else {
                newFileName = tempFileName;
            }
            File uploadFile = new File(uploadPath, newFileName);
            FileCopyUtils.copy(file.getBytes(), uploadFile);
            map.put("success", "true");
            map.put("cpdnRecordPath", savePath + newFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
