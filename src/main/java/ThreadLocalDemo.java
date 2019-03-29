import com.qianfeng.fxmall.goods.bean.WxbGood;

public class ThreadLocalDemo {
    private static ThreadLocal<WxbGood> threadLocal=new ThreadLocal<>();
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                WxbGood wxbGood = new WxbGood();
                wxbGood.setGoodName("123123");
                threadLocal.set(wxbGood);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                WxbGood wxbGood = threadLocal.get();
                System.out.println("线程2"+wxbGood.getGoodName());
            }
        }).start();

    }
}
