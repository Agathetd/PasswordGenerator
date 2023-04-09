import java.util.Random;
import java.util.Scanner;

public class passwordgenerator {

    static String chars = "AZERTYUIOPQSDFGHJKLMWXCVBN?./§¨%£µ1234567890°+<azertyuiop^$*qsdfghjklmùwxcvbn,;:!";
    static String normalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public static String generatePassword(int length) {
        int charsLength = chars.length(); 

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charsLength);
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String genereateNormalCharsPassword(int length) {
        int normalCharsLength = normalChars.length(); 

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(normalCharsLength);
            sb.append(normalChars.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur du mot de passe : ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        System.out.println("Mot de passe généré avec caractères spéciaux : " + password);

        String normalPassword = genereateNormalCharsPassword(length);
        System.out.println("Mot de passe généré sans caractères spéciaux : " + normalPassword);
    }

}