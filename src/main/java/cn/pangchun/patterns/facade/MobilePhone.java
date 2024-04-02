package cn.pangchun.patterns.facade;

/**
 * 外观者角色：手机，是统一地入口，包含通话、拍摄的功能
 *
 * @author pangchun
 * @since 2023/10/25
 */
public class MobilePhone {

    private DialSystem dialSystem = new DialSystemImpl();
    private CameraSystem cameraSystem = new CameraSystemImpl();

    public void dial() {
        dialSystem.dial();
    }

    public void videoChat() {
        System.out.println("---> 视频聊天接通中");
        cameraSystem.open();
        dialSystem.dial();
    }

    public void hangup() {
        dialSystem.hangup();
    }

    public void takePicture() {
        cameraSystem.open();
        cameraSystem.takePicture();
    }

    public void closeCamera() {
        cameraSystem.close();
    }
}
