package cn.pangchun.patterns.iterator;

/**
 * 容器接口
 *
 * @author pangchun
 * @since 2023/10/12
 */
public interface Aggregate<T> {

    /**
     * 添加一个元素
     * @param t 元素对象
     */
    void add(T t);

    /**
     * 移除一个元素
     * @param t 元素对象
     */
    void remove(T t);

    /**
     * 获取迭代器
     * @return 迭代器对象
     */
    Iterator<T> iterator();
}
