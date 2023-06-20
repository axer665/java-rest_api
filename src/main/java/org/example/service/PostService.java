package org.example.service;

import org.springframework.stereotype.Service;
import org.example.exception.NotFoundException;
import org.example.model.Post;
import org.example.repository.IPostRepository;

import java.util.List;

@Service
public class PostService {
  // сервис завязан на интерфейс, а не на конкретную реализацию
  private final IPostRepository repository;

  public PostService(IPostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return repository.all();
  }

  public Post getById(long id) {
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}

