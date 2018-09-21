package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DbService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(final Long id){
        return taskRepository.findById(id);
    }

    public Task saveTask(final Task task){
        return taskRepository.save(task);
    }

    public void deleteTaskById(final Long id){
        taskRepository.deleteById(id);
    }
}