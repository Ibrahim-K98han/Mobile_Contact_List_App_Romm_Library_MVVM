package com.ibrahim.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ibrahim.contactapp.databinding.FragmentNewContactBinding

class NewContactFragment : Fragment() {

    private lateinit var binding:FragmentNewContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewContactBinding.inflate(inflater,container,false)
        binding.saveBtn.setOnClickListener {
            saveInfo()
        }
        return binding.root
    }

    private fun saveInfo() {
        val name = binding.inputNameET.text.toString()
        val phone = binding.inputPhoneET.text.toString()
        val email = binding.inputEmailET.text.toString()
        val address = binding.inputAddressET.text.toString()

        val contact = ContactDB(
            id = System.currentTimeMillis(),
            contactName = name,
            phone = phone,
            email = email,
            address = address
        )
        contactList.add(contact)
        findNavController().navigate(R.id.action_newContactFragment_to_homeFragment)
    }

}