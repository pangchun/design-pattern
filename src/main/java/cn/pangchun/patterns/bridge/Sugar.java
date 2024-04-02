package cn.pangchun.patterns.bridge;

/**
 * 加糖
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class Sugar extends CoffeeAdditives {
    @Override
    public String addSomething() {
        return "加糖";
    }
}
