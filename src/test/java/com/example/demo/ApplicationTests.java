package com.example.demo;

import com.example.demo.domain.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ApplicationTests {

	@Test
	public void clientServiceFilterTest(){

		ClientService localMockService = Mockito.mock(ClientService.class);
		when(localMockService.getOlderThan(LocalDate.of(1995,1,1))).thenReturn(Stream.of(
				new Client(
						"Emily Davis",
						"emily.davis@email.com",
						LocalDate.of(1990, 2, 25),
						"456 Elm Street, New York City USA",
						"female"
				),
				new Client(
						"Jacob Nguyen",
						"jacob.nguyen@email.com",
						LocalDate.of(1988, 6, 3),
						"789 Oak Street, Columbus USA",
						"male"
				),
				new Client(
						"Liam Gonzalez",
						"liam.gonzalez@email.com",
						LocalDate.of(1993, 4, 30),
						"654 Cedar Street, Austin USA",
						"male"
				),
				new Client(
						"Daniel Lopez",
						"daniel.lopez@email.com",
						LocalDate.of(1992, 9, 22),
						"246 Birch Street, New York City USA",
						"male"
				),
				new Client(
						"Lucas Ng",
						"lucas.ng@email.com",
						LocalDate.of(1985, 12, 28),
						"864 Cherry Street, San Jose USA",
						"male"
				),
				new Client(
						"Sophia Lee",
						"sophia.lee@email.com",
						LocalDate.of(1991, 7, 14),
						"975 Ash Street, San Diego USA",
						"female"
				)).toList());

		Assert.assertEquals(6L, localMockService.getOlderThan(LocalDate.of(1995,1,1)).size());

	}

	@Test
	public void c(){

		ClientService localMockService = Mockito.mock(ClientService.class);
		when(localMockService.getOlderThan(LocalDate.of(1995,1,1))).thenReturn(Stream.of(
				new Client(
						"Emily Davis",
						"emily.davis@email.com",
						LocalDate.of(1990, 2, 25),
						"456 Elm Street, New York City USA",
						"female"
				),
				new Client(
						"Jacob Nguyen",
						"jacob.nguyen@email.com",
						LocalDate.of(1988, 6, 3),
						"789 Oak Street, Columbus USA",
						"male"
				),
				new Client(
						"Liam Gonzalez",
						"liam.gonzalez@email.com",
						LocalDate.of(1993, 4, 30),
						"654 Cedar Street, Austin USA",
						"male"
				),
				new Client(
						"Daniel Lopez",
						"daniel.lopez@email.com",
						LocalDate.of(1992, 9, 22),
						"246 Birch Street, New York City USA",
						"male"
				),
				new Client(
						"Lucas Ng",
						"lucas.ng@email.com",
						LocalDate.of(1985, 12, 28),
						"864 Cherry Street, San Jose USA",
						"male"
				),
				new Client(
						"Sophia Lee",
						"sophia.lee@email.com",
						LocalDate.of(1991, 7, 14),
						"975 Ash Street, San Diego USA",
						"female"
				)).toList());

		Assert.assertEquals(6L, localMockService.getOlderThan(LocalDate.of(1995,1,1)).size());

	}
}
