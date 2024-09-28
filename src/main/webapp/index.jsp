<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="javax.xml.xpath.XPathFactory" %>
<%@ page import="javax.xml.xpath.XPath" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="Elijah Omisore" name="author">
    <meta content="Aerosimo 1.0.0" name="generator">
    <meta content="Aerosimo" name="application-name">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="Aerosimo IT Consultancy" name="description">
    <meta content="Aerosimo" name="apple-mobile-web-app-title">
    <meta content="Oracle, Java, Tomcat, Maven, Jenkins, Bitbucket, Github" name="keywords">
    <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport" />
    <!-- Title -->
    <title>Card Validator | Aerosimo Ltd</title>
    <!-- Favicon-->
    <link href="assets/img/favicon.ico" rel="shortcut icon"/>
    <link href="assets/img/favicon.ico" rel="icon" type="image/x-icon">
    <link href="assets/img/favicon-32x32.png" rel="icon" sizes="32x32" type="image/png">
    <link href="assets/img/favicon-16x16.png" rel="icon" sizes="16x16" type="image/png">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" sizes="180x180">
    <link href="assets/img/android-chrome-192x192.png" rel="android-chrome" sizes="192x192">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #0072c6;
        }

        p {
            font-size: 16px;
            line-height: 1.5;
        }

        a {
            text-decoration: none;
            color: #0072c6;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Ominet Card Validator</h1>
    <p>Credit card validation is the process of validating the genuineness of a credit card.
        That process gains importance as monetary affairs become sensitive. The credit card number is
        generated under specific protocols and rules. It gives a merchant a facility to validate the
        credit card number before accepting a customer's payment.</p>
    <c:set var="baseUrl"
           value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
    <p>
        To access the web services, please click here: <a href="${baseUrl}/ws/cardvalidator">here</a>
    </p>

    <h1>Credit Card Validator</h1>
    <form action="" method="post">
        <label for="CardLongNumber">Enter Card Number:</label>
        <input type="text" id="CardLongNumber" name="CardLongNumber">
        <input type="submit" value="Validate">
    </form>

    <%
        // Check if form is submitted
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String CardLongNumber = request.getParameter("CardLongNumber");

            // Prepare SOAP request
            String soapRequest =
                    "<?xml version='1.0' encoding='UTF-8'?>" +
                            "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:card=\"https://aerosimo.com/api/ws/cardvalidator\">" +
                            "<soap:Header/>" +
                            "<soap:Body>" +
                            "<card:validateCard>" +
                            "<CardLongNumber>" + CardLongNumber + "</CardLongNumber>" +
                            "</card:validateCard>" +
                            "</soap:Body>" +
                            "</soap:Envelope>";

            try {
                // URL of the SOAP endpoint
                URL url = new URL("http://ominet.aerosimo.com:8082/cardvalidator/ws/cardvalidator");

                // Open HTTP connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");

                // Send SOAP request
                OutputStream os = connection.getOutputStream();
                os.write(soapRequest.getBytes());
                os.close();

                // Get response from the web service
                InputStream responseStream = connection.getInputStream();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(responseStream);

                // Extract values using XPath
                XPathFactory xPathFactory = XPathFactory.newInstance();
                XPath xpath = xPathFactory.newXPath();

                String valid = xpath.evaluate("//valid", document);
                String cardType = xpath.evaluate("//cardType", document);
                String message = xpath.evaluate("//message", document);

                // Display the results
                out.println("<h3>Validation Result</h3>");
                out.println("<p>Valid: " + valid + "</p>");
                out.println("<p>Card Type: " + cardType + "</p>");
                out.println("<p>Message: " + message + "</p>");

            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }
    %>

    <p>
        The current timestamp is:
        <%=new java.util.Date()%>
    </p>
</div>

</body>
</html>