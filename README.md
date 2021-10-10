# Escuela Colombiana de Ingeniería Julio Garavito

# Aplicación web segura

#### Autor🙎
> - María Angélica Alfaro Fandiño

#### 🔎 Descripción
Construcción de una aplicación web distribuida segura con dos servicios **LoginService** y **ImgService** que permite el acceso seguro desde el browser y garantiza la autenticación, autorización e integridad de usuarios.

Cada servicio cuenta con un certificado propio para el acceso seguro a través de **https**. Adicionalmente el **LoginService** cuenta con archivo de confianza que le permite consumir una imagen de **ImgService** para mostrarla al usuario si este se autenticó exitosamente.

## 🛠️ Arquitectura y diseño detallado de la aplicación
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/Dise%C3%B1o.PNG" width="600"/>
        </p>
    </body>
</html>

El proyecto está compuesto por:

- El servicio **LoginService**, que permite la autenticación, autorización e integridad de los usuarios a través del cifrado de la contraseña y el acceso al otro servicio a los usuarios autorizados. El servicio corre por el puerto ***4567***.

  - Cuenta con 2 endpoints:
       
     📌 ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.
     
     📌 ***(POST)*** /login. Recibe las credenciales y las valida con las existentes del usuario autorizado. Si la validación es exitosa se le aprueba el acceso al otro servicio para consumir el recurso (en este caso, una imagen); de lo contrario se le muestra en pantalla un mensaje de error.

- El servicio **ImgService**, que retorna los recursos solicitados por **LoginService**. El servicio corre por el puerto ***4600***.

  - Cuenta con 2 endpoints:

       📌  ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.

       📌 ***(GET)*** /img. Retorna recursos de tipo imagen.
       
## ⚙️ Arquitectura de seguridad para incorporar nuevos servicios
Puesto que lo realizado es una aplicación web distribuida, implementar nuevos servicios es sencillo. Únicamente se deben generar los endpoints desde el servicio principal para consumir los nuevos servicios, construir los certificados para dichos servicios garantizando el acceso seguro e importar los certificados anteriormente creados a un myTrustStore, archivo de confianza para autorizar el acceso de otros servicios.

## 📝 Evidencia
### Cliente web
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/Frontend.PNG"/>
        </p>
    </body>
</html>

### Usuario con credenciales válidas
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/UsuarioValido.PNG" width="600"/>
        </p>
    </body>
</html>

### Usuario con credenciales inválidas
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/UsuarioInvalido.PNG"/>
        </p>
    </body>
</html>

### Video expermiental
[Demostración de lo realizado en AWS](https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/DemoAppSegura.mp4)

## ✒️ Conceptos utilizados
- ***Autenticación:*** Es el proceso de identificar a los usuarios y garantizar que los mismos sean quienes dicen ser.
- ***Autorización:*** Permite validar si un usuario tiene el permiso para acceder a un recurso o realizar alguna acción.
- ***Integridad:*** Consiste en proteger la información de modificaciones por parte de accesos no autorizados.
- ***https:***  Tambien conocido como protocolo seguro de transferencia de hipertexto, es un protocolo de comunicación de Internet que protege la integridad y la confidencialidad de los datos de los usuarios entre sus ordenadores y el sitio web.
- ***Aplicación de 12 factores:*** Es una metodología para construir aplicaciones de software como servicio.
       
## 💡 Herramientas utilizadas
- Maven
- Eclipse
- GitHub
- AWS
