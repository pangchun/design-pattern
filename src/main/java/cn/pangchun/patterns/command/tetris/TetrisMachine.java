package cn.pangchun.patterns.command.tetris;

/**
 * 接收者角色：底层逻辑代码实现
 *
 * @author pangchun
 * @since 2023/10/9
 */
public class TetrisMachine {

    /**
     * 真正处理 向左移动 操作的逻辑代码
     */
    public void toLeft() {
        System.out.println("向左移动");
    }

    /**
     * 真正处理 向右移动 操作的逻辑代码
     */
    public void toRight() {
        System.out.println("向右移动");
    }

    /**
     * 真正处理 改变形状 操作的逻辑代码
     */
    public void transform() {
        System.out.println("改变形状");
    }

    /**
     * 真正处理 快速落下 操作的逻辑代码
     */
    public void fastToBottom() {
        System.out.println("快速落下");
    }
}
