package cn.pangchun.patterns.interpret;

/**
 * 抽象的算数运算解释器：为所有解释器共性的提取
 * 
 * @author pangchun
 * @since 2023/10/12
 */
public abstract class ArithmeticExpression {

    /**
     * 抽象的解析方法
     * 具体的解析逻辑由具体的子类实现
     * @return 解析得到具体的值
     */
    public abstract int interpret();
}
