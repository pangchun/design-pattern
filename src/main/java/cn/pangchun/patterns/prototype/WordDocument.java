package cn.pangchun.patterns.prototype;

import lombok.Data;

import java.util.ArrayList;

/**
 * 原型模式-浅拷贝/深拷贝
 *
 * @author pangchun
 * @since 2023/10/19
 */
@Data
public class WordDocument implements Cloneable {

    /**
     * 文本
     */
    private String text;

    /**
     * 图片集合，List是引用类型，浅拷贝时，在克隆对象上的修改会反映在原型对象上
     */
    private ArrayList<String> mImages = new ArrayList<>();

    /*
     * 浅拷贝
    @Override
    public WordDocument clone() {
        try {
            final WordDocument doc = (WordDocument) super.clone();
            doc.text = text;
            doc.mImages = mImages;
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    */


    /**
     * 深拷贝
     */
    @SuppressWarnings("all")
    @Override
    public WordDocument clone() {
        try {
            final WordDocument doc = (WordDocument) super.clone();
            doc.text = text;
            // 对mImages对象也执行clone()函数，执行深拷贝
            doc.mImages = (ArrayList<String>) this.mImages.clone();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加图片
     * @param img 图片
     */
    public void addImage(String img) {
        mImages.add(img);
    }

    /**
     * 展示文档内容
     */
    public void showDocument() {
        System.out.println("---------- document start -------------");
        System.out.println("text = " + text);
        System.out.println("Images List: ");
        for (String mImage : mImages) {
            System.out.println("image name: " + mImage);
        }
        System.out.println("---------- document end -------------");
    }
}
