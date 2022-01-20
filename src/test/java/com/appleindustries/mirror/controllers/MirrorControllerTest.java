package com.appleindustries.mirror.controllers;

import com.appleindustries.mirror.services.MirrorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author zane
 */
class MirrorControllerTest {

    @Mock
    private MirrorService mirrorService;

    @InjectMocks
    private MirrorController mirrorController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mirrorController).build();
    }

    @Test
    void mirrorSentence() throws Exception {
        String mirroredSentence = ".World Hello";
        when(mirrorService.mirrorSentence(anyString())).thenReturn(mirroredSentence);

        mockMvc.perform(get("/mirror/Hello World."))
                .andExpect(status().isOk())
                .andExpect(content().string(mirroredSentence));
    }
}