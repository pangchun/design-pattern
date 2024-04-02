package cn.pangchun.patterns.proxy;

/**
 * 诉讼接口类
 * 
 * @author pangchun
 * @since 2023/10/25
 */
public interface ILawsuit {
    /**
     * 提交申请
     */
    void submit();

    /**
     * 进行举证
     */
    void burden();

    /**
     * 开始辩护
     */
    void defend();

    /**
     * 诉讼完成
     */
    void finish();
}
