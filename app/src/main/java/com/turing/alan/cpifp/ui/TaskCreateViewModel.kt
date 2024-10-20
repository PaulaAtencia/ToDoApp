package com.turing.alan.cpifp.ui

import androidx.lifecycle.ViewModel
import com.turing.alan.cpifp.data.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

    // Esta clase puede crear tareas pasandole el titulo y el body
@HiltViewModel
class TaskCreateViewModel @Inject constructor
(
    private val defaultTaskRepository: TaskRepository
    ) : ViewModel()
{
    // Esta función solo se llama por un hilo
    suspend fun createTask(title: String, body: String) 
    {
        defaultTaskRepository.create(title, body)
    }

}