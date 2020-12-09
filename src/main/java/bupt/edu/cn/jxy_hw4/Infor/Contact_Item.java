package bupt.edu.cn.jxy_hw4.Infor;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@Entity
@Table(name="contact")
public class Contact_Item{
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

    @Id                                               // 指定主键  请注意 字段名不能和sql语言的保留字一致，否则无法创建表格
    @Column(name = "name", length = 40)              // 指定持久化时该变量对应table中的字段名（可以不指定，则和变量名一致）
    private String name;                       // 联系人姓名

    @Column(name = "tel")                             // 同上 ，下同
    private String tel;                               // 联系人电话

    @Column(name = "email")
    private String email;                             // 邮箱

    @Column(name = "addr")
    private String addr;                              // 住址

    @Column(name = "qq")
    private String qq;                                // qq号


    public Contact_Item(String cont, String tel, String email, String addr, String qq) {
        this.name = cont;
        this.tel = tel;
        this.email = email;
        this.qq = qq;
        this.addr = addr;
    }

    public Contact_Item() {                           // 对于 Entity 实体类，必须存在默认构造函数
        this.name = "";
        this.tel = "";
        this.email = "";
        this.qq = "";
        this.addr = "";
    }

}
