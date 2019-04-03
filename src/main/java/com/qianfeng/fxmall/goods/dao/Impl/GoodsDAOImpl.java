package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyBatis 商品数据访问层
 */
@Component
public class GoodsDAOImpl implements IGoodsDAO {
    @Autowired
    private WxbGoodMapper wxbGoodMapper;
    @Override
    public List<WxbGood> queryGoodsByPage(Integer index) {
        return wxbGoodMapper.queryGoodsByPage(index,SystemConstantsUtils.Page.Page_SIZE);
    }

    @Override
    public void insertOneGood(WxbGood wxbGood) {
        wxbGoodMapper.insertOneGood(wxbGood);
    }
}
