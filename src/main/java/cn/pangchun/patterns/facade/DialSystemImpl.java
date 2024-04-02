package cn.pangchun.patterns.facade;

/**
 * 具体的子系统：通话
 * 
 * @author pangchun
 * @since 2023/10/25
 */
public class DialSystemImpl implements DialSystem {
    @Override
    public void dial() {
        System.out.println("打电话");
    }

    @Override
    public void hangup() {
        System.out.println("挂断");
    }
}
