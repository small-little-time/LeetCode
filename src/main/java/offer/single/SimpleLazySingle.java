package offer.single;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/6 16:30
 */
public class SimpleLazySingle {

    private SimpleLazySingle() {
    }

    private static SimpleLazySingle simpleLazySingle = null;

    public static SimpleLazySingle getSimpleLazySingle() {
        if (simpleLazySingle == null) {
            return new SimpleLazySingle();
        }
        return simpleLazySingle;
    }
}
