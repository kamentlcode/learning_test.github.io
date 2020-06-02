$(document).ready(
	function() {
		var url = location.search.substr(5).trim();
		$(show_recommend());
		$(show_chapters('1'));
		$("#review").hide();
		
		$("#click_c").on("click", function() {
			$("#review").hide();
			$("#chapters").show();
		});
		
		$("#click_r").on("click", function() {

			$("#chapters").hide();
			$("#review").show();
		});
		
		//小说详情
		function show_recommend() {
			$("#book_messge_simple1").empty();
			$("#book_messge_simple2").empty();
			$.ajax({
				url: "novel/getById", // 请求地址
				data: {
					nId: url,
				},
				type: "get", // 请求方法					
				dataType: "json", // 返回数据类型
				success: function(data) { // 请求完成执行的方法
					var datas = eval(data.novel);
					var chapter = eval(data.chapter);

					//					var ol_1 = $("<ol></ol>").addClass("breadcrumb hidden-xs").
					//					appendTo("#book_messge");
					//					alert(datas.nName);

					var li_1 = $("<li>首页</li>").
					appendTo("#book_messge_simple1");
					var li_2 = $("<li></li>").
					appendTo($(book_messge_simple1));
					li_2.html(datas.nType + "小说");
					var li_3 = $("<li></li>").addClass("active").
					appendTo($(book_messge_simple1));
					li_3.html(datas.nName);

					var div_1_1 = $("<div></div>").addClass("panel-body").
					appendTo("#book_messge_simple2");

					var div_1_1_1 = $("<div></div>").addClass("row").
					appendTo($(div_1_1));

					var div_1_1_1_1 = $("<div></div>").addClass("col-md-2 col-xs-4 hidden-xs").
					appendTo($(div_1_1_1));

					var div_1_1_1_1_img1 = $("<img style='margin:0 5px 0 0'>").
					appendTo($(div_1_1_1_1));
					div_1_1_1_1_img1.attr("src", datas.nTest01);

					//col-md-10
					var div_1_1_1_2 = $("<div></div>").addClass("col-md-10").
					appendTo($(div_1_1_1));

					var div_1_1_1_2_h1 = $("<h1></h1>").addClass("bookTitle").appendTo($(div_1_1_1_2));
					div_1_1_1_2_h1.html(datas.nName);

					var div_1_1_1_2_p1 = $("<p></p>").addClass("booktag").appendTo($(div_1_1_1_2));
					var div_1_1_1_2_p1_sp1 = $("<span></span>").addClass("red").appendTo($(div_1_1_1_2_p1));
					div_1_1_1_2_p1_sp1.html(datas.nAuthor);
					var div_1_1_1_2_p1_sp2 = $("<span></span>").addClass("yellow").appendTo($(div_1_1_1_2_p1));
					div_1_1_1_2_p1_sp2.html(datas.nType);
					var div_1_1_1_2_p1_sp3 = $("<span></span>").addClass("blue").appendTo($(div_1_1_1_2_p1));
					div_1_1_1_2_p1_sp3.html("总字数：8098976");
					var div_1_1_1_2_p1_sp4 = $("<span></span>").addClass("blue").appendTo($(div_1_1_1_2_p1));
					div_1_1_1_2_p1_sp4.html("收藏数：188");
					var div_1_1_1_2_p1_sp5 = $("<span></span>").addClass("blue").appendTo($(div_1_1_1_2_p1));
					div_1_1_1_2_p1_sp5.html("热度：18960");
					//最新章节
					var div_1_1_1_2_p2 = $("<p>最新章节： </p>").appendTo($(div_1_1_1_2));

					var div_1_1_1_2_p2_a = $("<a></a>").appendTo($(div_1_1_1_2_p2));
					div_1_1_1_2_p2_a.html(chapter.cName);
					// 添加点击超链接到小说章节详情页面
					div_1_1_1_2_p2_a.click(function() {
						location.href = "chapter.html?cId=" + chapter.cId;
					});

					//加入书架和简介
					var div_1_1_1_2_d1 = $("<div></div>").addClass("row").
					appendTo($(div_1_1_1_2));

					var div_1_1_1_2_d1_sp1 = $("<span></span>").addClass("col-md-8").
					appendTo($(div_1_1_1_2_d1));

					var div_1_1_1_2_d1_sp1_bt1 = $("<button type='button'>加入书架</button>").addClass("btn btn-success").
					appendTo($(div_1_1_1_2_d1_sp1));

					var div_1_1_1_2_d1_c = $("<div></div>").addClass("clear").
					appendTo($(div_1_1_1_2_d1));

					var div_1_1_1_2_hr = $("<hr />").appendTo($(div_1_1_1_2));

					//简介
					var div_1_1_1_2_p2 = $("<p></p>").addClass("text-muted").appendTo($(div_1_1_1_2));
					var str = datas.nIntro;
					reg = new RegExp("r\n", "g");
					var newstr = str.replace(reg, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;");
					div_1_1_1_2_p2.html(newstr);
					var div_1_1_1_2_c = $("<div></div>").addClass("clear").
					appendTo($(div_1_1_1_2));

				}
				//success结束
			});
			//ajax结束
			//window.location.reload();
		};
		//小说章节列表
		function show_chapters(pageNum) {
			$("#chapters").empty();
			$.ajax({
				url: "chapter/page", // 请求地址
				data: {
					pageNum: pageNum,
					pageSize: 300,
					nId: url,
				},
				type: "get", // 请求方法					
				dataType: "json", // 返回数据类型
				success: function(data) { // 请求完成执行的方法
					//遍历list创建内容
					var list = eval(data.chapters.list);

					$.each(list, function(i, n) {

						//创建dd
						var appdd = $("<dd></dd>").addClass("col-md-3").appendTo("#chapters");
						var appdd_a = $("<a></a>").appendTo(appdd);
						appdd_a.html(n.cName);

						// 添加点击超链接到小说章节详情页面
						appdd_a.click(function() {
							location.href = "chapter.html?cId=" + n.cId;
						});

					});
					//each结束
					$("#pager").zPager({
						totalData: data.chapters.total,
						pageData: data.chapters.pageSize,
						htmlBox: $('#wraper'),
						btnShow: true,
						ajaxSetData: false
					});

				}
				//success结束
			});
			//ajax结束
			//window.location.reload();
		};

	});

function currentPage(currentPage) {
	/*
		触发页码数位置： Page/js/jquery.z-pager.js 64行
	*/
	console.log("当前页码数：" + currentPage);
	//$(page_chapters(currentPage));
};