package cn.pangchun.patterns.abstract_factory;

/**
 * 具体工厂：宝马工厂
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class BmwFactory extends CarFactory {
    @Override
    public Tire createTire() {
        return new InwardTire();
    }

    @Override
    public Engine createEngine() {
        return new InwardEngine();
    }
}
