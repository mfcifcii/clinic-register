package org.unityverse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PatientService patientService;

    @Test
    void getRegisterForm_shouldReturnRegisterView_withEmptyPatient() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("patient"));
    }

    @Test
    void postRegister_withValidPatient_shouldReturnResult() throws Exception {
        Patient saved = new Patient();
        saved.setName("Ali");
        saved.setSurname("Veli");
        saved.setPhoneNumber("05551234567");
        saved.setEmail("ali@example.com");
        saved.setPatientNo(1000);

        when(patientService.register(any(Patient.class))).thenReturn(saved);

        mockMvc.perform(post("/register")
                        .param("name", "Ali")
                        .param("surname", "Veli")
                        .param("phoneNumber", "05551234567")
                        .param("email", "ali@example.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeHasNoErrors("patient"))
                .andExpect(content().string(containsString("1000")))
                .andExpect(content().string(containsString("Ali")));
    }

    @Test
    void postRegister_withInvalidPatient_shouldReturnRegisterView_withErrors() throws Exception {
        mockMvc.perform(post("/register")
                        .param("name", "")
                        .param("surname", "")
                        .param("phoneNumber", "123")
                        .param("email", "not-an-email"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeHasFieldErrors("patient", "name", "surname", "phoneNumber", "email"));
    }

    @Test
    void getPatients_shouldRenderPatientsView() throws Exception {
        Patient p = new Patient();
        p.setPatientNo(1000);
        p.setName("Ayşe");
        p.setSurname("Yılmaz");
        p.setPhoneNumber("05321234567");
        p.setEmail("ayse@example.com");

        when(patientService.findAll()).thenReturn(List.of(p));

        mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(view().name("patients"))
                .andExpect(content().string(containsString("Ayşe")))
                .andExpect(content().string(containsString("ayse@example.com")));
    }
}