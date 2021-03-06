package com.laiteam.echowall.di.user

import com.laiteam.echowall.di.scope.UserScope
import dagger.Subcomponent

@UserScope
@Subcomponent
interface UserComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }

    fun activityComponent(): ActivityComponent.Factory
}