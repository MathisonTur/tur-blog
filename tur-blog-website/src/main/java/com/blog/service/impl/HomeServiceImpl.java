package com.blog.service.impl;

import com.blog.client.ContentClient;
import com.blog.constant.Constants;
import com.blog.constant.RedisConstants;
import com.blog.pojo.bo.PageBO;
import com.blog.pojo.bo.WebConfigBO;
import com.blog.pojo.dto.ContentCountDTO;
import com.blog.pojo.vo.WebsiteInfoVO;
import com.blog.service.intf.HomeService;
import com.blog.service.intf.PageService;
import com.blog.service.intf.RedisService;
import com.blog.service.intf.WebConfigService;
import com.blog.util.IpUtils;
import com.blog.util.ResponseResult;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author tur
 * @version 1.0
 * @date 2023/4/7 20:01
 * @description 网站首页服务
 */
@Slf4j
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    ContentClient contentClient;

    @Resource
    RedisService redisService;

    @Resource
    WebConfigService webConfigService;

    @Resource
    PageService pageService;

    /**
     * @return com.blog.utils.ResponseResult
     * @description 获取站点信息
     */
    @Override
    public ResponseResult webSiteInfo() {
        WebConfigBO webConfigBO = webConfigService.getOne();

        // 文章、分类、标签数量，访问量
        Long articleCount = contentClient.selectArticleCount();
        Long tagCount = contentClient.selectTagCount();
        Long categoryCount = contentClient.selectCategoryCount();
        String viewCount = getViewCount().toString();
        ContentCountDTO contentCountDTO = ContentCountDTO.builder()
                .articleCount(articleCount)
                .tagCount(tagCount)
                .categoryCount(categoryCount)
                .viewsCount(viewCount)
                .build();

        // 网站页面信息
        List<PageBO> pageBOList = pageService.getList();

        WebsiteInfoVO websiteInfoVO = WebsiteInfoVO.builder()
                .webSite(webConfigBO)
                .pageList(pageBOList)
                .count(contentCountDTO)
                .build();
        return ResponseResult.success(websiteInfoVO);
    }

    /**
     * @param request 前端请求
     * @return com.blog.utils.ResponseResult
     * @description 增加访问量
     */
    @Override
    public ResponseResult report(HttpServletRequest request) {
        // 获取ip
        String ipAddress = IpUtils.getIp(request);
        // 获取访问设备
        UserAgent userAgent = IpUtils.getUserAgent(request);
        // 获取访问的浏览器对象
        Browser browser = userAgent.getBrowser();
        // 获取操作系统对象
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        // 生成用户唯一标识
        String uuid = ipAddress + browser.getName() + operatingSystem.getName();
        // 利用DigestUtils进行md5加密。MD5加密：Hash加密
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());

        // 判断是否访问
        if (!redisService.sIsMember(RedisConstants.UNIQUE_VISITOR, md5)){
            // 未访问，则作如下处理
            // 统计游客地域分布
            String ipSource = IpUtils.getCityInfo(ipAddress);
            if (StringUtils.isNotBlank(ipSource)){
                ipSource = ipSource.substring(0, 2)
                        .replaceAll(Constants.PROVINCE, "")
                        .replaceAll(Constants.CITY, "");
                redisService.hIncr(RedisConstants.VISITOR_AREA, ipSource, 1L);
            } else{
                redisService.hIncr(RedisConstants.VISITOR_AREA, Constants.UNKNOW, 1L);
            }
            // 访问量+1
            redisService.incr(RedisConstants.BLOG_VIEWS_COUNT, 1);
            // 保存唯一标识
            redisService.sAdd(RedisConstants.UNIQUE_VISITOR, md5);
        }
        return ResponseResult.success();
    }

    //------------------- 自定义方法 ------------------------
    /**
     * @description 获取网站访问量
     * @return java.lang.Object
     */
    private Object getViewCount(){
        Object count = redisService.getCacheObject(RedisConstants.BLOG_VIEWS_COUNT);
        return Optional.ofNullable(count).orElse(0);
    }
}
