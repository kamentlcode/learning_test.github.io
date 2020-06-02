$(document).ready(
	function() {

		$(show_recommend());
		// 显示本站推荐列表
		function show_recommend() {
			$("#my_recommend").empty();

			$.ajax({
				url: "bookrack/page", // 请求地址
				data: {
				pageNum: 1,
				pageSize: 1,
				uId:1588650376,
				bName:"站长推荐",
				},
				type: "get", // 请求方法					
				dataType: "json", // 返回数据类型
				success: function(data) { // 请求完成执行的方法
					//遍历list创建内容
					var list1 = eval(data.Bookracks.list);
					var list = list1[0].brNovels;
					$.each(list, function(i, n) {

						// 创建一个div1
						var appdiv_1 = $("<div>").addClass("col-md-3 col-xs-6 mb10 mt10").
						appendTo("#my_recommend");
						
						// 添加点击超链接到小说详情页面
							appdiv_1.click(function(){
								location.href="book.html?nId="+n.nId;
							});

						// 在div1里添加一个a
						var appdiv1_a = $("<a title=n.nName>").addClass("thumbnail").appendTo($(appdiv_1));
					
						// 在a里添加一个img				
						var appdiv1_a_img = $("<img style='height:182px'>").appendTo($(appdiv1_a));
						appdiv1_a_img.attr("src",n.nTest01);
						// 在a里添加一个div2
						var appdiv1_a_div2 = $("<div>").addClass("caption").appendTo($(appdiv1_a));

						// 在div2里添加一个strong 书名
						var appdiv1_a_div2_strong = $("<strong>").appendTo($(appdiv1_a_div2));
						appdiv1_a_div2_strong.html(n.nName);
						// 换行
						$("<br />").appendTo($(appdiv1_a_div2));

						// 在div2里添加一个span1
						var appdiv1_a_div2_span1 = $("<span>").addClass("text-muted fs-12").
						appendTo($(appdiv1_a_div2));
						// 添加作者
						appdiv1_a_div2_span1.html(n.nAuthor + " / 著");
						// 换行
						$("<br />").appendTo($(appdiv1_a_div2));
						// 在div2里添加一个span2
						var appdiv1_a_div2_span2 = $("<span>").addClass("text-warning fs-12").
						appendTo($(appdiv1_a_div2));
						// 添加收藏数
						
						
						appdiv1_a_div2_span2.html(n.nId-1588748600 + "人已收藏");


					});
   
				}
				//success结束
			});
			//ajax结束
			//window.location.reload();
		};
	})