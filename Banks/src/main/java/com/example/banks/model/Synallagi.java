package com.example.banks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Synalagges")
public class Synallagi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_synalagis")
    private int ID;

//    @ManyToOne
//    @JoinColumn(name = "sourceAccountId")
@JsonProperty("SourceAccountID")
    private int SourceAccountID;

//    @ManyToOne
//    @JoinColumn(name = "targetAccountId")

    @JsonProperty("TargetAccountID")
    private  int TargetAccountID;

    @Positive

    private double ammount;

    private String currency;

    public int getSourceAccountID() {
        return SourceAccountID;
    }

    public void setSourceAccountID(int sourceAccountID) {
        SourceAccountID = sourceAccountID;
    }

    public int getTargetAccountID() {
        return TargetAccountID;
    }

    public void setTargetAccountID(int targetAccountID) {
        TargetAccountID = targetAccountID;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Synallagi(int sourceAccountID, int targetAccountID, double ammount, String currency) {
        this.SourceAccountID = sourceAccountID;
        this.TargetAccountID = targetAccountID;
        this.ammount = ammount;
        this.currency = currency;
    }
}
