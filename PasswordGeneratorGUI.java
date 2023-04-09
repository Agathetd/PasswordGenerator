import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneratorGUI extends JFrame {
    private JTextField lengthField;
    private JTextArea outputArea;

    private static String chars = "AZERTYUIOPQSDFGHJKLMWXCVBN?./§¨%£µ1234567890°+<azertyuiop^$*qsdfghjklmùwxcvbn,;:!";
    private static String normalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        lengthField = new JTextField(10);
        JButton generateButton = new JButton("Generate Password");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lengthStr = lengthField.getText();
                if (lengthStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid password length.");
                    return;
                }
                int length = Integer.parseInt(lengthStr);

                String password = generatePassword(length);
                String normalPassword = generateNormalCharsPassword(length);

                outputArea.setText("Mot de passe généré avec caractères spéciaux : " + password + "\n"
                        + "Mot de passe généré sans caractères spéciaux : " + normalPassword);
            }
        });

        setLayout(new BorderLayout());
        add(lengthField, BorderLayout.NORTH);
        add(generateButton, BorderLayout.CENTER);
        add(outputArea, BorderLayout.SOUTH);

        setVisible(true);
    }

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

    public static String generateNormalCharsPassword(int length) {
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordGeneratorGUI();
            }
        });
    }
}
