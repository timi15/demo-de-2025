package com.example.demo.service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService underTest;

    @Test
    void testGetTodoByIdWhenIdFound() {
        //Given
        Long todoId = 1L;
        Todo expectedTodo = new Todo(todoId, "Test Todo", false);
        Optional<Todo> expectedOptionalTodo = Optional.of(expectedTodo);
        when(todoRepository.findById(todoId)).thenReturn(expectedOptionalTodo);

        //When
        Todo actualTodo = underTest.getTodoById(todoId);

        //Then
        assertNotNull(actualTodo);
        assertEquals(expectedTodo.getTitle(), actualTodo.getTitle());
        assertFalse(actualTodo.isCompleted());
    }
}
