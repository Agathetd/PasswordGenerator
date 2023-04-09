import java.util.Random;

public class passwordgenerator {

    static String chars = "AZERTYUIOPQSDFGHJKLMWXCVBN?./§¨%£µ1234567890°+<azertyuiop^$*qsdfghjklmùwxcvbn,;:!";

    public static String generatePassword() {
        int charsLength = chars.length(); 

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            int index = random.nextInt(charsLength);
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String password = generatePassword();
        System.out.println("Mot de passe généré :" + password);

    }

}