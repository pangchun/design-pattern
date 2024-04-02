package cn.pangchun.patterns.adapter;

/**
 * adapter角色：将220v输入电压转为5v输出电压
 * 
 * @author pangchun
 * @since 2023/10/23
 */
public class VoltAdapter2 implements FiveVolt {

    private Volt220 volt220;

    public VoltAdapter2(Volt220 volt220) {
        this.volt220 = volt220;
    }

    public int getVolt220() {
        return volt220.getVolt220();
    }

    @Override
    public int getVolt5() {
        return 5;
    }
}
