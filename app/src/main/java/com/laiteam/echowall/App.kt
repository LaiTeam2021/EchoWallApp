package com.laiteam.echowall

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.flipper.plugins.sections.SectionsFlipperPlugin
import com.facebook.flipper.plugins.sharedpreferences.SharedPreferencesFlipperPlugin
import com.facebook.litho.editor.flipper.LithoFlipperDescriptors
import com.facebook.soloader.SoLoader
import com.laiteam.echowall.di.application.AppComponent
import com.laiteam.echowall.di.application.AppModule
import com.laiteam.echowall.di.application.DaggerAppComponent

class App : Application() {

    companion object {
        const val SHARED_PREFERENCE = "app_preference"
    }

    lateinit var appComponent: AppComponent
    lateinit var networkFlipperPlugin: NetworkFlipperPlugin

    override fun onCreate() {
        appComponent = DaggerAppComponent.factory().create(AppModule(this))
        super.onCreate()
        SoLoader.init(this, false)
        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            networkFlipperPlugin = NetworkFlipperPlugin()
            val descriptorMapping = DescriptorMapping.withDefaults()
            LithoFlipperDescriptors.add(descriptorMapping)
            client.addPlugin(SectionsFlipperPlugin(true));
            client.addPlugin(InspectorFlipperPlugin(this, descriptorMapping))
            client.addPlugin(
                SharedPreferencesFlipperPlugin(this, SHARED_PREFERENCE)
            )
            client.addPlugin(networkFlipperPlugin)
            client.start()
        }
    }

}