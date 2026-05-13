package com.zacharyhub.blogsystem.repository;

import com.zacharyhub.blogsystem.entity.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggerRepository extends JpaRepository<Blogger, Long> {
}