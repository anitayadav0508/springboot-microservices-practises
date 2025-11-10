package com.springmvc.form.implementation.using.taglibrary.with.savedToDB.respositories;

import com.springmvc.form.implementation.using.taglibrary.with.savedToDB.entity.Timings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimingRepository extends JpaRepository<Timings,Integer> {
}
