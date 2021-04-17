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

package expert.allku.util;

/**
 *
 * @author Jorge Luis
 */
public class Modulo11 {
    
     private String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }

    private int obtenerSumaPorDigitos(String cadena) {

        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal = temporal * pivote;
            pivote++;
            cantidadTotal = cantidadTotal + temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        if (cantidadTotal == 10) {
            cantidadTotal = 1;
        }
        if (cantidadTotal == 11) {
            cantidadTotal = 0;
        }
        return cantidadTotal;
    }

    public int modulo11(String cadena) {
        return obtenerSumaPorDigitos(invertirCadena(cadena));
    }
}
