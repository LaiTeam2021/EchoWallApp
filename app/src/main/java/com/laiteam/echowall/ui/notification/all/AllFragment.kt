package com.laiteam.echowall.ui.notification.all

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.laiteam.echowall.base.DaggerBaseLithoFragment
import com.laiteam.echowall.di.fragment.FragmentComponent
import com.laiteam.echowall.network.response.Status
import javax.inject.Inject

class AllFragment : DaggerBaseLithoFragment<Any?>() {
    companion object {
//        private const val MY_TAB_NAME = "tab_name"

        fun newInstance() = AllFragment().apply {
//            arguments = bundleOf(
//                MY_TAB_NAME to tabName,
//            )
        }
    }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel: AllViewModel by viewModels {
        viewModelFactory
    }

    override fun setupInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun initData() {
        viewModel.serverInfo.observe(this) {
            when (it.status) {
                Status.SUCCESS -> it.data?.let { _ ->
                    setComponentAsync(
                        RecyclerCollectionComponent.create(c)
                            .disablePTR(true)
                            .section(AllSection.create(SectionContext(c)).build()).build()
                    )

//                        AllItem.create(c).build())
                }
                Status.ERROR -> Toast.makeText(context, it.message!!, Toast.LENGTH_SHORT).show()
                else -> {
                }
            }
        }
    }
}