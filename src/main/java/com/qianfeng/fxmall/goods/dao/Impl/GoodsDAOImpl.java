package com.qianfeng.fxmall.goods.dao.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryBean;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

/**
 * MyBatis 商品数据访问层
 */
public class GoodsDAOImpl implements IGoodsDAO {

    @Override
    public List<WxbGood> queryGoodsByPage(Integer index) {
        SqlSession session= MyBatisSessionFactoryBean.getSession();
        WxbGoodMapper goodMapper = session.getMapper(WxbGoodMapper.class);
        List<WxbGood> wxbGoods = goodMapper.queryGoodsByPage(index,SystemConstantsUtils.Page.Page_SIZE);
        return wxbGoods;
    }

    @Override
    public void insertOneGood(WxbGood wxbGood) {
        SqlSession session= MyBatisSessionFactoryBean.getSession();
        session.getMapper(WxbGoodMapper.class).insertOneGood(wxbGood);
        session.commit();
    }
}
