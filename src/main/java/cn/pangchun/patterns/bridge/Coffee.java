package cn.pangchun.patterns.bridge;

/**
 * 抽象部分：咖啡，需要保持一个对实现部分对象的引用
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public abstract class Coffee {

    protected CoffeeAdditives additives;

    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    /**
     * 咖啡具体什么样子由子类决定
     */
    public abstract void makeCoffee();
}
