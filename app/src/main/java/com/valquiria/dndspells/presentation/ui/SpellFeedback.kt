package com.valquiria.dndspells.presentation.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.valquiria.dndspells.R
import com.valquiria.dndspells.databinding.ViewFeedbackErrorBinding

enum class SpellFeedback {
    CONNECTION, ERROR, NOT_FOUND
}

internal class SpellCustomFeedbackError(context: Context, attrs: AttributeSet) :
    FrameLayout(context, attrs, 0) {

    private val binding =
        ViewFeedbackErrorBinding.inflate(LayoutInflater.from(context), this, true)

    fun setFeedback(feedback: SpellFeedback) {
        val feedbackValues = when (feedback) {
            SpellFeedback.CONNECTION -> {
                Pair(R.string.error_message_connection, R.drawable.ic_crystal_ball)
            }
            SpellFeedback.ERROR -> {
                Pair(R.string.error_message_generic, R.drawable.ic_crystal_ball)
            }
            SpellFeedback.NOT_FOUND -> {
                Pair(R.string.error_message_no_data, R.drawable.ic_crystal_ball)
            }
        }

        binding.errorTextSubtitleView.text = context.getString(feedbackValues.first)
        binding.errorImageView.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                feedbackValues.second
            )
        )
    }
}