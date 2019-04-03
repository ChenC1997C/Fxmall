package com.qianfeng.fxmall.goods.mapper;


import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface WxbGoodMapper {
    /**
     *  通过商品Id 查找商品和商品所有套餐
     * @param goodId
     * @return 商品对象
     */
    WxbGood queryGoodAndGoodSkuById(@Param("goodId") String goodId);
    List<WxbGood> queryGoodsByPage (@Param("index") Integer index,@Param("size") Integer size);
    void insertOneGood(WxbGood wxbGood);
}
