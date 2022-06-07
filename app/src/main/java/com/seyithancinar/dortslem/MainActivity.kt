package com.seyithancinar.dortslem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import androidx.core.graphics.convertTo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var  yanslis=0
    var dogru=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sayi1=(200..999).random()
        var sayi2=(200..999).random()
        var sonuc=sayi1+sayi2
        btnsayi1.text=sayi1.toString()
        btnsayi2.text=sayi2.toString()
        txtsonuc.text=sonuc.toString()
        txtDogruSayisi.text="Doğru: ${dogru}"
        txtYanlisSayisi.text="Yanlış: ${yanslis}"


        val sayici=object :CountDownTimer(25000,1000){
            override fun onTick(i: Long) {
                textView.text="Kalan Süre: ${i/1000} sn"
            }
            override fun onFinish() {

                textView.text="Süre Doldu"
                btnsayiuret.isEnabled=false

            }
        }

    sayici.start()

    }

    fun sayiuret(view: View){
       var sonuc2=txtsonuc.text.toString().toInt()
       var tahmin=txttahmin.text.toString().toIntOrNull()
        if (tahmin==null){
            txtYanlisDogru.text="Tahmin Gir"
        }else{
            if (tahmin==sonuc2){
                txtYanlisDogru.text = "Doğru"
                dogru++
                txtDogruSayisi.text="Doğru: ${dogru}"
            }else{
                txtYanlisDogru.text="YANLIŞ"
                yanslis++
                txtYanlisSayisi.text="Yanlış: ${yanslis}"
            }

            var sayi1=(200..999).random()
            var sayi2=(200..999).random()
            var sonuc=sayi1+sayi2
            btnsayi1.text=sayi1.toString()
            btnsayi2.text=sayi2.toString()
            txtsonuc.text=sonuc.toString()
            txttahmin.text.clear()

        }

        }

}






