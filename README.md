# Escuela Colombiana de Ingenier铆a Julio Garavito

# Aplicaci贸n web segura

#### Autor馃檸
> - Mar铆a Ang茅lica Alfaro Fandi帽o

#### 馃攷 Descripci贸n
Construcci贸n de una aplicaci贸n web distribuida segura con dos servicios **LoginService** y **ImgService** que permite el acceso seguro desde el browser y garantiza la autenticaci贸n, autorizaci贸n e integridad de usuarios.

Cada servicio cuenta con un certificado propio para el acceso seguro a trav茅s de **https**. Adicionalmente el **LoginService** cuenta con archivo de confianza que le permite consumir una imagen de **ImgService** para mostrarla al usuario si este se autentic贸 exitosamente.

## 馃洜锔? Arquitectura y dise帽o detallado de la aplicaci贸n
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/Dise%C3%B1o.PNG" width="600"/>
        </p>
    </body>
</html>

El proyecto est谩 compuesto por:

- El servicio **LoginService**, que permite la autenticaci贸n, autorizaci贸n e integridad de los usuarios a trav茅s del cifrado de la contrase帽a y el acceso al otro servicio a los usuarios autorizados. El servicio corre por el puerto ***4567***.

  - Cuenta con 2 endpoints:
       
     馃搶 ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.
     
     馃搶 ***(POST)*** /login. Recibe las credenciales y las valida con las existentes del usuario autorizado. Si la validaci贸n es exitosa se le aprueba el acceso al otro servicio para consumir el recurso (en este caso, una imagen); de lo contrario se le muestra en pantalla un mensaje de error.

- El servicio **ImgService**, que retorna los recursos solicitados por **LoginService**. El servicio corre por el puerto ***4600***.

  - Cuenta con 2 endpoints:

       馃搶  ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.

       馃搶 ***(GET)*** /img. Retorna recursos de tipo imagen.
       
## 鈿欙笍 Arquitectura de seguridad para incorporar nuevos servicios
Puesto que lo realizado es una aplicaci贸n web distribuida, implementar nuevos servicios es sencillo. 脷nicamente se deben generar los endpoints desde el servicio principal para consumir los nuevos servicios, construir los certificados para dichos servicios garantizando el acceso seguro e importar los certificados anteriormente creados a un myTrustStore, archivo de confianza para autorizar el acceso de otros servicios.

## 馃摑 Evidencia
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

### Usuario con credenciales v谩lidas
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <p align="center">
          <img src="https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/Imgs/UsuarioValido.PNG" width="600"/>
        </p>
    </body>
</html>

### Usuario con credenciales inv谩lidas
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
[Demostraci贸n de lo realizado en AWS](https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/DemoAppSegura.mp4)

## 鉁掞笍 Conceptos utilizados
- ***Autenticaci贸n:*** Es el proceso de identificar a los usuarios y garantizar que los mismos sean quienes dicen ser.
- ***Autorizaci贸n:*** Permite validar si un usuario tiene el permiso para acceder a un recurso o realizar alguna acci贸n.
- ***Integridad:*** Consiste en proteger la informaci贸n de modificaciones por parte de accesos no autorizados.
- ***https:***  Tambien conocido como protocolo seguro de transferencia de hipertexto, es un protocolo de comunicaci贸n de Internet que protege la integridad y la confidencialidad de los datos de los usuarios entre sus ordenadores y el sitio web.
- ***Aplicaci贸n de 12 factores:*** Es una metodolog铆a para construir aplicaciones de software como servicio.
       
## 馃挕 Herramientas utilizadas
- Maven
- Eclipse
- GitHub
- AWS
