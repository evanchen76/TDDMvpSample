package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse

class ProductPresenter(
    val repository: IProductRepository,
    val view: ProductContract.IProductView
) : ProductContract.IProductPresenter
{
    override fun getProduct(productId: String) {
        repository.getProduct(productId, object : IProductRepository.LoadProductCallback{
            override fun onProductResult(productResponse: ProductResponse) {
                view.onGetResult(productResponse)
            }

        })
    }
}
