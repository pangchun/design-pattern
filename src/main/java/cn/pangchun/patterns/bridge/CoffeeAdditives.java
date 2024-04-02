package cn.pangchun.patterns.bridge;

/**
 * 实现部分：咖啡加糖
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public abstract class CoffeeAdditives {

    /**
     * 具体往咖啡里加什么也是由子类实现
     * @return 具体添加的东西
     */
    public abstract String addSomething();
}
