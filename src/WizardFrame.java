import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WizardFrame extends JFrame {
    private QuestionPanel questionPanel;
    private Toolbar toolbar;

    public WizardFrame(List<Step> aSteps, String aTitle) {
        super(aTitle);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30, 30, 5, 30);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 3;

        questionPanel = new QuestionPanel();
        c.gridx = 0;
        c.gridy = 0;
        add(questionPanel, c);

        toolbar = new Toolbar();
        c.gridx = 0;
        c.gridy = 1;
        add(toolbar, c);

        toolbar.setQuestionPanel(questionPanel);
        toolbar.setStepsList(aSteps);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
