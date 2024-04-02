package cn.pangchun.patterns.composite;

import java.util.Iterator;
import java.util.List;

/**
 * 文件夹类
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class Folder extends Dir {
    public Folder(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        dirs.add(dir);
    }

    @Override
    public void rmDir(Dir dir) {
        dirs.remove(dir);
    }

    @Override
    public void clear() {
        dirs.clear();
    }

    @Override
    public void print() {
        System.out.println(getName() + "(");
        final Iterator<Dir> iterator = dirs.iterator();
        while (iterator.hasNext()) {
            final Dir dir = iterator.next();
            dir.print();
            if (iterator.hasNext()) {
                System.out.println(", ");
            }
        }
        System.out.println(")");
    }

    @Override
    public List<Dir> getFiles() {
        return dirs;
    }
}
