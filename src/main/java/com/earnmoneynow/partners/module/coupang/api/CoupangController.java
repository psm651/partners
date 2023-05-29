package com.earnmoneynow.partners.module.coupang.api;

import com.earnmoneynow.partners.module.coupang.dto.ProductRequestDto;
import com.earnmoneynow.partners.module.coupang.dto.ProductsResponseDto;
import com.earnmoneynow.partners.module.coupang.dto.SearchedProductResponseDto;
import com.earnmoneynow.partners.module.coupang.service.CoupangSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupang/products")
public class CoupangController {
    private final CoupangSearchService coupangSearchService;

    @GetMapping("goldbox")
    public ResponseEntity<ProductsResponseDto> getGoldBox(@ModelAttribute ProductRequestDto productRequestDto) {
        ProductsResponseDto products = coupangSearchService.getGoldBoxProducts(productRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("bestcategories/{categoryId}")
    public ResponseEntity<ProductsResponseDto> getBestCategories(@PathVariable String categoryId, @ModelAttribute ProductRequestDto productRequestDto) {
        ProductsResponseDto products = coupangSearchService.getBestProducts(categoryId, productRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("search")
    public ResponseEntity<SearchedProductResponseDto> getSearchedProduct(@ModelAttribute ProductRequestDto productRequestDto) {
        SearchedProductResponseDto products = coupangSearchService.getSearchedProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
