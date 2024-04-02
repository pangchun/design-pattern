package cn.pangchun.patterns.command.calculator.command.impl;

import cn.pangchun.patterns.command.calculator.CalculatorMachine;
import lombok.AllArgsConstructor;

/**
 * 具体命令角色: 归零
 * 
 * @author pangchun
 * @since 2023/10/10
 */
@AllArgsConstructor
public class ZeroCommand {

    private CalculatorMachine machine;

    public void zero() {
        machine.zero();
    }
}
