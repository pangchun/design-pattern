package cn.pangchun.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的迭代器：要记录当前位置下标
 *
 * @author pangchun
 * @since 2023/10/12
 */
public class ConcreteIterator<T> implements Iterator<T> {

    /**
     * 当前下标位置
     */
    private int cursor = 0;

    /**
     * 元素数组
     */
    private List<T> list = new ArrayList<>();

    /**
     * 构造迭代器的时候传入元素数组
     * @param list 元素数组
     */
    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        T obj = null;
        if (this.hasNext()) {
            obj = list.get(cursor++);
        }
        return obj;
    }
}
