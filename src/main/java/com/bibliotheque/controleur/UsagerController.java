package com.bibliotheque.controleur;

import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsagerController {
    @Autowired
    UsagerService usagerService;

    

}
