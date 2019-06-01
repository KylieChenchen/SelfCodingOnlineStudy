package com.chen.dao.cart;


import com.chen.entity.cart.Cart;
import com.chen.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    public List<CartVO> selectAll(int userid);

    public int addCart(@Param("userid") int userid, @Param("courseid") int courseid);
    int delCart(@Param("userid") int userid, @Param("courseid") int courseid);
}