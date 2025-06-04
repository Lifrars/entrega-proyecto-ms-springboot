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
  cliente_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre text,
  telefono text,
  email text,
  direccion text
);

CREATE TABLE mascotas (
  mascota_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre text,
  especie text,
  fecha_nacimiento date,
  historial_medico text,
  cliente_id bigint REFERENCES clientes(cliente_id)
);

CREATE TABLE empleados (
    empleado_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre text,
    rol text,
    horario text
);

CREATE TABLE medicamentos (
  medicamento_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
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
 estado_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
 nombre text
);

CREATE TABLE historial_estados (
    historial_estado_id bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    mascota_id bigint REFERENCES mascotas(mascota_id),
    estado_id bigint REFERENCES estados(estado_id),
    fecha_cambio timestamp with time zone,
    comentario text,
    empleado_id bigint REFERENCES empleados(empleado_id)
);