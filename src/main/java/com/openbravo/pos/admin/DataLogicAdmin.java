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
import com.openbravo.data.loader.*;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.BeanFactoryDataSingle;

/**
 *
 * @author adrianromero, Jorge Luis
 */
public class DataLogicAdmin extends BeanFactoryDataSingle {
    
    private Session s;
    private TableDefinition m_tpeople;
    private TableDefinition m_troles;
    private TableDefinition m_tresources;    
    private TableDefinition m_ttaxpayer;    
    
    
    /** Creates a new instance of DataLogicAdmin */
    public DataLogicAdmin() {
    }
    
    /**
     *
     * @param s
     */
    @Override
    public void init(Session s){
        this.s = s;
        
        m_tpeople = new TableDefinition(s,
            "people"
            , new String[] {"ID", "NAME", "APPPASSWORD", "ROLE", "VISIBLE", "CARD", "IMAGE"}
            , new String[] {"ID", AppLocal.getIntString("label.peoplename"), AppLocal.getIntString("label.Password"), AppLocal.getIntString("label.role"), AppLocal.getIntString("label.peoplevisible"), AppLocal.getIntString("label.card"), AppLocal.getIntString("label.peopleimage")}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.BOOLEAN, Datas.STRING, Datas.IMAGE}
            , new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.BOOLEAN, Formats.STRING, Formats.NULL}
            , new int[] {0}
        );   
                        
        m_troles = new TableDefinition(s,
            "roles"
            , new String[] {"ID", "NAME", "PERMISSIONS"}
            , new String[] {"ID", AppLocal.getIntString("label.name"), "PERMISSIONS"}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.BYTES}
            , new Formats[] {Formats.STRING, Formats.STRING, Formats.NULL}
            , new int[] {0}
        );  
        
        m_tresources = new TableDefinition(s,
            "resources"
            , new String[] {
                "ID", "NAME", "RESTYPE", "CONTENT"}
            , new String[] {
                "ID", 
                AppLocal.getIntString("label.name"), 
                AppLocal.getIntString("label.type"), 
                "CONTENT"}
            , new Datas[] {
                Datas.STRING, Datas.STRING, Datas.INT, Datas.BYTES}
            , new Formats[] {
                Formats.STRING, Formats.STRING, Formats.INT, Formats.NULL}
            , new int[] {0}
        );        
        
        m_ttaxpayer = new TableDefinition(s,
            "taxpayer"
            , new String[] {"ID", "IDENTIFICATION", "LEGAL_NAME",
                "FORCED_ACCOUNTING", "SPECIAL_CONTRIBUTOR", "MICRO_BUSINESS",
                "RETENTION_AGENT", "ADDRESS", "PHONE", "EMAIL"}
            , new String[] {"ID", "IDENTIFICATION", "LEGAL_NAME",
                "FORCED_ACCOUNTING", "SPECIAL_CONTRIBUTOR", "MICRO_BUSINESS",
                "RETENTION_AGENT", "ADDRESS", "PHONE", "EMAIL"}
            , new Datas[] {Datas.INT, Datas.STRING, Datas.STRING, Datas.STRING,
                Datas.STRING, Datas.STRING, Datas.STRING,
                Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING}
            , new Formats[] {Formats.INT, Formats.STRING, Formats.STRING, Formats.STRING,
                Formats.STRING, Formats.STRING, Formats.STRING,
                Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING}
            , new int[] {0}
        );  
    }
       
    /**
     *
     * @return
     */
    public final SentenceList getRolesList() {
        return new StaticSentence(s
            , "SELECT ID, NAME FROM roles ORDER BY NAME"
            , null
            , new SerializerReadClass(RoleInfo.class));
    }

    /**
     *
     * @return
     */
    public final TableDefinition getTablePeople() {
        return m_tpeople;
    }    

    /**
     *
     * @return
     */
    public final TableDefinition getTableRoles() {
        return m_troles;
    }

    /**
     *
     * @return
     */
    public final TableDefinition getTableResources() {
        return m_tresources;
    }
    
    public final TableDefinition getTableTaxpayer() {
        return m_ttaxpayer;
    }
    
    /**
     *
     * @return
     */
    public final SentenceList getPeopleList() {
        return new StaticSentence(s
                , "SELECT ID, NAME FROM people ORDER BY NAME"
                , null
                , new SerializerReadClass(PeopleInfo.class));
    }    
    
    public final TaxpayerInfo getTaxpayerInfo() throws BasicException {
        return (TaxpayerInfo) new PreparedSentence(s
            ,"SELECT IDENTIFICATION, LEGAL_NAME, "
                        + "FORCED_ACCOUNTING, SPECIAL_CONTRIBUTOR, "
                        + "MICRO_BUSINESS, RETENTION_AGENT, ADDRESS, PHONE, "
                    + "EMAIL " +
                  "FROM taxpayer " +
             "WHERE ID = ?"
                , SerializerWriteString.INSTANCE , (DataRead dr) -> {
                    TaxpayerInfo c = new TaxpayerInfo();
                    c.setIdentification(dr.getString(1));
                    c.setLegalName(dr.getString(2));
                    c.setForcedAccounting(dr.getString(3));
                    c.setSpecialContributor(dr.getString(4));
                    c.setMicroBusiness(dr.getString(5));
                    c.setRetentionAgent(dr.getString(6));
                    c.setAddress(dr.getString(7));
                    c.setPhone(dr.getString(8));
                    c.seteMail(dr.getString(9));
            return c;
        }).find("1");
    }
}
