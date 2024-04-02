package cn.pangchun.patterns.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 车费类型枚举
 * 1.通过此枚举去判断，应该调用哪个实现类，每个枚举对应一个策略
 *
 * @author pangchun
 * @since 2023/6/17
 */
@Getter
@AllArgsConstructor
public enum FareTypeEnum {

    // 公交车
    BUS("bus", "公交车"),
    //地铁
    SUBWAY("subway", "地铁");

    /**
     * 编码
     */
    private final String code;

    /**
     * 展示名
     */
    private final String name;
}
