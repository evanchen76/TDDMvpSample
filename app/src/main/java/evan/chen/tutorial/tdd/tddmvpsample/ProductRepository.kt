package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.IProductAPI

class ProductRepository(val productAPI: IProductAPI) : IProductRepository {
    override fun getProduct(productId: String, callback: IProductRepository.LoadProductCallback) {
        productAPI.getProduct(productId, object : IProductAPI.LoadAPICallback{

        })
    }

}
