package cn.pangchun.patterns.state;

/**
 * 关机状态：此时只有开机功能是有效的
 * 
 * @author pangchun
 * @since 2023/10/17
 */
public class PowerOffState implements TvState {
    @Override
    public void nextChannel() {
    }

    @Override
    public void prevChannel() {
    }

    @Override
    public void turnUp() {
    }

    @Override
    public void turnDown() {
    }
}
