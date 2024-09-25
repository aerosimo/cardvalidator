/******************************************************************************
 * This piece of work is to enhance cardvalidator project functionality.      *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ValidateCardTest.java                                           *
 * Created:   25/09/2024, 01:05                                               *
 * Modified:  25/09/2024, 01:05                                               *
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateCardTest {

    @Test
    @DisplayName("Validating VISA Card Number")
    void checkVISACardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("4916801905619884"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating VISA Card IIN")
    void checkVISACardType() {
        String actual;
        String expected;
        expected = "Visa";
        actual = ValidateCard.checkCardType("4916801905619884");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating MasterCard Card Number")
    void checkMasterCardCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("5193347091529678"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating MasterCard Card IIN")
    void checkMasterCardCardType() {
        String actual;
        String expected;
        expected = "MasterCard";
        actual = ValidateCard.checkCardType("5193347091529678");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating American Express Card Number")
    void checkAMEXCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("348235854897579"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating American Express Card IIN")
    void checkAMEXCardType() {
        String actual;
        String expected;
        expected = "American Express";
        actual = ValidateCard.checkCardType("348235854897579");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating JCB Card Number")
    void checkJCBCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("3553512923196850"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating JCB Card IIN")
    void checkJCBCardType() {
        String actual;
        String expected;
        expected = "JCB";
        actual = ValidateCard.checkCardType("3553512923196850");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Discover Card Number")
    void checkDiscoverCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("6011643317673615"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Discover Card IIN")
    void checkDiscoverCardType() {
        String actual;
        String expected;
        expected = "Discover";
        actual = ValidateCard.checkCardType("6011643317673615");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Voyager Card Number")
    void checkVoyagerCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("8699005612629079"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Voyager Card IIN")
    void checkVoyagerCardType() {
        String actual;
        String expected;
        expected = "Voyager";
        actual = ValidateCard.checkCardType("8699005612629079");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating China UnionPay Number")
    void checkUnionPayCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("6250941006528599"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating China UnionPay Card IIN")
    void checkUnionPayCardType() {
        String actual;
        String expected;
        expected = "China UnionPay";
        actual = ValidateCard.checkCardType("6221268807629548");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating DinersClub Number")
    void checkDinersClubCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("38999138953244"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating DinersClub Card IIN")
    void checkDinersClubCardType() {
        String actual;
        String expected;
        expected = "DinersClub";
        actual = ValidateCard.checkCardType("38999138953244");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating UATP Number")
    void checkUATPCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("112583326236387"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating UATP Card IIN")
    void checkUATPCardType() {
        String actual;
        String expected;
        expected = "UATP";
        actual = ValidateCard.checkCardType("112583326236387");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Dankort Number")
    void checkDankortCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("5019717010103742"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating Dankort Card IIN")
    void checkDankortCardType() {
        String actual;
        String expected;
        expected = "Dankort";
        actual = ValidateCard.checkCardType("5019368793005259");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating InterPayment Number")
    void checkInterPaymentCardNumber() {
        String actual;
        String expected;
        expected = "true";
        actual = String.valueOf(ValidateCard.checkCardNumber("6366801905619884"));
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }

    @Test
    @DisplayName("Validating InterPayment Card IIN")
    void checkInterPaymentCardType() {
        String actual;
        String expected;
        expected = "InterPayment";
        actual = ValidateCard.checkCardType("6366801905619884");
        Assertions.assertNotNull(actual, "Checking that the card issuing network response is not null");
        Assertions.assertEquals(expected, actual, "This should match a the cardNetwork message from the CardValidator api");
    }
}