package cn.pangchun.patterns.command.calculator.command.impl;

import cn.pangchun.patterns.command.calculator.CalculatorMachine;
import cn.pangchun.patterns.command.calculator.command.CalculatorCommand;
import lombok.Data;

/**
 * 具体命令角色: 加法
 * 
 * @author pangchun
 * @since 2023/10/10
 */
@Data
public class AddCommand implements CalculatorCommand {

    private CalculatorMachine machine;

    /**
     * 运算参数
     */
    private double param;

    /**
     * 上一次运算结果: 每次计算前保存一下上一次的结果，执行撤销命令时可以直接获取
     */
    private double lastRs;

    @Override
    public double execute() {
        this.setLastRs(machine.getResult());
        return machine.add(param);
    }

    @Override
    public void undo() {
        machine.setResult(lastRs);
    }

    public AddCommand(CalculatorMachine machine, double param) {
        this.machine = machine;
        this.param = param;
    }
}
