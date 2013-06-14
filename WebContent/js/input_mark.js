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


function onInputClick() {
	var subjectEle = document.getElementsByName("subject")[0];
	var majorEle = document.getElementsByName("major")[0];
	var gradeEle = document.getElementsByName("grade")[0];
	var classEle = document.getElementsByName("class")[0];
	var subject = subjectEle.options[subjectEle.selectedIndex].value;
	var major = majorEle.options[majorEle.selectedIndex].text;
	var grade = gradeEle.options[gradeEle.selectedIndex].text;
	var classes = classEle.options[classEle.selectedIndex].text;
	if(subject != "" && major != "" && grade != "" && classes != "") {
		var action = "subject=" + subject + "&major=" + major + 
				"&grade=" + grade + "&class=" + classes;
		ajaxSend("input_mark", action, inputMarkCallback);
	}
}

function inputMarkCallback(result) {
	var data = eval("(" + result + ")");
	var students = data.students;
	if(students != null && students.length > 0) {
		var ele = document.getElementById("students");
		ele.setAttribute("name", data.subject);
		var html = "<table width=\"600px\" class=\"table_student\">" +
						"<tr>" +
							"<td>学号</td>" +
							"<td>名称</td>" +
							"<td>性别</td>" +
							"<td>分数</td>" +
						"</tr>";
		for(var i = 0; i < students.length; i++) {
			html += "<tr>" +
						"<td>" + students[i].no + "</td>" +
						"<td>" + students[i].name + "</td>" + 
						"<td>" + students[i].sex + "</td>" + 
						"<td><input type=\"text\" class=\"score\" name=\"" + students[i].no + "\"></td>" + 
					"</tr>";
		}
		html += "</table>";
		html += "<div class=\"row\"><a href=\"javascript:;\" class=\"a_btn\">确定录入</a></div>";
		ele.innerHTML = html;
		set_a_btn();
	}
}
