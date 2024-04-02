package cn.pangchun.patterns.singleton;

/**
 * 饿汉式单例模式
 * 1.缺点：无论是否使用，都会产生一个实例
 *
 * @author pangchun
 * @since 2023/10/19
 */
public class HungryRecycleBin {

    /**
     * 静态变量：类加载便初始化得到实例对象
     */
    private static final HungryRecycleBin INSTANCE = new HungryRecycleBin();

    /**
     * 私有构造方法
     */
    private HungryRecycleBin() {}

    /**
     * 公开的静态函数，对外暴露获取单例对象的接口
     * @return 单例对象
     */
    public static HungryRecycleBin getInstance() {
        return INSTANCE;
    }
}
