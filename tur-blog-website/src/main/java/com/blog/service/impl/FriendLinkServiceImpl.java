package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.constant.SQLConstant;
import com.blog.enums.FriendLinkEnum;
import com.blog.mapper.FriendLinkMapper;
import com.blog.pojo.entity.FriendLink;
import com.blog.pojo.form.FriendLinkForm;
import com.blog.pojo.vo.FriendLinkVO;
import com.blog.service.intf.FriendLinkService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
* @author tur
* @description 友情链接表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink> implements FriendLinkService {

    /**
     * @return com.blog.utils.ResponseResult
     * @description 友链列表
     */
    @Override
    public ResponseResult friendLinkList() {
        // 构建查询条件
        QueryWrapper<FriendLink> queryWrapper = new QueryWrapper<>();
        // 只展示已上架的友链
        queryWrapper.eq(SQLConstant.STATUS, FriendLinkEnum.UP.getCode());
        // 封装已上架的友链列表
        List<FriendLinkVO> friendLinkVOList = BeanCopyUntils.copyBeanList(baseMapper.selectList(queryWrapper), FriendLinkVO.class);

        return ResponseResult.success(friendLinkVOList);
    }

    /**
     * @param friendLinkForm 友链信息
     * @return com.blog.utils.ResponseResult
     * @description 申请友链
     */
    @Override
    public ResponseResult addFriendLink(FriendLinkForm friendLinkForm) {
        FriendLink friendLink = BeanCopyUntils.copyBean(friendLinkForm, FriendLink.class);
        Assert.isTrue(StringUtils.isNotBlank(friendLink.getUrl()), "请输入正确的网址!");
        friendLink.setStatus(FriendLinkEnum.APPLY.getCode());

        // 如果已经申请过又来拿，再次接入则会进行下架处理，需要重新审核
        FriendLink entity = baseMapper.selectOne(new QueryWrapper<FriendLink>().eq(SQLConstant.URL, friendLink.getUrl()));
        if (entity != null){
            friendLink.setId(entity.getId());
            baseMapper.updateById(friendLink);
        }else{
            baseMapper.insert(friendLink);
        }

        // 待实现：友链申请后，邮箱发送邮件提醒要审核

        return ResponseResult.success();
    }
}
