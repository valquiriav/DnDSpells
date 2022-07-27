package com.valquiria.dndspells.presentation.ui.spellListScreen

import io.mockk.MockKAnnotations
import org.junit.Before

abstract class BaseUnitTest {

    @Before
    open fun setup() {
        MockKAnnotations.init(this)
    }
}