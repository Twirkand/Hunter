
PRAGMA foreign_keys = OFF;

DELETE FROM monstruo;
DELETE FROM sqlite_sequence;

PRAGMA foreign_keys = ON;

BEGIN TRANSACTION;

INSERT INTO monstruo (nombre, tipo, elemento, vida, primera_aparicion) VALUES

-- =====================================================
-- MH1 / MHF / MHFU
-- =====================================================
('Rathalos','Wyvern volador','Fuego',7000,'MH1'),
('Rathian','Wyvern volador','Fuego',6800,'MH1'),
('Rathalos azul','Wyvern volador','Fuego',7400,'MH1'),
('Rathian rosa','Wyvern volador','Fuego',7200,'MH1'),
('Rathalos plateado','Wyvern volador','Fuego',9000,'MHFU'),
('Rathian dorada','Wyvern volador','Fuego',8800,'MHFU'),

('Yian Kut-Ku','Wyvern pájaro','Fuego',3500,'MH1'),
('Yian Kut-Ku azul','Wyvern pájaro','Fuego',3800,'MH1'),

('Gypceros','Wyvern pájaro','Veneno',4200,'MH1'),
('Gypceros púrpura','Wyvern pájaro','Veneno',4500,'MHFU'),

('Khezu','Wyvern volador','Rayo',5000,'MH1'),

('Basarios','Wyvern bruto','Fuego',6000,'MH1'),
('Gravios','Wyvern bruto','Fuego',8200,'MH1'),
('Gravios negro','Wyvern bruto','Fuego',8800,'MHFU'),

('Diablos','Wyvern volador','Neutral',8000,'MH1'),
('Diablos negro','Wyvern volador','Neutral',8500,'MH1'),
('Monoblos','Wyvern volador','Neutral',7800,'MH1'),
('Monoblos blanco','Wyvern volador','Neutral',8200,'MHFU'),

('Plesioth','Wyvern nadador','Agua',5200,'MH1'),
('Plesioth verde','Wyvern nadador','Agua',5500,'MHFU'),

('Cephadrome','Wyvern nadador','Neutral',4000,'MH1'),

-- =====================================================
-- DRAGONES ANCIANOS CLÁSICOS
-- =====================================================
('Kirin','Dragón anciano','Rayo',7500,'MH1'),
('Fatalis','Dragón anciano','Dragón',15000,'MH1'),
('Fatalis carmesí','Dragón anciano','Fuego',16000,'MHFU'),
('Fatalis blanco','Dragón anciano','Rayo',17000,'MHFU'),

('Kushala Daora','Dragón anciano','Viento',9000,'MH2'),
('Teostra','Dragón anciano','Fuego',9200,'MH2'),
('Lunastra','Dragón anciano','Fuego',9300,'MH2'),
('Chameleos','Dragón anciano','Veneno',8800,'MH2'),

('Lao-Shan Lung','Dragón anciano','Neutral',14000,'MHFU'),
('Yama Tsukami','Dragón anciano','Neutral',15000,'MHFU'),
('Shen Gaoren','Carapaceon','Neutral',13000,'MHFU'),

-- =====================================================
-- MH2 / MHFU
-- =====================================================
('Tigrex','Wyvern volador','Neutral',7200,'MH2'),
('Tigrex bruto','Wyvern volador','Neutral',7800,'MHFU'),

('Nargacuga','Wyvern volador','Oscuro',6000,'MH2'),

('Rajang','Bestia de colmillos','Rayo',8000,'MH2'),
('Rajang furioso','Bestia de colmillos','Rayo',9000,'MHFU'),

('Congalala','Bestia de colmillos','Veneno',4800,'MH2'),
('Congalala esmeralda','Bestia de colmillos','Veneno',5100,'MHFU'),

('Blangonga','Bestia de colmillos','Hielo',5000,'MH2'),

('Akantor','Wyvern bruto','Neutral',11000,'MHFU'),
('Ukanlos','Wyvern bruto','Hielo',11500,'MHFU'),

-- =====================================================
-- MH3 / TRI / 3U
-- =====================================================
('Lagiacrus','Leviatán','Rayo',8500,'MH3'),
('Lagiacrus marino','Leviatán','Rayo',9000,'MH3U'),

('Ceadeus','Dragón anciano','Agua',13000,'MH3'),

('Alatreon','Dragón anciano','Elemental',14000,'MH3U'),
('Dire Miralis','Dragón anciano','Fuego',15000,'MH3U'),

('Gobul','Leviatán','Agua',6000,'MH3'),

('Ludroth real','Leviatán','Agua',4000,'MH3'),
('Ludroth púrpura','Leviatán','Agua',4300,'MH3U'),

('Barroth','Wyvern bruto','Neutral',5500,'MH3'),
('Barroth jade','Wyvern bruto','Neutral',5800,'MH3U'),

('Uragaan','Wyvern bruto','Fuego',8000,'MH3'),
('Agnaktor','Wyvern bruto','Fuego',8200,'MH3U'),

('Deviljho','Wyvern bruto','Dragón',9000,'MH3'),

('Arzuros','Bestia de colmillos','Neutral',3800,'MH3U'),
('Lagombi','Bestia de colmillos','Hielo',3900,'MH3U'),
('Volvidon','Bestia de colmillos','Fuego',4000,'MH3U'),

-- =====================================================
-- MH4 / MH4U
-- =====================================================
('Gore Magala','Semianciano','Oscuro',8000,'MH4'),
('Shagaru Magala','Dragón anciano','Oscuro',9500,'MH4U'),

('Seregios','Wyvern volador','Neutral',7800,'MH4U'),

('Tetsucabra','Anfibio','Neutral',4000,'MH4U'),
('Zamtrios','Anfibio','Hielo',4500,'MH4U'),
('Nerscylla','Neopteron','Veneno',4200,'MH4U'),
('Kecha Wacha','Bestia de colmillos','Neutral',4100,'MH4U'),

('Dalamadur','Wyvern serpiente','Dragón',20000,'MH4U'),
('Shah Dalamadur','Wyvern serpiente','Dragón',21000,'MH4U'),

('Gogmazios','Dragón anciano','Fuego',18000,'MH4U'),

-- =====================================================
-- MHX / MHGU
-- =====================================================
('Mizutsune','Leviatán','Agua',7500,'MHX'),
('Mizutsune aurora','Leviatán','Hielo',8000,'MHGU'),

('Glavenus','Wyvern bruto','Fuego',8200,'MHX'),
('Glavenus Hellblade','Wyvern bruto','Fuego',8800,'MHGU'),

('Astalos','Wyvern volador','Rayo',7800,'MHX'),
('Astalos Boltreaver','Wyvern volador','Rayo',8400,'MHGU'),

('Gammoth','Bestia de colmillos','Hielo',9000,'MHX'),
('Gammoth Elderfrost','Bestia de colmillos','Hielo',9500,'MHGU'),

('Malfestio','Wyvern volador','Oscuro',6500,'MHGU'),

('Nakarkos','Cephalopodo','Dragón',15000,'MHGU'),
('Ahtal-Ka','Neopteron','Neutral',14000,'MHGU'),

('Valstrax','Dragón anciano','Dragón',12000,'MHGU'),

-- =====================================================
-- DEVIANTS MHGU
-- =====================================================
('Arzuros Cabeza Roja','Bestia de colmillos','Neutral',5000,'MHGU'),
('Lagombi Baron de Nieve','Bestia de colmillos','Hielo',5200,'MHGU'),
('Hermitaur Piedra','Carapaceon','Agua',5500,'MHGU'),
('Ceanataur Rustrazor','Carapaceon','Agua',5800,'MHGU'),

('Rathalos Rey Dragón','Wyvern volador','Fuego',9500,'MHGU'),
('Rathian Reina Oscura','Wyvern volador','Fuego',9200,'MHGU'),

('Zinogre Señor del Trueno','Wyvern volador','Rayo',9000,'MHGU'),
('Nargacuga Ala Plateada','Wyvern volador','Oscuro',8800,'MHGU'),
('Tigrex Grimclaw','Wyvern volador','Neutral',9000,'MHGU'),
('Diablos Bloodbath','Wyvern volador','Neutral',9500,'MHGU'),

('Uragaan Cristal','Wyvern bruto','Fuego',8800,'MHGU'),
('Tetsucabra Drilltusk','Anfibio','Neutral',5200,'MHGU'),

('Glavenus Hellblade','Wyvern bruto','Fuego',8800,'MHGU'),
('Astalos Boltreaver','Wyvern volador','Rayo',8400,'MHGU'),
('Mizutsune Soulseer','Leviatán','Agua',8200,'MHGU'),
('Gammoth Elderfrost','Bestia de colmillos','Hielo',9500,'MHGU');

COMMIT;