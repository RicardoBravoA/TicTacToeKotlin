package com.rba.tictactoekotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentPlayer:Int = 1
    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

    }

    fun play(view : View) {
        val buttonSelected = view as AppCompatButton
        var buttonId= 0

        when(buttonSelected.id){
            R.id.btn1 -> buttonId = 1
            R.id.btn2 -> buttonId = 2
            R.id.btn3 -> buttonId = 3
            R.id.btn4 -> buttonId = 4
            R.id.btn5 -> buttonId = 5
            R.id.btn6 -> buttonId = 6
            R.id.btn7 -> buttonId = 7
            R.id.btn8 -> buttonId = 8
            R.id.btn9 -> buttonId = 9
            else -> buttonId = 0
        }

        playGame(buttonId, buttonSelected)

    }

    private fun playGame(buttonId:Int, buttonSelected:AppCompatButton){

        if(currentPlayer == 1){
            buttonSelected.setText("X")
            buttonSelected.setBackgroundColor(ContextCompat.getColor(this, R.color.bgPlayer1))
            firstPlayer.add(buttonId)
            currentPlayer = 2
        } else {
            buttonSelected.setText("O")
            buttonSelected.setBackgroundColor(ContextCompat.getColor(this, R.color.bgPlayer2))
            secondPlayer.add(buttonId)
            currentPlayer = 1
        }

        buttonSelected.isEnabled = false
        winner()

    }

    private fun winner(){
        var winner:Int = 0

        if(firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winner = 1
        }

        if(firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winner = 1
        }

        if(firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winner = 1
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winner = 1
        }

        if(firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winner = 1
        }

        if(firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winner = 1
        }

        if(firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winner = 1
        }

        if(firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winner = 1
        }


        if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winner = 2
        }

        if(secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winner = 2
        }

        if(secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winner = 2
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winner = 2
        }

        if(secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winner = 2
        }

        if(secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winner = 2
        }

        if(secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winner = 2
        }

        if(secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winner = 2
        }

        when(winner){
            1 -> Toast.makeText(this, "El Jugador 1 ganó el juego", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "El Jugador 2 ganó el juego", Toast.LENGTH_SHORT).show()
        }



    }

}
