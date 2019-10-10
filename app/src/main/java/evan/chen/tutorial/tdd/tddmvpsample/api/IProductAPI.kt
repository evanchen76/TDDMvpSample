package evan.chen.tutorial.tdd.tddmvpsample.api

interface IProductAPI {
    fun getProduct(productId: String, loadAPICallback: LoadAPICallback)

    interface LoadAPICallback {

    }

}
