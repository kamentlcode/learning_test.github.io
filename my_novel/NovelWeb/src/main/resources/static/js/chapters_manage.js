$(document).ready(
	function() {
		var url = location.search.substr(5).trim();
		$(show_chapters());

		// 显示本站推荐列表
		function show_chapters() {
			$("#chapter_title").empty();
			$("#htmlContent").empty();
			$.ajax({
				url: "chapter/select", // 请求地址
				data: {
					cId: url,
				},
				type: "get", // 请求方法					
				dataType: "json", // 返回数据类型
				success: function(data) { // 请求完成执行的方法
					var datas = eval(data.chapter);
					//标题
					var app_h = $("<h1></h1>").appendTo("#chapter_title");
					app_h.html(datas.cName);
					var str = datas.cContent;
					reg = new RegExp("\r\n\r\n","g");
					var newstr = str.replace(reg,"<br/>&nbsp;&nbsp;&nbsp;&nbsp;");
					//内容
					$("#htmlContent").html(newstr);

				}
				//success结束
			});
			//ajax结束
			//window.location.reload();
		};


	})