package cn.pangchun.patterns.interpret;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 运算符号抽象解释器：为所有运算符号解释器共性的提取，运算符号有可能为加、减、乘、除等不同符号
 * 
 * @author pangchun
 * @since 2023/10/12
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class OperatorExpression extends ArithmeticExpression {

    /**
     * 声明两个成员变量，存储运算符号两边的数字解释器
     * protected: 子类可以直接访问，不需要通过getter方法
     */
    protected ArithmeticExpression exp1,exp2;
}
