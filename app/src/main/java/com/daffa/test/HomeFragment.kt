package com.daffa.test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.test.api.EsportAdapter
import com.daffa.test.api.EsportsResponseItem
import com.daffa.test.api.EsportsViewModel
import com.daffa.test.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    private var _viewModel: EsportsViewModel? = null
    private val viewModel get() = _viewModel as EsportsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        _viewModel = ViewModelProvider(this)[EsportsViewModel::class.java]

        viewModel.getEsportModel()
        viewModel.getListEsport().observe(viewLifecycleOwner) {
            showData(it)
            Log.i("data", it.toString())
        }

        return binding.root
    }

    private fun showData(data: List<EsportsResponseItem>) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = EsportAdapter(data)
        }
    }
}