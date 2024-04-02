package cn.pangchun.patterns.factory;

/**
 * 具体工厂B：只生产B类产品
 *
 * @author pangchun
 * @since 2023/10/20
 */
public class FactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }

    @Override
    public <T extends Product> T createProduct(Class<T> tClass) {
        return null;
    }
}
