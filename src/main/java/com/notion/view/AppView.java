package com.notion.view;

import com.notion.components.TaskItem;
import com.notion.controller.TaskController;
import com.notion.model.Task;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Classe responsável por construir a interface visual (UI) da aplicação To-Do Notes.
 * 
 * Responsabilidades:
 * - Criar e configurar todos os componentes JavaFX
 * - Renderizar tarefas usando o componente TaskItem
 * - Gerenciar atualização da lista de tarefas
 * - Definir listeners para botões e ações de usuário
 * - Retornar uma Scene pronta para ser exibida
 * 
 * Princípio aplicado: Separação de Responsabilidades (Single Responsibility Principle)
 */
public class AppView {
  private TaskController controller;
  private VBox taskContainer;

  /**
   * Construtor que inicializa o controlador de tarefas.
   * 
   * @param controller O controlador responsável pela lógica de negócio
   */
  public AppView(TaskController controller) {
    this.controller = controller;
    this.taskContainer = new VBox();
  }

  /**
   * Constrói e retorna a Scene completa da aplicação.
   * 
   * @return Uma Scene pronta para ser exibida
   */
  public Scene createScene() {
    // Componentes de entrada
    TextField taskInput = createTaskInput();

    // Componentes de exibição
    ScrollPane scrollPane = createTaskScrollPane();

    // Componentes de controle
    HBox buttonBox = createButtonBox(taskInput);

    // Layout principal
    VBox root = createRootLayout(taskInput, buttonBox, scrollPane);

    // Criar Scene com estilo CSS
    Scene scene = new Scene(root, 400, 550);
    applyStylesheet(scene);

    return scene;
  }

  /**
   * Cria o campo de entrada para novas tarefas.
   * 
   * @return Um TextField configurado
   */
  private TextField createTaskInput() {
    TextField taskInput = new TextField();
    taskInput.setPromptText("Enter a new task...");
    return taskInput;
  }

  /**
   * Cria a ScrollPane contendo as tarefas em um VBox.
   * 
   * @return Uma ScrollPane configurada
   */
  private ScrollPane createTaskScrollPane() {
    taskContainer.setStyle("-fx-spacing: 0;");
    
    ScrollPane scrollPane = new ScrollPane(taskContainer);
    scrollPane.setFitToWidth(true);
    scrollPane.setPrefHeight(300);
    scrollPane.setStyle("-fx-control-inner-background: #f9f9f9;");

    renderTasks();

    return scrollPane;
  }

  /**
   * Renderiza todas as tarefas como componentes TaskItem.
   * Funciona como um "map" de componentes.
   */
  private void renderTasks() {
    taskContainer.getChildren().clear();

    for (Task task : controller.getTasks()) {
      TaskItem taskItem = new TaskItem(
          task,
          controller,
          this::renderTasks // Callback para atualizar quando tarefa mudar
      );
      taskContainer.getChildren().add(taskItem.createTaskItem());
    }
  }

  /**
   * Cria a HBox contendo os botões de ação (Add).
   * 
   * @param taskInput O campo de entrada de texto
   * @return Uma HBox com os botões configurados
   */
  private HBox createButtonBox(TextField taskInput) {
    Button addButton = createAddButton(taskInput);

    HBox buttonBox = new HBox(10, addButton);
    buttonBox.setPadding(new Insets(10, 0, 0, 0));

    return buttonBox;
  }

  /**
   * Cria o botão de adicionar tarefa com seu listener.
   * 
   * @param taskInput O campo de entrada de texto
   * @return Um Button configurado
   */
  private Button createAddButton(TextField taskInput) {
    Button addButton = new Button("Add Task");
    addButton.setStyle("-fx-padding: 8; -fx-font-size: 12;");
    addButton.setPrefWidth(150);

    addButton.setOnAction(e -> handleAddTask(taskInput));

    return addButton;
  }

  /**
   * Cria o layout raiz (VBox) da aplicação.
   * 
   * @param taskInput O campo de entrada
   * @param buttonBox A caixa de botões
   * @param scrollPane O scroll contendo tarefas
   * @return Uma VBox configurada como layout raiz
   */
  private VBox createRootLayout(TextField taskInput, HBox buttonBox, ScrollPane scrollPane) {
    VBox root = new VBox(10);
    root.setPadding(new Insets(10));
    root.getChildren().addAll(taskInput, buttonBox, scrollPane);

    return root;
  }

  /**
   * Aplica a folha de estilos CSS à Scene.
   * 
   * @param scene A Scene a qual aplicar os estilos
   */
  private void applyStylesheet(Scene scene) {
    try {
      String stylesheet = getClass().getResource("/style.css").toExternalForm();
      scene.getStylesheets().add(stylesheet);
    } catch (NullPointerException e) {
      System.err.println("Aviso: Arquivo CSS não encontrado em /style.css");
    }
  }

  /**
   * Manipula a adição de uma nova tarefa.
   * 
   * @param taskInput O campo de entrada de texto
   */
  private void handleAddTask(TextField taskInput) {
    String description = taskInput.getText().trim();

    if (!description.isEmpty()) {
      controller.addTask(description);
      renderTasks();
      taskInput.clear();
    }
  }
}
