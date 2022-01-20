package com.appleindustries.mirror.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zane
 */
class MirrorServiceImplTest {
    private MirrorService mirrorService;

    @BeforeEach
    void setUp() {
        mirrorService = new MirrorServiceImpl();
    }

    @Test
    void mirrorSentence() {
        String sentence = "Hello World.";
        String mirroredSentence = ".World Hello";

        assertEquals(mirroredSentence, mirrorService.mirrorSentence(sentence));
    }
}