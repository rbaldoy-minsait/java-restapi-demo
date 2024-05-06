Proyecto realizado en Java 17, Maven 3.9.6 y Springboot 3.2.5
IDE: IntelliJ
Base de datos en memoria en h2, se inicializa con datos automáticamente 
Ejecutar proyecto: ejecutar la clase PruebaJavaRestApi
Endpints:
    - get all prices: curl --location 'http://localhost:8080/price/prices'
    - get tariff: curl --location 'http://localhost:8080/price/discount' \
                        --header 'Content-Type: application/json' \
                        --data '{
                        "APPLICATION_DATE": "2020-06-14T16:00:00.000+00:00",
                        "PRODUCT_ID": 35455,
                        "BRAND_ID": 1
                        }'

Batería de tests en src/test/java