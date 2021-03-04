package offer.single;

/**
 * 饿汉单例
 *
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/6 16:27
 */
public class HungerSingle {
    private HungerSingle() {
    }

    private static final HungerSingle SINGLE = new HungerSingle();

    public static HungerSingle getSingle() {
        return SINGLE;

    }
}
