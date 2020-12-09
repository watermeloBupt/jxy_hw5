function del(elem) {
    let tr = elem.parentNode.parentNode
    let contactName = tr.children[0].innerHTML
    $.post('/del', {name: contactName}, sucdel(tr))
}

function sucdel(tr) {
    tr.parentNode.removeChild(tr)  // 在前端中删除这一行
}

function alter(elem) {
    let tr = elem.parentNode.parentNode
    let contactName = tr.children[0].innerHTML
    let row = elem.parentNode.parentNode.rowIndex - 1
    let temp = document.createElement("form")
    temp.action = "/alter"
    temp.method = "post"
    temp.style.display = "none"

    let opt = document.createElement("textarea")
    opt.name = "name"
    opt.value = contactName
    temp.appendChild(opt)
    document.body.appendChild(temp)

    temp.submit()
    return temp
}

function add(elem) {
    var form;
    form = $('<form />', {
        action: '/add',
        method: 'POST',
        style: 'display: none;'
    });
    form.appendTo('body').submit();
}