package project.spotEEfy.core.dao;
/*
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import project.spotEEfy.core.entity.Playlist;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PlaylistDAO implements JpaRepository<Playlist, Long> {
    @Override
    public List<Playlist> findAll() {
        return null;
    }

    @Override
    public List<Playlist> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Playlist> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Playlist> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Playlist entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Playlist> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Playlist> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Playlist> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Playlist> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Playlist> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Playlist> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Playlist getOne(Long aLong) {
        return null;
    }

    @Override
    public Playlist getById(Long aLong) {
        return null;
    }

    @Override
    public Playlist getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Playlist> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Playlist> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Playlist> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Playlist> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Playlist> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Playlist> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Playlist, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Playlist> S saveAndFlush(S entity) {
        return null;
    }
}
