package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title", "Content");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals("Title", mappedTask.getTitle());
        assertEquals((Long)1L, mappedTask.getId());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Title", "Content");

        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals("Content", mappedTaskDto.getContent());
        assertEquals((Long)1L, mappedTaskDto.getId());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "Title", "Content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        //When
        List<TaskDto> mappedListTaskDto = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1, mappedListTaskDto.size());
        assertEquals("Title", mappedListTaskDto.get(0).getTitle());
    }
}
