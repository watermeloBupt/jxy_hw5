package bupt.edu.cn.jxy_hw4.Infor;

import java.util.Vector;

public class Table {
    private Vector<Contact_Item> tableinfo;

    public Vector<Contact_Item> getTableinfo() {
        return tableinfo;
    }

    public void setTableinfo(Vector<Contact_Item> tableinfo) {
        this.tableinfo = tableinfo;
    }

    public Table() {
        tableinfo = new Vector<Contact_Item>();
        tableinfo.add(new Contact_Item("Tanmay", "15980740510", "542140922@qq.com"
                , "北京", "542140922"));
        tableinfo.add(new Contact_Item("Sachin", "18065124560", "jxy_watermelo@163.com"
                , "福建", "304498473"));
        tableinfo.add(new Contact_Item("Uma", "13311566452", "sddd@bupt.edu"
                , "北京", "151255123"));
    }
}