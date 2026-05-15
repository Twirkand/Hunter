PRAGMA foreign_keys = OFF;

DELETE FROM monstruo;
DELETE FROM sqlite_sequence;
DELETE FROM anfibio;
DELETE FROM bestia_de_colmillos;
DELETE FROM carapaceon;
DELETE FROM cephalopodo;
DELETE FROM dragon_anciano;
DELETE FROM leviatan;
DELETE FROM neopteron;
DELETE FROM semianciano;
DELETE FROM temnoceran;
DELETE FROM wyvern_bruto;
DELETE FROM wyvern_de_colmillos;
DELETE FROM wyvern_nadador;
DELETE FROM wyvern_pajaro;
DELETE FROM wyvern_serpiente;
DELETE FROM wyvern_volador;

PRAGMA foreign_keys = ON;

INSERT INTO monstruo (nombre, tipo, elemento, primera_aparicion) VALUES

-- =====================================================
-- MH1 / MHF / MHFU
-- =====================================================
('Rathalos','Wyvern volador','Fuego','MH1'),
('Rathian','Wyvern volador','Fuego','MH1'),
('Rathalos azul','Wyvern volador','Fuego','MH1'),
('Rathian rosa','Wyvern volador','Fuego','MH1'),
('Rathalos plateado','Wyvern volador','Fuego','MHFU'),
('Rathian dorada','Wyvern volador','Fuego','MHFU'),

('Yian Kut-Ku','Wyvern pájaro','Fuego','MH1'),
('Yian Kut-Ku azul','Wyvern pájaro','Fuego','MH1'),

('Gypceros','Wyvern pájaro','Veneno','MH1'),
('Gypceros púrpura','Wyvern pájaro','Veneno','MHFU'),

('Khezu','Wyvern volador','Rayo','MH1'),

('Basarios','Wyvern bruto','Fuego','MH1'),
('Gravios','Wyvern bruto','Fuego','MH1'),
('Gravios negro','Wyvern bruto','Fuego','MHFU'),

('Diablos','Wyvern volador','Ninguno','MH1'),
('Diablos negro','Wyvern volador','Ninguno','MH1'),
('Monoblos','Wyvern volador','Ninguno','MH1'),
('Monoblos blanco','Wyvern volador','Ninguno','MHFU'),

('Plesioth','Wyvern nadador','Agua','MH1'),
('Plesioth verde','Wyvern nadador','Agua','MHFU'),

('Cephadrome','Wyvern nadador','Ninguno','MH1'),

-- =====================================================
-- DRAGONES ANCIANOS CLÁSICOS
-- =====================================================
('Kirin','Dragón anciano','Rayo','MH1'),
('Fatalis','Dragón anciano','Dragón','MH1'),
('Fatalis carmesí','Dragón anciano','Fuego','MHFU'),
('Fatalis blanco','Dragón anciano','Rayo','MHFU'),

('Kushala Daora','Dragón anciano','Viento','MH2'),
('Teostra','Dragón anciano','Fuego','MH2'),
('Lunastra','Dragón anciano','Fuego','MH2'),
('Chameleos','Dragón anciano','Veneno','MH2'),

('Lao-Shan Lung','Dragón anciano','Ninguno','MHFU'),
('Yama Tsukami','Dragón anciano','Ninguno','MHFU'),
('Shen Gaoren','Carapaceon','Ninguno','MHFU'),

-- =====================================================
-- MH2 / MHFU
-- =====================================================
('Tigrex','Wyvern volador','Ninguno','MH2'),
('Tigrex bruto','Wyvern volador','Ninguno','MHFU'),

('Nargacuga','Wyvern volador','Ninguno','MH2'),

('Rajang','Bestia de colmillos','Rayo','MH2'),
('Rajang furioso','Bestia de colmillos','Rayo','MH4U'),

('Congalala','Bestia de colmillos','Veneno','MH2'),
('Congalala esmeralda','Bestia de colmillos','Veneno','MHFU'),

('Blangonga','Bestia de colmillos','Hielo','MH2'),

('Akantor','Wyvern bruto','Ninguno','MHFU'),
('Ukanlos','Wyvern bruto','Hielo','MHFU'),

-- =====================================================
-- MH3 / TRI / 3U
-- =====================================================
('Lagiacrus','Leviatán','Rayo','MH3'),
('Lagiacrus marino','Leviatán','Rayo','MH3U'),

('Ceadeus','Dragón anciano','Agua','MH3'),

('Alatreon','Dragón anciano','Dragón','MH3U'),
('Dire Miralis','Dragón anciano','Fuego','MH3U'),

('Gobul','Leviatán','Agua','MH3'),

('Ludroth real','Leviatán','Agua','MH3'),
('Ludroth púrpura','Leviatán','Agua','MH3U'),

('Barroth','Wyvern bruto','Ninguno','MH3'),
('Barroth jade','Wyvern bruto','Ninguno','MH3U'),

('Uragaan','Wyvern bruto','Fuego','MH3'),
('Agnaktor','Wyvern bruto','Fuego','MH3U'),

('Deviljho','Wyvern bruto','Dragón','MH3'),

('Arzuros','Bestia de colmillos','Ninguno','MH3U'),
('Lagombi','Bestia de colmillos','Hielo','MH3U'),
('Volvidon','Bestia de colmillos','Fuego','MH3U'),

-- =====================================================
-- MH4 / MH4U
-- =====================================================
('Gore Magala','Semianciano','Ninguno','MH4'),
('Shagaru Magala','Dragón anciano','Ninguno','MH4U'),

('Seregios','Wyvern volador','Ninguno','MH4U'),

('Tetsucabra','Anfibio','Ninguno','MH4U'),
('Zamtrios','Anfibio','Hielo','MH4U'),
('Nerscylla','Neopteron','Veneno','MH4U'),
('Kecha Wacha','Bestia de colmillos','Ninguno','MH4U'),

('Dalamadur','Wyvern serpiente','Dragón','MH4U'),
('Shah Dalamadur','Wyvern serpiente','Dragón','MH4U'),

('Gogmazios','Dragón anciano','Fuego','MH4U'),

-- =====================================================
-- MHX / MHGU
-- =====================================================
('Mizutsune','Leviatán','Agua','MHX'),
('Mizutsune aurora','Leviatán','Hielo','MHGU'),

('Glavenus','Wyvern bruto','Fuego','MHX'),
('Glavenus Hellblade','Wyvern bruto','Fuego','MHGU'),

('Astalos','Wyvern volador','Rayo','MHX'),
('Astalos Boltreaver','Wyvern volador','Rayo','MHGU'),

('Gammoth','Bestia de colmillos','Hielo','MHX'),
('Gammoth Elderfrost','Bestia de colmillos','Hielo','MHGU'),

('Malfestio','Wyvern volador','Parálisis','MHGU'),

('Nakarkos','Dragón anciano','Dragón','MHGU'),
('Ahtal-Ka','Neopteron','Ninguno','MHGU'),

('Valstrax','Dragón anciano','Dragón','MHGU'),

-- =====================================================
-- DEVIANTS MHGU
-- =====================================================
('Arzuros Yelmo Rojo','Bestia de colmillos','Ninguno','MHGU'),
('Lagombi Barón Nevado','Bestia de colmillos','Hielo','MHGU'),
('Hermitaur Puño de Piedra','Carapaceon','Agua','MHGU'),
('Ceanataur Desgarracobre','Carapaceon','Agua','MHGU'),

('Rathalos Rey Celeste','Wyvern volador','Fuego','MHGU'),
('Rathian Reina Oscura','Wyvern volador','Fuego','MHGU'),

('Zinogre Señor del Trueno','Wyvern de colmillos','Rayo','MHGU'),
('Nargacuga Viento Plateado','Wyvern volador','Ninguno','MHGU'),
('Tigrex Garras Funestas','Wyvern volador','Ninguno','MHGU'),
('Diablos Masacre Sangrienta','Wyvern volador','Ninguno','MHGU'),

('Uragaan Barbacristal','Wyvern bruto','Fuego','MHGU'),
('Tetsucabra Colmillo Taladrador','Anfibio','Ninguno','MHGU'),

('Glavenus Hellblade','Wyvern bruto','Fuego','MHGU'),
('Astalos Boltreaver','Wyvern volador','Rayo','MHGU'),
('Mizutsune Vidente del Alma','Leviatán','Agua','MHGU'),
('Gammoth Escarcha Antigua','Bestia de colmillos','Hielo','MHGU'),

-- =====================================================
-- MH WORLD / ICEBORNE
-- =====================================================
('Nergigante','Dragón anciano','Ninguno','MHWorld'),
('Nergigante Ruina','Dragón anciano','Ninguno','Iceborne'),

('Xeno''jiiva','Dragón anciano','Dragón','MHWorld'),
('Safi''jiiva','Dragón anciano','Dragón','Iceborne'),

('Velkhana','Dragón anciano','Hielo','Iceborne'),
('Namielle','Dragón anciano','Agua','Iceborne'),

('Vaal Hazak','Dragón anciano','Ninguno','MHWorld'),
('Vaal Hazak Velo Negro','Dragón anciano','Ninguno','Iceborne'),

('Shara Ishvalda','Dragón anciano','Ninguno','Iceborne'),

('Magnamalo','Wyvern bruto','Ninguno','MH Rise'),

('Zinogre','Wyvern de colmillos','Rayo','MH3U'),
('Barioth','Wyvern volador','Hielo','MH3U'),
('Brachydios','Wyvern bruto','Explosivo','MH3U'),

('Rajang Furioso','Bestia de colmillos','Rayo','MH4U');