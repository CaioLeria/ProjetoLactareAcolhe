# Lactare Acolhe — Design Spec

**Data:** 2026-08-31
**Contexto:** Projeto Challenge Sprint 3 — Android Kotlin Developer (FIAP)
**Objetivo:** App Android do "Lactare Acolhe", focado em ser um MVP navegável e funcional, utilizando dados mockados para simular a conexão e apoio à doação de leite humano. Demonstra arquitetura organizada, navegação com BottomBar e interface de chatbot sem necessidade de integrações com APIs reais nesta fase.

---


## Requisitos

- 4 Telas principais: Onboarding de Apresentação, Home, Chat Interativo e Lista de Pontos de Coleta.
- Navegação fluida utilizando `Navigation Compose` acoplado a um `Scaffold` com `BottomBar`.
- Interface em **Português**, aderente ao tom de voz acolhedor e às cores do manual da marca Lactare — Azul Escuro `#0D3B66` e Azul Claro `#4FB0C6` (valores placeholder até confirmação do manual oficial da marca).
- Dados 100% mockados e realistas (sem *Lorem Ipsum*), centralizados em classes e listas estáticas.
- Uso de `Intent` para redirecionamento externo (abrir site e WhatsApp).
- Código simples, explícito e sem frameworks de injeção de dependência (sem Hilt/Koin).
- Toda tela e todo componente reutilizável deve ter função(ões) `@Preview` para visualização isolada no Android Studio, seguindo a divisão Stateful/Stateless.
- Proibição estrita do uso de imagens ou ícones de chupetas/mamadeiras.
- O código precisa ser claro quanto ao que faz, não adicionar comentários.
- seguir exemplo de código:  https://github.com/carreiras/to-do-list
- buscar dados para mock em: PontosColetaSP_MockData.kt
### Entity / Models

```kotlin
data class PontoColeta(val id: Int, val nome: String, val endereco: String, val telefone: String, val cep: String, val regiao: String)

data class MensagemChat(val id: Int, val texto: String, val isUsuario: Boolean, val opcoes: List<String> = emptyList())
```

---

## Arquitetura

Padrão **MVVM com Mock Repository**:

```text
Compose UI → ViewModel → Repository → Dados Estáticos (MockData)
```

Cada camada tem responsabilidade única e se comunica somente com a camada imediatamente adjacente, garantindo pontos na separação mínima de responsabilidades.

---

## Estrutura de Pacotes

```text
br.com.fiap.lactareacolhe/
├── model/
│   ├── PontoColeta.kt
│   └── MensagemChat.kt
├── data/
│   ├── MockData.kt
│   └── Constants.kt
├── repository/
│   └── LactareRepository.kt
├── viewmodel/
│   ├── ChatViewModel.kt
│   └── PontosColetaViewModel.kt
├── ui/
│   ├── theme/
│   │   ├── Color.kt
│   │   └── Theme.kt
│   ├── screens/
│   │   ├── ApresentacaoScreen.kt
│   │   ├── HomeScreen.kt
│   │   ├── ChatScreen.kt
│   │   └── PontosColetaScreen.kt
│   └── components/
│       ├── BalaoMensagemChat.kt
│       └── CardPontoColeta.kt
├── navigation/
│   └── AppNavigation.kt
└── MainActivity.kt
```

---

## Camada de Dados

### MockData.kt

- Objeto (Singleton) `object MockData`.
- `val pontosDeColeta: List<PontoColeta>` — Lista pré-preenchida com hospitais reais do projeto (ex: Hospital Ipiranga, Anália Franco).
- `val roteiroChat: Map<String, MensagemChat>` — chave é o texto exato da opção escolhida pela usuária (ex: "Estou amamentando", "Quero saber mais"), valor é a `MensagemChat` de resposta do bot correspondente.

### Constants.kt

- `object Constants` — centraliza valores usados nas Intents, evitando strings hardcoded espalhadas na UI.
- `const val SITE_URL: String` — URL da página oficial usada no banner "Agosto Dourado" (placeholder até definição final).
- `const val WHATSAPP_NUMERO: String` — número no formato esperado por `wa.me` (placeholder até definição final).

---

## Repository

### LactareRepository.kt

- Classe que concentra o acesso ao `MockData`.
- `fun getPontosColeta(): List<PontoColeta>` — Retorna a lista de pontos.
- `fun getRespostaBot(escolha: String): MensagemChat` — Busca direta em `roteiroChat` pela chave `escolha`; retorna uma `MensagemChat` de fallback (ex: "Não entendi, pode escolher uma opção?") se a chave não existir no Map.
- Camada intencionalmente fina para demonstrar boas práticas arquiteturais de isolamento de dados.

---

## ViewModel

lógicas sempre vivem na ViewModel, as Views são apenas camadas de apresentação
Sem framework de injeção de dependência, cada ViewModel instancia o repository diretamente como propriedade privada: `private val repository = LactareRepository()`.

### ChatViewModel.kt

- Estende `ViewModel()`.
- `historico: StateFlow<List<MensagemChat>>` — Controla o estado atual da conversa exibida na tela.
- `fun enviarMensagem(texto: String)` — Adiciona a fala da usuária ao `historico`, chama o `repository` e adiciona a resposta do bot (com um pequeno `delay` de coroutine simulando a digitação).

### PontosColetaViewModel.kt

- Estende `ViewModel()`.
- `pontosFiltrados: StateFlow<List<PontoColeta>>` — Reflete a lista atual de locais.
- `fun filtrarPorRegiao(regiao: String)` — Atualiza o `StateFlow` filtrando a lista original. Caso especial: `regiao == "Todos"` retorna a lista completa sem filtro; qualquer outro valor filtra por `it.regiao == regiao`.

---

## Navegação

### AppNavigation.kt

- `rememberNavController()` para controle de fluxo.
- `NavHost(startDestination = "apresentacao")` — ponto de entrada explícito do fluxo de navegação.
- Criação de um `Scaffold` onde a `bottomBar` exibe os ícones (Home, Chat, Locais).
- A exibição da `BottomBar` deve ser condicional (oculta na rota `"apresentacao"`).

**Rotas:**

- `"apresentacao"` → `ApresentacaoScreen`
- `"home"` → `HomeScreen`
- `"chat"` → `ChatScreen`
- `"pontos_coleta"` → `PontosColetaScreen`

---

## Convenção de Preview

`@Preview` não consegue instanciar ViewModels reais sem complexidade desnecessária. Por isso, toda tela que depende do ViewModel é dividida em duas funções `@Composable` no mesmo arquivo:

- **Versão stateful** (`XScreen`) — recebe o `viewModel` e `navController`, coleta o `StateFlow` e delega para a versão content. É a única chamada pela navegação. **Sem `@Preview`**.
- **Versão content** (`XContent`) — recebe apenas dados simples (`List`, `String`) e lambdas (callbacks). É essa versão que leva a(s) função(ões) `@Preview`.

Componentes reutilizáveis sem dependência de ViewModel (ex: `BalaoMensagemChat`) já são *previewable* diretamente.

Padrão de anotação:

```kotlin
@Preview(showBackground = true, name = "Nome descritivo do estado")
@Composable
private fun NomeContentPreview() {
    NomeContent(/* dados de exemplo */)
}
```

---

## Telas

### ApresentacaoScreen (Onboarding)

- **Não utiliza a BottomBar**.
- `ApresentacaoScreen` (stateful): recebe o `navController`.
- `ApresentacaoContent` (previewable): recebe callback `onFinalizar`.
- Componente principal: `HorizontalPager` (ou similar) com 3 passos explicativos sobre a missão do Lactare Acolhe.
- Botão "Começar" na última página dispara o `navController.navigate("home") { popUpTo("apresentacao") { inclusive = true } }`.

### HomeScreen

- `HomeScreen` (stateful): recebe `navController` e o `Context` local (para disparar as *Intents*).
- `HomeContent` (previewable): recebe callbacks `onAbrirNoticia`, `onAbrirWhatsApp`, `onAbrirChat`.
- Banner (Card) "Agosto Dourado": ao clicar, dispara uma `Intent.ACTION_VIEW` para `Constants.SITE_URL`.
- Call to Action ("Gostaria de conhecer..."): Botão do WhatsApp (dispara Intent para url `wa.me/Constants.WHATSAPP_NUMERO`) e botão para Chat interno (dispara rota `"chat"`).

### ChatScreen

- `ChatScreen` (stateful): coleta o histórico do `ChatViewModel` via `collectAsStateWithLifecycle()`.
- `ChatContent` (previewable): recebe `historico: List<MensagemChat>` e callback `onMensagemEnviada`.
- `LazyColumn` para o fluxo do chat.
- Mensagens renderizadas alinhadas à direita (Usuária) ou à esquerda (Bot).
- Se a mensagem do bot oferecer opções, exibe botões clicáveis abaixo da bolha de fala.
- Opção "Onde posso doar?" dispara um callback que faz `navController.navigate("pontos_coleta")`.

### PontosColetaScreen

- `PontosColetaScreen` (stateful): coleta `viewModel.pontosFiltrados`.
- `PontosColetaContent` (previewable): recebe `pontos: List<PontoColeta>` e callback `onFiltroSelecionado(String)`.
- Topo: `LazyRow` contendo opções de filtro (ex: "Todos", "Ipiranga", "Zona Leste").
- Corpo: `LazyColumn` renderizando os cartões de cada hospital (nome, endereço, CEP, telefone).

---

## Dependências a Adicionar

| Dependência | Motivo |
| --- | --- |
| `navigation-compose` | NavHost, NavController e suporte a rotas |
| `material3` | Componentes de UI (Scaffold, BottomAppBar, Cards, TextFields) |
| `material-icons-extended` | Ícones para a BottomBar — Chat e Map não existem no pacote core; mantida por simplicidade apesar do custo extra de tamanho no APK |
| `lifecycle-viewmodel-compose` | Chamada segura de `viewModel()` em Composables |
| `lifecycle-runtime-compose` | Suporte a `collectAsStateWithLifecycle()` |

---

## Conceitos Demonstrados (Avaliação Sprint 3)

- **Organização Arquitetural:** Separação clara entre UI, ViewModel e Dados (Mock).
- **Navigation Compose Avançado:** Gerenciamento de rotas integradas a um `Scaffold` com barra inferior e manipulação de `Backstack` (`popUpTo`).
- **Gestão de Estado Reativa:** Uso de `StateFlow` e atualização dinâmica da UI (Filtros instantâneos e fluxo de chat).
- **Componentização e Previews:** Separação rígida de componentes visuais *Stateless* para testes isolados no Android Studio.
- **Interação Nativa:** Uso de Intents nativas do Android para estender funcionalidades do MVP conectando a ecossistemas reais (Browser e WhatsApp).
