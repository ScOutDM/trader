package ru.itpark.trader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.trader.entity.ProductEntity;
import ru.itpark.trader.entity.UserEntity;
import ru.itpark.trader.repository.ProductRepository;
import ru.itpark.trader.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class TraderApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(TraderApplication.class, args);

        context.getBean(ProductRepository.class)
                .saveAll(List.of(
                        new ProductEntity(
                                0,
                                "First Product Name",
                                "First Product Description",
                                1000,
                                1,
                                "1.png"
                        ),
                        new ProductEntity(
                                0,
                                "Second Product Name",
                                "Second Product Description",
                                2000,
                                1,
                                "2.png"
                        ),
                        new ProductEntity(
                                0,
                                "Third Product Name",
                                "Third Product Description",
                                10,
                                2,
                                "3.png"
                        ),
                        new ProductEntity(
                                0,
                                "Fourth Product Name",
                                "Fourth Product Description",
                                10,
                                2,
                                "4.png"
                        ),
                        new ProductEntity(
                                0,
                                "Fifth Product Name",
                                "Fifth Product Description",
                                10,
                                2,
                                "5.png"
                        ),
                        new ProductEntity(
                                0,
                                "Sixth Product Name",
                                "Sexth Product Description",
                                10,
                                2,
                                "6.png"
                        ),
                        new ProductEntity(
                                0,
                                "Seventh Product Name",
                                "Seventh Product Description",
                                10,
                                2,
                                "7.png"
                        )
                ));

        var encoder = context.getBean(PasswordEncoder.class);
        context.getBean(UserRepository.class)
                .saveAll(List.of(
                        new UserEntity(
                                0,
                                "vasya",
                                encoder.encode("vasya"),
                                List.of(new SimpleGrantedAuthority("USER")),
                                true,
                                true,
                                true,
                                true
                        ),
                        new UserEntity(
                                0,
                                "petya",
                                encoder.encode("petya"),
                                List.of(new SimpleGrantedAuthority("ADMIN")),
                                true,
                                true,
                                true,
                                true
                        )
                ));
    }
}
