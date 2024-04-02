package cn.pangchun.patterns.strategy.provider.impl;

import cn.pangchun.patterns.strategy.enums.FareTypeEnum;
import cn.pangchun.patterns.strategy.provider.FareDataProvider;
import org.springframework.stereotype.Component;

/**
 * 公交车车费计算策略实现
 *
 * @author pangchun
 * @since 2023/6/17
 */
@Component
public class BusFareProvider implements FareDataProvider {
    @Override
    public Boolean support(FareTypeEnum type) {
        return FareTypeEnum.BUS.equals(type);
    }

    @Override
    public int calculate(int distance) {
        // 公交1元/km
        return distance;
    }
}
