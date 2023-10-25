import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextAdventureGameUI extends JFrame implements ActionListener, KeyListener {
    private JTextArea textArea;
    private JTextField inputField;
    private String currentLocation;
    private String outputText;

    public TextAdventureGameUI() {
        setTitle("Text-Based Adventure Game");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(new Color(144, 238, 144)); // Lemon Green
        textArea.setForeground(new Color(139, 69, 19)); // Brown
        textArea.setFont(new Font("Arial", Font.BOLD, 20)); // Increase font size
        JScrollPane scrollPane = new JScrollPane(textArea);

        inputField = new JTextField();
        inputField.addKeyListener(this);
        inputField.setBackground(new Color(255, 255, 153)); // Light Yellow
        inputField.setFont(new Font("Arial", Font.PLAIN, 18)); // Increase font size

        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);

        currentLocation = "start";
        outputText = "You find yourself in a mysterious room. Type 'help' for instructions.";
        textArea.append(outputText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            handleInput(inputField.getText());
            inputField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key release
    }

    public void handleInput(String input) {
        // Handle user input and change the game state accordingly
        // You can use a switch or if-else statements to navigate the game's state.

        outputText = ""; // Clear the output text

        if (currentLocation.equals("start")) {
            if (input.equalsIgnoreCase("help")) {
                outputText = "You are in a mysterious room. You can type 'north' to move north.";
            } else if (input.equalsIgnoreCase("north")) {
                currentLocation = "forest";
                outputText = "You are in a dark forest. You can see a path leading further north.";
            } else {
                outputText = "I don't understand. Type 'help' for instructions.";
            }
        } else if (currentLocation.equals("forest")) {
            if (input.equalsIgnoreCase("south")) {
                currentLocation = "start";
                outputText = "You are back in the mysterious room.";
            } else if (input.equalsIgnoreCase("north")) {
                outputText = "You follow the path to a clearing. Congratulations, you've won!";
            } else {
                outputText = "I don't understand your command. Try 'north' or 'south'.";
            }
        }

        textArea.append("\n" + input);
        textArea.append("\n" + outputText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TextAdventureGameUI().setVisible(true);
        });
    }
}
