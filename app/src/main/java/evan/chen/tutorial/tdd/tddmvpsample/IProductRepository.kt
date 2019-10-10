package evan.chen.tutorial.tdd.tddmvpsample

interface IProductRepository {
    fun getProduct(productId: String, callback: LoadProductCallback)

    interface LoadProductCallback {

    }

}
