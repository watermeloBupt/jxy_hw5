package bupt.edu.cn.jxy_hw4.Controller;

import bupt.edu.cn.jxy_hw4.Infor.Check_Log;
import bupt.edu.cn.jxy_hw4.Infor.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class LogController {
    @RequestMapping("/")
    public String login_(Log user, Model model){
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(Log user, Model model){
        model.addAttribute("user", user);
        return "log_in";
    }

    @PostMapping("/checklogin")
    public Object checkLogin(Log user, Model model, HttpServletRequest request) {
        if (Check_Log.Check(user)) {                        // 通过校验
            request.getSession().setAttribute("login", "OK");   // 设置标识
            return "redirect:/list";
        }
        else{                                                       // 没通过校验
            user.setPassword("");
            return login(user, model);
        }
    }


}
