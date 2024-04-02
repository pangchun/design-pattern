package cn.pangchun.patterns.command.calculator.command;

/**
 * 抽象命令角色: 加减乘除、撤销
 *
 * @author pangchun
 * @since 2023/10/10
 */
public interface CalculatorCommand {

    /**
     * 执行命令
     * @return 运算结果
     */
    double execute();

    /**
     * 撤销
     */
    void undo();
}
