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

package com.openbravo.data.loader;

/**
 *
 * @author adrianromero
 */
public interface SessionDB {

    /**
     *
     * @return
     */
    public String TRUE();

    /**
     *
     * @return
     */
    public String FALSE();

    /**
     *
     * @return
     */
    public String INTEGER_NULL();

    /**
     *
     * @return
     */
    public String CHAR_NULL();

    /**
     *
     * @return
     */
    public String getName();

    /**
     * Get sequence from ticketsnum
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind getSequenceSentence(Session s, String sequence);
    
    /**
     * Get sequence from ticketsnum by user or people
     * @param s
     * @param sequence
     * @param peopleId
     * @return 
     */
    public SentenceFind getSequenceSentence(Session s, String sequence, String peopleId);

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind resetSequenceSentence(Session s, String sequence);
    
}


