document.addEventListener('DOMContentLoaded', () => {
    let password = document.querySelector("#password"),
        confirmPassword = document.querySelector("#confirm_password");

    confirmPassword.addEventListener('input', () => {
        checkConfirmPassword(password, confirmPassword);
    });

    password.addEventListener('input', () => {
        checkConfirmPassword(password, confirmPassword);
    });

    function checkConfirmPassword(password, confirmPassword) {
        if (password.value !== confirmPassword.value) {
            confirmPassword.style.borderColor = 'red';
            document.querySelector(".btn").disabled = true;
        } else {
            confirmPassword.style.borderColor = 'black';
            document.querySelector(".btn").disabled = false;
        }
    }
})