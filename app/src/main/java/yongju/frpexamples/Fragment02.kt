package yongju.frpexamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_01.*
import yongju.frpexamples.R.layout.fragment_02
import yongju.frpexamples.base.BaseFragment

/**
 * Created by yongju on 2017. 10. 23..
 */
class Fragment02: BaseFragment() {
    override val layoutId: Int = fragment_02

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        RxTextView.textChanges(editText)
            .map { it.reversed() }
            .subscribe(
                textView2::setText,
                Throwable::printStackTrace
            ).apply {
                disposables.add(this)
            }

//        val textChanges = RxTextView.textChanges(editText)
//        val textChagesMap = textChanges.map { StringBuilder(it).reverse().toString() }
//        textChagesMap.subscribe(
//            textView2::setText,
//            Throwable::printStackTrace
//        ).apply {
//            disposables.add(this)
//        }

//        RxTextView.textChanges(editText)
//            .subscribe(
//                {
//                    textView2.text = it.reversed()
//                },
//                Throwable::printStackTrace
//            ).apply {
//                disposables.add(this)
//            }
    }

    override fun onResume() {
        Log.d(TAG,"[onResume]")
        (activity as AppCompatActivity).supportActionBar?.title = TAG
        super.onResume()
    }

    companion object {
        val TAG = "Reverse"
    }
}