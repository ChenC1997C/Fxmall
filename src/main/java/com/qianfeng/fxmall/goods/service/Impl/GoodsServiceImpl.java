package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodsDAO;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private IGoodsDAO goodsDAO;
    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws IOException {
        if(page<1){
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        //计算起始下标
        int index=(page-1)* SystemConstantsUtils.Page.Page_SIZE;
        List<WxbGood> goods = goodsDAO.queryGoodsByPage(index);
        return goods;
    }

    @Override
    public void insertOneGood(WxbGood wxbGood) {

        goodsDAO.insertOneGood(wxbGood);
    }
}
