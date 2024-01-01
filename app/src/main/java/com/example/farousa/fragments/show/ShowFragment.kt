package com.example.farousa.fragments.show

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.farousa.databinding.FragmentShowBinding
import com.example.farousa.listOfDecore
import com.example.farousa.listOfTables
import com.example.farousa.listofChair
import com.example.farousa.listofElectric


class ShowFragment : Fragment() {
    private lateinit var binding:FragmentShowBinding
    private val adapterElectronic: CutomerAdapter by lazy {
        CutomerAdapter(listofElectric, onItemClicked = {
            Toast.makeText(requireContext(),"clicked\n ${it.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(ShowFragmentDirections.actionShowFragmentToDetailFragment(it))
        })
    }
    private val adapterDecore: CutomerAdapter by lazy {
        CutomerAdapter(listOfDecore, onItemClicked = {
            Toast.makeText(requireContext(),"clicked\n ${it.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(ShowFragmentDirections.actionShowFragmentToDetailFragment(it))
        })
    }
    private val adapterChair: CutomerAdapter by lazy {
        CutomerAdapter(listofChair, onItemClicked = {
            Toast.makeText(requireContext(),"clicked\n ${it.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(ShowFragmentDirections.actionShowFragmentToDetailFragment(it))
        })
    }
    private val adapterTables: CutomerAdapter by lazy {
        CutomerAdapter(listOfTables, onItemClicked = {
            Toast.makeText(requireContext(),"clicked\n ${it.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(ShowFragmentDirections.actionShowFragmentToDetailFragment(it))
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding=FragmentShowBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inElectronic
        binding.inElectronic.textCategory.text="Electronic"
        binding.inDecoration.textCategory.text="Decoration"
        binding.inTable.textCategory.text="Tables"
        binding.inChair.textCategory.text="Chairs"

        binding.inElectronic.recyclerviewCategories.adapter=adapterElectronic
        binding.inDecoration.recyclerviewCategories.adapter=adapterDecore
        binding.inTable.recyclerviewCategories.adapter=adapterTables
        binding.inChair.recyclerviewCategories.adapter=adapterChair

    }

}