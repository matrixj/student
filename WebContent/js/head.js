init(setBackground);

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

function setHeadBarMouse() {
	var as = document.getElementsByTagName("a");
	for(var i = 0; i < as.length; i++) {
		var className = as[i].className.split(" ");
		for(var j = 0; j < className.length; j++) {
			if(className[j] == "a_title") {
				as[i].setAttribute("onmouseover", "onHeadBarHover(this);");
				as[i].setAttribute("onmouseout", "onHeadBarLeave(this);");
				break;
			}
		}
	}
}


function onHeadBarHover(ele) {
	ele.style.color = "#163B6C";
}

function onHeadBarLeave(ele) {
	ele.style.color = "black";
}

function onLogoutHover(ele) {
	ele.style.color = "red";
}

function onLogoutLeave(ele) {
	ele.style.color = "black";
}

function setBackground() {
	var body = document.getElementsByTagName("body")[0];
	var headPage = document.getElementById("div_headPage");
	var htm = body.innerHTML;
	var index = htm.indexOf(headPage.innerHTML);
	body.innerHTML = htm.substring(index + 1, headPage.innerHTML.length + index + 6) + 
	"<div class=\"div_bg\"><div class=\"nothing\"></div>" + 
	htm.substring(headPage.innerHTML.length + index + 7, htm.length) + 
	"</div></body>";
}

function setTitleBar(id) {
	document.getElementById(id).style.backgroundColor = "#43699A";
}