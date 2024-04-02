package cn.pangchun.patterns.bridge;

/**
 * 原味
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class Ordinary extends CoffeeAdditives {
    @Override
    public String addSomething() {
        return "原味";
    }
}
