package dev.company.newsandupdates;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.company.newsandupdates.entity.NewsAndUpdates;
import dev.company.newsandupdates.repository.NewsAndUpdatesRepository;

@SpringBootTest
class NewsAndUpdatesAppApplicationTests {
	@Autowired
	private NewsAndUpdatesRepository newsAndUpdatesRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	@Rollback(true)
	public void createNewsAndUpdatesTest() {
		// fail();
		NewsAndUpdates newsAndUpdates = new NewsAndUpdates();
		newsAndUpdates.setTitle("the chronicles of c++");
		newsAndUpdates.setContent(
				"Donec rutrum congue leo eget malesuada. Nulla quis lorem ut libero malesuada feugiat. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.");
		newsAndUpdatesRepository.save(newsAndUpdates);
	}

	@Test
	public void readNewsAndUpdatesTest() {
		// fail();
		newsAndUpdatesRepository.findById(1);

	}

	@Test
	public void readAllNewsAndUpdatesTest() {
		// fail();
		newsAndUpdatesRepository.findAll();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void updateNewsAndUpdatesTest() {
		// fail();
		Optional<NewsAndUpdates> nu = newsAndUpdatesRepository.findById(1);
		NewsAndUpdates newsAndUpdates = nu.get();
		newsAndUpdates.setTitle("Test Title");
		newsAndUpdatesRepository.save(newsAndUpdates);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteNewsAndUpdatesTest() {
		// fail();
		newsAndUpdatesRepository.deleteById(1);

	}
}
