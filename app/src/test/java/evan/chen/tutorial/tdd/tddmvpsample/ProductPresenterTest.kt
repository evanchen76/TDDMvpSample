package evan.chen.tutorial.tdd.tddmvpsample

import evan.chen.tutorial.tdd.tddmvpsample.api.ProductResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ProductPresenterTest {

    private lateinit var presenter: ProductContract.IProductPresenter

    @Mock
    private lateinit var repository: IProductRepository

    @Mock
    private lateinit var view: ProductContract.IProductView

    private var productResponse = ProductResponse()


    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)
        presenter = ProductPresenter(repository, view)

        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"
    }

    @Test
    fun getProductTest() {
        val productId = "pixel3"
        presenter.getProduct(productId)

        val loadProductCallbackCaptor = argumentCaptor<IProductRepository.LoadProductCallback>()
        verify(repository).getProduct(eq(productId), capture(loadProductCallbackCaptor))

        loadProductCallbackCaptor.value.onProductResult(productResponse)

        verify(view).onGetResult(productResponse)

    }
}