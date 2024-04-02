package cn.pangchun.patterns.command.calculator;

import cn.pangchun.patterns.command.calculator.command.CalculatorCommand;
import cn.pangchun.patterns.command.calculator.command.impl.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 请求者角色：与客户端直接交互
 *
 * @author pangchun
 * @since 2023/10/10
 */
@Data
@Accessors(chain = true)
public class CalculatorInvoker {

    /**
     * 计算器: 用于构造命令对象
     */
    private CalculatorMachine machine;

    /**
     * 引用命令对象
     */
    private SettleCommand settleCommand;
    private ZeroCommand zeroCommand;

    /**
     * 计算列表
     */
    private final List<CalculatorCommand> calculateList = Collections.synchronizedList(new ArrayList<>());

    /**
     * 重做列表
     */
    private final List<CalculatorCommand> redoList = Collections.synchronizedList(new ArrayList<>());

    /**
     * 加法
     * @param v 加几
     * @return 运算结果
     */
    public double add(double v) {
        // 构造加法命令
        final AddCommand command = new AddCommand(machine, v);
        calculateList.add(command);
        redoList.clear();
        return command.execute();
    }

    /**
     * 减法
     * @param v 减几
     * @return 运算结果
     */
    public double subtract(double v) {
        // 构造减法命令
        final SubtractCommand command = new SubtractCommand(machine, v);
        calculateList.add(command);
        redoList.clear();
        return command.execute();
    }

    /**
     * 乘法
     * @param v 乘几
     * @return 运算结果
     */
    public double multiply(double v) {
        // 构造乘法命令
        final MultiplyCommand command = new MultiplyCommand(machine, v);
        calculateList.add(command);
        redoList.clear();
        return command.execute();
    }

    /**
     * 除法
     * @param v 除几
     * @return 运算结果
     */
    public double divide(double v) {
        // 构造除法命令
        final DivideCommand command = new DivideCommand(machine, v);
        calculateList.add(command);
        redoList.clear();
        return command.execute();
    }

    /**
     * 结算
     * @return 运算结果
     */
    public double settle() {
        return settleCommand.settle();
    }

    /**
     * 归零
     */
    public void zero() {
        // 清楚撤销和重做列表
        calculateList.clear();
        redoList.clear();
        zeroCommand.zero();
    }

    /**
     * 是否可以撤销
     * @return ...
     */
    public boolean canUndo() {
        return calculateList.size() > 0;
    }

    /**
     * 是否可以重做
     * @return ...
     */
    public boolean canRedo() {
        return redoList.size() > 0;
    }

    /**
     * 撤销上一步的命令
     */
    public void undo() {
        if (!canUndo()) {
            throw new RuntimeException("当前没有可撤销的操作");
        }
        final CalculatorCommand undo = calculateList.get(calculateList.size() - 1);
        calculateList.remove(calculateList.size() - 1);
        undo.undo();
        redoList.add(undo);
    }

    /**
     * 重做上一步撤销的命令
     */
    public void redo() {
        if (!canRedo()) {
            throw new RuntimeException("当前没有可重做的操作");
        }
        final CalculatorCommand redo = redoList.get(redoList.size() - 1);
        redoList.remove(redoList.size() - 1);
        redo.execute();
        calculateList.add(redo);
    }
}
