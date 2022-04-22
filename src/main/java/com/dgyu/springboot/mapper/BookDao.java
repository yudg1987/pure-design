package com.dgyu.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dgyu.springboot.entity.Book;

import java.util.List;

public interface BookDao extends BaseMapper<Book> {
	List<Book> findBooks();

}
