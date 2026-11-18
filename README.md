# Placar de futebol com Observer

## O projeto

Este sistema de console acompanha uma partida entre os times Azul e Verde. Pelo menu, o usuário registra gols, consulta o placar e vê o histórico da partida. A narração começa ligada e pode ser desligada a qualquer momento. Os dados ficam na memória até o programa ser encerrado.

## Por que usar Observer?

Cada gol interessa a dois componentes por motivos diferentes. O narrador exibe o resultado na hora e o histórico guarda o placar daquele momento para consulta posterior. O padrão **Observer** resolve essa relação de um para muitos e permite que cada componente comece ou pare de acompanhar a partida em tempo de execução.

No código, `Partida` é o objeto observado. Ao registrar um gol, ela atualiza o placar e chama `atualizar(placar)` em cada objeto inscrito pela interface `ObservadorPlacar`. Tanto `Narrador` quanto `Historico` implementam essa interface. Assim, a partida só precisa saber como comunicar a mudança. Cada observador decide o que fazer com ela.

Para ver isso na prática, registre um gol do Azul, desligue a narração e registre um gol do Verde. Só o primeiro gol será narrado. Ao abrir o histórico, você verá os dois resultados em ordem:

```text
Gol 1 | Azul 1 x 0 Verde
Gol 2 | Azul 1 x 1 Verde
```

**Outro padrão possível** seria o Command, caso o sistema precisasse desfazer um gol registrado por engano. O registro do gol poderia ser representado por um comando com operações para executar e desfazer. Para o requisito atual de avisar vários interessados sempre que o placar muda, Observer é a escolha mais direta. Os dois padrões poderiam coexistir se o projeto ganhasse essa nova função.


## Como executar

**No Eclipse**, selecione **File → Import → Maven → Existing Maven Projects**, escolha a pasta que contém o `pom.xml` e clique em **Finish**. Abra a classe `Main` e selecione **Run As → Java Application**.
