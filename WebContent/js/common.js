init(set_a_btn);

function init(func) {
	var oldLoad = window.onload;
	if(typeof window.onload != "function") {
		window.onload = func;
	}
	else {
		window.onload = function() {
			oldLoad();
			func();
		};
	}
}

function set_a_btn() {
	var a_btn = document.getElementsByTagName("a");
	for(var i = 0; i < a_btn.length; i++) {
		var className = a_btn[i].className.split(" ");
		for(var j = 0; j < className.length; j++) {
			if(className[j] == "a_btn") {
				a_btn[i].setAttribute("onmouseover", "onAbtnHover(this);");
				a_btn[i].setAttribute("onmouseout", "onAbtnLeave(this);");
				a_btn[i].setAttribute("onmousedown", "onAbtnDown(this);");
				a_btn[i].setAttribute("onmouseup", "onAbtnUp(this);");
				break;
			}
		}
	}
}

function onAbtnHover(ele) {
	ele.style.backgroundColor = "#00DB00";
}

function onAbtnLeave(ele) {
	ele.style.backgroundColor = "#00EC00";
}

function onAbtnDown(ele) {
	ele.style.display = "inline-block";
	ele.style.marginTop = "1px";
}

function onAbtnUp(ele) {
	ele.style.display = "inline";
}


/**
 * ajax发送post请求
 */
function ajaxSend(url, action, callback) {
	var xmlhttp;
	if(window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else {
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState==4 && xmlhttp.status==200) {
			callback(xmlhttp.responseText);
		}
	};
	xmlhttp.open("POST", url, true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(action);
}