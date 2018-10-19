package com.example.vipul.testingbasic

import android.os.Bundle
import android.widget.TextView
import android.support.v7.app.AppCompatActivity
import android.view.View


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mCoffeePrice: TextView? = null
    private var mTotalPrice: TextView? = null
    private var mCoffeeCount: TextView? = null
    private var mOrder: CoffeeOrder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCoffeePrice = findViewById<TextView>(R.id.coffee_price)
        mTotalPrice = findViewById<TextView>(R.id.total_price)
        mCoffeeCount = findViewById<TextView>(R.id.coffee_count)
        mCoffeePrice!!.text = String.format(getString(R.string.coffee_price), DEFAULT_COFFEE_PRICE)
        mTotalPrice!!.text = String.format(getString(R.string.total_price), 0.0f)
        findViewById<View>(R.id.coffee_increment).setOnClickListener(this)
        findViewById<View>(R.id.coffee_decrement).setOnClickListener(this)
        mOrder = CoffeeOrder(DEFAULT_COFFEE_PRICE)
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.coffee_increment -> {
                mOrder!!.incrementCoffeeCount()
                updateCoffeeCount()
                updateTotalPrice()
            }
            R.id.coffee_decrement -> {
                mOrder!!.decrementCoffeeCount()
                updateCoffeeCount()
                updateTotalPrice()
            }
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COFFEE_COUNT, mOrder!!.getCoffeeCount())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            mOrder!!.setCoffeeCount(savedInstanceState.getInt(COFFEE_COUNT))
            updateCoffeeCount()
            updateTotalPrice()
        }
    }

    private fun updateCoffeeCount() {
        mCoffeeCount!!.setText(mOrder!!.getCoffeeCount())
    }

    private fun updateTotalPrice() {
        mTotalPrice!!.text = String.format(getString(R.string.total_price), mOrder!!.getTotalPrice())
    }

    companion object {
        private val COFFEE_COUNT = "coffee_count"
        val DEFAULT_COFFEE_PRICE = 5.0f
    }
}
