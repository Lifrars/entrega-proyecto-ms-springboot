-- Poblar tabla clientes
INSERT INTO clientes (nombre, telefono, email, direccion)
VALUES ('Ash Ketchum',
        '123456789',
        'ash.ketchum@pokemon.com',
        'Pueblo Paleta'),
       ('Misty Waterflower',
        '987654321',
        'misty.waterflower@pokemon.com',
        'Ciudad Celeste'),
       ('Brock Harrison',
        '456789123',
        'brock.harrison@pokemon.com',
        'Ciudad Pewter'),
       ('Gary Oak',
        '321654987',
        'gary.oak@pokemon.com',
        'Pueblo Paleta'),
       ('Tracey Sketchit',
        '654321789',
        'tracey.sketchit@pokemon.com',
        'Isla Orange');

-- Poblar tabla mascotas
INSERT INTO mascotas (nombre,
                      especie,
                      fecha_nacimiento,
                      historial_medico,
                      cliente_id)
VALUES ('Pikachu',
        'Eléctrico',
        '2018-10-01',
        'Última visita: 2023-10-01, Medicamentos: Poción',
        1),
       ('Bulbasaur',
        'Planta',
        '2019-09-15',
        'Última visita: 2023-09-15, Medicamentos: Antídoto',
        1),
       ('Charmander',
        'Fuego',
        '2020-10-03',
        'Última visita: 2023-10-03, Medicamentos: Revitalizador',
        1),
       ('Psyduck',
        'Agua',
        '2019-09-20',
        'Última visita: 2023-09-20, Medicamentos: Poción',
        2),
       ('Onix',
        'Roca/Tierra',
        '2017-08-30',
        'Última visita: 2023-08-30, Medicamentos: Antídoto',
        3),
       ('Squirtle',
        'Agua',
        '2018-10-01',
        'Última visita: 2023-10-05, Medicamentos: Revitalizador',
        2),
       ('Jigglypuff',
        'Normal',
        '2019-09-25',
        'Última visita: 2023-09-25, Medicamentos: Poción',
        4),
       ('Meowth',
        'Normal',
        '2019-10-02',
        'Última visita: 2023-10-02, Medicamentos: Antídoto',
        4),
       ('Eevee',
        'Normal',
        '2018-10-01',
        'Última visita: 2023-10-04, Medicamentos: Revitalizador',
        5),
       ('Gengar',
        'Fantasma/Veneno',
        '2017-08-30',
        'Última visita: 2023-09-28, Medicamentos: Poción',
        5);

-- Poblar tabla empleados
INSERT INTO empleados (nombre, rol, horario)
VALUES ('Professor Oak',
        'Investigador',
        '9:00 AM - 5:00 PM'),
       ('Nurse Joy', 'Enfermera', '8:00 AM - 4:00 PM'),
       ('Officer Jenny', 'Policía', '10:00 AM - 6:00 PM'),
       ('Dr. Fuji', 'Veterinario', '9:00 AM - 5:00 PM'),
       ('Cynthia', 'Veterinario', '10:00 AM - 6:00 PM');

-- Poblar tabla medicamentos
INSERT INTO medicamentos (nombre,
                          cantidad_stock,
                          precio,
                          fecha_vencimiento)
VALUES ('Poción', 20, 300.00, '2024-12-31'),
       ('Antídoto', 15, 150.00, '2024-11-30'),
       ('Revitalizador', 10, 500.00, '2025-01-15'),
       ('Super Poción', 8, 600.00, '2024-10-20'),
       ('Hiper Poción', 5, 800.00, '2025-02-28');

-- Poblar tabla estados
INSERT INTO estados (nombre)
VALUES ('Consulta'),
       ('En Observación'),
       ('Estable'),
       ('Crítico'),
       ('Recuperándose'),
       ('Dado de Alta');

-- Poblar tabla aplicaciones
INSERT INTO aplicaciones (mascota_id,
                          medicamento_id,
                          empleado_id,
                          fecha_aplicacion,
                          comentario)
VALUES (1,
        1,
        2,
        '2024-10-01 10:00:00+00',
        'Aplicada para restaurar salud.'),
       (2,
        2,
        2,
        '2024-09-15 11:00:00+00',
        'Cura de envenenamiento.'),
       (3,
        3,
        1,
        '2024-10-03 12:00:00+00',
        'Restauración de salud.'),
       (4,
        1,
        2,
        '2024-09-20 09:00:00+00',
        'Aplicada para restaurar salud.'),
       (5,
        2,
        1,
        '2024-08-30 08:30:00+00',
        'Cura de envenenamiento.'),
       (6,
        3,
        1,
        '2024-10-05 10:30:00+00',
        'Restauración de salud.'),
       (7,
        1,
        2,
        '2024-09-25 11:15:00+00',
        'Aplicada para restaurar salud.'),
       (8,
        2,
        1,
        '2024-10-02 09:45:00+00',
        'Cura de envenenamiento.'),
       (9,
        3,
        1,
        '2024-10-04 10:00:00+00',
        'Restauración de salud.'),
       (10,
        1,
        2,
        '2024-09-28 11:00:00+00',
        'Aplicada para restaurar salud.');

-- Poblar tabla historial_estados
INSERT INTO historial_estados (mascota_id,
                               estado_id,
                               fecha_cambio,
                               comentario,
                               empleado_id)
VALUES (1,
        1,
        '2024-10-01 10:00:00+00',
        'Consulta inicial.',
        4),
       (1,
        3,
        '2024-10-02 10:00:00+00',
        'Estable después de tratamiento.',
        4),
       (2,
        1,
        '2024-09-15 11:00:00+00',
        'Consulta inicial.',
        4),
       (3,
        4,
        '2024-10-03 12:00:00+00',
        'Crítico, necesita atención.',
        4),
       (4,
        3,
        '2024-09-20 09:00:00+00',
        'Estable después de tratamiento.',
        4),
       (5,
        2,
        '2024-08-30 08:30:00+00',
        'En observación.',
        4),
       (6,
        5,
        '2024-10-05 10:30:00+00',
        'Recuperándose.',
        4),
       (7,
        1,
        '2024-09-25 11:15:00+00',
        'Consulta inicial.',
        4),
       (8,
        2,
        '2024-10-02 09:45:00+00',
        'En observación.',
        4),
       (9,
        3,
        '2024-10-04 10:00:00+00',
        'Estable después de tratamiento.',
        4),
       (10,
        4,
        '2024-09-28 11:00:00+00',
        'Crítico, necesita atención.',
        4);

-- 👨‍🎓 Alumnos
INSERT INTO alumnos (nombre, correo, edad, nivel)
VALUES ('Juan Pérez', 'juan.perez@email.com', 10, 'básico'),
       ('María López', 'maria.lopez@email.com', 12, 'intermedio'),
       ('Carlos Ruiz', 'carlos.ruiz@email.com', 14, 'avanzado'),
       ('Laura Torres', 'laura.torres@email.com', 9, 'básico'),
       ('Ana García', 'ana.garcia@email.com', 11, 'intermedio');

-- 👨‍🏫 Profesores
INSERT INTO profesores (nombre, especialidad, disponibilidad)
VALUES ('Ricardo Gómez', 'Guitarra', 'Lunes a Viernes 8:00-12:00'),
       ('Patricia Díaz', 'Piano', 'Lunes a Viernes 14:00-18:00'),
       ('Fernando Morales', 'Violín', 'Martes y Jueves 10:00-16:00'),
       ('Sofía Ríos', 'Batería', 'Lunes, Miércoles y Viernes 9:00-13:00');

-- 🏢 Salas
INSERT INTO salas (nombre, capacidad)
VALUES ('Sala 1', 10),
       ('Sala 2', 8),
       ('Sala 3', 12);

-- 🥁 Instrumentos
INSERT INTO instrumentos (nombre, tipo, estado)
VALUES ('Guitarra Clásica', 'Cuerda', 'activo'),
       ('Piano Yamaha', 'Teclado', 'activo'),
       ('Violín Stradivarius', 'Cuerda', 'mantenimiento'),
       ('Batería Acústica', 'Percusión', 'activo');

-- 📚 Clases
INSERT INTO clases (horario, sala_id, instrumento_id, profesor_id)
VALUES ('2025-05-15T09:00:00', 1, 1, 1),
       ('2025-05-16T14:00:00', 2, 2, 2),
       ('2025-05-17T10:30:00', 3, 4, 4);

-- 🧾 Evaluaciones
INSERT INTO evaluaciones (fecha, calificacion, observaciones, alumno_id, profesor_id)
VALUES ('2025-03-10', 4.5, 'Buena técnica y ritmo.', 1, 1),
       ('2025-03-11', 3.8, 'Debe mejorar digitación.', 2, 2),
       ('2025-03-12', 4.2, 'Buen desempeño general.', 3, 1);

-- ✅ Inscripciones
INSERT INTO inscripciones (alumno_id, clase_id)
VALUES (1, 1),
       (2, 2),
       (3, 1),
       (4, 3),
       (5, 2);
