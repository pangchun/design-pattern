package cn.pangchun.patterns.visitor;

import java.util.Random;

/**
 * 抽象元素：员工基类
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public abstract class Staff {

    public String name;
    public int kpi;

    /**
     * 构造函数
     * @param name 员工姓名
     */
    public Staff(String name) {
        this.name = name;
        this.kpi = new Random().nextInt(10);
    }

    /**
     * 接受visitor的访问
     * @param visitor 访问者
     */
    public abstract void accept(Visitor visitor);
}
