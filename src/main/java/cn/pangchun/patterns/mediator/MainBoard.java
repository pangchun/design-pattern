package cn.pangchun.patterns.mediator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 主板中介者
 * 
 * @author pangchun
 * @since 2023/10/16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MainBoard extends Mediator {

    /**
     * 引用其他同事对象
     */
    private CdDevice cdDevice;
    private Cpu cpu;
    private GraphicsCard graphicsCard;
    private SoundCard soundCard;

    @Override
    public void changed(Colleague c) {
        // 如果是光驱读取了数据
        if (c == cdDevice) {
            handleCd((CdDevice) c);
        } else if (c == cpu) {
            handleCpu((Cpu) c);
        }
    }

    /**
     * 处理cd设备读取数据后与其他设备的交互
     * @param cdDevice 光驱设备
     */
    public void handleCd(CdDevice cdDevice) {
        cpu.decodeData(cdDevice.read());
    }

    /**
     * 处理cpu读取数据后与其他设备的交互
     * @param cpu cpu
     */
    public void handleCpu(Cpu cpu) {
        soundCard.soundPlay(cpu.getDataSound());
        graphicsCard.videoPlay(cpu.getDataVideo());
    }
}
