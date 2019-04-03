package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.service.IGoodsService;
import com.qianfeng.fxmall.goods.service.Impl.GoodsServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class GoodsServlet extends BaseServlet {
    final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    IGoodsService goodsService=applicationContext.getBean(GoodsServiceImpl.class);

    /**
     *  商品页面分页显示商品信息
     */
    public void queryGoodsByPage(HttpServletRequest req, HttpServletResponse resp){
        String pageStr = req.getParameter("page");
        try {
            pageStr = pageStr==null?"1":pageStr;
            List<WxbGood> goodList =
                    goodsService.queryGoodsByPage(Integer.parseInt(pageStr));
            for(WxbGood wxbGood:goodList){
                System.out.println(wxbGood.getGoodName());
            }
            req.setAttribute("goodsList",goodList);
            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            //能处理就处理
            //不能处理就跳转到错误提示页面
        }
    }

    /**
     *  商品信息插入
     */
    public void insertGoodsAndGoodSku(HttpServletRequest req, HttpServletResponse resp){
//        String sku_str=req.getParameter("sku_str");
//        String ctype=req.getParameter("ctype");
//        String aaa="adasdasdasdsa";
//        String sku_title=req.getParameter("sku_title");
//        String sku_cost=req.getParameter("sku_cost");
//        String sku_pmoney=req.getParameter("sku_pmoney");
//        String service_money=req.getParameter("service_money");
//        String sku_price=req.getParameter("sku_price");
//
//        String copy_id=req.getParameter("copy_id");
//        String spc_id=req.getParameter("spc_id");
//        String zon_id=req.getParameter("zon_id");
//        String optype=req.getParameter("optype");
//        String iswxpay=req.getParameter("iswxpay");
//        int iswxPay=Integer.parseInt(iswxpay);
//        String customer_id=req.getParameter("customer_id");
//        String good_name=req.getParameter("good_name");
//        String type_id=req.getParameter("type_id");
//        String order_no=req.getParameter("order_no");
//        int orderNo=Integer.parseInt(order_no);
//        String sell_num=req.getParameter("sell_num");
//
//        String smfile="jpg1";
//        String smfile1="jpg1";
//        String smfile2="jpg1";
////        String smfile=req.getParameter("smfile");
////        String smfile1=req.getParameter("smfile1");
////        String smfile2=req.getParameter("smfile2");
//        String promote_desc=req.getParameter("promote_desc");
//        //复选框
//        String []tags=req.getParameterValues("tage");
//
//        String gcopy=req.getParameter("gcopy");
//        String zcopy_id=req.getParameter("zcopy_id");
//        String copy_desc=req.getParameter("copy_desc");
//        String forward_link=req.getParameter("forward_link");
//
//        String good_id= UUID.randomUUID().toString().substring(0,8);
//        Date date=new Date();
//       Timestamp timestamp = new Timestamp(date.getTime());
//        WxbGood wxbGood=new WxbGood("12312312","123","123","123","123","123","123","123","123","123","123","123","123","123",1,"123","123",1,timestamp,11,22,timestamp,timestamp,"123","123",123,"123",111,111,111,"222");
////        WxbGood wxbGood=new WxbGood(good_id,good_name,customer_id,"123",smfile,smfile1,smfile2,sku_title,sku_cost,sku_price,sku_pmoney,copy_id,copy_desc,forward_link,orderNo,type_id,tags[0],1,timestamp,11,22,timestamp,timestamp,"123","123",123,"123",111,111,111,"222");
//        goodsService.insertOneGood(wxbGood);
        WxbGood wxbGood=new WxbGood();
        WxbGoodSku wxbGoodSku=new WxbGoodSku();
        String good_id= UUID.randomUUID().toString().substring(0,8);
        wxbGood.setGoodId(good_id);
        System.out.println("运行");
        if (ServletFileUpload.isMultipartContent(req)) {
            ServletFileUpload upload = new ServletFileUpload();
            upload.setFileSizeMax(5 * 1024 * 1024);
            try {
                FileItemIterator itr = upload.getItemIterator(req);
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                        String value = Streams.asString(item.openStream(), "UTF-8");
                        System.out.println(value);
                        switch (item.getFieldName()) {
                            case "sku_str":
                                break;
                            case "ctype":
                                if (value != null) {
                                }
                                break;
                            case "sku_title":
                                wxbGood.setSkuTitle(value);
                                break;
                            case "sku_cost":
                                wxbGood.setSkuCost(value);
                                break;
                            case "sku_pmoney":
                                wxbGood.setSkuPmoney(value);
                                break;
                            case "service_money":

                                break;
                            case "sku_price":
                                wxbGood.setSkuPrice(value);
                                break;
                            case "good_id":
                                if (value != null) {
                                }
                                break;
                            case "copy_id":
                                wxbGood.setCopyIds(value);
                                break;
                            case "spc_id":
                               wxbGood.setCopyDesc(value);
                                break;
                            case "zon_id":
                               wxbGood.setZonId(value);
                                break;
                            case "optype":
                                if (value != null) {
                                }
                                break;
                            case "iswxpay":
                                if (value != null) {
                                }
                                break;
                            case "customer_id":
                                wxbGood.setCustomerId(value);
                                break;
                            case "good_name":
                                wxbGood.setGoodName(value);
                                break;
                            case "type_id":
                                wxbGood.setTypeId(value);
                                break;
                            case "order_no":
                                if(value!=null){
                                    wxbGood.setOrderNo(Long.parseLong(value));
                                }else{
                                    wxbGood.setSellNum(0);
                                }
                                break;
                            case "sell_num":
                                if(value!=null){
                                    wxbGood.setSellNum(Long.parseLong(value));
                                }else{
                                    wxbGood.setSellNum(0);
                                }
                                break;
                            case "promote_desc":
                                wxbGood.setPromoteDesc(value);
                                break;
//                            case "tags":
//                                break;
                            case "gcopy":
                                break;
                            case "zcopy_id":
                               wxbGood.setZonId(value);
                                break;
                            case "copy_desc":
                                wxbGood.setCopyDesc(value);
                                break;
                            case "forward_link":
                                wxbGood.setForwardLink(value);
                                break;
                            case "sku":
                                break;
                            case "cb":
                                break;
                            case "jg":
                                break;
                            case "fc":
                                break;
                            case "kffc":
                                break;
                          default:break;
                        }
                    }else {
                        String filename = item.getName();
                        if(filename!=null&&filename.length()>0){
                            String filename2=UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
                            wxbGood.setGoodPic(filename2);
                            filename= SystemConstantsUtils.URL.IMG_URL+filename2;
                            FileOutputStream out=new FileOutputStream(filename);
                            Streams.copy(item.openStream(), out, true);
                        }
                    }
                }
                Date date=new Date();
                Timestamp timestamp = new Timestamp(date.getTime());
                wxbGood.setGoodPic1("2222222");
                wxbGood.setGoodPic2("3333333");
                wxbGood.setCreateTime(timestamp);
                wxbGood.setTopedTime(timestamp);
                wxbGood.setRecomedTime(timestamp);
                wxbGood.setTags("复选框值");
                System.out.println(wxbGood);
                System.out.println(wxbGoodSku);
                goodsService.insertOneGood(wxbGood);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
