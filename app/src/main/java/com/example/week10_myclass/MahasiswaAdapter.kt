package com.example.week10_myclass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.example.week10_myclass.databinding.ItemMahasiswaBinding

typealias OnClickMahasiswa = (Mahasiswa) -> Unit
class MahasiswaAdapter (private  val listMahasiswa : List<Mahasiswa>,
    private val onClickMahasiswa: OnClickMahasiswa) :
    RecyclerView.Adapter<MahasiswaAdapter.ItemMahasiswaViewHolder>() {

    inner class ItemMahasiswaViewHolder (private val binding: ItemMahasiswaBinding) :
            RecyclerView.ViewHolder(binding.root) {

                    fun bind(data : Mahasiswa) {
                        with(binding) {
                            txtNamaMahasiswa.text = data.name
                            txtIpk.text = "IPK: ${data.ipk.toString()}"
                            itemView.setOnClickListener {
                                onClickMahasiswa(data)
                            }
                            Glide.with(itemView.context)
                                .load(data.image)
                                .signature(ObjectKey(System.currentTimeMillis()))
                                .error(R.drawable.baseline_person_24)
                                .into(icMahasiswa)

                            if (data.ipk >= 3.0) {
                                icStatus.setImageResource(R.drawable.baseline_circle_green)
                            } else {
                                icStatus.setImageResource(R.drawable.baseline_circle_red)
                            }
                        }
                    }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMahasiswaViewHolder {
        val binding = ItemMahasiswaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemMahasiswaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMahasiswa.size
    }

    override fun onBindViewHolder(holder: ItemMahasiswaViewHolder, position: Int) {
        holder.bind(listMahasiswa[position])
    }
}