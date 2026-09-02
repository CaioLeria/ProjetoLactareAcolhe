# Lactare Acolhe

App Android (Jetpack Compose) do Challenge Sprint 3 — FIAP. MVP navegável com dados
100% mockados, implementado a partir de [`Lactare_Acolhe_Design_Spec.md`](Lactare_Acolhe_Design_Spec.md).

## Como abrir

1. Android Studio → *Open* → selecione esta pasta.
2. Aguarde o *Gradle sync* (AGP 8.8.0, Kotlin 2.1.0, Gradle 9.4.1, compileSdk 35, minSdk 24).
3. Run ▶ no emulador ou dispositivo.

Build por linha de comando:

```bash
./gradlew :app:assembleDebug
```

## Estrutura

```
app/src/main/java/br/com/fiap/lactareacolhe/
├── model/         PontoColeta, OpcaoChat, MensagemChat, PassoOnboarding
├── data/          MockData (pontos de coleta + roteiro do chat), Constants
├── repository/    LactareRepository
├── viewmodel/     ChatViewModel, PontosColetaViewModel
├── ui/theme/      Color, Type, Theme
├── ui/screens/    Apresentacao, Home, Chat, PontosColeta (stateful + Content)
├── ui/components/ BalaoMensagemChat, ChipFiltroRegiao, CardPontoColeta
├── navigation/    AppNavigation (Scaffold + BottomBar), Rotas
└── MainActivity
```

Arquitetura: `Compose UI → ViewModel → Repository → MockData`.

## Pendências (valores provisórios)

| Local | O que trocar |
| --- | --- |
| `data/Constants.kt` → `SITE_URL` | URL oficial da campanha Agosto Dourado |
| `data/Constants.kt` → `WHATSAPP_NUMERO` | Número real do projeto (só dígitos, `55` + DDD + número) |
| `ui/theme/Type.kt` | Tipografia da marca (hoje usa o padrão do Material 3) |
| Textos de `MockData.roteiroChat` | Revisão do tom de voz com a equipe |
