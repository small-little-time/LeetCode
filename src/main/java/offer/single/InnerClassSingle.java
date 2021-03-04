package offer.single;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/6 17:05
 */
public class InnerClassSingle {

    private InnerClassSingle() {
    }

    private static class Single {
        private static final InnerClassSingle INNER_CLASS_SINGLE = new InnerClassSingle();
    }

    private static InnerClassSingle getInstance() {
        return Single.INNER_CLASS_SINGLE;
    }
}
