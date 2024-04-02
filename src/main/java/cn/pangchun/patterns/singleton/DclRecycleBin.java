package cn.pangchun.patterns.singleton;

/**
 * double check lock 双重检锁单例模式
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class DclRecycleBin {

    /**
     * volatile防止指令重排，每次都从主内存中获取instance对象
     */
    private volatile static DclRecycleBin instance = null;

    /**
     * 私有构造方法
     */
    private DclRecycleBin() {}

    /**
     * 公开的静态函数，对外暴露获取单例对象的接口
     * @return 单例对象
     */
    public static DclRecycleBin getInstance() {
        // 判空，避免不必要的同步
        if (instance == null) {
            synchronized (DclRecycleBin.class) {
                // 判空，避免多线程下，因为instance = new DclRecycleBin();语句的指令重排序，导致DCL失效，创建多个实例对象
                if (instance == null) {
                    instance = new DclRecycleBin();
                }
            }
        }
        return instance;
    }
}
