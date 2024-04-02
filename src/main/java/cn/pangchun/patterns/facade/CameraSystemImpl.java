package cn.pangchun.patterns.facade;

/**
 * 具体的子系统：拍照
 *
 * @author pangchun
 * @since 2023/10/25
 */
public class CameraSystemImpl implements CameraSystem {
    @Override
    public void open() {
        System.out.println("打开相机");
    }

    @Override
    public void takePicture() {
        System.out.println("拍照");
    }

    @Override
    public void close() {
        System.out.println("关闭相机");
    }
}
