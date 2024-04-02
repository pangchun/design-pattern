package cn.pangchun.patterns.builder;

/**
 * Macbook：具体产品角色
 *
 * @author pangchun
 * @since 2023/10/20
 */
public class Macbook extends Laptop {
    @Override
    public void setOs() {
        this.os = "Mac OS x 10.10";
    }
}
