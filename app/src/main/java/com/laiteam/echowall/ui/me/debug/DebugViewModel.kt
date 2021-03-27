package com.laiteam.echowall.ui.me.debug

import androidx.lifecycle.LiveData
import com.laiteam.echowall.base.BaseViewModel
import com.laiteam.echowall.network.response.SeverResponse
import com.laiteam.echowall.network.response.NetworkResponse
import javax.inject.Inject

class DebugViewModel @Inject constructor(repository: DebugRepository) : BaseViewModel() {


    val serverInfo: LiveData<NetworkResponse<SeverResponse>> = repository.loadSeverInfo()
}