package cn.pangchun.patterns.visitor;

/**
 * 具体访问者：CTO，CTO更关注的是员工在技术层面的贡献
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class CtoVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + " , 代码数量: " + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + " , 新产品数量：" + manager.getProducts());
    }
}
