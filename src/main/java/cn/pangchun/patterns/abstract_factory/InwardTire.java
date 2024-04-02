package cn.pangchun.patterns.abstract_factory;

/**
 * 具体产品：进口轮胎
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class InwardTire extends Tire {
    @Override
    public void tire() {
        System.out.println("进口轮胎");
    }
}
