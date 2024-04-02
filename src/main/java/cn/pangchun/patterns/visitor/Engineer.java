package cn.pangchun.patterns.visitor;

import java.util.Random;

/**
 * 具体元素：工程师
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class Engineer extends Staff {
    /**
     * 构造函数
     *
     * @param name 员工姓名
     */
    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 工程师这一年写的代码数量
     * @return 代码行数
     */
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
