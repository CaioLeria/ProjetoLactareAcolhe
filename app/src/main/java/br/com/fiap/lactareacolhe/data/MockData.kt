package br.com.fiap.lactareacolhe.data

import br.com.fiap.lactareacolhe.model.MensagemChat
import br.com.fiap.lactareacolhe.model.OpcaoChat
import br.com.fiap.lactareacolhe.model.PassoOnboarding
import br.com.fiap.lactareacolhe.model.PontoColeta
import br.com.fiap.lactareacolhe.navigation.Rotas

object MockData {

    const val CHAVE_MENSAGEM_INICIAL = "inicio"
    const val CHAVE_FALLBACK = "fallback"

    val passosOnboarding: List<PassoOnboarding> = listOf(
        PassoOnboarding(
            titulo = "Bem-vinda ao Lactare Acolhe",
            texto = "Um espaço para tirar dúvidas sobre amamentação e doação de leite humano, no seu tempo e sem julgamento."
        ),
        PassoOnboarding(
            titulo = "Sua dúvida tem resposta",
            texto = "Converse com a gente sobre pega, produção de leite, armazenamento e o que mais precisar saber."
        ),
        PassoOnboarding(
            titulo = "Doar é mais simples do que parece",
            texto = "Encontre o banco de leite ou posto de coleta mais perto de você e descubra como dar o primeiro passo."
        )
    )

    val pontosDeColeta: List<PontoColeta> = listOf(
        PontoColeta(1, "Banco de Leite Humano Cachoeirinha", "Avenida Deputado Emílio Carlos, 3100", "Cachoeirinha", "Zona Norte", "(11) 3986-1011", "02720-200"),
        PontoColeta(2, "Banco de Leite Humano da Santa Casa de São Paulo", "Rua Dr. Cesário Mota Júnior, 112", "Vila Buarque", "Centro", "(11) 2176-7390", "01221-020"),
        PontoColeta(3, "Banco de Leite Humano do Hospital do Servidor Público Estadual", "Rua Pedro de Toledo, 1800", "Vila Clementino", "Zona Sul", "(11) 4573-8172", "04039-004"),
        PontoColeta(4, "Banco de Leite Humano do Hospital e Maternidade Santa Joana", "Rua Dr. Eduardo Amaro, 157", "Paraíso", "Zona Sul", "(11) 5080-6062", "04104-080"),
        PontoColeta(5, "Banco de Leite Humano do Hospital Geral de Pedreira", "Rua João Francisco de Moura, 251", "Vila Campo Grande", "Zona Sul", "(11) 5613-5900", "04455-170"),
        PontoColeta(6, "Banco de Leite Humano do Hospital Ipiranga", "Avenida Nazaré, 28", "Ipiranga", "Zona Sul", "(11) 2067-7866", "04262-000"),
        PontoColeta(7, "Banco de Leite Humano do Hospital Israelita Albert Einstein", "Avenida Albert Einstein, 627", "Morumbi", "Zona Oeste", "(11) 2151-2734", "05651-901"),
        PontoColeta(8, "Banco de Leite Humano do Hospital Maternidade Interlagos Waldemar Seyssel", "Rua Guaiuba, 312", "Cidade Dutra", "Zona Sul", "(11) 5669-1891", "04810-110"),
        PontoColeta(9, "Banco de Leite Humano do Hospital Municipal do Campo Limpo", "Estrada de Itapecerica, 1661", "Vila Maracanã", "Zona Sul", "(11) 5178-2509", "05835-005"),
        PontoColeta(10, "Banco de Leite Humano do Hospital Municipal Prof. Dr. Alípio Correa Netto", "Rua Rodrigo de Brum, 1989", "Ermelino Matarazzo", "Zona Leste", "(11) 3394-8046", "03807-230"),
        PontoColeta(11, "Banco de Leite Humano do Hospital São Paulo (HU/UNIFESP)", "Rua dos Otonis, 683", "Vila Clementino", "Zona Sul", "(11) 5576-4891", "04037-001"),
        PontoColeta(12, "Banco de Leite Humano do Hospital Universitário da USP", "Avenida Professor Lineu Prestes, 2565", "Cidade Universitária", "Zona Oeste", "(11) 3091-9210", "05508-900"),
        PontoColeta(13, "Banco de Leite Humano Gabriela Andrade", "Rua Francisco Octávio Pacca, 180", "Parque das Nações", "Zona Sul", "(11) 3544-9444", "04822-030"),
        PontoColeta(14, "Banco de Leite Humano Maternidade São Luiz Star", "Rua Helena, 29", "Vila Olímpia", "Zona Sul", "(11) 2121-1349", "04552-050"),
        PontoColeta(15, "Banco de Leite Humano Rede Dor São Luiz - Unidade Anália Franco", "Rua Francisco Marengo, 1312", "Tatuapé", "Zona Leste", "(11) 3386-1315", "03313-000"),
        PontoColeta(16, "BLH do Instituto da Criança e do Adolescente do HCFMUSP", "Avenida Dr. Enéas de Carvalho Aguiar, 255", "Cerqueira César", "Zona Oeste", "(11) 2661-8946", "05403-900"),
        PontoColeta(17, "Banco de Leite Humano Maria José Guardia Mattar - Maternidade Leonor Mendes de Barros", "Avenida Celso Garcia, 2477", "Belenzinho", "Zona Leste", "(11) 2847-7294", "03015-000"),
        PontoColeta(18, "Posto de Coleta do Hospital Estadual Sapopemba", "Rua Manoel França dos Santos, 174", "Jardim Sapopemba", "Zona Leste", "(11) 2014-6000", "03975-130"),
        PontoColeta(19, "Posto de Coleta do Hospital Vila Nova Star", "Rua Dr. Alceu de Campos Rodrigues, 126", "Vila Nova Conceição", "Zona Sul", "Não informado", "04544-000"),
        PontoColeta(20, "Posto de Coleta da Maternidade Pro Matre Paulista", "Rua Joaquim Eugênio de Lima, 383", "Bela Vista", "Centro", "(11) 3269-2279", "01403-001"),
        PontoColeta(21, "Posto de Coleta de Leite Humano Amparo Maternal", "Rua Loefgren, 101", "Vila Clementino", "Zona Sul", "Não informado", "04040-033"),
        PontoColeta(22, "Posto de Coleta de Leite Humano Chella e Moise Safra", "Rua Napoleão de Barros, 754", "Vila Clementino", "Zona Sul", "(11) 5576-4107", "04024-002"),
        PontoColeta(23, "Posto de Coleta de Leite Humano do Hospital Municipal Tide Setúbal", "Rua Dr. José Guilherme Eiras, 123", "São Miguel Paulista", "Zona Leste", "(11) 3394-8779", "08010-220"),
        PontoColeta(24, "Posto de Coleta de Leite Humano do Hospital do Coração (HCor)", "Rua Desembargador Eliseu Guilherme, 123", "Paraíso", "Zona Sul", "(11) 3053-6611", "04004-030"),
        PontoColeta(25, "Posto de Coleta de Leite Humano do Hospital Estadual de Francisco Morato", "Rodovia Manoel Silvério Pinto, 25", "Belém", "Grande São Paulo", "(11) 4489-9444", "07901-155"),
        PontoColeta(26, "Posto de Coleta de Leite Humano do Hospital Estadual de Vila Alpina", "Rua Francisco Falconi, 1501", "Vila Alpina", "Zona Leste", "(11) 2318-2100", "03227-000"),
        PontoColeta(27, "Posto de Coleta de Leite Humano do Hospital Geral de Guarulhos", "Alameda dos Lírios, 200", "CECAP", "Grande São Paulo", "(11) 3466-1369", "07190-912"),
        PontoColeta(28, "Posto de Coleta de Leite Humano do Hospital Maternidade Santa Maria", "Rua Leôncio de Carvalho, 233", "Paraíso", "Zona Sul", "Não informado", "04003-010"),
        PontoColeta(29, "Posto de Coleta do Hospital Maternidade Interlagos Waldemar Seyssel", "Rua Leonor Alvim, 211", "Cidade Dutra", "Zona Sul", "Não informado", "04802-190")
    )

    val roteiroChat: Map<String, MensagemChat> = mapOf(
        CHAVE_MENSAGEM_INICIAL to MensagemChat(
            id = 1,
            texto = "Oi! Que bom ter você por aqui. Eu sou a assistente do Lactare Acolhe e posso ajudar com dúvidas sobre amamentação e doação de leite humano. Como você está agora?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Estou amamentando", "amamentando"),
                OpcaoChat("Quero saber mais", "quero_saber_mais")
            )
        ),
        "amamentando" to MensagemChat(
            id = 2,
            texto = "Que fase especial. Amamentar tem alegrias e também desafios, e está tudo bem falar sobre isso. Sobre o que você quer conversar?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Como doar", "como_doar"),
                OpcaoChat("Onde posso doar?", "onde_doar", Rotas.PONTOS_COLETA),
                OpcaoChat("Tirar uma dúvida", "tirar_duvida")
            )
        ),
        "quero_saber_mais" to MensagemChat(
            id = 3,
            texto = "Fico feliz com o seu interesse. Cada frasco de leite doado ajuda a alimentar bebês internados que ainda não podem mamar no peito. Por onde começamos?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Como doar", "como_doar"),
                OpcaoChat("Onde posso doar?", "onde_doar", Rotas.PONTOS_COLETA),
                OpcaoChat("Tirar uma dúvida", "tirar_duvida")
            )
        ),
        "como_doar" to MensagemChat(
            id = 4,
            texto = "É mais simples do que parece: você faz um cadastro rápido em um banco de leite, recebe orientação sobre higiene e coleta, e a equipe combina a retirada em casa ou a entrega em um posto próximo. Quer ajuda para dar o primeiro passo?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Sim, por favor!", "agendar_sim", Rotas.PONTOS_COLETA),
                OpcaoChat("Agora não", "lembretes"),
                OpcaoChat("Tenho outra dúvida", "tirar_duvida")
            )
        ),
        "onde_doar" to MensagemChat(
            id = 5,
            texto = "Reuni os bancos de leite e postos de coleta de São Paulo em uma lista. Você pode filtrar pela sua região e ver endereço e telefone de cada um. Abri a lista para você.",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Voltar ao início", "inicio")
            )
        ),
        "agendar_sim" to MensagemChat(
            id = 6,
            texto = "Perfeito! Escolha na lista o ponto mais perto de você e ligue para combinar a primeira visita. A equipe vai te explicar tudo com calma, sem compromisso. Vamos continuar?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Continuar", "lembretes")
            )
        ),
        "tirar_duvida" to MensagemChat(
            id = 7,
            texto = "Pode perguntar à vontade. Qual assunto?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Exames", "duvida_exames"),
                OpcaoChat("Medicamento", "duvida_medicamento"),
                OpcaoChat("Voltar ao início", "inicio")
            )
        ),
        "duvida_exames" to MensagemChat(
            id = 8,
            texto = "Para doar, o banco de leite pede exames simples de sangue, geralmente os mesmos do pré-natal. Se você fez pré-natal, muitas vezes esses resultados já servem. A equipe confere tudo junto com você.",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Tenho outra dúvida", "tirar_duvida"),
                OpcaoChat("Voltar ao início", "inicio")
            )
        ),
        "duvida_medicamento" to MensagemChat(
            id = 9,
            texto = "A maioria dos medicamentos é compatível com a amamentação e com a doação. Alguns pedem atenção, então vale informar à equipe do banco de leite o que você usa. Eles orientam caso a caso.",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Onde posso doar?", "onde_doar", Rotas.PONTOS_COLETA),
                OpcaoChat("Voltar ao início", "inicio")
            )
        ),
        "lembretes" to MensagemChat(
            id = 10,
            texto = "Sem pressa. Você pode voltar aqui quando quiser. Quer que a gente deixe combinado de te lembrar sobre a doação daqui a alguns dias?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Sim, com certeza!", "despedida"),
                OpcaoChat("Agora não, obrigada", "despedida")
            )
        ),
        "despedida" to MensagemChat(
            id = 11,
            texto = "Combinado. Obrigada pelo carinho com os bebês que precisam e por cuidar de você também. Sempre que quiser conversar, é só voltar.",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Recomeçar", "inicio")
            )
        ),
        CHAVE_FALLBACK to MensagemChat(
            id = 12,
            texto = "Acho que me perdi na nossa conversa. Vamos recomeçar do início?",
            isUsuario = false,
            opcoes = listOf(
                OpcaoChat("Recomeçar", "inicio")
            )
        )
    )
}
