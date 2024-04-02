package cn.pangchun.patterns.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * ObjectStructure角色：员工业务报表
 * 
 * @author pangchun
 * @since 2023/10/19
 */
public class BusinessReport {

    private List<Staff> mStaffs = new LinkedList<>();

    public BusinessReport() {
        mStaffs.add(new Manager("王经理"));
        mStaffs.add(new Engineer("工程师-a"));
        mStaffs.add(new Engineer("工程师-b"));
        mStaffs.add(new Engineer("工程师-c"));
        mStaffs.add(new Engineer("工程师-d"));
    }

    /**
     * 为访问者展示报表
     * @param visitor 访问者
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffs) {
            staff.accept(visitor);
        }
    }
}
