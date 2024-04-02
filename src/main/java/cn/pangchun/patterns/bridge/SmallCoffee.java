package cn.pangchun.patterns.bridge;

/**
 * 小杯咖啡
 *
 * @author pangchun
 * @since 2023/10/24
 */
public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的" + additives.addSomething() + "咖啡");
    }
}
