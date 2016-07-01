public class Step {
    private static int numberOfSteps = 0;
    private int stepNumber;
    private String question;
    private String answer = "";
    private boolean required = false;

    public Step(String aQuestion, boolean aRequired) {
        question = aQuestion;
        required = aRequired;
        stepNumber = ++numberOfSteps;

        if(required)
            question += " *";
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String aAnswer) {
        answer = aAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isRequired() {
        return required;
    }
}
