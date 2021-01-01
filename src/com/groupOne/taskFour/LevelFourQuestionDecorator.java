package com.groupOne.taskFour;

public class LevelFourQuestionDecorator extends QuestionDecorator {
    Question question;

    public LevelFourQuestionDecorator(Question question) {
        this.question = question;
        this.levelLimit = 12;
        this.levelNumber = 4;
    }

    @Override
    public String generateQuestion() {
        clearPreviousQuestionState();
        int operand1 = 1 + secureRandom.nextInt(5);
        int operand2 = 1 + secureRandom.nextInt(5);
        int operand3 = 1 + secureRandom.nextInt(5);
        int operand4 = 1 + secureRandom.nextInt(5);
        questionString = stringBuilder.append(operand1).append(" * ").append(operand2).append(" * ").append(operand3)
                .append(" * ").append(operand4).toString();
        determineAnswer(operand1, operand2, operand3, operand4);
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
