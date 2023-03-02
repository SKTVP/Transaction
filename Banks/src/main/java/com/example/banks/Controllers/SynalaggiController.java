package com.example.banks.Controllers;

import com.example.banks.ApiResponse.ApiResponse;
import com.example.banks.Service.SynallagiService;
import com.example.banks.model.Account;
import com.example.banks.model.Synallagi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Synnlages")

public class SynalaggiController {

    @Autowired
    SynallagiService synallagiService;

    @CrossOrigin(origins = {"http://localhost:8082/"}, allowedHeaders = {"Access-Control-Allow-Origin"}, allowCredentials = "false", maxAge = 15 * 60, methods = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/create")// create mia synallagi
    public ResponseEntity<ApiResponse> Synallagi(@RequestBody Synallagi synallagi) throws Exception {

        synallagiService.metafora(synallagi.getSourceAccountID(),synallagi.getTargetAccountID(),synallagi.getAmmount());
        synallagiService.save(synallagi);


        return new ResponseEntity<> (new ApiResponse(true,"I sinallagi egine"), HttpStatus.CREATED);
    };


    @GetMapping("/listaSynalagon")
    public ResponseEntity<List<Synallagi>> ShowSynalages(){

        return new ResponseEntity<>(synallagiService.showAll(),HttpStatus.OK);

    }
}
