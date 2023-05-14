package com.example.university_assignments_tracker.screens.tabs.subjects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.university_assignments_tracker.databinding.ItemSubjectBinding

//typealias SubjectDeleteListener = (subject: Subject) -> Unit

class SubjectsAdapter(
    //private val deleteListener: SubjectDeleteListener
) : RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder>(), View.OnClickListener {

//    var subjects: List<Subject> = emptyList()
//        set(newValue) {
//            field = newValue
//            notifyDataSetChanged()
//        }

    override fun onClick(v : View) {
//        val subject = v.tag as Subject
//        deleteListener.invoke(subject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSubjectBinding.inflate(inflater, parent, false)

        binding.deleteImageViewButton.setOnClickListener(this)

        return SubjectsViewHolder(binding)
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
//        val subject = subjects[position]
//        with(holder.binding) {
//            deleteImageViewButton.tag = subject
//
//            titleTextView.text = subject.title
//            teacherTextView.text = subject.teacher
//            totalRateTextView.text = subject.totalrate
//            descriptionTextView.text = subject.description
//        }
    }

    class SubjectsViewHolder (
        val binding: ItemSubjectBinding
    ) : RecyclerView.ViewHolder(binding.root)

}