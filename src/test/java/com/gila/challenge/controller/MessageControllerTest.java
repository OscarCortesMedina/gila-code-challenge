package com.gila.challenge.controller;

import com.gila.challenge.service.NotificationService;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private MessageController messageController;

    private MockMvc mockMvc;

    @Test
    public void testCreateMessageSuccess() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

        String category = "SPORTS";
        String message = "Test message";

        mockMvc.perform(post("/api/messages")
                        .param("category", category)
                        .param("message", message)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateMessageFailMissingMessage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

        String category = "SPORTS";
        String message = "";
        assertThrows(ServletException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                mockMvc.perform(post("/api/messages")
                        .param("category", category)
                        .param("message", message)
                        .contentType(MediaType.APPLICATION_JSON));
            }
        });

    }

    @Test
    public void testCreateMessageFailBadCategory() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

        String category = "TEST";
        String message = "Test message";

        mockMvc.perform(post("/api/messages")
                        .param("category", category)
                        .param("message", message)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }


}