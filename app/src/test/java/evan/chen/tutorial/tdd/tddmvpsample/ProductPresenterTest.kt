package evan.chen.tutorial.tdd.tddmvpsample

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ProductPresenterTest {

    private lateinit var presenter: ProductContract.IProductPresenter

    @Mock
    private lateinit var repository: IProductRepository

    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)
        presenter = ProductPresenter(repository)

    }

    @Test
    fun getProductTest() {
        val productId = "pixel3"
        presenter.getProduct(productId)

        val loadProductCallbackCaptor = argumentCaptor<IProductRepository.LoadProductCallback>()
        verify(repository).getProduct(eq(productId), capture(loadProductCallbackCaptor))

    }
}