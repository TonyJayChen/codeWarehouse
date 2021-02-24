package com.myprojectlist.springboot.utils;
import java.util.UUID;

public class IDCreater {

    /****
     * newID32方法慨述:32为主键
     * @return String
     * @创建人 huanghy
     * @创建时间 2017年9月1日 下午5:03:47
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static String newID32(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "").toUpperCase();
    }

    /***
     * newID16方法慨述:16位主键
     * @return String
     * @创建人 huanghy
     * @创建时间 2017年9月1日 下午5:04:02
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static String newID16(){
        String id="";
        String datetime = System.currentTimeMillis() +"";
        datetime=datetime.substring(5);
        String beg=UUID.randomUUID().toString().trim().replaceAll("-", "").toUpperCase().substring(0,8);
        for(int i=0;i<8;i++){
            id+=datetime.substring(i,i+1);
            id+=beg.substring(i,i+1);
        }
        return id;
    }

    public static String id32to36(String id32){
        id32=id32.substring(0,20)+"-"+id32.substring(20);
        id32=id32.substring(0,16)+"-"+id32.substring(16);
        id32=id32.substring(0,12)+"-"+id32.substring(12);
        id32=id32.substring(0,8)+"-"+id32.substring(8);
        return id32;
    }

    public static String id36to32(String id36){
        return id36.replaceAll("-", "");
    }
}
