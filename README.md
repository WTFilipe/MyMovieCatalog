# My Movie Catalog

O aplicativo My Movie Catalog é um pequeno organizador de listas de filme. No My Movie Catalog você pode ver uma listagem de filmes populares na home do aplicativo, pode realizar uma busca por nome, adicionar um filme como favorito e como "já assistido"

Na tela inicial do aplicativo uma listagem de filmes populares de acordo com a API do "The Movie Database" (https://developer.themoviedb.org/docs). É possível clicar em um item da listagem para ver mais informações sobre o filme, marcar como "já assistido" ou marcar como favorito.

Na tela de busca é possível inserir o nome de um filme para realizar uma busca por título. Também é possível clicar em um item para ver mais detalhes

Na tela de favoritos irá aparecer uma listagem com os filmes que foram marcados como favoritos. Dentre esses, os que também estiverem marcados como "já assistido", terão um efeito de transparância para indicar, ainda na listagem, que já foi assistido. 
Também é possível clicar no item para ver mais informações

## Tecnologias utilizadas:
- Material Design 3- Componentes e tema da aplicação
- Hilt - Injeção de dependência
- Coil - Carregamento de imagens
- Arquitetura MVVM + Clean Architecture
- Jetpack Compose - Desenvolvimento da UI
- Navigation - Para navegação entre as telas
- Kotlin KTS - Gerenciamento de dependências
- Suporte ao "Modo Escuro"
- Modularização da aplicação em "app", "domain" e "data"

![image](https://github.com/WTFilipe/MyMovieCatalog/assets/32869667/b9586b95-380f-4530-be12-9bbd6c353795)
![image](https://github.com/WTFilipe/MyMovieCatalog/assets/32869667/0876c040-9cff-4a67-8765-ed67861ef256)
![image](https://github.com/WTFilipe/MyMovieCatalog/assets/32869667/3b7b6ed2-5e6e-4734-8821-54f5f1647da3)
![image](https://github.com/WTFilipe/MyMovieCatalog/assets/32869667/2d4295e8-223e-45af-a50f-12cee94e8297)



## Observações
- A aplicação foi pensada para usar os conceitos de temas dinâmicos do Material 3. Por conta disso, as cores do aplicativo podem ser diferentes das cores exibidas na captura de tela, pois serão baseadas na cor do papel de parede do dispositivo. Quaisquer que sejam as cores, a hierarquia de cores, visibilidade e contraste estão garantidos. Caso o projeto seja executado em um dispositivo que não ofereça suporte ao Material 3, um tema padrão (cores próximas ao vermelho) será apresentado

## Execução
O aplicativo já está pronto para a execução. Basta clonar o projeto e rodar no Android Studio

## Pontos de melhoria já mapeados
- Caso a listagem tenha apenas 2 items, a altura dos itens fica diferente (esse é o comportamento esperado do LazyVerticalStaggeredGrid, uma solução seria usar o LazyColumn nesse caso em particular)
- Feedbacks mais personalizados para cada tipo de erro (por exemplo, diferenciar o feedback de falta de conexão com a internet do feedback de timeout)
- Baixa cobertura de teste
