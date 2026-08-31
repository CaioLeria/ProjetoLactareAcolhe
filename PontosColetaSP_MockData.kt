package br.com.fiap.lactareacolhe.data

import br.com.fiap.lactareacolhe.model.PontoColeta

/**
 * Pontos de coleta / Bancos de Leite Humano — Cidade de São Paulo.
 *
 * Fonte: Rede Brasileira de Bancos de Leite Humano (Fiocruz)
 * https://rblh.fiocruz.br/localizacao-dos-blhs?field_estado_da_uniao_target_id=930&field_cidade_target_id=SAO+PAULO+%28683%29
 * Consultado em 31/08/2026 — 29 registros (16 Bancos de Leite, 1 Centro de Referência, 12 Postos de Coleta).
 *
 * Observações:
 * - "regiao" é uma classificação aproximada por zona da cidade (Zona Norte/Sul/Leste/Oeste/Centro),
 *   não fornecida pela fonte original — foi inferida a partir do bairro de cada endereço.
 * - Os itens #25 (Francisco Morato) e #27 (Guarulhos) aparecem no filtro "São Paulo" da fonte,
 *   mas ficam fisicamente em outros municípios da Grande São Paulo — mantidos aqui como constam
 *   no site oficial, com a região marcada pelo município real.
 * - Telefone "Não informado" = campo vazio na fonte original.
 * - O telefone do item #29 veio truncado/malformado na fonte ("56-6812-40") — reproduzido como está,
 *   recomenda-se confirmar antes de exibir no app.
 */
val pontosDeColetaSP: List<PontoColeta> = listOf(
    // ---- Bancos de Leite ----
    PontoColeta(1, "Banco de Leite Humano Cachoeirinha", "Avenida Deputado Emílio Carlos, 3100, Cachoeirinha, São Paulo", "(11) 3986-1011", "02720-200", "Zona Norte"),
    PontoColeta(2, "Banco de Leite Humano da Santa Casa de São Paulo (Hospital Central São Paulo)", "Rua Dr. Cesário Mota Júnior, 112, Vila Buarque, São Paulo", "(11) 2176-7390", "01221-020", "Centro"),
    PontoColeta(3, "Banco de Leite Humano do Hospital do Servidor Público Estadual", "Rua Pedro de Toledo, 1800, 5º andar, Vila Clementino, São Paulo", "(11) 4573-8172", "04039-004", "Zona Sul"),
    PontoColeta(4, "Banco de Leite Humano do Hospital e Maternidade Santa Joana", "Rua Dr. Eduardo Amaro, 157, Paraíso, São Paulo", "(11) 5080-6062", "04104-080", "Zona Sul"),
    PontoColeta(5, "Banco de Leite Humano do Hospital Geral de Pedreira", "Rua João Francisco de Moura, 251, Vila Campo Grande, São Paulo", "(11) 5613-5900", "04455-170", "Zona Sul"),
    PontoColeta(6, "Banco de Leite Humano do Hospital Ipiranga", "Avenida Nazaré, 28, 8º andar, Ipiranga, São Paulo", "(11) 2067-7866", "04262-000", "Zona Sul"),
    PontoColeta(7, "Banco de Leite Humano do Hospital Israelita Albert Einstein", "Avenida Albert Einstein, 627, 701 - 7º andar, Bloco D, Morumbi, São Paulo", "(11) 2151-2734", "05651-901", "Zona Oeste"),
    PontoColeta(8, "Banco de Leite Humano do Hospital Maternidade Interlagos Waldemar Seyssel-Arrel", "Rua Guaiuba, 312, Cidade Dutra, São Paulo", "(11) 5669-1891", "04810-110", "Zona Sul"),
    PontoColeta(9, "Banco de Leite Humano do Hospital Municipal do Campo Limpo", "Estrada de Itapecerica, 1661, 2º andar, Vila Maracanã, São Paulo", "(11) 5178-2509", "05835-005", "Zona Sul"),
    PontoColeta(10, "Banco de Leite Humano do Hospital Municipal Prof. Dr. Alípio Correa Netto", "Ala Rodrigo de Brum, 1989, 3º andar, Ermelino Matarazzo, São Paulo", "(11) 3394-8046", "03807-230", "Zona Leste"),
    PontoColeta(11, "Banco de Leite Humano do Hospital São Paulo – HU/UNIFESP", "Rua dos Otonis, 683, Vila Clementino, São Paulo", "(11) 5576-4891", "04037-001", "Zona Sul"),
    PontoColeta(12, "Banco de Leite Humano do Hospital Universitário da USP", "Avenida Professor Lineu Prestes, 2565, Cidade Universitária, São Paulo", "(11) 3091-9210", "05508-900", "Zona Oeste"),
    PontoColeta(13, "Banco de Leite Humano Gabriela Andrade", "Rua Francisco Octávio Pacca, 180, Parque das Nações, São Paulo", "(11) 3544-9444", "04822-030", "Zona Sul"),
    PontoColeta(14, "Banco de Leite Humano Maternidade São Luiz Star", "Rua Helena, 29, Vila Olímpia, São Paulo", "(11) 2121-1349", "04552-050", "Zona Sul"),
    PontoColeta(15, "Banco de Leite Humano Rede Dor São Luíz - Unidade Anália Franco", "Rua Francisco Marengo, 1312, Tatuapé, São Paulo", "(11) 3386-1315", "03313-000", "Zona Leste"),
    PontoColeta(16, "BLH do Centro Neonatal do Instituto da Criança e do Adolescente do HCFMUSP", "Avenida Dr. Enéas de Carvalho Aguiar, 255, Cerqueira César, São Paulo", "(11) 2661-8946", "05403-900", "Zona Oeste"),

    // ---- Centro de Referência ----
    PontoColeta(17, "Banco de Leite Humano Maria José Guardia Mattar – Hospital Maternidade Leonor Mendes de Barros", "Avenida Celso Garcia, 2477, Belenzinho, São Paulo", "(11) 2847-7294", "03015-000", "Zona Leste"),

    // ---- Postos de Coleta ----
    PontoColeta(18, "Hospital Estadual Sapopemba", "Rua Manoel França dos Santos, 174, Jardim Sapopemba, São Paulo", "(11) 2014-6000", "03975-130", "Zona Leste"),
    PontoColeta(19, "Hospital Vila Nova Star", "Rua Dr. Alceu de Campos Rodrigues, 126, Vila Nova Conceição, São Paulo", "Não informado", "04544-000", "Zona Sul"),
    PontoColeta(20, "Posto de Coleta da Maternidade Pro Matre Paulista", "Rua Joaquim Eugênio de Lima, 383, Bela Vista, São Paulo", "(11) 3269-2279", "01403-001", "Centro"),
    PontoColeta(21, "Posto de Coleta de Leite Humano Amparo Maternal", "Rua Loefgren, 101, Vila Clementino, São Paulo", "Não informado", "04040-033", "Zona Sul"),
    PontoColeta(22, "Posto de Coleta de Leite Humano Chella e Moise Safra", "Rua Napoleão de Barros, 754, 8º andar, Vila Clementino, São Paulo", "(11) 5576-4107", "04024-002", "Zona Sul"),
    PontoColeta(23, "Posto de Coleta de Leite Humano do H. M. Tide Setúbal", "Rua Dr. José Guilherme Eiras, 123, São Miguel Paulista, São Paulo", "(11) 3394-8779", "08010-220", "Zona Leste"),
    PontoColeta(24, "Posto de Coleta de Leite Humano do Hospital do Coração - HCOR", "Rua Desembargador Eliseu Guilherme, 123, Paraíso, São Paulo", "(11) 3053-6611", "04004-030", "Zona Sul"),
    PontoColeta(25, "Posto de Coleta de Leite Humano do Hospital Estadual de Francisco Morato", "Rodovia Manoel Silvério Pinto, 25, Belém, Francisco Morato", "(11) 4489-9444", "07901-155", "Francisco Morato (Grande SP)"),
    PontoColeta(26, "Posto de Coleta de Leite Humano do Hospital Estadual de Vila Alpina", "Rua Francisco Falconi, 1501, Vila Alpina, São Paulo", "(11) 2318-2100", "03227-000", "Zona Leste"),
    PontoColeta(27, "Posto de Coleta de Leite Humano do Hospital Geral de Guarulhos", "Alameda dos Lírios, 200, CECAP, Guarulhos", "(11) 3466-1369", "07190-912", "Guarulhos (Grande SP)"),
    PontoColeta(28, "Posto de Coleta de Leite Humano do Hospital Maternidade Santa Maria", "Rua Leôncio de Carvalho, 233, Paraíso, São Paulo", "Não informado", "04003-010", "Zona Sul"),
    PontoColeta(29, "Posto de Coleta do Hospital Maternidade Interlagos Waldemar Seyssel-Arrelia", "Rua Leonor Alvim, 211, Cidade Dutra, São Paulo", "56-6812-40", "04802-190", "Zona Sul"),
)
