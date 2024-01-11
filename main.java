/**
* Created By: Tanishka Ghosh
* Password Maker and Checker
* Created using Swing GUI and Java
* Started on: 2024-01-09
* Finished on: 2024-01-10
* Description: A simple password maker and checker application.
* User can put in the requirements of their password. The default value is 0.
* Once the requirements are put in, the user can either make their own password
* and check if it passes the requirements, or they can request the program to
* create a password that meets the requirements for them.
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException {
        //setting up the frame
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //asking for the password criteria
        JLabel title = new JLabel("Password Checker and Generator!",
                SwingConstants.CENTER);
        title.setBounds(10, 20, 780, 30);
        frame.add(title);

        JLabel capital = new JLabel("Minimum capital letters required?");
        capital.setBounds(50, 60, 350, 20);
        frame.add(capital);
        JTextField capitalCount = new JTextField("0");
        capitalCount.setBounds(400, 60, 350, 20);
        frame.add(capitalCount);

        JLabel lower = new JLabel("Minimum lowercase letters required?");
        lower.setBounds(50, 90, 350, 20);
        frame.add(lower);
        JTextField lowerCount = new JTextField("0");
        lowerCount.setBounds(400, 90, 350, 20);
        frame.add(lowerCount);

        JLabel special = new JLabel("Minimum special characters required?");
        special.setBounds(50, 120, 350, 20);
        frame.add(special);
        JTextField specialCount = new JTextField("0");
        specialCount.setBounds(400, 120, 350, 20);
        frame.add(specialCount);

        JLabel number = new JLabel("Minimum numbers required?");
        number.setBounds(50, 150, 350, 20);
        frame.add(number);
        JTextField numberCount = new JTextField("0");
        numberCount.setBounds(400, 150, 350, 20);
        frame.add(numberCount);

        JLabel length = new JLabel("Minimum total characters required?");
        length.setBounds(50, 180, 350, 20);
        frame.add(length);
        JTextField lengthCount = new JTextField("0");
        lengthCount.setBounds(400, 180, 350, 20);
        frame.add(lengthCount);

        JLabel choice = new JLabel("What would you like to do?",
                SwingConstants.CENTER);
        choice.setBounds(10, 220, 780, 40);
        frame.add(choice);

        //place for the user to enter their password, if they're checking validity
        JTextField password = new JTextField();
        password.setBounds(100, 300, 600, 40);
        frame.add(password);

        //creating and placing buttons to ask what the user wants to do
        JButton passwordCheck = new JButton(
                "Enter password above and click here to check your password");
        passwordCheck.setBounds(100, 350, 600, 50);
        frame.add(passwordCheck);

        JButton passwordMake = new JButton(
                "Click here to generate a password");
        passwordMake.setBounds(100, 400, 600, 50);
        frame.add(passwordMake);

        //Message on inccorect user entry
        JLabel error = new JLabel("Opps! You seemed to have entered something " +
                "that wasn't a number...Try again (Make sure to put 0 instead of " +
                "leaving an empty box!)",
                SwingConstants.CENTER);
        error.setBounds(20, 500, 760, 30);
        error.setVisible(false);
        frame.add(error);

        //message on password success
        JLabel success = new JLabel("Good Job! Your password passes.",
                SwingConstants.CENTER);
        success.setBounds(100, 500, 600, 30);
        success.setVisible(false);
        frame.add(success);

        //message on password fail
        JLabel fail = new JLabel("Uh oh....Try again.",
                SwingConstants.CENTER);
        fail.setBounds(100, 500, 600, 30);

        JLabel failMessage = new JLabel("",
                SwingConstants.CENTER);
        failMessage.setBounds(100, 550, 600, 30);
        fail.setVisible(false);
        failMessage.setVisible(false);
        frame.add(fail);
        frame.add(failMessage);

        //generated password
        JTextField generatedPassword = new JTextField("",
                SwingConstants.CENTER);
        generatedPassword.setBounds(100, 500, 600, 30);
        generatedPassword.setVisible(false);
        frame.add(generatedPassword);


        //actions to perform if passwordCheck is clicked: checks the password
        passwordCheck.addActionListener(e -> {
            int capCount = 0, lowCount = 0, speCount = 0, numCount = 0, lenCount = 0;

            try {
                capCount = Integer.parseInt(capitalCount.getText());
                lowCount = Integer.parseInt(lowerCount.getText());
                speCount = Integer.parseInt(specialCount.getText());
                numCount = Integer.parseInt(numberCount.getText());
                lenCount = Integer.parseInt(lengthCount.getText());

                String passwordText = password.getText();

                for (char i : passwordText.toCharArray()){
                    if ((i >= 33 && i <= 47) || (i >= 58 && i <= 64) ||
                            (i >= 91 && i <= 96) || i >= 123 && i <= 126){
                        speCount = (speCount != 0)? speCount - 1 : 0;
                    } else if (i >= 48 && i <= 57){
                        numCount = (numCount != 0)? numCount - 1 : 0;
                    } else if (i >= 65 && i <= 90){
                        capCount = (capCount != 0)? capCount - 1 : 0;
                    } else if (i >= 97 && i <= 122) {
                        lowCount = (lowCount != 0)? lowCount - 1 : 0;
                    }
                    lenCount = (lenCount != 0)? lenCount - 1 : 0;
                }

                //reset the visibility of the success/fail messages
                if (speCount + numCount + capCount + lowCount + lenCount == 0){
                    generatedPassword.setVisible(false);
                    fail.setVisible(false);
                    failMessage.setVisible(false);
                    error.setVisible(false);
                    success.setVisible(true);
                } else  {
                    failMessage.setText("You need to add:- capital: " + capCount +
                            " lowercase: " + lowCount + " special character: " + speCount
                            + " numbers: " + numCount + " characters: " + lenCount);
                    generatedPassword.setVisible(false);
                    success.setVisible(false);
                    error.setVisible(false);
                    fail.setVisible(true);
                    failMessage.setVisible(true);
                }

            } catch (Exception NumberFormatException){
                error.setVisible(true);
            }
        });

        //actions to perform if passwordMake is clicked: make a password
        passwordMake.addActionListener(e -> {
            int capCount = 0, lowCount = 0, speCount = 0, numCount = 0, lenCount = 0;

            try {
                capCount = Integer.parseInt(capitalCount.getText());
                lowCount = Integer.parseInt(lowerCount.getText());
                speCount = Integer.parseInt(specialCount.getText());
                numCount = Integer.parseInt(numberCount.getText());
                lenCount = Integer.parseInt(lengthCount.getText());

                String passwordText = "";

                while (capCount + lowCount + speCount + numCount + lenCount != 0) {
                    char c = (char) (33 + Math.round(Math.random() * 89));
                    passwordText += c;

                    if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) ||
                            (c >= 91 && c <= 96) || c >= 123 && c <= 126){
                        speCount = (speCount != 0)? speCount - 1 : 0;
                    } else if (c >= 48 && c <= 57){
                        numCount = (numCount != 0)? numCount - 1 : 0;
                    } else if (c >= 65 && c <= 90){
                        capCount = (capCount != 0)? capCount - 1 : 0;
                    } else if (c >= 97 && c <= 122) {
                        lowCount = (lowCount != 0)? lowCount - 1 : 0;
                    }
                    lenCount = (lenCount != 0)? lenCount - 1 : 0;
                }
                generatedPassword.setText(passwordText);

                //set the visibility of the password messages
                success.setVisible(false);
                fail.setVisible(false);
                failMessage.setVisible(false);
                error.setVisible(false);
                generatedPassword.setVisible(true);

            } catch (Exception NumberFormatException){
                System.out.println("HERE!");
                error.setVisible(true);
            }
        });

        //making frame visible
        frame.setLayout(null);
        frame.setVisible(true);

    }


}
