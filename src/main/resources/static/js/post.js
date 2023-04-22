/**
 * 
 */
 
/**
 /sbootblog/src/main/resources/static/js/user.js
 */

/**
 * 회원가입 old style java script
 /sbootblog/src/main/resources/static/js/user.js
 */

function usersubmit() {
	alert("회원가입 요청됨:old style javascript");

	let user = {
		username: document.getElementById("username").value,
		password: document.getElementById("password").value,
		email: document.getElementById("email").value
	}
	console.log(user);

/* http request 
*/


	var ajaxrequest = new XMLHttpRequest();

	ajaxrequest.open('POST', '/user');
	JSON.stringify(user);
	ajaxrequest.onreadystatechange = function() {
		if (ajaxrequest.readyState == 4) {
			response = ajaxrequest.responseText;
			alert(response);
			location - "/";
		}
	}
	ajaxrequest.setRequestHeader("Content-Type", "application/json");
	ajaxrequest.send(JSON.stringify(user));

}

function memberjoin() {
	let btnsave = document.getElementById("btn-save");
	btnsave.onclick = usersubmit;
}

// memberjoin();



 let postObject = {
    init: function(){
        let _this = this;

        $("#btn-insert").on("click",() =>{
            _this.insertPost();
        });
    },

    insertPost: function(){
        alert("포스트등록 요청됨");    
        		let post = {
			title: $("#title").val(),
			content: $("#content").val()
		}
		
		console.log(post);   
		
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(post),
			contentType: "application/json; charset=utf-8"	
		}).done(function(response){
			console.log(response);
			alert(response["data"]);
		}).fail(function(error){
			alert("!@ post.js 에러발생" + error["data"]);
		});
    },
 }

 postObject.init();
