/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.admin;

/**
 *
 * @author jorgeluis
 */
public class TaxpayerInfo {
    
    private String identification;
    private String legalName; 
    private String comercialName;
    private String forcedAccounting;
    private String specialContributor;
    private String microBusiness;
    private String legalretentionAgent;
    private String address;
    private String phone;
    private String eMail;

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getComercialName() {
        return comercialName;
    }

    public void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }

    public String getForcedAccounting() {
        return forcedAccounting;
    }

    public void setForcedAccounting(String forcedAccounting) {
        this.forcedAccounting = forcedAccounting;
    }

    public String getSpecialContributor() {
        return specialContributor;
    }

    public void setSpecialContributor(String specialContributor) {        
        this.specialContributor = specialContributor;
    }

    public String getMicroBusiness() {
        return microBusiness;
    }

    public void setMicroBusiness(String microBusiness) {
        this.microBusiness = microBusiness;
    }

    public String getLegalretentionAgent() {
        return legalretentionAgent;
    }

    public void setLegalretentionAgent(String legalretentionAgent) {
        this.legalretentionAgent = legalretentionAgent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }        
}
