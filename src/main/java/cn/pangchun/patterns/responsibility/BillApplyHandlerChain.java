package cn.pangchun.patterns.responsibility;

import cn.pangchun.patterns.responsibility.handler.BillApplyHandler;
import cn.pangchun.patterns.responsibility.request.BillApplyRequest;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;


/**
 * 统一请求入口
 * 
 * @author pangchun
 * @since 2023/10/8
 */
@Data
public class BillApplyHandlerChain {

    /**
     * 持有所有Handler
     */
    private final List<BillApplyHandler> handlers = Lists.newArrayList();

    /**
     * 添加handler
     * @param handler
     */
    public void addHandler(BillApplyHandler handler) {
        this.handlers.add(handler);
    }

    /**
     * 处理请求
     * @param request
     */
    public void process(BillApplyRequest request) {
        for (BillApplyHandler handler : handlers) {
            final Boolean flag = handler.process(request);
            if (null != flag) {
                break;
            }
        }
    }
}
