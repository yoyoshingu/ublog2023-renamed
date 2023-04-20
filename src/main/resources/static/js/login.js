


 let loginObject = {
    init: function(){
        let _this = this;

        $("#btn-login").on("click",() =>{
            _this.login();
        });
    },

    login: function(){
        alert("로그인 요청됨");    
        		let logindata = {
			username: $("#username").val(),
			password: $("#password").val(),
		}
		
		console.log(logindata);   
		
		$.ajax({
			type: "POST",
			url: "/auth/login",
			data: JSON.stringify(logindata),
			contentType: "application/json; charset=utf-8"	
		}).done(function(response){
			console.log(response["data"]);
			alert(response);
		}).fail(function(error){
			alert("!@ login.js 에러발생" + error);
		});
    },
 }

loginObject.init();
