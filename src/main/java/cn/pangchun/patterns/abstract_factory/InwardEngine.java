package cn.pangchun.patterns.abstract_factory;

/**
 * 具体产品：进口发动机
 *
 * @author pangchun
 * @since 2023/10/22
 */
public class InwardEngine extends Engine {
    @Override
    public void engine() {
        System.out.println("进口发送机");
    }
}
