package bupt.edu.cn.jxy_hw4.Infor;

public class Contact_Item {
    private String name; // 联系人姓名

    private String tel;         // 联系人电话

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    private String email;       // 邮箱

    private String addr;        // 住址

    private String qq;          // qq号

    public Contact_Item(String name, String tel, String email, String addr, String qq){
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.qq = qq;
        this.addr = addr;
    }

}
