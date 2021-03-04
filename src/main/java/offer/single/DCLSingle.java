package offer.single;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/6 16:36
 */
public class DCLSingle {

    private DCLSingle() {
    }

    private volatile static DCLSingle dclSingle = null;

    private static DCLSingle getDclSingle() {
        if (dclSingle == null) {//这里判断空其实是为了提高性能
            synchronized (DCLSingle.class) {
                if (dclSingle == null) {
                    return new DCLSingle();
                }
            }
        }
        return dclSingle;
    }
}
