# TODO APP 
>Esta aplicación fue desarrollado con spring- boot y vue-js3.
## Configuración 
Clone el proyecto, ir a la carpeta "todo-app_Spring-boot_y_vue-js" dentro abran dos carpetas back y front, abrir la carpeta back con el editor de su preferencia, ya que aquí toca configurar los datos de MySQL.
- Debes crear un base de datos con el siguiente nombre "todo-app”, configurar tus credenciales de permiso a MySQL en el properties de spring.

[![1.png](https://i.postimg.cc/wj5fwPCY/1.png)](https://postimg.cc/G42x2M3X)

## Ejecución
### Ejecutar el Back
Para ejecutarlo desde una terminal de comandos, debemos seguir los siguientes pasos:  
1. Posicionarnos en la carpeta back/todo-app y ejecutar el comando
```
./mvnw compile install
```
2. Se nos creará una carpeta llamada target, nos dirigimos a ella, aquí podemos ver que se nos creó un **.jar** con el nombre de nuestro proyecto, para ejecutar dicho archivo debemos hacer lo siguiente:

```
java -jar {nombreProyecto}.jar
```
- Esto nos creará un servidor...

### Ejecutar el Front
- Abrimos una terminal en la carpata front de nuestro proyecto y ejecutamos 
```
npm install
npm run dev
````
- Si todo lo ha hecho correctamente, debe de ver una pestaña similar a esta en su navegador. 
 [![2.png](https://i.postimg.cc/FK5fHCzz/2.png)](https://postimg.cc/RWdCPRcx)
