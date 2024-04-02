package cn.pangchun.patterns.facade;

/**
 * 子系统：拍摄系统
 *
 * @author pangchun
 * @since 2023/10/25
 */
public interface CameraSystem {

    /**
     * 打开相机
     */
    void open();

    /**
     * 拍摄
     */
    void takePicture();

    /**
     * 关闭相机
     */
    void close();
}
