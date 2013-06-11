init(setOnchange);

function setOnchange() {
	var selects = document.getElementsByTagName("select");
	for(var i = 0; i < selects.length; i++) {
		var className = selects[i].className.split(" ");
		for(var j = 0; j < className.length; j++) {
			if(className[j] == "select_onchange") {
				selects[i].setAttribute("onchange", "onInputMarkChange(this);");
				break;
			}
		}
	}
}

function onInputMarkChange(ele) {
	var action = null;
	if(ele.name == "subject") {
		//换了科目
		var majorEle = document.getElementsByName("major")[0];
		var subject = ele.options[ele.selectedIndex].value;
		var major = majorEle.options[majorEle.selectedIndex].text;
		action = "subject=" + subject + "&major=" + major;
		ajaxSend("input_mark", action, onRecieveSelect);
	}
	else if(ele.name == "major") {
		//换了专业
		var subjectEle = document.getElementsByName("subject")[0];
		var subject = subjectEle.options[subjectEle.selectedIndex].value;
		var major =  ele.options[ele.selectedIndex].text;
		action = "subject=" + subject + "&major=" + major;
		ajaxSend("input_mark", action, onRecieveSelect);
	}
	else if(ele.name == "grade") {
		//换了年级
		var subjectEle = document.getElementsByName("subject")[0];
		var majorEle = document.getElementsByName("major")[0];
		var subject = subjectEle.options[subjectEle.selectedIndex].value;
		var major = majorEle.options[majorEle.selectedIndex].text;
		var grade = ele.options[ele.selectedIndex].text;
		action = "subject=" + subject + "&major=" + major + "&grade=" + grade;
		ajaxSend("input_mark", action, onRecieveSelect);
	}
}

function onRecieveSelect(result) {
	//转化为json格式
	var data = eval ("(" + result + ")");
	var gradeEle = document.getElementsByName("grade")[0];
	var classEle = document.getElementsByName("class")[0];
	if(data.grades != null && data.grades.length > 0) {
		gradeEle.innerHTML = "";
		for(var i = 0; i < data.grades.length; i++) {
			gradeEle.innerHTML += "<option>" + data.grades[i] + "</option>";
		}
	}
	else if(data.classes == null || data.classes.length <= 0) {
		gradeEle.innerHTML = "";
	}
	classEle.innerHTML = "";
	if(data.classes != null && data.classes.length > 0) {
		for(var i = 0; i < data.classes.length; i++) {
			classEle.innerHTML += "<option>" + data.classes[i] + "</option>";
		}
	}
}