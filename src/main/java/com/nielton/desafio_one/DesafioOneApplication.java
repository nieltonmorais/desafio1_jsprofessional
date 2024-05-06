package com.nielton.desafio_one;

import com.nielton.desafio_one.entities.Order;
import com.nielton.desafio_one.services.OrderService;
import com.nielton.desafio_one.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioOneApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DesafioOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);


		System.out.print("Código: ");
		Integer code = sc.nextInt();
		System.out.print("Pedido: ");
		double pedido = sc.nextDouble();
		System.out.print("Percentual Desconto: ");
		double discount = sc.nextDouble();

		Order order = new Order(code, pedido, discount);

		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService();

		double totalValue = orderService.total(order) + shippingService.shipment(order);

		System.out.println();
		System.out.println("Pedido código "+ code);
		System.out.printf("Valor total: R$ %.2f%n", totalValue);
		sc.close();
	}
}
