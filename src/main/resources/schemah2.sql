-- Eliminar tablas si existen en cascada
DROP TABLE IF EXISTS historial_estados CASCADE;

DROP TABLE IF EXISTS aplicaciones CASCADE;

DROP TABLE IF EXISTS medicamentos CASCADE;

DROP TABLE IF EXISTS empleados CASCADE;

DROP TABLE IF EXISTS mascotas CASCADE;

DROP TABLE IF EXISTS clientes CASCADE;

DROP TABLE IF EXISTS estados CASCADE;

-- Crear tablas
CREATE TABLE clientes (
  cliente_id bigint PRIMARY KEY AUTO_INCREMENT,
  nombre text,
  telefono text,
  email text,
  direccion text
);

CREATE TABLE mascotas (
  mascota_id bigint PRIMARY KEY AUTO_INCREMENT,
  nombre text,
  especie text,
  fecha_nacimiento date,
  historial_medico text,
  cliente_id bigint REFERENCES clientes(cliente_id)
);

CREATE TABLE empleados (
   empleado_id bigint PRIMARY KEY AUTO_INCREMENT,
   nombre text,
   rol text,
   horario text
);

CREATE TABLE medicamentos (
  medicamento_id bigint PRIMARY KEY AUTO_INCREMENT,
  nombre text,
  cantidad_stock integer,
  precio numeric,
  fecha_vencimiento date
);

CREATE TABLE aplicaciones (
  aplicacion_id BIGSERIAL PRIMARY KEY,
  mascota_id BIGINT REFERENCES mascotas(mascota_id),
  medicamento_id BIGINT REFERENCES medicamentos(medicamento_id),
  empleado_id BIGINT REFERENCES empleados(empleado_id),
  fecha_aplicacion TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
  comentario TEXT
);

CREATE TABLE estados (
 estado_id bigint PRIMARY KEY AUTO_INCREMENT,
 nombre text
);

CREATE TABLE historial_estados (
   historial_estado_id bigint PRIMARY KEY AUTO_INCREMENT,
   mascota_id bigint REFERENCES mascotas(mascota_id),
   estado_id bigint REFERENCES estados(estado_id),
   fecha_cambio timestamp with time zone,
   comentario text,
   empleado_id bigint REFERENCES empleados(empleado_id)
);

-- 🔄 Eliminar tablas si existen (orden correcto por claves foráneas)
DROP TABLE IF EXISTS evaluaciones;
DROP TABLE IF EXISTS inscripciones;
DROP TABLE IF EXISTS clases;
DROP TABLE IF EXISTS salas;
DROP TABLE IF EXISTS instrumentos;
DROP TABLE IF EXISTS profesores;
DROP TABLE IF EXISTS alumnos;

-- 👤 Tabla Alumnos
CREATE TABLE alumnos (
                         alumno_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         correo VARCHAR(100),
                         edad INT,
                         nivel VARCHAR(50)
);

-- 👨‍🏫 Tabla Profesores
CREATE TABLE profesores (
                            profesor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nombre VARCHAR(100) NOT NULL,
                            especialidad VARCHAR(100),
                            disponibilidad VARCHAR(100)
);

-- 🏢 Tabla Salas
CREATE TABLE salas (
                       sala_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       capacidad INT NOT NULL
);

-- 🥁 Tabla Instrumentos
CREATE TABLE instrumentos (
                              instrumento_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL,
                              tipo VARCHAR(50),
                              estado VARCHAR(50)
);

-- 🧑‍🏫 Tabla Clases
CREATE TABLE clases (
                        clase_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        horario TIMESTAMP NOT NULL,
                        sala_id BIGINT NOT NULL,
                        instrumento_id BIGINT NOT NULL,
                        profesor_id BIGINT NOT NULL,
                        FOREIGN KEY (sala_id) REFERENCES salas(sala_id),
                        FOREIGN KEY (instrumento_id) REFERENCES instrumentos(instrumento_id),
                        FOREIGN KEY (profesor_id) REFERENCES profesores(profesor_id)
);

-- 📝 Tabla Evaluaciones
CREATE TABLE evaluaciones (
                              evaluacion_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              fecha DATE NOT NULL,
                              calificacion DECIMAL(5,2),
                              observaciones VARCHAR(255),
                              alumno_id BIGINT NOT NULL,
                              profesor_id BIGINT NOT NULL,
                              FOREIGN KEY (alumno_id) REFERENCES alumnos(alumno_id),
                              FOREIGN KEY (profesor_id) REFERENCES profesores(profesor_id)
);

-- ✅ Tabla Inscripciones (relación N:N entre alumnos y clases)
CREATE TABLE inscripciones (
                               inscripcion_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               alumno_id BIGINT NOT NULL,
                               clase_id BIGINT NOT NULL,
                               FOREIGN KEY (alumno_id) REFERENCES alumnos(alumno_id),
                               FOREIGN KEY (clase_id) REFERENCES clases(clase_id)
);
