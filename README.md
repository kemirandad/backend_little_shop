# LittleShop

_Proyecto inicial sobre el manejo de compras en una base de datos ficticia para un almacen_

## Comenzando 🚀

_Proyecto realizado siguiendo paradigma SOA, utilizando el lenguaje JAVA en su version 8 LTS, y 
el framework de SpringBook para el uso de librerias en su version 2.4.4. y manejando las 
dependencias con Maven._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Get Started_

```
Generar un proyecto con Spring Iniatialzr
Manejo de dependencias con Maven
* JDBC
* JPA
* SpringBoot DevTools
* MySQL connector
* Postman
```

### Instalación 🔧

_Primeros pasos_

```
git clone https://github.com/kemirandad/backend_little_shop.git
```

_Luego_

```
Generar peticiones a tráves de PostMan

+ Clients
|-GET ---> /clients
|-GET ---> /clients/{id}
|-POST --> /clients
|-DELETE --> /clients/{id}

+ Products
|-GET ---> /products
|-GET ---> /products/{id}
|-POST --> /products
|-DELETE --> /products/{id}

+ Orders
|-GET ---> /orders
|-GET ---> /orders/{id}
|-POST --> /orders
|-POST --> /clients/{idClient}/orders/{idOrder}/addProduct/{idProduct}
|-PUT --> /clients/{idClient}/orders/{idOrder}
|-DELETE --> /clients/{idClient}/orders/{idOrder}

+ Invoices
|-GET --> /invoices/{idInvoices}
|-GET --> /invoices
```

_Bodies para generar peticiones en el directions /assets de este repositorio_
```
Create one product
    {
        "idProduct": 1,
        "name": "Chair",
        "price": 80000.0
    }
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

## Ejecutando las pruebas ⚙️

_Pruebas unitarias con JUnit 3_
```
Run as project: JUnit Test from SpringBoot
```
_Se crearon pruebas unitarias para todos los **métodos** dentro de el paquete_ [Repository]
 _para comprobar las validaciones necesarias/incluidas en las historias de usuario_

## Despliegue 📦

_Próximamente_

## Construido con 🛠️

_Herramientas para crear tu proyecto_

* [SpringInitializer](https://start.spring.io/) - El generador del proyecto
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [JAVA](https://docs.oracle.com/en/java/) - Lenguaje usado para implementar el proyecto

## Wiki 📖

Puedes encontrar mucho más de cómo utilizar este proyecto en la [Wiki](https://github.com/kemirandad/backend_little_shop/blob/master/README.md)

## Autores ✒️

* **Kenny Miranda** - *Trabajo Inicial* - [kemirandad](https://github.com/kemirandad)

## Licencia 📄

Este proyecto está bajo la Licencia (GNU) - mira el archivo [LICENSE.md](LICENSE.md) para detalles


---
⌨️por [kemirandad](https://github.com/kemirandad) 😊