package com.tpodman172.tsk2.server.api.controller;

import com.tpodman172.tsk2.server.api.appService.TaskAppService;
import com.tpodman172.tsk2.server.api.appService.model.AchievementDTO;
import com.tpodman172.tsk2.server.api.appService.model.TaskCreateDTO;
import com.tpodman172.tsk2.server.api.appService.model.TaskDTO;
import com.tpodman172.tsk2.server.api.appService.model.TaskUpdateDTO;
import com.tpodman172.tsk2.server.config.UserSessionService;
import com.tpodman172.tsk2.server.context.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

// todo error handling by AOP
@AllArgsConstructor
@RestController
public class TaskController implements TasksApi {

    private TaskAppService taskAppService;
    private UserSessionService userSessionService;

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        taskAppService.deleteTask(TaskEntity.ofUpdate(id, userSessionService.getUserId(), null));
        return null;
    }

    @Override
    public ResponseEntity<Void> putTask(Long id, @Valid TaskUpdateDTO taskUpdateDTO) {
        taskAppService.updateTask(TaskEntity.ofUpdate(id, userSessionService.getUserId(), taskUpdateDTO.getTitle()));
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> putAchievement(Long id, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @NotNull @Valid LocalDate targetDate, @NotNull @Valid Boolean completed) {
        taskAppService.updateAchievement(id, targetDate, completed);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TaskDTO>> getTasks() {
        HttpHeaders header = new HttpHeaders();

        val userId = userSessionService.getUserId();
        List<TaskDTO> tasks = taskAppService.fetchTasks(userId);

        return new ResponseEntity(tasks, header, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AchievementDTO>> getAchievements() {
        return new ResponseEntity(taskAppService.fetchAchievement(userSessionService.getUserId()), null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> postTask(@Valid TaskCreateDTO taskCreateDTO) {
        return new ResponseEntity(taskAppService.createTask(TaskEntity.ofNew(userSessionService.getUserId(), taskCreateDTO.getTitle())), null, HttpStatus.OK);
    }


}
