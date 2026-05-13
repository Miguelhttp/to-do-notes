package com.notion.model;

public class Task {
  // Properties
  private int id;
  private String description;
  private boolean completed; // Verifica se a tarefa foi concluída

  public Task(int id, String description, boolean completed) {
    this.id = id;
    this.description = description;
    this.completed = false; // Inicialmente, a tarefa não está concluída
  }

  // Getters -> Permite acessar as propriedades da classe
  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public boolean isCompleted() {
    return completed;
  }

  // Setters -> Permite modificar as propriedades da classe
  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  // Método `toString` para exibir a tarefa de forma legível
  @Override
  public String toString() {
    return (completed ? "[✅] " : "[ ] ") + description;
  }
}
