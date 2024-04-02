package cn.pangchun.patterns.interpret;

import java.util.Stack;

/**
 * 计算器：处理与解释一些相关的业务
 * 
 * @author pangchun
 * @since 2023/10/12
 */
public class ArithmeticCalculator {

    /**
     * 声明一个栈，存储并操作所有相关的解释器
     */
    private final Stack<ArithmeticExpression> stack = new Stack<ArithmeticExpression>();

    /**
     * 构造方法，在实例化的时候把表达式传进来
     * @param expression 表达式
     */
    public ArithmeticCalculator(String expression) {
        // 声明两个临时变量，存储运算符号两边的数字解释器
        ArithmeticExpression exp1,exp2;

        // 使用空格分割表达式字符串
        final String[] elements = expression.split(" ");

        // 循环遍历表达式元素数组
        for (int i = 0; i < elements.length; i++) {
            // 判断运算符号
            switch (elements[i].charAt(0)) {
                case '+':
                    // 如果是加号，则将栈中的解释器弹出作为运算符左边的解释器
                    exp1 = stack.pop();

                    // 同时将运算符号数组下标下一个元素构造为数字解释器
                    exp2 = new NumberExpression(Integer.parseInt(elements[++i]));

                    // 通过上面两个数字解释器构造一个加法运算解释器并压入栈中
                    stack.push(new AdditionExpression(exp1,exp2));
                    break;
                default:
                    // 如果是数字(只有加号和数字)，则构造数字解释器并压入栈中
                    stack.push(new NumberExpression(Integer.parseInt(elements[i])));
                    break;
            }
        }
    }

    /**
     * 计算最终结果
     * @return 最终的计算结果
     */
    public int calculate() {
        return stack.pop().interpret();
    }
}
