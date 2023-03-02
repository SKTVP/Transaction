package com.example.banks.Controllers;

import com.example.banks.ApiResponse.ApiResponse;
import com.example.banks.Service.AccountService;
import com.example.banks.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/logariasmoi")
public class AccountController {
    @Autowired
    AccountService accountService;
    //@CrossOrigin(origins = {"http://localhost:8082/"}, allowedHeaders = {"Access-Control-Allow-Origin"}, allowCredentials = "false", maxAge = 15 * 60, methods = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createAccount(@RequestBody Account account) {

        accountService.save(account);
        return new ResponseEntity<> (new ApiResponse(true,"Account has been created"),HttpStatus.CREATED);

    };

    @GetMapping("/Logariasmoi")
    public ResponseEntity<List<Account>> getAllLogariasmous(){

        return new ResponseEntity<>(accountService.showAll(),HttpStatus.OK);
    }




}
