/** ***************验证码******************** */
function _change() {
	var $img = $("#verifyCode");
	$img.attr("src", "VerifyCodeServlet" + "?verfiyCodeTemp="
			+ new Date().getTime());
}

window.onload = function() {
	rightPage();
	loginPage();
	registPage();
};

/**
 * 网页右侧
 * 
 * @returns
 */
function rightPage() {
	/** ***************购物车******************** */
	ajax({
		url : "CartAjaxServlet?method=getCarMessage",
		callback : function(data) {
			document.getElementById("cartBookNumber").innerText = data.bookNumber;
			document.getElementById("cartTotalMoney").innerText = data.totalMoney;
		},
		type : "json"
	});

	/** ***************图书分类******************** */
	ajax({
		url : "CategoryAjaxServlet?method=findAll",
		callback : function(CategoryArray) {

			var clategoryUl = document.getElementById("clategoryUl");

			for ( var i in CategoryArray) {
				var li = document.createElement("li");

				var a = document.createElement("a");
				var url = "BookServlet?method=findByCategory&cid="
						+ CategoryArray[i].cid;
				a.setAttribute("href", url);
				a.text = CategoryArray[i].cname;

				li.appendChild(a);
				clategoryUl.appendChild(li);
			}
		},
		type : "json"
	});
}

/**
 * 登录页面
 * 
 * @returns
 */
function loginPage() {
	$("#username").blur(function() {
		$("#usernameVerify").html("");

		var username = $.trim($("#username").val());
		if (username == "") {
			$("#usernameVerify").html("用户名不能为空！");
			return;
		}

		ajax({
			url : "UserAjaxServlet?method=checkUsername&username=" + username,
			callback : function(data) {
				$("#usernameVerify").html("");
				$("#usernameVerify").html(data);
				if (data == "true") {
					$("#usernameVerify").html("√");
				} else if (data == "false") {
					$("#usernameVerify").html("用户名不存在");
				}
			}
		});
	});
}

/**
 * 注册页面
 * 
 * @returns
 */
function registPage() {
	$("#usernameRe").blur(function() {
		$("#usernameVerify").html("");

		var username = $.trim($("#usernameRe").val());
		if (username == "") {
			$("#usernameVerify").html("用户名不能为空！");
			return;
		}

		ajax({
			url : "UserAjaxServlet?method=checkUsername&username=" + username,
			callback : function(data) {
				if (data == "true") {
					$("#usernameVerify").html("用户名已存在！");
				} else if (data == "false") {
					$("#usernameVerify").html("√");
				}
			}
		});
	});

	$("#email").blur(function() {
		$("#emailVerify").html("");

		var email = $.trim($("#email").val());
		if (email == "") {
			$("#emailVerify").html("邮箱不能为空！");
			return;
		}

		ajax({
			url : "UserAjaxServlet?method=checkEmail&email=" + email,
			callback : function(data) {

				if (data == "true") {
					$("#emailVerify").html("邮箱已存在！");
				} else if (data == "false") {
					$("#emailVerify").html("√");
				}
			}
		});
	});

}