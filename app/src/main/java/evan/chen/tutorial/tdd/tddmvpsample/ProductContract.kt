package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse

interface ProductContract {
    interface IProductPresenter {
        fun getProduct(productId: String)

    }

    interface IProductView {
        fun onGetResult(productResponse: ProductResponse)

    }

}
