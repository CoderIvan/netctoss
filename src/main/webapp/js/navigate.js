$(function() {
	var url = window.location.pathname;
	var last = url.indexOf('/', 1);
	var path = url.substring(0, last);
	if (path == "") {
		$(".index_off").attr("class", "index_on");
	} else if (path == "/service") {
		$(".service_off").attr("class", "service_on");
	} else if (path == "/cost") {
		$(".fee_off").attr("class", "fee_on");
	}else if(path == "/account"){
		$(".account_off").attr("class", "account_on");
	}else if(path == "/role"){
		$(".role_off").attr("class", "role_on");
	}else if(path == "/admin"){
		$(".admin_off").attr("class", "admin_on");
	}else if(path == "/report"){
		$(".report_off").attr("class", "report_on");
	}else if(path == "/bill"){
		$(".bill_off").attr("class", "bill_on");
	}else if(path == "/user"){
		var temp = url.substring(url.lastIndexOf('/'),url.lastIndexOf("."));
		if(temp == "/info"){
			$(".information_off").attr("class", "information_on");
		}else if(temp == "/password"){
			$(".password_off").attr("class", "password_on");
		}
	}
});