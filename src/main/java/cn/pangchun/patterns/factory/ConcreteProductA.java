package cn.pangchun.patterns.factory;

/**
 * 具体产品类A
 *
 * @author pangchun
 * @since 2023/10/20
 */
public class ConcreteProductA extends Product {
    @Override
    public void method() {
        System.out.println("具体产品A");
    }
}
