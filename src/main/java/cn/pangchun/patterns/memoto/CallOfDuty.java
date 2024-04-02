package cn.pangchun.patterns.memoto;

/**
 * 使命召唤游戏
 * 
 * @author pangchun
 * @since 2023/10/17
 */
public class CallOfDuty {

    // 第几关
    private int mCheckpoint = 1;
    // 血量
    private int mLifeValue = 100;
    // 武器
    private String mWeapon = "沙漠之鹰";

    /**
     * 玩游戏
     */
    public void play() {
        System.out.println("玩游戏：" + String.format("第%d关", mCheckpoint) + "奋战杀敌中");
        mLifeValue -= 10;
        System.out.println("进度升级啦");
        mCheckpoint++;
        System.out.println("到达" + String.format("第%d关", mCheckpoint));
    }

    /**
     * 退出游戏
     */
    public void quit() {
        System.out.println("-------------");
        System.out.println("退出游戏前的属性：" + this.toString());
        System.out.println("退出游戏");
        System.out.println("-------------");
    }

    /**
     * 创建备忘录
     * @return 备忘录
     */
    public Memoto createMemoto() {
        final Memoto memoto = new Memoto();
        memoto.mCheckpoint = mCheckpoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    /**
     * 恢复游戏进度
     * @param memoto 备忘录
     */
    public void restore(Memoto memoto) {
        this.mCheckpoint = memoto.mCheckpoint;
        this.mLifeValue = memoto.mLifeValue;
        this.mWeapon = memoto.mWeapon;
        System.out.println("恢复后的游戏属性：" + this.toString());
    }

    @Override
    public String toString() {
        return "CallOfDuty{" +
                "mCheckpoint=" + mCheckpoint +
                ", mLifeValue=" + mLifeValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }
}
