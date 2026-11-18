# Mural de atividades da turma

O mural é um sistema em Java que permite ao professor inscrever alunos, publicar atividades e lançar notas individuais. Pelo Console do Eclipse, é possível consultar as pendências e o histórico de notas de cada aluno. Os dados ficam em memória enquanto o programa está aberto.

## Por que escolhemos o Observer?

Quando o professor publica uma atividade, ela precisa aparecer nas pendências de todos os alunos inscritos. Se ele excluir a atividade, cada aluno precisa removê-la das pendências e apagar a nota correspondente, caso já tenha sido avaliado. O **Observer** é adequado porque uma ação do professor pode provocar mudanças em vários alunos, e o grupo de inscritos pode mudar durante a execução.

No código, `Professor` é o objeto observado e `Aluno` implementa a interface `Observador`. O professor envia um evento e cada aluno atualiza seus próprios dados no método `update()`. Assim, o professor pode publicar uma atividade sem precisar saber como cada aluno guarda suas pendências. No lançamento de uma nota, somente o aluno avaliado recebe o evento, registra a nota e retira a atividade das pendências.

## Outro padrão poderia ser usado?

Sim. O **Command** poderia representar cada ação do menu como um objeto, por exemplo, um comando para publicar uma atividade e outro para excluí-la. Isso ajudaria a organizar a execução dessas ações. Para o objetivo principal do mural, o **Observer** é mais adequado porque permite notificar os alunos inscritos assim que a atividade muda.

## Como executar no Eclipse

Com o JDK 17 configurado, importe a pasta que contém o `pom.xml` em **File → Import → Maven → Existing Maven Projects**. Em seguida, clique com o botão direito em `Main.java` e selecione **Run As → Java Application**. O menu aparece na aba **Console**.
