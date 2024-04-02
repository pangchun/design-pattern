package cn.pangchun.patterns.singleton;

/**
 * 懒汉式单例模式
 * 1.缺点：每次获取单例都要进行同步，消耗资源
 *
 * @author pangchun
 * @since 2023/10/19
 */
public class LazyRecycleBin {

    private static LazyRecycleBin instance;

    /**
     * 私有构造方法
     */
    private LazyRecycleBin() {}

    /**
     * 公开的静态函数，对外暴露获取单例对象的接口
     * 1.synchronized保证多线程下单例对象的唯一性
     * 2.每次获取单例都要synchronized，消耗不必要的资源
     * @return 单例对象
     */
    public static synchronized LazyRecycleBin getInstance() {
        if (instance == null) {
            instance = new LazyRecycleBin();
        }
        return instance;
    }
}
