# 📝 To-Do Notes - Aplicação de Gerenciamento de Tarefas

Uma aplicação de **To-Do List** desenvolvida em **JavaFX** com **Maven**, seguindo as melhores práticas de **Programação Orientada a Objetos (OOP)** e princípios **SOLID**.

---

## 📋 Sumário

- [🎯 Visão Geral](#visão-geral)
- [🏗️ Arquitetura](#arquitetura)
- [📦 Estrutura do Projeto](#estrutura-do-projeto)
- [🔧 Requisitos](#requisitos)
- [⚙️ Instalação](#instalação)
- [🚀 Como Executar](#como-executar)
- [📚 Guia de Uso](#guia-de-uso)
- [🎓 Padrões de Design](#padrões-de-design)
- [🔄 Fluxo de Dados](#fluxo-de-dados)
- [✨ Funcionalidades](#funcionalidades)
- [❓ Troubleshooting](#troubleshooting)
- [📖 Documentação Adicional](#documentação-adicional)

---

## 🎯 Visão Geral

**To-Do Notes** é uma aplicação de gerenciamento de tarefas intuitiva e responsiva que permite os usuários:

- ✅ **Criar** novas tarefas
- ☑️ **Marcar** tarefas como concluídas (com efeito visual de riscado)
- ❌ **Remover** tarefas individualmente
- 👁️ **Visualizar** todas as tarefas em uma interface limpa

### Características Principais

| Feature | Descrição |
|---------|-----------|
| **Interface Moderna** | Design limpo com cores harmônicas |
| **Responsividade** | Layout adaptável com ScrollPane |
| **Componentes Reutilizáveis** | TaskItem encapsulado e bem documentado |
| **Arquitetura Limpa** | Separação clara entre UI, Lógica e Model |
| **Código Documentado** | JavaDoc completo em todas as classes |

---

## 🏗️ Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)** com separação clara de responsabilidades:

```
┌─────────────────────────────────────────────────────┐
│                   Aplicação (App.java)              │
│         - Inicializa o Stage (janela)               │
│         - Orquestra AppView e TaskController        │
└─────────────────────┬───────────────────────────────┘
                      │
        ┌─────────────┴─────────────┐
        ▼                           ▼
   ┌─────────────┐          ┌──────────────┐
   │  AppView    │          │ TaskController│
   │  (View)     │◄────────►│   (Controller)│
   └─────────────┘          └──────┬───────┘
        │                          │
        ├─ TaskItem               │
        │  (Componentes)          │
        │                         ▼
        │                    ┌──────────┐
        └───────────────────►│  Task    │
                             │  (Model) │
                             └──────────┘
```

### Camadas

#### 🎨 **Camada de Apresentação (View)**
- **AppView.java** - Responsável pela construção da UI
- **TaskItem.java** - Componente reutilizável para cada tarefa
- **style.css** - Estilos e temas visuais

#### 🧠 **Camada de Lógica (Controller)**
- **TaskController.java** - Gerencia operações com tarefas
- Método `addTask(description)` - Cria nova tarefa
- Método `removeTask(task)` - Remove tarefa
- Método `getTasks()` - Recupera todas as tarefas

#### 💾 **Camada de Dados (Model)**
- **Task.java** - Representa uma tarefa individual
- Propriedades: `id`, `description`, `completed`

---

## 📦 Estrutura do Projeto

```
notion/
├── pom.xml                          # Configurações Maven e dependências
├── README.md                        # Este arquivo
├── src/
│   ├── main/
│   │   ├── java/com/notion/
│   │   │   ├── App.java             # Classe principal da aplicação
│   │   │   ├── Main.java            # Ponto de entrada
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java      # Lógica de negócio
│   │   │   ├── model/
│   │   │   │   └── Task.java                # Entidade de tarefa
│   │   │   ├── view/
│   │   │   │   └── AppView.java             # Construção da UI
│   │   │   └── components/
│   │   │       └── TaskItem.java            # Componente visual de tarefa
│   │   └── resources/
│   │       └── style.css            # Estilos CSS da aplicação
│   └── test/
│       └── java/                    # Testes unitários (opcional)
└── target/                          # Diretório compilado (Maven)
    ├── classes/                     # Classes compiladas
    └── generated-sources/           # Fontes geradas
```

### Descrição de Cada Arquivo

| Arquivo | Responsabilidade | Linhas |
|---------|------------------|--------|
| `App.java` | Inicializa aplicação, configura Stage | 41 |
| `Main.java` | Ponto de entrada (launch JavaFX) | 6 |
| `AppView.java` | Constrói interface visual completa | ~150 |
| `TaskItem.java` | Componente HBox para cada tarefa | ~180 |
| `TaskController.java` | Gerencia lista de tarefas | ~30 |
| `Task.java` | Modelo de dados de tarefa | ~40 |
| `style.css` | Estilos visuais da aplicação | ~130 |

---

## 🔧 Requisitos

### Sistema Operacional
- ✅ Windows 10+
- ✅ macOS 10.15+
- ✅ Linux (Ubuntu 20.04+)

### Software Necessário

| Componente | Versão | Link |
|-----------|--------|------|
| **Java JDK** | 25+ | [Download](https://www.oracle.com/java/technologies/downloads/) |
| **Maven** | 3.8.0+ | [Download](https://maven.apache.org/download.cgi) |
| **JavaFX SDK** | 25+ | [Download](https://gluonhq.com/products/javafx/) |

### Dependências Maven

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>25</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>25</version>
    </dependency>
</dependencies>
```

---

## ⚙️ Instalação

### 1. Clonar o Repositório (ou copiar os arquivos)

```bash
cd ~/Documents
git clone https://github.com/Miguelhttp/to-do-notes.git
# ou extraia o arquivo ZIP fornecido
```

### 2. Navegar para o Diretório do Projeto

```bash
cd to-do-notes
# ou
cd notion
```

### 3. Verificar Instalação do Java

```bash
java -version
javac -version
```

**Saída esperada:**
```
openjdk version "25" 2024-09-17
...
```

### 4. Verificar Instalação do Maven

```bash
mvn -version
```

**Saída esperada:**
```
Apache Maven 3.9.x
Java version: 25
...
```

### 5. Compilar o Projeto

```bash
mvn clean compile
```

Este comando:
- 🧹 Remove compilações anteriores (`clean`)
- 🔨 Compila o código-fonte (`compile`)
- ✅ Deve terminar com: `BUILD SUCCESS`

---

## 🚀 Como Executar

### Opção 1: Via Maven (Recomendado)

```bash
mvn javafx:run
```

A aplicação abrirá em uma janela nova.

### Opção 2: Via IDE (IntelliJ IDEA)

1. Abra o projeto em **IntelliJ IDEA**
2. Clique com botão direito em `App.java`
3. Selecione **Run 'App.main()'**
4. A aplicação será executada

### Opção 3: Via IDE (Eclipse)

1. Importe o projeto em **Eclipse** > **Import** > **Existing Maven Projects**
2. Clique com botão direito no projeto
3. **Run As** > **Java Application**
4. Selecione `App`

### Opção 4: Via Linha de Comando (JAR)

```bash
# Compilar para JAR
mvn clean package

# Executar JAR
java -jar target/notion-1.0-SNAPSHOT.jar
```

---

## 📚 Guia de Uso

### Interface da Aplicação

```
┌──────────────────────────────────────────┐
│           To-Do Notes                    │
├──────────────────────────────────────────┤
│                                          │
│  ┌────────────────────────────────────┐  │
│  │ Enter a new task...                │  │ ← Campo de entrada
│  └────────────────────────────────────┘  │
│                                          │
│  ┌──────────────────────────────────┐    │
│  │         Add Task                 │    │ ← Botão adicionar
│  └──────────────────────────────────┘    │
│                                          │
│  ┌────────────────────────────────────┐  │
│  │ ☑️ Estudar JavaFX                 ✕  │
│  ├────────────────────────────────────┤  │
│  │ ☐ Fazer projeto                   ✕  │ ← ScrollPane
│  ├────────────────────────────────────┤  │ com tarefas
│  │ ☑ Revisar código                  ✕  │
│  ├────────────────────────────────────┤  │
│  │ ☐ Escrever testes                 ✕  │
│  └────────────────────────────────────┘  │
│                                          │
└──────────────────────────────────────────┘
```

### Passo a Passo

#### 1️⃣ Adicionar uma Tarefa

```
1. Digite a descrição no campo: "Estudar JavaFX"
2. Clique em "Add Task" ou pressione Enter
3. A tarefa aparece na lista
```

#### 2️⃣ Marcar como Concluída

```
1. Clique no checkbox (☐) ao lado da tarefa
2. A tarefa fica riscada e acinzentada
3. Clique novamente para desmarcar
```

#### 3️⃣ Remover uma Tarefa

```
1. Clique no botão "✕" ao lado da tarefa
2. A tarefa é removida imediatamente
```

### Recursos Adicionais

- 🎨 **Cores Inteligentes**: Tarefas concluídas ficam cinzas (#999999)
- 📱 **ScrollPane**: Suporta muitas tarefas com scroll
- ⌨️ **Keyboard**: Digite e pressione Enter para adicionar

---

## 🎓 Padrões de Design

### 1. **MVC (Model-View-Controller)**

```java
// Model: Dados
Task task = new Task(1, "Estudar", false);

// Controller: Lógica
TaskController controller = new TaskController();
controller.addTask("Novo projeto");

// View: Apresentação
AppView view = new AppView(controller);
Scene scene = view.createScene();
```

### 2. **Single Responsibility Principle (SRP)**

Cada classe tem **uma única responsabilidade**:

```
✅ App.java          → Inicializa aplicação
✅ AppView.java      → Constrói UI
✅ TaskItem.java     → Renderiza tarefa individual
✅ TaskController.java → Gerencia tarefas
✅ Task.java         → Representa tarefa
```

### 3. **Separation of Concerns (SoC)**

Camadas separadas e independentes:

```
┌─────────────────────────────────────┐
│ Presentation Layer (AppView, CSS)   │ ← UI
├─────────────────────────────────────┤
│ Controller Layer (TaskController)   │ ← Lógica
├─────────────────────────────────────┤
│ Model Layer (Task)                  │ ← Dados
└─────────────────────────────────────┘
```

### 4. **Dependency Injection**

Dependências injetadas nos construtores:

```java
// TaskItem recebe suas dependências
TaskItem taskItem = new TaskItem(
    task,              // Tarefa
    controller,        // Controller
    this::renderTasks  // Callback
);
```

### 5. **Component Composition**

TaskItem é composto por componentes menores:

```java
HBox taskItem
  ├─ CheckBox (marca como concluída)
  ├─ Label (descrição)
  ├─ Region (espaço flexível)
  └─ Button (remover)
```

---

## 🔄 Fluxo de Dados

### Adição de Tarefa

```
1. Usuário digita no TextField
2. Clica em "Add Task"
3. AppView.handleAddTask() é chamado
4. TaskController.addTask() cria nova Task
5. renderTasks() regenera a UI
6. TaskItem renderiza a nova tarefa
```

### Diagrama de Sequência

```
Usuário
   │
   └──► App.java
         │
         └──► AppView.createScene()
              │
              ├──► CreateTaskInput()
              │
              ├──► CreateScrollPane()
              │    │
              │    └──► renderTasks()
              │         │
              │         └──► for each Task:
              │              new TaskItem().createTaskItem()
              │
              └──► Scene.addStylesheet(style.css)
```

### Marcação de Tarefa

```
Usuário clica em CheckBox
   │
   └──► CheckBox.selectedProperty().addListener()
        │
        ├──► task.setCompleted(true)
        │
        ├──► applyCompletedStyle()
        │    └──► Label fica riscada (#999999)
        │
        └──► onTaskChanged.run()
             └──► renderTasks() (atualiza UI)
```

---

## ✨ Funcionalidades

### Implementadas ✅

| Funcionalidade | Status | Descrição |
|---|---|---|
| Adicionar tarefa | ✅ | Criar nova tarefa com descrição |
| Listar tarefas | ✅ | Exibir todas as tarefas |
| Marcar concluída | ✅ | Checkbox com efeito visual |
| Remover tarefa | ✅ | Botão individual por tarefa |
| Estilos CSS | ✅ | Interface moderna e responsiva |
| ScrollPane | ✅ | Suporte para muitas tarefas |

---

## ❓ Troubleshooting

### Problema: "ClassNotFoundException: com.notion.Main"

**Causa**: pom.xml com configuração errada

**Solução**:
```xml
<!-- pom.xml -->
<configuration>
    <mainClass>com.notion.Main</mainClass>  <!-- Correto -->
</configuration>
```

### Problema: "Cannot find module javafx"

**Causa**: JavaFX não está nas dependências do Maven

**Solução**:
```bash
mvn clean install
mvn javafx:run
```

### Problema: Aplicação não inicia

**Causa**: JavaFX precisa de módulos específicos no Java 25+

**Solução**:
```bash
# Adicione ao comando:
java --add-modules javafx.controls,javafx.fxml -jar app.jar
```

### Problema: CSS não está sendo aplicado

**Causa**: Arquivo `style.css` não foi copiado para `target/classes/`

**Solução**:
```bash
mvn clean compile
# Verifique se o arquivo existe em: target/classes/style.css
```

### Problema: Espaço na lista de tarefas

**Causa**: ScrollPane não está configurado corretamente

**Solução**: No `AppView.java`:
```java
private ScrollPane createTaskScrollPane() {
    scrollPane.setFitToWidth(true);  // ← Importante
    return scrollPane;
}
```

---

## 📖 Documentação Adicional

### Referências Externas

- 📚 [JavaFX Official Documentation](https://openjfx.io/javadoc/25/)
- 🔨 [Maven Guide](https://maven.apache.org/guides/)
- ☕ [Java 25 Documentation](https://docs.oracle.com/en/java/javase/25/)
- 🎨 [JavaFX CSS Reference Guide](https://openjfx.io/javadoc/25/javafx.graphics/javafx/scene/doc-files/cssref.html)

### Documentação no Código

Cada classe possui **JavaDoc completo**:

```java
/**
 * Cria o CheckBox que marca a tarefa como concluída.
 * 
 * @return Um CheckBox configurado
 */
private CheckBox createCheckBox() {
    CheckBox checkBox = new CheckBox();
    checkBox.setSelected(task.isCompleted());
    return checkBox;
}
```

Para gerar documentação HTML:

```bash
mvn javadoc:javadoc
# Abra: target/site/apidocs/index.html
```

### Livros Recomendados

- 📖 **"Clean Code"** - Robert C. Martin
- 📖 **"Design Patterns"** - Gang of Four
- 📖 **"Java Concurrency in Practice"** - Brian Goetz
- 📖 **"Pro JavaFX 8"** - Johan Vos, Weiqi Gao, et al.

---

### Padrões de Código

- ✅ Use **camelCase** para variáveis e métodos
- ✅ Use **PascalCase** para classes
- ✅ Inclua **JavaDoc** em classes públicas
- ✅ Mantenha **métodos pequenos** (< 20 linhas)
- ✅ Siga o **Single Responsibility Principle**

---

## 📈 Status do Projeto

- **Versão**: 1.0.0
- **Status**: ✅ Estável
- **Última Atualização**: Maio 2026
- **Java**: 25+
- **JavaFX**: 25+

---

## 🎓 Notas para Aprendizagem

Este projeto foi desenvolvido como **referência educacional** para:

- ✅ Aprender padrões de design Java
- ✅ Compreender arquitetura MVC
- ✅ Praticar princípios SOLID
- ✅ Desenvolver aplicações JavaFX profissionais
- ✅ Usar Maven e gerenciar dependências

**Estude o código, entenda a arquitetura e aprenda!** 🎓

---

## ✅ Checklist de Desenvolvimento

Para novos desenvolvedores que entram no projeto:

- [ ] Clonar/baixar o repositório
- [ ] Instalar Java 25+
- [ ] Instalar Maven 3.8.0+
- [ ] Executar `mvn clean compile`
- [ ] Executar `mvn javafx:run`
- [ ] Ler este README.md completo
- [ ] Explorar a estrutura de pacotes
- [ ] Ler JavaDoc das classes principais
- [ ] Executar testes (se houver)
- [ ] Fazer alteração pequena para praticar

---

**Desenvolvido usando Java + JavaFX**

*Última atualização: 13 de Maio de 2026*
