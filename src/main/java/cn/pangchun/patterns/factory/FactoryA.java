package cn.pangchun.patterns.factory;

/**
 * 具体工厂A：只生产A类产品
 *
 * @author pangchun
 * @since 2023/10/20
 */
public class FactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }

    @Override
    public <T extends Product> T createProduct(Class<T> tClass) {
        Product p = null;
        try {
            p = (Product) Class.forName(tClass.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) p;
    }
}
