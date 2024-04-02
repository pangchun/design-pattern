package cn.pangchun.patterns.mediator;

import lombok.Data;

/**
 * 抽象同事
 * 
 * @author pangchun
 * @since 2023/10/16
 */
@Data
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
