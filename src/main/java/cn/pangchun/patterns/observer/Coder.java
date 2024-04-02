package cn.pangchun.patterns.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * 程序员：具体的观察者角色
 *
 * @author pangchun
 * @since 2023/10/17
 */
@Data
@AllArgsConstructor
public class Coder implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("你好：" + name + ", 技术前线网站更新啦, 内容：" + arg);
    }
}
