package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if (oldPassword.equals(getPassword())) {
            boolean isDigitPresent = false;
            boolean isUpperCasePresent = false;
            boolean isLowerCasePresent = false;
            boolean isLengthSufficient = false;
            boolean isSpecialCharPresent = false;
            if (newPassword.length() >= 8) {
                isLengthSufficient = true;
            }
            for (int i = 0; i < newPassword.length(); i++) {
                int ascii = (int) (newPassword.charAt(i));
                if (ascii > 47 && ascii < 58) {
                    isDigitPresent = true;
                } else if (ascii > 64 && ascii < 91) {
                    isUpperCasePresent = true;
                } else if (ascii > 96 && ascii < 123) {
                    isLowerCasePresent = true;
                } else {
                    isSpecialCharPresent = true;
                }
            }
            if (isDigitPresent && isLengthSufficient && isLowerCasePresent
                    && isUpperCasePresent && isSpecialCharPresent) {
                this.password = newPassword;
            }
        }
    }
}
