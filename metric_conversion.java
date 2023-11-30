import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UnitsConverter {
    private JFrame frame;
    private JTextField quantityTextField;
    private JComboBox<String> conversionOptions;
    private JLabel resultLabel;

    public UnitsConverter() {
        frame = new JFrame("Midnight Coders Units Converter");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
        panel.setBackground(new Color(174, 160, 160));
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
    
        // Set background color
        panel.setBackground(new Color(174, 160, 160));
    
        // Add welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Midnight Coders Unit Converter");
        welcomeLabel.setBounds(10, 10, 400, 25); // Adjust the position and size as needed
        panel.add(welcomeLabel);
    
        JLabel quantityLabel = new JLabel("Enter Quantity:");
        quantityLabel.setBounds(10, 40, 120, 25);
        panel.add(quantityLabel);
    
        quantityTextField = new JTextField(20);
        quantityTextField.setBounds(140, 40, 200, 25);
        panel.add(quantityTextField);
    
        JLabel conversionLabel = new JLabel("Choose Conversion:");
        conversionLabel.setBounds(10, 70, 120, 25);
        panel.add(conversionLabel);
    
        String[] conversionOptionsArray = {"Feet to Meters", "Pounds to Kgs", "Fahrenheit to Celsius"};
        conversionOptions = new JComboBox<>(conversionOptionsArray);
        conversionOptions.setBounds(140, 70, 200, 25);
        panel.add(conversionOptions);
    
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(10, 100, 120, 25);
        panel.add(convertButton);
    
        resultLabel = new JLabel("");
        resultLabel.setBounds(140, 100, 200, 25);
        panel.add(resultLabel);
    
        // Add action listener for the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonClicked();
            }
        });
    }
    private void convertButtonClicked() {
        try {
            double quantity = Double.parseDouble(quantityTextField.getText());
    
            if (quantity < 0) {
                resultLabel.setText("Please enter a positive number.");
            } else {
                int conversionOption = conversionOptions.getSelectedIndex() + 1; // Index starts from 0
    
                double result = performConversion(quantity, conversionOption);
    
                String unitFrom = getUnitFrom(conversionOption);
                String unitTo = getUnitTo(conversionOption);
    
                resultLabel.setText(String.format("%.2f %s is equal to %.2f %s", quantity, unitFrom, result, unitTo));
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double performConversion(double quantity, int conversionOption) {
        switch (conversionOption) {
            case 1:
                return feetToMeters(quantity);
            case 2:
                return poundsToKgs(quantity);
            case 3:
                return fahrenheitToCelsius(quantity);
            default:
                throw new IllegalArgumentException("Invalid conversion option");
        }
    }

    private String getUnitFrom(int conversionOption) {
        switch (conversionOption) {
            case 1:
                return "Feet";
            case 2:
                return "Pounds";
            case 3:
                return "Fahrenheit";
            default:
                throw new IllegalArgumentException("Invalid conversion option");
        }
    }

    private String getUnitTo(int conversionOption) {
        switch (conversionOption) {
            case 1:
                return "Meters";
            case 2:
                return "Kgs";
            case 3:
                return "Celsius";
            default:
                throw new IllegalArgumentException("Invalid conversion option");
        }
    }

    private double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    private double poundsToKgs(double pounds) {
        return pounds * 0.453592;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnitsConverter();  // Corrected instantiation
            }
        });
    }
}
