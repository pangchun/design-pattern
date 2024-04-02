package cn.pangchun.patterns.singleton;

/**
 * 静态内部类单例模式
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class StaticRecycleBin {

    /**
     * 私有构造方法
     */
    private StaticRecycleBin() {}

    /**
     * 公开的静态函数，对外暴露获取单例对象的接口
     * @return 单例对象
     */
    public static StaticRecycleBin getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final StaticRecycleBin instance = new StaticRecycleBin();
    }
}
