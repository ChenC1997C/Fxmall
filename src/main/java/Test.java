import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryBean;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.dao.Impl.GoodsDAOImpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.IGoodsSkuService;
import com.qianfeng.fxmall.goods.service.Impl.GoodsServiceImpl;
import com.qianfeng.fxmall.goods.service.Impl.GoodsSkuServiceImpl;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args){
//        SqlSession session = MyBatisSessionFactoryBean.getSession();
        IGoodsSkuService goodsSkuService=new GoodsSkuServiceImpl();
//
            WxbGoodSku wxbGoodSku=new WxbGoodSku("aqw```sss","aaaa","aaaa","123","asdad","32e51f09",1,"aaa,");
//        SqlSession session=MyBatisSessionFactoryBean.getSession();
//        session.insert("com.qianfeng.fxmall.goods.bean.WxbGoodSkuMapper.insertGoodsSku",wxbGoodSku);
        goodsSkuService.insertGoodsSku(wxbGoodSku);
//        Date date=new Date();
//        Timestamp timestamp = new Timestamp(date.getTime());
//        WxbGood wxbGood=new WxbGood("1111","123","123","123","123","123","123","123","123","123","123","123","123","123",1,"123","123",1,timestamp,11,22,timestamp,timestamp,"123","123",123,"123",111,111,111,"222");
//        IGoodsService goodsService=new GoodsServiceImpl();
//        goodsService.insertOneGood(wxbGood);
//        session.insert("com.qianfeng.fxmall.goods.mapper.WxbGoodMapper.insertOneGood",wxbGood);
//        session.commit();
//        goodSkuDAO.insertOneSku(wxbGoodSku);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
//                    List<WxbGood> goods=goodsDAO.queryGoodsByPage(0);
//                    goods.get(0).setGoodName("前鋒");
//
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    GoodsDAOImpl goodsDAO=new GoodsDAOImpl();
//                    List<WxbGood> goods=goodsDAO.queryGoodsByPage(0);
//                    System.out.println(goods.get(0).getGoodName());
//
//            }
//        }).start();
    }
}
