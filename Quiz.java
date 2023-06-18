import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener{

    private String[] questions = {
            "Which team has the most UCLs?",
            "Which player has the most golden boots?",
            "Who has the most goals in the history of the premier league?",
            "Who is the all time top scorer of the world cup?"
    };
    private String[][] options = {
            {"Real Madrid", "Barcelona", "AC Milan", "Bayern Munich"},
            {"Cristiano Ronaldo", "Lionel Messi", "Gerd Muller", "Ronaldo Nazario"},
            {"Harry Kane", "Wayne Rooney", "Kun Aguero", "Alan Shearer"},
            {"Pele", "Ronaldo Nazario", "Miroslav Klose", "Just Fontaine"}
    };
    private char[] answers = {'A', 'B', 'D', 'C'};
    private char guess;
    private char answer;
    private int index;
    private int correctGuesses = 0;
    private int totalQuestions = questions.length;
    private int result;
    private int seconds = 10;
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_LabelA = new JLabel();
    JLabel answer_LabelB = new JLabel();
    JLabel answer_LabelC = new JLabel();
    JLabel answer_LabelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds <= 0) {
                displayAnswer();
            }
        }
    });
    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_LabelA.setBounds(125, 100, 500, 100);
        answer_LabelA.setBackground(new Color(50, 50, 50));
        answer_LabelA.setForeground(new Color(25, 255, 0));
        answer_LabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_LabelB.setBounds(125, 200, 500, 100);
        answer_LabelB.setBackground(new Color(50, 50, 50));
        answer_LabelB.setForeground(new Color(25, 255, 0));
        answer_LabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_LabelC.setBounds(125, 300, 500, 100);
        answer_LabelC.setBackground(new Color(50, 50, 50));
        answer_LabelC.setForeground(new Color(25, 255, 0));
        answer_LabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_LabelD.setBounds(125, 400, 500, 100);
        answer_LabelD.setBackground(new Color(50, 50, 50));
        answer_LabelD.setForeground(new Color(25, 255, 0));
        answer_LabelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Inl Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_LabelA);
        frame.add(answer_LabelB);
        frame.add(answer_LabelC);
        frame.add(answer_LabelD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);
        nextQuestion();
    }
    public void nextQuestion() {
        if(index >= totalQuestions) {
            results();
        }else {
            textField.setText("Question " + (index + 1));
            textArea.setText(questions[index]);
            answer_LabelA.setText(options[index][0]);
            answer_LabelB.setText(options[index][1]);
            answer_LabelC.setText(options[index][2]);
            answer_LabelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource() == buttonA) {
            answer = 'A';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonB) {
            answer = 'B';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonC) {
            answer = 'C';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        if(e.getSource() == buttonD) {
            answer = 'D';
            if(answer == answers[index]) {
                correctGuesses++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if(answers[index] != 'A') {
            answer_LabelA.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'B') {
            answer_LabelB.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'C') {
            answer_LabelC.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'D') {
            answer_LabelD.setForeground(new Color(255, 0, 0));
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_LabelA.setForeground(new Color(25, 255, 0));
                answer_LabelB.setForeground(new Color(25, 255, 0));
                answer_LabelC.setForeground(new Color(25, 255, 0));
                answer_LabelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        result = (int)((correctGuesses/(double)totalQuestions) * 100);
        textField.setText("RESULTS!");
        textArea.setText("");
        answer_LabelA.setText("");
        answer_LabelB.setText("");
        answer_LabelC.setText("");
        answer_LabelD.setText("");
        number_right.setText(correctGuesses + "/" + totalQuestions);
        percentage.setText(result + "%");
        frame.add(percentage);
        frame.add(number_right);
    }
}
