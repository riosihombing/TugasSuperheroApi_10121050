/*
 * Project Name : TugasSuperheroAPI_10121050
 * Created by Rio
 * Copyright (c) 2024. All rights reserverd.
 * Last modified 7/14/24, 4:21 PM
 */
package com.rio.tugassuperheroapi_10121050

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rio.tugassuperheroapi_10121050.DetailSuperheroActivity.Companion.EXTRA_ID

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigateToDetail("571") // Panggil fungsi untuk navigasi ke DetailSuperheroActivity dengan ID "571"
    }

    // Fungsi untuk navigasi ke DetailSuperheroActivity dengan ID yang diberikan
    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java) // Buat intent untuk navigasi ke DetailSuperheroActivity
        intent.putExtra(EXTRA_ID, id) // Sisipkan ID superhero ke intent sebagai data tambahan
        startActivity(intent) // Mulai aktivitas baru dengan intent yang sudah disiapkan
        finish() // Selesaikan aktivitas saat ini sehingga pengguna tidak kembali ke MainActivity setelah membuka DetailSuperheroActivity
    }
}
