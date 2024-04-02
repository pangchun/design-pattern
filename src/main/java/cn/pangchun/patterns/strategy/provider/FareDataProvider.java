package cn.pangchun.patterns.strategy.provider;

import cn.pangchun.patterns.strategy.enums.FareTypeEnum;

/**
 * 车费数据的提供者
 * 1.抽象策略接口
 *
 * @author pangchun
 * @since 2023/6/17
 */
public interface FareDataProvider {

    /**
     * 是否支持提供策略
     *
     * @param type 车费类型
     * @return 是否支持
     */
    Boolean support(FareTypeEnum type);

    /**
     * 计算车费
     * @param distance 距离
     * @return 车费
     */
    int calculate(int distance);
}
