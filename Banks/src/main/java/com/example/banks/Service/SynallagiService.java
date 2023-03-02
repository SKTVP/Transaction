package com.example.banks.Service;



import com.example.banks.Repository.AccountRepository;
import com.example.banks.Repository.SynalagiRepository;
import com.example.banks.model.Account;
import com.example.banks.model.Synallagi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SynallagiService {
    @Autowired
    SynalagiRepository synalagiRepository;
    @Autowired
    AccountRepository accountRepository;

          public void metafora(Integer SourceID, Integer TargetID, double balance ) throws Exception {

            // tous brisko sto database


            Optional<Account> source=accountRepository.findById(SourceID);
            Optional<Account> target=accountRepository.findById(TargetID);



            //elegxos an to balance ine arnitiko

            if(balance <0 ){
                throw new Exception("arnitiko poso");
            }

////            //elegxos an iparxoun oi logariasmoi
////
           if(source.isEmpty() || target.isEmpty()){
               throw new Exception("den yparxei logariasmos");
           }
////
////            // an yparxoun tous perno
////
            Account source1=source.get();
            Account target1=target.get();

////            // elegxos an ine idios o arithmos apostolis me ton target logariasmo
////
            if(source1.equals(target1)){
                throw new Exception("Idios logariasmos");
            }
////
////            //ftiaxno to pos allazoun ta balance tou source kai tou target
////
            double sourcebalance=source1.getBalance()-balance;
////
////            // an to balance tou source einai mikrotero apo afto to tou zitoumenou balance amount bgale error
////
            if(sourcebalance<0){
                throw new Exception("den yparxei ipolipo ");
            }
////
////            //poso tha ine to poso tou target
////
            double targetbalance= target1.getBalance()+balance;
////
////            // edo kano set to teliko balance ammount tous
////
            source1.setBalance(sourcebalance);
            target1.setBalance(targetbalance);
////
////            // kai edo tous bazo to modified time
////
            source1.setModifiedOn(LocalDateTime.now());
            target1.setModifiedOn(LocalDateTime.now());
       }
//
//
//
//        // kano save tin synallagi stin basi dedomenon
        public void save(Synallagi synallagi){
            synalagiRepository.save(synallagi);
        }

    ////// na dixnei tis sinallages gia to get method.//////
    public List<Synallagi> showAll() {

        List<Synallagi> lista= synalagiRepository.findAll();
        return lista;

    }
}
