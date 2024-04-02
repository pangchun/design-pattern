package cn.pangchun.patterns.state;

/**
 * 电视状态接口：定义了电视操作的函数
 * 
 * @author pangchun
 * @since 2023/10/17
 */
public interface TvState {
    void nextChannel();
    void prevChannel();
    void turnUp();
    void turnDown();
}
