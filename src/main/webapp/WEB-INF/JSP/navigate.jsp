<%@ page contentType="text/html; charset=utf-8" %>
<script type="text/javascript">
	function selectTitle(){
		var url = window.location.href;
		var li = document.getElementById("menu").getElementsByTagName("li");
		for(var i = 0 ; i < li.length ; i++){
			var a = li[i].getElementsByTagName("a")[0];
			if(url.indexOf(a.href,0) > -1){
				a.className = a.className.replace("_off","_on");
			}
		}
	}
</script>
<!--导航区域开始-->
<ul id="menu">
    <li><a href="${base}/main" class="index_off"></a></li>
    <li><a href="${base}/role/index" class="role_off"></a></li>
    <li><a href="${base}/admin/index" class="admin_off"></a></li>
    <li><a href="${base}/cost/index" class="fee_off"></a></li>
    <li><a href="${base}/account/index" class="account_off"></a></li>
    <li><a href="${base}/service/index" class="service_off"></a></li>
    <li><a href="${base}/bill/index" class="bill_off"></a></li>
    <li><a href="${base}/report/index" class="report_off"></a></li>
    <li><a href="${base}/user/info" class="information_off"></a></li>
    <li><a href="${base}/user/password" class="password_off"></a></li>
</ul>
<script>selectTitle();</script>
<!--导航区域结束-->