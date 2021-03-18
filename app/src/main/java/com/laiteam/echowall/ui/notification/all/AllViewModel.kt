package com.laiteam.echowall.ui.notification.all

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseViewModel
import com.laiteam.echowall.network.model.SeverInfo
import com.laiteam.echowall.network.response.NetworkResponse
import javax.inject.Inject

class AllViewModel @Inject constructor(repository: AllRepository) : BaseViewModel() {


    val serverInfo: LiveData<NetworkResponse<SeverInfo>> = repository.loadSeverInfo()
}