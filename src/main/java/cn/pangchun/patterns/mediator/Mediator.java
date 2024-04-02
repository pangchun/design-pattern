package cn.pangchun.patterns.mediator;

/**
 * 抽象的中介者
 *
 * @author pangchun
 * @since 2023/10/16
 */
public abstract class Mediator {

    /**
     * 同事对象改变时通知中介者的方法
     * 在同事对象改变时由中介者对象去通知其他同事对象
      * @param c 同事对象
     */
    public abstract void changed(Colleague c);
}
