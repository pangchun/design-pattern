package cn.pangchun.patterns.interpret;

/**
 * 加法运算符号解释器
 *
 * @author pangchun
 * @since 2023/10/12
 */
public class AdditionExpression extends OperatorExpression{

    public AdditionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpret() {
        return exp1.interpret() + exp2.interpret();
    }
}
