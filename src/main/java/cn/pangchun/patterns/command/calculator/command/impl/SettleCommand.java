package cn.pangchun.patterns.command.calculator.command.impl;

import cn.pangchun.patterns.command.calculator.CalculatorMachine;
import lombok.AllArgsConstructor;

/**
 * 具体命令角色: 结算
 * 
 * @author pangchun
 * @since 2023/10/10
 */
@AllArgsConstructor
public class SettleCommand {

    private CalculatorMachine machine;

    public double settle() {
        return machine.settle();
    }
}
