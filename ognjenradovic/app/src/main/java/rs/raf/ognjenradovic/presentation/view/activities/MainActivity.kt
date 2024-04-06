package rs.raf.ognjenradovic.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rs.raf.ognjenradovic.R
import rs.raf.ognjenradovic.databinding.ActivityMainBinding
import rs.raf.ognjenradovic.presentation.view.fragments.FirstFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        val fragment = FirstFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}