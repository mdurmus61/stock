package services.stock.repository.layer;

import org.springframework.context.ApplicationContext;
import services.stock.repository.ImageRepository;

public final class StockRepositoryLayer {

    private static ApplicationContext context;


    public static <T> T find(Class<T> repositoryClass) {
        return context.getBean(repositoryClass);
    }

    /**
     * Injected from the class "ApplicationContextProvider" which is automatically loaded during Spring-Initialization.
     *
     * @param applicationContext the new application context
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        StockRepositoryLayer.context = applicationContext;
    }
    /**
     * Instantiates a new app context.
     */
    private StockRepositoryLayer() {
        // Avoid instantiation of the class
    }

    public static ImageRepository imageRepository() {
        return find(ImageRepository.class);
    }

}
