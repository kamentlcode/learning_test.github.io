window.onload = function() {

}

function log() {
	var uname = $(".form_item1 #username").val();
	var upwd = $(".form_item1 #password").val();
	if(uname != "" && upwd != "") {
		$.post("user/login", {
			uname: uname,
			upassword: upwd
		}, function(data) {
			if(data.loginStatue > 0) {
				// 登录成功跳转到主页面
				location.href = "boke.html";
			} else if(data.loginStatue == 0) {
				// 登录失败
				alert("登录失败，密码错误");
			} else {
				alert("登录失败，用户不存在");
			}
		}, "json")
	} else {
		alert("用户名或密码不能为空");
	}
}
//切换到注册表单
function to_register() {
	$(".form_register").css({
		"height": "500px",
		"transition": "0.7s"
	});
	$(".form_login").css({
		"height": "0px",
		"transition": "0.7s"
	});
}

//切换到登录表单
function to_login() {
	$(".form_register").css({
		"height": "0px",
		"transition": "0.7s"
	});
	$(".form_login").css({
		"height": "500px",
		"transition": "0.7s"
	});
					// 清空输入框
//				$("#reusername").val(""); $("#repassword").val("");
//				$("#secondpassword").val(""); $("#nickName").val("");
}

// 判断鼠标离开姓名输入框时的内容
function name_change() {
	var name = document.getElementById("reusername").value;
	var nameValue = document.getElementById("cname");
	if(3 <= name.length && name.length <= 14) {
		nameValue.innerHTML = "";
	} else {
		nameValue.innerHTML = "请输入3-14个字符之间的用户名";
	}
}
// 判断鼠标离开密码输入框时的内容
function pwd_change() {
	var pwd = document.getElementById("repassword").value;
	var pwdValue = document.getElementById("cpwd");
	var test1 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,16}$/;
	if(test1.test(pwd)) {
		pwdValue.innerHTML = "";
	} else {
		pwdValue.innerHTML = "请输入合适的密码（6-12位数字和字母组合）";
	}
}
// 判断鼠标离开二次密码输入框时的内容
function repwd_change() {
	var pwd = document.getElementById("repassword").value;
	var repwd = document.getElementById("secondpassword").value;
	var repwdValue = document.getElementById("crepwd");
	if(pwd == repwd) {
		repwdValue.innerHTML = "";
	} else {
		repwdValue.innerHTML = "两次输入的密码不一致，请重新输入";
	}
}
// 判断鼠标离开昵称输入框时的内容
function nickName_change() {
	var nickNamev = document.getElementById("nickName").value;
	var nickNameValue = document.getElementById("cnickName");
	if(3 <= nickNamev.length && nickNamev.length <= 14) {
		nickNameValue.innerHTML = "";
	} else {
		nickNameValue.innerHTML = "请输入3-14个字符之间的昵称名";
	}
}

function code_change() {
	$("#ccode").text("");
}

function reg() {
	// 获取提示框的信息
	var reusername = $(".form_item #cname").text();
	var repwd = $(".form_item #cpwd").text();
	var repassword = $(".form_item #crepwd").text();
	var nickName = $(".form_item #cnickName").text();
	//	var email2 = $(".form_item #cemail").text();
	//	var tel = $(".form_item #ctel").text();
	// 获取用户输入的信息
	var uname = $(".form_item #reusername").val();
	var pas = $(".form_item #repassword").val();
	var repas = $(".form_item #secondpassword").val();
	var nickN = $(".form_item #nickName").val();
	//	var email1 = $(".form_item #email").val();
	//	var tele = $(".form_item #tel").val();
	//	var code = $("#code").val();
	/*console.log(uname);
	console.log(pas);
	console.log(repas);
	console.log(nickN);
	console.log(email1);
	console.log(tele);*/
	if(uname != "" && pas != "" && nickN != "" && repas != "" &&
		reusername == "" && repwd == "" && repassword == "" && nickName == "") {
		$.post("user/register", {
			uname: uname,
			upassword: pas,
			phone: tele,
			nickName: nickN,
			email: email1,
			code: code
		}, function(data) {
			if(data.eCode == 0) {
				$("#ccode").text("验证码输入错误");
			}
			if(data.registerStatue == 1) {
				$(".form_register").css({
					"height": "0px",
					"transition": "0.7s"
				});
				$(".form_login").css({
					"height": "500px",
					"transition": "0.7s"
				});
				/*
				 * $("#reusername").val(""); $("#repassword").val("");
				 * $("#secondpassword").val(""); $("#nickName").val("");
				 * $("#email").val(""); $("#tel").val("");
				 */
			} else if(data.registerStatue == 0) {
				alert("注册失败");
			} else if(data.registerStatue == -1) {
				alert("用户名已被注册，请重试");
			}
		}, "json")
	} else {
		alert("请输入正确的注册信息");
	}
}
$(function() {
	if($.cookie("total") != undefined && $.cookie("total") != 'NaN' && $.cookie("total") != 'null') {
		timekeeping();
		// cookie没有到技术
	} else {
		$('#sendBut').text('发送验证码');
	}

	function timekeeping() {
		// 从cookie中读取剩余倒计时
		total = $.cookie("total");
		// 把按钮设置为不可点击
		$('#sendBut').addClass('notclick');
		// 在发送按钮显示剩余倒计时
		$('#sendBut').text(total + '秒后可重新获取');
		// 设置样式
		$('#sendBut').css({
			background: '#d8d8d8',
			color: '#707070',
		});
		// 每秒读取一次cookie
		var interval = setInterval(function() {
			// 设置时间
			total--;
			// 在发送按钮显示剩余倒计时
			$('#sendBut').text(total + '秒后可重新获取');
			//剩余倒计时为零，则显示 重新发送，可点击
			if(total == 0) {
				//清除定时器
				clearInterval(interval);
				//删除cookie
				total = $.cookie("total", total, {
					expires: -1
				});
				//显示重新发送
				$('#sendBut').text('重新发送').removeClass('notclick');
				// 设置样式
				$('#sendBut').css({
					background: '#ff9400',
					color: '#fff',
				});
				//剩余倒计时不为零
			} else {
				//重新写入总倒计时
				$.cookie("total", total);
			}
		}, 1000);
	}
	// 点击事件
	$('#sendBut').click(function() {
		// email地址
		var getEmail = $("#email").val();
		// 提示信息
		var email2 = $(".form_item #cemail").text();
		if(getEmail == '' || email2 != '') {
			alert("请输入正确的邮箱格式");
			return this;
		}
		$.cookie("total", 60);
		timekeeping();
		// 请求后台
		$.ajax({
				url: '/user/sendCode',
				type: 'post',
				dataType: 'json',
				data: {
					email: getEmail
				},
			})
			.done(function(re) {
				console.log(re);
				/*if(re){
		        $.cookie("total",60);
		        timekeeping();
			}*/
			})
	});
})