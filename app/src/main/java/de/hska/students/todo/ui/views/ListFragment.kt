package de.hska.students.todo.ui.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import de.hska.students.todo.databinding.ListFragmentBinding
import de.hska.students.todo.entities.Note



private const val LOG_TAG = "ListFragment"

class ListFragment : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val notes = mutableListOf<Note>()
    private val listAdapter = NoteListAdapter(::onClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater)

        with(binding.noteList) {
            layoutManager = LinearLayoutManager(context)

            adapter = listAdapter
            setHasFixedSize(true)
        }
        binding.addNote.setOnClickListener { addNote() }
        return binding.root
    }

    private fun addNote() {
        Log.d(LOG_TAG, "Add note")
        val note = Note(
            id = 0,
            title = "Title",
            content = "Content body",
        )
        notes.add(note)
        updateList()
    }

    private fun updateList() {
        listAdapter.submitList(notes)
    }


    private fun onClick(note: Note) {
        Log.d(LOG_TAG, "Clicked note ${note.id}")
    }

}