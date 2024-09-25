/******************************************************************************
 * This piece of work is to enhance cardvalidator project functionality.      *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ValidateCard.java                                               *
 * Created:   25/09/2024, 00:37                                               *
 * Modified:  25/09/2024, 00:37                                               *
 *                                                                            *
 * Copyright (c)  2024.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ValidateCard class provides functionality to validate
 * credit card numbers using the Luhn algorithm and identify card types.
 */

public class ValidateCard {

    private static final Logger log;

    static {
        log = LogManager.getLogger(ValidateCard.class.getName());
    }

    /**
     * Validates a given credit card number using the Luhn algorithm.
     *
     * @param cardNumber The credit card number as a String.
     * @return true if the card number is valid according to the Luhn algorithm, false otherwise.
     */
    public static boolean checkCardNumber(String cardNumber) {
        // Check if the card number is null or empty
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }

        // Check if the card number contains only digits
        if (!cardNumber.matches("\\d+")) {
            return false;
        }

        // Reverse the card number and convert to character array
        char[] cardDigits = new StringBuilder(cardNumber).reverse().toString().toCharArray();
        int sum = 0;

        for (int i = 0; i < cardDigits.length; i++) {
            int digit = Character.getNumericValue(cardDigits[i]);

            // Double every second digit (i.e., digits at odd indices)
            if (i % 2 == 1) {
                digit *= 2;
                // If the result is greater than 9, subtract 9
                if (digit > 9) {
                    digit -= 9;
                }
            }

            // Sum all the digits
            sum += digit;
        }

        // A valid card number will have a total sum that is a multiple of 10
        return sum % 10 == 0;
    }

    static String response;
    static String digit1;
    static String digit2;
    static String digit3;
    static String digit4;
    static String digit6;

    public static String checkCardType(String cardLongNumber) {
        response = "Unknown";
        digit1 = cardLongNumber.substring(0, 1);
        digit2 = cardLongNumber.substring(0, 2);
        digit3 = cardLongNumber.substring(0, 3);
        digit4 = cardLongNumber.substring(0, 4);
        digit6 = cardLongNumber.substring(0, 6);
        if (cardLongNumber.chars().allMatch(Character::isDigit)) {

            /* ----
             * VISA Electron  IIN range = 4026, 417500, 4405, 4508, 4844, 4913, 4917
             ** ------------  length = 16
             */
            if ((digit4.equals("4026") ||
                    digit4.equals("4175") ||
                    digit4.equals("4405") ||
                    digit4.equals("4508") ||
                    digit4.equals("4844") ||
                    digit4.equals("4913") ||
                    digit4.equals("4917")) && (cardLongNumber.length() == 16))
            {
                response = "Visa Electron";
                log.info("Visa Electron Card validation is successful");
            }

            /* ----
             ** VISA  IIN range = 4
             ** ----  length = 13 to 19
             */
            if (digit1.equals("4") && (cardLongNumber.length() >= 13 && cardLongNumber.length() <= 19)) {
                response = "Visa";
                log.info("VISA Card validation is successful");
            }

            /* ----
             ** AMEX  IIN range = 34 or 37
             ** ----  length = 15
             */
            if ((digit2.equals("34") || digit2.equals("37")) && (cardLongNumber.length() == 15)) {
                response = "American Express";
                log.info("Amex Card validation is successful");
            }

            /* ---------------
             ** China UnionPay  IIN range = 622126 to 622925
             ** --------------  length = 16 to 19
             **
             */
            if (digit6.compareTo("622126") >= 0 && digit6.compareTo("622925") <= 0
                    && (cardLongNumber.length() >= 16 && cardLongNumber.length() <= 19)) {
                response = "China UnionPay";
                log.info("China UnionPay validation is successful");
            }

            /* ----------
             ** MASTERCARD  IIN range = 51 ... 55
             ** ----------  length = 16
             */
            if (digit2.compareTo("51") >= 0 && digit2.compareTo("55") <= 0 && (cardLongNumber.length() == 16)) {
                response = "MasterCard";
                log.info("MasterCard validation is successful");
            }

            /*  -------------------------
             ** Diners Club Carte Blanche  IIN range=300 ... 305 or 36 or 38
             **  300000 through 305999
             **    309500 through 309599
             **    360000 through 369999
             **    380000 through 399999
             ** ----- length=14
             */
            if ((digit4.compareTo("3000") >= 0 && digit4.compareTo("3999") <= 0) && (cardLongNumber.length() == 14)) {
                response = "DinersClub";
                log.info("DinersClub Card validation is successful");
            }

            /* ---------
             ** DISCOVER  IIN range = 6011, 622126‑622925, 644‑649, 65
             ** --------  length = 16
             */
            if ((digit4.equals("6011") || digit2.equals("65") || (digit3.compareTo("644") >= 0 && digit3.compareTo("649") <= 0)
                    || ((digit6.compareTo("622126") < 0 || digit6.compareTo("622925") > 0)
                    && digit2.equals("62")))
                    && cardLongNumber.length() == 16) {
                response = "Discover";
                log.info("Discover Card validation is successful");
            }

            /* -----
             ** JCB IIN range = 3528.....3589
             **     IIN range = 1800.....2131
             ** ----- length = 16
             */
            if ((digit4.compareTo("3528") >= 0 && digit4.compareTo("3589") <= 0) && (cardLongNumber.length() == 16)) {
                response = "JCB";
                log.info("JCB Card validation is successful");
            }

            /* -----
             ** UATP    IIN range = 1
             ** ---     length = 15
             */
            if ((digit1.equals("1")) && (cardLongNumber.length() == 15)) {
                response = "UATP";
                log.info("UATP Card validation is successful");
            }

            /* --------
             ** Dankort IIN range = 5019
             ** -----   length = 16
             */
            if ((digit4.equals("5019")) && (cardLongNumber.length() == 16)) {
                response = "Dankort";
                log.info("Dankort Card validation is successful");
            }

            /* -------------
             ** InterPayment    IIN range= 636
             ** ------------    length= 16 to 19
             */
            if ((digit3.equals("636")) && (cardLongNumber.length() >= 16 && cardLongNumber.length() <= 19)) {
                response = "InterPayment";
                log.info("InterPayment card validation is successful");
            }

            /* ----
             ** VOYAGER card IIN range = 8699
             ** --------      length = 15
             */
            if (digit4.equals("8699") && (cardLongNumber.length() == 15 || cardLongNumber.length() == 16)) {
                response = "Voyager";
                log.info("Voyager Card validation is successful");
            }
        }
        return response;
    }
}