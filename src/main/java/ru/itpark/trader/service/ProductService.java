package ru.itpark.trader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import ru.itpark.trader.DTO.ProductDTO;
import ru.itpark.trader.entity.ProductEntity;
import ru.itpark.trader.exception.FileRemoveException;
import ru.itpark.trader.exception.MediaUploadException;
import ru.itpark.trader.exception.ProductNotFoundException;
import ru.itpark.trader.exception.UnsupportedMediaTypeException;
import ru.itpark.trader.repository.ProductRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final Path pathFiles;

    public ProductService(ProductRepository productRepository,
                          @Value("C:/Users/PressAnyKey/IdeaProjects/trader/files/img") String pathFiles) {
        this.productRepository = productRepository;
        this.pathFiles = Paths.get(pathFiles);
    }

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    }

    public void add(ProductDTO productDTO) {
        var contentType = productDTO.getImage().getContentType();
        String name = UUID.randomUUID().toString();
        String extension;

        if (MediaType.IMAGE_JPEG_VALUE.equals(contentType)) {
            extension = ".jpg";
        } else if (MediaType.IMAGE_PNG_VALUE.equals(contentType)) {
            extension = ".png";
        } else {
            throw new UnsupportedMediaTypeException(contentType);
        }

        Path target = pathFiles.resolve(name + extension);

        try {
            productDTO.getImage().transferTo(target.toFile());
        } catch (IOException e) {
            throw new MediaUploadException(e);
        }

        var product = new ProductEntity(0, productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), 0, name + extension);
        productRepository.saveAndFlush(product);
    }

    public void deleteById(int id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        Path target = pathFiles.resolve(productEntity.getPathFiles());
        try {
            Files.deleteIfExists(target);
        } catch (IOException e) {
            throw new FileRemoveException(e);
        }

        productRepository.delete(productEntity);
    }

    public List<ProductEntity> findByName(String name) {
        return productRepository.findAllByNameStartsWithIgnoreCase(name);
    }
}
