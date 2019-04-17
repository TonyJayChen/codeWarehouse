package com.myprojectlist.springboot.utils;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Zip压缩工具
 */
public class ZipUtils {
    /**
     * 压缩文件
     * @param src 要压缩的文件或目录的绝对路径
     * @param zip 输出的压缩文件的绝对路径
     * @throws IOException
     */
    public static void zip(String src, String zip) throws IOException {
        zip(new File(src), new File(zip));
    }
    /**
     * 压缩文件
     * @param src 要压缩的文件或目录的绝对路径
     * @param zip 输出的压缩文件
     * @throws IOException
     */
    public static void zip(String src, File zip) throws IOException {
        zip(new File(src), zip);
    }
    /**
     * 压缩文件
     * @param src 要压缩的文件或目录
     * @param zip 输出的压缩文件的绝对路径
     * @throws IOException
     */
    public static void zip(File src, String zip) throws IOException {
        zip(src, new File(zip));
    }
    /**
     * 压缩文件
     * @param src 要压缩的文件或目录
     * @param zip 输出的压缩文件
     * @throws IOException
     */
    public static void zip(File src, File zip) throws IOException {
        List<ZipEntry> list = foreach(src);
        ZipOutputStream out = new ZipOutputStream(zip);
        for (ZipEntry en : list) {
            File fo = new File(src.getParent(), en.getName());
            out.putNextEntry(en);
            FileInputStream in = new FileInputStream(fo);
            byte[] buffer = new byte[1024*8];
            for(int len=0;(len=in.read(buffer))!=-1;){
                out.write(buffer, 0, len);
            }
            in.close();
            out.flush();
        }
        out.close();
    }
    /**
     * 解压缩
     * @param zip 需要解压的压缩文件
     * @param out 解压到的目录
     * @throws Exception
     */
    public static void unzip(String zip,String out) throws Exception {
        unzip(new File(zip), new File(out));
    }
    /**
     * 解压缩
     * @param zip 需要解压的压缩文件
     * @param out 解压到的目录
     * @throws Exception
     */
    public static void unzip(String zip,File out) throws Exception {
        unzip(new File(zip), out);
    }
    /**
     * 解压缩
     * @param zip 需要解压的压缩文件
     * @param out 解压到的目录
     * @throws Exception
     */
    public static void unzip(File zip,String out) throws Exception {
        unzip(zip, new File(out));
    }
    /**
     * 解压缩
     * @param zip 需要解压的压缩文件
     * @param out 解压到的目录
     * @throws Exception
     */
    public static void unzip(File zip,File out) throws Exception {
        ZipFile zipFile = new ZipFile(zip,"GB18030");
        for (Enumeration<ZipEntry> entries = zipFile.getEntries(); entries.hasMoreElements();) {
            ZipEntry entry = entries.nextElement();
            File file = new File(out,entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                File parent = file.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                IOUtils.copy(zipFile.getInputStream(entry), new FileOutputStream(file));
            }
        }
        zipFile.close();
    }
     
    private static List<ZipEntry> foreach(File file) {
        return foreach(file, "");
    }
 
    private static List<ZipEntry> foreach(File file, String path) {
        List<ZipEntry> list = new ArrayList<ZipEntry>();
        if (file.isDirectory()) {
            path += file.getName() + File.separator;
            for (File fo : file.listFiles()) {
                list.addAll(foreach(fo, path));
            }
 
        } else if (file.isFile()) {
            list.add(new ZipEntry(path + file.getName()));
        }
        return list;
    }
    
   
    
    /**
     * 文件压缩
     * @param srcFile  目录或者单个文件
     * @param destFile 压缩后的ZIP文件
     */
    public static void doCompress(File srcFile, File destFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destFile));
        if(srcFile.isDirectory()){
            File[] files = srcFile.listFiles();
            for(File file : files){
                doCompress(file, out);
            }
        }else {
            doCompress(srcFile, out);
        }
    }
    
    public static void doCompress(String pathname, ZipOutputStream out) throws IOException{
        doCompress(new File(pathname), out);
    }

    
    
    public static void doCompress(File file, ZipOutputStream out) throws IOException{
        if( file.exists() ){
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(file.getName()));
            int len = 0 ;
            // 读取文件的内容,打包到zip文件    
            while ((len = fis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            out.flush();
            out.closeEntry();
            fis.close();
        }
    }
    
    public static void doCompress(String filename,String body, ZipOutputStream out) throws IOException{
        out.putNextEntry(new ZipEntry(filename));
        byte[] buffer = body.getBytes();
        out.write(buffer);
        out.flush();
        out.closeEntry();
    }
    /**
     *  @author wqm
     *  2017-8-27
     *  把文件内容添加到zip包
     * @param filename
     * @param body
     * @param out
     * @throws IOException
     */
    public static void doCompress(String filename,byte[] body, ZipOutputStream out) throws IOException{
        out.putNextEntry(new ZipEntry(filename));
        out.write(body);
        out.flush();
        out.closeEntry();
    }
    
    public static void doCompress(String srcFile, String zipFile) throws Exception {
        doCompress(new File(srcFile), new File(zipFile));
    }
 
    public static void main(String[] args) throws Exception {
        //zip("d:/abc", "d:/haha.zip");
        unzip("d:/FlashFXPPortable.zip","d:/abc");
    }


}