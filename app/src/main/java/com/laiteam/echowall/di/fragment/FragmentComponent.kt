package com.laiteam.echowall.di.fragment

import dagger.Subcomponent

@Subcomponent
interface FragmentComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentComponent
    }
}