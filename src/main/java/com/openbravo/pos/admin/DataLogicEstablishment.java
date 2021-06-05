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
 * @author Jorge Luis
 */
public class DataLogicEstablishment extends BeanFactoryDataSingle {

    private Session s;
    private TableDefinition m_tEstablishment;

    /**
     * Creates a new instance of DataLogicAdmin
     */
    public DataLogicEstablishment() {
    }

    /**
     *
     * @param s
     */
    @Override
    public void init(Session s) {
        this.s = s;

        m_tEstablishment = new TableDefinition(s,
                "establishment",
                 new String[]{"ID", "COMERCIAL_NAME", "ADDRESS",
                    "CITY", "STATUS"},
                 new String[]{"ID", "COMERCIAL_NAME", "ADDRESS",
                    "CITY", "STATUS"},
                 new Datas[]{Datas.STRING, Datas.STRING, Datas.STRING,
                    Datas.STRING, Datas.STRING},
                 new Formats[]{Formats.STRING, Formats.STRING, Formats.STRING,
                    Formats.STRING, Formats.STRING},
                 new int[]{0}
        );
    }

    
      /**
     * Sequence table sales
     *
     * @return
     */
    public final TableDefinition getTableEstablishment() {
        return new TableDefinition(s,
                "establishment",
                new String[]{"ID", "COMERCIAL_NAME", "ADDRESS",
                    "CITY", "STATUS"},
                new String[]{"ID", "COMERCIAL_NAME", "ADDRESS",
                    "CITY", "STATUS"},
                new Datas[]{Datas.STRING, Datas.STRING, Datas.STRING,
                    Datas.STRING, Datas.STRING},
                new Formats[]{Formats.STRING, Formats.STRING, Formats.STRING,
                    Formats.STRING, Formats.STRING},
                new int[]{0}
        );
    }
    
    /**
     * 
     * @param establishment
     * @return 
     */
    public SentenceList getComercialNameEstablishment(String establishment) {
        return new StaticSentence(s,
                "select comercial_name from establishment "
                + "where id = '" + establishment + "' "
                + "and status = 'Activo'",
                null,
                new SerializerRead() {
            public Object readValues(DataRead dr) throws BasicException {
                return new String(dr.getString(1));
            }
        });
    }
}
