INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (0,  0, '03.00', '0.025');
INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (1,  10, '12.00', '0.00');
INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (11, 20, '00,00', '0.082');
INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (21, 30, '00,00', '0.069');
INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (31, 40, '00,00', '0.047');
INSERT INTO taxas_transferencia (de, ate, valor, taxa) VALUES (41, 50, '00,00', '0.017');

INSERT INTO transferencias (agendada, data_criacao, data_transferencia, conta_destino, conta_origem, taxa,valor)
    VALUES (1,  '2023-11-15', '2023-11-16', '3490823420', '2349082222', '0.1', '100.00');
