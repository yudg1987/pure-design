package com.dgyu.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dgyu.springboot.entity.Comment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 青哥哥
 * @since 2022-03-22
 */
public interface ICommentService extends IService<Comment> {

    List<Comment> findCommentDetail(Integer articleId);
}
