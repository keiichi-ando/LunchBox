package com.ex.lunchbox.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex.lunchbox.R
import com.ex.lunchbox.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var fragmentBinding: FragmentHomeBinding
    private lateinit var workListAdapter: WorkListAdapter
    private lateinit var listview: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false).also{
            it.lifecycleOwner = viewLifecycleOwner
        }
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listview = list_view
        homeViewModel.initList()

        val textView: TextView = text_home
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        setupAdapter()
        homeViewModel.getWorkList().observe(viewLifecycleOwner, Observer { workList ->
            workListAdapter.setWorks(workList)
        })

        homeViewModel.loadList()
    }

    private fun setupAdapter(){
        workListAdapter = WorkListAdapter(viewLifecycleOwner)
        val layoutManager = LinearLayoutManager(activity)
        listview.layoutManager = layoutManager
        listview.adapter = workListAdapter

    }
}