package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Task;
import com.anyaudit.payload.request.TaskDTO;
import com.anyaudit.repository.PlanRepository;
import com.anyaudit.repository.TaskRepository;
import com.anyaudit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskManager  {
    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

//    @Autowired
//    public TaskManager(TaskRepository taskRepository, UserRepository userRepository, PlanRepository planRepository) {
//        this.taskRepository = taskRepository;
//        this.userRepository = userRepository;
//        this.planRepository = planRepository;
//    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public Task createTask(TaskDTO taskRequest) {
        Task task = new Task();
        task.setDate(taskRequest.getDate());
        task.setPlanHour(taskRequest.getPlanHour());
        task.setPlanDesc(taskRequest.getPlanDesc());
        task.setUser(userRepository.getOne(taskRequest.getUserId()));
        task.setPlan(planRepository.getOne(taskRequest.getPlanId()));
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskRequest) {
        Task task = getTaskById(id);
        task.setDate(taskRequest.getDate());
        task.setPlanHour(taskRequest.getPlanHour());
        task.setPlanDesc(taskRequest.getPlanDesc());
        task.setUser(userRepository.getOne(taskRequest.getUserId()));
        task.setPlan(planRepository.getOne(taskRequest.getPlanId()));
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}

