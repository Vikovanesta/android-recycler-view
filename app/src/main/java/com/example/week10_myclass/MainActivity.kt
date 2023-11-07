package com.example.week10_myclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week10_myclass.databinding.ActivityMainBinding
import io.github.serpro69.kfaker.Faker
import java.text.DecimalFormat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, ProfileActivity::class.java)

        val adapterMahasiswa = MahasiswaAdapter(generateMahasiswa()) {
            mahasiswa -> Toast.makeText(this@MainActivity, "Yu klik on ${mahasiswa.name}",
                Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvMahasiswa.apply {
                adapter = adapterMahasiswa
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateMahasiswa(): List<Mahasiswa> {
        return listOf(
            Mahasiswa(name = "Udin Breitenberg", ipk = 2.5, image = "https://randomuser.me/api/portraits/men/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Marni Anderson", ipk = 3.7, image = "https://randomuser.me/api/portraits/women/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Anwar Kreiger", ipk = 4.0, image = "https://randomuser.me/api/portraits/men/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Abdul Ismail", ipk = 2.9, image = "https://randomuser.me/api/portraits/men/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Siti Miller", ipk = 2.0, image = "https://randomuser.me/api/portraits/women/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Regina Wintheiser", ipk = 3.1, image = "https://randomuser.me/api/portraits/women/" + (0..99).random() + ".jpg"),
            Mahasiswa(name = "Bulbasaur", ipk = 4.1, image = "https://img.pokemondb.net/artwork/large/bulbasaur.jpg"),
        )
    }
}