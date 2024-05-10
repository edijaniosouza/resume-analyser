package com.barrosedijanio.avaliadordecurriculo.ia

import com.google.ai.client.generativeai.type.content

val inputHistory = content("user") {
    text("Você é um recrutador que avalia curriculos e responde pontos fortes, pontos a melhorar, sugestoes e conclusão em um Json. Você sempre receberá um curriculo totalmente novo")
    text("IMPORTANTE: SEMPRE ao responder o JSON dentro da string sempre acrescente barra invertida '\\' ou utilize aspas simples para não dar problemas de conversão. Siga EXATAMEMTE os exemplos")
    text("IMPORTANTE: O JSON não deve haver problemas para converte-lo com a biblioteca Gson com kotlin")
    text("EXEMPLO 1")
    text("--user--")
    text("vaga desejada: desenvolvimento Android")
    text("nivel de experiencia: Junior")
    text("---Curriculo abaixo---")
    text(
        "EDJANIO DE SOUZA BARROS\n" +
                "Telefone: (11) 93468-5043\n" +
                "E-mail: edijanio.dev@gmail.com\n" +
                "LinkedIn: Edjanio Barros\n" +
                "                                                                                                    Github: github.com/edijaniosouza\n" +
                "                                                                                                    São Paulo - SP\n" +
                "                                                                                                    OBJETIVO\n" +
                "                                                                                                    Desenvolvedor Mobile Júnior\n" +
                "                                                                                                    HISTÓRICO EDUCACIONAL\n" +
                "                                                                                                    Análise e desenvolvimento de Sistemas | Concluído em 2021\n" +
                "                                                                                                    Universidade Nove de Julho\n" +
                "                                                                                                    HISTÓRICO PROFISSIONAL\n" +
                "                                                                                                    Desenvolvedor Android - Voluntário\n" +
                "                                                                                                    Routinely\n" +
                "                                                                                                    Abril de 2024 – até o momento\n" +
                "                                                                                                    ● Desenvolvimento em Android com Kotlin e Jetpack compose.\n" +
                "                                                                                                    ● Ktor (Api Rest), Koin, Room\n" +
                "                                                                                                    ● Git, Github\n" +
                "                                                                                                    ● Modelo Ágil\n" +
                "                                                                                                    Analista de Desenvolvimento de Sistemas\n" +
                "                                                                                                    G+D EPayments\n" +
                "                                                                                                    Dezembro de 2021 – Fevereiro de 2024\n" +
                "                                                                                                    ● Desenvolvimento de chip para cartões bancários e prestação de consultoria técnica.\n" +
                "                                                                                                    ● Condução de projetos de cartões bancários EMV, desde a aquisição de novos clientes até o\n" +
                "                                                                                                    lançamento de novos produtos, envolvendo a identificação de requisitos, elaboração de\n" +
                "                                                                                                    documentação e análise para desenvolvimento do perfil elétrico (chip).\n" +
                "                                                                                                    ● Responsável direto pela comunicação contínua entre os clientes e a equipe de\n" +
                "                                                                                                    desenvolvimento, garantindo alinhamento estratégico e atendimento preciso às\n" +
                "                                                                                                    necessidades do cliente.\n" +
                "                                                                                                    Estagiário de Desenvolvimento\n" +
                "                                                                                                    G+D EPayments\n" +
                "                                                                                                    Dezembro de 2019 – dezembro de 2021\n" +
                "                                                                                                    ● Responsável pelo desenvolvimento de soluções completas de cartões bancários e\n" +
                "                                                                                                    SIMCards, desempenhando um papel fundamental na concepção, implementação e\n" +
                "                                                                                                    aprimoramento contínuo desses produtos.\n" +
                "                                                                                                    ● Aplicação de conhecimentos em Full-Stack (PHP, Javascript, React, C#) para criar e\n" +
                "                                                                                                    aperfeiçoar sistemas inovadores e eficazes no setor financeiro e de telecomunicações.\n" +
                "                                                                                                    ● Colaboração ativa em equipes multidisciplinares para garantir a integração perfeita\n" +
                "                                                                                                    entre o software e o hardware, otimizando a funcionalidade dos cartões e SIMCards.\n" +
                "                                                                                                    HABILIDADES TÉCNICAS\n" +
                "                                                                                                    ● Kotlin - Intermediário\n" +
                "                                                                                                    ● Java - básico\n" +
                "                                                                                                    ● Javascript / Typescript -\n" +
                "                                                                                                    Intermediário\n" +
                "                                                                                                    ● Android - Activity / Fragment /\n" +
                "                                                                                                    Jetpack compose - Intermediário\n" +
                "                                                                                                    ● React native (CLI / Expo) - básico\n" +
                "                                                                                                    ● Testes: Junit / Mockito - básico\n" +
                "                                                                                                    ● Git / Github - intermediário\n" +
                "                                                                                                    ● MySql / Room / SQLite / Firebase /\n" +
                "                                                                                                    Supabase - Intermediário\n" +
                "                                                                                                    ● Microsoft Office - Intermediário\n" +
                "                                                                                                    IDIOMAS\n" +
                "                                                                                                    ● Inglês Intermediário ● Espanhol básico\n" +
                "                                                                                                    CERTIFICAÇÕES E ATIVIDADES COMPLEMENTARES\n" +
                "                                                                                                    ● Cursos:\n" +
                "                                                                                                    o The Complete Android 10 & Kotlin Development Masterclass - Concluído.\n" +
                "                                                                                                    o Santander Bootcamp | Mobile Developer (Kotlin) - Concluído.\n" +
                "                                                                                                    o Android com Kotlin: Migrations e relacionamento com o Room\n" +
                "                                                                                                    o Architecture Components: ViewModel, LiveData e Room - Alura\n" +
                "                                                                                                    o Jetpack Compose: criando um app android\n" +
                "                                                                                                    o Jetpack Compose: utilizando Lazy Layout e estados"
    )
}
val outputHistory = content("model") {
    text("{")
    text(
        "\"pontos fortes\":" +
                "[\n\t\t\"" +
                "Objetivo profissional claramente definido\",\n\t\t\"" + "Qualidades pessoais relevantes, como comunicação, aprendizado rápido e trabalho em equipe\",\n\t\t\"Apresentação pessoal concisa e informativa\"\n\t],\n\t\"pontos a melhorar\": [\n\t\t\"Destaque suas conquistas: Inclua exemplos específicos de suas realizações e use números para demonstrar o impacto de seu trabalho.\",\n\t\t\"Use palavras-chave relevantes: Incorpore palavras-chave relacionadas à indústria para facilitar aos recrutadores a encontrar seu currículo em sistemas de rastreamento de candidatos (ATS).\",\n\t\t\"Revise a seção de histórico educacional: Forneça mais detalhes sobre sua formação educacional, como o nome completo da instituição e as datas de frequência.\",\n\t\t\"Adicione uma seção de habilidades: Liste suas habilidades técnicas e interpessoais relevantes para o cargo de atendente.\",\n\t\t\"Use um design profissional: Escolha um modelo de currículo profissional que seja fácil de ler e navegar.\"\n\t],\n\t\"sugestoes\": [\n\t\t\"Inclua uma seção 'Experiência Profissional' se você tiver qualquer experiência de trabalho relevante, mesmo que não seja no setor de varejo.\",\n\t\t\"Quantifique seus resultados, por exemplo, 'Aumentou as vendas em 10% fornecendo atendimento excepcional ao cliente'.\",\n\t\t\"Use palavras-chave como 'Atendimento ao Cliente', 'Comunicação Efetiva', 'Trabalho em Equipe' e 'Gestão de Conflitos'.\",\n\t\t\"Escolha um modelo de currículo clássico com seções claras para experiência, habilidades e educação.\"\n\t],\n\t\"conclusao\": [\n\t\t\"Seu currículo é um bom começo para se candidatar a cargos de balconista júnior. No entanto, há algumas áreas que podem ser melhoradas para torná-lo mais competitivo. Ao implementar as recomendações acima, você pode criar um currículo que destaque suas habilidades e experiência e aumente suas chances de conseguir uma entrevista.\nLembre-se de adaptar seu currículo a cada vaga específica a que você se candidatar, destacando as habilidades e experiências mais relevantes para o cargo. " +
                "Boa sorte em sua busca de emprego!\"\n\t]"
    )
    text("}")
}

val input2 = content ("user"){
    text("EXEMPLO 2")
    text("--user--")
    text("vaga desejada: Psicologa")
    text("nivel de experiencia: pleno")
    text("---Curriculo abaixo---")
    text(
        "AMANDA DOS SANTOS THEODORO \n" +
                "                                                                                                    São Paulo - SP      \n" +
                "                                                                                                    Telefones: (11) 93040-7568                         26 anos \n" +
                "                                                                                                    E-mail: psi_amandatheodoro@hotmail.com \n" +
                "                                                                                                     \n" +
                "                                                                                                    Objetivo: Psicologia Clínica e Desenvolvimento Humano Organizacional \n" +
                "                                                                                                     \n" +
                "                                                                                                    Qualificação  \n" +
                "                                                                                                    Psicóloga – CRP: 06-167259 cadastro e-Psi 258782 \n" +
                "                                                                                                    Experiência em relacionamento com o cliente, avaliação de contatos com o cliente e aplicação \n" +
                "                                                                                                    de treinamentos relacionados a produto, processo e comportamento. Conhecimento \n" +
                "                                                                                                    intermediário dos programas Word, Excel, PowerPoint. \n" +
                "                                                                                                    Em relação a psicologia experiência com estágios obrigatórios da faculdade e atuação com \n" +
                "                                                                                                    atendimentos em psicoterapia online. Experiência com demandas de ansiedade, depressão. \n" +
                "                                                                                                    luto, timidez, problemas de relacionamentos e autoconhecimento. \n" +
                "                                                                                                     \n" +
                "                                                                                                    Formação Acadêmica \n" +
                "                                                                                                    Ensino Superior – Pós-graduação \n" +
                "                                                                                                    Curso – Terapia Cognitivo Comportamental \n" +
                "                                                                                                    Período – fev-2021 a out-2022 \n" +
                "                                                                                                    Instituição – PUC RS – Pontifícia Universidade Católica \n" +
                "                                                                                                      \n" +
                "                                                                                                    Experiência profissional \n" +
                "                                                                                                     \n" +
                "                                                                                                    Empresa: SABER - Instituto Brasileiro de Aprendizagem 08-2022 – até o momento \n" +
                "                                                                                                    Cargo: Analista Educacional Jr \n" +
                "                                                                                                    Acompanhamento do desenvolvimento de jovens aprendizes com a realização de orientações, \n" +
                "                                                                                                    acolhimento, atendimento institucional e verificação de assiduidade. \n" +
                "                                                                                                    Apoio aos instrutores com reforço de orientações comportamentais aos jovens e atendimento \n" +
                "                                                                                                    as empresas parceiras para orientações gerais sobre o programa e acompanhamento \n" +
                "                                                                                                    simultâneo dos aprendizes \n" +
                "                                                                                                     \n" +
                "                                                                                                    Atendimento clínico – Psicoterapia \n" +
                "                                                                                                    Psicóloga: 03-2021 – até o momento \n" +
                "                                                                                                    Experiência com demandas de luto, ansiedade, depressão, timidez, problemas de \n" +
                "                                                                                                    relacionamentos, autoconhecimento, entre outros. \n" +
                "                                                                                                     \n" +
                "                                                                                                    Empresa: Concentrix - set-2016 a abr-2020 \n" +
                "                                                                                                    Cargos:  Agente de atendimento set-2016 - jun-2017 \n" +
                "                                                                                                          Analista de qualidade jul-2017 - dez-2017 \n" +
                "                                                                                                         Analista de qualidade e treinamento jan-2019 - abr-2020  \n" +
                "                                                                                                    Experiência com atendimento ao cliente com foco em retenção. \n" +
                "                                                                                                    Relacionamento com a empresa parceira. \n" +
                "                                                                                                    Avaliação de atendimento. \n" +
                "                                                                                                    Levantamento de necessidades de treinamento. \n" +
                "                                                                                                    Aplicação de treinamento. \n" +
                "                                                                                                     \n" +
                "                                                                                                     \n" +
                "                                                                                                    Idiomas \n" +
                "                                                                                                    Inglês Básico \n" +
                "                                                                                                     \n" +
                "                                                                                                    Habilidades \n" +
                "                                                                                                    Pacote Office intermediário "
    )
}

val output2 = content("model") {
    text("{")
    text("\"pontos fortes\" :")
    text("[\"Objetivo profissional claramente definido\",\n" +
            "\"Experiência relevante em atendimento ao cliente\",\n" +
            "\"Habilidades interpessoais e de comunicação bem desenvolvidas\",\n" +
            "\"Conhecimento de psicologia clínica e desenvolvimento humano organizacional\"]")
    text("\"pontos a melhorar\":")
    text("[ \"Destaque suas habilidades técnicas: Embora você mencione o conhecimento intermediário do pacote Office, seria benéfico incluir outras habilidades técnicas relevantes para o cargo de desenvolvedor Android, como conhecimento de linguagens de programação, ferramentas de desenvolvimento e metodologias ágeis.\",\n" +
            " \"Quantifique suas realizações: Forneça exemplos específicos e quantificáveis de suas realizações em cargos anteriores, como o número de clientes atendidos, projetos concluídos ou melhorias implementadas.\",\n" +
            " \"Use palavras-chave relevantes: Incorpore palavras-chave relacionadas à indústria de desenvolvimento Android para facilitar aos recrutadores a encontrar seu currículo em sistemas de rastreamento de candidatos (ATS).\",\n" +
            " \"Revise a seção de formação acadêmica: Forneça mais detalhes sobre sua formação acadêmica, como o nome completo da instituição e as datas de frequência.\",\n" +
            " \"Adicione uma seção de projetos: Se você tiver algum projeto pessoal ou contribuições para projetos de código aberto relacionados ao desenvolvimento Android, inclua uma seção para destacá-los.\"]")
    text("\"susgestoes\":")
    text("[ \"Inclua uma seção \\\"Habilidades Técnicas\\\": Liste suas habilidades técnicas relevantes para o desenvolvimento Android, como Java, Kotlin, Android Studio e Git.\",\n" +
            " \"Quantifique suas realizações: Por exemplo, \\\"Atendido mais de 1.000 clientes por mês, resultando em uma taxa de satisfação de 95%\\\".\",\n" +
            " \"Use palavras-chave como: \\\"Desenvolvimento Android\\\", \\\"Java\\\", \\\"Kotlin\\\", \\\"Android Studio\\\", \\\"Git\\\", \\\"Metodologias Ágeis\\\".\",\n" +
            " \"Escolha um modelo de currículo profissional: Escolha um modelo de currículo clássico com seções claras para experiência, habilidades e educação.\"]")
    text("\"conclusao\":")
    text("[\"Seu currículo é um bom começo para se candidatar a cargos de desenvolvedor Android júnior. No entanto, há algumas áreas que podem ser melhoradas para torná-lo mais competitivo. Ao implementar as recomendações acima, você pode criar um currículo que destaque suas habilidades e experiência e aumente suas chances de conseguir uma entrevista.\",\n]")
    text("}")
}
