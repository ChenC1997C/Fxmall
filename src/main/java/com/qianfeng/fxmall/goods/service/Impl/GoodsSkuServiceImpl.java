package com.qianfeng.fxmall.goods.service.Impl;

import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.dao.IGoodsSkuDAO;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsSkuDAOImpl;
import com.qianfeng.fxmall.goods.service.IGoodsSkuService;

public class GoodsSkuServiceImpl implements IGoodsSkuService {

    private IGoodsSkuDAO goodsSkuDAO = new GoodsSkuDAOImpl();

    @Override
    public void insertGoodsSku(WxbGoodSku wxbGoodSku) {
        goodsSkuDAO.insertGoodsSku(wxbGoodSku);
    }
}
