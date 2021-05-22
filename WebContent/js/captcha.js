function removeSpaces(txt){
	return txt.split(' ').join('');
}

function captcha(){
	var letters = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
	
	var a = letters[Math.floor(Math.random() * letters.length)];
	var b = letters[Math.floor(Math.random() * letters.length)];
	var c = letters[Math.floor(Math.random() * letters.length)];
	var d = letters[Math.floor(Math.random() * letters.length)];
	var e = letters[Math.floor(Math.random() * letters.length)];
	var f = letters[Math.floor(Math.random() * letters.length)];
	var g = letters[Math.floor(Math.random() * letters.length)];
	
	var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;

	document.getElementById("captchacode").innerHTML = "<b><i>" + code + "</i></b>";
	
	//source - https://stackoverflow.com/questions/3196335/how-to-create-simple-javascript-jquery-client-side-captcha
}

function validate () {
	var card = document.getElementById("card").checked;
	var other = document.getElementById("other").checked;
	var pemail = document.getElementById("pemail").value;
	var service = document.getElementById("service").value;
	var pfname = document.getElementById("pfname").value;
	var plname = document.getElementById("plname").value;
	var cno = document.getElementById("cno").value;
	var date = document.getElementById("date").value;
	var code = document.getElementById("code").value;
	
	if(card == true) {
		if(pfname == "" || plname == "" || cno == "" || date == "" || code == "") {
			document.getElementById("error").innerHTML = "<div class='alert alert-error'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Error!</strong> Please fill all the necessary fields.</div>";			                  
						                
		}
		else {
			verify();
		}
	}
	else if(other == true) {
		if(service == "" || pemail == "") {
			document.getElementById("error").innerHTML = "<div class='alert alert-error'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Error!</strong> Please fill all the necessary fields.</div>";			     
		}
		else {
			verify();
		}
	}
}

function verify() {
	var txt1 = removeSpaces(document.getElementById("captchacode").textContent);
	var captcha = removeSpaces(document.getElementById("captcha").value);
	if (captcha != txt1){
		document.getElementById("error").innerHTML = "<div class='alert alert-error'><button type='button' class='close' data-dismiss='alert'>&times;</button><strong>Error!</strong> Wrong captcha.</div>";			     
		document.getElementById("captcha").style.border = "1px solid red"
		return false;
	}
	else{
		document.getElementById("error").innerHTML = "";
		document.getElementById("pay").submit();
	}
}