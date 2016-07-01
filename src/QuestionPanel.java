import javax.swing.*;

public class QuestionPanel extends JPanel {
    private JLabel questionLabel;
    private JTextField answerField;

    public QuestionPanel() {
        questionLabel = new JLabel();
        answerField = new JTextField();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        questionLabel.setAlignmentX(0);
        answerField.setAlignmentX(0);

        add(questionLabel);
        add(answerField);
    }

    public void setQuestion(Step aStep) {
        questionLabel.setText("Step " + aStep.getStepNumber() + ": " + aStep.getQuestion());
        answerField.setText(aStep.getAnswer());
    }

    public String getAnswerFromField() {
        return answerField.getText();
    }

}
