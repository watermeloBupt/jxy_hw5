window.onload=function() {
    var btn1 = document.getElementById("submit");
    btn1.onclick = function checkForm1() {
        var name = document.getElementById("name");
        if (name.value === "") {
            alert("请输入姓名！");
            return false;
        } else {
            var add = document.getElementById("Address");
            var tel = document.getElementById("telephone");
            var telreg = /^[1]([3-9])[0-9]{9}$/;
            if (telreg.test(tel.value) === false) {
                alert("手机号码输入错误！");
                return false;
            } else {
                var email = document.getElementById("Email");
                var emreg = /^\w{3,}(\.\w+)*@[A-z0-9]+(\.[A-z]{2,5}){1,2}$/;
                if (emreg.test(email.value) === false) {
                    alert("邮箱输入错误！");
                    return false;
                } else {
                    if (add.value === "") {
                        alert("请输入地址！")
                        return false;
                    } else {
                        var qq_num = document.getElementById("QQ_num");
                        var qqreg = /^\s*[.0-9]{5,11}\s*$/;
                        if (qqreg.test(qq_num.value) === false) {
                            alert("QQ输入错误！");
                            return false;
                        } else {
                            alert("修改联系人成功！")
                            return true;
                        }
                    }
                }
            }
        }
    }
}