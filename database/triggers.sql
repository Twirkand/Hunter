-- =====================================================
-- 🧹 LIMPIEZA DE TRIGGERS ANTIGUOS
-- =====================================================

DROP TRIGGER IF EXISTS trg_wyvern_volador;
DROP TRIGGER IF EXISTS trg_wyvern_bruto;
DROP TRIGGER IF EXISTS trg_wyvern_colmillos;
DROP TRIGGER IF EXISTS trg_wyvern_nadador;
DROP TRIGGER IF EXISTS trg_wyvern_pajaro;
DROP TRIGGER IF EXISTS trg_wyvern_serpiente;
DROP TRIGGER IF EXISTS trg_leviatan;
DROP TRIGGER IF EXISTS trg_anfibio;
DROP TRIGGER IF EXISTS trg_carapaceon;
DROP TRIGGER IF EXISTS trg_cephalopodo;
DROP TRIGGER IF EXISTS trg_neopteron;
DROP TRIGGER IF EXISTS trg_temnoceran;
DROP TRIGGER IF EXISTS trg_dragon_anciano;
DROP TRIGGER IF EXISTS trg_bestia_colmillos;

-- =====================================================
-- 🧠 NOTA IMPORTANTE
-- Normalización:
-- - LOWER() → ignora mayúsculas
-- - comparación múltiple → cubre tildes y variantes
-- =====================================================

-- =====================================================
-- 🐉 WYVERN VOLADOR
-- =====================================================
CREATE TRIGGER trg_wyvern_volador
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'wyvern volador'
BEGIN
    INSERT INTO wyvern_volador (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐉 WYVERN BRUTO
-- =====================================================
CREATE TRIGGER trg_wyvern_bruto
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'wyvern bruto'
BEGIN
    INSERT INTO wyvern_bruto (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐉 WYVERN DE COLMILLOS (CON TILDE / SIN TILDE)
-- =====================================================
CREATE TRIGGER trg_wyvern_colmillos
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) IN ('wyvern de colmillos', 'wyvern de colmillos')
BEGIN
    INSERT INTO wyvern_de_colmillos (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐉 WYVERN PÁJARO (CON Y SIN TILDE)
-- =====================================================
CREATE TRIGGER trg_wyvern_pajaro
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) IN ('wyvern pajaro', 'wyvern pájaro')
BEGIN
    INSERT INTO wyvern_pajaro (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐉 WYVERN NADADOR
-- =====================================================
CREATE TRIGGER trg_wyvern_nadador
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'wyvern nadador'
BEGIN
    INSERT INTO wyvern_nadador (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐉 WYVERN SERPIENTE
-- =====================================================
CREATE TRIGGER trg_wyvern_serpiente
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'wyvern serpiente'
BEGIN
    INSERT INTO wyvern_serpiente (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🌊 LEVIATÁN (CON TILDE / SIN TILDE)
-- =====================================================
CREATE TRIGGER trg_leviatan
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) IN ('leviatan', 'leviatán')
BEGIN
    INSERT INTO leviatan (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐸 ANFIBIO
-- =====================================================
CREATE TRIGGER trg_anfibio
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'anfibio'
BEGIN
    INSERT INTO anfibio (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🦀 CARAPACEON
-- =====================================================
CREATE TRIGGER trg_carapaceon
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'carapaceon'
BEGIN
    INSERT INTO carapaceon (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐙 CEPHALOPODO
-- =====================================================
CREATE TRIGGER trg_cephalopodo
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'cephalopodo'
BEGIN
    INSERT INTO cephalopodo (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐝 NEOPTERON
-- =====================================================
CREATE TRIGGER trg_neopteron
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) = 'neopteron'
BEGIN
    INSERT INTO neopteron (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🧠 DRAGÓN ANCIANO (CON TILDES ROBUSTO)
-- =====================================================
CREATE TRIGGER trg_dragon_anciano
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) IN ('dragon anciano', 'dragón anciano')
BEGIN
    INSERT INTO dragon_anciano (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;

-- =====================================================
-- 🐗 BESTIA DE COLMILLOS
-- =====================================================
CREATE TRIGGER trg_bestia_colmillos
AFTER INSERT ON monstruo
WHEN LOWER(NEW.tipo) IN ('bestia de colmillos', 'bestia de colmillos')
BEGIN
    INSERT INTO bestia_de_colmillos (id, variantes)
    VALUES (last_insert_rowid(), 0);
END;