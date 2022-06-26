package com.promedia.fragmentComunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.promedia.fragmentComunication.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    private var _b:FragmentFirstBinding? = null
    private val b get() = _b!!

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var myView : View
    private val dados = arrayOf<Int>(
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)
    private var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentFirstBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_first, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.ivDado1.setOnClickListener { clickOnDado() }
        b.ivDado2.setOnClickListener { clickOnDado() }
        b.tvContador.setOnClickListener {
            setFragmentResult("requestKey",
                bundleOf("bundleKey" to b.tvContador.text))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }

    fun clickOnDado(){
        val d1 = (1..6).random()
        val d2 = (1..6).random()
        cont = d1 + d2
        b.ivDado1.setImageResource(dados[d1-1])
        b.ivDado2.setImageResource(dados[d2-1])
        b.tvContador.text = cont.toString()
        //setFragmentResult("requestKey", bundleOf("bundleKey" to cont.toString()))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}