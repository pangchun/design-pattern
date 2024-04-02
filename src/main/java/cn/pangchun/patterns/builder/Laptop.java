package cn.pangchun.patterns.builder;

import lombok.Data;

/**
 * 笔记本电脑：抽象产品角色
 *
 * @author pangchun
 * @since 2023/10/20
 */
@Data
public abstract class Laptop {

    /**
     * 主板、显示器、操作系统 属性
     */
    protected String board;
    protected String display;
    protected String os;

    protected Laptop() {}

    /**
     * 设置主板
     * @param board 主板信息
     */
    public void setBoard(String board) {
        this.board = board;
    }

    /**
     * 设置显示器
     * @param display 显示器信息
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * 设置操作系统信息：由子类去实现
     */
    public abstract void setOs();
}
