package com.groupOne.taskFour;

public class LevelThreeQuestionDecorator extends QuestionDecorator {
    Question question;

    public LevelThreeQuestionDecorator(Question question) {
        this.question = question;
        this.levelLimit = 10;
        this.levelNumber = 3;
    }

    @Override
    public String generateQuestion() {
        clearPreviousQuestionState();
        int operand1 = secureRandom.nextInt(5);
        int operand2 = secureRandom.nextInt(5);
        int operand3 = secureRandom.nextInt(5);
        questionString = stringBuilder.append(operand1).append(" * ").append(operand2).append(" * ").append(operand3).toString();
        determineAnswer(operand1, operand2, operand3);
        return questionString;
    }

    @Override
    public void determineAnswer(int... operands) {
        int result = 1;
        for (int operand : operands) {
            result *= operand;
        }
        answer = result;
    }
}
