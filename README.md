<h1 align="center"> Spring Boot Products - Hexagonal Architecture </h1>

<p align="center">
  <img width="50%" height="50%" src="https://miro.medium.com/v2/resize:fit:761/1*9A0lTCXhJma8-gSISbzKrA.png" />
</p>

<p align="center">
   <img src="https://img.shields.io/badge/Status-En_desarrollo-green"/>
</p>

[Descripción del proyecto](#descripción-del-proyecto)

[Tecnologías utilizadas](#tecnologías-utilizadas)

[Estructura del proyecto](#estructura-del-proyecto)


## Descripción del proyecto
Servicio en SpringBoot que provee una end point rest de consulta.

Acepta como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.

Devuelve como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Utiliza una base de datos en memoria (tipo h2) que se inicializa con los datos:

![img.png](img.png)

## Tecnologías utilizadas
<p align="left">
  <img width="15%" height="15%" src="https://miro.medium.com/v2/resize:fit:1358/1*yIEa02vx20jdlcWWJM-L4Q.jpeg" />
  <img width="15%" height="15%" src="https://miro.medium.com/v2/resize:fit:1400/1*Jt34KK87zw10NOLYqU-CNQ.jpeg" />
  <img width="15%" height="15%" src="https://user-images.githubusercontent.com/33158051/103466459-7524de80-4d13-11eb-96ba-f13e5409a18a.png" />
  <img width="15%" height="15%" src="https://dc722jrlp2zu8.cloudfront.net/media/uploads/2020/09/08/pildora-04-imagen.png" />
  <img width="15%" height="15%" src="https://upload.wikimedia.org/wikipedia/commons/a/a1/H2_logo.png" />
</p>

## Estructura del proyecto

![img_3.png](img_3.png)

Se ha creado una estructura hexagonal, la cual nos ayudará a seguir los principios SOLID, y nos permitirá una buena escalabilidad y mantenibilidad.
La entrada a nuestro servicio está en la capa de infraestructura, la cual se comunica con el modelo a través de la capa de aplicación, y viceversa.

