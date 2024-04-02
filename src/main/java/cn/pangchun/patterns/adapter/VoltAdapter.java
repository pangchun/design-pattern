package cn.pangchun.patterns.adapter;

/**
 * adapter角色：将220v输入电压转为5v输出电压
 * 
 * @author pangchun
 * @since 2023/10/23
 */
public class VoltAdapter extends Volt220 implements FiveVolt {
    @Override
    public int getVolt5() {
        return 5;
    }
}
