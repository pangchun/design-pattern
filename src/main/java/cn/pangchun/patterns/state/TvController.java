package cn.pangchun.patterns.state;

import lombok.Data;

/**
 * 电视遥控器：对应Context角色，含有开机、关机、下一频道、上一频道、调高音量、调低音量这几个功能
 * 
 * @author pangchun
 * @since 2023/10/17
 */
@Data
public class TvController implements PowerController {

    private TvState tvState;

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
        System.out.println("开机啦");
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
        System.out.println("关机啦");
    }

    public void nextChannel() {
        tvState.nextChannel();
    }

    public void prevChannel() {
        tvState.prevChannel();
    }

    public void turnUp() {
        tvState.turnUp();
    }

    public void turnDown() {
        tvState.turnDown();
    }
}
