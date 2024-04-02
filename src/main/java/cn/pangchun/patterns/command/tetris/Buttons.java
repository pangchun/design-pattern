package cn.pangchun.patterns.command.tetris;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 请求者角色
 * 
 * @author pangchun
 * @since 2023/10/9
 */
@Data
@Accessors(chain = true)
public class Buttons {

    /**
     * 持有命令对象的引用
     */
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private TransformCommand transformCommand;
    private FallCommand fallCommand;

    /**
     * 按下按钮 向左移动
     */
    public void toLeft() {
        leftCommand.execute();
    }

    /**
     * 按下按钮 向右移动
     */
    public void toRight() {
        rightCommand.execute();
    }

    /**
     * 按下按钮 改变形状
     */
    public void transform() {
        transformCommand.execute();
    }

    /**
     * 按下按钮 快速落下
     */
    public void fall() {
        fallCommand.execute();
    }
}
