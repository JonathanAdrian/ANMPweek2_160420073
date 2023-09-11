package com.example.adv160420073week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        var playerScore = 0
        var number1 = (0..100).random()
        var number2 = (0..100).random()

        num1.text = number1.toString()
        num2.text = number2.toString()

        btnSubmit.setOnClickListener{
            if (txtAnswer.text.toString().toInt() == number1+number2 ){
                playerScore += 1
                number1 = (0..100).random()
                number2 = (0..100).random()

                num1.text = number1.toString()
                num2.text = number2.toString()

                Toast.makeText(requireActivity(), "Correct!", Toast.LENGTH_LONG).show()
            }
            else {
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)

                Toast.makeText(requireActivity(), "Too bad. Incorrect!", Toast.LENGTH_LONG).show()
            }

        }
    }
}