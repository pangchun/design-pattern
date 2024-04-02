package cn.pangchun.patterns.strategy.provider.impl;

import cn.pangchun.patterns.strategy.enums.FareTypeEnum;
import cn.pangchun.patterns.strategy.provider.FareDataProvider;
import org.springframework.stereotype.Component;

/**
 * 地铁车费计算策略实现
 *
 * @author pangchun
 * @since 2023/6/17
 */
@Component
public class SubwayFareProvider implements FareDataProvider {
    @Override
    public Boolean support(FareTypeEnum type) {
        return FareTypeEnum.SUBWAY.equals(type);
    }

    @Override
    public int calculate(int distance) {
        // 地铁2元/km
        return distance * 2;
    }
}
