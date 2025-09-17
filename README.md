# ICEVOS - Trabalho P1

## 📚 Disciplina
Algoritmo e Estrutura de Dados I  

## 👨‍🏫 Professor
Dimmy Magalhães  

## 👨‍🎓 Integrante
- Ian Rodrigues Jucá — Matrícula: *[insira aqui sua matrícula]*  

## 🔗 Repositório
[GitHub - ICEVOS-TrabalhoP1](https://github.com/ianjuca/ICEVOS-TrabalhoP1)

---

## 📌 Descrição do Projeto
Este projeto implementa um **escalonador de processos** que simula a execução de tarefas em um ambiente computacional.  
A lógica foi construída em **Java**, utilizando estruturas de dados personalizadas para representar filas de processos com diferentes prioridades.  

### Estruturas principais:
- **`Processo`**: Representa um processo, contendo atributos como prioridade e tempo de execução.  
- **`ListaDeProcessos` e `Node`**: Implementam uma lista encadeada para armazenar e gerenciar os processos.  
- **`Scheduler`**: Responsável pelo escalonamento, aplicando regras de prioridade, anti-inanição e bloqueio de processos que precisam de recursos (ex.: DISCO).  
- **`Leitor`**: Lê arquivos `.txt` de entrada contendo a lista de processos a serem executados.  
- **`Main`**: Classe principal que inicializa o sistema, carrega os processos e executa o escalonador.  

O projeto foi desenvolvido para demonstrar conceitos de **filas de prioridade, escalonamento justo, prevenção de inanição e gerenciamento de bloqueio** em sistemas operacionais.

---

## ⚙️ Instruções de Compilação e Execução

### 🔽 1. Clonar o repositório
Abra o **Git Bash** e execute:
```bash
git clone https://github.com/ianjuca/ICEVOS-TrabalhoP1.git
cd ICEVOS-TrabalhoP1
📂 2. Estrutura do projeto
ICEVOS-TrabalhoP1/
 ├─ src/
 │   ├─ Main.java
 │   ├─ Componentes/
 │   │   ├─ Processo.java
 │   │   └─ Scheduler.java
 │   ├─ Estruturas/
 │   │   ├─ ListaDeProcessos.java
 │   │   └─ Node.java
 │   └─ LeitorTXT/
 │       └─ Leitor.java
 └─ bin/   (será gerada após compilação)

🏗️ 3. Compilar

Ainda no Git Bash, execute o comando abaixo para compilar todas as classes para a pasta bin:

javac -d bin src/Main.java src/Componentes/Processo.java src/Componentes/Scheduler.java src/Estruturas/ListaDeProcessos.java src/Estruturas/Node.java src/LeitorTXT/Leitor.java


Após esse comando, a pasta bin/ será criada com os arquivos .class.

▶️ 4. Executar

Para rodar o programa (classe principal Main):

java -cp bin Main

🚀 Funcionalidades

Escalonamento com três níveis de prioridade (alta, média e baixa).

Anti-inanição: garante que processos de baixa prioridade eventualmente sejam executados.

Bloqueio de processos: processos que requerem acesso ao DISCO entram em lista de bloqueados até a liberação do recurso.

Leitura dinâmica de entrada a partir de arquivos .txt.

📖 Observação

Certifique-se de ter o Java JDK 8+ instalado e configurado no PATH antes de compilar.

Use o Git Bash ou outro terminal compatível para executar os comandos.


