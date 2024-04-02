package cn.pangchun.patterns.command.tetris;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 具体命令角色：快速落下
 * 
 * @author pangchun
 * @since 2023/10/9
 */
@Data
@AllArgsConstructor
public class FallCommand implements Command {

    /**
     * 持有一个对接收者对象(游戏机)的引用
     */
    private TetrisMachine tetrisMachine;

    @Override
    public void execute() {
        // 调用游戏机里具体的逻辑操作
        tetrisMachine.fastToBottom();
    }
}
