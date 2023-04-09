package com.blog.util;

import com.alibaba.fastjson.JSONObject;
import com.blog.constant.Constants;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/2 18:54
 * @description ip工具类
 */
@Slf4j
public class IpUtils {

    private static final String localIp = "127.0.0.1";

    private static final String format_url = "https://apis.map.qq.com/ws/location/v1/ip?ip={}&key=VBPBZ-SYKRI-J3ZGJ-U3P42-XS2B6-3NBE7";

    /**
     * @author tur
     * @date 2023/4/2 21:43
     * @description 获取ip地址
     * @param request 前端请求
     * @return java.lang.String
    */
    public static String getIp(HttpServletRequest request){
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)){
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)){
                ipAddress = request.getHeader("WL_proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)){
                ipAddress = request.getRemoteAddr();
                if (localIp.equals(ipAddress)){
                    // 根据网卡取本机配置的IP
                    InetAddress inetAddress = null;
                    try {
                        inetAddress = InetAddress.getLocalHost();
                        ipAddress = inetAddress.getHostAddress();
                    } catch(UnknownHostException e){
                        e.printStackTrace();
                    }
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP，多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15){
                if (ipAddress.indexOf(",") > 15){
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch(Exception e){
            ipAddress = "";
        }

        return "0:0:0:0:0:0:0:1".equals(ipAddress) ? localIp : ipAddress;
    }

    /**
     * @author tur
     * @date 2023/4/2 22:29
     * @description 获取访问设备
     * @param request 前端请求
     * @return eu.bitwalker.useragentutils.UserAgent
    */
    public static UserAgent getUserAgent(HttpServletRequest request){
        return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
    }

    /**
     * @author tur
     * @date 2023/4/3 8:33
     * @description 解析IP地址
     * @param ip IP地址
     * @return java.lang.String 解析后的IP地址
    */
    public static String getCityInfo(String ip){
        // 解析ip地址.获取省市区
        String s = analyzeIp(ip);
        Map map = JSONObject.parseObject(s, Map.class);
        Integer status = (Integer) map.get("status");
        String address = Constants.UNKNOW;
        if (status == 0){
            Map result = (Map) map.get("result");
            Map addressInfo = (Map) result.get("ad_info");
            String nation = (String) addressInfo.get("nation");
            String province = (String) addressInfo.get("province");
            String city = (String) addressInfo.get("city");

            address = nation + "-" + province + "-" + city;
        }
        return address;
    }

    /**
     * @author tur
     * @date 2023/4/3 8:35
     * @description 根据在腾讯服务上申请的key进行请求解析ip
     * @param ip IP地址
     * @return java.lang.String
    */
    public static String analyzeIp(String ip){
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String url = format_url.replace("{}", ip);
            URL realUrl = new URL(url);
            // 打开和URL之间的链接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/**");
            connection.setRequestProperty("connection", "Keep-ALive");
            connection.setRequestProperty("user-agent", "http://localhost:8800/website-service/web/home/report");
            // 创建实际链接
            connection.connect();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
        } catch (Exception e) {
            log.error("发送GET请求出现异常!异常信息为：{}", e.getMessage());
        } finally {  // 使用finally来关闭输入流
            try {
                if (in != null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return result.toString();
    }
}
