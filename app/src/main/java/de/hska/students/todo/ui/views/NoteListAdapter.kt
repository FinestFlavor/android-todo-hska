package de.hska.students.todo.ui.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.hska.students.todo.R
import de.hska.students.todo.entities.Note

private const val LOG_TAG = "NoteListAdapter"

class NoteListAdapter(private val clickListener: (Note) -> Unit) :
    ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NoteDiffCallback) {

    class NoteViewHolder(
        itemView: View,
        private val clickListener: (Note) -> Unit,
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var currentNote: Note? = null
        private var noteText: TextView = itemView.findViewById(R.id.list_item_text)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(note: Note) {
            currentNote = note
            noteText.text = note.title
        }

        override fun onClick(view: View) {
            currentNote?.let {
                clickListener(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        Log.d(LOG_TAG, "Creating view holder")
        val listItemRoot =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return NoteViewHolder(listItemRoot, clickListener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        Log.d(LOG_TAG, "Binding view holder")
        holder.bind(getItem(position))
    }
}

object NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

}