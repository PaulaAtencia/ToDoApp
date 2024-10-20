package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.turing.alan.cpifp.databinding.FragmentTaskCreateBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaskCreateFragment : Fragment() {

    private val vm: TaskCreateViewModel by viewModels()
    private lateinit var binding: FragmentTaskCreateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskCreateBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveTaskButton.setOnClickListener {
            val title = binding.titleInput.text.toString()
            val body = binding.bodyInput.text.toString()
            //  Ahora se crea la tarea sin necesidad de llamar repository desde aquí
            vm.viewModelScope.launch {
               vm.createTask(title, body)
            }
            findNavController().popBackStack()

        }
    }


}