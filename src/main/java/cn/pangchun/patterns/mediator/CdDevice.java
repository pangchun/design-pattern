package cn.pangchun.patterns.mediator;

/**
 * 具体同事CD设备：负责读取光盘的数据并传递给主板
 * 
 * @author pangchun
 * @since 2023/10/16
 */
public class CdDevice extends Colleague {

    /**
     * 视频数据
     */
    private String data;

    public CdDevice(Mediator mediator) {
        super(mediator);
    }

    /**
     * 读取视频数据
     * @return 视频数据
     */
    public String read() {
        return data;
    }

    /**
     * 加载视频数据
     */
    public void load() {
        // 实际情况是视频和音频数据都在一个数据流中
        data = "视频数据,音频数据";

        // 通知中介者，也就是主板数据改变
        mediator.changed(this);
    }
}
