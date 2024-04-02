package cn.pangchun.patterns.bridge;

/**
 * 大杯咖啡
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class LargeCoffee extends Coffee {
    public LargeCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯的" + additives.addSomething() + "咖啡");
    }
}
