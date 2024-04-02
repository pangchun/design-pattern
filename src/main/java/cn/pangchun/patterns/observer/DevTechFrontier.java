package cn.pangchun.patterns.observer;

import java.util.Observable;

/**
 * 技术前线网站：被观察的角色
 *
 * @author pangchun
 * @since 2023/10/17
 */
public class DevTechFrontier extends Observable {

    /**
     * 发布新的内容
     * 当它更新时，要通知所有程序员
     * @param content 新内容
     */
    public void postNewPublication(String content) {
        // 标识状态或内容发生改变
        setChanged();
        // 通知所有观察者
        notifyObservers(content);
    }
}
