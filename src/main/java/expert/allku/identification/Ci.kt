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

package expert.allku.identification

/**
 * Created by jorge luis on 2021/03/03
 */
open class Ci(val ci : String){

    var error :  String = ""

    open fun validar() : Boolean {
        if (!basica(10))
            return false
        if (!provincia())
            return false
        if (!modulo10())
            return false
        return true
    }

    /**
    Función que verifica si son los digitos correctos
     */
    fun basica(dijitos : Int) : Boolean {
        if(isNumeric(ci)){
            val l = ci.length
            println("Longitud de cadena: $l")
            if (l == dijitos)
                return true
            else {
                error = "El número de díjitos es de 10 para la Cédula y 13 para el RUC"
                return false
            }
        }

        return false
    }
    /**
    Función que identifica si es un número
     */
    fun isNumeric(input : String) : Boolean {
        try {
            input.toLong()
            return true
        } catch (e: NumberFormatException) {
            error = "La cédula y el RUC deben tener solo valores numéricos"
            return false
        }
    }
    /**
    Función que verifica la provincia
     */
    fun provincia() : Boolean {
        val p = ci.substring(0,2).toInt()

        if (p == 30 || (p > 0 && p <= 24)) {
            println("Provincia: $p")
            return true
        }
        error = "La provincia no corresponde, debe comenzar entre 1 y 24 o 30"
        return false
    }
    /**
     * Algoritmo Modulo10 para validar si CI y RUC de persona natural son válidos.
     *
     * Los coeficientes usados para verificar el décimo díjito de la cédula,
     * mediante el algoritmo Módulo 10 son: 2. 1. 2. 1. 2. 1. 2. 1. 2
     *
     * Paso 1: Multiplicar cada díjito de los díjitos iniciales por su respectivo
     * coeficiente.
     *
     * Ejemplo
     * digitosIniciales posicion 1 x 2
     * digitosIniciales posicion 2 x 1
     * digitosIniciales posicion 3 x 2
     * digitosIniciales posicion 4 x 1
     * digitosIniciales posicion 5 x 2
     * digitosIniciales posicion 6 x 1
     * digitosIniciales posicion 7 x 2
     * digitosIniciales posicion 8 x 1
     * digitosIniciales posicion 9 x 2
     *
     * Paso 2: Sí alguno de los resultados de cada multiplicación es mayor a o igual a 10,
     * se suma entre ambos díjitos de dicho resultado. Ex. 12->1+2->3
     *
     * Paso 3: Se suman los resultados y se obtiene total
     *
     * Paso 4: Divido total para 10, se guarda residuo. Se resta 10 menos el residuo.
     * El valor obtenido debe concordar con el díjito verificador
     *
     * Nota: Cuando el residuo es cero(0) el díjito verificador debe ser 0.
     */

    fun modulo10() : Boolean {
        val dijitos = ci.substring(0,9).toCharArray()
        val verificador = ci.substring(9,10).toInt()
        val multiplicadores : IntArray = intArrayOf(2,1,2,1,2,1,2,1,2)
        var valor : Int
        var total : Int = 0
        val residuo : Int
        val resultado : Int

        println("Algoritmo Módulo 10")
        println("Verificador: ${verificador}")

        for (i in dijitos.indices){
            val multiplicador = multiplicadores[i]
            val dijito  = dijitos[i].toString().toInt()
            valor = multiplicador*dijito

            if (valor >= 10) {
                valor = valor.toString().substring(0, 1).toInt() + valor.toString().substring(1, 2).toInt()
            }

            println("Multiplicador:  ${multiplicador} * Díjito: ${dijitos[i]} = $valor")

            total = total + valor
        }
        println("Total = $total")

        residuo = total % 10

        println("Residuo = $residuo")

        if (residuo == 0) {
            resultado = 0
        }
        else {
            resultado = 10 - residuo
        }

        if (resultado == verificador) {
            println("Resultado = $resultado")
            error = ""
            return true
        }

        error = "Los números no cumplen la validación del algoritomo módulo 10"
        return false
    }
}