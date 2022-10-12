function myAlert() {
    window.alert("This is a popup");
}

function validateName(firstNameInput){
        var firstNameInputElement = document.getElementById("firstNameInput");
        var firstNameInput = firstNameInputElement.value;
        document.getElementById('errorText1').innerText = "";
        if (firstNameInput.length == "" || firstNameInput.length == 0 ) {
            document.getElementById('errorText1').innerText="Please enter your First Name";

    }
    }

    function validateLastName(lastNameInput){
            var lastNameInputElement = document.getElementById("lastNameInput");
            var lastNameInput = lastNameInputElement.value;
            //var userInputElement = document.activeElement;
            document.getElementById('errorText2').innerText = "";
            console.log(lastNameInput);
            console.log(lastNameInputElement);
            console.log(lastNameInput.length);
            if (lastNameInput.length == "" || lastNameInput.length == null ) {
                document.getElementById('errorText2').innerText="Please enter your Last Name";
        }
        }
function validateUsername(usernameInput){
            var usernameInput = document.getElementById("usernameInput").value;
            var lastNameInput = document.getElementById("lastNameInput").value;
            //var usernameInput = usernameInputElement.value;
           // var usernameInput = usernameInputElement.value;
            //var userInputElement = document.activeElement;
            document.getElementById('errorText4').innerText = "";
            if (usernameInput == lastNameInput ) {
                document.getElementById('errorText4').innerText="Username must be different than Last Name";
        }
        }

function validateField(passwordInput){
        var passwordInputElement = document.getElementById("passwordInput");
        var passwordInput = passwordInputElement.value;
        //var userInputElement = document.activeElement;
        //passwordInputElement.style = "background-color:#04AA6D;";
        document.getElementById('errorText').innerText = "";
        //console.log(passwordInput);
        //console.log(passwordInputElement);
        //console.log(passwordInput.length);
        if (passwordInput.length < 8 || passwordInput.length > 30) {
            document.getElementById('errorText').innerText="Password must be between 8 and 30 characters";
            passwordInputElement.style = "background-color:red;";
    }
    }

function checkPasswordMatch(passwordInput, passwordConfirmInput){
        var passwordInput = document.getElementById("passwordInput").value;
        var passwordConfirmInput = document.getElementById("passwordConfirmInput").value;
        //var passwordConfirmInput = passwordInputElement.value;
        document.getElementById('errorText3').innerText = "";
    if (passwordInput !== passwordConfirmInput) {
    document.getElementById('errorText3').innerText="Passwords do no match";

    }
}

function validateFormAll() {

var firstNameInput = document.getElementById('firstNameInput').value;
var lastNameInput = document.getElementById('lastNameInput').value;
var usernameInput = document.getElementById('usernameInput').value;
var passwordInput = document.getElementById('passwordInput').value;
var passwordConfirmInput = document.getElementById('passwordConfirmInput').value;
var emailInput = document.getElementById('emailInput').value;
var fileInput = document.getElementById('fileInput').value;
 if (firstNameInput == null || firstNameInput == "" || lastNameInput == null
 || lastNameInput == "" || usernameInput == null || usernameInput == "" || !passwordConfirmInput || !emailInput ){
 window.alert("Please make sure all fields are complete");}
}

