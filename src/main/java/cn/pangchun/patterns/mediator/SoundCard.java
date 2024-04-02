package cn.pangchun.patterns.mediator;

/**
 * 具体同事声卡：用来播放音频
 * 
 * @author pangchun
 * @since 2023/10/16
 */
public class SoundCard extends Colleague {

    public SoundCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 播放音频
     * @param data 视频音频
     */
    public void soundPlay(String data) {
        System.out.println("音频：" + data);
    }
}
