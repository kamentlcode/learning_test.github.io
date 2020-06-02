$(document).ready(
		function() {
			/* 隐藏其他内容 */
//			$("#themsg_03_02").hide();
//			$("#themsg_03_03").hide();
			$("#themsg_03_01").show();

			$(show_allvip());
			// 显示所有会员信息
			function show_allvip() {
				//$("#allvip_msg>tr").remove();
				$.ajax({
					url : "getAllVipusers.do",// 请求地址
					type : "POST",// 请求方法					
					dataType : "json",// 返回数据类型
					success : function(data) {// 请求完成执行的方法
						//console.log(data);
						// 遍历list创建内容
						$.each(data, function(i, list) {
							// 创建一个tr放在tbody最后面
							var apptr = $("<tr>").appendTo("#allvip_msg");
							// 在tr里添加一个td1
							var apptrtd_1 = $("<td>").appendTo($(apptr));
							// 添加会员编号
							apptrtd_1.html(list.vid);
							// 在tr里添加一个td2
							var apptrtd_2 = $("<td>").appendTo($(apptr));
							// 添加会员名称
							apptrtd_2.html(list.vname);
							// 在tr里添加一个td3
							var apptrtd_3 = $("<td>").appendTo($(apptr));
							// 添加会员车牌
							apptrtd_3.html(list.cnumber);
							// 在tr里添加一个td4
							var apptrtd_4 = $("<td>").appendTo($(apptr));
							// 添加会员余额
							apptrtd_4.html(list.vbalance+"元");
							// 在tr里添加一个td5
							var apptrtd_5 = $("<td>").addClass("del_vip")
									.appendTo($(apptr));
							// 在td5中添加删除按钮
							var apptrtd_5_button = $("<button>").addClass(
									"btn btn-danger").appendTo($(apptrtd_5));
							// 给button赋值
							apptrtd_5_button.html("删除会员");

							// 获取会员名称
							var delcnumberv = apptrtd_3.html();
							//console.log(delcnumberv);
							apptrtd_5_button.click(
							// 根据名称删除会员
							function del() {
								// 执行ajax请求
								$.ajax({
									url : "delVipusersByCarnumber.do",// 请求地址
									type : "POST",// 请求方法
									data : {
										cnumber : delcnumberv
									},
									dataType : "json",// 返回数据类型
									success : function(data) {// 请求完成执行的方法
										console.log(data);
										if (data > 0) {
											alert("删除成功");
											window.location.reload();
										} else {
											alert("删除失败");
										}
									}
								});

							});
						
						});
						
					}
				});
				//window.location.reload();
			}

			// 侧边栏1
			$("#left_03_01").click(function() {
				$("#themsg_03_02").hide();
				$("#themsg_03_03").hide();

				$("#themsg_03_01").show();
				//window.location.reload();
				$(show_allvip());

			});
			// 侧边栏2
			$("#left_03_02").click(function() {

				$("#themsg_03_01").hide();
				$("#themsg_03_03").hide();
				$("#themsg_03_02").show();

			});
			// 侧边栏3
			$("#left_03_03").click(function() {
				$("#themsg_03_01").hide();
				$("#themsg_03_02").hide();
				$("#themsg_03_03").show();

			});

			// 注册会员
			$("#insertvip").click(function() {
				// 创建对象,并赋值
				var newvip_namev = $("#newvip_name").val();
				var newvip_carnum = $("#newvip_carnum").val();
				var newvip_money = $("#newvip_money").val();
				// 执行ajax请求
				$.ajax({
					url : "insVipUsers.do",// 请求地址
					type : "POST",// 请求方法
					data : {
						vname : newvip_namev,
						cnumber : newvip_carnum,
						vbalance : newvip_money
					},
					dataType : "json",// 返回数据类型

					success : function(data) {// 请求完成执行的方法
						console.log(data);
						if (data > 0) {
							alert("注册成功");
						} else {
							alert("注册失败");
						}
					}
				});

			});
			
			
//			会员充值
			$("#vip_button").click(function() {
				// 定义变量
				var vipname = $("#vip_name_1").val();
				var vipmoney = $("#vip_money_1").val();
				var vipcarnum = $("#vip_carnum_1").val();
				
				// 执行ajax请求
				$.ajax({
					url : "getVipRecharge.do",// 请求地址
					type : "POST",// 请求方法
					data : {
						vipname : vipname,
						vipmoney: vipmoney,
						vipcarnum:vipcarnum,
						
					},
					dataType : "json",// 返回数据类型
					
					success : function(data) {
						//判断输入值是否在数据库中
						if(data.vbalance==0){
							//不是 则返回弹窗提示重新输入
							alert("该账户不是会员或会员姓名和注册车牌号不符合，请重新输入")
						}else{
							//是的话则提示会员信息并且显示充值完成金额
							alert("您充值的会员名是："+data.vname
									+"\n您充值的会员绑定的车牌号是："+data.cnumber
									+"\n您本次充值金额是："+vipmoney+
									"\n您充值后会员卡内余额是："+data.vbalance);
						}
						$('#myModal').modal(options)

					}
				});
			});
		
			
			
			//动态查询会员信息
				$("#select_two").click(function(){
					console.log(22);
					var input_vipname_number = $("#input_vipname_number").val();
					console.log(input_vipname_number);	
					$.ajax({
						url : "getVipUsersByCarnumberOrname.do",// 请求地址
						type : "POST",// 请求方法
						data : {
							input_vipname_number : input_vipname_number
						},
						dataType : "json",// 返回数据类型
						success : function(data) {// 请求完成执行的方法
							console.log(data);	
								//alert(data.vname);
							
							if(data.vid==0){
								alert("该用户不是会员");
							}else {
								$("#in_msg1").html(data.vid);
								$("#in_msg2").html(data.vname);
								$("#in_msg3").html(data.cnumber);
								$("#in_msg4").html(data.vbalance);
								
								
								$('#myModal').modal('show');
							}
							
						}
					});
					
				});

			
//				
//				$("#select_two").click(function () {
//					var a=9;
//					if (a>9) {
//						$('#myModal').modal('show');
//						console.log(2);
//			             alert()
//					}
//			            
//			        });
//			
			
			
			

		})
