package com.notion.controller;

import com.notion.model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
  private List<Task> tasks = new ArrayList<>();

  // Esse método retorna a lista de tarefas. Ele é usado para exibir as tarefas na interface do usuário.
  public List<Task> getTasks() {
    return tasks;
  }

  public void addTask(String description) {
    // Gerando ID para a nova tarefa com base no tamanho da lista de tarefas
    Task task = new Task(tasks.size() + 1, description, false);
    tasks.add(task);
  }

  // Esse método. Ele recebe uma tarefa como parâmetro e a remove da lista de
  // tarefas.
  public void removeTask(Task task) {
    tasks.remove(task);
  }
}
