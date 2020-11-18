package bupt.edu.cn.jxy_hw4.Controller;

import bupt.edu.cn.jxy_hw4.Infor.Contact_Item;
import bupt.edu.cn.jxy_hw4.Infor.Table;
import bupt.edu.cn.jxy_hw4.Infor.Table_Change;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ListController {
    @GetMapping("/list")
    public String showMain(HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        if(null != flag){
            HttpSession session = request.getSession();
            if(null == session.getAttribute("table")){
                Table table = new Table();
                session.setAttribute("table", table);
            }
            return "contact_list";
        }
        else
            return "redirect:/login";
    }
    @PostMapping("/del")
    public String DeleteContact(@ModelAttribute(value="row")Integer row, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            Table t = (Table) request.getSession().getAttribute("table");
            Table_Change.deleteElem(t, row);
            System.out.println("删除！");
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
            Table t = (Table) request.getSession().getAttribute("table");
            boolean is_valid = Table_Change.checkValidAdd(t, cont);
            if (is_valid) {
                t.getTableinfo().addElement(cont);
                return "redirect:/list";
            } else {
                cont.setName("");
                return showAdd(cont, model, request);
            }
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/alter")
    public String showAlter(HttpServletRequest request, @ModelAttribute(value="row")Integer row, Contact_Item m, Model model) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            Table t = (Table) request.getSession().getAttribute("table");
            Contact_Item infor = t.getTableinfo().elementAt(row);
            model.addAttribute("cont", infor);
            return "alter";
        }
        else
            return "redirect:/login";
    }

    @PostMapping("/checkalter")
    public String checkAlter(Contact_Item infor, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag) {
            Table t = (Table) request.getSession().getAttribute("table");
            Table_Change.alterElem(t, infor);
            return "redirect:/list";
        }
        else
            return "redirect:/login";
    }
}
