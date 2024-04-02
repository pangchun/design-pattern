package cn.pangchun.patterns.abstract_factory;

/**
 * 具体产品：国产发送机
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class HomeMadeEngine extends Engine {
    @Override
    public void engine() {
        System.out.println("国产发送机");
    }
}
