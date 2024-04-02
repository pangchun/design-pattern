package cn.pangchun.patterns.composite;

import java.util.List;

/**
 * 文件类
 * 
 * @author pangchun
 * @since 2023/10/24
 */
public class File extends Dir {
    public File(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        throw new UnsupportedOperationException("文件对象不支持此操作");
    }

    @Override
    public void rmDir(Dir dir) {
        throw new UnsupportedOperationException("文件对象不支持此操作");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("文件对象不支持此操作");
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    @Override
    public List<Dir> getFiles() {
        throw new UnsupportedOperationException("文件对象不支持此操作");
    }
}
