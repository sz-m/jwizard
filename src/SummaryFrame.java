import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SummaryFrame extends JFrame {
    public SummaryFrame(List<Step> aSteps) {
        super("Summary");
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 10, 100, 200);
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        for(Step step : aSteps) {
            textArea.append(step.getQuestion() + " : " + step.getAnswer() + "\n");
        }


        setSize(400, 200);
        setVisible(true);
    }
}
