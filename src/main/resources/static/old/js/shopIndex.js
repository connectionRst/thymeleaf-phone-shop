var url =window.location.href;


function share(phone) {
  var q = qrcode.clear(); // clear the code.
  var path = url.split("/");
  var realPath = "";
  for (var i = 0; i < 3; i++) {
    realPath += path[i] + "/";
  }
  realPath += "singleShop/"+phone;
  qrcode.makeCode(realPath);
}
function collect(pid) {
  $.ajax({
    url: "/collect",
    type: "post",
    data: {
      pid: pid
    },
    dataType: "json",
    success: function (result) {
      if (result) {
        showMsg('添加收藏夹成功！', 'top', 'successful');
      } else {
        showMsg('账号没登录，请登录！', 'top', 'error');
      }
    },
    error: function (result) {
      console.log(0)
    }
  });
}

function indent(pid) {
  $.ajax({
    url: "/indent",
    type: "post",
    data: {
      pid: pid
    },
    dataType: "json",
    success: function (result) {
      if (result) {
        showMsg('添加收藏夹成功！', 'top', 'successful');
      } else {
        showMsg('账号没登录，请登录！', 'top', 'error');
      }
    },
    error: function (result) {
      console.log(0)
    }
  });
}