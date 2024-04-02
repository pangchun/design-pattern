package cn.pangchun.patterns.decorator;

/**
 * 需要装饰的原始对象
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class Boy extends Person {
    @Override
    public void dressed() {
        System.out.println("穿了内衣内裤");
    }
}
