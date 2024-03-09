package org.example.card;

public class Test01 {

    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    public static void main(String[] args) {
        String userId = "1234";
        String password = "1q2w3e4r$";
        String confirmPassword = "1q2w3e4r$";

        boolean isUserIdValid = validateUserId(userId);
        boolean isPasswordValid = validatePassword(password);
        boolean isPasswordConfirmed = password.equals(confirmPassword);

        String result = (isUserIdValid && isPasswordValid && isPasswordConfirmed) ? PASS : FAIL;

        System.out.println(result);
    }

    private static boolean validateUserId(String userId) {
        return userId.matches("[a-z0-9]{3,20}");
    }

    private static boolean validatePassword(String password) {
        final boolean lengthCheck = password.matches(".{8,20}");
        final boolean alphabetCheck = password.matches(".*[a-zA-Z].*");
        final boolean numberCheck = password.matches(".*[0-9].*");
        final boolean specialCharCheck = password.matches(".*[!@#$].*");

        return lengthCheck && alphabetCheck && numberCheck && specialCharCheck;
    }


}
