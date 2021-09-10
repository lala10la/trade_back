package com.trade_accounting.utils.mapper;

import com.trade_accounting.models.Employee;
import com.trade_accounting.models.RetailSales;
import com.trade_accounting.models.Task;
import com.trade_accounting.models.TaskComment;
import com.trade_accounting.models.dto.RetailSalesDto;
import com.trade_accounting.models.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

     /*   @Mappings({
            @Mapping(source = "taskEmployee.id", target = "employeeId"),
            @Mapping(source = "taskAuthor.id", target = "taskAuthorId")
    })
        TaskDto taskToTaskDto(Task task);

    @Mappings({
            @Mapping(source = "employeeId", target = "taskEmployee.id"),
            @Mapping(source = "taskAuthorId", target = "taskAuthor.id")

    })
    Task taskDtoToTask(TaskDto taskDto);*/

    default Task taskDtoToTask(TaskDto taskdto) {

        if (taskdto == null) {
            return null;
        }

        return Task.builder()
                .id(taskdto.getId())
                .description(taskdto.getDescription())
                .completed(taskdto.isCompleted())
                .build();
    }

    default TaskDto taskToTaskDto(Task task) {

        TaskDto taskDto = new TaskDto();
        if (task == null) {
            return null;
        } else {
            taskDto.setId(task.getId());
            taskDto.setDescription(task.getDescription());
            taskDto.setCompleted(task.isCompleted());
            taskDto.setCreationDateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(task.getCreationDateTime()));
            taskDto.setDeadlineDateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(task.getDeadlineDateTime()));

            if (task.getTaskEmployee() == null) {
                return null;
            } else {
                taskDto.setEmployeeId(task.getTaskEmployee().getId());

                if (task.getTaskAuthor() == null) {
                    return null;
                } else {
                    taskDto.setTaskAuthorId(task.getTaskAuthor().getId());

                    if (task.getTaskComments() == null) {
                        return null;
                    } else {
                        taskDto.setTaskCommentsIds(task.getTaskComments().stream().map(TaskComment::getId).collect(Collectors.toList()));
                        return taskDto;
                    }
                }
            }
        }
    }
}
