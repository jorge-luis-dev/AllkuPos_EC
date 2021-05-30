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
public class ExtractNames {

    public String extractLastName(String name) {

        String[] words = name.split(" ");
        String apellido = "";
        int spaceCount = countWhiteSpace(name);
        int i = 0;

        if (spaceCount == 0) {
            return name;
        }

        for (String token : words) {
            apellido = apellido + token;
            if (spaceCount - 1 == i || i == 1) {
                return apellido.trim();
            }
            apellido = apellido + " ";
            i++;
        }

        return "";
    }

    public String extractFirstName(String name) {

        String[] words = name.split(" ");
        String nombre = "";
        int spaceCount = countWhiteSpace(name);
        int i = 0;

        for (String token : words) {
            if (spaceCount == i || i > 1) {
                nombre = nombre + token;
                nombre = nombre + " ";
            }
            i++;
        }

        return nombre;
    }

    int countWhiteSpace(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }
}
