/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
            //0
            Question(text = "My name is Arthur. I was born on February 29, 19XX. I was born with a uniqueness where I was always lucky. At the age of 24, I won the door prize for a vacation to Hawaii for 7 days. Plus the cost for eating and lodging is covered.",
                    answers = listOf("Use ticket and go sailing", "Give to other people", "Sell the ticket", "Ignore the ticket")),
            //1
            Question(text = "One week later, I sailed to Hawaii. But, on the way to Hawaii. The ship I boarded suddenly sank and cause myself to be stranded on an empty island. I was shocked and had to accept the fact that only myself survived. ",
                    answers = listOf("Calm down", "Panic", "", "")),
            //2
            Question(text = "It's good if this ticket is donated to people who can't afford it.",
                    answers = listOf("Main menu", "", "", "")),
            //3
            Question(text = "Finally the ticket was sold to someone for a decent price. However, the ticket I sold brought disaster to the customers. ",
                    answers = listOf("Main menu", "", "", "")),
            //4
            Question(text = "One week later, there was an accident in which the shipwreck was caused by the ship crashed by chunks of ice. Luckily I did not take the cruise, because I've been there several times. ",
                    answers = listOf("Main menu", "", "", "")),
            //5
            Question(text = "Finally, I can calm myself.",
                    answers = listOf("Start gather item", "", "", "")),
            //6
            Question(text = "I decided to end my life, because it was too much suffering for me to endure alone. ",
                    answers = listOf("Main menu", "", "", "")),
            //7
            Question(text = "I must to survive in this island no matter whatever. First, i must to gather some item.",
                    answers = listOf("Gather materials", "Gather food", "", "")),
            //8
            Question(text = "I decide to gather some materials. ",
                    answers = listOf("Continue gathering", "Stop gathering", "", "")),
            //9
            Question(text = "I decide to gather food around.",
                    answers = listOf("Collect food", "", "", "")),
            //10
            Question(text = "After collecting some food, I get fish, coconut, unique red mushroom. I must to sort the food that are safe to eat. ",
                    answers = listOf("Eat fish and coconut", "Eat all the food", "", "")),
            //11
            Question(text = "I'm to hungry, so I eat all the food and I don't know that one of my food contain deadly poison.",
                    answers = listOf("Main menu", "", "", "")),
            //12
            Question(text = "I decide to gather some materials. ",
                    answers = listOf("Stop gathering", "", "", "")),
            //13
            Question(text = "After the materials completely collected, I build small boat and go away from this island. ",
                    answers = listOf("Continue", "", "", "")),
            //14
            Question(text = "After eat the food, I build house and wait the rescue team. ",
                    answers = listOf("Wait hopelessly", "Wait hopefully", "", "")),
            //15
            Question(text = "The ship finished on time, so I can go to my home.",
                    answers = listOf("Main menu", "", "", "")),
            //16
            Question(text = "Finally the rescue team come to save me, and I can rest after going through this suffer.",
                    answers = listOf("Main menu", "", "", "")),
            //17
            Question(text = "The rescue team never come to save me, and none of the ships passed this island. ",
                    answers = listOf("Main menu", "", "", ""))
    )



    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        //Copy for quit game = this.activity!!.onBackPressed()

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId

            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.firstAnswerRadioButton -> answerIndex = 0
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                when (currentQuestion) {
                    questions[0] -> when(answerIndex) {
                        0 -> {
                            currentQuestion = questions[1]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        1 -> {
                            currentQuestion = questions[2]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        2 -> {
                            currentQuestion = questions[3]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        3 -> {
                            currentQuestion = questions[4]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[1] -> when(answerIndex) {
                        0 -> {
                            currentQuestion = questions[5]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        1 -> {
                            currentQuestion = questions[6]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[2] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[3] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[4] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[5] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[7]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[6] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[7] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[8]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        1 -> {
                            currentQuestion = questions[9]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[8] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[12]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[9] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[10]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        1 -> {
                            currentQuestion = questions[11]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[10] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[14]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[11] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[12] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[13]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[13] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[15]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[14] -> when(answerIndex){
                        0 -> {
                            currentQuestion = questions[16]
                            answers = currentQuestion.answers.toMutableList()
                        }
                        1 -> {
                            currentQuestion = questions[17]
                            answers = currentQuestion.answers.toMutableList()
                        }
                    }
                    questions[15] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[16] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                    questions[17] -> when(answerIndex){
                        0 -> this.activity!!.onBackPressed()
                    }
                }
                binding.invalidateAll()
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                /*
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment3)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                }

                 */
            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        //questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun startGame() {
        currentQuestion = questions[0]
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
    }
}
