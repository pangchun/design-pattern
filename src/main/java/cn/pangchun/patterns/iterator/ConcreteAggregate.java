package cn.pangchun.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的容器
 *
 * @author pangchun
 * @since 2023/10/12
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

    private final List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<>(list);
    }
}
