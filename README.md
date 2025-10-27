#  App Nano-Pulse

Este proyecto es una aplicación Android que permite **conectarse a un dispositivo Bluetooth** emparejado, **enviar comandos personalizados** y **controlar dispositivos externos** (por ejemplo, un **ESP32**) utilizando la librería `BluetoothJhr`.



Principalmente para el control de un electroporador de pulsos voltaje de 700V a ns, sin carga de celda (img de probe prototipo v0.0)

![image](app\Img01.jpg)
![image](app\Img00.jpg)

##  Características principales

* Escanea y lista los dispositivos Bluetooth emparejados.
* Permite seleccionar un dispositivo y establecer una conexión.
* Envío de datos o comandos a través de Bluetooth.
* Interfaz sencilla para enviar parámetros (`Ton`, `Toff`, `Cantidad`) al dispositivo conectado.
* Botón adicional para detener o cancelar la operación.
* Conexión directa con el **ESP32** para controlar un **electroporador de nanoPulsos**.

---

##  Dependencias

El proyecto utiliza la librería **BluetoothJhr**, que simplifica la conexión y comunicación con módulos Bluetooth clásicos como **HC-05** o **HC-06**.

**Gradle:**

```gradle
dependencies {
    implementation 'com.github.juanjhr:BluetoothJhr:1.1.0'
}
```

>  Si usas la librería localmente, incluye el archivo `.aar` o `.jar` dentro de la carpeta `libs/` y añádelo manualmente al `build.gradle`.

---

##  Funcionamiento

### Pantalla principal (`Inicio.java`)

* Activa el Bluetooth automáticamente con:

  ```java
  bluetoothJhr.EncenderBluetooth();
  ```
* Muestra una lista con los dispositivos emparejados mediante:

  ```java
  bluetoothJhr.Listadis();
  ```
* Al seleccionar un dispositivo, inicia la segunda actividad (`conexion.java`):

  ```java
  bluetoothJhr.Disp_Seleccionado(view, position, conexion.class);
  ```

---

### Pantalla de conexión (`conexion.java`)

Permite enviar datos personalizados al dispositivo conectado por Bluetooth.

####  Envío de parámetros

Se envía una cadena con el siguiente formato:

```
C<Ton>s<Toff>s<Cantidad>s
```

**Ejemplo:**

```
C100s200s5s
```

**Código Java:**

```java
bluetoothJhr2.Tx("C" + tonn + "s" + tofff + "s" + cantidad + "s");
```

Para detener el proceso:

```java
bluetoothJhr2.Tx("P");
```

---

##  Uso

1. Instala la aplicación en tu dispositivo Android.
2. Activa el Bluetooth y empareja tu módulo **HC-05 / HC-06 / esp32**.
3. Abre la app:

   * Se listarán los dispositivos disponibles.
4. Selecciona el dispositivo a conectar.
5. Ingresa los valores de `Ton`, `Toff` y `Cantidad`, luego presiona **Enviar**.
6. Para detener el proceso, presiona **Stop**.

---

## Permisos requeridos (`AndroidManifest.xml`)

Asegúrate de incluir los siguientes permisos para permitir la conexión Bluetooth:

```xml
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

---






















