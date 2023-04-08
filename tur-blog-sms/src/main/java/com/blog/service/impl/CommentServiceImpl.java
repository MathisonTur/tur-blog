package com.blog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.client.SystemClient;
import com.blog.constant.RedisConstants;
import com.blog.constant.SQLConstant;
import com.blog.exception.BusinessException;
import com.blog.mapper.CommentMapper;
import com.blog.pojo.bo.CommentBO;
import com.blog.pojo.bo.UserAuthBO;
import com.blog.pojo.dto.CommentDTO;
import com.blog.pojo.dto.ReplyDTO;
import com.blog.pojo.entity.Comment;
import com.blog.pojo.form.CommentForm;
import com.blog.pojo.vo.CommentVO;
import com.blog.service.intf.CommentService;
import com.blog.service.intf.RedisService;
import com.blog.util.BeanCopyUntils;
import com.blog.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
* @author tur
* @description 评论表服务
* @version 1.0
* @date 2023-04-07
*/
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    SystemClient systemClient;

    @Resource
    RedisService redisService;

    /**
     * @param articleId 文章ID
     * @param pageNo    页码
     * @param pageSize  每页数量
     * @return com.blog.utils.ResponseResult
     * @description 获取文章评论
     */
    @Override
    public ResponseResult comments(Long articleId, Long pageNo, Long pageSize) {
        // 查询文章评论数量
        Long commentCount = baseMapper.selectCount(new LambdaQueryWrapper<Comment>()
                .eq(Objects.nonNull(articleId), Comment::getArticleId, articleId)
                .isNull(Objects.isNull(articleId), Comment::getArticleId)
                .isNull(Comment::getParentId)
        );
        if (commentCount == 0){
            return ResponseResult.success();
        }
        Page<Comment> pages = baseMapper.selectPage(
                new Page<>(pageNo, pageSize),
                new QueryWrapper<Comment>().eq(SQLConstant.ARTICLE_ID, articleId).isNull(SQLConstant.PARENT_ID).orderByDesc(SQLConstant.ID));
        // 分页查询评论集合
        List<Comment> comments = pages.getRecords();
        if (CollectionUtils.isEmpty(comments)){
            return ResponseResult.success();
        }
        List<CommentDTO> commentDTOList = new ArrayList<>();
        List<ReplyDTO> replyDTOList = null;

        for (Comment comment : comments) {
            UserAuthBO userAuthBO = systemClient.getUserAuthByUserId(comment.getUserId());
            replyDTOList = getReplyDTOList(comment.getId(), comment.getUserId());
            CommentDTO commentDTO = CommentDTO.builder()
                    .id(comment.getId())
                    .userId(comment.getUserId())
                    .nickname(userAuthBO.getNickname())
                    .avatar(userAuthBO.getAvatar())
                    .webSite(userAuthBO.getWebSite())
                    .commentContent(comment.getContent())
                    .likeCount((Integer) redisService.hGet(RedisConstants.COMMENT_LIKE_COUNT, comment.getId().toString()))
                    .createTime(comment.getCreateTime())
                    .replyCount(replyDTOList == null ? 0 : replyDTOList.size())
                    .replyVOList(replyDTOList)
                    .build();

            commentDTOList.add(commentDTO);
        }

        CommentVO commentVO = new CommentVO(commentCount, commentDTOList);
        return ResponseResult.success(commentVO);
    }

    /**
     * @param commentForm 评论信息
     * @return com.blog.utils.ResponseResult
     * @description 添加评论
     */
    @Override
    public ResponseResult addComment(CommentForm commentForm) {
        if(commentForm.getUserId() != null){
            throw new BusinessException("非法请求评论!");
        }
        // 过滤标签
        // commentAddVO.setCommentContent();
        Comment comment = Comment.builder()
                .userId(systemClient.getUserAuthByUserId(StpUtil.getLoginIdAsLong()).getUserAuthId())
                .replyUserId(commentForm.getReplyUserId())
                .articleId(commentForm.getArticleId())
                .content(commentForm.getCommentContent())
                .parentId(commentForm.getParentId())
                .createTime(DateUtil.date().toLocalDateTime())
                .build();
        int rows = baseMapper.insert(comment);

        return rows > 0 ? ResponseResult.success(comment) : ResponseResult.error("评论失败");

    }

    /**
     * @param commentId 评论id
     * @return com.blog.utils.ResponseResult
     * @description 查询评论回复
     */
    @Override
    public ResponseResult repliesByCommentId(Long commentId) {
        return null;
    }

    //---------------------------- 其他服务方法 -------------------------
    /**
     * @param articleId 文章id
     * @return java.util.List<com.blog.model.entity.CommentBO>
     * @description 根据文章id获取评论集合
     */
    @Override
    public List<CommentBO> selectByArticleId(Long articleId) {
        return BeanCopyUntils.copyBeanList(baseMapper.selectByArticleId(articleId), CommentBO.class);
    }

    //--------------------------- 自定义方法 ---------------------
    /**
     * @description 根据父评论id，获取回复集合
     * @param parentId 父评论id
     * @return com.blog.model.dto.ReplyDTO
     */
    private List<ReplyDTO> getReplyDTOList(Long parentId, Long replyUserId){
        List<Comment> commentList = baseMapper.selectList(new QueryWrapper<Comment>().eq(SQLConstant.PARENT_ID, parentId));
        List<ReplyDTO> replyDTOList = BeanCopyUntils.copyBeanList(commentList, ReplyDTO.class);
        replyDTOList.forEach(replyDTO -> {
            UserAuthBO userAuthBO = systemClient.getUserAuthByUserId(replyDTO.getUserId());
            replyDTO.setNickname(userAuthBO.getNickname());
            replyDTO.setAvatar(userAuthBO.getAvatar());
            replyDTO.setWebSite(userAuthBO.getWebSite());
            replyDTO.setLikeCount((Integer) redisService.hGet(RedisConstants.COMMENT_LIKE_COUNT, replyDTO.getId().toString()));

            UserAuthBO replyUserAuthBO = systemClient.getUserAuthByUserId(replyUserId);
            replyDTO.setReplyUserId(replyUserId);
            replyDTO.setReplyNickname(replyUserAuthBO.getNickname());
            replyDTO.setReplyWebSite(replyUserAuthBO.getWebSite());
        });

        return replyDTOList;
    }
}
