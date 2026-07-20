Llanquihue Tour App - Evaluación Final Transversal

Descripción general del sistema
Este proyecto es un prototipo de software orientado a objetos desarrollado para la agencia de turismo Llanquihue Tour, ubicada en la Región de Los Lagos. El sistema busca solucionar problemas administrativos reales de la empresa, como la información desorganizada, los procesos manuales y la falta de categorización formal de las personas vinculadas a su operación.
Para lograrlo, la aplicación lee los registros desde un archivo de texto externo (datos_agencia.txt), automatiza la conversión de esos datos a objetos Java y los almacena en colecciones dinámicas. El proyecto aplica los pilares de la Programación Orientada a Objetos para asegurar un código escalable, reutilizable y seguro.
Resumen de las clases principales y sus funciones
El código fuente ha sido diseñado bajo una arquitectura modular, separando las responsabilidades en cuatro paquetes principales:

1. Paquete model (Entidades y Contratos):
Registrable: Interfaz que define un contrato de comportamiento común, obligando a las entidades a implementar los métodos registrar() y mostrarDatos().
Persona: Superclase abstracta que centraliza atributos compartidos para evitar duplicación de código y establecer una jerarquía de herencia.
Cliente y GuiaTuristico: Subclases que heredan de Persona. Representan los roles específicos de la agencia y personalizan su comportamiento mediante la sobrescritura de métodos (@Override).
Rut y Direccion: Clases integradas mediante el principio de composición. La clase Rut encapsula la lógica de validación de formato mediante expresiones regulares.
PaqueteTuristico: Representa los itinerarios de la agencia. Contiene métodos mutadores (setters) que resuelven la problemática de trazabilidad, permitiendo modificar horarios y precios de forma dinámica.

2. Paquete data (Gestión Lógica):
GestorEntidades: Funciona como el cerebro del sistema. Utiliza BufferedReader para leer el archivo de texto y separa las columnas usando el comando split(";"). Almacena los objetos en una lista genérica polimórfica (List<Registrable>) y emplea el operador instanceof para validar el tipo de objeto en tiempo de ejecución y aplicar lógica diferenciada. Contiene además los métodos de filtrado y modificación de paquetes.

3. Paquete util (Herramientas y Excepciones):
RutInvalidoException: Excepción personalizada que detiene la creación de un objeto si el formato del RUT no es válido, asegurando la integridad de la base de datos.
Separador: Clase de utilidad que mejora la estética y legibilidad de los reportes impresos por consola.

4. Paquete ui (Interfaz de Usuario):
Main: Clase principal que sirve como punto de entrada de la aplicación, coordinando el flujo de ejecución: carga de datos, ingresos manuales, búsquedas, modificaciones y la visualización final de reportes consolidados.

Instrucciones para clonar y ejecutar el proyecto

Para revisar el correcto funcionamiento del sistema, siga estos pasos:
Clone o descargue este repositorio en su equipo y ábralo utilizando el entorno de desarrollo IntelliJ IDEA.
Verifique que el proyecto esté utilizando el JDK de Java 17, tal como está definido en el archivo de configuración pom.xml.
Asegúrese de que el archivo de datos de prueba llamado datos_agencia.txt se encuentre ubicado directamente en la carpeta raíz del proyecto (al mismo nivel que la carpeta src y el archivo pom.xml).
El archivo de texto debe contar con datos estructurados separados por punto y coma (;), en el siguiente orden para el registro de personas: Tipo; Nombre; RUT; Calle; Ciudad; Categoría o Especialidad.
Diríjase al paquete ui, abra la clase Main.java y ejecute el programa haciendo clic en la opción "Run". El sistema procesará el archivo automáticamente y desplegará la interfaz de operaciones estructurada a través de la consola.
