package cn.pangchun.patterns.singleton;

/**
 * 枚举单例
 *
 * @author pangchun
 * @since 2023/10/19
 */
public enum EnumRecycleBin {

    // 枚举单例
    Instance;

    public void doSomething() {
        System.out.println("do something...");
    }
}
