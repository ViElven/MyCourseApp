package com.example.mycourseapp.screens.root

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.mycourseapp.R
import com.example.mycourseapp.VpAdapter
import com.example.mycourseapp.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_root.*
import kotlinx.android.synthetic.main.fragment_root.view.*

class RootFragment : Fragment() {

    private var ctx: Context ?= null
    lateinit var binding: FragmentRootBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val view = inflater.inflate(R.layout.fragment_root, container, false)
        binding = FragmentRootBinding.inflate(layoutInflater, container, false)
        binding.tabLayout.tabIconTint = null
        binding.viewPager.adapter = VpAdapter(ctx as FragmentActivity)

        if (checkForInternet(requireContext())){
            TabLayoutMediator(binding.tabLayout, binding.viewPager){
                    tab, position ->
                when(position){
                    0 -> {tab.setIcon(R.drawable.ic_baseline_money_off_24)}
                    1 -> {tab.setIcon(R.drawable.ic_baseline_attach_money_24)}
                }
            }.attach()
        } else {
            findNavController().navigate(R.id.action_rootFragment_to_noInternetFragment)
        }
        return binding.root
    }

    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

}