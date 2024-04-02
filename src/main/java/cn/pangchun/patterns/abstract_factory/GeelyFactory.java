package cn.pangchun.patterns.abstract_factory;

/**
 * 具体工厂：吉利工厂
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class GeelyFactory extends CarFactory {
    @Override
    public Tire createTire() {
        return new HomeMadeTire();
    }

    @Override
    public Engine createEngine() {
        return new HomeMadeEngine();
    }
}
