package com.notion;

import com.notion.controller.TaskController;
import com.notion.view.AppView;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe principal da aplicação To-Do Notes.
 * 
 * Responsabilidades:
 * - Iniciar a aplicação JavaFX
 * - Configurar o Stage (janela principal)
 * - Delegar a construção da UI para AppView
 * 
 * Princípio aplicado: Separação de Responsabilidades (Single Responsibility Principle)
 */
public class App extends Application {

  /**
   * Método inicial da aplicação JavaFX.
   * Configura a janela e exibe a interface criada por AppView.
   * 
   * @param stage O palco (janela) principal da aplicação
   */
  @Override
  public void start(Stage stage) {
    // Criar o controlador de tarefas
    TaskController controller = new TaskController();

    // Criar a visualização (UI)
    AppView view = new AppView(controller);

    // Configurar a janela
    stage.setTitle("To-Do Notes");
    stage.setScene(view.createScene());
    stage.show();
  }

  /**
   * Ponto de entrada da aplicação.
   * 
   * @param args Argumentos de linha de comando
   */
  public static void main(String[] args) {
    launch();
  }
}
