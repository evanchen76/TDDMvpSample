package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.IProductAPI
import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ProductRepositoryTest {

    lateinit var repository: IProductRepository

    @Mock
    private lateinit var repositoryCallback: IProductRepository.LoadProductCallback

    @Mock
    private lateinit var productAPI: IProductAPI

    private var productResponse = ProductResponse()

    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)
        repository = ProductRepository(productAPI)

        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"
    }

    @Test
    fun getProductTest() {
        repository.getProduct("pixel3", repositoryCallback)

        val argumentCaptor = argumentCaptor<IProductAPI.LoadAPICallback>()

        verify(productAPI).getProduct(eq("pixel3"), capture(argumentCaptor))

        //指定ProductAPI回傳值
        argumentCaptor.value.onGetResult(productResponse)
        //驗證是否有呼叫View
        verify(repositoryCallback).onProductResult(productResponse)
    }
}