package com.laiteam.echowall.ui.feed

import com.laiteam.echowall.base.BaseViewModel
import javax.inject.Inject

class FeedViewModel @Inject constructor(private val feedRepository: FeedRepository) : BaseViewModel(feedRepository) {

}