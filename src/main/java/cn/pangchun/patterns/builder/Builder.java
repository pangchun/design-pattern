package cn.pangchun.patterns.builder;

/**
 * 抽象建造者角色：规范产品组件的步骤
 *
 * @author pangchun
 * @since 2023/10/20
 */
public abstract class Builder {

    /**
     * 设置主板
     * @param board 主板信息
     */
    public abstract void buildBoard(String board);

    /**
     * 设置显示器
     * @param display 显示器信息
     */
    public abstract void buildDisplay(String display);

    /**
     * 设置操作系统
     */
    public abstract void buildOs();

    /**
     * 组件产品
     * @return 笔记本产品
     */
    public abstract Laptop create();
}
