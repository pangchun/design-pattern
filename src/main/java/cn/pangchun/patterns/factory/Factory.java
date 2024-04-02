package cn.pangchun.patterns.factory;

/**
 * 抽象产品工厂：定义生产产品的方法
 *
 * @author pangchun
 * @since 2023/10/20
 */
public abstract class Factory {

    /**
     * 抽象方法，生产何种产品由子类决定
     * @return 产品对象
     */
    public abstract Product createProduct();

    /**
     * 抽象工厂方法
     * @param tClass 产品对象类型
     * @return 产品对象
     */
    public abstract <T extends Product> T createProduct(Class<T> tClass);
}
