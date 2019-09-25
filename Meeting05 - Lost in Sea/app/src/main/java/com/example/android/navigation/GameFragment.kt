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
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.navigation.databinding.FragmentGameBinding
import com.example.android.navigation.MyApplication.Scene

class GameFragment : Fragment() {

    private val scenes = MyApplication.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0
    private var arthurHealth = 10

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        currentScene = scenes[0]

        //binding.scene = this

        binding.actionButton.setOnClickListener {

            if (binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1
                    binding.actionThree.id -> selectedActionId = 2
                    binding.actionFour.id -> selectedActionId = 3
                }

                when (currentScene) {
                    scenes[0] -> currentScene = scenes[1]
                    scenes[1] -> {
                        when (selectedActionId) { //Sailing Ticket to Hawaii
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[3]
                            2 -> currentScene = scenes[4]
                            3 -> currentScene = scenes[5]
                        }
                    }

                    scenes[2] -> { //shipwreckage
                        when (selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[7]
                        }
                    }

                    scenes[3] -> { //Donors
                        MyApplication.charityEnding = true
                        ending()
                    }

                    scenes[4] -> { //Pesky Ticket
                        MyApplication.peskyEnding = true
                        ending()
                    }

                    scenes[5] -> { //You are lucky
                        MyApplication.luckyEnding = true
                        ending()
                    }

                    scenes[6] -> { //Calm down self
                        when (selectedActionId) {
                            0 -> currentScene = scenes[8]
                        }
                    }

                    scenes[7] -> { //Suicide
                        MyApplication.worstEnding1 = true
                        ending()
                    }

                    scenes[8] -> { //Gathering items
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[9]
                                arthurHealth--
                            }
                            1 -> {
                                currentScene = scenes[10]
                                arthurHealth--
                            }
                        }
                    }

                    scenes[9] -> { //Gathering material
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[12]
                                arthurHealth--
                            }
                        }
                    }

                    scenes[10] -> { //Gathering food
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[11]
                                arthurHealth--
                            }
                        }
                    }

                    scenes[11] -> { //Eat food
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[12]
                                arthurHealth += 3
                            }
                            1 -> currentScene = scenes[13]
                        }
                    }

                    scenes[12] -> { //Continue Gather item
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[14]
                                arthurHealth--
                            }
                            1 -> {
                                currentScene = scenes[15]
                                arthurHealth--
                            }
                        }
                    }

                    scenes[13] -> { //poisoned
                        MyApplication.worstEnding2 = true
                        ending()
                    }

                    scenes[14] -> { //Gather material
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[16]
                                arthurHealth--
                            }
                        }
                    }

                    scenes[15] -> {//Eat food
                        when (selectedActionId) {
                            0 -> {
                                currentScene = scenes[17]
                                arthurHealth += 3
                            }
                            1 -> currentScene = scenes[13]
                        }
                    }

                    scenes[16] -> currentScene = scenes[18] //Build boat

                    scenes[17] -> { //Wait rescue team
                        when (selectedActionId) {
                            0 -> currentScene = scenes[19]
                            1 -> currentScene = scenes[20]
                        }
                    }

                    scenes[18] -> { // Go home
                        MyApplication.bestEnding1 = true
                        ending()
                    }

                    scenes[19] -> { //You are Safe
                        MyApplication.bestEnding2 = true
                        ending()
                    }

                    scenes[20] -> {
                        MyApplication.anotherEnding = true
                        ending()
                    }

                }

                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true
                if (currentScene.actions[2] == "") binding.actionThree.isEnabled = false else binding.actionThree.isEnabled = true
                if (currentScene.actions[3] == "") binding.actionFour.isEnabled = false else binding.actionFour.isEnabled = true

                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else{
                Toast.makeText(this.activity, "Select one optional of the actions to continue!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root

        }
        private fun ending(){
            arthurHealth = 10
            when(selectedActionId){
                0 -> this.activity!!.onBackPressed()
                1 -> currentScene = scenes[0]
            }
        }
}

