package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse

interface IProductRepository {
    fun getProduct(productId: String, callback: LoadProductCallback)

    interface LoadProductCallback {
        fun onProductResult(productResponse: ProductResponse)

    }

}
