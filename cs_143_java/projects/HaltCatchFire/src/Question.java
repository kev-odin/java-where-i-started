/**
 * This class is going to store information for the trivia game read from a .txt file
 */

public class Question {
    private String category;
    private String questionString;
    private String[] choices;
    private int answer;

    public Question(String category, String questionString, String[] choices, int answer) {
        this.category = category;
        this.questionString = questionString;
        this.choices = choices;
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestionString() {
        return questionString;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getAnswer() {
        return answer;
    }
    
}
