# Conversor de Moneda

Este es un proyecto de una aplicación de conversión de monedas que consume una API para obtener la tasa de cambio de la moneda seleccionada.

## Descripción

Este challenge de Alura fue resuelto utilizando Java, con la biblioteca **Gson** para convertir los datos en formato JSON a objetos Java. Se utilizó **Maven** para la gestión de dependencias y **Swing** para desarrollar la interfaz gráfica, brindando una experiencia amigable al usuario.

### API utilizada

La aplicación hace uso de la siguiente API para obtener los tipos de cambio:

- [ExchangeRate-API](https://www.exchangerate-api.com/)

## Uso

Una vez ejecutada la aplicación, se presentan dos menús desplegables donde el usuario puede seleccionar la moneda de origen y la moneda a la que desea convertir. Al hacer clic en el botón "Calcular", se muestra la equivalencia entre ambas monedas.

<p align="center">
  <img src="https://github.com/user-attachments/assets/bd370442-a8dc-440c-9e02-20e506d858e8" alt="Interfaz de Conversor de Moneda">
</p>

En caso de que el usuario ingrese letras en lugar de números, se mostrará un mensaje de error sugiriendo que ingrese solo valores numéricos.

<p align="center">
  <img src="https://github.com/user-attachments/assets/446ebdb9-cd6a-4170-b1a5-b82c5ad5294c" alt="Error de conversión">
</p>

## Requisitos

Para ejecutar la aplicación, es necesario tener instalado:

- **Java 21** o superior
- **Maven**

## Instalación

Clona el repositorio y navega al directorio del proyecto:

  ```bash
  mkdir conversor-moneda
  cd conversor-moneda
  git clone https://github.com/CZrich/Conversor-de-Modena---Challenge-ONE--Java-Back-end.git 
   ```
Ubicarse en el directorio donde se encuentre el `pom.xml` y ejecutar el comando que genera el `.jar` de la aplicación.
  ```bash
  mvn package
   ```

## Uso con archivo .jar

Una ves generado  el archivo `.jar`  se encuentrará en el directorio `target` después de compilar el proyecto,también puede descargarlo directamente del repositorio desde `Releases`.

### Ejecutar desde la terminal:
Si  ha clonado el repositorio y  compilado para ejecutar use:
```bash
 java -jar target/ConversorMonedas-1.0-SNAPSHOT-jar-with-dependencies.jar 
```
Pero si lo descargo dese `Releases` el archivo `.jar` debe ubircarse en la carpeta donde descargo y ejecutar el siguiente comando:
```bash
 java -jar ConversorMonedas-1.0-SNAPSHOT-jar-with-dependencies.jar 
```
