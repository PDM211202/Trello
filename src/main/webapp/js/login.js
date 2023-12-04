function login(){
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    console.log(email, password);
    window.location.href = 'http://localhost:8080/itad/HomeView?email=' + email + '&password=' + password;
}