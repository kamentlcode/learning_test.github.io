$(document).ready(function() {
	/* 隐藏其他内容 */
//	$("#themsg_04_02").hide();
	
	
	

	$("#themsg_04_01").show();
	// console.log(1);
	// 显示所有营收信息
	$(show_allsales());

	// 显示所有营收信息
	function show_allsales() {
		$("#allsales_msg>tr").remove();

		// 执行ajax
		$.ajax({
			url : "getAllSales.do",// 请求地址
			type : "POST",// 请求方法
			dataType : "json",// 返回数据类型
			success : function(data) {// 请求完成执行的方法

				// 遍历list创建内容
				$.each(data, function(i, list) {

					// 创建一个tr放在tbody最后面
					var apptr = $("<tr>").appendTo("#allsales_msg");
					// 在tr里添加一个td1
					var apptrtd_1 = $("<td>").appendTo($(apptr));
					// 添加营收编号
					apptrtd_1.html(list.sid);
					// 在tr里添加一个td2
					var apptrtd_2 = $("<td>").appendTo($(apptr));
					// 添加会每日日期
					apptrtd_2.html(list.formatsdate);
					// 在tr里添加一个td3
					var apptrtd_3 = $("<td>").appendTo($(apptr));
					// 添加每日完成车次
					apptrtd_3.html(list.scars);
					// 在tr里添加一个td4
					var apptrtd_4 = $("<td>").appendTo($(apptr));
					// 添加每日收费标准
					apptrtd_4.html(list.sprice + "元/小时");
					// 在tr里添加一个td5
					var apptrtd_5 = $("<td>").appendTo($(apptr));
					// 添加每日营收
					apptrtd_5.html(list.ssal + "元");

				});

			}
		});

	}
	// 显示最近五条收费标准改动的方法
	function show_5sales() {
		$("#5sales_msg>tr").remove();
		// 执行ajax
		$.ajax({
			url : "getFiveSales.do",// 请求地址
			type : "POST",// 请求方法
			dataType : "json",// 返回数据类型
			success : function(data) {// 请求完成执行的方法
				// 遍历list创建内容
				$.each(data, function(i, list) {

					// 创建一个tr放在tbody最后面
					var apptr = $("<tr>").appendTo("#5sales_msg");
					// 在tr里添加一个td1
					var apptrtd_1 = $("<td>").appendTo($(apptr));
					// 添加营收编号
					apptrtd_1.html(list.sid);
					// 在tr里添加一个td2
					var apptrtd_2 = $("<td>").appendTo($(apptr));
					// 添加会收费标准
					apptrtd_2.html(list.sprice + "元/小时");
					// 在tr里添加一个td3
					var apptrtd_3 = $("<td>").appendTo($(apptr));
					// 添加修改时间
					apptrtd_3.html(list.formatsdate);

				});
			}
		});
	}
	;

	// 侧边栏1
	$("#left_04_01").click(function() {
		$("#themsg_04_02").hide();
		
		$("#themsg_04_01").show();
		
		// 显示所有营收信息
		$(show_allsales());

	});
	// 侧边栏2
	$("#left_04_02").click(function() {
		$("#themsg_04_01").hide();
	
		$("#themsg_04_02").show();
		$("#new_money").hide();

		// 显示最近五条收费标准改动
		$(show_5sales());
		//修改栏
		$(sprice_manager());
		
//		获取今日收费标准
		$.ajax({
			url : "getSalesToday.do",// 请求地址
			type : "POST",// 请求方法
			
			dataType : "json",// 返回数据类型
			success : function(data) {// 请求完成执行的方法						
				console.log(data.sprice);
				$("#now_money").html(data.sprice);
			}					
		});	
		

	});
	
	
//	查询
	$("#select_one").click(function() {
//		清空之前的创建
		$("#onesales_msg>tr").remove();
		
		var todayv=$("#input_time").val();
		console.log(todayv);
		$.ajax({
			url : "getSalesMsgByTime.do",// 请求地址
			type : "POST",// 请求方法
			data : {
				today : todayv
			},
			dataType : "json",// 返回数据类型
			success : function(data) {// 请求完成执行的方法
				console.log(data);
//				// 创建一个tr放在tbody最后面
//				var apptr = $("<tr>").appendTo("#onesales_msg");
//				// 在tr里添加一个td1
//				var apptrtd_1 = $("<td>").appendTo($(apptr));
//				// 添加营收编号
//				apptrtd_1.html(data.sid);
//				// 在tr里添加一个td2
//				var apptrtd_2 = $("<td>").appendTo($(apptr));
//				// 添加会每日日期
//				apptrtd_2.html(data.formatsdate);
//				// 在tr里添加一个td3
//				var apptrtd_3 = $("<td>").appendTo($(apptr));
//				// 添加每日完成车次
//				apptrtd_3.html(data.scars);
//				// 在tr里添加一个td4
//				var apptrtd_4 = $("<td>").appendTo($(apptr));
//				// 添加每日收费标准
//				apptrtd_4.html(data.sprice + "元/小时");
//				// 在tr里添加一个td5
//				var apptrtd_5 = $("<td>").appendTo($(apptr));
//				// 添加每日营收
//				apptrtd_5.html(data.ssal + "元");
				if(data.sid==0){
					alert("没有当日的营收信息");
				}else {
					$("#in_msg01").html(data.sid);
					$("#in_msg02").html(data.formatsdate);
					$("#in_msg03").html(data.scars);
					$("#in_msg04").html(data.sprice+ "元/小时");				
					$("#in_msg05").html(data.ssal + "元");					
					$('#myModal').modal('show');
				}
				
				
				
			}
		});

	});

	// 收费管理的方法
	function sprice_manager() {
//		点击修改
		$("#now_money_button").click(function() {
			// 聚焦到收费标准输入框
			$("#now_money").trigger("focus");
			
			

		});
		
		
	
		

	};
	
	
	
//	点击确定
	$("#now_money_active").click(function() {
		var sprice=$("#now_money").text();
		console.log(sprice);
		console.log(666666666);
		//更新的ajax
		$.ajax({
			url : "updateSprice.do",// 请求地址
			type : "POST",// 请求方法
			 data : {				
				 sprice : sprice,				
			},  
			dataType : "json",// 返回数据类型
			success : function(data) {// 请求完成执行的方法
				console.log(data);	
				alert("修改成功");
			}
			
		});
		$(show_5sales());
	});
	
	
	
	
	
	

})