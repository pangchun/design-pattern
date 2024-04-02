package cn.pangchun.patterns.iterator;

/**
 * 迭代器接口
 * 
 * @author pangchun
 * @since 2023/10/12
 */
public interface Iterator<T> {

    /**
     * 是否还有下一个元素
     * @return true表示有，false表示没有
     */
    boolean hasNext();

    /**
     * 返回当前位置元素并将位置移至下一位
     * @return 当前位置的元素
     */
    T next();
}
