# 🐉 Hunter

Aplicación de escritorio desarrollada en **JavaFX** que funciona como un **bestiario interactivo de Monster Hunter**, permitiendo consultar monstruos, juegos, tipos y otra información de forma visual, organizada y moderna.

---

## 📌 Descripción

**Hunter** es una aplicación creada como proyecto de aprendizaje y práctica de desarrollo multiplataforma.

La aplicación permite explorar información sobre monstruos de la saga *Monster Hunter* mediante una interfaz gráfica desarrollada con **JavaFX**, utilizando una base de datos integrada y una arquitectura organizada siguiendo principios de programación orientada a objetos.

Actualmente el proyecto cuenta con funcionalidades reales de búsqueda, visualización y persistencia de datos.

---

## ✨ Características actuales

- ✅ Interfaz gráfica moderna con JavaFX
- ✅ Sistema de búsqueda de monstruos
- ✅ Base de datos integrada con SQLite
- ✅ Listado dinámico de monstruos
- ✅ Sistema de imágenes
- ✅ Arquitectura organizada por controladores y modelos
- ✅ Compatibilidad con Java 17
- ✅ Empaquetado portable mediante AppImage
- ✅ Uso de Maven para gestión del proyecto

---

## 🧩 Tecnologías utilizadas

- ☕ Java 17
- 🎨 JavaFX
- 🗄️ SQLite
- 📦 Maven
- 🖼️ Scene Builder
- 🐧 Linux / AppImage
- 🔀 Git y GitHub

---

## 🏗️ Arquitectura del proyecto

El proyecto sigue una estructura modular basada en:

- **Controllers** → lógica de interfaz
- **Models** → representación de datos
- **Database** → acceso y gestión SQLite
- **Resources** → imágenes, CSS y FXML
- **Utils** → utilidades auxiliares

---

## 🚀 Funcionalidades

| Funcionalidad | Estado |
|---|---|
| Listado de monstruos | ✅ |
| Búsqueda por nombre | ✅ |
| Interfaz gráfica | ✅ |
| Base de datos funcional | ✅ |
| Sistema de imágenes | ✅ |
| Relación monstruos ↔ juegos | 🚧 |
| Filtros avanzados | 🚧 |
| Estadísticas | ❌ |
| Sistema de favoritos | ❌ |
| Exportación de datos | ❌ |

---

## 📷 Capturas

*(Próximamente)*

---

## ⚙️ Instalación

### Requisitos

- Java 17 o superior
- Maven

### Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd Hunter
```

### Ejecutar el proyecto

```bash
mvn clean javafx:run
```

---

## 📦 Generar versión portable

```bash
mvn clean package
```

Posteriormente se puede empaquetar como AppImage.

---

## 🎯 Objetivos del proyecto

- Mejorar habilidades en Java y JavaFX
- Aplicar arquitectura MVC
- Practicar acceso a bases de datos
- Crear una aplicación visual completa
- Aprender empaquetado y distribución de aplicaciones Linux

---

## 🛠️ Estado del proyecto

🚧 En desarrollo activo

El proyecto continúa evolucionando con nuevas funcionalidades, mejoras visuales y optimización de arquitectura.

---

## 👤 Autor

**Nauzet Torres Tejera (Twirkand)**  
CFGS Desarrollo de Aplicaciones Multiplataforma

---

## 📜 Licencia

Proyecto desarrollado con fines educativos y personales.
