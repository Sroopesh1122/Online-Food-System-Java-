let check = false;
let error = false;

$(document).ready(function() {

	for (let i = 0; i < $(".error").length; i++) {
		const ele = $(".error")[i];
		$(ele).hide()
	}


	function checkEmail() {
		if ($("#email").val().trim() === "" || !$("#email").val().includes("@")) {
			const ele = $("#email").siblings(".error")[0];
			$(ele).show();
			$("#email").addClass("input-error")
			error = true;
		} else {
			const ele = $("#email").siblings(".error")[0];
			$(ele).hide()
			$("#email").removeClass("input-error")
			error = false;
		}
	}

	function checkPassword() {
     if ($("#password").val().trim() === "") {
			const ele = $("#password").siblings(".error")[0];
			$(ele).text("Please enter password")
			$(ele).show();
			$("#password").addClass("input-error")
			error = true;
		} else {
				const ele = $("#password").siblings(".error")[0];
				$(ele).hide()
				$("#password").removeClass("input-error")
				error = false;
		}


	}

	$("#email").on('input', function() {
		if (check) {
			checkEmail()
		}
	})

	$("#password").on('input', function() {
		if (check) {
			checkPassword()
		}
	})

    $("#login-btn").on('click',function(){
		check = true;
		checkEmail();
		checkPassword();
		
		if(!error)
		{
			$("#signinForm").submit()
		}
		
	})
})
