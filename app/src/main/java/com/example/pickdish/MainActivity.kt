package com.example.pickdish

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rollBtn:Button
    private lateinit var dishNum:TextView
    private lateinit var dishDesc:TextView
    private lateinit var dishImg:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dishNum = findViewById(R.id.dish_num)
        rollBtn = findViewById(R.id.roll_btn)
        dishDesc = findViewById(R.id.dish_desc)
        dishImg = findViewById(R.id.dish_image)

        var list = mutableListOf<Dish>()
        list.add(Dish( "Món ăn hằng ngày", "Cơm + Gà + Lá chuối :))", R.drawable.dish_1))
        list.add(Dish( "Sơn hào hải vị", "Cơm + Gà + Lá chuối :)) 2", R.drawable.dish_2))
        list.add(Dish( "Trứng cúc kho thịt", "Cơm + Gà + Lá chuối :)) 3", R.drawable.dish_3))
        list.add(Dish( "Cá viên chiên", "Cơm + Gà + Lá chuối :)) 4", R.drawable.dish_4))
        list.add(Dish( "Cái này là món gì đó?", "Cơm + Gà + Lá chuối :)) 5", R.drawable.dish_5))
        list.add(Dish( "Cái này có màu đỏ", "Cơm + Gà + Lá chuối :)) 6", R.drawable.dish_6))

        rollBtn.setOnClickListener(){

            dishImg.animate().apply {
                duration = 1000
                rotationYBy(180f)
            }.start()

            var haha = rollDish(list);


        }
    }

    private fun rollDish( listnek : MutableList<Dish>): Int{
        var list = listnek

        var randomInt:Int = Random.nextInt( list.size)
        dishNum.text = list[randomInt].title

        dishDesc.text = list[randomInt].desc
        dishImg.setImageResource(list[randomInt].img)
        Toast.makeText(this, "Đã lắc thành công!", Toast.LENGTH_SHORT).show()

        return randomInt;
    }


}