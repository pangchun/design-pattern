package cn.pangchun.patterns.facade;

/**
 * 子系统：拨号系统
 *
 * @author pangchun
 * @since 2023/10/25
 */
public interface DialSystem {

    /**
     * 拨号
     */
    void dial();

    /**
     * 挂断
     */
    void hangup();
}
