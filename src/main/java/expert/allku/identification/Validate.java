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

package expert.allku.identification;

import com.openbravo.pos.forms.AppLocal;
import javax.swing.JOptionPane;
import expert.allku.identification.*;

/**
 *
 * @author Jorge Luis
 */
public class Validate {    
    
    public Boolean identification(String identificationType, String identification) {
        if (identificationType.equals("C")) {
            Ci ci = new Ci(identification);
            if(!ci.validar()) {
                JOptionPane.showMessageDialog(null,
                        ci.getError(), 
                        "Error al validar la cédula", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else if (identificationType.equals("R")) {
            Ruc ruc = new Ruc(identification);
            if(!ruc.validar()) {
                JOptionPane.showMessageDialog(null,
                        ruc.getError(), 
                        "Error al validar la RUC", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else if (identificationType.equals("CF")) {
            if (!identification.equals("9999999999999")) {
                JOptionPane.showMessageDialog(null,
                        "El consumidor final debe ser 9999999999999", 
                        "Error al validar el Consumidor Final", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }    
    
    public Boolean blank(String identification, String name) {
        if ("".equals(identification)
                || "".equals(name)) {
            JOptionPane.showMessageDialog(
                null, 
                AppLocal.getIntString("message.customercheck"), 
                "Validación del cliente", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
