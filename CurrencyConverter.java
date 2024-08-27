import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Std ID : F22040119 
// Name : Muntasir Al Mamun
public class CurrencyConverter extends javax.swing.JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> conversionDirectionComboBox;
    private JButton convertButton;

    private static final double EXCHANGE_RATE = 6.88; // Exchange rate from RMB to USD

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(300, 300); // Adjusted for better layout and to accommodate the image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(75, 0, 130)); // Neon Purple background
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Icon Panel
        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\asus\\OneDrive\\Desktop\\Final Preparation\\Need to submit\\Java Lab Reports\\Images\\currencyConverter.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel iconLabel = new JLabel(icon);
        iconPanel.add(iconLabel);
        getContentPane().add(iconPanel);

        // Create GUI components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Enter Amount:");
        label.setForeground(Color.BLACK); // Set text color to black
        inputField = new JTextField(10);
        inputField.setBackground(new Color(128, 0, 128)); // Dark Purple background
        inputField.setForeground(Color.WHITE); // White text for visibility
        inputPanel.add(label);
        inputPanel.add(inputField);

        JPanel conversionPanel = new JPanel();
        conversionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        String[] conversionOptions = {"RMB to USD", "USD to RMB"};
        conversionDirectionComboBox = new JComboBox<>(conversionOptions);
        conversionDirectionComboBox.setBackground(new Color(128, 0, 128)); // Dark Purple background
        conversionDirectionComboBox.setForeground(Color.WHITE); // White text for visibility
        conversionPanel.add(conversionDirectionComboBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(75, 0, 130)); // Neon Purple
        convertButton.setForeground(new Color(255, 255, 0)); // Neon text color
        buttonPanel.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setForeground(new Color(255, 255, 0)); // Neon text color

        // Add panels to the container
        getContentPane().add(inputPanel);
        getContentPane().add(conversionPanel);
        getContentPane().add(buttonPanel);
        getContentPane().add(resultLabel);

        // Add ActionListener to the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (conversionDirectionComboBox.getSelectedItem().equals("RMB to USD")) {
                    convertRmbToUsd();
                } else {
                    convertUsdToRmb();
                }
            }
        });
    }

    private void convertRmbToUsd() {
        try {
            double rmbAmount = Double.parseDouble(inputField.getText());
            if (rmbAmount < 0) {
                resultLabel.setText("Invalid Currency");
            } else {
                double usdAmount = rmbAmount / EXCHANGE_RATE;
                resultLabel.setText("USD: " + String.format("%.2f", usdAmount));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    private void convertUsdToRmb() {
        try {
            double usdAmount = Double.parseDouble(inputField.getText());
            if (usdAmount < 0) {
                resultLabel.setText("Invalid Currency");
            } else {
                double rmbAmount = usdAmount * EXCHANGE_RATE;
                resultLabel.setText("RMB: " + String.format("%.2f", rmbAmount));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}