package com.delivery.deliveryfinal.Request;

import com.delivery.deliveryfinal.Clases.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@AllArgsConstructor

@NoArgsConstructor
public class OrderRequest {
    private String nombreClient;
    private String emailClient;
    private List<Food> items;

}
