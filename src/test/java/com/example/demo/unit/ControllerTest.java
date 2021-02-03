package com.example.demo.unit;

import com.example.demo.controller.DemoController;
import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
public class ControllerTest {

    public DemoController demoController;

    @MockBean
    public DemoService demoService;

    @BeforeEach
    public void setup() {
        demoController = new DemoController(demoService);
    }

    @Test
    public void whenFindAllDemosShouldReturnAListOfDemosFromZeroToN(){

        //arrange
        when(demoService.findAllDemos()).thenReturn(Arrays.asList(Demo.builder().id(UUID.randomUUID()).userName("User1").password("Pass****").build()));

        //act
        ResponseEntity<List<Demo>> response = demoController.findAllDemos();

        //assert
        assertEquals("The 'response' body should contain 1 element.", 1, response.getBody().size());

    }


}
