package cn.pangchun.patterns.builder;

/**
 * MacbookBuilder：具体的建造者角色
 *
 * @author pangchun
 * @since 2023/10/20
 */
public class MacbookBuilder extends Builder {

    private final Macbook laptop = new Macbook();

    @Override
    public void buildBoard(String board) {
        laptop.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        laptop.setDisplay(display);
    }

    @Override
    public void buildOs() {
        laptop.setOs();
    }

    @Override
    public Laptop create() {
        return this.laptop;
    }
}
