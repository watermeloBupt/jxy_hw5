package bupt.edu.cn.jxy_hw4.Controller;

import bupt.edu.cn.jxy_hw4.Dao.UserJpaRepository;
import bupt.edu.cn.jxy_hw4.Infor.Contact_Item;
import bupt.edu.cn.jxy_hw4.Infor.Table;
import bupt.edu.cn.jxy_hw4.Infor.Table_Change;
import bupt.edu.cn.jxy_hw4.Infor.TypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Vector;

@Controller
public class ListController {
    // JPA
    @Autowired
    private UserJpaRepository userJpaRepository;


    @GetMapping("/list")
    public String showMain(HttpServletRequest request, Model model){
        Object flag = request.getSession().getAttribute("login");
        if(null != flag){
            List<Contact_Item> info = userJpaRepository.findAll();           // 获取持久层的数据
            Table t = new Table(TypeTransformer.listToVector(info));  // 类型转换
            model.addAttribute("table", t);
            return "contact_list";
        }
        else
            return "redirect:/login";
    }
    @PostMapping("/del")
    public String DeleteContact(@ModelAttribute(value = "name") String name, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            userJpaRepository.deleteByname(name);
            System.out.println(name);
            return "redirect:/list";
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/add_people")
    public String showAdd(Contact_Item cont, Model model, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            model.addAttribute("cont", cont);
            return "add_contact";
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/checkadd")
    public String checkAdd(Contact_Item cont, HttpServletRequest request, Model model) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            List<Contact_Item> list = userJpaRepository.findByname(cont.getName());
            if (0 == list.size()) {        //   没有重复的
                userJpaRepository.save(cont);
                return "redirect:/list";
            }  else {
                cont.setName("");
                return showAdd(cont, model, request);
            }
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/alter")
    public String showAlter(HttpServletRequest request, @ModelAttribute(name = "name") String name, Model model) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            model.addAttribute("cont", userJpaRepository.findByname(name).get(0));
            return "alter";
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/checkalter")
    public String checkAlter(Contact_Item infor, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            userJpaRepository.save(infor);
            return "redirect:/list";
        }
        else
            return "redirect:/login";
    }

    // ajax 检测电话号码 是否重复  有重复的返回1 没有重复的返回0
    @ResponseBody
    @PostMapping("/checkTelephone")
    public int checkTel(@RequestParam(name="telephone")String tel, HttpServletRequest request) {
        Table table = (Table)request.getSession().getAttribute("table");
        boolean result = false;
        for (int i = 0; i < userJpaRepository.findAll().size() && !result; i++) {
            if (userJpaRepository.findAll().get(i).getTel().equals(tel))
                result = true;
        }
        if (result)
            return 1;
        else
            return 0;
    }
}
