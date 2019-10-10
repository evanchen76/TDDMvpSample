package evan.chen.tutorial.tdd.tddmvpsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import evan.chen.tutorial.tdd.tddmvpsample.api.ProductAPI
import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse
import kotlinx.android.synthetic.main.activity_product.*
import java.text.NumberFormat

class ProductActivity : AppCompatActivity(), ProductContract.IProductView{
    private val productId = "pixel3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productRepository = ProductRepository(ProductAPI())
        val productPresenter = ProductPresenter(productRepository, this)

        productPresenter.getProduct(productId)
    }

    override fun onGetResult(productResponse: ProductResponse) {
        productName.text = productResponse.name
        productDesc.text = productResponse.desc

        val currencyFormat = NumberFormat.getCurrencyInstance()
        currencyFormat.maximumFractionDigits = 0
        val price = currencyFormat.format(productResponse.price)
        productPrice.text = price
    }

}
