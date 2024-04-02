package cn.pangchun.patterns.responsibility.handler;


import cn.pangchun.patterns.responsibility.request.BillApplyRequest;

/**
 * 处理者角色
 *
 * @author pangchun
 * @since 2023/10/8
 */
public interface BillApplyHandler {

    /**
     * 判断可否处理本次请求
     *
     * @param req 请求对象
     * @return 返回判断结果(false-无法处理)
     */
    Boolean support(BillApplyRequest req);

    /**
     * 处理请求
     *
     * @param req 请求对象
     * @return 返回处理结果(true-通过/false-拒绝/null-无法处理，转交给下一个处理者)
     */
    Boolean process(BillApplyRequest req);
}
