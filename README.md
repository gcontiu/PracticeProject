
Creat dupa: http://spring.io/guides/gs/producing-web-service/

    Proiect Maven
    Creare Web Service cu Spring-WS ca si standalone application
    foleseste JAXB maven plugin pt generare clase java din xsd (vezi countries.xsd)

Apelare din linia de comanda: curl --header "content-type: text/xml" -d @client-request.xml http://localhost:8080/ws

WSDL disponibil la: http://localhost:8080/ws/countries.wsdl
