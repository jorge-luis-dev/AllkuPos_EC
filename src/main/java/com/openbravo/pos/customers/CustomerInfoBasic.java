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

package com.openbravo.pos.customers;

import java.io.Serializable;

/** @author Jorge Luis */

public class CustomerInfoBasic implements Serializable {
    
    private static final long serialVersionUID = 9083257536541L;

    protected String id;
    protected String searchkey;
    protected String taxid;
    protected String type;
    protected String name;
    protected String address;
    protected String phone;
    protected String email;
    
    /** Creates a new instance of CustomerInfo
     * @param id */
    public CustomerInfoBasic(String id) {
        this.id = id;
        this.searchkey = id;
        this.taxid = id;
        this.type = null;
        this.name = null;
        this.address = null;
        this.phone = null;
        this.email = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchkey() {
        return searchkey;
    }

    public void setSearchkey(String searchkey) {
        this.searchkey = searchkey;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getName();
    }        
}