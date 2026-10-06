# RideWake AI

**RideWake AI** es una aplicación para **smartwatch con Wear OS** orientada a usuarios de transporte público.

Su propósito es ayudar al usuario durante su recorrido y avisarle antes de llegar a su destino, reduciendo la necesidad de revisar constantemente el reloj.

El proyecto se encuentra actualmente en una etapa parcial de desarrollo enfocada principalmente en la **experiencia de usuario, interfaz, navegación, internacionalización y representación visual del recorrido**.

---

## Estado actual del proyecto

RideWake AI cuenta actualmente con un flujo funcional que permite:

```text
Iniciar la aplicación
        ↓
Seleccionar un destino
        ↓
Confirmar el destino
        ↓
Iniciar el recorrido
        ↓
Visualizar el viaje
        ↓
Finalizar el recorrido
        ↓
Regresar al inicio
```

En esta etapa, algunos datos del viaje como el **tiempo estimado** y la **distancia restante** son simulados.

La integración con ubicación, rutas y datos reales del recorrido corresponde a las siguientes etapas del proyecto.

---

# Funcionalidades implementadas

Las siguientes funcionalidades han sido verificadas y pueden demostrarse actualmente dentro de la aplicación.

### Inicio

- Pantalla principal optimizada para smartwatch.
- Diseño adaptado a pantalla circular.
- Botón para iniciar un viaje.
- Acceso a los ajustes de la aplicación.

### Configuración

- Pantalla de ajustes.
- Cambio entre Español e English.
- Persistencia del idioma seleccionado.
- Actualización de la interfaz según el idioma elegido.

### Inicio del viaje

- Navegación desde Inicio hacia la selección de destino.
- Selección de destinos frecuentes:
  - Casa.
  - Universidad.
- Activación del botón Continuar después de seleccionar un destino.

### Confirmación del destino

- Visualización del destino seleccionado.
- Opción para cambiar el destino.
- Opción para iniciar el recorrido.

### Viaje en curso

- Pantalla de viaje activo.
- Visualización del destino seleccionado.
- Visualización simulada del tiempo estimado.
- Visualización simulada de la distancia restante.
- Indicador visual de monitoreo del recorrido.
- Alerta visual de **Aviso temprano**.
- Simulación visual de retroalimentación háptica.
- Opción para finalizar el viaje.
- Regreso a la pantalla de Inicio después de finalizar el recorrido.

---

# Flujo principal de navegación

El flujo que actualmente puede realizarse dentro de RideWake AI es:

```text
Inicio
  ↓
Iniciar viaje
  ↓
Seleccionar destino
  ↓
Casa / Universidad
  ↓
Continuar
  ↓
Confirmar destino
  ↓
Iniciar recorrido
  ↓
Viaje en curso
  ↓
Finalizar viaje
  ↓
Inicio
```

Existe además un flujo independiente para la configuración del idioma:

```text
Inicio
  ↓
Ajustes
  ↓
Seleccionar idioma
  ↓
Español / English
  ↓
Volver
  ↓
Inicio
```

---

# Pantallas principales

## 1. Inicio

La pantalla de Inicio funciona como punto principal de entrada a RideWake AI.

Presenta:

- identidad visual de RideWake AI;
- mensaje principal;
- descripción breve de la aplicación;
- botón **Iniciar viaje**;
- botón **Ajustes**.

Su diseño está pensado para mantener una buena jerarquía visual dentro del espacio reducido de una pantalla circular.

---

## 2. Ajustes

La pantalla de Ajustes permite seleccionar el idioma utilizado por la aplicación.

Actualmente se encuentran disponibles:

```text
Español
English
```

El idioma seleccionado se conserva localmente.

Esto permite que, después de cerrar y volver a abrir la aplicación, RideWake AI mantenga la última configuración seleccionada por el usuario.

---

## 3. Selección de destino

Después de iniciar un viaje, el usuario accede a la pantalla de selección de destino.

Para la demostración actual se encuentran disponibles como destinos funcionales:

```text
Casa
Universidad
```

Cuando el usuario selecciona un destino, el botón **Continuar** se habilita.

---

## 4. Confirmación del destino

Antes de iniciar el recorrido, RideWake AI presenta una pantalla de confirmación.

Esta pantalla permite:

- visualizar el destino seleccionado;
- regresar para cambiarlo;
- iniciar el recorrido.

Ejemplo:

```text
Destino seleccionado

Casa

[ Cambiar destino ]

[ Iniciar recorrido ]
```

---

## 5. Viaje en curso

La pantalla de viaje presenta la información principal del recorrido.

Actualmente muestra:

```text
Destino

Tiempo estimado

Distancia restante

Estado de monitoreo

Aviso temprano

Finalizar viaje
```

Por ejemplo:

```text
Destino
Casa

12 min
Tiempo estimado

3,2 km
Distancia restante

IA monitoreando tu recorrido

Aviso temprano
```

El tiempo y la distancia mostrados durante esta etapa son valores simulados.

---

# Datos simulados

La interfaz del viaje actualmente utiliza datos simulados para poder validar la experiencia del usuario antes de integrar servicios de ubicación y rutas.

Actualmente:

```text
Tiempo estimado
→ simulado

Distancia restante
→ simulada

Destino seleccionado
→ real dentro del flujo de la aplicación

Aviso temprano
→ representado visualmente
```

Esta estrategia permite desarrollar primero la experiencia de usuario y posteriormente conectar la interfaz con información real del recorrido.

---

# Simulación visual de retroalimentación háptica

RideWake AI está pensado para que las alertas importantes puedan comunicarse mediante vibraciones en un smartwatch físico.

Actualmente el proyecto se encuentra en desarrollo y demostración mediante un emulador Wear OS.

Por esta razón se implementó una **simulación visual de retroalimentación háptica**.

Al ingresar a la pantalla de viaje, la interfaz realiza una pequeña animación lateral durante aproximadamente dos segundos.

```text
Inicio del recorrido
        ↓
Pantalla de viaje
        ↓
Microanimación visual
        ↓
Representación de una alerta háptica
```

Esta animación permite representar visualmente el comportamiento que posteriormente podrá asociarse al motor de vibración de un dispositivo Wear OS físico.

---

# Internacionalización

RideWake AI cuenta actualmente con soporte para:

```text
Español
English
```

Los textos se gestionan mediante el sistema de recursos de Android.

```text
app/src/main/res/values/strings.xml
app/src/main/res/values-en/strings.xml
```

La aplicación también conserva el idioma seleccionado por el usuario.

Se realizaron ajustes visuales para garantizar que los textos mantengan una buena distribución dentro de la pantalla circular tanto en Español como en English.

---

# Design System

RideWake AI utiliza un sistema de diseño centralizado para mantener consistencia visual entre las diferentes pantallas.

Actualmente se encuentran centralizados:

- colores;
- colores semánticos;
- tipografías;
- fondos;
- superficies;
- bordes;
- botones;
- estados visuales.

---

## Color principal

El color primario de RideWake AI es:

```text
#59D9FF
```

Este tono cyan forma parte de la identidad visual de la aplicación.

---

## Sistema de colores

La configuración de colores se encuentra centralizada en:

```text
app/src/main/java/com/ridewake/app/presentation/theme/Color.kt
```

Esto permite reutilizar los mismos valores visuales en toda la aplicación y evitar definir colores directamente dentro de cada pantalla.

---

## Sistema tipográfico

La configuración tipográfica se encuentra centralizada en:

```text
app/src/main/java/com/ridewake/app/presentation/theme/Type.kt
```

Esto permite mantener una jerarquía visual consistente entre:

- títulos;
- subtítulos;
- textos informativos;
- etiquetas;
- botones.

---

## Tema de la aplicación

La integración del sistema visual con Material 3 se encuentra configurada en:

```text
app/src/main/java/com/ridewake/app/presentation/theme/Theme.kt
```

---

# Arquitectura de información

RideWake AI utiliza principalmente una navegación secuencial.

```text
Inicio
↓
Destino
↓
Confirmación
↓
Viaje
```

Esta estructura busca reducir la cantidad de decisiones necesarias durante el uso del smartwatch.

---

## Organización

Cada pantalla tiene una función específica dentro del recorrido.

```text
Inicio
→ comenzar la experiencia

Destino
→ seleccionar dónde se dirige el usuario

Confirmación
→ comprobar la selección

Viaje
→ visualizar el recorrido
```

---

## Etiquetado

Los textos utilizados dentro de la aplicación buscan ser breves y fáciles de comprender.

Ejemplos:

```text
Iniciar viaje

Casa

Universidad

Continuar

Cambiar destino

Iniciar recorrido

Finalizar viaje
```

Esto es especialmente importante debido al espacio reducido disponible en una pantalla de smartwatch.

---

# Arquitectura general del proyecto

El proyecto mantiene separadas diferentes responsabilidades relacionadas con presentación, navegación, configuración y diseño.

Una estructura simplificada es:

```text
com.ridewake.app
│
├── core
│   └── localization
│       └── LanguageManager.kt
│
└── presentation
    │
    ├── components
    │   └── PredictiveAlertCard.kt
    │
    ├── navigation
    │   └── RideWakeApp.kt
    │
    ├── screens
    │   ├── home
    │   ├── destination
    │   ├── confirmation
    │   ├── trip
    │   └── settings
    │
    └── theme
        ├── Color.kt
        ├── Type.kt
        └── Theme.kt
```

---

# Stack tecnológico implementado

El stack tecnológico utilizado actualmente por RideWake AI está compuesto por:

| Tecnología | Uso dentro del proyecto |
|---|---|
| **Kotlin** | Lenguaje principal de desarrollo |
| **Jetpack Compose** | Construcción declarativa de interfaces |
| **Compose for Wear OS** | Desarrollo de interfaces específicas para smartwatch |
| **Material 3 for Wear OS** | Componentes y estructura visual |
| **Wear OS** | Plataforma objetivo de la aplicación |
| **Android SDK** | APIs y recursos fundamentales de Android |
| **Android Resources** | Gestión de textos e internacionalización |
| **SharedPreferences** | Persistencia local de la configuración de idioma |
| **Gradle** | Compilación y gestión de dependencias |
| **Android Studio** | Entorno principal de desarrollo |
| **Git** | Control de versiones |
| **GitHub** | Repositorio remoto y seguimiento del desarrollo |

---

# Stack tecnológico por implementar

Las siguientes etapas requerirán ampliar el stack tecnológico para trabajar con datos reales del recorrido.

Las tecnologías concretas de algunos servicios todavía se encuentran por definir.

| Tecnología o servicio | Uso proyectado |
|---|---|
| **APIs de ubicación de Android** | Obtener la ubicación real del usuario |
| **Servicio de rutas** | Obtener recorridos entre la ubicación actual y el destino |
| **Servicio de cálculo de ETA** | Obtener tiempos estimados reales |
| **Servicio de cálculo de distancia** | Obtener la distancia restante real |
| **API o servicio de mapas/rutas** | Consultar información del recorrido |
| **Motor predictivo** | Interpretar los datos del viaje y determinar el nivel de alerta |
| **Inteligencia artificial** | Analizar el contexto del recorrido en etapas posteriores |
| **APIs hápticas de Wear OS** | Activar vibraciones reales en un smartwatch físico |
| **Comunicación con servicios externos** | Consultar información necesaria para el recorrido |

La selección exacta de proveedores y servicios externos se realizará durante las siguientes etapas del proyecto.

---

# Funcionamiento proyectado

La evolución esperada de RideWake AI consiste en reemplazar progresivamente los valores simulados por datos reales.

El flujo proyectado es:

```text
Ubicación actual
        +
Destino seleccionado
        ↓
Servicio de ubicación y rutas
        ↓
Distancia restante
        +
Tiempo estimado
        +
Velocidad reciente
        +
Información del recorrido
        ↓
Motor predictivo
        ↓
Nivel de alerta
        ↓
Interfaz del smartwatch
        +
Retroalimentación háptica
```

---

# Inteligencia artificial

En el estado actual del proyecto todavía no existe un modelo de inteligencia artificial conectado a datos reales del recorrido.

La interfaz está preparada conceptualmente para que, en etapas posteriores, un motor predictivo pueda interpretar información como:

```text
Distancia restante

Tiempo estimado

Velocidad reciente

Evolución del recorrido

Información de paradas
```

Con esta información se podrán determinar diferentes niveles de aviso según la proximidad al destino.

La lógica predictiva real forma parte de las siguientes etapas del proyecto.

---

# Alcance actual

La etapa actual de RideWake AI está enfocada principalmente en:

```text
Experiencia de usuario
        +
Interfaz de usuario
        +
Navegación
        +
Internacionalización
        +
Design System
        +
Flujo principal del viaje
        +
Simulación de datos
```

Esto permite validar primero cómo interactúa el usuario con el smartwatch antes de integrar componentes externos más complejos.

---

# Próximas etapas

Para continuar el desarrollo se plantea implementar:

- ubicación GPS en tiempo real;
- integración con un servicio de rutas;
- cálculo real de distancia restante;
- cálculo real del tiempo estimado;
- análisis de velocidad del recorrido;
- actualización dinámica de los datos del viaje;
- lógica predictiva de proximidad al destino;
- diferentes niveles automáticos de alerta;
- retroalimentación háptica real;
- pruebas en un smartwatch físico;
- destinos personalizados;
- mejora de la entrada de destinos;
- integración con los servicios externos necesarios;
- pruebas de usabilidad;
- mejoras de accesibilidad.

---

# Demostración actual

El flujo recomendado para demostrar el estado actual de RideWake AI es:

```text
Inicio
  ↓
Iniciar viaje
  ↓
Casa
  ↓
Continuar
  ↓
Confirmar destino
  ↓
Iniciar recorrido
  ↓
Viaje en curso
  ↓
Finalizar viaje
  ↓
Inicio
```

Durante el viaje se pueden visualizar:

```text
Destino seleccionado

Tiempo estimado simulado

Distancia restante simulada

Indicador de monitoreo

Aviso temprano

Simulación visual de alerta háptica
```

---

## Demostración del cambio de idioma

También puede realizarse el siguiente flujo:

```text
Inicio
  ↓
Ajustes
  ↓
English
  ↓
Back
  ↓
Home
  ↓
Start trip
```

Después de cerrar y volver a abrir la aplicación, el idioma seleccionado se conserva.

Esto permite demostrar la persistencia de la configuración.

---

# Control de versiones

El desarrollo de RideWake AI utiliza **Git** como sistema de control de versiones y **GitHub** como repositorio remoto.

El proyecto mantiene commits separados para las principales funcionalidades y mejoras implementadas durante el desarrollo.

Esto permite conservar un historial claro de la evolución de la aplicación.

---

# Autor

**Luis Sebastian Diaz**

Proyecto académico desarrollado para **Wear OS**.

**RideWake AI — Alerta predictiva de llegada para transporte público.**
