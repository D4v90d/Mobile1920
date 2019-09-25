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
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentEndingListBinding


class EndingListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEndingListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ending_list, container, false)

        binding.charityEndingButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[3]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.peskyEndingButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[4]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.luckyEndingButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[5]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.worstEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[7]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.worstEndingTwoButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[13]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.bestEndingOneButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[18]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.bestEndingTwoButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[19]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        binding.anotherEndingButton.setOnClickListener {
            MyApplication.currentDisplayEnding = MyApplication.scenes[20]
            it.findNavController().navigate(R.id.actions_endingFragment_to_endingListFragment)
        }

        if (MyApplication.charityEnding)binding.charityEndingButton.isEnabled = true
        if (MyApplication.peskyEnding)binding.peskyEndingButton.isEnabled = true
        if (MyApplication.luckyEnding)binding.luckyEndingButton.isEnabled = true
        if (MyApplication.worstEnding1)binding.worstEndingOneButton.isEnabled = true
        if (MyApplication.worstEnding2)binding.worstEndingTwoButton.isEnabled = true
        if (MyApplication.bestEnding1)binding.bestEndingOneButton.isEnabled = true
        if (MyApplication.bestEnding2)binding.bestEndingTwoButton.isEnabled = true
        if (MyApplication.anotherEnding)binding.anotherEndingButton.isEnabled = true

        return binding.root
    }
}
