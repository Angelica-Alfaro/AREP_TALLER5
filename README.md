# Escuela Colombiana de Ingeniería Julio Garavito

# Aplicación web segura

#### Autor🙎
> - María Angélica Alfaro Fandiño

#### 🔎 Descripción
Construcción de una aplicación web distribuida segura con dos servicios **LoginService** y **ImgService** que permite el acceso seguro desde el browser y garantiza la autenticación, autorización e integridad de usuarios.

Cada servicio cuenta con un certificado propio para el acceso seguro a través de **https**. Adicionalmente el **LoginService** cuenta con archivo de confianza que le permite consumir una imagen de **ImgService** para mostrarla al usuario si este se autenticó exitosamente.

## 🛠️ Arquitectura y diseño detallado de la aplicación

El proyecto está compuesto por:

- El servicio **LoginService**, que permite la autenticación, autorización e integridad de los usuarios a través del cifrado de la contraseña y el acceso al otro servicio a los usuarios autorizados. El servicio corre por el puerto ***4567***.

  - Cuenta con 2 endpoints:
       
     📌 ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.
     
     📌 ***(POST)*** /login. Recibe las credenciales y las valida con las existentes del usuario autorizado. Si la validación fue exitosa se le aprueba el acceso al otro servicio para consumir el recurso (en este caso, una imagen); de lo contrario se le muestra en pantalla un mensaje de error.

- El servicio **ImgService**, que retorna los recursos solicitados por **LoginService**. El servicio corre por el puerto ***4600***.

  - Cuenta con 2 endpoints:

       📌  ***(GET)*** /hello. Permite verificar que el servicio corre satisfactoriamente.

       📌 ***(GET)*** /img. Retorna recursos de tipo imagen.
       
## ⚙️ Arquitectura de seguridad para incorporar nuevos servicios
Puesto que lo realizado es una aplicación web distribuida, implementar nuevos servicios es sencillo. Únicamente se deben generar los endpoints desde el servicio principal para consumir los nuevos servicios, construir los certificados para dichos servicios garantizando el acceso seguro e importar los certificados anteriormente creados a un myTrustStore, archivo de confianza para autorizar el acceso de otros servicios.

## 📝 Evidencia
### Cliente web
- Usuario con credenciales correctas
- Usuario con credenciales incorrectas
### Video expermiental
[Demostración de lo realizado en AWS](https://github.com/Angelica-Alfaro/AREP_TALLER5/blob/main/DemoAppSegura.mp4)
       
## 💡 Herramientas utilizadas
- Maven
- Eclipse
- GitHub
- AWS
