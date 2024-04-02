package cn.pangchun.patterns.mediator;

/**
 * 具体同事显卡：用来播放视频
 * 
 * @author pangchun
 * @since 2023/10/16
 */
public class GraphicsCard extends Colleague {

    public GraphicsCard(Mediator mediator) {
        super(mediator);
    }

    /**
     * 播放视频
     * @param data 视频数据
     */
    public void videoPlay(String data) {
        System.out.println("视频：" + data);
    }
}
