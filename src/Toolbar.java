import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Toolbar extends JPanel implements ActionListener {
    private JButton previousButton;
    private JButton nextButton;
    private JButton finishButton;
    private QuestionPanel questionPanel;

    private List<Step> steps;
    private int actualStep;


    public Toolbar() {
        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");
        finishButton = new JButton("Finish");

        setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(previousButton);
        add(nextButton);
        add(finishButton);

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        finishButton.addActionListener(this);

        previousButton.setEnabled(false);
        nextButton.setEnabled(false);
        finishButton.setEnabled(false);
    }

    public void setQuestionPanel(QuestionPanel aQuestionPanel) {
        questionPanel = aQuestionPanel;
    }

    public void setStepsList(List<Step> aSteps) {
        steps = aSteps;

        if(steps.size() > 0) {
            actualStep = 0;
            questionPanel.setQuestion(steps.get(actualStep));

            if (actualStep == steps.size()) {
                finishButton.setEnabled(true);
            }
            else if(actualStep < steps.size()) {
                nextButton.setEnabled(true);
            }
        }
    }

    private void saveAnswerFromField() {
        steps.get(actualStep).setAnswer(questionPanel.getAnswerFromField());
    }

    private boolean isAnswerFieldEmpty() {
        return questionPanel.getAnswerFromField().equals("");
    }

    private boolean isAnswerRequired() {
        return steps.get(actualStep).isRequired();
    }

    private boolean checkField() {
        return !(isAnswerRequired() && isAnswerFieldEmpty());
    }

    private boolean isFirstStep() {
        return actualStep == 0;
    }

    private boolean isLastStep() {
        return actualStep == steps.size() - 1;
    }

    private void nextQuestion() {
        questionPanel.setQuestion(steps.get(++actualStep));
    }

    private void previousQuestion() {
        questionPanel.setQuestion(steps.get(--actualStep));
    }

    private void showMessage(String aMessage) {
        JOptionPane.showMessageDialog(this,  aMessage,  "Problem...", JOptionPane.ERROR_MESSAGE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(clicked == nextButton) {
            if(checkField()) {
                saveAnswerFromField();
                nextQuestion();

                if (isLastStep()) {
                    nextButton.setEnabled(false);
                    finishButton.setEnabled(true);
                }

                previousButton.setEnabled(true);
            }
            else {
                showMessage("This field is required.");
            }
        }
        else if(clicked == previousButton) {
            saveAnswerFromField();
            previousQuestion();

            if(isFirstStep()) {
                previousButton.setEnabled(false);
            }

            nextButton.setEnabled(true);
        }
        else if(clicked == finishButton) {
            if(checkField()) {
                saveAnswerFromField();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new SummaryFrame(steps);
                    }
                });
            }
            else {
                showMessage("This field is required.");
            }
        }
    }
}
