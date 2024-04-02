package cn.pangchun.patterns.abstract_factory;

/**
 * 抽象工厂：汽车工厂
 * 
 * @author pangchun
 * @since 2023/10/22
 */
public abstract class CarFactory {

    /**
     * 生产轮胎
     * @return 轮胎
     */
    public abstract Tire createTire();

    /**
     * 生产引擎
     * @return 殷勤
     */
    public abstract Engine createEngine();
}
