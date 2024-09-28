![MIT License.!](/img/MIT.png "MIT")

##### MIT License Copyright (c) 2024 Aerosimo

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.

	The characters, names, events, articles, templates, or information provided by 
	Aerosimo Ltd are fictional and for reference only. While we strive to keep the 
	information up to date and correct, we make no representations or warranties of 
	any kind, express or implied, about the completeness, accuracy, reliability, 
	suitability, or availability with respect to the information, articles, templates, 
	or related graphics contained in this document or any part of the project. 
	Any reliance you place on such information is therefore strictly at your own risk.

---

# Card Validator Project

![Project Cover.!](/img/cover.jpg "Card Validator Project")
# Card Validation
> *Validating a credit card refers to the process of running a computer algorithm
> that performs calculations using a credit card's number.
> When the algorithm shows that the card is valid, it means only that the card number
> is among those that could potentially exist with a given credit card company.
> For example, a random series of numbers would likely result in an invalid answer
> from the program, while an actual card number, even from a card that has expired
> or reached its credit limit, would show up as valid, since the number is one that
> the credit card company issued.*

---
This project is a **Credit Card Validator** built using **core Java**. It validates credit card numbers using the **Luhn algorithm** and exposes **SOAP** web services. The project also includes a simple **JSP-based web interface** for user input and validation.

## Project Structure

This `README.md` gives an overview of the project structure, dependencies, and instructions on how to build and deploy the application. It also includes brief explanations of the Luhn algorithm and the web services.

## Features

1. **Luhn Algorithm**: The core logic that validates whether a credit card number is valid.
2. **SOAP Web Service**: Exposes a `validateCard(String CardLongNumber)` method to validate card numbers.
3. **JSP Web Interface**: A user-friendly web interface for inputting and validating card numbers.

## Getting Started

![Project Codes & Tasks.!](/img/code.jpg "Project Codes and Task")

---

### Prerequisites

>- **Apache TomEE 10**: Make sure TomEE is installed and running.
>- **Java 23**: Ensure you have Java 23 installed as TomEE 10 targets Jakarta EE 10.
>- **Maven**: The project uses Maven for dependency management with any IDE of choice.

### Dependencies

The required dependencies are defined in `pom.xml`. Below are the key dependencies:

- **Jakarta EE 10 API**: Provides JAX-WS support.
- **JAX-WS**: For SOAP web service implementation.

### Building and Running the Application

1. **Clone the repository**:

    ```bash
    git clone https://github.com/aerosimo/cardvalidator.git
    cd cardvalidator
    ```

2. **Build the project using Maven**:

    ```bash
    mvn clean install
    ```

3. **Deploy the WAR file**:

   After building the project, deploy the generated `WAR` file from the `target/` directory into the `webapps/` folder of your TomEE installation.

4. **Start TomEE**:

   Start TomEE and access the application:

    - SOAP Service: WSDL at `http://localhost:8080/soap/cardvalidator?wsdl`
    - Web Interface: `http://localhost:8080/cardvalidator/index.jsp`

## Detailed Explanation of Components

### 1. **Luhn Algorithm** (Core Logic)

Located in `com/aerosimo/ominet/core/ValidateCard.java`, this class implements the Luhn algorithm, a simple checksum formula used to validate credit card numbers.

### 2. **SOAP Web Service** (JAX-WS)

The SOAP web service is implemented in `com/aerosimo/ominet/service/CardValidatorSOAPService.java`. It provides a `validateCard(String CardLongNumber)` method to check the validity of card numbers.

Example SOAP Request:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:card="http://service.ominet.aerosimo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <card:validateCard>
         <CardLongNumber>1234567890123456</CardLongNumber>
      </card:validateCard>
   </soapenv:Body>
</soapenv:Envelope>
```

---

![Aerosimo Logo.!](/img/logo.png "Aerosimo")