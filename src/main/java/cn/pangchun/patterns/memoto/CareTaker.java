package cn.pangchun.patterns.memoto;

/**
 * CareTaker：负责管理备忘录
 * 
 * @author pangchun
 * @since 2023/10/17
 */
public class CareTaker {

    private Memoto memoto;

    /**
     * 存档
     * @param memoto 备忘录
     */
    public void archive(Memoto memoto) {
        this.memoto = memoto;
    }

    /**
     * 获取存档
     * @return 备忘录
     */
    public Memoto getMemoto() {
        return this.memoto;
    }
}
