document.getElementById("admin_register_form").addEventListener("submit",function(event){
    var nameInput = document.getElementsByName("admin_name")[0];
    var emailInput = document.getElementsByName("admin_email")[0];
    var passwordInput = document.getElementById("password");
    var confirmPasswordInput = document.getElementById("confirmPassword");
    var errorMessage = document.getElementById("error_message");

    if(nameInput.value.trim() === "" || emailInput.value.trim() ==="" || passwordInput.value === "" || confirmPasswordInput.value === "" || !document.querySelector(".check_box").checked){
        event.preventDefault();
        errorMessage.textContent = "未入力の項目があります、利用者規則に同意していません。";
    }else if(passwordInput.value !== confirmPasswordInput.value){
        event.preventDefault();
        errorMessage.textContent = "パスワードが一致しません。";
    }else{
        errorMessage.textContent = "";
    }
});


document.getElementById("admin_login_form").addEventListener("submit",function(event){
    var emailInput = document.getElementsByName("admin_email")[0];
    var passwordInput = document.getElementsByName("admin_password")[0];
    var errorMessage = document.getElementById("error_message");
    
    if(emailInput.value.trim() === "" || passwordInput.value === "" ){
        event.preventDefault();
        errorMessage.textContent = "間違いがあります。";
    }else{
        errorMessage.textContent = "";
    }
});