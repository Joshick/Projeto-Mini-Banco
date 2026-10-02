# MiniBanco

O MiniBanco é um sistema financeiro interativo em modo de consola, concebido para automatizar operações bancárias essenciais de forma segura. O principal objetivo da aplicação é garantir a integridade matemática das contas, resolvendo o problema de falhas no controlo manual de saldos e prevenindo transações indevidas. Desenvolvido como parte do projeto integrador do Senac, o sistema explora um modelo de negócio de rentabilidade direta e sem anúncios, cobrando e retendo de forma automática uma taxa de 2% sobre todas as operações de saque.

## 🚀 Funcionalidades
- Registo inicial com identificação do utilizador pelo nome.
- Processamento de depósitos com validação rigorosa para impedir a entrada de valores negativos ou nulos.
- Gestão de saques com sistema de segurança em três camadas: validação de valor positivo, verificação do limite máximo por transação (R$ 1000,00) e bloqueio por saldo insuficiente (contabilizando o valor do saque somado à taxa).
- Consulta de saldo atualizado em tempo real.
- Geração e impressão de extrato cronológico detalhado, demonstrando o histórico exato de cada movimentação e o impacto no saldo final.

## 🛠️ Tecnologias Utilizadas
- **Linguagem de Programação:** Java (Lógica estruturada com divisão de responsabilidades em métodos estáticos).
- **Entrada/Saída de Dados:** Classe `Scanner` (`java.util.Scanner`) para interação contínua no terminal.
- **Ferramentas de apoio:** IDE para compilação (ex: VS Code, Eclipse, IntelliJ) e Git/GitHub para o controlo de versões.

## 📁 Estrutura do Projeto
/
├── MiniBanco.java       # Código-fonte principal com as regras de negócio financeiras e menu de navegação
└── README.md            # Documentação, capa do projeto e guia estrutural

---
*Desenvolvido por José Hickelme Lopes*
