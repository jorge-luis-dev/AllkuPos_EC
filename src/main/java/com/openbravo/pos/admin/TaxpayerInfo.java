//    Allku Pos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://www.allku.expert
//
//    This file is part of Allku Pos
//
//    Allku Pos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Allku Pos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Allku Pos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * @author Jorge Luis
 */
public class TaxpayerInfo implements SerializableRead {

    private String identification;
    private String legalName;    
    private String forcedAccounting;
    private String specialContributor;
    private String microBusiness;
    private String retentionAgent;
    private String address;
    private String phone;
    private String eMail;
    private String comercialNameByEstablishment;

    public TaxpayerInfo() {
        this.identification = "";
        this.legalName = "";
        this.forcedAccounting = "";
        this.specialContributor = "";
        this.microBusiness = "";
        this.retentionAgent = "";
        this.address = "";
        this.phone = "";
        this.eMail = "";
        this.comercialNameByEstablishment = "";
    }        

    public TaxpayerInfo(String identification, String legalName, String forcedAccounting, String specialContributor, String microBusiness, String retentionAgent, String address, String phone, String eMail) {
        this.identification = identification;
        this.legalName = legalName;
        this.forcedAccounting = forcedAccounting;
        this.specialContributor = specialContributor;
        this.microBusiness = microBusiness;
        this.retentionAgent = retentionAgent;
        this.address = address;
        this.phone = phone;
        this.eMail = eMail;
        this.comercialNameByEstablishment = "";
    }

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

    public String getRetentionAgent() {
        return retentionAgent;
    }

    public void setRetentionAgent(String retentionAgent) {
        this.retentionAgent = retentionAgent;
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
    
    public String getComercialNameByEstablishment() {
        return comercialNameByEstablishment;
    }

    public void setComercialNameByEstablishment(String comercialNameByEstablishment) {
        this.comercialNameByEstablishment = comercialNameByEstablishment;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        this.identification = dr.getString(1);
        this.legalName = dr.getString(2);        
        this.forcedAccounting = dr.getString(3);
        this.specialContributor = dr.getString(4);
        this.microBusiness = dr.getString(5);
        this.retentionAgent = dr.getString(6);
        this.address = dr.getString(7);
        this.phone = dr.getString(8);
        this.eMail = dr.getString(9);
    }
}
