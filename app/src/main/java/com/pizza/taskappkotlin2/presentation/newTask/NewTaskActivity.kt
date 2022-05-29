package com.pizza.taskappkotlin2.presentation.newTask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pizza.taskappkotlin2.databinding.ActivityNewTaskBinding
import com.pizza.taskappkotlin2.domain.models.ShopItem
import com.pizza.taskappkotlin2.extentions.showToast

class NewTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLauncherRealization()
    }

    private fun initLauncherRealization() {
        binding.btnSave.setOnClickListener {
            if(binding.edTaskName.text.isEmpty() && binding.edCount.text.isEmpty()) {
                showToast("Your task or count is empty")
            } else {
                setResult(RESULT_OK, intent.putExtra("item", ShopItem(binding.edTaskName.text.toString(), binding.edCount.text.toString().toInt(), false)))
                finish()
            }
        }
    }

}