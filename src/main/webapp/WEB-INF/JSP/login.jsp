<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>达内－NetCTOSS</title>
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css" />
	<link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css" />
	<script type="text/javascript" src="${base}/js/jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			/* 获取、更改验证码 */
			$("#img_verifiCode").click(function() {
				$(this).attr('src', '${base}/verification?ran='+Math.random());
			}).click();
			/* 登录*/
			$("#submit").click(function(){
				var params = $("form").serialize();
        		$.ajax({
     				type: "POST",
					url: "${base}/login",
					data: params,
					dataType: "JSON",
					success: function(result){
						if(result.success){
							location = result.content;
						}else{
							$("#error_msg").html(result.content);
						}
					}
       			});			
			});
		}); 
	</script>
</head>
<body class="index">
	<form method="post">
		<div class="login_box">
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input type="text" name="username" class="width150"/></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input type="password" name="password" class="width150"/></td>
				</tr>
				<tr>
					<td class="login_info">验证码：</td>
					<td class="width70"><input type="text" id="verrifiCode" name="verifiCode" class="width70"/></td>
					<td><img id="img_verifiCode" alt="验证码" title="点击更换"/></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2">
                        <a id="submit"><img src="${base}/images/login_btn.png"/></a>
                    </td>
				</tr>
				<tr>
					<td colspan="3">
						<div style="color:Red;border:0px;text-align:center;" id="error_msg"></div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>