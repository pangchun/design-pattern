package cn.pangchun.patterns.abstract_factory;

/**
 * 具体产品：国产轮胎
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class HomeMadeTire extends Tire {
    @Override
    public void tire() {
        System.out.println("国产轮胎");
    }
}
