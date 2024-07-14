/*
 * Project Name : TugasSuperheroAPI_10121050
 * Created by Rio
 * Copyright (c) 2024. All rights reserverd.
 * Last modified 7/14/24, 4:21 PM
 */
package com.rio.tugassuperheroapi_10121050

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.rio.tugassuperheroapi_10121050.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id" // Konstanta untuk kirim dan terima ID superhero melalui Intent
    }

    private lateinit var binding: ActivityDetailSuperheroBinding // Binding untuk Activity menggunakan View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater) // Inflate layout menggunakan View Binding
        setContentView(binding.root) // Set content view dengan root view dari binding

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty() // Ambil ID superhero dari Intent
        getSuperheroInformation(id) // Panggil fungsi untuk ambil informasi superhero berdasarkan ID
    }

    // Fungsi untuk ambil informasi superhero dari API
    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch { // Jalankan dalam CoroutineScope IO untuk operasi jaringan
            val superheroDetail = getRetrofit().create(ApiService::class.java).getSuperheroDetail(id) // Panggil API untuk detail superhero

            if (superheroDetail.body() != null){ // Jika respons tidak null
                runOnUiThread { createUI(superheroDetail.body()!!) } // Update UI dengan hasil respons di UI thread
            }
        }
    }

    // Fungsi untuk menampilkan data superhero di UI
    private fun createUI(superhero: SuperHeroDetailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero) // Load gambar superhero ke ImageView menggunakan Picasso
        binding.tvSuperheroName.text = superhero.name // Set nama superhero
        prepareStats(superhero.powerstats) // Persiapkan dan tampilkan statistik kekuatan superhero
        binding.tvSuperheroRealName.text = superhero.biography.fullName // Set nama asli superhero
        binding.tvPublisher.text = superhero.biography.publisher // Set penerbit superhero
    }

    // Fungsi untuk menyiapkan dan menampilkan statistik kekuatan superhero
    private fun prepareStats(powerstats: PowerStatsResponse) {
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)
    }

    // Fungsi untuk update tinggi view berdasarkan statistik superhero
    private fun updateHeight(view: View, stat: String){
        val params = view.layoutParams // Ambil parameter layout dari view
        if(stat != "null") params.height = pxToDp(stat.toFloat()) else params.height = pxToDp(0.00.toFloat()) // Set tinggi view berdasarkan nilai statistik, konversi piksel ke dp
        view.layoutParams = params // Update parameter layout view
    }

    // Fungsi untuk konversi piksel ke dp
    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }

    // Fungsi untuk mendapatkan instance Retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/") // Base URL dari API superhero
            .addConverterFactory(GsonConverterFactory.create()) // Converter untuk Gson
            .build()
    }
}
