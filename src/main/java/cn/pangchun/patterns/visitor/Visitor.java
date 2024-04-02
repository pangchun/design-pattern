package cn.pangchun.patterns.visitor;

/**
 * 抽象访问者Visitor
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public interface Visitor {

    /**
     * 访问工程师类型
     * @param engineer 工程师
     */
    void visit(Engineer engineer);

    /**
     * 访问产品经理类型
     * @param manager 产品经理
     */
    void visit(Manager manager);
}
