$.fn.minLength = function(minLength, msg, msgCnt) {
	var value = this.val();
	if (value != null && value.length >= minLength) {
		$(msgCnt).text('');
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.maxLength = function(maxLength, msg, msgCnt) {
	var value = this.val();
	if (value != null && value.length <= maxLength) {
		$(msgCnt).text('');
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.intRange = function(min, max, msg, msgCnt) {
	var value = this.val();
	var regex = /^-?\d*$/;
	if (regex.test(value)) {
		var intValue = parseInt(value);
		if (intValue > min && intValue <= max) {
			$(msgCnt).text('');
			return true;
		}
	}
	$(msgCnt).text(msg);
	return false;
};

$.fn.doubleRange = function(min, max, msg, msgCnt) {
	var value = this.val();
	var regex = /^(-?\d*)(\.\d+)?$/;
	if (regex.test(value)) {
		var intValue = parseFloat(value);
		if (intValue >= min && intValue <= max) {
			$(msgCnt).text('');
			return true;
		}
	}
	$(msgCnt).text(msg);
	return false;
};

$.fn.chineseRange = function(min, max, msg, msgCnt) {
	var value = this.val();
	var regex = /^[\w\u4E00-\u9FA5]*$/;
	if (regex.test(value)) {
		var length = value.length;
		if (length >= min && length <= max) {
			$(msgCnt).text('');
			return true;
		}
	}
	$(msgCnt).text(msg);
	return false;
};

$.fn.range = function(min, max, msg, msgCnt) {
	var value = this.val();
	var regex = /^[\w]*$/;
	if (regex.test(value)) {
		var length = value.length;
		if (length >= min && length <= max) {
			$(msgCnt).text('');
			return true;
		}
	}
	$(msgCnt).text(msg);
	return false;
};

$.fn.required = function(msg, msgCnt) {
	return this.minLength(1, msg, msgCnt);
};

$.fn.remote = function(uri, msg, msgCnt) {
	var value = this.val();
	var name = this.attr('name');
	var b = false;
	$.ajax({
		url : uri + '?' + name + '=' + value,
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data) {
				$(msgCnt).text('');
				b = true;
			} else {
				$(msgCnt).text(msg);
			}
		}
	});
	return b;
};

function remoteResult(url) {
	var b = false;
	$.ajax({
		url : url,
		dataType : 'json',
		async : false,
		success : function(data) {
			b = data;
		}
	});
	return b;
}

$.fn.isTelephone = function(msg, msgCnt) {
	var value = this.val();
	var regex = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
	if (regex.test(value)) {
		$(msgCnt).text("");
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.isEmail = function(msg, msgCnt) {
	var value = this.val();
	var regex = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	if (regex.test(value)) {
		$(msgCnt).text("");
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.isIdcardNo = function(msg, msgCnt) {
	var value = this.val();
	var regex = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
	if (regex.test(value)) {
		$(msgCnt).text("");
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.isZipCode = function(msg, msgCnt) {
	var value = this.val();
	var regex = /^\d{6}$/;
	if (regex.test(value)) {
		$(msgCnt).text("");
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};

$.fn.isQQ = function(msg, msgCnt) {
	var value = this.val();
	var regex = /^\d{5,13}$/;
	if (regex.test(value)) {
		$(msgCnt).text("");
		return true;
	} else {
		$(msgCnt).text(msg);
		return false;
	}
};