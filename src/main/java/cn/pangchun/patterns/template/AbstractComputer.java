package cn.pangchun.patterns.template;

/**
 * 抽象电脑：抽象模板角色，定义模板骨架
 * 
 * @author pangchun
 * @since 2023/10/18
 */
public abstract class AbstractComputer {

    protected void powerOn() {
        System.out.println("开启电源");
    }

    protected void checkHardware() {
        System.out.println("硬件检查");
    }

    protected void loadOs() {
        System.out.println("载入操作系统");
    }

    protected void login() {
        System.out.println("小白的计算机无验证，直接进入操作系统");
    }

    /**
     * 启动计算机方法，步骤固定为开启电源、系统检查、加载操作系统、用户登录。该方法为final，防止算法框架被覆写
     */
    public final void startUp() {
        System.out.println("-------- 开机 start ------------");
        powerOn();
        checkHardware();
        loadOs();
        login();
        System.out.println("-------- 关机 end ------------");
    }
}
