package cn.pangchun.patterns.builder;

/**
 * 指挥者角色
 * 
 * @author pangchun
 * @since 2023/10/20
 */
public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 组建对象：指挥构建过程，这里并没有直接返回产品对象，而是void，产品对象可以直接由 builder.create(); 得到
     * @param board 主板信息
     * @param display 显示器信息
     */
    public void construct(String board, String display) {
        builder.buildBoard(board);
        builder.buildDisplay(display);
        builder.buildOs();
    }
}
