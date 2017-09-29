var info = document.getElementById("info");
		document.getElementById("promptBtn").addEventListener('tap', function(e) {
				e.detail.gesture.preventDefault(); //修复iOS 8.x平台存在的bug，使用plus.nativeUI.prompt会造成输入法闪一下又没了
				var btnArray = ['取消', '确定'];
				mui.prompt('請留下有效電郵地址', '', '參加幸運抽獎活動', btnArray, function(e) {
					if (e.index == 1) {
						console.info("yes");
//						mui.post('http://localhost:8080/WebProudOrganDonors/saveEmail?email='+e.value,{},function(data){
//							//服务器返回响应，根据响应结果，分析是否登录成功；
//							console.info(data);
//							//服务器返回响应，根据响应结果，分析是否登录成功；
//									info.innerText = '電郵地址' + e.value +'提交成功';
//							},'text'
//						);

						var email_v = e.value;
						
						mui.ajax('http://117.27.138.166:8080/WebProudOrganDonors/saveEmail?email='+email_v,{
								email:email_v,
								dataType:'json',//服务器返回json格式数据
								type:'post',//HTTP请求类型
								timeout:10000,//超时时间设置为10秒；
								headers:{'Content-Type':'application/x-www-form-urlencoded'},	              
								success:function(data){
									//服务器返回响应，根据响应结果，分析是否登录成功；
									info.innerText = '電郵地址' + email_v +'提交成功';
								},
								error:function(xhr,type,errorThrown){
									//异常处理；
									console.log(type);
									info.innerText = '電郵地址' + email_v +'提交成功了';
									//info.innerText = '网络连接错误'+type;
								}
							});
						
					} else {
						console.info("no");
						//info.innerText = '你点了取消按钮';
					}
				})
			});
		function index(){
			console.info("index");
			document.getElementById("title").innerText="器官捐贈資訊";
		}
		function share(){
			console.info("share");
			document.getElementById("title").innerText="故事分享";
		}
		function regist(){
			console.info("regist");
			document.getElementById("title").innerText="現在登記";
		}
		function count(){
			mui.post('http://117.27.138.166:8080/WebProudOrganDonors/updateConnectUrlCount',{},function(data){
					//服务器返回响应，根据响应结果，分析是否登录成功；
					console.info(data);
				},'json'
				);
		}