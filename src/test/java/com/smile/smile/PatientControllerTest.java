package com.smile.smile;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.smile.smile.controllers.PatientController;
import com.smile.smile.model.PatientModel;
import com.smile.smile.services.PatientService;

@WebMvcTest(value = PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PatientService service;

    @Test
    public void testRetreiveAllPatients() throws Exception {

        // Given
        List<PatientModel> patients = new ArrayList<PatientModel>();
        PatientModel patient1 = new PatientModel("00112233H");
        PatientModel patient2 = new PatientModel("00112244J");
        patients.add(patient1);
        patients.add(patient2);

        when(service.getAll()).thenReturn(patients);
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/patients"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        assertEquals(response.getStatus(), 200);
        assertEquals(response.getContentAsString(), "[{\"dniPatient\":\"00112233H\"},{\"dniPatient\":\"00112244J\"}]");
    }

}
