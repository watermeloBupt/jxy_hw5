package bupt.edu.cn.jxy_hw4.Infor;

public class Check_Log {
    public static boolean Check(Log log){
        if ("Admin".equals(log.getUsername()) && "123123".equals(log.getPassword()))
            return true;
        else
            return false;
    }
}
