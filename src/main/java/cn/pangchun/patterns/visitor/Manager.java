package cn.pangchun.patterns.visitor;

import java.util.Random;

/**
 * 具体元素：产品经理
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class Manager extends Staff {

    private int products;

    /**
     * 构造函数
     *
     * @param name 员工姓名
     */
    public Manager(String name) {
        super(name);
        this.products = new Random().nextInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 一年内做的产品数量
     * @return 产品数量
     */
    public int getProducts() {
        return products;
    }
}
