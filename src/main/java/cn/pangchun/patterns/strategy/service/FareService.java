package cn.pangchun.patterns.strategy.service;

import cn.pangchun.patterns.strategy.enums.FareTypeEnum;
import cn.pangchun.patterns.strategy.provider.FareDataProvider;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 车费service
 *
 * @author pangchun
 * @since 2023/6/17
 */
@Service
public class FareService {

    @Resource
    private List<FareDataProvider> fareDataProviders;

    /**
     * Spring应用上下文环境
     */
    @Resource
    private ApplicationContext applicationContext;

    @SneakyThrows
    public int calculate(FareTypeEnum type, int distance) {
        // 这里使用for循环去调了每个策略实现类的support方法，当返回true时就去调计算车费的方法 (这里获取所有bean可以使用hutool工具提供的SpringUtil.getBeansOfType方法，原理是一样的)
        for (FareDataProvider provider : applicationContext.getBeansOfType(FareDataProvider.class).values()) {
            if (provider.support(type)) {
                return provider.calculate(distance);
            }
        }

        /* 获取所有bean也可以使用@Autowired注解注入的方式
        for (FareDataProvider provider : fareDataProviders) {
            if (provider.support(type)) {
                return provider.calculate(distance);
            }
        }
        */

        throw new Exception("未查询到对应的策略");
    }
}
