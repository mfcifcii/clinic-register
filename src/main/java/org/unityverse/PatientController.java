package org.unityverse;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients";
    }

    @PostMapping("/register")
    public String registerSubmit(
            @Valid @ModelAttribute("patient") Patient patient,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        Patient saved = patientService.register(patient);
        model.addAttribute("patient", saved);
        return "result";
    }
}