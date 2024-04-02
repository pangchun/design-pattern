package cn.pangchun.patterns.mediator;

import lombok.Getter;

/**
 * 具体同事CPU：负责从主板传递来音视频的数据解码
 * 
 * @author pangchun
 * @since 2023/10/16
 */
@Getter
public class Cpu extends Colleague {

    /**
     * 视频和音频数据
     */
    private String dataVideo, dataSound;

    public Cpu(Mediator mediator) {
        super(mediator);
    }

    /**
     * 解码音视频数据
     * @param data 音视频数据
     */
    public void decodeData(String data) {
        // 分割音视频数据
        final String[] tmp = data.split(",");

        // 解析音视频数据
        this.dataVideo = tmp[0];
        this.dataSound = tmp[1];

        // 告诉中介者自身状态改变
        mediator.changed(this);
    }
}
