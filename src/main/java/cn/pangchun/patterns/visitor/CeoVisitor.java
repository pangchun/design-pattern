package cn.pangchun.patterns.visitor;

/**
 * 具体访问者：CEO，只关注业绩
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class CeoVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + " , kpi: " + engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + " , kpi: " + manager.kpi + " , 新产品数量：" + manager.getProducts());
    }
}
