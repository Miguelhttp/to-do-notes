package com.notion.components;

import com.notion.controller.TaskController;
import com.notion.model.Task;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * Componente que representa visualmente uma tarefa individual.
 * 
 * Responsabilidades:
 * - Criar um HBox contendo CheckBox, Label e Button de remoção
 * - Gerenciar o estado visual de tarefas concluídas
 * - Aplicar estilos CSS para tarefas concluídas
 * 
 * Estrutura do componente:
 * [✓ CheckBox] [Descrição da Tarefa] [Espaço flexível] [Remove Button]
 */
public class TaskItem {
  private Task task;
  private TaskController controller;
  private Runnable onTaskChanged;

  /**
   * Construtor que inicializa o componente de tarefa.
   * 
   * @param task A tarefa a ser representada
   * @param controller O controlador de tarefas
   * @param onTaskChanged Callback executado quando a tarefa é modificada
   */
  public TaskItem(Task task, TaskController controller, Runnable onTaskChanged) {
    this.task = task;
    this.controller = controller;
    this.onTaskChanged = onTaskChanged;
  }

  /**
   * Cria e retorna o HBox representando a tarefa.
   * 
   * @return Um HBox configurado com todos os elementos da tarefa
   */
  public HBox createTaskItem() {
    CheckBox checkBox = createCheckBox();
    Label label = createLabel();
    Region spacer = createSpacer();
    Button removeButton = createRemoveButton();

    // Aplicar estilos iniciais se tarefa já está concluída
    if (task.isCompleted()) {
      applyCompletedStyle(label, checkBox);
    }

    // Configurar listener do CheckBox após criar o label
    checkBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
      task.setCompleted(newVal);
      
      if (newVal) {
        applyCompletedStyle(label, checkBox);
      } else {
        removeCompletedStyle(label, checkBox);
      }

      onTaskChanged.run();
    });

    HBox taskItem = new HBox(10);
    taskItem.setPadding(new Insets(8, 10, 8, 10));
    taskItem.setStyle("-fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");
    taskItem.getChildren().addAll(checkBox, label, spacer, removeButton);

    return taskItem;
  }

  /**
   * Cria o CheckBox que marca a tarefa como concluída.
   * 
   * @return Um CheckBox configurado
   */
  private CheckBox createCheckBox() {
    CheckBox checkBox = new CheckBox();
    checkBox.setSelected(task.isCompleted());
    checkBox.setPrefWidth(30);
    return checkBox;
  }

  /**
   * Cria o Label que exibe a descrição da tarefa.
   * 
   * @return Um Label configurado
   */
  private Label createLabel() {
    Label label = new Label(task.getDescription());
    label.setWrapText(true);
    label.setStyle("-fx-font-size: 12; -fx-text-fill: #333333;");
    HBox.setHgrow(label, Priority.ALWAYS);

    return label;
  }

  /**
   * Cria um espaçador flexível entre o label e o botão de remover.
   * 
   * @return Uma Region configurada como espaçador
   */
  private Region createSpacer() {
    Region spacer = new Region();
    HBox.setHgrow(spacer, Priority.ALWAYS);
    return spacer;
  }

  /**
   * Cria o botão de remover tarefa.
   * 
   * @return Um Button configurado com listener
   */
  private Button createRemoveButton() {
    Button removeButton = new Button("✕");
    removeButton.setStyle(
        "-fx-padding: 5 10 5 10; " +
        "-fx-font-size: 12; " +
        "-fx-text-fill: #ff4444; " +
        "-fx-background-color: transparent; " +
        "-fx-cursor: hand;"
    );

    removeButton.setOnAction(e -> {
      controller.removeTask(task);
      onTaskChanged.run();
    });

    return removeButton;
  }

  /**
   * Aplica estilos para tarefa concluída (riscado e cinza).
   * 
   * @param label O Label da tarefa
   * @param checkBox O CheckBox da tarefa
   */
  private void applyCompletedStyle(Label label, CheckBox checkBox) {
    label.setStyle(
        "-fx-font-size: 12; " +
        "-fx-text-fill: #999999; " +
        "-fx-text-decoration: line-through;"
    );
    checkBox.setStyle("-fx-opacity: 0.7;");
  }

  /**
   * Remove estilos de tarefa concluída.
   * 
   * @param label O Label da tarefa
   * @param checkBox O CheckBox da tarefa
   */
  private void removeCompletedStyle(Label label, CheckBox checkBox) {
    label.setStyle(
        "-fx-font-size: 12; " +
        "-fx-text-fill: #333333;"
    );
    checkBox.setStyle("");
  }
}
