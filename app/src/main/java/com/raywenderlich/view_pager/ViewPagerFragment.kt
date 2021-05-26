package com.raywenderlich.view_pager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.raywenderlich.view_pager.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {



    private lateinit var binding: FragmentViewPagerBinding

    private lateinit var adapter: CustomPagerAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = context?.let { CustomPagerAdapter(it, object:ItemListener{

            override fun imageListener(position: Int) {
                setFragmentResult("requestKey", bundleOf("img" to position))
                findNavController().navigate(R.id.action_viewPagerFragment_to_imageFragment)

            }
        }) }!!

        binding.viewpager.adapter = adapter

    }




}