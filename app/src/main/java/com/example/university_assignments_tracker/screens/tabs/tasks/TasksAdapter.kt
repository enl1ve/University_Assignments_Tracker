package com.example.university_assignments_tracker.screens.tabs.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.university_assignments_tracker.databinding.ItemTaskBinding
import java.text.SimpleDateFormat
import java.util.*

//typealias TaskUpdateListener = (task: Task) -> Unit

class TasksAdapter(
    //private val updateListener: TaskUpdateListener
) : RecyclerView.Adapter<TasksAdapter.TasksViewHolder>(), View.OnClickListener {

//    var tasks: List<Task> = emptyList()
//        set(newValue) {
//            field = newValue
//            notifyDataSetChanged()
//        }

    override fun onClick(v : View) {
//        val subject = v.tag as Task
//        updateListener.invoke(subject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return TasksViewHolder(binding)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
//        val task = tasks[position]
//        with(holder.binding) {
//            titleTextView.text = task.title
//            subjectTextView.text = task.subject
//            rateTextView.text = task.rate
//            statusTextView.text = task.status
//            deadlineTextView.text = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(Date(task.deadline))
//            descriptionTextView.text = task.description
//        }
    }

    class TasksViewHolder (
        val binding: ItemTaskBinding
    ) : RecyclerView.ViewHolder(binding.root)

}