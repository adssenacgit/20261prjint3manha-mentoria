package br.com.johnny.mentoria.controller;

import br.com.johnny.mentoria.dto.MentorRequest;
import br.com.johnny.mentoria.dto.MentorResponse;
import br.com.johnny.mentoria.service.MentorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/mentores")
@Tag(name = "Mentores")
@CrossOrigin("*")    
public class MentorController extends BaseCrudController<Integer, MentorRequest, MentorResponse> {

    public MentorController(MentorService service) {
        super(service);
    }
}
