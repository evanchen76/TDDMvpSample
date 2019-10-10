package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.IProductAPI
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

    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)
        repository = ProductRepository(productAPI)
    }

    @Test
    fun getProductTest() {
        repository.getProduct("pixel3", repositoryCallback)

        val argumentCaptor = argumentCaptor<IProductAPI.LoadAPICallback>()

        verify(productAPI).getProduct(eq("pixel3"), capture(argumentCaptor))
    }
}