package bupt.edu.cn.jxy_hw4.Infor;

import java.util.Vector;

public class Table_Change {
    public static boolean checkValidAdd(Table table, Contact_Item infor){
        boolean isvalid = true;
        Vector<Contact_Item> list = table.getTableinfo();
        for (int i = 0; i < list.size() && isvalid; i++) {
            if (list.elementAt(i).getName().equals(infor.getName()))
                isvalid = false;
        }
        return isvalid;
    }

    // 更新指定元素
    public static boolean alterElem(Table table, Contact_Item infor) {
        int index = -1;
        Vector<Contact_Item> list = table.getTableinfo();
        for (int i = 0; i < list.size() && -1 == index; i++) {
            if (list.elementAt(i).getName().equals(infor.getName()))
                index = i;
        }

        if (index != -1) { //如果找到了 就替换该元素
            list.set(index, infor);
            return true;
        }
        else {
            return false;
        }
    }

    public static void deleteElem(Table table, int index) {
        table.getTableinfo().remove(index);
    }
}
