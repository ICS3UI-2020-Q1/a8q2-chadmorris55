import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

  JButton validateButton;
  JButton resetButton;

  JTextArea outputTextArea;
  JTextArea instructionTextArea;

  JPanel mainPanel;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize main main panel 
    mainPanel = new JPanel();
    //tells main panel we will do a  manual layout
    mainPanel.setLayout(null);
    //initialize first label
    firstLabel = new JLabel("Enter the first side:");
    //sets bounds of first label
    firstLabel.setBounds(10, 10, 200, 20);

    //Finish last two labels
    secondLabel = new JLabel("Enter the second side:");
    secondLabel.setBounds(10,40,200,20);
    thirdLabel = new JLabel("Enter the third side:");
    thirdLabel.setBounds(10,70,200,20);

    //create the text boxes
    firstInput = new JTextField();
    firstInput.setBounds(220, 10, 150, 20);
    secondInput = new JTextField();
    secondInput.setBounds(220, 40, 150, 20);
    thirdInput = new JTextField();
    thirdInput.setBounds(220, 70, 150, 20);

    //initialize buttons
    validateButton = new JButton("Validate");
    validateButton.setBounds(380, 10, 100, 35);
    resetButton = new JButton("Reset");
    resetButton.setBounds(380, 55, 100, 35);

    //set the action command so we know which button was pressedv
    validateButton.setActionCommand("validate");
    resetButton.setActionCommand("reset");

    //add the acton listener to the buttons
    validateButton.addActionListener(this);
    resetButton.addActionListener(this);

    //initialize the text areas
    outputTextArea = new JTextArea();
    outputTextArea.setBounds(10, 100, 780, 240);
    instructionTextArea = new JTextArea();
    instructionTextArea.setBounds(10, 350, 780, 240);

    String instructionText = "This is a simple Triangle Detector.\nEnter an integer into each pf the textfields above.\nPress the button \" Validate\" to check whether or not the triangle is valid\nPress Reset to start all over.";
    instructionTextArea.setText(instructionText);

    //makes it so that the user cant type int these text boxes
    outputTextArea.setEnabled(false);
    instructionTextArea.setEnabled(false);
    //add the things to the main panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(thirdInput);
    mainPanel.add(validateButton);
    mainPanel.add(resetButton);
    mainPanel.add(outputTextArea);
    mainPanel.add(instructionTextArea);
    //add the main panel to the screen
    frame.add(mainPanel);

  }


  //method to determine if a triangle is valid when given the three side lengths
  public boolean isValidtriangle(int a, int b, int c){
    if(a + b > c && a + c > b && b + c > a){
      return true;
    } else {
      return false;
    }
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    //deal with the buttons being pressed
    if(command.equals("reset")){
      //reset button pressed
      //clears all text
      firstInput.setText("");
      secondInput.setText("");
      thirdInput.setText("");
      outputTextArea.setText("");
  } else if(command.equals("validate")){
    //valiodate button was pressed
    //grabs the text that appears in eachg box
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();
    String thirdText = thirdInput.getText();

    //convert these strings into integers
    int firstSide = Integer.parseInt(firstText);
    int secondSide = Integer.parseInt(secondText);
    int thirdSide = Integer.parseInt(thirdText);

    boolean isValid = isValidtriangle(firstSide, secondSide, thirdSide);

    //check the result

    if(isValid){
      outputTextArea.setText("This is a valid triangle.");
    } else {
      outputTextArea.setText("This is not a valid triangle.");
    }
  }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
