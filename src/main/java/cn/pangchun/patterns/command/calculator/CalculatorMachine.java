package cn.pangchun.patterns.command.calculator;

import lombok.Data;

/**
 * 接受者角色：真正实现计算器底层逻辑
 *
 * @author pangchun
 * @since 2023/10/10
 */
@Data
public class CalculatorMachine {

    /**
     * 记录结果
     */
    private Double result = (double) 0;

    /**
     * 加法
     * @param v 加几
     * @return 运算结果
     */
    public double add(double v) {
        this.result = result + v;
        return result;
    }

    /**
     * 减法
     * @param v 减几
     * @return 运算结果
     */
    public double subtract(double v) {
        this.result = result - v;
        return result;
    }

    /**
     * 乘法
     * @param v 乘几
     * @return 运算结果
     */
    public double multiply(double v) {
        this.result = result * v;
        return result;
    }

    /**
     * 除法
     * @param v 除几
     * @return 运算结果
     */
    public double divide(double v) {
        if (0 == v) {
            throw new RuntimeException("除法运算参数异常，被除数不能为零");
        }
        this.result = result / v;
        return result;
    }

    /**
     * 结算
     * @return 运算结果
     */
    public double settle() {
        return result;
    }

    /**
     * 归零
     */
    public void zero() {
        setResult((double) 0);
    }
}
