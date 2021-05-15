package de.hska.students.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import de.hska.students.todo.databinding.MainActivityBinding
import de.hska.students.todo.ui.views.ListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        supportFragmentManager.findFragmentById(R.id.list_fragment)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, ListFragment.newInstance())
//                .commitNow()
//        }
    }
}