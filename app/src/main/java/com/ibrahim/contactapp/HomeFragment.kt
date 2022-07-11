package com.ibrahim.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.contactapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val adapter = ContactAdapter{
            val bundle = Bundle().apply {
                putString("phone_value",it.phone)
                putString("email_value",it.email)
                putString("address_value",it.address)
            }
            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,bundle)
        }
        binding.contactRV.layoutManager = LinearLayoutManager(activity)
        binding.contactRV.adapter = adapter
        adapter.submitList(contactList)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newContactFragment)
        }
        return binding.root
    }

}