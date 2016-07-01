import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private List<Step> steps = new ArrayList<Step>();
    private String title;

    public Wizard(String aTitle) {
        title = aTitle;
    }

    public void addStep(String aQuestion) {
        steps.add(new Step(aQuestion, false));
    }

    public void addStep(String aQuestion, boolean aRequired) {
        steps.add(new Step(aQuestion, aRequired));
    }

    public void generate() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WizardFrame(steps, title);
            }
        });
    }
}
