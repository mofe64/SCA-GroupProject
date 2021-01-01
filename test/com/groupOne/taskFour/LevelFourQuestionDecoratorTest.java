package com.groupOne.taskFour;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelFourQuestionDecoratorTest {
    Question question;
    Question levelFourQuestion;

    @BeforeEach
    void setUp() {
        question = new QuestionImpl();
        levelFourQuestion = new LevelFourQuestionDecorator(question);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatLevelNumberShouldBeSetToFourWhenLevelQuestFourQuestionInitialized() {
        assertEquals(4, levelFourQuestion.getLevelNumber());
    }

    @Test
    void testThatLevelLimitShouldBeSetToTwelveWhenLevelFourQuestionInitialized() {
        assertEquals(12, levelFourQuestion.getLevelLimit());
    }

    @Test
    void generateQuestion() {
        levelFourQuestion.generateQuestion();
        assertNotNull(levelFourQuestion.getQuestionString());
    }

    @Test
    void determineAnswer() {
        levelFourQuestion.generateQuestion();
        System.out.println(levelFourQuestion.getAnswer().toString());
        assertNotNull(levelFourQuestion.getAnswer());
    }
}