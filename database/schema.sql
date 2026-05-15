PRAGMA foreign_keys = OFF;

-- =====================
-- TABLAS DEPENDIENTES
-- =====================
DROP TABLE IF EXISTS drop_monstruo;
DROP TABLE IF EXISTS objeto;

-- =====================
-- SUBTIPOS DE MONSTRUOS
-- =====================
DROP TABLE IF EXISTS anfibio;
DROP TABLE IF EXISTS bestia_de_colmillos;
DROP TABLE IF EXISTS carapaceon;
DROP TABLE IF EXISTS cephalopodo;
DROP TABLE IF EXISTS dragon_anciano;
DROP TABLE IF EXISTS leviatan;
DROP TABLE IF EXISTS neopteron;
DROP TABLE IF EXISTS semianciano;
DROP TABLE IF EXISTS temnoceran;
DROP TABLE IF EXISTS wyvern_bruto;
DROP TABLE IF EXISTS wyvern_de_colmillos;
DROP TABLE IF EXISTS wyvern_nadador;
DROP TABLE IF EXISTS wyvern_pajaro;
DROP TABLE IF EXISTS wyvern_serpiente;
DROP TABLE IF EXISTS wyvern_volador;

-- =====================
-- TABLA PRINCIPAL
-- =====================
DROP TABLE IF EXISTS monstruo;

PRAGMA foreign_keys = ON;

------------------
-- TABLA BASE
------------------

CREATE TABLE monstruo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    tipo TEXT NOT NULL,
    elemento TEXT,
    primera_aparicion TEXT
);

------------------
-- ANFIBIO
------------------

CREATE TABLE anfibio (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- BESTIA DE COLMILLOS
------------------

CREATE TABLE bestia_de_colmillos (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- CARAPACEON
------------------

CREATE TABLE carapaceon (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- CEPHALOPODO
------------------

CREATE TABLE cephalopodo (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- DRAGON ANCIANO
------------------

CREATE TABLE dragon_anciano (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- LEVIATAN
------------------

CREATE TABLE leviatan (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- NEOPTERO------------------

CREATE TABLE neopteron (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- SEMIANCIANO
------------------

CREATE TABLE semianciano (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- TEMNOCERAN
------------------

CREATE TABLE temnoceran (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN BRUTO
------------------

CREATE TABLE wyvern_bruto (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN DE COLMILLOS
------------------

CREATE TABLE wyvern_de_colmillos (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN NADADOR
------------------

CREATE TABLE wyvern_nadador (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN PAJARO
------------------

CREATE TABLE wyvern_pajaro (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN SERPIENTE
------------------

CREATE TABLE wyvern_serpiente (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- WYVERN VOLADOR
------------------

CREATE TABLE wyvern_volador (
    id INTEGER PRIMARY KEY,
    variantes INTEGER NOT NULL,

    FOREIGN KEY (id)
        REFERENCES monstruo(id)
        ON DELETE CASCADE
);

------------------
-- OBJETOS
------------------

CREATE TABLE objeto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    rareza INTEGER,
    descripcion TEXT
);

------------------
-- DROPS
------------------

CREATE TABLE drop_monstruo (
    id_monstruo INTEGER,
    id_objeto INTEGER,
    probabilidad REAL,

    PRIMARY KEY (id_monstruo, id_objeto),

    FOREIGN KEY (id_monstruo)
        REFERENCES monstruo(id)
        ON DELETE CASCADE,

    FOREIGN KEY (id_objeto)
        REFERENCES objeto(id)
        ON DELETE CASCADE
);